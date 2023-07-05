/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package io.github.joppebijlsma.tvstudio.registries;

import io.github.joppebijlsma.tvstudio.TvStudio;
import io.github.joppebijlsma.tvstudio.recipe.PaintingRecipe;
import net.minecraft.recipe.ArmorDyeRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public final class ModRecipes {
    public static final SpecialRecipeSerializer<?> PAINTING = register("crafting_special_painting", new SpecialRecipeSerializer<>(PaintingRecipe::new));
    private static <T extends RecipeSerializer<?>> T register(String id, T value) {
        return Registry.register(Registries.RECIPE_SERIALIZER, TvStudio.id(id), value);
    }

    public static void init() {
    }
}
