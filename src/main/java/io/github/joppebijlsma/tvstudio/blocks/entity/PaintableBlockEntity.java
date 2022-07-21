package io.github.joppebijlsma.tvstudio.blocks.entity;

import io.github.joppebijlsma.tvstudio.items.paintable.SwatchItem;
import io.github.joppebijlsma.tvstudio.util.Colors;
import io.github.joppebijlsma.tvstudio.util.NbtKeys;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class PaintableBlockEntity extends BlockEntity implements SwatchItem.DyeTarget {
    private int color = Colors.STONE_DEFAULT_COLOR;

    public PaintableBlockEntity(BlockPos pos, BlockState state) {
        super(TsBlockEntities.PAINTERS_BLOCK, pos, state);
    }

    @Override
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        markDirty();
    }

    @Override
    public void setColorAndSync(int color) {
        setColor(color);
        TsBlockEntities.sync(this);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        color = nbt.getInt(NbtKeys.COLOR);

        if (world != null && world.isClient) {
            // rerender
            // TODO: this is concern, can I remove it?
            world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
        }
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt(NbtKeys.COLOR, color);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }
}
