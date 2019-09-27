package com.mraof.minestuck.block.multiblock;

import com.mraof.minestuck.block.AlchemiterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class AlchemiterMultiblock extends MachineMultiblock
{
	public final RegistryObject<Block> CENTER, CORNER, LEFT_SIDE, RIGHT_SIDE;
	public final RegistryObject<Block> TOTEM_CORNER, TOTEM_PAD, LOWER_ROD, UPPER_ROD;
	
	public AlchemiterMultiblock(DeferredRegister<Block> register, String name)
	{
		CENTER = register.register(name + "_center", () -> new AlchemiterBlock(this, AlchemiterBlock.FULL_BLOCK_SHAPE, true, false, new BlockPos(1, 0, -1), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		CORNER = register.register(name + "_corner", () -> new AlchemiterBlock(this, AlchemiterBlock.FULL_BLOCK_SHAPE, true, true, new BlockPos(0, 0, 3), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		LEFT_SIDE = register.register(name + "_left_side", () -> new AlchemiterBlock(this, AlchemiterBlock.FULL_BLOCK_SHAPE, true, false, new BlockPos(1, 0, 0), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		RIGHT_SIDE = register.register(name + "_right_side", () -> new AlchemiterBlock(this, AlchemiterBlock.FULL_BLOCK_SHAPE, true, false, new BlockPos(2, 0, 0), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		TOTEM_CORNER = register.register(name + "_totem_corner", () -> new AlchemiterBlock(this, AlchemiterBlock.FULL_BLOCK_SHAPE, false, true, new BlockPos(0, 1, 0), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		TOTEM_PAD = register.register(name + "_totem_pad", () -> new AlchemiterBlock.Pad(this, AlchemiterBlock.TOTEM_PAD_SHAPE, Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		LOWER_ROD = register.register(name + "_lower_rod", () -> new AlchemiterBlock(this, AlchemiterBlock.LOWER_ROD_SHAPE, false, false, new BlockPos(0, -1, 0), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		UPPER_ROD = register.register(name + "upper_rod", () -> new AlchemiterBlock(this, AlchemiterBlock.UPPER_ROD_SHAPE, false, false, new BlockPos(0, -2, 0), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
	}
	
	@Override
	public Block getMainBlock()
	{
		return CENTER.get();
	}
}