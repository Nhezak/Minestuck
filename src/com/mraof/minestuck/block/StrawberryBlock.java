package com.mraof.minestuck.block;

import com.mraof.minestuck.item.MSItems;
import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nullable;

public class StrawberryBlock extends StemGrownBlock
{
	public static final DirectionProperty FACING = BlockStateProperties.FACING;
	
	protected StrawberryBlock(Properties properties)
	{
		super(properties);
		
		setDefaultState(getDefaultState().with(FACING, Direction.UP));
	}
	
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
	{
		builder.add(FACING);
	}
	
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context)
	{
		Direction direction = context.getNearestLookingDirection();
		return this.getDefaultState().with(FACING, direction);
	}
	
	@Override
	public StemBlock getStem()
	{
		return MSBlocks.STRAWBERRY_STEM.orElseThrow(() -> new IllegalStateException("Should not get stem block before it is created!"));
	}
	
	@Override
	public AttachedStemBlock getAttachedStem()
	{
		return MSBlocks.ATTACHED_STRAWBERRY_STEM.orElseThrow(() -> new IllegalStateException("Should not get attached stem block before it is created!"));
	}
	
	//TODO These need to handle suppliers for the crop block
	public static class AttachedStem extends AttachedStemBlock
	{
		public AttachedStem(RegistryObject<StemGrownBlock> crop, Properties properties)
		{
			super(crop.orElseThrow(() -> new IllegalStateException("Shouldn't create crop stem before the crop is created!")), properties);
		}
		
		@Override
		protected Item getSeeds()
		{
			return MSItems.STRAWBERRY_CHUNK;
		}
	}
	
	public static class Stem extends StemBlock
	{
		public Stem(RegistryObject<StemGrownBlock> crop, Properties properties)
		{
			super(crop.orElseThrow(() -> new IllegalStateException("Shouldn't create crop stem before the crop is created!")), properties);
		}
		
		@Nullable
		@Override
		protected Item getSeedItem()
		{
			return MSItems.STRAWBERRY_CHUNK;
		}
	}
}