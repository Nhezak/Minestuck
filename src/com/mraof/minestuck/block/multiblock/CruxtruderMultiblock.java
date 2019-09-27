package com.mraof.minestuck.block.multiblock;

import com.mraof.minestuck.block.CruxtruderBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class CruxtruderMultiblock extends MachineMultiblock
{
	public final RegistryObject<Block> CORNER, SIDE, CENTER, TUBE;
	
	public CruxtruderMultiblock(DeferredRegister<Block> register, String name)
	{
		CORNER = register.register(name + "_corner", () -> new CruxtruderBlock(this, VoxelShapes.fullCube(), false, new BlockPos(1, 1, 1), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		SIDE = register.register(name + "_side", () -> new CruxtruderBlock(this, VoxelShapes.fullCube(), false, new BlockPos(0, 1, 1), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		CENTER = register.register(name + "_center", () -> new CruxtruderBlock(this, VoxelShapes.fullCube(), true, new BlockPos(0, 1, 0), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
		TUBE = register.register(name + "_tube", () -> new CruxtruderBlock(this, CruxtruderBlock.TUBE_SHAPE, false, new BlockPos(0, 0, 0), Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
	}
	
	@Override
	public Block getMainBlock()
	{
		return CENTER.get();
	}
}