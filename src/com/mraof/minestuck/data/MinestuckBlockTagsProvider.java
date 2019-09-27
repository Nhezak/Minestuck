package com.mraof.minestuck.data;

import com.mraof.minestuck.util.ExtraForgeTags;
import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;

import static com.mraof.minestuck.block.MSBlocks.*;
import static com.mraof.minestuck.util.MSTags.Blocks.*;
import static net.minecraft.tags.BlockTags.*;

public class MinestuckBlockTagsProvider extends BlockTagsProvider
{
	MinestuckBlockTagsProvider(DataGenerator generatorIn)
	{
		super(generatorIn);
	}
	
	@Override
	@SuppressWarnings("ConstantConditions")
	protected void registerTags()
	{
		getBuilder(PLANKS).add(GLOWING_PLANKS.get(), FROST_PLANKS.get(), RAINBOW_PLANKS.get(), END_PLANKS.get(), DEAD_PLANKS.get(), TREATED_PLANKS.get()).add(ASPECT_PLANKS);
		getBuilder(STONE_BRICKS).add(FLOWERY_MOSSY_STONE_BRICKS.get());
		getBuilder(WOODEN_BUTTONS).add(WOODEN_EXPLOSIVE_BUTTON.get());
		getBuilder(BUTTONS).add(STONE_EXPLOSIVE_BUTTON.get());
		getBuilder(WOODEN_STAIRS).add(RAINBOW_PLANKS_STAIRS.get(), END_PLANKS_STAIRS.get(), DEAD_PLANKS_STAIRS.get(), TREATED_PLANKS_STAIRS.get());
		getBuilder(WOODEN_SLABS).add(RAINBOW_PLANKS_SLAB.get(), END_PLANKS_SLAB.get(), DEAD_PLANKS_SLAB.get(), TREATED_PLANKS_SLAB.get());
		getBuilder(SAPLINGS).add(RAINBOW_SAPLING.get(), END_SAPLING.get()).add(ASPECT_SAPLINGS);
		getBuilder(LOGS).add(GLOWING_LOGS, FROST_LOGS, RAINBOW_LOGS, END_LOGS, VINE_LOGS, FLOWERY_VINE_LOGS, DEAD_LOGS, PETRIFIED_LOGS, ASPECT_LOGS);
		getBuilder(ENDERMAN_HOLDABLE).add(BLUE_DIRT.get(), THOUGHT_DIRT.get());
		getBuilder(STAIRS).add(COARSE_STONE_STAIRS.get(), SHADE_BRICK_STAIRS.get(), FROST_BRICK_STAIRS.get(), CAST_IRON_STAIRS.get(), MYCELIUM_BRICK_STAIRS.get(), CHALK_STAIRS.get(), CHALK_BRICK_STAIRS.get(), PINK_STONE_BRICK_STAIRS.get());
		getBuilder(SLABS).add(CHALK_SLAB.get(), CHALK_BRICK_SLAB.get(), PINK_STONE_BRICK_SLAB.get());
		getBuilder(LEAVES).add(FROST_LEAVES.get(), RAINBOW_LEAVES.get(), END_LEAVES.get()).add(ASPECT_LEAVES);
		getBuilder(DIRT_LIKE).add(BLACK_CHESS_DIRT.get(), WHITE_CHESS_DIRT.get(), DARK_GRAY_CHESS_DIRT.get(), LIGHT_GRAY_CHESS_DIRT.get(), BLUE_DIRT.get(), THOUGHT_DIRT.get());
		getBuilder(Tags.Blocks.COBBLESTONE).add(FLOWERY_MOSSY_COBBLESTONE.get());
		getBuilder(Tags.Blocks.END_STONES).add(COARSE_END_STONE.get());
		getBuilder(Tags.Blocks.ORES).add(CRUXITE_ORES, ExtraForgeTags.Blocks.URANIUM_ORES);
		getBuilder(Tags.Blocks.ORES_COAL).add(COAL_ORES);
		getBuilder(Tags.Blocks.ORES_DIAMOND).add(DIAMOND_ORES);
		getBuilder(Tags.Blocks.ORES_GOLD).add(GOLD_ORES);
		getBuilder(Tags.Blocks.ORES_IRON).add(IRON_ORES);
		getBuilder(Tags.Blocks.ORES_LAPIS).add(LAPIS_ORES);
		getBuilder(Tags.Blocks.ORES_QUARTZ).add(QUARTZ_ORES);
		getBuilder(Tags.Blocks.ORES_REDSTONE).add(REDSTONE_ORES);
		getBuilder(Tags.Blocks.STONE).add(COARSE_STONE.get(), BLACK_STONE.get(), COARSE_END_STONE.get(), PINK_STONE.get());
		getBuilder(Tags.Blocks.STORAGE_BLOCKS).add(CRUXITE_STORAGE_BLOCKS, ExtraForgeTags.Blocks.URANIUM_STORAGE_BLOCKS);
		
		getBuilder(ExtraForgeTags.Blocks.URANIUM_ORES).add(URANIUM_ORES);
		getBuilder(ExtraForgeTags.Blocks.URANIUM_STORAGE_BLOCKS).add(URANIUM_BLOCK.get());
		getBuilder(ExtraForgeTags.Blocks.TERRACOTTA).add(Blocks.TERRACOTTA, Blocks.BLACK_GLAZED_TERRACOTTA, Blocks.BLACK_TERRACOTTA, Blocks.BLUE_GLAZED_TERRACOTTA, Blocks.BLUE_TERRACOTTA, Blocks.BROWN_GLAZED_TERRACOTTA, Blocks.BROWN_TERRACOTTA, Blocks.CYAN_GLAZED_TERRACOTTA, Blocks.CYAN_TERRACOTTA, Blocks.GRAY_GLAZED_TERRACOTTA, Blocks.GRAY_TERRACOTTA, Blocks.GREEN_GLAZED_TERRACOTTA, Blocks.GREEN_TERRACOTTA, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.LIME_GLAZED_TERRACOTTA, Blocks.LIME_TERRACOTTA, Blocks.MAGENTA_GLAZED_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA, Blocks.ORANGE_GLAZED_TERRACOTTA, Blocks.ORANGE_TERRACOTTA, Blocks.PINK_GLAZED_TERRACOTTA, Blocks.PINK_TERRACOTTA, Blocks.PURPLE_GLAZED_TERRACOTTA, Blocks.PURPLE_TERRACOTTA, Blocks.RED_GLAZED_TERRACOTTA, Blocks.RED_TERRACOTTA, Blocks.WHITE_GLAZED_TERRACOTTA, Blocks.WHITE_TERRACOTTA, Blocks.YELLOW_GLAZED_TERRACOTTA, Blocks.YELLOW_TERRACOTTA);
		
		getBuilder(GLOWING_LOGS).add(GLOWING_LOG.get(), GLOWING_WOOD.get());
		getBuilder(FROST_LOGS).add(FROST_LOG.get(), FROST_WOOD.get());
		getBuilder(RAINBOW_LOGS).add(RAINBOW_LOG.get(), RAINBOW_WOOD.get());
		getBuilder(END_LOGS).add(END_LOG.get(), END_WOOD.get());
		getBuilder(VINE_LOGS).add(VINE_LOG.get(), VINE_WOOD.get());
		getBuilder(FLOWERY_VINE_LOGS).add(FLOWERY_VINE_LOG.get(), FLOWERY_VINE_WOOD.get());
		getBuilder(DEAD_LOGS).add(DEAD_LOG.get(), DEAD_WOOD.get());
		getBuilder(PETRIFIED_LOGS).add(PETRIFIED_LOG.get(), PETRIFIED_WOOD.get());
		getBuilder(ASPECT_LOGS).add(BLOOD_ASPECT_LOG.get(), BREATH_ASPECT_LOG.get(), DOOM_ASPECT_LOG.get(), HEART_ASPECT_LOG.get(), HOPE_ASPECT_LOG.get(), LIFE_ASPECT_LOG.get(), LIGHT_ASPECT_LOG.get(), MIND_ASPECT_LOG.get(), RAGE_ASPECT_LOG.get(), SPACE_ASPECT_LOG.get(), TIME_ASPECT_LOG.get(), VOID_ASPECT_LOG.get());
		getBuilder(ASPECT_PLANKS).add(BLOOD_ASPECT_PLANKS.get(), BREATH_ASPECT_PLANKS.get(), DOOM_ASPECT_PLANKS.get(), HEART_ASPECT_PLANKS.get(), HOPE_ASPECT_PLANKS.get(), LIFE_ASPECT_PLANKS.get(), LIGHT_ASPECT_PLANKS.get(), MIND_ASPECT_PLANKS.get(), RAGE_ASPECT_PLANKS.get(), SPACE_ASPECT_PLANKS.get(), TIME_ASPECT_PLANKS.get(), VOID_ASPECT_PLANKS.get());
		getBuilder(ASPECT_LEAVES).add(BLOOD_ASPECT_LEAVES.get(), BREATH_ASPECT_LEAVES.get(), DOOM_ASPECT_LEAVES.get(), HEART_ASPECT_LEAVES.get(), HOPE_ASPECT_LEAVES.get(), LIFE_ASPECT_LEAVES.get(), LIGHT_ASPECT_LEAVES.get(), MIND_ASPECT_LEAVES.get(), RAGE_ASPECT_LEAVES.get(), SPACE_ASPECT_LEAVES.get(), TIME_ASPECT_LEAVES.get(), VOID_ASPECT_LEAVES.get());
		getBuilder(ASPECT_SAPLINGS).add(BLOOD_ASPECT_SAPLING.get(), BREATH_ASPECT_SAPLING.get(), DOOM_ASPECT_SAPLING.get(), HEART_ASPECT_SAPLING.get(), HOPE_ASPECT_SAPLING.get(), LIFE_ASPECT_SAPLING.get(), LIGHT_ASPECT_SAPLING.get(), MIND_ASPECT_SAPLING.get(), RAGE_ASPECT_SAPLING.get(), SPACE_ASPECT_SAPLING.get(), TIME_ASPECT_SAPLING.get(), VOID_ASPECT_SAPLING.get());
		getBuilder(CRUXITE_ORES).add(STONE_CRUXITE_ORE.get(), NETHERRACK_CRUXITE_ORE.get(), COBBLESTONE_CRUXITE_ORE.get(), SANDSTONE_CRUXITE_ORE.get(), RED_SANDSTONE_CRUXITE_ORE.get(), END_STONE_CRUXITE_ORE.get(), PINK_STONE_CRUXITE_ORE.get());
		getBuilder(URANIUM_ORES).add(STONE_URANIUM_ORE.get(), NETHERRACK_URANIUM_ORE.get(), COBBLESTONE_URANIUM_ORE.get(), SANDSTONE_URANIUM_ORE.get(), RED_SANDSTONE_URANIUM_ORE.get(), END_STONE_URANIUM_ORE.get(), PINK_STONE_URANIUM_ORE.get());
		getBuilder(COAL_ORES).add(NETHERRACK_COAL_ORE.get(), PINK_STONE_COAL_ORE.get());
		getBuilder(IRON_ORES).add(END_STONE_IRON_ORE.get(), SANDSTONE_IRON_ORE.get(), RED_SANDSTONE_IRON_ORE.get());
		getBuilder(GOLD_ORES).add(SANDSTONE_GOLD_ORE.get(), RED_SANDSTONE_GOLD_ORE.get(), PINK_STONE_GOLD_ORE.get());
		getBuilder(REDSTONE_ORES).add(END_STONE_REDSTONE_ORE.get());
		getBuilder(QUARTZ_ORES).add(STONE_QUARTZ_ORE.get());
		getBuilder(LAPIS_ORES).add(PINK_STONE_LAPIS_ORE.get());
		getBuilder(DIAMOND_ORES).add(PINK_STONE_DIAMOND_ORE.get());
		getBuilder(CRUXITE_STORAGE_BLOCKS).add(CRUXITE_BLOCK.get());
		getBuilder(END_SAPLING_DIRT).add(Tags.Blocks.END_STONES).add(END_GRASS.get());
	}
	
	@Override
	public String getName()
	{
		return "Minestuck Block Tags";
	}
}
