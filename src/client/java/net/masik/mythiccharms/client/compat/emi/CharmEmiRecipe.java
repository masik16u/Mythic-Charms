package net.masik.mythiccharms.client.compat.emi;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.DrawableWidget;
import dev.emi.emi.api.widget.WidgetHolder;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.block.ModBlocks;
import net.masik.mythiccharms.item.ModItems;
import net.masik.mythiccharms.recipe.ResonanceRecipe;
import net.masik.mythiccharms.util.SafeDefaultedList;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class CharmEmiRecipe implements EmiRecipe {

    public static final EmiTexture RESONANCE_RECIPE_TREE = new EmiTexture(MythicCharms.id("textures/gui/resonance_recipe_texture.png"), 0, 0, 16, 16, 16, 16, 16, 16);
    public static final EmiRecipeCategory CATEGORY = new EmiRecipeCategory(MythicCharms.id(ResonanceRecipe.Type.ID), MythicCharmsEmiPlugin.RESONANCE_TABLE, RESONANCE_RECIPE_TREE);
    public static final EmiTexture ARROW = new EmiTexture(new Identifier(MythicCharms.MOD_ID, "textures/gui/arrow.png"), 0, 0, 17, 15, 17, 15, 17, 15);
    public static final EmiIngredient EXPERIENCE_BOTTLE = EmiStack.of(Items.EXPERIENCE_BOTTLE);
    public static final EmiIngredient RESONANCE_RING = EmiStack.of(ModItems.RESONANCE_RING);
    private final Identifier id;
    private final List<? extends EmiIngredient> inputs;
    private final List<EmiStack> output;

    public CharmEmiRecipe(ResonanceRecipe recipe) {
        this.id = Registries.ITEM.getId(recipe.result);
        this.inputs = new SafeDefaultedList<>(recipe.stacks.stream().map(EmiStack::of).toList(), EmiStack.EMPTY);
        this.output = Collections.singletonList(EmiStack.of(recipe.result));
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return CATEGORY;
    }

    @Override
    public @Nullable Identifier getId() {
        return this.id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<EmiIngredient> getInputs() {
        return (List<EmiIngredient>) this.inputs;
    }

    @Override
    public List<EmiStack> getOutputs() {
        return this.output;
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
        widgets.addSlot(this.inputs.get(0), 15, 5);
        widgets.addSlot(this.inputs.get(1), 36, 5);
        widgets.addSlot(this.inputs.get(2), 57, 5);
        widgets.addSlot(this.inputs.get(3), 26, 26);
        widgets.addSlot(this.inputs.get(4), 47, 26);
        widgets.addSlot(EXPERIENCE_BOTTLE, 81, 5);

        widgets.addTexture(EmiTexture.EMPTY_ARROW, 68, 55);
        widgets.addSlot(RESONANCE_RING, 7, 55);
        widgets.addSlot(this.output.get(0), 96, 55);

        widgets.add(new DrawableWidget(33, 63, 60, 60, (context, $, $$, $$$) -> {
            context.push();
            context.scale(1.5F, 1.5F, 1.5F);
            context.drawItem(Items.LAPIS_BLOCK.getDefaultStack(), 0, 0, 0, 1);
            context.pop();
        }));
        widgets.add(new DrawableWidget(33, 47, 60, 60, (context, $, $$, $$$) -> {
            context.push();
            context.scale(1.5F, 1.5F, 1.5F);
            context.drawItem(ModBlocks.RESONANCE_TABLE.asItem().getDefaultStack(), 0, 0, 0, 2);
            context.pop();
        }));
    }
}
