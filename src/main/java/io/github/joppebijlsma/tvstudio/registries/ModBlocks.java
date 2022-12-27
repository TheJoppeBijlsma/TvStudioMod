package io.github.joppebijlsma.tvstudio.registries;

import io.github.joppebijlsma.tvstudio.TvStudio;
import io.github.joppebijlsma.tvstudio.blocks.*;
import io.github.joppebijlsma.tvstudio.items.ModItemGroup;
import io.github.joppebijlsma.tvstudio.items.PaintableItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.List;
import java.util.function.BiFunction;

import static net.minecraft.block.AbstractBlock.Settings.copy;

public class ModBlocks {
//Blocks without BlockItem


//Blocks with BlockItem
	//Screen Blocks
	public static final Block BLUE_SCREEN_BLOCK = registerBlock("blue_screen_block",
		new Block(FabricBlockSettings.of(Material.STONE).breakInstantly().sounds(BlockSoundGroup.STONE)), ModItemGroup.BLOCKS_GROUP);
	public static final Block GREEN_SCREEN_BLOCK = registerBlock("green_screen_block",
			new Block(FabricBlockSettings.of(Material.STONE).breakInstantly().sounds(BlockSoundGroup.STONE)), ModItemGroup.BLOCKS_GROUP);
	public static final Block BLUE_SCREEN_WALL = registerBlock("blue_screen_wall",
			new WallBlock(FabricBlockSettings.of(Material.WOOL).breakInstantly().sounds(BlockSoundGroup.METAL)), ModItemGroup.BLOCKS_GROUP);
	public static final Block GREEN_SCREEN_WALL = registerBlock("green_screen_wall",
			new WallBlock(FabricBlockSettings.of(Material.WOOL).breakInstantly().sounds(BlockSoundGroup.METAL)), ModItemGroup.BLOCKS_GROUP);

	//Coloured
		public static final Block TV_CAMERA_ON_STAND = registerColouredBlock("tv_camera_on_stand", new TvCameraOnAStand(copy(Blocks.STONE)), PaintableItem::new);
		public static final Block TV_STAND = registerColouredBlock("tv_stand", new TvStand(copy(Blocks.STONE)), PaintableItem::new);
		public static final Block STUDIO_LIGHT = registerColouredBlock("studio_light", new StudioLight(copy(Blocks.STONE)), PaintableItem::new);
		public static final Block STUDIO_BAR = registerColouredBlock("studio_bar", new StudioBar(copy(Blocks.STONE)), PaintableItem::new);
		public static final Block DIRECTOR_CHAIR = registerColouredBlock("director_chair", new DirectorChair(copy(Blocks.STONE)), PaintableItem::new);

	//Non-Coloured
		public static final Block TV_CAMERA = registerBlock("tv_camera",
			new TvCamera(), ModItemGroup.BLOCKS_GROUP);
		public static final Block CHIPBOARD_BLOCK = registerBlock("chipboard_block",
			new Block(FabricBlockSettings.of(Material.WOOD).strength(3f, 3f).sounds(BlockSoundGroup.WOOD)), ModItemGroup.BLOCKS_GROUP);
		public static final Block SET_WALL_SUPPORT = registerBlock("set_wall_support",
			new SetWallSupport(), ModItemGroup.BLOCKS_GROUP);

		//Set Wall
		public static final Block SET_WALL = registerBlock("set_wall", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_STONE = registerBlock("set_wall_stone", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_GRANITE = registerBlock("set_wall_granite", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_POLISHED_GRANITE = registerBlock("set_wall_polished_granite", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DIORITE = registerBlock("set_wall_diorite", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_POLISHED_DIORITE = registerBlock("set_wall_polished_diorite", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_ANDESITE = registerBlock("set_wall_andesite", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_POLISHED_ANDESITE = registerBlock("set_wall_polished_andesite", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DIRT = registerBlock("set_wall_dirt", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_COARSE_DIRT = registerBlock("set_wall_coarse_dirt", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CRIMSON_NYLIUM = registerBlock("set_wall_crimson_nylium", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_WARPED_NYLIUM = registerBlock("set_wall_warped_nylium", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_COBBLESTONE = registerBlock("set_wall_cobblestone", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_OAK_PLANKS = registerBlock("set_wall_oak_planks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_SPRUCE_PLANKS = registerBlock("set_wall_spruce_planks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BIRCH_PLANKS = registerBlock("set_wall_birch_planks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_JUNGLE_PLANKS = registerBlock("set_wall_jungle_planks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_ACACIA_PLANKS = registerBlock("set_wall_acacia_planks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DARK_OAK_PLANKS = registerBlock("set_wall_dark_oak_planks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CRIMSON_PLANKS = registerBlock("set_wall_crimson_planks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_WARPED_PLANKS = registerBlock("set_wall_warped_planks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BEDROCK = registerBlock("set_wall_bedrock", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_SAND = registerBlock("set_wall_sand", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_RED_SAND = registerBlock("set_wall_red_sand", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_GRAVEL = registerBlock("set_wall_gravel", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_GOLD_ORE = registerBlock("set_wall_gold_ore", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_IRON_ORE = registerBlock("set_wall_iron_ore", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_COAL_ORE = registerBlock("set_wall_coal_ore", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_NETHER_GOLD_ORE = registerBlock("set_wall_nether_gold_ore", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_OAK_LOG = registerBlock("set_wall_oak_log", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_SPRUCE_LOG = registerBlock("set_wall_spruce_log", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BIRCH_LOG = registerBlock("set_wall_birch_log", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_JUNGLE_LOG = registerBlock("set_wall_jungle_log", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_ACACIA_LOG = registerBlock("set_wall_acacia_log", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DARK_OAK_LOG = registerBlock("set_wall_dark_oak_log", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CRIMSON_STEM = registerBlock("set_wall_crimson_stem", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_WARPED_STEM = registerBlock("set_wall_warped_stem", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_STRIPPED_OAK_LOG = registerBlock("set_wall_stripped_oak_log", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_STRIPPED_SPRUCE_LOG = registerBlock("set_wall_stripped_spruce_log", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_STRIPPED_BIRCH_LOG = registerBlock("set_wall_stripped_birch_log", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_STRIPPED_JUNGLE_LOG = registerBlock("set_wall_stripped_jungle_log", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_STRIPPED_ACACIA_LOG = registerBlock("set_wall_stripped_acacia_log", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_STRIPPED_DARK_OAK_LOG = registerBlock("set_wall_stripped_dark_oak_log", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_STRIPPED_CRIMSON_STEM = registerBlock("set_wall_stripped_crimson_stem", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_STRIPPED_WARPED_STEM = registerBlock("set_wall_stripped_warped_stem", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_SPONGE = registerBlock("set_wall_sponge", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_WET_SPONGE = registerBlock("set_wall_wet_sponge", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_LAPIS_ORE = registerBlock("set_wall_lapis_ore", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_LAPIS_BLOCK = registerBlock("set_wall_lapis_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DISPENSER = registerBlock("set_wall_dispenser", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_SANDSTONE = registerBlock("set_wall_sandstone", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CHISELED_SANDSTONE = registerBlock("set_wall_chiseled_sandstone", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CUT_SANDSTONE = registerBlock("set_wall_cut_sandstone", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_NOTE_BLOCK = registerBlock("set_wall_note_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_WHITE_WOOL = registerBlock("set_wall_white_wool", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_ORANGE_WOOL = registerBlock("set_wall_orange_wool", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_MAGENTA_WOOL = registerBlock("set_wall_magenta_wool", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_LIGHT_BLUE_WOOL = registerBlock("set_wall_light_blue_wool", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_YELLOW_WOOL = registerBlock("set_wall_yellow_wool", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_LIME_WOOL = registerBlock("set_wall_lime_wool", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_PINK_WOOL = registerBlock("set_wall_pink_wool", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_GRAY_WOOL = registerBlock("set_wall_gray_wool", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_LIGHT_GRAY_WOOL = registerBlock("set_wall_light_gray_wool", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CYAN_WOOL = registerBlock("set_wall_cyan_wool", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_PURPLE_WOOL = registerBlock("set_wall_purple_wool", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BLUE_WOOL = registerBlock("set_wall_blue_wool", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BROWN_WOOL = registerBlock("set_wall_brown_wool", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_GREEN_WOOL = registerBlock("set_wall_green_wool", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_RED_WOOL = registerBlock("set_wall_red_wool", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BLACK_WOOL = registerBlock("set_wall_black_wool", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_GOLD_BLOCK = registerBlock("set_wall_gold_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_IRON_BLOCK = registerBlock("set_wall_iron_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_SMOOTH_QUARTZ = registerBlock("set_wall_smooth_quartz", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_SMOOTH_RED_SANDSTONE = registerBlock("set_wall_smooth_red_sandstone", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_SMOOTH_SANDSTONE = registerBlock("set_wall_smooth_sandstone", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_SMOOTH_STONE = registerBlock("set_wall_smooth_stone", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BRICKS = registerBlock("set_wall_bricks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_TNT = registerBlock("set_wall_tnt", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BOOKSHELF = registerBlock("set_wall_bookshelf", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_MOSSY_COBBLESTONE = registerBlock("set_wall_mossy_cobblestone", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_OBSIDIAN = registerBlock("set_wall_obsidian", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_PURPUR_BLOCK = registerBlock("set_wall_purpur_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_PURPUR_PILLAR = registerBlock("set_wall_purpur_pillar", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DIAMOND_ORE = registerBlock("set_wall_diamond_ore", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DIAMOND_BLOCK = registerBlock("set_wall_diamond_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_REDSTONE_ORE = registerBlock("set_wall_redstone_ore", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_ICE = registerBlock("set_wall_ice", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_SNOW_BLOCK = registerBlock("set_wall_snow_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CLAY = registerBlock("set_wall_clay", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_JUKEBOX = registerBlock("set_wall_jukebox", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_PUMPKIN = registerBlock("set_wall_pumpkin", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CARVED_PUMPKIN = registerBlock("set_wall_carved_pumpkin", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_SOUL_SAND = registerBlock("set_wall_soul_sand", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_SOUL_SOIL = registerBlock("set_wall_soul_soil", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BASALT = registerBlock("set_wall_basalt", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BASALT_TOP = registerBlock("set_wall_basalt_top", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_POLISHED_BASALT = registerBlock("set_wall_polished_basalt", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_POLISHED_BASALT_TOP = registerBlock("set_wall_polished_basalt_top", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_GLOWSTONE = registerBlock("set_wall_glowstone", new LitSetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_STONE_BRICKS = registerBlock("set_wall_stone_bricks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_MOSSY_STONE_BRICKS = registerBlock("set_wall_mossy_stone_bricks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CRACKED_STONE_BRICKS = registerBlock("set_wall_cracked_stone_bricks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CHISELED_STONE_BRICKS = registerBlock("set_wall_chiseled_stone_bricks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BROWN_MUSHROOM_BLOCK = registerBlock("set_wall_brown_mushroom_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_RED_MUSHROOM_BLOCK = registerBlock("set_wall_red_mushroom_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_MUSHROOM_INSIDE = registerBlock("set_wall_mushroom_inside", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_MUSHROOM_STEM = registerBlock("set_wall_mushroom_stem", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_MELON = registerBlock("set_wall_melon", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_MELON_TOP = registerBlock("set_wall_melon_top", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_NETHER_BRICKS = registerBlock("set_wall_nether_bricks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CRACKED_NETHER_BRICKS = registerBlock("set_wall_cracked_nether_bricks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CHISELED_NETHER_BRICKS = registerBlock("set_wall_chiseled_nether_bricks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_END_STONE = registerBlock("set_wall_end_stone", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_END_STONE_BRICKS = registerBlock("set_wall_end_stone_bricks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_EMERALD_ORE = registerBlock("set_wall_emerald_ore", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_EMERALD_BLOCK = registerBlock("set_wall_emerald_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_REDSTONE_BLOCK = registerBlock("set_wall_redstone_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_NETHER_QUARTZ_ORE = registerBlock("set_wall_nether_quartz_ore", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CHISELED_QUARTZ_BLOCK = registerBlock("set_wall_chiseled_quartz_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_QUARTZ_BLOCK = registerBlock("set_wall_quartz_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_QUARTZ_BRICKS = registerBlock("set_wall_quartz_bricks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_QUARTZ_PILLAR = registerBlock("set_wall_quartz_pillar", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_TERRACOTTA = registerBlock("set_wall_terracotta", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_WHITE_TERRACOTTA = registerBlock("set_wall_white_terracotta", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_ORANGE_TERRACOTTA = registerBlock("set_wall_orange_terracotta", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_MAGENTA_TERRACOTTA = registerBlock("set_wall_magenta_terracotta", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_LIGHT_BLUE_TERRACOTTA = registerBlock("set_wall_light_blue_terracotta", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_YELLOW_TERRACOTTA = registerBlock("set_wall_yellow_terracotta", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_LIME_TERRACOTTA = registerBlock("set_wall_lime_terracotta", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_PINK_TERRACOTTA = registerBlock("set_wall_pink_terracotta", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_GRAY_TERRACOTTA = registerBlock("set_wall_gray_terracotta", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_LIGHT_GRAY_TERRACOTTA = registerBlock("set_wall_light_gray_terracotta", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CYAN_TERRACOTTA = registerBlock("set_wall_cyan_terracotta", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_PURPLE_TERRACOTTA = registerBlock("set_wall_purple_terracotta", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BLUE_TERRACOTTA = registerBlock("set_wall_blue_terracotta", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BROWN_TERRACOTTA = registerBlock("set_wall_brown_terracotta", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_GREEN_TERRACOTTA = registerBlock("set_wall_green_terracotta", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_RED_TERRACOTTA = registerBlock("set_wall_red_terracotta", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BLACK_TERRACOTTA = registerBlock("set_wall_black_terracotta", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_HAY_BLOCK = registerBlock("set_wall_hay_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_HAY_BLOCK_TOP = registerBlock("set_wall_hay_block_top", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_COAL_BLOCK = registerBlock("set_wall_coal_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_PACKED_ICE = registerBlock("set_wall_packed_ice", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_PRISMARINE = registerBlock("set_wall_prismarine", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_PRISMARINE_BRICKS = registerBlock("set_wall_prismarine_bricks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DARK_PRISMARINE = registerBlock("set_wall_dark_prismarine", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_SEA_LANTERN = registerBlock("set_wall_sea_lantern", new LitSetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_RED_SANDSTONE = registerBlock("set_wall_red_sandstone", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CHISELED_RED_SANDSTONE = registerBlock("set_wall_chiseled_red_sandstone", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CUT_RED_SANDSTONE = registerBlock("set_wall_cut_red_sandstone", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_MAGMA_BLOCK = registerBlock("set_wall_magma_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_NETHER_WART_BLOCK = registerBlock("set_wall_nether_wart_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_WARPED_WART_BLOCK = registerBlock("set_wall_warped_wart_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_RED_NETHER_BRICKS = registerBlock("set_wall_red_nether_bricks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BONE_BLOCK = registerBlock("set_wall_bone_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_OBSERVER = registerBlock("set_wall_observer", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_WHITE_CONCRETE = registerBlock("set_wall_white_concrete", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_ORANGE_CONCRETE = registerBlock("set_wall_orange_concrete", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_MAGENTA_CONCRETE = registerBlock("set_wall_magenta_concrete", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_LIGHT_BLUE_CONCRETE = registerBlock("set_wall_light_blue_concrete", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_YELLOW_CONCRETE = registerBlock("set_wall_yellow_concrete", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_LIME_CONCRETE = registerBlock("set_wall_lime_concrete", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_PINK_CONCRETE = registerBlock("set_wall_pink_concrete", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_GRAY_CONCRETE = registerBlock("set_wall_gray_concrete", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_LIGHT_GRAY_CONCRETE = registerBlock("set_wall_light_gray_concrete", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CYAN_CONCRETE = registerBlock("set_wall_cyan_concrete", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_PURPLE_CONCRETE = registerBlock("set_wall_purple_concrete", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BLUE_CONCRETE = registerBlock("set_wall_blue_concrete", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BROWN_CONCRETE = registerBlock("set_wall_brown_concrete", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_GREEN_CONCRETE = registerBlock("set_wall_green_concrete", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_RED_CONCRETE = registerBlock("set_wall_red_concrete", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BLACK_CONCRETE = registerBlock("set_wall_black_concrete", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_WHITE_CONCRETE_POWDER = registerBlock("set_wall_white_concrete_powder", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_ORANGE_CONCRETE_POWDER = registerBlock("set_wall_orange_concrete_powder", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_MAGENTA_CONCRETE_POWDER = registerBlock("set_wall_magenta_concrete_powder", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_LIGHT_BLUE_CONCRETE_POWDER = registerBlock("set_wall_light_blue_concrete_powder", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_YELLOW_CONCRETE_POWDER = registerBlock("set_wall_yellow_concrete_powder", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_LIME_CONCRETE_POWDER = registerBlock("set_wall_lime_concrete_powder", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_PINK_CONCRETE_POWDER = registerBlock("set_wall_pink_concrete_powder", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_GRAY_CONCRETE_POWDER = registerBlock("set_wall_gray_concrete_powder", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_LIGHT_GRAY_CONCRETE_POWDER = registerBlock("set_wall_light_gray_concrete_powder", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CYAN_CONCRETE_POWDER = registerBlock("set_wall_cyan_concrete_powder", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_PURPLE_CONCRETE_POWDER = registerBlock("set_wall_purple_concrete_powder", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BLUE_CONCRETE_POWDER = registerBlock("set_wall_blue_concrete_powder", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BROWN_CONCRETE_POWDER = registerBlock("set_wall_brown_concrete_powder", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_GREEN_CONCRETE_POWDER = registerBlock("set_wall_green_concrete_powder", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_RED_CONCRETE_POWDER = registerBlock("set_wall_red_concrete_powder", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BLACK_CONCRETE_POWDER = registerBlock("set_wall_black_concrete_powder", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_TUBE_CORAL_BLOCK = registerBlock("set_wall_tube_coral_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BRAIN_CORAL_BLOCK = registerBlock("set_wall_brain_coral_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BUBBLE_CORAL_BLOCK = registerBlock("set_wall_bubble_coral_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_FIRE_CORAL_BLOCK = registerBlock("set_wall_fire_coral_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_HORN_CORAL_BLOCK = registerBlock("set_wall_horn_coral_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DEAD_TUBE_CORAL_BLOCK = registerBlock("set_wall_dead_tube_coral_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DEAD_BRAIN_CORAL_BLOCK = registerBlock("set_wall_dead_brain_coral_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DEAD_BUBBLE_CORAL_BLOCK = registerBlock("set_wall_dead_bubble_coral_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DEAD_FIRE_CORAL_BLOCK = registerBlock("set_wall_dead_fire_coral_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DEAD_HORN_CORAL_BLOCK = registerBlock("set_wall_dead_horn_coral_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BLUE_ICE = registerBlock("set_wall_blue_ice", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DRIED_KELP_BLOCK = registerBlock("set_wall_dried_kelp_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_COMPOSTER = registerBlock("set_wall_composter", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_SMITHING_TABLE_TOP = registerBlock("set_wall_smithing_table_top", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_SMITHING_TABLE_BOTTOM = registerBlock("set_wall_smithing_table_bottom", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_SHROOMLIGHT = registerBlock("set_wall_shroomlight", new LitSetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BEE_NEST = registerBlock("set_wall_bee_nest", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BEEHIVE = registerBlock("set_wall_beehive", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_HONEYCOMB_BLOCK = registerBlock("set_wall_honeycomb_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_LODESTONE = registerBlock("set_wall_lodestone", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_LODESTONE_TOP = registerBlock("set_wall_lodestone_top", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_NETHERITE_BLOCK = registerBlock("set_wall_netherite_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_ANCIENT_DEBRIS = registerBlock("set_wall_ancient_debris", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_TARGET = registerBlock("set_wall_target", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CRYING_OBSIDIAN = registerBlock("set_wall_crying_obsidian", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_NETHERRACK = registerBlock("set_wall_netherrack", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BLACKSTONE = registerBlock("set_wall_blackstone", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_POLISHED_BLACKSTONE_BRICKS = registerBlock("set_wall_polished_blackstone_bricks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_GILDED_BLACKSTONE = registerBlock("set_wall_gilded_blackstone", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_POLISHED_BLACKSTONE = registerBlock("set_wall_polished_blackstone", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CHISELED_POLISHED_BLACKSTONE = registerBlock("set_wall_chiseled_polished_blackstone", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CRACKED_POLISHED_BLACKSTONE_BRICKS = registerBlock("set_wall_cracked_polished_blackstone_bricks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_SHULKER_BOX = registerBlock("set_wall_shulker_box", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_WHITE_SHULKER_BOX = registerBlock("set_wall_white_shulker_box", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_ORANGE_SHULKER_BOX = registerBlock("set_wall_orange_shulker_box", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_MAGENTA_SHULKER_BOX = registerBlock("set_wall_magenta_shulker_box", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_LIGHT_BLUE_SHULKER_BOX = registerBlock("set_wall_light_blue_shulker_box", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_YELLOW_SHULKER_BOX = registerBlock("set_wall_yellow_shulker_box", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_LIME_SHULKER_BOX = registerBlock("set_wall_lime_shulker_box", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_PINK_SHULKER_BOX = registerBlock("set_wall_pink_shulker_box", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_GRAY_SHULKER_BOX = registerBlock("set_wall_gray_shulker_box", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_LIGHT_GRAY_SHULKER_BOX = registerBlock("set_wall_light_gray_shulker_box", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CYAN_SHULKER_BOX = registerBlock("set_wall_cyan_shulker_box", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_PURPLE_SHULKER_BOX = registerBlock("set_wall_purple_shulker_box", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BLUE_SHULKER_BOX = registerBlock("set_wall_blue_shulker_box", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BROWN_SHULKER_BOX = registerBlock("set_wall_brown_shulker_box", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_GREEN_SHULKER_BOX = registerBlock("set_wall_green_shulker_box", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_RED_SHULKER_BOX = registerBlock("set_wall_red_shulker_box", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BLACK_SHULKER_BOX = registerBlock("set_wall_black_shulker_box", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DEEPSLATE_GOLD_ORE = registerBlock("set_wall_deepslate_gold_ore", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DEEPSLATE_IRON_ORE = registerBlock("set_wall_deepslate_iron_ore", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DEEPSLATE_COAL_ORE = registerBlock("set_wall_deepslate_coal_ore", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DEEPSLATE_LAPIS_ORE = registerBlock("set_wall_deepslate_lapis_ore", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DEEPSLATE_DIAMOND_ORE = registerBlock("set_wall_deepslate_diamond_ore", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DEEPSLATE_REDSTONE_ORE = registerBlock("set_wall_deepslate_redstone_ore", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DEEPSLATE_EMERALD_ORE = registerBlock("set_wall_deepslate_emerald_ore", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DEEPSLATE_COPPER_ORE = registerBlock("set_wall_deepslate_copper_ore", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_AZALEA = registerBlock("set_wall_azalea", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_FLOWERING_AZALEA = registerBlock("set_wall_flowering_azalea", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_MOSS_BLOCK = registerBlock("set_wall_moss_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_ROOTED_DIRT = registerBlock("set_wall_rooted_dirt", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_AMETHYST_BLOCK = registerBlock("set_wall_amethyst_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_BUDDING_AMETHYST = registerBlock("set_wall_budding_amethyst", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_TUFF = registerBlock("set_wall_tuff", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CALCITE = registerBlock("set_wall_calcite", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_POWDER_SNOW = registerBlock("set_wall_powder_snow", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_OXIDIZED_COPPER = registerBlock("set_wall_oxidized_copper", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_WEATHERED_COPPER = registerBlock("set_wall_weathered_copper", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_EXPOSED_COPPER = registerBlock("set_wall_exposed_copper", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_COPPER_BLOCK = registerBlock("set_wall_copper_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_COPPER_ORE = registerBlock("set_wall_copper_ore", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_OXIDIZED_CUT_COPPER = registerBlock("set_wall_oxidized_cut_copper", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_WEATHERED_CUT_COPPER = registerBlock("set_wall_weathered_cut_copper", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_EXPOSED_CUT_COPPER = registerBlock("set_wall_exposed_cut_copper", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CUT_COPPER = registerBlock("set_wall_cut_copper", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DRIPSTONE_BLOCK = registerBlock("set_wall_dripstone_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DEEPSLATE = registerBlock("set_wall_deepslate", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_COBBLED_DEEPSLATE = registerBlock("set_wall_cobbled_deepslate", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_POLISHED_DEEPSLATE = registerBlock("set_wall_polished_deepslate", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DEEPSLATE_TILES = registerBlock("set_wall_deepslate_tiles", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_DEEPSLATE_BRICKS = registerBlock("set_wall_deepslate_bricks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CHISELED_DEEPSLATE = registerBlock("set_wall_chiseled_deepslate", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CRACKED_DEEPSLATE_BRICKS = registerBlock("set_wall_cracked_deepslate_bricks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_CRACKED_DEEPSLATE_TILES = registerBlock("set_wall_cracked_deepslate_tiles", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_SMOOTH_BASALT = registerBlock("set_wall_smooth_basalt", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_RAW_IRON_BLOCK = registerBlock("set_wall_raw_iron_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_RAW_COPPER_BLOCK = registerBlock("set_wall_raw_copper_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_RAW_GOLD_BLOCK = registerBlock("set_wall_raw_gold_block", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_MANGROVE_PLANKS = registerBlock("set_wall_mangrove_planks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_MANGROVE_LOG = registerBlock("set_wall_mangrove_log", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_STRIPPED_MANGROVE_LOG = registerBlock("set_wall_stripped_mangrove_log", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_MUD = registerBlock("set_wall_mud", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_MUDDY_MANGROVE_ROOTS = registerBlock("set_wall_muddy_mangrove_roots", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_PACKED_MUD = registerBlock("set_wall_packed_mud", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_MUD_BRICKS = registerBlock("set_wall_mud_bricks", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_REINFORCED_DEEPSLATE = registerBlock("set_wall_reinforced_deepslate", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_SCULK = registerBlock("set_wall_sculk", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_SCULK_CATALYST = registerBlock("set_wall_sculk_catalyst", new SetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_OCHRE_FROGLIGHT = registerBlock("set_wall_ochre_froglight", new LitSetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_VERDANT_FROGLIGHT = registerBlock("set_wall_verdant_froglight", new LitSetWall(), ModItemGroup.SET_WALL_GROUP);
		public static final Block SET_WALL_PEARLESCENT_FROGLIGHT = registerBlock("set_wall_pearlescent_froglight", new LitSetWall(), ModItemGroup.SET_WALL_GROUP);


	private static Block registerBlockWithoutItem(String name, Block block) {
		return Registry.register(Registry.BLOCK, new Identifier(TvStudio.MOD_ID, name), block);
	}

	private static Block registerBlock(String name, Block block, ItemGroup tab) {
		registerBlockItem(name, block, tab);
		return Registry.register(Registry.BLOCK, new Identifier(TvStudio.MOD_ID, name), block);
	}

	private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
		return Registry.register(Registry.ITEM, new Identifier(TvStudio.MOD_ID, name),
				new BlockItem(block, new FabricItemSettings().group(tab)));
	}

	public static final List<Block> ALL_BLOCKS = List.of(
			STUDIO_BAR,
			DIRECTOR_CHAIR,
			TV_STAND,
			TV_CAMERA_ON_STAND,
			STUDIO_LIGHT
	);

	private static Block registerColouredBlock(String id, Block block, BiFunction<Block, Item.Settings, Item> item) {
		Registry.register(Registry.BLOCK, TvStudio.id(id), block);
		Registry.register(Registry.ITEM, TvStudio.id(id), item.apply(block, new Item.Settings().group(ModItemGroup.BLOCKS_GROUP)));
		return block;
	}

	public static Block[] all() {
		return ALL_BLOCKS.toArray(new Block[0]);
	}

	public static void registerModBlocks() {
		TvStudio.TVSTUDIO_LOGGER.debug("Registering ModBlocks for " + TvStudio.MOD_ID);

	}
}
