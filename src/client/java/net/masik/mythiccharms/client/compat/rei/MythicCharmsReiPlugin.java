package net.masik.mythiccharms.client.compat.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.block.ModBlocks;
import net.masik.mythiccharms.recipe.ModRecipes;
import net.masik.mythiccharms.recipe.ResonanceRecipe;
import net.minecraft.recipe.RecipeEntry;

public class MythicCharmsReiPlugin implements REIClientPlugin {
    public static final CategoryIdentifier<ResonanceTableDisplay> RESONANCE_INFUSING = CategoryIdentifier.of(MythicCharms.MOD_ID, ResonanceRecipe.Type.ID);

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new ResonanceTableCategory());

        registry.addWorkstations(RESONANCE_INFUSING, EntryStacks.of(ModBlocks.RESONANCE_TABLE));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        for (RecipeEntry<ResonanceRecipe> recipe : registry.getRecipeManager().listAllOfType(ResonanceRecipe.Type.INSTANCE)) {
            registry.add(new ResonanceTableDisplay(recipe.value()));
        }
    }
}
