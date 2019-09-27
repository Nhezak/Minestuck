package com.mraof.minestuck.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

import java.util.function.Supplier;

/**
 * Only exists because the constructor in BlockStairs is protected
 */
public class ModStairsBlock extends StairsBlock
{
	//TODO Probably need to make sure that they are burnable if the modelState is. Same thing for slabs
	public ModStairsBlock(Supplier<BlockState> modelState, Properties properties)
	{
		super(modelState, properties);
	}
}