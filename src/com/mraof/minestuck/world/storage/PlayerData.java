package com.mraof.minestuck.world.storage;

import com.mraof.minestuck.MinestuckConfig;
import com.mraof.minestuck.editmode.EditData;
import com.mraof.minestuck.editmode.ServerEditHandler;
import com.mraof.minestuck.inventory.captchalogue.CaptchaDeckHandler;
import com.mraof.minestuck.inventory.captchalogue.Modus;
import com.mraof.minestuck.item.crafting.alchemy.GristSet;
import com.mraof.minestuck.item.crafting.alchemy.GristTypes;
import com.mraof.minestuck.item.crafting.alchemy.ImmutableGristSet;
import com.mraof.minestuck.item.crafting.alchemy.NonNegativeGristSet;
import com.mraof.minestuck.network.CaptchaDeckPacket;
import com.mraof.minestuck.network.GristCachePacket;
import com.mraof.minestuck.network.MSPacketHandler;
import com.mraof.minestuck.network.PlayerDataPacket;
import com.mraof.minestuck.network.skaianet.SburbConnection;
import com.mraof.minestuck.network.skaianet.SburbHandler;
import com.mraof.minestuck.network.skaianet.SkaianetHandler;
import com.mraof.minestuck.util.ColorCollector;
import com.mraof.minestuck.util.Echeladder;
import com.mraof.minestuck.util.IdentifierHandler;
import com.mraof.minestuck.util.Title;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public final class PlayerData
{
	private static final Logger LOGGER = LogManager.getLogger();
	
	final IdentifierHandler.PlayerIdentifier identifier;
	
	private final PlayerSavedData savedData;
	private final Echeladder echeladder;
	private int color = ColorCollector.DEFAULT_COLOR;
	
	private boolean givenModus;
	private Modus modus;
	private long boondollars;
	private ImmutableGristSet gristCache;	//This is immutable in order to control where it can be changed
	
	private Title title;
	private boolean effectToggle;
	
	private boolean hasLoggedIn;
	
	PlayerData(PlayerSavedData savedData, IdentifierHandler.PlayerIdentifier player)
	{
		this.savedData = savedData;
		this.identifier = player;
		echeladder = new Echeladder(savedData, player);
		gristCache = new ImmutableGristSet(GristTypes.BUILD, 20);
		hasLoggedIn = false;
	}
	
	PlayerData(PlayerSavedData savedData, CompoundNBT nbt)
	{
		this.savedData = savedData;
		this.identifier = IdentifierHandler.load(nbt, "player");
		
		echeladder = new Echeladder(savedData, identifier);
		echeladder.loadEcheladder(nbt);
		if (nbt.contains("color"))
			this.color = nbt.getInt("color");
		
		if (nbt.contains("modus"))
		{
			this.modus = CaptchaDeckHandler.readFromNBT(nbt.getCompound("modus"), savedData);
			givenModus = true;
		}
		else givenModus = nbt.getBoolean("given_modus");
		boondollars = nbt.getLong("boondollars");
		gristCache = NonNegativeGristSet.read(nbt.getList("grist_cache", Constants.NBT.TAG_COMPOUND)).asImmutable();
		
		title = Title.tryRead(nbt, "title");
		effectToggle = nbt.getBoolean("effect_toggle");
		
		hasLoggedIn = true;
	}
	
	CompoundNBT writeToNBT()
	{
		CompoundNBT nbt = new CompoundNBT();
		identifier.saveToNBT(nbt, "player");
		echeladder.saveEcheladder(nbt);
		nbt.putInt("color", color);
		
		if (this.modus != null)
			nbt.put("modus", CaptchaDeckHandler.writeToNBT(modus));
		else nbt.putBoolean("given_modus", givenModus);
		nbt.putLong("boondollars", boondollars);
		nbt.put("grist_cache", gristCache.write(new ListNBT()));
		
		if(title != null)
			title.write(nbt, "title");
		nbt.putBoolean("effect_toggle", effectToggle);
		
		return nbt;
	}
	
	private void markDirty()
	{
		savedData.markDirty();
	}
	
	public Echeladder getEcheladder()
	{
		return echeladder;
	}
	
	public int getColor()
	{
		return color;
	}
	
	public void trySetColor(int color)
	{
		if(SburbHandler.canSelectColor(identifier, savedData.mcServer) && this.color != color)
		{
			this.color = color;
			markDirty();
			
			sendColor(getPlayer(), false);
		}
	}
	
	public Modus getModus()
	{
		return modus;
	}
	
	public void setModus(Modus modus)
	{
		if(this.modus != modus)
		{
			this.modus = modus;
			if(modus != null)
				setGivenModus();
			markDirty();
		}
	}
	
	public boolean hasGivenModus()
	{
		return givenModus;
	}
	
	private void setGivenModus()
	{
		givenModus = true;
		markDirty();
	}
	
	public long getBoondollars()
	{
		return boondollars;
	}
	
	public void addBoondollars(long amount)
	{
		if(amount < 0)
			throw new IllegalArgumentException("Boondollar amount may not be negative.");
		else if(amount > 0)
		{
			boondollars += amount;
			markDirty();
			sendBoondollars(getPlayer());
		}
	}
	
	public void takeBoondollars(long amount)
	{
		if(amount < 0)
			throw new IllegalArgumentException("Boondollar amount may not be negative.");
		else if(amount > 0)
		{
			if(boondollars - amount < 0)
				throw new IllegalStateException("Can't go to negative boondollars");
			
			boondollars -= amount;
			markDirty();
			sendBoondollars(getPlayer());
		}
	}
	
	public boolean tryTakeBoondollars(long amount)
	{
		if(getBoondollars() - amount < 0)
			return false;
		else
		{
			takeBoondollars(amount);
			return true;
		}
	}
	
	public void setBoondollars(long amount)
	{
		if(amount < 0)
			throw new IllegalArgumentException("Boondollar amount may not be negative.");
		else if(amount != boondollars)
		{
			boondollars = amount;
			markDirty();
			sendBoondollars(getPlayer());
		}
	}
	
	public ImmutableGristSet getGristCache()
	{
		return gristCache;
	}
	
	public void setGristCache(NonNegativeGristSet cache)
	{
		gristCache = cache.asImmutable();
		markDirty();
		updateGristCache(getPlayer());
	}
	
	public Title getTitle()
	{
		return title;
	}
	
	public void setTitle(Title newTitle)
	{
		if(title == null)
		{
			title = Objects.requireNonNull(newTitle);
			markDirty();
			sendTitle(getPlayer());
		} else throw new IllegalStateException("Can't set title for player "+ identifier.getUsername()+" because they already have one");
	}
	
	public boolean effectToggle()
	{
		return effectToggle;
	}
	
	public void effectToggle(boolean toggle)
	{
		if(effectToggle != toggle)
		{
			effectToggle = toggle;
			markDirty();
		}
	}
	
	public void onPlayerLoggedIn(ServerPlayerEntity player)
	{
		getEcheladder().updateEcheladderBonuses(player);
		
		if(getModus() == null && MinestuckConfig.defaultModusTypes.length > 0 && !hasGivenModus())
		{
			int index = player.world.rand.nextInt(MinestuckConfig.defaultModusTypes.length);
			Modus modus = CaptchaDeckHandler.createServerModus(new ResourceLocation(MinestuckConfig.defaultModusTypes[index]), savedData);
			if(modus != null)
			{
				modus.initModus(player, null, MinestuckConfig.initialModusSize.get());
				CaptchaDeckHandler.setModus(player, modus);
			} else LOGGER.warn("Couldn't create a modus by name {}.", MinestuckConfig.defaultModusTypes[index]);
		}
		
		if(getModus() != null)
		{
			Modus modus = getModus();
			MSPacketHandler.sendToPlayer(CaptchaDeckPacket.data(CaptchaDeckHandler.writeToNBT(modus)), player);
		}
		
		echeladder.sendDataPacket(player, true);
		sendColor(player, !hasLoggedIn);
		sendBoondollars(player);
		updateGristCache(player);
		sendTitle(player);
		
		hasLoggedIn = true;
	}
	
	private void sendColor(ServerPlayerEntity player, boolean firstTime)
	{
		if(player == null)
			return;
		if(firstTime && !player.isSpectator())
			MSPacketHandler.sendToPlayer(PlayerDataPacket.color(), player);
		else
		{
			PlayerDataPacket packet = PlayerDataPacket.color(getColor());
			MSPacketHandler.sendToPlayer(packet, player);
		}
	}
	
	private void sendBoondollars(ServerPlayerEntity player)
	{
		if(player == null)
			return;
		PlayerDataPacket packet = PlayerDataPacket.boondollars(getBoondollars());
		MSPacketHandler.sendToPlayer(packet, player);
	}
	
	private void updateGristCache(ServerPlayerEntity player)
	{
		GristSet gristSet = getGristCache();
		
		//Send to the player
		if(player != null)
		{
			GristCachePacket packet = new GristCachePacket(gristSet, false);
			MSPacketHandler.sendToPlayer(packet, player);
		}
		
		//Also send to the editing player, if there is any
		SburbConnection c = SkaianetHandler.get(savedData.mcServer).getActiveConnection(identifier);
		if(c != null)
		{
			EditData data = ServerEditHandler.getData(savedData.mcServer, c);
			if(data != null)
			{
				data.sendGristCacheToEditor();
			}
		}
	}
	
	private void sendTitle(ServerPlayerEntity player)
	{
		Title newTitle = getTitle();
		if(newTitle == null || player == null)
			return;
		PlayerDataPacket packet = PlayerDataPacket.title(newTitle);
		MSPacketHandler.sendToPlayer(packet, player);
	}
	
	private ServerPlayerEntity getPlayer()
	{
		return identifier.getPlayer(savedData.mcServer);
	}
}