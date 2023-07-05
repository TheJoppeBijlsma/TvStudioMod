/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package io.github.joppebijlsma.tvstudio.blocks;

import io.github.joppebijlsma.tvstudio.blocks.entity.PaintableBlockEntity;
import io.github.joppebijlsma.tvstudio.registries.ModBlockEntities;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class PaintableBlock extends BlockWithEntity {

    public PaintableBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PaintableBlockEntity(pos, state);
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        var stack = new ItemStack(this);
        world.getBlockEntity(pos, ModBlockEntities.PAINTABLE_BLOCK)
                .ifPresent(entity -> ((DyeableItem) stack.getItem()).setColor(stack, entity.getColor()));
        return stack;
    }
}