package net.masik.mythiccharms.compat.emi;

import com.google.common.collect.ImmutableList;
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
import net.masik.mythiccharms.recipe.CharmRecipe;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class CharmEmiRecipe implements EmiRecipe {
    public static final EmiRecipeCategory CATEGORY = new EmiRecipeCategory(new Identifier(MythicCharms.MOD_ID, "resonance_table"), MythicCharmsEmiPlugin.RESONANCE_TABLE);
    public static final EmiTexture ARROW = new EmiTexture(new Identifier(MythicCharms.MOD_ID, "textures/gui/widgets.png"), 0, 0, 31, 15);
    public static final EmiIngredient EXPERIENCE_BOTTLE = EmiStack.of(Items.EXPERIENCE_BOTTLE);
    public static final EmiIngredient RESONANCE_RING = EmiStack.of(ModItems.RESONANCE_RING);
    private final Identifier id;
    private final List<EmiIngredient> inputs;
    private final List<EmiStack> output;

    public CharmEmiRecipe(Identifier id, CharmRecipe recipe) {
        this.id = id;
        ImmutableList.Builder<EmiIngredient> inputs = ImmutableList.builder();
        for (int i = 0; i < CharmRecipe.INPUT_SIZE; i++) {
            inputs.add(EmiStack.of(recipe.input.get(i)));
        }
        this.inputs = inputs.build();
        this.output = Collections.singletonList(EmiStack.of(recipe.output));
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
        return id;
    }

    /**
     * @return A list of ingredients required for the recipe.
     * Inputs will consider this recipe a use when exploring recipes.
     */
    @Override
    public List<EmiIngredient> getInputs() {
        return inputs;
    }

    /**
     * @return A list of stacks that are created after a craft.
     * Outputs will consider this recipe a source when exploring recipes.
     */
    @Override
    public List<EmiStack> getOutputs() {
        return output;
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
        return 150;
    }

    /**
     * @return The maximum height taken up by the recipe's widgets.
     * Vertical screen space is capped, however, and EMI may opt to provide less vertical space.
     */
    @Override
    public int getDisplayHeight() {
        return 100;
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
        widgets.addTexture(ARROW, 90, 33);
        widgets.addSlot(inputs.get(0), 30, 10);
        widgets.addSlot(inputs.get(1), 51, 10);
        widgets.addSlot(inputs.get(2), 72, 10);
        widgets.addSlot(inputs.get(3), 41, 31);
        widgets.addSlot(inputs.get(4), 62, 31);
        widgets.addSlot(EXPERIENCE_BOTTLE, 96, 10);

        widgets.addTexture(EmiTexture.EMPTY_ARROW, 83, 60);
        widgets.addSlot(RESONANCE_RING, 22, 60);
        widgets.addSlot(output.get(0), 111, 60);

        widgets.add(new DrawableWidget(50, 68, 60, 60, (context, $, $$, $$$) -> {
            context.push();
            context.scale(1.5F,1.5F,1.5F);
            context.drawItem(Items.LAPIS_BLOCK.getDefaultStack(), 0, 0, 0, 1);
            context.pop();
        }));
        widgets.add(new DrawableWidget(50, 52, 60, 60, (context, $, $$, $$$) -> {
            context.push();
            context.scale(1.5F,1.5F,1.5F);
            context.drawItem(ModBlocks.RESONANCE_TABLE.asItem().getDefaultStack(), 0, 0, 0, 2);
            context.pop();
        }));
    }
}
