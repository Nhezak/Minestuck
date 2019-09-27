package com.mraof.minestuck.block.multiblock;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;

public abstract class MachineMultiblock implements IItemProvider    //An abstraction for large machines that might be expanded upon in the future
{
	
	public abstract Block getMainBlock();
	
	@Override
	public Item asItem()
	{
		return getMainBlock().asItem();
	}
}