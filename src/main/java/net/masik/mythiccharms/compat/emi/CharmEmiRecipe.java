package net.masik.mythiccharms.compat.emi;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.DrawableWidget;
import dev.emi.emi.api.widget.WidgetHolder;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.block.ModBlocks;
import net.masik.mythiccharms.item.ModItems;
import net.masik.mythiccharms.recipe.ResonanceRecipe;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CharmEmiRecipe implements EmiRecipe {
    public static final EmiTexture ARROW = new EmiTexture(new Identifier(MythicCharms.MOD_ID,
            "textures/gui/arrow.png"), 0, 0, 17, 15, 17, 15, 17, 15);
    public static final EmiIngredient EXPERIENCE_BOTTLE = EmiStack.of(Items.EXPERIENCE_BOTTLE);
    public static final EmiIngredient RESONANCE_RING = EmiStack.of(ModItems.RESONANCE_RING);
    private final Identifier id;
    private final List<EmiIngredient> inputs;
    private final List<EmiStack> output;

    public CharmEmiRecipe(ResonanceRecipe recipe) {
        this.id = recipe.getId();

        List<Ingredient> ingredients = recipe.getRecipeItems();
        if (ingredients.size() < 5) {
            for (int i = 0; i < 10 - ingredients.size(); i++) {
                ingredients.add(Ingredient.ofItems(Items.AIR));
            }
        }
        this.inputs = ingredients.stream().map(EmiIngredient::of).toList();

        this.output = List.of(EmiStack.of(recipe.getOutput(null)));
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return MythicCharmsEmiPlugin.RESONANCE_INFUSING;
    }

    @Override
    public @Nullable Identifier getId() {
        return id;
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return inputs;
    }

    @Override
    public List<EmiStack> getOutputs() {
        return output;
    }

    @Override
    public int getDisplayWidth() {
        return 120;
    }

    @Override
    public int getDisplayHeight() {
        return 90;
    }

    @SuppressWarnings("UnstableApiUsage")
    @Override
    public void addWidgets(WidgetHolder widgets) {
        // These numbers are completely magic, defined by a spell called "Trys-Errorus"
        widgets.addTexture(ARROW, 75, 28);
        widgets.addSlot(inputs.get(0), 15, 5);
        widgets.addSlot(inputs.get(1), 36, 5);
        widgets.addSlot(inputs.get(2), 57, 5);
        widgets.addSlot(inputs.get(3), 26, 26);
        widgets.addSlot(inputs.get(4), 47, 26);

        widgets.addSlot(EXPERIENCE_BOTTLE, 81, 5);

        widgets.addTexture(EmiTexture.EMPTY_ARROW, 68, 55);
        widgets.addSlot(RESONANCE_RING, 7, 55);
        widgets.addSlot(output.get(0), 96, 55);

        widgets.add(new DrawableWidget(33, 63, 60, 60, (context, $, $$, $$$) -> {
            context.push();
            context.scale(1.5F,1.5F,1.5F);
            context.drawItem(Items.LAPIS_BLOCK.getDefaultStack(), 0, 0, 0, 1);
            context.pop();
        }));
        widgets.add(new DrawableWidget(33, 47, 60, 60, (context, $, $$, $$$) -> {
            context.push();
            context.scale(1.5F,1.5F,1.5F);
            context.drawItem(ModBlocks.RESONANCE_TABLE.asItem().getDefaultStack(), 0, 0, 0, 2);
            context.pop();
        }));
    }
}