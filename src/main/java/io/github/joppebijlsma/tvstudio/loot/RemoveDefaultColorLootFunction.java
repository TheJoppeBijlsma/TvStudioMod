/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package io.github.joppebijlsma.tvstudio.loot;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import io.github.joppebijlsma.tvstudio.items.TsDyeableItem;
import io.github.joppebijlsma.tvstudio.registries.ModLoot;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.function.LootFunctionType;
import net.minecraft.util.JsonSerializer;

public class RemoveDefaultColorLootFunction implements LootFunction {
    @Override
    public ItemStack apply(ItemStack stack, LootContext lootContext) {
        if (stack.getItem() instanceof TsDyeableItem dyeable) {
            if (dyeable.getColor(stack) == dyeable.getDefaultColor()) {
                stack = stack.copy();
                dyeable.removeColor(stack);
            }
        }

        return stack;
    }

    @Override
    public LootFunctionType getType() {
        return ModLoot.REMOVE_DEFAULT_COLOR;
    }

    public static final class Serializer implements JsonSerializer<RemoveDefaultColorLootFunction> {
        @Override
        public void toJson(JsonObject json, RemoveDefaultColorLootFunction object, JsonSerializationContext context) {
        }

        @Override
        public RemoveDefaultColorLootFunction fromJson(JsonObject json, JsonDeserializationContext context) {
            return new RemoveDefaultColorLootFunction();
        }
    }
}
