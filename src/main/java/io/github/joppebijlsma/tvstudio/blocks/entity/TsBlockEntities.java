package io.github.joppebijlsma.tvstudio.blocks.entity;

import io.github.joppebijlsma.tvstudio.TvStudio;
import io.github.joppebijlsma.tvstudio.registries.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class TsBlockEntities  {
    public static final BlockEntityType<PaintableBlockEntity> PAINTERS_BLOCK = register("painters_block", FabricBlockEntityTypeBuilder.create(PaintableBlockEntity::new, ModBlocks.all()).build());

    private static <T extends BlockEntityType<?>> T register(String id, T type) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, TvStudio.id(id), type);
    }

    public static void init() {
    }

    static void sync(BlockEntity entity) {
        World world = entity.getWorld();

        if (world instanceof ServerWorld sw) {
            sw.getChunkManager().markForUpdate(entity.getPos());
        } else {
            throw new UnsupportedOperationException("[Painter's Blocks] Trying to sync from the client thread. Please report thi");
        }
    }
}
