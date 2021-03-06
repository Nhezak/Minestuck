package com.mraof.minestuck.network;

import com.mraof.minestuck.tileentity.AlchemiterTileEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class AlchemiterPacket implements PlayToServerPacket
{
	public BlockPos pos;
	public int quantity;
	
	public AlchemiterPacket(BlockPos pos, int quantity)
	{
		this.pos = pos;
		this.quantity = quantity;
	}
	
	@Override
	public void encode(PacketBuffer buffer)
	{
		buffer.writeBlockPos(pos);
		buffer.writeInt(quantity);
	}
	
	public static AlchemiterPacket decode(PacketBuffer buffer)
	{
		BlockPos pos = buffer.readBlockPos();
		int quantity = buffer.readInt();
		
		return new AlchemiterPacket(pos, quantity);
	}
	
	@Override
	public void execute(ServerPlayerEntity player)
	{
		if(player.getEntityWorld().isAreaLoaded(pos, 0))
		{
			TileEntity te;
			te = player.getEntityWorld().getTileEntity(pos);
			if(te instanceof AlchemiterTileEntity)
			{
				((AlchemiterTileEntity) te).processContents(quantity, player);
			}
		}
	}
}