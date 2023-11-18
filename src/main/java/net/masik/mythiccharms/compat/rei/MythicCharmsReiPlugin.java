package net.masik.mythiccharms.compat.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.block.ModBlocks;
import net.masik.mythiccharms.compat.emi.CharmEmiRecipe;
import net.masik.mythiccharms.item.ModItems;
import net.masik.mythiccharms.recipe.ModRecipes;
import net.masik.mythiccharms.recipe.ResonanceRecipe;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeManager;

import java.util.List;

public class MythicCharmsReiPlugin implements REIClientPlugin {
    public static final CategoryIdentifier<ResonanceTableDisplay> RESONANCE_INFUSING = CategoryIdentifier.of(MythicCharms.MOD_ID, "resonance_infusing");

    @Override
    public void registerCategories(CategoryRegistry registry) {

        registry.add(new ResonanceTableCategory());

        registry.addWorkstations(RESONANCE_INFUSING, EntryStacks.of(ModBlocks.RESONANCE_TABLE));

    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        RecipeManager manager = registry.getRecipeManager();
        for (ResonanceRecipe recipe : manager.listAllOfType(ResonanceRecipe.Type.INSTANCE)) {
            registry.add(new ResonanceTableDisplay(recipe));
        }
    }

}
