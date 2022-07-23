package io.github.joppebijlsma.tvstudio.mixin;

import io.github.joppebijlsma.tvstudio.items.dyeable.TsDyeableItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(ItemStack.class)
abstract class ItemStackMixin {
    @Shadow
    public abstract Item getItem();

    @Shadow
    private static native boolean isSectionVisible(int flags, ItemStack.TooltipSection tooltipSection);

    // would use an inject but isSectionVisible is static...
    @Redirect(
            method = "getTooltip",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isSectionVisible(ILnet/minecraft/item/ItemStack$TooltipSection;)Z", ordinal = 0),
            slice = @Slice(from = @At(value = "FIELD", target = "Lnet/minecraft/item/ItemStack$TooltipSection;DYE:Lnet/minecraft/item/ItemStack$TooltipSection;"))
    )
    private boolean hideDyeSectionForSwatches(int flags, ItemStack.TooltipSection section) {
        if (getItem() instanceof TsDyeableItem) {
            return false;
        }

        return isSectionVisible(flags, section);
    }
}