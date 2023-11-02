package net.masik.mythiccharms.util;

import net.minecraft.recipe.Recipe;

import java.util.Optional;

public class RecipeUtils {
    public static <R extends Recipe<?>> R get(R entry) {
        return entry;
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public static <R extends Recipe<?>> Optional<R> getOptional(Optional<R> entry) {
        return entry;
    }
}
