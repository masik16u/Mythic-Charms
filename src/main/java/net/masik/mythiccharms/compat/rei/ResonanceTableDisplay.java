package net.masik.mythiccharms.compat.rei;

import com.google.common.collect.ImmutableList;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.masik.mythiccharms.item.ModItems;
import net.masik.mythiccharms.recipe.CharmRecipe;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResonanceTableDisplay implements Display {

    private static final EntryIngredient EXPERIENCE_BOTTLE = EntryIngredients.of(Items.EXPERIENCE_BOTTLE).map(stack ->
            stack.copy().tooltip(Text.translatable("category.mythic_charms.resonance.catalyst").formatted(Formatting.YELLOW)));
    private static final EntryIngredient RESONANCE_RING = EntryIngredients.of(ModItems.RESONANCE_RING).map(stack ->
            stack.copy().tooltip(Text.translatable("category.mythic_charms.resonance.trinket").formatted(Formatting.YELLOW)));

    private List<EntryIngredient> output;
    private List<EntryIngredient> input;

    public ResonanceTableDisplay(CharmRecipe recipe) {
        ImmutableList.Builder<EntryIngredient> builder = ImmutableList.builder();
        recipe.input.forEach(item ->
                builder.add(EntryIngredients.of(item).map(stack -> stack.copy().tooltip(Text.translatable("category.mythic_charms.resonance.ingredient").formatted(Formatting.YELLOW)))));
        builder.add(EXPERIENCE_BOTTLE);
        builder.add(RESONANCE_RING);
        this.input = builder.build();

        this.output = Collections.singletonList(EntryIngredients.of(recipe.output).map(stack -> stack.copy().tooltip(Text.translatable("category.mythic_charms.resonance.output").formatted(Formatting.YELLOW))));

    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        return this.input;
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return this.output;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return MythicCharmsReiPlugin.RESONANCE_INFUSING;
    }

}
