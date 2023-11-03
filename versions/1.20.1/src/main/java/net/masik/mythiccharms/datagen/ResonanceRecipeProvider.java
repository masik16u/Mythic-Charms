package net.masik.mythiccharms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.masik.mythiccharms.recipe.ModRecipes;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

import java.util.function.Consumer;

public class ResonanceRecipeProvider extends FabricRecipeProvider {
    public ResonanceRecipeProvider(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ModRecipes.RESONANCE_TABLE.forEach((item, recipe) -> exporter.accept(recipe));
    }
}
