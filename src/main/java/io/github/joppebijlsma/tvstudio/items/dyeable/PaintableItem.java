package io.github.joppebijlsma.tvstudio.items.dyeable;

import io.github.joppebijlsma.tvstudio.blocks.entity.PaintableBlockEntity;
import io.github.joppebijlsma.tvstudio.mixin.BlockItemAccessor;
import io.github.joppebijlsma.tvstudio.util.Colors;
import io.github.joppebijlsma.tvstudio.util.NbtKeys;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
public class PaintableItem extends BlockItem implements TsDyeableItem {
    static final Int2ObjectMap<Item> DYES_BY_RGB = Util.make(new Int2ObjectOpenHashMap<>(), map -> {
        for (DyeColor color : DyeColor.values()) {
            map.put(Colors.DYE_COLOR_RGB_VALUES.getInt(color), DyeItem.byColor(color));
        }
    });

    public PaintableItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        appendColorTooltip(stack, tooltip);
    }

    @Override
    public int getDefaultColor() {
        return Colors.STONE_DEFAULT_COLOR;
    }

    @Override
    public String getColorParentNbtKey() {
        return BlockItemAccessor.getBlockEntityTagKey();
    }

    @Override
    public String getColorNbtKey() {
        return NbtKeys.COLOR;
    }

    @Override
    protected boolean postPlacement(BlockPos pos, World world, @Nullable PlayerEntity player, ItemStack stack, BlockState state) {
        boolean updatedOnServer = super.postPlacement(pos, world, player, stack, state);

        // Set the color on the client to match the stack
        if (world.isClient && hasColor(stack) && world.getBlockEntity(pos) instanceof PaintableBlockEntity paintable) {
            paintable.setColor(getColor(stack));
        }

        return updatedOnServer;
    }
}