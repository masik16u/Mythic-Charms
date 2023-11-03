package net.masik.mythiccharms.util;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeEntry;

import java.util.Optional;

/**
 * Recipe getter wrapper for 1.20.2 compat
 */
public class RecipeUtils {
    public static <R extends Recipe<?>> R get(RecipeEntry<R> entry) {
        return entry.value();
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public static <R extends Recipe<?>> Optional<R> getOptional(Optional<RecipeEntry<R>> entry) {
        return entry.map(RecipeEntry::value);
    }
}
