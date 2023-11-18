package net.masik.mythiccharms.compat.emi;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiStack;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.block.ModBlocks;
import net.masik.mythiccharms.recipe.ResonanceRecipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.util.Identifier;

public class MythicCharmsEmiPlugin implements EmiPlugin {

    public static final Identifier RESONANCE_SPRITE_SHEET = new Identifier(MythicCharms.MOD_ID, "textures/gui/resonance_recipe_texture.png");
    public static final EmiStack RESONANCE_WORKSTATION = EmiStack.of(ModBlocks.RESONANCE_TABLE);
    public static final EmiRecipeCategory RESONANCE_INFUSING
            = new EmiRecipeCategory(new Identifier(MythicCharms.MOD_ID, "resonance_infusing"), RESONANCE_WORKSTATION, new EmiTexture(RESONANCE_SPRITE_SHEET, 0, 0, 16, 16, 16, 16, 16, 16));

    @Override
    public void register(EmiRegistry registry) {
        // Tell EMI to add a tab for your category
        registry.addCategory(RESONANCE_INFUSING);

        // Add all the workstations your category uses
        registry.addWorkstation(RESONANCE_INFUSING, RESONANCE_WORKSTATION);

        RecipeManager manager = registry.getRecipeManager();

        // Use vanilla's concept of your recipes and pass them to your EmiRecipe representation
        for (ResonanceRecipe recipe : manager.listAllOfType(ResonanceRecipe.Type.INSTANCE)) {
            registry.addRecipe(new CharmEmiRecipe(recipe));
        }
    }

//    public static final Map<Item, EmiStack> EMI_ITEMS = new LinkedHashMap<>();
//    public static final EmiStack RESONANCE_TABLE = EmiStack.of(ModBlocks.RESONANCE_TABLE);
//
//    static {
//        for (Field field : ModItems.class.getDeclaredFields()) {
//            Object value;
//            try {
//                value = field.get(ModItems.class);
//            } catch (IllegalAccessException e) {
//                MythicCharms.LOGGER.error("Failed to get field value item " + field.getName());
//                continue;
//            }
//            if (value instanceof Item item) {
//                EMI_ITEMS.put(item, EmiStack.of(item));
//            }
//        }
//    }
//
//    @Override
//    public void register(EmiRegistry registry) {
//        registry.addEmiStack(RESONANCE_TABLE);
//        registry.addCategory(CharmEmiRecipe.CATEGORY);
//        registry.addWorkstation(CharmEmiRecipe.CATEGORY, RESONANCE_TABLE);
//        EMI_ITEMS.forEach((item, emiStack) -> registry.addEmiStack(emiStack));
//        ModRecipes.RESONANCE_TABLE.forEach(((item, recipe) -> {
//            EmiStack emiStack = EMI_ITEMS.get(item);
//            if (emiStack == null) {
//                MythicCharms.LOGGER.error("Failed to find EMI item for " + item);
//                return;
//            }
//
//            registry.addRecipe(new CharmEmiRecipe(emiStack.getId(), recipe));
//        }));
//    }
}