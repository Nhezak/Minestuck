package com.mraof.minestuck.data;

import com.mraof.minestuck.util.ExtraForgeTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;

import static com.mraof.minestuck.block.MinestuckBlocks.*;
import static com.mraof.minestuck.util.MinestuckTags.Blocks.*;
import static net.minecraft.tags.BlockTags.*;
import static net.minecraftforge.common.Tags.*;

public class MinestuckBlockTagsProvider extends BlockTagsProvider
{
	MinestuckBlockTagsProvider(DataGenerator generatorIn)
	{
		super(generatorIn);
	}
	
	@Override
	protected void registerTags()
	{
		getBuilder(PLANKS).add(GLOWING_PLANKS, FROST_PLANKS, RAINBOW_PLANKS, END_PLANKS, DEAD_PLANKS, TREATED_PLANKS).add(ASPECT_PLANKS);
		getBuilder(STONE_BRICKS).add(FLOWERY_MOSSY_STONE_BRICKS);
		getBuilder(WOODEN_BUTTONS).add(WOODEN_EXPLOSIVE_BUTTON);
		getBuilder(BUTTONS).add(STONE_EXPLOSIVE_BUTTON);
		getBuilder(WOODEN_STAIRS).add(RAINBOW_PLANKS_STAIRS, END_PLANKS_STAIRS, DEAD_PLANKS_STAIRS, TREATED_PLANKS_STAIRS);
		getBuilder(WOODEN_SLABS).add(RAINBOW_PLANKS_SLAB, END_PLANKS_SLAB, DEAD_PLANKS_SLAB, TREATED_PLANKS_SLAB);
		getBuilder(SAPLINGS).add(RAINBOW_SAPLING, END_SAPLING).add(ASPECT_SAPLINGS);
		getBuilder(LOGS).add(GLOWING_LOGS, FROST_LOGS, RAINBOW_LOGS, END_LOGS, VINE_LOGS, FLOWERY_VINE_LOGS, DEAD_LOGS, PETRIFIED_LOGS, ASPECT_LOGS);
		getBuilder(ENDERMAN_HOLDABLE).add(BLUE_DIRT, THOUGHT_DIRT);
		getBuilder(STAIRS).add(COARSE_STONE_STAIRS, SHADE_BRICK_STAIRS, FROST_BRICK_STAIRS, CAST_IRON_STAIRS, MYCELIUM_BRICK_STAIRS, CHALK_STAIRS, CHALK_BRICK_STAIRS, PINK_STONE_BRICK_STAIRS);
		getBuilder(SLABS).add(CHALK_SLAB, CHALK_BRICK_SLAB, PINK_STONE_BRICK_SLAB);
		getBuilder(LEAVES).add(FROST_LEAVES, RAINBOW_LEAVES, END_LEAVES).add(ASPECT_LEAVES);
		getBuilder(DIRT_LIKE).add(BLACK_CHESS_DIRT, WHITE_CHESS_DIRT, DARK_GRAY_CHESS_DIRT, LIGHT_GRAY_CHESS_DIRT, BLUE_DIRT, THOUGHT_DIRT);
		getBuilder(Blocks.COBBLESTONE).add(FLOWERY_MOSSY_COBBLESTONE);
		getBuilder(Blocks.ORES).add(CRUXITE_ORES, ExtraForgeTags.Blocks.URANIUM_ORES);
		getBuilder(Blocks.ORES_COAL).add(COAL_ORES);
		getBuilder(Blocks.ORES_DIAMOND).add(DIAMOND_ORES);
		getBuilder(Blocks.ORES_GOLD).add(GOLD_ORES);
		getBuilder(Blocks.ORES_IRON).add(IRON_ORES);
		getBuilder(Blocks.ORES_LAPIS).add(LAPIS_ORES);
		getBuilder(Blocks.ORES_QUARTZ).add(QUARTZ_ORES);
		getBuilder(Blocks.ORES_REDSTONE).add(REDSTONE_ORES);
		getBuilder(Blocks.STONE).add(COARSE_STONE, BLACK_STONE, COARSE_END_STONE, PINK_STONE);
		getBuilder(Blocks.STORAGE_BLOCKS).add(CRUXITE_STORAGE_BLOCKS, ExtraForgeTags.Blocks.URANIUM_STORAGE_BLOCKS);
		
		getBuilder(ExtraForgeTags.Blocks.URANIUM_ORES).add(URANIUM_ORES);
		getBuilder(ExtraForgeTags.Blocks.URANIUM_STORAGE_BLOCKS).add(URANIUM_BLOCK);
		
		getBuilder(GLOWING_LOGS).add(GLOWING_LOG, GLOWING_WOOD);
		getBuilder(FROST_LOGS).add(FROST_LOG, FROST_WOOD);
		getBuilder(RAINBOW_LOGS).add(RAINBOW_LOG, RAINBOW_WOOD);
		getBuilder(END_LOGS).add(END_LOG, END_WOOD);
		getBuilder(VINE_LOGS).add(VINE_LOG, VINE_WOOD);
		getBuilder(FLOWERY_VINE_LOGS).add(FLOWERY_VINE_LOG, FLOWERY_VINE_WOOD);
		getBuilder(DEAD_LOGS).add(DEAD_LOG, DEAD_WOOD);
		getBuilder(PETRIFIED_LOGS).add(PETRIFIED_LOG, PETRIFIED_WOOD);
		getBuilder(ASPECT_LOGS).add(BLOOD_ASPECT_LOG, BREATH_ASPECT_LOG, DOOM_ASPECT_LOG, HEART_ASPECT_LOG, HOPE_ASPECT_LOG, LIFE_ASPECT_LOG, LIGHT_ASPECT_LOG, MIND_ASPECT_LOG, RAGE_ASPECT_LOG, SPACE_ASPECT_LOG, TIME_ASPECT_LOG, VOID_ASPECT_LOG);
		getBuilder(ASPECT_PLANKS).add(BLOOD_ASPECT_PLANKS, BREATH_ASPECT_PLANKS, DOOM_ASPECT_PLANKS, HEART_ASPECT_PLANKS, HOPE_ASPECT_PLANKS, LIFE_ASPECT_PLANKS, LIGHT_ASPECT_PLANKS, MIND_ASPECT_PLANKS, RAGE_ASPECT_PLANKS, SPACE_ASPECT_PLANKS, TIME_ASPECT_PLANKS, VOID_ASPECT_PLANKS);
		getBuilder(ASPECT_LEAVES).add(BLOOD_ASPECT_LEAVES, BREATH_ASPECT_LEAVES, DOOM_ASPECT_LEAVES, HEART_ASPECT_LEAVES, HOPE_ASPECT_LEAVES, LIFE_ASPECT_LEAVES, LIGHT_ASPECT_LEAVES, MIND_ASPECT_LEAVES, RAGE_ASPECT_LEAVES, SPACE_ASPECT_LEAVES, TIME_ASPECT_LEAVES, VOID_ASPECT_LEAVES);
		getBuilder(ASPECT_SAPLINGS).add(BLOOD_ASPECT_SAPLING, BREATH_ASPECT_SAPLING, DOOM_ASPECT_SAPLING, HEART_ASPECT_SAPLING, HOPE_ASPECT_SAPLING, LIFE_ASPECT_SAPLING, LIGHT_ASPECT_SAPLING, MIND_ASPECT_SAPLING, RAGE_ASPECT_SAPLING, SPACE_ASPECT_SAPLING, TIME_ASPECT_SAPLING, VOID_ASPECT_SAPLING);
		getBuilder(CRUXITE_ORES).add(STONE_CRUXITE_ORE, NETHERRACK_CRUXITE_ORE, COBBLESTONE_CRUXITE_ORE, SANDSTONE_CRUXITE_ORE, RED_SANDSTONE_CRUXITE_ORE, END_STONE_CRUXITE_ORE, PINK_STONE_CRUXITE_ORE);
		getBuilder(URANIUM_ORES).add(STONE_URANIUM_ORE, NETHERRACK_URANIUM_ORE, COBBLESTONE_URANIUM_ORE, SANDSTONE_URANIUM_ORE, RED_SANDSTONE_URANIUM_ORE, END_STONE_URANIUM_ORE, PINK_STONE_URANIUM_ORE);
		getBuilder(COAL_ORES).add(NETHERRACK_COAL_ORE, PINK_STONE_COAL_ORE);
		getBuilder(IRON_ORES).add(END_STONE_IRON_ORE, SANDSTONE_IRON_ORE, RED_SANDSTONE_IRON_ORE);
		getBuilder(GOLD_ORES).add(SANDSTONE_GOLD_ORE, RED_SANDSTONE_GOLD_ORE, PINK_STONE_GOLD_ORE);
		getBuilder(REDSTONE_ORES).add(END_STONE_REDSTONE_ORE);
		getBuilder(QUARTZ_ORES).add(STONE_QUARTZ_ORE);
		getBuilder(LAPIS_ORES).add(PINK_STONE_LAPIS_ORE);
		getBuilder(DIAMOND_ORES).add(PINK_STONE_DIAMOND_ORE);
		getBuilder(CRUXITE_STORAGE_BLOCKS).add(CRUXITE_BLOCK);
	}
	
	@Override
	public String getName()
	{
		return "Minestuck Block Tags";
	}
}
