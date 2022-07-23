package io.github.joppebijlsma.tvstudio.recipe;

import io.github.joppebijlsma.tvstudio.items.dyeable.SwatchItem;
import io.github.joppebijlsma.tvstudio.items.dyeable.TsDyeableItem;
import io.github.joppebijlsma.tvstudio.registries.ModItems;
import io.github.joppebijlsma.tvstudio.registries.ModRecipes;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SwatchingRecipe extends SpecialCraftingRecipe {
    public SwatchingRecipe(Identifier id) {
        super(id);
    }

    @Nullable
    private Inputs findInputs(CraftingInventory inventory) {
        ItemStack clean = ItemStack.EMPTY;
        ItemStack dyed = ItemStack.EMPTY;

        for (int slot = 0; slot < inventory.size(); slot++) {
            ItemStack stack = inventory.getStack(slot);
            if (stack.isEmpty()) continue;

            Item item = stack.getItem();
            if (item != ModItems.SWATCH) return null; // invalid item
            SwatchItem swatch = (SwatchItem) item;

            if (swatch.hasColor(stack)) {
                if (!dyed.isEmpty()) return null; // duplicate dyed swatch
                dyed = stack;
            } else {
                if (!clean.isEmpty()) return null; // duplicate clean swatch
                clean = stack;
            }
        }

        return !clean.isEmpty() && !dyed.isEmpty() ? new Inputs(clean, dyed) : null;
    }

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        return findInputs(inventory) != null;
    }

    @Override
    public ItemStack craft(CraftingInventory inventory) {
        @Nullable Inputs inputs = findInputs(inventory);
        if (inputs == null) return ItemStack.EMPTY;

        ItemStack result = new ItemStack(ModItems.SWATCH, 2);
        TsDyeableItem.copyColor(inputs.dyed(), result);
        return result;
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.SWATCHING;
    }

    private record Inputs(ItemStack clean, ItemStack dyed) {}
}