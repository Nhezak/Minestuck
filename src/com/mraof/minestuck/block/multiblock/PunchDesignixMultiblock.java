package com.mraof.minestuck.block.multiblock;

import com.mraof.minestuck.block.PunchDesignixBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class PunchDesignixMultiblock extends MachineMultiblock
{
	public final RegistryObject<Block> LEFT_LEG, RIGHT_LEG, SLOT, KEYBOARD;
	
	public PunchDesignixMultiblock(DeferredRegister<Block> register, String name)
	{
		LEFT_LEG = register.register(name + "_left_leg", () -> new PunchDesignixBlock(this, PunchDesignixBlock.LEG_SHAPE, new BlockPos(0, 1, 0), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		RIGHT_LEG = register.register(name + "_right_leg", () -> new PunchDesignixBlock(this, PunchDesignixBlock.LEG_SHAPE, new BlockPos(1, 1, 0), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		SLOT = register.register(name + "_slot", () -> new PunchDesignixBlock.Slot(this, PunchDesignixBlock.SLOT_SHAPE, Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		KEYBOARD = register.register(name + "_keyboard", () -> new PunchDesignixBlock(this, PunchDesignixBlock.KEYBOARD_SHAPE, new BlockPos(1, 0, 0), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
	}
	
	@Override
	public Block getMainBlock()
	{
		return SLOT.get();
	}
}