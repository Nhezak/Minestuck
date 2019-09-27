package com.mraof.minestuck.block;

import com.mraof.minestuck.Minestuck;
import com.mraof.minestuck.block.multiblock.AlchemiterMultiblock;
import com.mraof.minestuck.block.multiblock.CruxtruderMultiblock;
import com.mraof.minestuck.block.multiblock.PunchDesignixMultiblock;
import com.mraof.minestuck.block.multiblock.TotemLatheMultiblock;
import com.mraof.minestuck.fluid.MSFluids;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.DyeColor;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Minestuck.MOD_ID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class MSBlocks
{
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Minestuck.MOD_ID);
	
	//All block properties that should be reused for multiple blocks, such as for stairs and slab blocks
	public static final Block.Properties COARSE_STONE_PROPERTIES = Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0);
	public static final Block.Properties SHADE_BRICKS_PROPERTIES = Block.Properties.create(Material.ROCK, MaterialColor.BLUE).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0);
	public static final Block.Properties FROST_BRICKS_PROPERTIES = Block.Properties.create(Material.ROCK, MaterialColor.ICE).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0);
	public static final Block.Properties CAST_IRON_PROPERTIES = Block.Properties.create(Material.ROCK, MaterialColor.IRON).hardnessAndResistance(3.0F, 9.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0);
	public static final Block.Properties MYCELIUM_BRICKS_PROPERTIES = Block.Properties.create(Material.ROCK, MaterialColor.MAGENTA).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0);
	public static final Block.Properties CHALK_PROPERTIES = Block.Properties.create(Material.ROCK, MaterialColor.SNOW).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0);
	public static final Block.Properties CHALK_BRICKS_PROPERTIES = Block.Properties.create(Material.ROCK, MaterialColor.SNOW).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0);
	public static final Block.Properties PINK_STONE_BRICKS_PROPERTIES = Block.Properties.create(Material.ROCK, MaterialColor.PINK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0);
	public static final Block.Properties RAINBOW_PLANKS_PROPERTIES = Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD);
	public static final Block.Properties END_PLANKS_PROPERTIES = Block.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD);
	public static final Block.Properties DEAD_PLANKS_PROPERTIES = Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD);
	public static final Block.Properties TREATED_PLANKS_PROPERTIES = Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD);
	
	//
	//Skaia
	public static final RegistryObject<Block> BLACK_CHESS_DIRT = BLOCKS.register("black_chess_dirt", () -> new Block(Block.Properties.create(Material.EARTH, MaterialColor.BLACK).hardnessAndResistance(0.5F).harvestTool(ToolType.SHOVEL).sound(SoundType.GROUND)));
	public static final RegistryObject<Block> WHITE_CHESS_DIRT = BLOCKS.register("white_chess_dirt", () -> new Block(Block.Properties.create(Material.EARTH, MaterialColor.SNOW).hardnessAndResistance(0.5F).harvestTool(ToolType.SHOVEL).sound(SoundType.GROUND)));
	public static final RegistryObject<Block> DARK_GRAY_CHESS_DIRT = BLOCKS.register("dark_gray_chess_dirt", () -> new Block(Block.Properties.create(Material.EARTH, MaterialColor.GRAY).hardnessAndResistance(0.5F).harvestTool(ToolType.SHOVEL).sound(SoundType.GROUND)));
	public static final RegistryObject<Block> LIGHT_GRAY_CHESS_DIRT = BLOCKS.register("light_gray_chess_dirt", () -> new Block(Block.Properties.create(Material.EARTH, MaterialColor.LIGHT_GRAY).hardnessAndResistance(0.5F).harvestTool(ToolType.SHOVEL).sound(SoundType.GROUND)));
	public static final RegistryObject<Block> SKAIA_PORTAL = BLOCKS.register("skaia_portal", () -> new SkaiaPortalBlock(Block.Properties.create(Material.PORTAL, MaterialColor.CYAN).doesNotBlockMovement().lightValue(11).hardnessAndResistance(-1.0F, 3600000.0F)));
	
	//Ores
	public static final RegistryObject<Block> STONE_CRUXITE_ORE = BLOCKS.register("stone_cruxite_ore", () -> new CustomOreBlock(2, 5, Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> COBBLESTONE_CRUXITE_ORE = BLOCKS.register("cobblestone_cruxite_ore", () -> new CustomOreBlock(2, 5, Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> SANDSTONE_CRUXITE_ORE = BLOCKS.register("sandstone_cruxite_ore", () -> new CustomOreBlock(2, 5, Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> RED_SANDSTONE_CRUXITE_ORE = BLOCKS.register("red_sandstone_cruxite_ore", () -> new CustomOreBlock(2, 5, Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> NETHERRACK_CRUXITE_ORE = BLOCKS.register("netherrack_cruxite_ore", () -> new CustomOreBlock(2, 5, Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> END_STONE_CRUXITE_ORE = BLOCKS.register("end_stone_cruxite_ore", () -> new CustomOreBlock(2, 5, Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> PINK_STONE_CRUXITE_ORE = BLOCKS.register("pink_stone_cruxite_ore", () -> new CustomOreBlock(2, 5, Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> STONE_URANIUM_ORE = BLOCKS.register("stone_uranium_ore", () -> new CustomOreBlock(2, 5, Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).lightValue(3)));
	public static final RegistryObject<Block> COBBLESTONE_URANIUM_ORE = BLOCKS.register("cobblestone_uranium_ore", () -> new CustomOreBlock(2, 5, Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).lightValue(3)));
	public static final RegistryObject<Block> SANDSTONE_URANIUM_ORE = BLOCKS.register("sandstone_uranium_ore", () -> new CustomOreBlock(2, 5, Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).lightValue(3)));
	public static final RegistryObject<Block> RED_SANDSTONE_URANIUM_ORE = BLOCKS.register("red_sandstone_uranium_ore", () -> new CustomOreBlock(2, 5, Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).lightValue(3)));
	public static final RegistryObject<Block> NETHERRACK_URANIUM_ORE = BLOCKS.register("netherrack_uranium_ore", () -> new CustomOreBlock(2, 5, Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).lightValue(3)));
	public static final RegistryObject<Block> END_STONE_URANIUM_ORE = BLOCKS.register("end_stone_uranium_ore", () -> new CustomOreBlock(2, 5, Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).lightValue(3)));
	public static final RegistryObject<Block> PINK_STONE_URANIUM_ORE = BLOCKS.register("pink_stone_uranium_ore", () -> new CustomOreBlock(2, 5, Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).lightValue(3)));
	
	public static final RegistryObject<Block> NETHERRACK_COAL_ORE = BLOCKS.register("netherrack_coal_ore", () -> new CustomOreBlock(0, 2, Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> PINK_STONE_COAL_ORE = BLOCKS.register("pink_stone_coal_ore", () -> new CustomOreBlock(0, 2, Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> SANDSTONE_IRON_ORE = BLOCKS.register("sandstone_iron_ore", () -> new CustomOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> RED_SANDSTONE_IRON_ORE = BLOCKS.register("red_sandstone_ore", () -> new CustomOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> END_STONE_IRON_ORE = BLOCKS.register("end_stone_iron_ore", () -> new CustomOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> SANDSTONE_GOLD_ORE = BLOCKS.register("sandstone_gold_ore", () -> new CustomOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> RED_SANDSTONE_GOLD_ORE = BLOCKS.register("red_sandstone_gold_ore", () -> new CustomOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> PINK_STONE_GOLD_ORE = BLOCKS.register("pink_stone_gold_ore", () -> new CustomOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> END_STONE_REDSTONE_ORE = BLOCKS.register("end_stone_redstone_ore", () -> new CustomOreBlock(1, 5, Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> STONE_QUARTZ_ORE = BLOCKS.register("stone_quartz_ore", () -> new CustomOreBlock(2, 5, Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> PINK_STONE_LAPIS_ORE = BLOCKS.register("pink_stone_lapis_ore", () -> new CustomOreBlock(2, 5, Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> PINK_STONE_DIAMOND_ORE = BLOCKS.register("pink_stone_diamond_ore", () -> new CustomOreBlock(3, 7, Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	
	//Resource Blocks
	public static final RegistryObject<Block> CRUXITE_BLOCK = BLOCKS.register("cruxite_block", () -> new Block(Block.Properties.create(Material.ROCK, DyeColor.LIGHT_BLUE).hardnessAndResistance(3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> URANIUM_BLOCK = BLOCKS.register("uranium_block", () -> new Block(Block.Properties.create(Material.ROCK, DyeColor.LIME).hardnessAndResistance(3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).lightValue(7)));
	public static final RegistryObject<Block> GENERIC_OBJECT = BLOCKS.register("generic_object", () -> new Block(Block.Properties.create(Material.GOURD, DyeColor.LIME).hardnessAndResistance(1.0F).sound(SoundType.WOOD)));
	
	//Land Environment Blocks
	public static final RegistryObject<Block> BLUE_DIRT = BLOCKS.register("blue_dirt", () -> new Block(Block.Properties.create(Material.EARTH, MaterialColor.BLUE).hardnessAndResistance(0.5F).lightValue(11).sound(SoundType.GROUND)));
	public static final RegistryObject<Block> THOUGHT_DIRT = BLOCKS.register("thought_dirt", () -> new Block(Block.Properties.create(Material.EARTH, MaterialColor.LIME).hardnessAndResistance(0.5F).lightValue(11).sound(SoundType.GROUND)));
	public static final RegistryObject<Block> COARSE_STONE = BLOCKS.register("coarse_stone", () -> new Block(COARSE_STONE_PROPERTIES));
	public static final RegistryObject<Block> CHISELED_COARSE_STONE = BLOCKS.register("chiseled_coarse_stone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> SHADE_BRICKS = BLOCKS.register("shade_bricks", () -> new Block(SHADE_BRICKS_PROPERTIES));
	public static final RegistryObject<Block> SMOOTH_SHADE_STONE = BLOCKS.register("smooth_shade_stone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.BLUE).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> FROST_BRICKS = BLOCKS.register("frost_bricks", () -> new Block(FROST_BRICKS_PROPERTIES));
	public static final RegistryObject<Block> FROST_TILE = BLOCKS.register("frost_tile", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.ICE).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> CHISELED_FROST_BRICKS = BLOCKS.register("chiseled_frost_bricks", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.ICE).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> CAST_IRON = BLOCKS.register("cast_iron", () -> new Block(CAST_IRON_PROPERTIES));
	public static final RegistryObject<Block> CHISELED_CAST_IRON = BLOCKS.register("chiseled_cast_iron", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.IRON).hardnessAndResistance(3.0F, 9.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> MYCELIUM_BRICKS = BLOCKS.register("mycelium_bricks", () -> new Block(MYCELIUM_BRICKS_PROPERTIES));
	public static final RegistryObject<Block> BLACK_STONE = BLOCKS.register("black_stone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(2.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> FLOWERY_MOSSY_COBBLESTONE = BLOCKS.register("flowery_mossy_cobblestone", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> FLOWERY_MOSSY_STONE_BRICKS = BLOCKS.register("flowery_mossy_stone_bricks", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> COARSE_END_STONE = BLOCKS.register("coarse_end_stone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(3.0F, 9.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> END_GRASS = BLOCKS.register("end_grass", () -> new EndGrassBlock(Block.Properties.create(Material.ROCK, MaterialColor.PURPLE).hardnessAndResistance(3.0F, 9.0F).harvestTool(ToolType.SHOVEL).tickRandomly()));
	public static final RegistryObject<Block> CHALK = BLOCKS.register("chalk", () -> new Block(CHALK_PROPERTIES));
	public static final RegistryObject<Block> POLISHED_CHALK = BLOCKS.register("polished_chalk", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.SNOW).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> CHALK_BRICKS = BLOCKS.register("chalk_bricks", () -> new Block(CHALK_BRICKS_PROPERTIES));
	public static final RegistryObject<Block> CHISELED_CHALK_BRICKS = BLOCKS.register("chiseled_chalk_bricks", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.SNOW).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> PINK_STONE = BLOCKS.register("pink_stone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.PINK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> POLISHED_PINK_STONE = BLOCKS.register("polished_pink_stone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.PINK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> PINK_STONE_BRICKS = BLOCKS.register("pink_stone_bricks", () -> new Block(PINK_STONE_BRICKS_PROPERTIES));
	public static final RegistryObject<Block> CHISELED_PINK_STONE_BRICKS = BLOCKS.register("chiseled_pink_stone_bricks", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.PINK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> CRACKED_PINK_STONE_BRICKS = BLOCKS.register("cracked_pink_stone_bricks", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.PINK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> MOSSY_PINK_STONE_BRICKS = BLOCKS.register("mossy_pink_stone_bricks", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.PINK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0)));
	public static final RegistryObject<Block> DENSE_CLOUD = BLOCKS.register("dense_cloud", () -> new Block(Block.Properties.create(Material.GLASS, MaterialColor.YELLOW).hardnessAndResistance(0.5F).sound(SoundType.SNOW)));
	public static final RegistryObject<Block> BRIGHT_DENSE_CLOUD = BLOCKS.register("bright_dense_cloud", () -> new Block(Block.Properties.create(Material.GLASS, MaterialColor.LIGHT_GRAY).hardnessAndResistance(0.5F).sound(SoundType.SNOW)));
	public static final RegistryObject<Block> SUGAR_CUBE = BLOCKS.register("sugar_cube", () -> new Block(Block.Properties.create(Material.SAND, MaterialColor.SNOW).hardnessAndResistance(0.4F).sound(SoundType.SAND)));
	
	//Land Tree Blocks
	public static final RegistryObject<Block> GLOWING_LOG = BLOCKS.register("glowing_log", () -> new FlammableLogBlock(MaterialColor.LIGHT_BLUE, Block.Properties.create(Material.WOOD, MaterialColor.LIGHT_BLUE).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).lightValue(11).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GLOWING_WOOD = BLOCKS.register("glowing_wood", () -> new FlammableLogBlock(MaterialColor.LIGHT_BLUE, Block.Properties.create(Material.WOOD, MaterialColor.LIGHT_BLUE).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).lightValue(11).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GLOWING_PLANKS = BLOCKS.register("glowing_planks", () -> new FlammableBlock(5, 20, Block.Properties.create(Material.WOOD, MaterialColor.LIGHT_BLUE).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).lightValue(7).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> FROST_LOG = BLOCKS.register("frost_log", () -> new FlammableLogBlock(MaterialColor.ICE, Block.Properties.create(Material.WOOD, MaterialColor.ICE).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> FROST_WOOD = BLOCKS.register("frost_wood", () -> new FlammableLogBlock(MaterialColor.ICE, Block.Properties.create(Material.WOOD, MaterialColor.ICE).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> FROST_PLANKS = BLOCKS.register("frost_planks", () -> new FlammableBlock(5, 5, Block.Properties.create(Material.WOOD, MaterialColor.ICE).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> FROST_LEAVES = BLOCKS.register("frost_leaves", () -> new FlammableLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> RAINBOW_LOG = BLOCKS.register("rainbow_log", () -> new FlammableLogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RAINBOW_WOOD = BLOCKS.register("rainbow_wood", () -> new FlammableLogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RAINBOW_PLANKS = BLOCKS.register("rainbow_planks", () -> new FlammableBlock(5, 20, RAINBOW_PLANKS_PROPERTIES));
	public static final RegistryObject<Block> RAINBOW_LEAVES = BLOCKS.register("rainbow_leaves", () -> new FlammableLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> RAINBOW_SAPLING = BLOCKS.register("rainbow_sapling", () -> new RainbowSaplingBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)));
	public static final RegistryObject<Block> END_LOG = BLOCKS.register("end_log", () -> new DoubleLogBlock(MaterialColor.SAND, 1, 250, Block.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> END_WOOD = BLOCKS.register("end_wood", () -> new FlammableLogBlock(MaterialColor.SAND, 1, 250, Block.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> END_PLANKS = BLOCKS.register("end_planks", () -> new FlammableBlock(1, 250, END_PLANKS_PROPERTIES));
	public static final RegistryObject<Block> END_LEAVES = BLOCKS.register("end_leaves", () -> new EndLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> END_SAPLING = BLOCKS.register("end_sapling", () -> new EndSaplingBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)));
	public static final RegistryObject<Block> VINE_LOG = BLOCKS.register("vine_log", () -> new FlammableLogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> VINE_WOOD = BLOCKS.register("vine_wood", () -> new FlammableLogBlock(MaterialColor.OBSIDIAN, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> FLOWERY_VINE_LOG = BLOCKS.register("flowery_vine_log", () -> new FlammableLogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> FLOWERY_VINE_WOOD = BLOCKS.register("flowery_vine_wood", () -> new FlammableLogBlock(MaterialColor.OBSIDIAN, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> DEAD_LOG = BLOCKS.register("dead_log", () -> new FlammableLogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> DEAD_WOOD = BLOCKS.register("dead_wood", () -> new FlammableLogBlock(MaterialColor.OBSIDIAN, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> DEAD_PLANKS = BLOCKS.register("dead_planks", () -> new FlammableBlock(5, 5, DEAD_PLANKS_PROPERTIES));
	public static final RegistryObject<Block> PETRIFIED_LOG = BLOCKS.register("petrified_log", () -> new FlammableLogBlock(MaterialColor.WOOD, 0, 0, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PETRIFIED_WOOD = BLOCKS.register("petrified_wood", () -> new FlammableLogBlock(MaterialColor.OBSIDIAN, 0, 0, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> TREATED_PLANKS = BLOCKS.register("treated_planks", () -> new FlammableBlock(1, 0, TREATED_PLANKS_PROPERTIES));
	
	//Aspect Tree Blocks
	public static final RegistryObject<Block> BLOOD_ASPECT_LOG = BLOCKS.register("blood_aspect_log", () -> new FlammableLogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BLOOD_ASPECT_PLANKS = BLOCKS.register("blood_aspect_planks", () -> new FlammableBlock(5, 20, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BLOOD_ASPECT_LEAVES = BLOCKS.register("blood_aspect_leaves", () -> new FlammableLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> BLOOD_ASPECT_SAPLING = BLOCKS.register("blood_aspect_sapling", () -> new AspectSaplingBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)));
	public static final RegistryObject<Block> BREATH_ASPECT_LOG = BLOCKS.register("breath_aspect_log", () -> new FlammableLogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BREATH_ASPECT_PLANKS = BLOCKS.register("breath_aspect_planks", () -> new FlammableBlock(5, 20, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BREATH_ASPECT_LEAVES = BLOCKS.register("breath_aspect_leaves", () -> new FlammableLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> BREATH_ASPECT_SAPLING = BLOCKS.register("breath_aspect_sapling", () -> new AspectSaplingBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)));
	public static final RegistryObject<Block> DOOM_ASPECT_LOG = BLOCKS.register("doom_aspect_log", () -> new FlammableLogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> DOOM_ASPECT_PLANKS = BLOCKS.register("doom_aspect_planks", () -> new FlammableBlock(5, 20, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> DOOM_ASPECT_LEAVES = BLOCKS.register("doom_aspect_leaves", () -> new FlammableLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> DOOM_ASPECT_SAPLING = BLOCKS.register("doom_aspect_sapling", () -> new AspectSaplingBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)));
	public static final RegistryObject<Block> HEART_ASPECT_LOG = BLOCKS.register("heart_aspect_log", () -> new FlammableLogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> HEART_ASPECT_PLANKS = BLOCKS.register("heart_aspect_planks", () -> new FlammableBlock(5, 20, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> HEART_ASPECT_LEAVES = BLOCKS.register("heart_aspect_leaves", () -> new FlammableLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> HEART_ASPECT_SAPLING = BLOCKS.register("heart_aspect_sapling", () -> new AspectSaplingBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)));
	public static final RegistryObject<Block> HOPE_ASPECT_LOG = BLOCKS.register("hope_aspect_log", () -> new FlammableLogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> HOPE_ASPECT_PLANKS = BLOCKS.register("hope_aspect_planks", () -> new FlammableBlock(5, 20, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> HOPE_ASPECT_LEAVES = BLOCKS.register("hope_aspect_leaves", () -> new FlammableLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> HOPE_ASPECT_SAPLING = BLOCKS.register("hope_aspect_sapling", () -> new AspectSaplingBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)));
	public static final RegistryObject<Block> LIFE_ASPECT_LOG = BLOCKS.register("life_aspect_log", () -> new FlammableLogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LIFE_ASPECT_PLANKS = BLOCKS.register("life_aspect_planks", () -> new FlammableBlock(5, 20, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LIFE_ASPECT_LEAVES = BLOCKS.register("life_aspect_leaves", () -> new FlammableLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> LIFE_ASPECT_SAPLING = BLOCKS.register("life_aspect_sapling", () -> new AspectSaplingBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)));
	public static final RegistryObject<Block> LIGHT_ASPECT_LOG = BLOCKS.register("light_aspect_log", () -> new FlammableLogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LIGHT_ASPECT_PLANKS = BLOCKS.register("light_aspect_planks", () -> new FlammableBlock(5, 20, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LIGHT_ASPECT_LEAVES = BLOCKS.register("light_aspect_leaves", () -> new FlammableLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> LIGHT_ASPECT_SAPLING = BLOCKS.register("light_aspect_sapling", () -> new AspectSaplingBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)));
	public static final RegistryObject<Block> MIND_ASPECT_LOG = BLOCKS.register("mind_aspect_log", () -> new FlammableLogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> MIND_ASPECT_PLANKS = BLOCKS.register("mind_aspect_planks", () -> new FlammableBlock(5, 20, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> MIND_ASPECT_LEAVES = BLOCKS.register("mind_aspect_leaves", () -> new FlammableLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> MIND_ASPECT_SAPLING = BLOCKS.register("mind_aspect_sapling", () -> new AspectSaplingBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)));
	public static final RegistryObject<Block> RAGE_ASPECT_LOG = BLOCKS.register("rage_aspect_log", () -> new FlammableLogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RAGE_ASPECT_PLANKS = BLOCKS.register("rage_aspect_planks", () -> new FlammableBlock(5, 20, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RAGE_ASPECT_LEAVES = BLOCKS.register("rage_aspect_leaves", () -> new FlammableLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> RAGE_ASPECT_SAPLING = BLOCKS.register("rage_aspect_sapling", () -> new AspectSaplingBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)));
	public static final RegistryObject<Block> SPACE_ASPECT_LOG = BLOCKS.register("space_aspect_log", () -> new FlammableLogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SPACE_ASPECT_PLANKS = BLOCKS.register("space_aspect_planks", () -> new FlammableBlock(5, 20, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SPACE_ASPECT_LEAVES = BLOCKS.register("space_aspect_leaves", () -> new FlammableLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> SPACE_ASPECT_SAPLING = BLOCKS.register("space_aspect_sapling", () -> new AspectSaplingBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)));
	public static final RegistryObject<Block> TIME_ASPECT_LOG = BLOCKS.register("time_aspect_log", () -> new FlammableLogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> TIME_ASPECT_PLANKS = BLOCKS.register("time_aspect_planks", () -> new FlammableBlock(5, 20, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> TIME_ASPECT_LEAVES = BLOCKS.register("time_aspect_leaves", () -> new FlammableLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> TIME_ASPECT_SAPLING = BLOCKS.register("time_aspect_sapling", () -> new AspectSaplingBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)));
	public static final RegistryObject<Block> VOID_ASPECT_LOG = BLOCKS.register("void_aspect_log", () -> new FlammableLogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> VOID_ASPECT_PLANKS = BLOCKS.register("void_aspect_planks", () -> new FlammableBlock(5, 20, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> VOID_ASPECT_LEAVES = BLOCKS.register("void_aspect_leaves", () -> new FlammableLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> VOID_ASPECT_SAPLING = BLOCKS.register("void_aspect_sapling", () -> new AspectSaplingBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)));
	
	//Land Plant Blocks
	public static final RegistryObject<Block> GLOWING_MUSHROOM = BLOCKS.register("glowing_mushroom", () -> new GlowingMushroomBlock(Block.Properties.create(Material.PLANTS, MaterialColor.DIAMOND).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT).lightValue(11)));
	public static final RegistryObject<Block> DESERT_BUSH = BLOCKS.register("desert_bush", () -> new DesertFloraBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));
	public static final RegistryObject<Block> BLOOMING_CACTUS = BLOCKS.register("blooming_cactus", () -> new DesertFloraBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));
	public static final RegistryObject<Block> PETRIFIED_GRASS = BLOCKS.register("petrified_grass", () -> new PetrifiedFloraBlock(Block.Properties.create(Material.ROCK, DyeColor.GRAY).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PETRIFIED_POPPY = BLOCKS.register("petrified_poppy", () -> new PetrifiedFloraBlock(Block.Properties.create(Material.ROCK, DyeColor.GRAY).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.STONE)));
	public static final RegistryObject<StemGrownBlock> STRAWBERRY = BLOCKS.register("strawberry", () -> new StrawberryBlock(Block.Properties.create(Material.GOURD, MaterialColor.RED).hardnessAndResistance(1.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<StemBlock> STRAWBERRY_STEM = BLOCKS.register("strawberry_stem", () -> new StrawberryBlock.Stem(STRAWBERRY, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.WOOD)));
	public static final RegistryObject<AttachedStemBlock> ATTACHED_STRAWBERRY_STEM = BLOCKS.register("attached_strawberry_stem", () -> new StrawberryBlock.AttachedStem(STRAWBERRY, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.WOOD)));
	
	//Special Land Blocks
	public static final RegistryObject<Block> LAYERED_SAND = BLOCKS.register("layered_sand", () -> new LayeredBlock(Block.Properties.from(Blocks.SAND)));
	public static final RegistryObject<Block> LAYERED_RED_SAND = BLOCKS.register("layered_red_sand", () -> new LayeredBlock(Block.Properties.from(Blocks.RED_SAND)));
	public static final RegistryObject<Block> GLOWING_GOOP = BLOCKS.register("glowing_goop", () -> new GoopBlock(Block.Properties.create(Material.CLAY).hardnessAndResistance(0.1F).sound(SoundType.SLIME).lightValue(14)));
	public static final RegistryObject<Block> COAGULATED_BLOOD = BLOCKS.register("coagulated_blood", () -> new GoopBlock(Block.Properties.create(Material.CLAY).hardnessAndResistance(0.1F).sound(SoundType.SLIME)));
	public static final RegistryObject<Block> VEIN = BLOCKS.register("vein", () -> new VeinBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.45F).sound(SoundType.SLIME)));
	public static final RegistryObject<Block> VEIN_CORNER = BLOCKS.register("vein_corner", () -> new VeinCornerBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.45F).sound(SoundType.SLIME)));
	public static final RegistryObject<Block> INVERTED_VEIN_CORNER = BLOCKS.register("inverted_vein_corner", () -> new VeinCornerBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.45F).sound(SoundType.SLIME)));
	
	//Structure Land Blocks
	public static final RegistryObject<Block> COARSE_STONE_STAIRS = BLOCKS.register("coarse_stone_stairs", () -> new ModStairsBlock(COARSE_STONE.lazyMap(Block::getDefaultState), COARSE_STONE_PROPERTIES));
	public static final RegistryObject<Block> SHADE_BRICK_STAIRS = BLOCKS.register("shade_brick_stairs", () -> new ModStairsBlock(SHADE_BRICKS.lazyMap(Block::getDefaultState), SHADE_BRICKS_PROPERTIES));
	public static final RegistryObject<Block> FROST_BRICK_STAIRS = BLOCKS.register("frost_brick_stairs", () -> new ModStairsBlock(FROST_BRICKS.lazyMap(Block::getDefaultState), FROST_BRICKS_PROPERTIES));
	public static final RegistryObject<Block> CAST_IRON_STAIRS = BLOCKS.register("cast_iron_stairs", () -> new ModStairsBlock(CAST_IRON.lazyMap(Block::getDefaultState), CAST_IRON_PROPERTIES));
	public static final RegistryObject<Block> MYCELIUM_BRICK_STAIRS = BLOCKS.register("mycelium_brick_stairs", () -> new ModStairsBlock(MYCELIUM_BRICKS.lazyMap(Block::getDefaultState), MYCELIUM_BRICKS_PROPERTIES));
	public static final RegistryObject<Block> CHALK_STAIRS = BLOCKS.register("chalk_stairs", () -> new ModStairsBlock(CHALK.lazyMap(Block::getDefaultState), CHALK_PROPERTIES));
	public static final RegistryObject<Block> CHALK_SLAB = BLOCKS.register("chalk_slab", () -> new SlabBlock(CHALK_PROPERTIES));
	public static final RegistryObject<Block> CHALK_BRICK_STAIRS = BLOCKS.register("chalk_brick_stairs", () -> new ModStairsBlock(CHALK_BRICKS.lazyMap(Block::getDefaultState), CHALK_BRICKS_PROPERTIES));
	public static final RegistryObject<Block> CHALK_BRICK_SLAB = BLOCKS.register("chalk_brick_slab", () -> new SlabBlock(CHALK_BRICKS_PROPERTIES));
	public static final RegistryObject<Block> PINK_STONE_BRICK_STAIRS = BLOCKS.register("pink_stone_brick_stairs", () -> new ModStairsBlock(PINK_STONE_BRICKS.lazyMap(Block::getDefaultState), PINK_STONE_BRICKS_PROPERTIES));
	public static final RegistryObject<Block> PINK_STONE_BRICK_SLAB = BLOCKS.register("pink_stone_Brick_slab", () -> new SlabBlock(PINK_STONE_BRICKS_PROPERTIES));
	public static final RegistryObject<Block> RAINBOW_PLANKS_STAIRS = BLOCKS.register("rainbow_planks_stairs", () -> new ModStairsBlock(RAINBOW_PLANKS.lazyMap(Block::getDefaultState), RAINBOW_PLANKS_PROPERTIES));
	public static final RegistryObject<Block> RAINBOW_PLANKS_SLAB = BLOCKS.register("rainbow_planks_slab", () -> new SlabBlock(RAINBOW_PLANKS_PROPERTIES));
	public static final RegistryObject<Block> END_PLANKS_STAIRS = BLOCKS.register("end_planks_stairs", () -> new ModStairsBlock(END_PLANKS.lazyMap(Block::getDefaultState), END_PLANKS_PROPERTIES));
	public static final RegistryObject<Block> END_PLANKS_SLAB = BLOCKS.register("end_planks_slab", () -> new SlabBlock(END_PLANKS_PROPERTIES));
	public static final RegistryObject<Block> DEAD_PLANKS_STAIRS = BLOCKS.register("dead_planks_stairs", () -> new ModStairsBlock(DEAD_PLANKS.lazyMap(Block::getDefaultState), DEAD_PLANKS_PROPERTIES));
	public static final RegistryObject<Block> DEAD_PLANKS_SLAB = BLOCKS.register("dead_planks_slab", () -> new SlabBlock(DEAD_PLANKS_PROPERTIES));
	public static final RegistryObject<Block> TREATED_PLANKS_STAIRS = BLOCKS.register("treated_planks_stairs", () -> new ModStairsBlock(TREATED_PLANKS.lazyMap(Block::getDefaultState), TREATED_PLANKS_PROPERTIES));
	public static final RegistryObject<Block> TREATED_PLANKS_SLAB = BLOCKS.register("treated_planks_slab", () -> new SlabBlock(TREATED_PLANKS_PROPERTIES));
	
	//Core Functional Land Blocks
	public static final RegistryObject<Block> GATE = BLOCKS.register("gate", () -> new GateBlock(Block.Properties.create(Material.PORTAL).doesNotBlockMovement().hardnessAndResistance(-1.0F, 25.0F).sound(SoundType.GLASS).lightValue(11)));
	public static final RegistryObject<Block> RETURN_NODE = BLOCKS.register("return_node", () -> new ReturnNodeBlock(Block.Properties.create(Material.PORTAL).doesNotBlockMovement().hardnessAndResistance(-1.0F, 10.0F).sound(SoundType.GLASS).lightValue(11)));
	
	//Misc Functional Land Blocks
	public static final RegistryObject<Block> RABBIT_SPAWNER = BLOCKS.register("rabbit_spawner", () -> new MobSpawnerBlock(Block.Properties.create(Material.AIR).tickRandomly().doesNotBlockMovement()));
	
	//Sburb Machines
	public static final CruxtruderMultiblock CRUXTRUDER = new CruxtruderMultiblock(BLOCKS, "cruxtruder");
	public static final RegistryObject<Block> CRUXTRUDER_LID = BLOCKS.register("cruxtruder_lid", () -> new CruxtruderLidBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.0F)));
	public static final TotemLatheMultiblock TOTEM_LATHE = new TotemLatheMultiblock(BLOCKS, "totem_lathe");
	public static final AlchemiterMultiblock ALCHEMITER = new AlchemiterMultiblock(BLOCKS, "alchemiter");
	public static final PunchDesignixMultiblock PUNCH_DESIGNIX = new PunchDesignixMultiblock(BLOCKS, "punch_designix");
	public static final RegistryObject<Block> MINI_CRUXTRUDER = BLOCKS.register("mini_cruxtruder", () -> new MiniCruxtruderBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
	public static final RegistryObject<Block> MINI_TOTEM_LATHE = BLOCKS.register("mini_totem_lathe", () -> new MiniTotemLatheBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
	public static final RegistryObject<Block> MINI_ALCHEMITER = BLOCKS.register("mini_alchemiter", () -> new MiniAlchemiterBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
	public static final RegistryObject<Block> MINI_PUNCH_DESIGNIX = BLOCKS.register("mini_punch_designix", () -> new MiniPunchDesignixBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
	//public static final RegistryObject<Block> HOLOPAD = BLOCKS.register("holopad", () -> new BlockHolopad(Block.Properties.create(Material.IRON, MaterialColor.SNOW).hardnessAndResistance(3.0F)));
	
	//Misc Machines
	public static final RegistryObject<Block> COMPUTER_OFF = BLOCKS.register("computer_off", () -> new ComputerOffBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(4.0F), MSBlocks.COMPUTER_ON, ComputerOffBlock.COMPUTER_SHAPE, ComputerOffBlock.COMPUTER_COLLISION_SHAPE));
	public static final RegistryObject<Block> COMPUTER_ON = BLOCKS.register("computer_on", () -> new ComputerOnBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(4.0F), ComputerOffBlock.COMPUTER_SHAPE, ComputerOffBlock.COMPUTER_COLLISION_SHAPE, MSBlocks.COMPUTER_OFF));
	public static final RegistryObject<Block> LAPTOP_OFF = BLOCKS.register("laptop_off", () -> new ComputerOffBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(4.0F), MSBlocks.LAPTOP_ON, ComputerOffBlock.LAPTOP_SHAPE, ComputerOffBlock.LAPTOP_COLLISION_SHAPE));
	public static final RegistryObject<Block> LAPTOP_ON = BLOCKS.register("laptop_on", () -> new ComputerOnBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(4.0F), ComputerOffBlock.LAPTOP_SHAPE, ComputerOffBlock.LAPTOP_COLLISION_SHAPE, MSBlocks.LAPTOP_OFF));
	public static final RegistryObject<Block> CROCKERTOP_OFF = BLOCKS.register("crockertop_off", () -> new ComputerOffBlock(Block.Properties.create(Material.IRON, MaterialColor.RED).hardnessAndResistance(4.0F), MSBlocks.CROCKERTOP_ON, ComputerOffBlock.LAPTOP_SHAPE, ComputerOffBlock.LAPTOP_COLLISION_SHAPE));
	public static final RegistryObject<Block> CROCKERTOP_ON = BLOCKS.register("crockertop_on", () -> new ComputerOnBlock(Block.Properties.create(Material.IRON, MaterialColor.RED).hardnessAndResistance(4.0F), ComputerOffBlock.LAPTOP_SHAPE, ComputerOffBlock.LAPTOP_COLLISION_SHAPE, MSBlocks.CROCKERTOP_OFF));
	public static final RegistryObject<Block> HUBTOP_OFF = BLOCKS.register("hubtop_off", () -> new ComputerOffBlock(Block.Properties.create(Material.IRON, MaterialColor.GREEN).hardnessAndResistance(4.0F), MSBlocks.HUBTOP_ON, ComputerOffBlock.LAPTOP_SHAPE, ComputerOffBlock.LAPTOP_COLLISION_SHAPE));
	public static final RegistryObject<Block> HUBTOP_ON = BLOCKS.register("hubtop_on", () -> new ComputerOnBlock(Block.Properties.create(Material.IRON, MaterialColor.GREEN).hardnessAndResistance(4.0F), ComputerOffBlock.LAPTOP_SHAPE, ComputerOffBlock.LAPTOP_COLLISION_SHAPE, MSBlocks.HUBTOP_OFF));
	public static final RegistryObject<Block> LUNCHTOP_OFF = BLOCKS.register("lunchtop_off", () -> new ComputerOffBlock(Block.Properties.create(Material.IRON, MaterialColor.RED).hardnessAndResistance(4.0F), MSBlocks.LUNCHTOP_ON, ComputerOffBlock.LUNCHTOP_SHAPE, ComputerOffBlock.LUNCHTOP_SHAPE));
	public static final RegistryObject<Block> LUNCHTOP_ON = BLOCKS.register("lunchtop_on", () -> new ComputerOnBlock(Block.Properties.create(Material.IRON, MaterialColor.RED).hardnessAndResistance(4.0F), ComputerOffBlock.LUNCHTOP_SHAPE, ComputerOffBlock.LUNCHTOP_SHAPE, MSBlocks.LUNCHTOP_OFF));
	public static final RegistryObject<Block> TRANSPORTALIZER = BLOCKS.register("transportalizer", () -> new TransportalizerBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
	public static final RegistryObject<Block> GRIST_WIDGET = BLOCKS.register("grist_widget", () -> new GristWidgetBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
	public static final RegistryObject<Block> URANIUM_COOKER = BLOCKS.register("uranium_cooker", () -> new UraniumCookerBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F)));
	
	//Misc Core Objects
	public static final RegistryObject<Block> CRUXITE_DOWEL = BLOCKS.register("cruxite_dowel", () -> new CruxiteDowelBlock(Block.Properties.create(Material.GLASS).hardnessAndResistance(0.0F)));
	
	//Misc Alchemy Semi-Plants
	public static final RegistryObject<Block> GOLD_SEEDS = BLOCKS.register("gold_seeds", () -> new GoldSeedsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.1F).sound(SoundType.METAL).doesNotBlockMovement()));
	public static final RegistryObject<Block> WOODEN_CACTUS = BLOCKS.register("wooden_cactus", () -> new SpecialCactusBlock(Block.Properties.create(Material.WOOD).tickRandomly().hardnessAndResistance(1.0F, 2.5F).sound(SoundType.WOOD), ToolType.AXE));
	
	//Cakes
	public static final RegistryObject<Block> APPLE_CAKE = BLOCKS.register("apple_cake", () -> new SimpleCakeBlock(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH), 2, 0.5F, null));
	public static final RegistryObject<Block> BLUE_CAKE = BLOCKS.register("blue_cake", () -> new SimpleCakeBlock(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH), 2, 0.3F, player -> player.addPotionEffect(new EffectInstance(Effects.SPEED, 150, 0))));
	public static final RegistryObject<Block> COLD_CAKE = BLOCKS.register("cold_cake", () -> new SimpleCakeBlock(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH), 2, 0.3F, player -> {player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 200, 1));player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 200, 1));}));
	public static final RegistryObject<Block> RED_CAKE = BLOCKS.register("red_cake", () -> new SimpleCakeBlock(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH), 2, 0.1F, player -> player.heal(1)));
	public static final RegistryObject<Block> HOT_CAKE = BLOCKS.register("hot_cake", () -> new SimpleCakeBlock(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH), 2, 0.1F, player -> player.setFire(4)));
	public static final RegistryObject<Block> REVERSE_CAKE = BLOCKS.register("reverse_cake", () -> new SimpleCakeBlock(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH), 2, 0.1F, null));
	public static final RegistryObject<Block> FUCHSIA_CAKE = BLOCKS.register("fuchsia_cake", () -> new SimpleCakeBlock(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH), 3, 0.5F, player -> {player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 350, 1));player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 200, 0));}));
	
	//Explosion and Redstone
	public static final RegistryObject<Block> PRIMED_TNT = BLOCKS.register("primed_tnt", () -> new SpecialTNTBlock(Block.Properties.create(Material.TNT).hardnessAndResistance(0.0F).sound(SoundType.PLANT), true, false, false));
	public static final RegistryObject<Block> UNSTABLE_TNT = BLOCKS.register("unstable_tnt", () -> new SpecialTNTBlock(Block.Properties.create(Material.TNT).hardnessAndResistance(0.0F).sound(SoundType.PLANT).tickRandomly(), false, true, false));
	public static final RegistryObject<Block> INSTANT_TNT = BLOCKS.register("instant_tnt", () -> new SpecialTNTBlock(Block.Properties.create(Material.TNT).hardnessAndResistance(0.0F).sound(SoundType.PLANT), false, false, true));
	public static final RegistryObject<Block> WOODEN_EXPLOSIVE_BUTTON = BLOCKS.register("wooden_explosive_button", () -> new SpecialButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD), true, true));
	public static final RegistryObject<Block> STONE_EXPLOSIVE_BUTTON = BLOCKS.register("stone_explosive_button", () -> new SpecialButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.STONE), true, false));
	
	//Misc Alchemy Objects
	public static final RegistryObject<Block> BLENDER = BLOCKS.register("blender", () -> new DecorBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5F).sound(SoundType.METAL), DecorBlockShapes.BLENDER_SHAPE));
	public static final RegistryObject<Block> CHESSBOARD = BLOCKS.register("chessboard", () -> new DecorBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5F), DecorBlockShapes.CHESSBOARD_SHAPE));
	public static final RegistryObject<Block> MINI_FROG_STATUE = BLOCKS.register("mini_frog_statue", () -> new DecorBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5F), DecorBlockShapes.FROG_STATUE_SHAPE));
	public static final RegistryObject<Block> GLOWYSTONE_DUST = BLOCKS.register("glowystone_dust", () -> new GlowystoneWireBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0F).lightValue(16).doesNotBlockMovement()));
	
	public static final RegistryObject<FlowingFluidBlock> OIL = BLOCKS.register("oil", () -> new FlowingModFluidBlock(MSFluids.OIL, new Vec3d(0.0, 0.0, 0.0), Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
	public static final RegistryObject<FlowingFluidBlock> LIGHT_WATER = BLOCKS.register("light_water", () -> new FlowingModFluidBlock(MSFluids.LIGHT_WATER, new Vec3d(0.2, 0.3, 1.0), Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
	public static final RegistryObject<FlowingFluidBlock> BLOOD = BLOCKS.register("blood", () -> new FlowingModFluidBlock(MSFluids.BLOOD, new Vec3d(0.8, 0.0, 0.0), Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
	public static final RegistryObject<FlowingFluidBlock> BRAIN_JUICE = BLOCKS.register("brain_juice", () -> new FlowingModFluidBlock(MSFluids.BRAIN_JUICE, new Vec3d(0.55, 0.25, 0.7), Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
	public static final RegistryObject<FlowingFluidBlock> WATER_COLORS = BLOCKS.register("water_colors", () -> new FlowingWaterColorsBlock(MSFluids.WATER_COLORS, Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
	public static final RegistryObject<FlowingFluidBlock> ENDER = BLOCKS.register("ender", () -> new FlowingModFluidBlock(MSFluids.ENDER, Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
}