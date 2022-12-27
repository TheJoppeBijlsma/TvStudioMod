/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package io.github.joppebijlsma.tvstudio.client;

import io.github.joppebijlsma.tvstudio.TvStudio;
import io.github.joppebijlsma.tvstudio.blocks.entity.PaintableBlockEntity;
import io.github.joppebijlsma.tvstudio.items.PaintBrushItem;
import io.github.joppebijlsma.tvstudio.registries.ModBlockEntities;
import io.github.joppebijlsma.tvstudio.registries.ModBlocks;
import io.github.joppebijlsma.tvstudio.registries.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.DyeableItem;
import org.jetbrains.annotations.Nullable;

public final class ColourTestClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (tintIndex == 0 && world != null) {
                @Nullable PaintableBlockEntity entity = world.getBlockEntity(pos, ModBlockEntities.PAINTABLE_BLOCK).orElse(null);

                if (entity != null) {
                    return entity.getColor();
                }
            }

            return -1;
        }, ModBlocks.all());

        ColorProviderRegistry.ITEM.register(
            (stack, tintIndex) -> tintIndex == 0 ? ((DyeableItem) stack.getItem()).getColor(stack) : -1,
            ModItems.blockLikeItems()
        );

        ColorProviderRegistry.ITEM.register(
            (stack, tintIndex) -> ((PaintBrushItem) stack.getItem()).getColor(stack, tintIndex),
            ModItems.PAINT_BRUSH
        );

        FabricModelPredicateProviderRegistry.register(
            ModItems.PAINT_BRUSH, TvStudio.id("dyed"),
            (stack, world, entity, seed) -> ((DyeableItem) stack.getItem()).hasColor(stack) ? 1 : 0
        );
    }
}
