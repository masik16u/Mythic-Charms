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
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class CharmEmiRecipe implements EmiRecipe {

    public static final EmiTexture RESONANCE_RECIPE_TREE = new EmiTexture(new Identifier(MythicCharms.MOD_ID, "textures/gui/resonance_recipe_texture.png"), 0, 0, 16, 16, 16, 16, 16, 16);
    public static final EmiRecipeCategory CATEGORY = new EmiRecipeCategory(new Identifier(MythicCharms.MOD_ID, "resonance_table"),
            MythicCharmsEmiPlugin.RESONANCE_TABLE, RESONANCE_RECIPE_TREE);
    public static final EmiTexture ARROW = new EmiTexture(new Identifier(MythicCharms.MOD_ID, "textures/gui/arrow.png"), 0, 0, 17, 15, 17, 15, 17, 15);
    public static final EmiIngredient EXPERIENCE_BOTTLE = EmiStack.of(Items.EXPERIENCE_BOTTLE);
    public static final EmiIngredient RESONANCE_RING = EmiStack.of(ModItems.RESONANCE_RING);
    private final Identifier id;
    private final List<? extends EmiIngredient> inputs;
    private final List<EmiStack> output;

    public CharmEmiRecipe(Identifier id, ResonanceRecipe recipe) {
        this.id = id;
        this.inputs = recipe.stacks.stream().map(EmiStack::of).toList();
        this.output = Collections.singletonList(EmiStack.of(recipe.result));
    }

    /**
     * @return The recipe category this recipe should be displayed under.
     * This is used for grouping in the recipe screen, as well as category display in the recipe tree.
     */
    @Override
    public EmiRecipeCategory getCategory() {
        return CATEGORY;
    }

    /**
     * @return The unique id of the recipe, or null. If null, the recipe cannot be serialized.
     */
    @Override
    public @Nullable Identifier getId() {
        return this.id;
    }

    /**
     * @return A list of ingredients required for the recipe.
     * Inputs will consider this recipe a use when exploring recipes.
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<EmiIngredient> getInputs() {
        return (List<EmiIngredient>) this.inputs;
    }

    /**
     * @return A list of stacks that are created after a craft.
     * Outputs will consider this recipe a source when exploring recipes.
     */
    @Override
    public List<EmiStack> getOutputs() {
        return this.output;
    }

    /**
     * @return The width taken up by the recipe's widgets
     * EMI will grow to accomodate requested width.
     * To fit within the default width, recipes should request a width of 134.
     * If a recipe does not support the recipe tree or recipe filling, EMI
     * will not need to add buttons, and it will have space for a width of 160.
     */
    @Override
    public int getDisplayWidth() {
        return 120;
    }

    /**
     * @return The maximum height taken up by the recipe's widgets.
     * Vertical screen space is capped, however, and EMI may opt to provide less vertical space.
     */
    @Override
    public int getDisplayHeight() {
        return 90;
    }

    /**
     * Called to add widgets that display the recipe.
     * Can be used in several places, including the main recipe screen, and tooltips.
     * It is worth noting that EMI cannot grow vertically, so recipes with large heights
     * may be provided less space than requested if they span more than the entire vertical
     * space available in the recipe scren.
     * In the case of very large heights, recipes should respect {@link WidgetHolder#getHeight()}.
     *
     * @param widgets
     */
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
