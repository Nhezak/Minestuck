package com.mraof.minestuck.block.multiblock;

import com.mraof.minestuck.block.TotemLatheBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class TotemLatheMultiblock extends MachineMultiblock
{
	public final RegistryObject<Block> CARD_SLOT, BOTTOM_LEFT, BOTTOM_RIGHT, BOTTOM_CORNER;
	public final RegistryObject<Block> MIDDLE, WHEEL, ROD, DOWEL_ROD;
	public final RegistryObject<Block> TOP_CORNER, TOP, CARVER;
	
	public TotemLatheMultiblock(DeferredRegister<Block> register, String name)
	{
		CARD_SLOT = register.register(name + "_card_slot", () -> new TotemLatheBlock.Slot(this, TotemLatheBlock.CARD_SLOT_SHAPE, Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		BOTTOM_LEFT = register.register(name + "_bottom_left", () -> new TotemLatheBlock(this, TotemLatheBlock.BOTTOM_LEFT_SHAPE, new BlockPos(1, 0, 0), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		BOTTOM_RIGHT = register.register(name + "_bottom_right", () -> new TotemLatheBlock(this, TotemLatheBlock.BOTTOM_RIGHT_SHAPE, new BlockPos(2, 0, 0), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		BOTTOM_CORNER = register.register(name + "_bottom_corner", () -> new TotemLatheBlock(this, TotemLatheBlock.BOTTOM_CORNER_SHAPE, new BlockPos(3, 0, 0), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		MIDDLE = register.register(name + "_middle", () -> new TotemLatheBlock(this, TotemLatheBlock.MIDDLE_SHAPE, new BlockPos(0, -1, 0), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		WHEEL = register.register(name + "_wheel", () -> new TotemLatheBlock.Rod(this, TotemLatheBlock.WHEEL_SHAPE, new BlockPos(3, -1, 0), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		ROD = register.register(name + "_rod", () -> new TotemLatheBlock.Rod(this, TotemLatheBlock.ROD_SHAPE, new BlockPos(1, -1, 0), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		DOWEL_ROD = register.register(name + "_dowel_rod", () -> new TotemLatheBlock.DowelRod(this, TotemLatheBlock.ROD_SHAPE, new BlockPos(2, -1, 0), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		TOP_CORNER = register.register(name + "_top_corner", () -> new TotemLatheBlock(this, TotemLatheBlock.TOP_CORNER_SHAPE, new BlockPos(0, -2, 0), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		TOP = register.register(name + "_top", () -> new TotemLatheBlock(this, TotemLatheBlock.TOP_SHAPE, new BlockPos(1, -2, 0), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		CARVER = register.register(name + "_carver", () -> new TotemLatheBlock(this, TotemLatheBlock.CARVER_SHAPE, new BlockPos(2, -2, 0), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
	}
	
	@Override
	public Block getMainBlock()
	{
		return MIDDLE.get();
	}
}