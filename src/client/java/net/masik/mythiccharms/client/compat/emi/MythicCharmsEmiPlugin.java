package net.masik.mythiccharms.client.compat.emi;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.stack.EmiStack;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.block.ModBlocks;
import net.masik.mythiccharms.item.ModItems;
import net.masik.mythiccharms.recipe.ResonanceRecipe;
import net.masik.mythiccharms.util.RecipeUtils;
import net.minecraft.item.Item;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class MythicCharmsEmiPlugin implements EmiPlugin {
    public static final Map<Item, EmiStack> EMI_ITEMS = new LinkedHashMap<>();
    public static final EmiStack RESONANCE_TABLE = EmiStack.of(ModBlocks.RESONANCE_TABLE);

    static {
        for (Field field : ModItems.class.getDeclaredFields()) {
            Object value;
            try {
                value = field.get(ModItems.class);
            } catch (IllegalAccessException e) {
                MythicCharms.LOGGER.error("Failed to get field value item " + field.getName());
                continue;
            }
            if (value instanceof Item item) {
                EMI_ITEMS.put(item, EmiStack.of(item));
            }
        }
    }

    @Override
    public void register(EmiRegistry registry) {
        registry.addEmiStack(RESONANCE_TABLE);
        registry.addCategory(CharmEmiRecipe.CATEGORY);
        registry.addWorkstation(CharmEmiRecipe.CATEGORY, RESONANCE_TABLE);
        EMI_ITEMS.forEach((item, emiStack) -> registry.addEmiStack(emiStack));
        registry.getRecipeManager().listAllOfType(ResonanceRecipe.Type.INSTANCE).forEach(entry ->
                registry.addRecipe(new CharmEmiRecipe(RecipeUtils.get(entry))));
    }
}
