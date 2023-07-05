/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package io.github.joppebijlsma.tvstudio.registries;

import io.github.joppebijlsma.tvstudio.TvStudio;
import io.github.joppebijlsma.tvstudio.blocks.entity.PaintableBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.registry.Registry;
import net.minecraft.world.World;

public final class ModBlockEntities {
    public static final BlockEntityType<PaintableBlockEntity> PAINTABLE_BLOCK = register("paintable_block",
            FabricBlockEntityTypeBuilder.create(PaintableBlockEntity::new, ModBlocks.all()).build());

    private static <T extends BlockEntityType<?>> T register(String id, T type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, TvStudio.id(id), type);
    }

    public static void init() {
    }

    public static void sync(BlockEntity entity) {
        World world = entity.getWorld();

        if (world instanceof ServerWorld sw) {
            sw.getChunkManager().markForUpdate(entity.getPos());
        } else {
            throw new UnsupportedOperationException("[TvStudio] Trying to sync from the client thread. Please report thi");
        }
    }
}