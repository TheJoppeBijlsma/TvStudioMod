package io.github.joppebijlsma.tvstudio.registries;

import io.github.joppebijlsma.tvstudio.TvStudio;
import io.github.joppebijlsma.tvstudio.recipe.SwatchingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static final SpecialRecipeSerializer<?> SWATCHING = register("crafting_special_swatching", new SpecialRecipeSerializer<>(SwatchingRecipe::new));

    private static <T extends RecipeSerializer<?>> T register(String id, T value) {
        return Registry.register(Registry.RECIPE_SERIALIZER, TvStudio.id(id), value);
    }

    public static void registerModRecipes() {
        TvStudio.TVSTUDIO_LOGGER.debug("Registering recipes for " + TvStudio.MOD_ID);

    }
}
