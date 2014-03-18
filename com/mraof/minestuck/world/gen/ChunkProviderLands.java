package com.mraof.minestuck.world.gen;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;

import com.mraof.minestuck.entity.consort.EntityIguana;
import com.mraof.minestuck.entity.consort.EntityNakagator;
import com.mraof.minestuck.entity.consort.EntitySalamander;
import com.mraof.minestuck.entity.underling.EntityBasilisk;
import com.mraof.minestuck.entity.underling.EntityGiclops;
import com.mraof.minestuck.entity.underling.EntityImp;
import com.mraof.minestuck.entity.underling.EntityOgre;
import com.mraof.minestuck.world.gen.lands.BlockWithMetadata;
import com.mraof.minestuck.world.gen.lands.ILandDecorator;
import com.mraof.minestuck.world.gen.lands.LandAspect;
import com.mraof.minestuck.world.gen.lands.LandHelper;

import cpw.mods.fml.common.eventhandler.Event.Result;

public class ChunkProviderLands implements IChunkProvider 
{
	List consortList;
	List underlingList;
	World landWorld;
	Random random;
	private NoiseGeneratorOctaves noiseGens[] = new NoiseGeneratorOctaves[2];
	private NoiseGeneratorTriangle noiseGeneratorTriangle;
	private NoiseGeneratorTriangle noiseGeneratorTriangle1;
	public LandAspect aspect1;
	public LandAspect aspect2;
	public LandHelper helper;
	public int nameIndex1, nameIndex2;

	public BlockWithMetadata surfaceBlock;
	public BlockWithMetadata upperBlock;
	public Block oceanBlock;
	public Block riverBlock;
	public LandAspect terrainMapper;
	public ArrayList decorators;
	public int dayCycle;

	public ChunkProviderLands(World worldObj, long seed, boolean b) 
	{
		helper = new LandHelper(seed);

		NBTBase landDataTag = worldObj.getWorldInfo().getAdditionalProperty("LandData");

		this.landWorld = worldObj;

		if (landDataTag == null) {
			this.aspect1 = helper.getLandAspect();
			this.aspect2 = helper.getLandAspect(aspect1);
			Random rand = new Random();
			nameIndex1 = rand.nextInt(aspect1.getNames().length);	//Better way to generate these?
			nameIndex2 = rand.nextInt(aspect2.getNames().length);
			Map<String, NBTBase> dataTag = new Hashtable<String,NBTBase>();
			dataTag.put("LandData",LandHelper.toNBT(aspect1,aspect2));
			worldObj.getWorldInfo().setAdditionalProperties(dataTag);

			//			// this packet code is wrong-sided, needs fixed, I don't even know if we need it anymore
			//			Packet250CustomPayload packet = new Packet250CustomPayload();
			//			packet.channel = "Minestuck";
			//			packet.data = MinestuckPacket.makePacket(Type.NEWLAND,aspect1.getPrimaryName(),aspect2.getPrimaryName(),3);
			//			packet.length = packet.data.length;
			//			Minecraft.getMinecraft().getNetHandler().addToSendQueue(packet);
		} else {
			aspect1 = helper.fromName(((NBTTagCompound) landDataTag).getString("aspect1"));
			aspect2 = helper.fromName(((NBTTagCompound) landDataTag).getString("aspect2"));
			nameIndex1 = ((NBTTagCompound) landDataTag).getInteger("aspectName1");
			nameIndex2 = ((NBTTagCompound) landDataTag).getInteger("aspectName2");
		}

		this.random = new Random(seed);
		this.consortList = new ArrayList();
		this.underlingList = new ArrayList();
		this.consortList.add(new SpawnListEntry(EntityNakagator.class, 2, 1, 10));
		this.consortList.add(new SpawnListEntry(EntitySalamander.class, 2, 1, 10));
		this.consortList.add(new SpawnListEntry(EntityIguana.class, 2, 1, 10));
		this.underlingList.add(new SpawnListEntry(EntityImp.class, 6, 1, 10));
		this.underlingList.add(new SpawnListEntry(EntityOgre.class, 4, 1, 2));
		this.underlingList.add(new SpawnListEntry(EntityBasilisk.class, 3, 1, 2));
		this.underlingList.add(new SpawnListEntry(EntityGiclops.class, 1, 1, 1));
		this.underlingList.add(new SpawnListEntry(EntityBasilisk.class, 1, 1, 1));
		this.noiseGens[0] = new NoiseGeneratorOctaves(this.random, 7);
		this.noiseGens[1] = new NoiseGeneratorOctaves(this.random, 1);
		noiseGeneratorTriangle = new NoiseGeneratorTriangle(this.random);
		noiseGeneratorTriangle1 = new NoiseGeneratorTriangle(this.random);

		this.surfaceBlock = (BlockWithMetadata) helper.pickElement(helper.pickOne(aspect1, aspect2).getSurfaceBlocks());
		this.upperBlock = (BlockWithMetadata) helper.pickElement(helper.pickOne(aspect1, aspect2).getUpperBlocks());
		LandAspect fluidAspect = helper.pickOne(aspect1, aspect2);
		this.oceanBlock = fluidAspect.getOceanBlock();
		this.riverBlock = fluidAspect.getRiverBlock();
		this.terrainMapper = helper.pickOne(aspect1,aspect2);
		this.decorators = helper.pickSubset(aspect1.getDecorators(),aspect2.getDecorators());
		this.dayCycle = helper.pickOne(aspect1,aspect2).getDayCycleMode();


	}

	@Override
	public boolean chunkExists(int i, int j) 
	{
		return true;
	}

	@Override
	public Chunk provideChunk(int chunkX, int chunkZ) 
	{
		Block[] chunkBlocks = new Block[65536];
		byte[] chunkMetadata = new byte[65536];
		double[] heightMap = new double[256];
		double[] heightMapTriangles = new double[256];
		double[] riverHeightMap = new double[256];
		int[] topBlock = new int[256];
		int[] topRiverBlock = new int[256];

		heightMap = this.noiseGens[0].generateNoiseOctaves(heightMap, chunkX * 16, 10, chunkZ * 16, 16, 1, 16, .1, 0, .1);
		riverHeightMap = this.noiseGens[1].generateNoiseOctaves(riverHeightMap, chunkX * 16, 1, chunkZ * 16, 16, 1, 16, .003, 0, .003);
		heightMapTriangles = noiseGeneratorTriangle.generateNoiseTriangle(heightMap, chunkX * 16, chunkZ * 16, 16, 16);

		for(int i = 0; i < 256; i++)
		{
			topRiverBlock[i] = (int) (.025 / ((5 * riverHeightMap[i]) * (5 * riverHeightMap[i]) + 0.005));
		}

		for(int i = 0; i < 256; i++)
		{
			int y = (int) (64 + heightMap[i] + heightMapTriangles[i]);
			topBlock[i] = ((y & 511) <= 255  ? y & 255 : 255 - y & 255) - topRiverBlock[i];
		}


		for(int x = 0; x < 16; x++)
			for(int z = 0; z < 16; z++)
			{
				chunkBlocks[x + z * 16] = Blocks.bedrock;
				int y;
				int currentBlockOffset;
				for(y = 1; y < topBlock[x * 16 + z] - 1; y++)
				{
					//currentBlockOffset = (int) Math.abs(generated1[x + z * 256 + y * 16]);
					chunkBlocks[x + z * 16 + y * 256] = upperBlock.block;
					chunkMetadata[x + z * 16 + y * 256] = upperBlock.metadata;
				}

				
				chunkBlocks[x + z * 16 + y * 256] = surfaceBlock.block;
				chunkMetadata[x + z * 16 + y * 256] = surfaceBlock.metadata;

				for(int i = y + topRiverBlock[x * 16 + z]; y < i; y++)
					chunkBlocks[x + z * 16 + y * 256] = this.riverBlock;

				for(; y < 63; y++)
					chunkBlocks[x + z * 16 + y * 256] = this.oceanBlock;

			}
		Chunk chunk = new Chunk(this.landWorld, chunkBlocks, chunkMetadata, chunkX, chunkZ);
		return chunk;
	}
	private double[] initializeNoiseField(double[] par1ArrayOfDouble, int par2, int par3, int par4, int par5, int par6, int par7)
	{
		ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField(this, par1ArrayOfDouble, par2, par3, par4, par5, par6, par7);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.getResult() == Result.DENY) return event.noisefield;

		if (par1ArrayOfDouble == null)
		{
			par1ArrayOfDouble = new double[par5 * par6 * par7];
		}

		return par1ArrayOfDouble;
	}
	@Override
	public Chunk loadChunk(int chunkX, int chunkZ) 
	{
		return this.provideChunk(chunkX, chunkZ);
	}

	@Override
	public void populate(IChunkProvider ichunkprovider, int i, int j) {

		Chunk chunk = this.provideChunk(i, j);
		if (!chunk.isTerrainPopulated)
		{
			//Debug.print("Populating! We have "+decorators.size()+" decorators");
			chunk.isTerrainPopulated = true;

			if (ichunkprovider != null)
			{
				ichunkprovider.populate(ichunkprovider, i, j);
				for (Object decorator : decorators) {
					((ILandDecorator) decorator).generate(landWorld, random, i,  j, this);
				}
				chunk.setChunkModified();
			}
		}
	}

	@Override
	public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
		return true;
	}

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public boolean canSave() {
		return true;
	}

	@Override
	public String makeString() {
		return "LandRandomLevelSource";
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType enumcreaturetype, int i,
			int j, int k) {
		//Debug.printf("Chosen to spawn! args: %s %d %d %d",enumcreaturetype,i,j,k);
		return enumcreaturetype == EnumCreatureType.creature ? this.consortList : (enumcreaturetype == EnumCreatureType.monster ? this.underlingList : null);
	}

	/*@Override
	public ChunkPosition findClosestStructure(World world, String s, int i,int j, int k) {
		return null;
	}*/

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void recreateStructures(int i, int j) {
	}

	@Override
	public void saveExtraData() {
	}
	
	@Override
	/**
	 * Redirected to in World.findClosestStructure()
	 * Only used in vanilla by ender eye when looking for a stronghold.
	 * var1: The world object; var2: The name of the structure type;
	 * var3: xCoord; var4: yCoord; var5: zCoord;
	 */
	public ChunkPosition func_147416_a(World var1, String var2, int var3, int var4, int var5) {
		return null;
	}

}
