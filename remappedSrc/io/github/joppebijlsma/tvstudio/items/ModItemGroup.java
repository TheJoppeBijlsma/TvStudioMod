package io.github.joppebijlsma.tvstudio.items;

import io.github.joppebijlsma.tvstudio.TvStudio;
import io.github.joppebijlsma.tvstudio.registries.ModBlocks;
import io.github.joppebijlsma.tvstudio.registries.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import static io.github.joppebijlsma.tvstudio.registries.ModItems.ALL_DYEABLE_BLOCKS;
import static io.github.joppebijlsma.tvstudio.registries.ModItems.ALL_DYEABLE_ITEMS;

public class ModItemGroup {

    public static final ItemGroup BLOCKS_GROUP = FabricItemGroup.builder(TvStudio.id("studio_blocks"))
            .entries((enabledFeatures, entries, operatorEnabled) -> {

                entries.add(ModBlocks.CHIPBOARD_BLOCK);
                entries.add(ModBlocks.SET_WALL_SUPPORT);
                entries.add(ModBlocks.GREEN_SCREEN_BLOCK);
                entries.add(ModBlocks.GREEN_SCREEN_WALL);
                entries.add(ModBlocks.BLUE_SCREEN_BLOCK);
                entries.add(ModBlocks.BLUE_SCREEN_WALL);
                entries.add(ModBlocks.TV_CAMERA);

                for (Item item : ALL_DYEABLE_BLOCKS) {
                    TsDyeableItem.appendStacks(item, entries::add);
                }
            })

            .icon(() -> {
                ItemStack stack = new ItemStack(ModBlocks.TV_CAMERA_ON_STAND);
                TsDyeableItem.setColor(stack, DyeColor.LIGHT_BLUE);
                return stack;
            })
            .build();

    public static final ItemGroup ITEMS_GROUP = FabricItemGroup.builder(TvStudio.id("studio_items"))
            .entries((enabledFeatures, entries, operatorEnabled) -> {

                entries.add(ModItems.LENS);
                entries.add(ModItems.CLAPBOARD);
                entries.add(ModItems.BOOMPOLE_MICROPHONE);
                entries.add(ModItems.HEADSET);
                entries.add(ModItems.IRON_STICK);
                entries.add(ModItems.POLE);
                entries.add(ModItems.TV_STAND_HEAD);
                entries.add(ModItems.WASHING_TOWEL);
                entries.add(ModItems.BLUE_NEON_ORB);
                entries.add(ModItems.BLUE_SCREEN_DYE);
                entries.add(ModItems.GREEN_NEON_ORB);
                entries.add(ModItems.GREEN_SCREEN_DYE);

                for (Item item : ALL_DYEABLE_ITEMS) {
                    TsDyeableItem.appendStacks(item, entries::add);
                }
            })
            .icon(() -> {
                ItemStack stack = new ItemStack(ModItems.LENS);
                return stack;
            })
            .build();

    public static final ItemGroup SET_WALL_GROUP = FabricItemGroup.builder(new Identifier(TvStudio.MOD_ID, "studio_set_walls"))
            .icon(() -> new ItemStack(ModBlocks.SET_WALL))
            .entries((enabledFeatures, entries, operatorEnabled) -> {
                entries.add(ModBlocks.SET_WALL);
                entries.add(ModBlocks.SET_WALL_OAK_LOG);
                entries.add(ModBlocks.SET_WALL_STRIPPED_OAK_LOG);
                entries.add(ModBlocks.SET_WALL_OAK_PLANKS);
                entries.add(ModBlocks.SET_WALL_SPRUCE_LOG);
                entries.add(ModBlocks.SET_WALL_STRIPPED_SPRUCE_LOG);
                entries.add(ModBlocks.SET_WALL_SPRUCE_PLANKS);
                entries.add(ModBlocks.SET_WALL_BIRCH_LOG);
                entries.add(ModBlocks.SET_WALL_STRIPPED_BIRCH_LOG);
                entries.add(ModBlocks.SET_WALL_BIRCH_PLANKS);
                entries.add(ModBlocks.SET_WALL_JUNGLE_LOG);
                entries.add(ModBlocks.SET_WALL_STRIPPED_JUNGLE_LOG);
                entries.add(ModBlocks.SET_WALL_JUNGLE_PLANKS);
                entries.add(ModBlocks.SET_WALL_ACACIA_LOG);
                entries.add(ModBlocks.SET_WALL_STRIPPED_ACACIA_LOG);
                entries.add(ModBlocks.SET_WALL_ACACIA_PLANKS);
                entries.add(ModBlocks.SET_WALL_DARK_OAK_LOG);
                entries.add(ModBlocks.SET_WALL_STRIPPED_DARK_OAK_LOG);
                entries.add(ModBlocks.SET_WALL_DARK_OAK_PLANKS);
                entries.add(ModBlocks.SET_WALL_MANGROVE_LOG);
                entries.add(ModBlocks.SET_WALL_STRIPPED_MANGROVE_LOG);
                entries.add(ModBlocks.SET_WALL_MANGROVE_PLANKS);
                entries.add(ModBlocks.SET_WALL_CRIMSON_STEM);
                entries.add(ModBlocks.SET_WALL_STRIPPED_CRIMSON_STEM);
                entries.add(ModBlocks.SET_WALL_CRIMSON_PLANKS);
                entries.add(ModBlocks.SET_WALL_WARPED_STEM);
                entries.add(ModBlocks.SET_WALL_STRIPPED_WARPED_STEM);
                entries.add(ModBlocks.SET_WALL_WARPED_PLANKS);
                entries.add(ModBlocks.SET_WALL_STONE);
                entries.add(ModBlocks.SET_WALL_COBBLESTONE);
                entries.add(ModBlocks.SET_WALL_MOSSY_COBBLESTONE);
                entries.add(ModBlocks.SET_WALL_STONE_BRICKS);
                entries.add(ModBlocks.SET_WALL_CRACKED_STONE_BRICKS);
                entries.add(ModBlocks.SET_WALL_CHISELED_STONE_BRICKS);
                entries.add(ModBlocks.SET_WALL_MOSSY_STONE_BRICKS);
                entries.add(ModBlocks.SET_WALL_GRANITE);
                entries.add(ModBlocks.SET_WALL_POLISHED_GRANITE);
                entries.add(ModBlocks.SET_WALL_DIORITE);
                entries.add(ModBlocks.SET_WALL_POLISHED_DIORITE);
                entries.add(ModBlocks.SET_WALL_ANDESITE);
                entries.add(ModBlocks.SET_WALL_POLISHED_ANDESITE);
                entries.add(ModBlocks.SET_WALL_DEEPSLATE);
                entries.add(ModBlocks.SET_WALL_COBBLED_DEEPSLATE);
                entries.add(ModBlocks.SET_WALL_CHISELED_DEEPSLATE);
                entries.add(ModBlocks.SET_WALL_POLISHED_DEEPSLATE);
                entries.add(ModBlocks.SET_WALL_DEEPSLATE_BRICKS);
                entries.add(ModBlocks.SET_WALL_CRACKED_DEEPSLATE_BRICKS);
                entries.add(ModBlocks.SET_WALL_DEEPSLATE_TILES);
                entries.add(ModBlocks.SET_WALL_CRACKED_DEEPSLATE_TILES);
                entries.add(ModBlocks.SET_WALL_REINFORCED_DEEPSLATE);
                entries.add(ModBlocks.SET_WALL_BRICKS);
                entries.add(ModBlocks.SET_WALL_PACKED_MUD);
                entries.add(ModBlocks.SET_WALL_MUD_BRICKS);
                entries.add(ModBlocks.SET_WALL_SANDSTONE);
                entries.add(ModBlocks.SET_WALL_CHISELED_SANDSTONE);
                entries.add(ModBlocks.SET_WALL_SMOOTH_SANDSTONE);
                entries.add(ModBlocks.SET_WALL_CUT_SANDSTONE);
                entries.add(ModBlocks.SET_WALL_RED_SANDSTONE);
                entries.add(ModBlocks.SET_WALL_CHISELED_RED_SANDSTONE);
                entries.add(ModBlocks.SET_WALL_SMOOTH_RED_SANDSTONE);
                entries.add(ModBlocks.SET_WALL_CUT_RED_SANDSTONE);
                entries.add(ModBlocks.SET_WALL_SEA_LANTERN);
                entries.add(ModBlocks.SET_WALL_PRISMARINE);
                entries.add(ModBlocks.SET_WALL_PRISMARINE_BRICKS);
                entries.add(ModBlocks.SET_WALL_DARK_PRISMARINE);
                entries.add(ModBlocks.SET_WALL_NETHERRACK);
                entries.add(ModBlocks.SET_WALL_NETHER_BRICKS);
                entries.add(ModBlocks.SET_WALL_CRACKED_NETHER_BRICKS);
                entries.add(ModBlocks.SET_WALL_CHISELED_NETHER_BRICKS);
                entries.add(ModBlocks.SET_WALL_RED_NETHER_BRICKS);
                entries.add(ModBlocks.SET_WALL_BASALT);
                entries.add(ModBlocks.SET_WALL_SMOOTH_BASALT);
                entries.add(ModBlocks.SET_WALL_POLISHED_BASALT);
                entries.add(ModBlocks.SET_WALL_BLACKSTONE);
                entries.add(ModBlocks.SET_WALL_GILDED_BLACKSTONE);
                entries.add(ModBlocks.SET_WALL_CHISELED_POLISHED_BLACKSTONE);
                entries.add(ModBlocks.SET_WALL_POLISHED_BLACKSTONE);
                entries.add(ModBlocks.SET_WALL_POLISHED_BLACKSTONE_BRICKS);
                entries.add(ModBlocks.SET_WALL_CRACKED_POLISHED_BLACKSTONE_BRICKS);
                entries.add(ModBlocks.SET_WALL_END_STONE);
                entries.add(ModBlocks.SET_WALL_END_STONE_BRICKS);
                entries.add(ModBlocks.SET_WALL_PURPUR_BLOCK);
                entries.add(ModBlocks.SET_WALL_PURPUR_PILLAR);
                entries.add(ModBlocks.SET_WALL_COAL_BLOCK);
                entries.add(ModBlocks.SET_WALL_IRON_BLOCK);
                entries.add(ModBlocks.SET_WALL_GOLD_BLOCK);
                entries.add(ModBlocks.SET_WALL_REDSTONE_BLOCK);
                entries.add(ModBlocks.SET_WALL_EMERALD_BLOCK);
                entries.add(ModBlocks.SET_WALL_LAPIS_BLOCK);
                entries.add(ModBlocks.SET_WALL_DIAMOND_BLOCK);
                entries.add(ModBlocks.SET_WALL_NETHERITE_BLOCK);
                entries.add(ModBlocks.SET_WALL_QUARTZ_BLOCK);
                entries.add(ModBlocks.SET_WALL_CHISELED_QUARTZ_BLOCK);
                entries.add(ModBlocks.SET_WALL_QUARTZ_BRICKS);
                entries.add(ModBlocks.SET_WALL_QUARTZ_PILLAR);
                entries.add(ModBlocks.SET_WALL_SMOOTH_QUARTZ);
                entries.add(ModBlocks.SET_WALL_COPPER_BLOCK);
                entries.add(ModBlocks.SET_WALL_CUT_COPPER);
                entries.add(ModBlocks.SET_WALL_EXPOSED_COPPER);
                entries.add(ModBlocks.SET_WALL_EXPOSED_CUT_COPPER);
                entries.add(ModBlocks.SET_WALL_WEATHERED_COPPER);
                entries.add(ModBlocks.SET_WALL_WEATHERED_CUT_COPPER);
                entries.add(ModBlocks.SET_WALL_OXIDIZED_COPPER);
                entries.add(ModBlocks.SET_WALL_OXIDIZED_CUT_COPPER);

                //entries.add(ItemStack.EMPTY);

                entries.add(ModBlocks.SET_WALL_WHITE_WOOL);
                entries.add(ModBlocks.SET_WALL_LIGHT_GRAY_WOOL);
                entries.add(ModBlocks.SET_WALL_GRAY_WOOL);
                entries.add(ModBlocks.SET_WALL_BLACK_WOOL);
                entries.add(ModBlocks.SET_WALL_BROWN_WOOL);
                entries.add(ModBlocks.SET_WALL_RED_WOOL);
                entries.add(ModBlocks.SET_WALL_ORANGE_WOOL);
                entries.add(ModBlocks.SET_WALL_YELLOW_WOOL);
                entries.add(ModBlocks.SET_WALL_LIME_WOOL);
                entries.add(ModBlocks.SET_WALL_GREEN_WOOL);
                entries.add(ModBlocks.SET_WALL_CYAN_WOOL);
                entries.add(ModBlocks.SET_WALL_LIGHT_BLUE_WOOL);
                entries.add(ModBlocks.SET_WALL_BLUE_WOOL);
                entries.add(ModBlocks.SET_WALL_PURPLE_WOOL);
                entries.add(ModBlocks.SET_WALL_MAGENTA_WOOL);
                entries.add(ModBlocks.SET_WALL_PINK_WOOL);
                entries.add(ModBlocks.SET_WALL_TERRACOTTA);
                entries.add(ModBlocks.SET_WALL_WHITE_TERRACOTTA);
                entries.add(ModBlocks.SET_WALL_LIGHT_GRAY_TERRACOTTA);
                entries.add(ModBlocks.SET_WALL_GRAY_TERRACOTTA);
                entries.add(ModBlocks.SET_WALL_BLACK_TERRACOTTA);
                entries.add(ModBlocks.SET_WALL_BROWN_TERRACOTTA);
                entries.add(ModBlocks.SET_WALL_RED_TERRACOTTA);
                entries.add(ModBlocks.SET_WALL_ORANGE_TERRACOTTA);
                entries.add(ModBlocks.SET_WALL_YELLOW_TERRACOTTA);
                entries.add(ModBlocks.SET_WALL_LIME_TERRACOTTA);
                entries.add(ModBlocks.SET_WALL_GREEN_TERRACOTTA);
                entries.add(ModBlocks.SET_WALL_CYAN_TERRACOTTA);
                entries.add(ModBlocks.SET_WALL_LIGHT_BLUE_TERRACOTTA);
                entries.add(ModBlocks.SET_WALL_BLUE_TERRACOTTA);
                entries.add(ModBlocks.SET_WALL_PURPLE_TERRACOTTA);
                entries.add(ModBlocks.SET_WALL_MAGENTA_TERRACOTTA);
                entries.add(ModBlocks.SET_WALL_PINK_TERRACOTTA);
                entries.add(ModBlocks.SET_WALL_WHITE_CONCRETE);
                entries.add(ModBlocks.SET_WALL_LIGHT_GRAY_CONCRETE);
                entries.add(ModBlocks.SET_WALL_GRAY_CONCRETE);
                entries.add(ModBlocks.SET_WALL_BLACK_CONCRETE);
                entries.add(ModBlocks.SET_WALL_BROWN_CONCRETE);
                entries.add(ModBlocks.SET_WALL_RED_CONCRETE);
                entries.add(ModBlocks.SET_WALL_ORANGE_CONCRETE);
                entries.add(ModBlocks.SET_WALL_YELLOW_CONCRETE);
                entries.add(ModBlocks.SET_WALL_LIME_CONCRETE);
                entries.add(ModBlocks.SET_WALL_GREEN_CONCRETE);
                entries.add(ModBlocks.SET_WALL_CYAN_CONCRETE);
                entries.add(ModBlocks.SET_WALL_LIGHT_BLUE_CONCRETE);
                entries.add(ModBlocks.SET_WALL_BLUE_CONCRETE);
                entries.add(ModBlocks.SET_WALL_PURPLE_CONCRETE);
                entries.add(ModBlocks.SET_WALL_MAGENTA_CONCRETE);
                entries.add(ModBlocks.SET_WALL_PINK_CONCRETE);
                entries.add(ModBlocks.SET_WALL_WHITE_CONCRETE_POWDER);
                entries.add(ModBlocks.SET_WALL_LIGHT_GRAY_CONCRETE_POWDER);
                entries.add(ModBlocks.SET_WALL_GRAY_CONCRETE_POWDER);
                entries.add(ModBlocks.SET_WALL_BLACK_CONCRETE_POWDER);
                entries.add(ModBlocks.SET_WALL_BROWN_CONCRETE_POWDER);
                entries.add(ModBlocks.SET_WALL_RED_CONCRETE_POWDER);
                entries.add(ModBlocks.SET_WALL_ORANGE_CONCRETE_POWDER);
                entries.add(ModBlocks.SET_WALL_YELLOW_CONCRETE_POWDER);
                entries.add(ModBlocks.SET_WALL_LIME_CONCRETE_POWDER);
                entries.add(ModBlocks.SET_WALL_GREEN_CONCRETE_POWDER);
                entries.add(ModBlocks.SET_WALL_CYAN_CONCRETE_POWDER);
                entries.add(ModBlocks.SET_WALL_LIGHT_BLUE_CONCRETE_POWDER);
                entries.add(ModBlocks.SET_WALL_BLUE_CONCRETE_POWDER);
                entries.add(ModBlocks.SET_WALL_PURPLE_CONCRETE_POWDER);
                entries.add(ModBlocks.SET_WALL_MAGENTA_CONCRETE_POWDER);
                entries.add(ModBlocks.SET_WALL_PINK_CONCRETE_POWDER);
                entries.add(ModBlocks.SET_WALL_WHITE_SHULKER_BOX);
                entries.add(ModBlocks.SET_WALL_LIGHT_GRAY_SHULKER_BOX);
                entries.add(ModBlocks.SET_WALL_GRAY_SHULKER_BOX);
                entries.add(ModBlocks.SET_WALL_BLACK_SHULKER_BOX);
                entries.add(ModBlocks.SET_WALL_BROWN_SHULKER_BOX);
                entries.add(ModBlocks.SET_WALL_RED_SHULKER_BOX);
                entries.add(ModBlocks.SET_WALL_ORANGE_SHULKER_BOX);
                entries.add(ModBlocks.SET_WALL_YELLOW_SHULKER_BOX);
                entries.add(ModBlocks.SET_WALL_LIME_SHULKER_BOX);
                entries.add(ModBlocks.SET_WALL_GREEN_SHULKER_BOX);
                entries.add(ModBlocks.SET_WALL_CYAN_SHULKER_BOX);
                entries.add(ModBlocks.SET_WALL_LIGHT_BLUE_SHULKER_BOX);
                entries.add(ModBlocks.SET_WALL_BLUE_SHULKER_BOX);
                entries.add(ModBlocks.SET_WALL_PURPLE_SHULKER_BOX);
                entries.add(ModBlocks.SET_WALL_MAGENTA_SHULKER_BOX);
                entries.add(ModBlocks.SET_WALL_PINK_SHULKER_BOX);

                //entries.add(ItemStack.EMPTY);

                entries.add(ModBlocks.SET_WALL_DIRT);
                entries.add(ModBlocks.SET_WALL_COARSE_DIRT);
                entries.add(ModBlocks.SET_WALL_ROOTED_DIRT);
                entries.add(ModBlocks.SET_WALL_MUD);
                entries.add(ModBlocks.SET_WALL_CLAY);
                entries.add(ModBlocks.SET_WALL_GRAVEL);
                entries.add(ModBlocks.SET_WALL_SAND);
                entries.add(ModBlocks.SET_WALL_RED_SAND);
                entries.add(ModBlocks.SET_WALL_ICE);
                entries.add(ModBlocks.SET_WALL_PACKED_ICE);
                entries.add(ModBlocks.SET_WALL_BLUE_ICE);
                entries.add(ModBlocks.SET_WALL_SNOW_BLOCK);
                entries.add(ModBlocks.SET_WALL_POWDER_SNOW);
                entries.add(ModBlocks.SET_WALL_MOSS_BLOCK);
                entries.add(ModBlocks.SET_WALL_CALCITE);
                entries.add(ModBlocks.SET_WALL_TUFF);
                entries.add(ModBlocks.SET_WALL_DRIPSTONE_BLOCK);
                entries.add(ModBlocks.SET_WALL_MAGMA_BLOCK);
                entries.add(ModBlocks.SET_WALL_OBSIDIAN);
                entries.add(ModBlocks.SET_WALL_CRYING_OBSIDIAN);
                entries.add(ModBlocks.SET_WALL_CRIMSON_NYLIUM);
                entries.add(ModBlocks.SET_WALL_WARPED_NYLIUM);
                entries.add(ModBlocks.SET_WALL_SOUL_SAND);
                entries.add(ModBlocks.SET_WALL_SOUL_SOIL);
                entries.add(ModBlocks.SET_WALL_BONE_BLOCK);
                entries.add(ModBlocks.SET_WALL_COAL_ORE);
                entries.add(ModBlocks.SET_WALL_DEEPSLATE_COAL_ORE);
                entries.add(ModBlocks.SET_WALL_IRON_ORE);
                entries.add(ModBlocks.SET_WALL_DEEPSLATE_IRON_ORE);
                entries.add(ModBlocks.SET_WALL_COPPER_ORE);
                entries.add(ModBlocks.SET_WALL_DEEPSLATE_COPPER_ORE);
                entries.add(ModBlocks.SET_WALL_GOLD_ORE);
                entries.add(ModBlocks.SET_WALL_DEEPSLATE_GOLD_ORE);
                entries.add(ModBlocks.SET_WALL_REDSTONE_ORE);
                entries.add(ModBlocks.SET_WALL_DEEPSLATE_REDSTONE_ORE);
                entries.add(ModBlocks.SET_WALL_EMERALD_ORE);
                entries.add(ModBlocks.SET_WALL_DEEPSLATE_EMERALD_ORE);
                entries.add(ModBlocks.SET_WALL_LAPIS_ORE);
                entries.add(ModBlocks.SET_WALL_DEEPSLATE_LAPIS_ORE);
                entries.add(ModBlocks.SET_WALL_DIAMOND_ORE);
                entries.add(ModBlocks.SET_WALL_DEEPSLATE_DIAMOND_ORE);
                entries.add(ModBlocks.SET_WALL_NETHER_GOLD_ORE);
                entries.add(ModBlocks.SET_WALL_NETHER_QUARTZ_ORE);
                entries.add(ModBlocks.SET_WALL_ANCIENT_DEBRIS);
                entries.add(ModBlocks.SET_WALL_RAW_IRON_BLOCK);
                entries.add(ModBlocks.SET_WALL_RAW_COPPER_BLOCK);
                entries.add(ModBlocks.SET_WALL_RAW_GOLD_BLOCK);
                entries.add(ModBlocks.SET_WALL_GLOWSTONE);
                entries.add(ModBlocks.SET_WALL_AMETHYST_BLOCK);
                entries.add(ModBlocks.SET_WALL_BUDDING_AMETHYST);
                entries.add(ModBlocks.SET_WALL_MUSHROOM_STEM);
                entries.add(ModBlocks.SET_WALL_MUDDY_MANGROVE_ROOTS);
                entries.add(ModBlocks.SET_WALL_BROWN_MUSHROOM_BLOCK);
                entries.add(ModBlocks.SET_WALL_RED_MUSHROOM_BLOCK);
                entries.add(ModBlocks.SET_WALL_NETHER_WART_BLOCK);
                entries.add(ModBlocks.SET_WALL_WARPED_WART_BLOCK);
                entries.add(ModBlocks.SET_WALL_SHROOMLIGHT);
                entries.add(ModBlocks.SET_WALL_AZALEA);
                entries.add(ModBlocks.SET_WALL_FLOWERING_AZALEA);
                entries.add(ModBlocks.SET_WALL_DRIED_KELP_BLOCK);
                entries.add(ModBlocks.SET_WALL_TUBE_CORAL_BLOCK);
                entries.add(ModBlocks.SET_WALL_BRAIN_CORAL_BLOCK);
                entries.add(ModBlocks.SET_WALL_BUBBLE_CORAL_BLOCK);
                entries.add(ModBlocks.SET_WALL_FIRE_CORAL_BLOCK);
                entries.add(ModBlocks.SET_WALL_HORN_CORAL_BLOCK);
                entries.add(ModBlocks.SET_WALL_DEAD_TUBE_CORAL_BLOCK);
                entries.add(ModBlocks.SET_WALL_DEAD_BRAIN_CORAL_BLOCK);
                entries.add(ModBlocks.SET_WALL_DEAD_BUBBLE_CORAL_BLOCK);
                entries.add(ModBlocks.SET_WALL_DEAD_FIRE_CORAL_BLOCK);
                entries.add(ModBlocks.SET_WALL_DEAD_HORN_CORAL_BLOCK);
                entries.add(ModBlocks.SET_WALL_SPONGE);
                entries.add(ModBlocks.SET_WALL_WET_SPONGE);
                entries.add(ModBlocks.SET_WALL_MELON);
                entries.add(ModBlocks.SET_WALL_PUMPKIN);
                entries.add(ModBlocks.SET_WALL_CARVED_PUMPKIN);
                entries.add(ModBlocks.SET_WALL_HAY_BLOCK);
                entries.add(ModBlocks.SET_WALL_BEE_NEST);
                entries.add(ModBlocks.SET_WALL_BEEHIVE);
                entries.add(ModBlocks.SET_WALL_HONEYCOMB_BLOCK);
                entries.add(ModBlocks.SET_WALL_OCHRE_FROGLIGHT);
                entries.add(ModBlocks.SET_WALL_VERDANT_FROGLIGHT);
                entries.add(ModBlocks.SET_WALL_PEARLESCENT_FROGLIGHT);
                entries.add(ModBlocks.SET_WALL_SCULK);
                entries.add(ModBlocks.SET_WALL_SCULK_CATALYST);
                entries.add(ModBlocks.SET_WALL_BEDROCK);

                //entries.add(ItemStack.EMPTY);

                entries.add(ModBlocks.SET_WALL_SMITHING_TABLE_TOP);
                entries.add(ModBlocks.SET_WALL_SMITHING_TABLE_BOTTOM);
                entries.add(ModBlocks.SET_WALL_COMPOSTER);
                entries.add(ModBlocks.SET_WALL_NOTE_BLOCK);
                entries.add(ModBlocks.SET_WALL_JUKEBOX);
                entries.add(ModBlocks.SET_WALL_LODESTONE);
                entries.add(ModBlocks.SET_WALL_LODESTONE_TOP);
                entries.add(ModBlocks.SET_WALL_BOOKSHELF);
                entries.add(ModBlocks.SET_WALL_TARGET);
                entries.add(ModBlocks.SET_WALL_DISPENSER);
                entries.add(ModBlocks.SET_WALL_OBSERVER);
                entries.add(ModBlocks.SET_WALL_TNT);
            })
            .build();

    /** For adding in the middle of vanilla Itemgroups
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(BLOCKS_GROUP).register(content -> {
            content.add(ModBlocks.STUDIO_BAR);
        });
    }**/
}

