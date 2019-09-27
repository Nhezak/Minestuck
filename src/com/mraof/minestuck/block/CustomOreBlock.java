package com.mraof.minestuck.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.RegistryObject;

import java.util.Random;

public class CustomOreBlock extends OreBlock
{
	private final int minExp, maxExp;
	
	public CustomOreBlock(Properties properties)
	{
		this(0, 0, properties);
	}
	
	public CustomOreBlock(int minExp, int maxExp, Properties properties)
	{
		super(properties);
		this.minExp = minExp;
		this.maxExp = maxExp;
	}
	
	@Override
	protected int func_220281_a(Random random)
	{
		return MathHelper.nextInt(random, minExp, maxExp);
	}
	
	public static BlockState getCruxiteState(BlockState ground)
	{
		RegistryObject<Block> block;
		if(ground.getBlock() == Blocks.STONE)	//TODO Change this to something more dynamic
			block = MSBlocks.STONE_CRUXITE_ORE;
		else if(ground.getBlock() == Blocks.COBBLESTONE)
			block = MSBlocks.COBBLESTONE_CRUXITE_ORE;
		else if(ground.getBlock() == Blocks.SANDSTONE)
			block = MSBlocks.SANDSTONE_CRUXITE_ORE;
		else if(ground.getBlock() == Blocks.RED_SANDSTONE)
			block = MSBlocks.RED_SANDSTONE_CRUXITE_ORE;
		else if(ground.getBlock() == Blocks.NETHERRACK)
			block = MSBlocks.NETHERRACK_CRUXITE_ORE;
		else if(ground.getBlock() == Blocks.END_STONE)
			block = MSBlocks.END_STONE_CRUXITE_ORE;
		else if(ground.getBlock() == MSBlocks.PINK_STONE.get())
			block = MSBlocks.PINK_STONE_CRUXITE_ORE;
		else block = MSBlocks.STONE_CRUXITE_ORE;
		
		return block.orElseThrow(() -> new IllegalStateException("Cruxite ore for "+ground.getBlock()+" has not been created yet!")).getDefaultState();
	}
	
	public static BlockState getUraniumState(BlockState ground)
	{
		RegistryObject<Block> block;
		if(ground.getBlock() == Blocks.STONE)	//TODO Change this to something more dynamic
			block = MSBlocks.STONE_URANIUM_ORE;
		else if(ground.getBlock() == Blocks.COBBLESTONE)
			block = MSBlocks.COBBLESTONE_URANIUM_ORE;
		else if(ground.getBlock() == Blocks.SANDSTONE)
			block = MSBlocks.SANDSTONE_URANIUM_ORE;
		else if(ground.getBlock() == Blocks.RED_SANDSTONE)
			block = MSBlocks.RED_SANDSTONE_URANIUM_ORE;
		else if(ground.getBlock() == Blocks.NETHERRACK)
			block = MSBlocks.NETHERRACK_URANIUM_ORE;
		else if(ground.getBlock() == Blocks.END_STONE)
			block = MSBlocks.END_STONE_URANIUM_ORE;
		else if(ground.getBlock() == MSBlocks.PINK_STONE.get())
			block = MSBlocks.PINK_STONE_URANIUM_ORE;
		else block = MSBlocks.STONE_URANIUM_ORE;
		
		return block.orElseThrow(() -> new IllegalStateException("Uranium ore for "+ground.getBlock()+" has not been created yet!")).getDefaultState();
	}
}