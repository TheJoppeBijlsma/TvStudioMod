package io.github.joppebijlsma.tvstudio.registries;

import io.github.joppebijlsma.tvstudio.TvStudio;
import io.github.joppebijlsma.tvstudio.loot.RemoveDefaultColorLootFunction;
import net.minecraft.loot.function.LootFunctionType;
import net.minecraft.loot.provider.nbt.LootNbtProviderType;
import net.minecraft.util.registry.Registry;

public final class ModLoot {
    public static final LootFunctionType REMOVE_DEFAULT_COLOR = register("remove_default_color", new LootFunctionType(new RemoveDefaultColorLootFunction.Serializer()));

    private static LootNbtProviderType register(String id, LootNbtProviderType type) {
        return Registry.register(Registry.LOOT_NBT_PROVIDER_TYPE, TvStudio.id(id), type);
    }

    private static LootFunctionType register(String id, LootFunctionType type) {
        return Registry.register(Registry.LOOT_FUNCTION_TYPE, TvStudio.id(id), type);
    }

    public static void registerModLoot() {
        TvStudio.TVSTUDIO_LOGGER.debug("Registering loot for " + TvStudio.MOD_ID);

    }
}