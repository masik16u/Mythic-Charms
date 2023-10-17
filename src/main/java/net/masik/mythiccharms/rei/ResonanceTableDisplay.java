package net.masik.mythiccharms.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.List;

public class ResonanceTableDisplay implements Display {

    private List<EntryIngredient> output;
    private List<EntryIngredient> input;

    private EntryIngredient catalyst = EntryIngredients.of(Items.EXPERIENCE_BOTTLE).map(stack -> stack.copy().tooltip(Text.translatable("category.mythic_charms.resonance.catalyst").formatted(Formatting.YELLOW)));
    private EntryIngredient trinket = EntryIngredients.of(ModItems.RESONANCE_RING).map(stack -> stack.copy().tooltip(Text.translatable("category.mythic_charms.resonance.trinket").formatted(Formatting.YELLOW)));

    public ResonanceTableDisplay(List<EntryIngredient> in, EntryIngredient out) {

        List<EntryIngredient> inp = new ArrayList<>();

        for (EntryIngredient item : in) {

            inp.add(item.map(stack -> stack.copy().tooltip(Text.translatable("category.mythic_charms.resonance.ingredient").formatted(Formatting.YELLOW))));

        }

        inp.add(catalyst);

        inp.add(trinket);

        this.input = inp;

        this.output = List.of(out.map(stack -> stack.copy().tooltip(Text.translatable("category.mythic_charms.resonance.output").formatted(Formatting.YELLOW))));

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
        return MythicCharmsPlugin.RESONANCE_INFUSING;
    }

}
