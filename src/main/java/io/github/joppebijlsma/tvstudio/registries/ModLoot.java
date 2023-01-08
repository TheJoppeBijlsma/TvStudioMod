/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package io.github.joppebijlsma.tvstudio.registries;

import io.github.joppebijlsma.tvstudio.TvStudio;
import io.github.joppebijlsma.tvstudio.loot.RemoveDefaultColorLootFunction;
import net.minecraft.loot.function.LootFunctionType;
import net.minecraft.loot.provider.nbt.LootNbtProviderType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public final class ModLoot {
    public static final LootFunctionType REMOVE_DEFAULT_COLOR = register("remove_default_color", new LootFunctionType(new RemoveDefaultColorLootFunction.Serializer()));

    private static LootFunctionType register(String id, LootFunctionType type) {
        return Registry.register(Registries.LOOT_FUNCTION_TYPE, TvStudio.id(id), type);
    }

    public static void init() {
    }
}
