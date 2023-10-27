package net.masik.mythiccharms.recipe;

import net.masik.mythiccharms.MythicCharms;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class NewModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(MythicCharms.MOD_ID, ResonanceRecipe.Serializer.ID),
                ResonanceRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(MythicCharms.MOD_ID, ResonanceRecipe.Type.ID),
                ResonanceRecipe.Type.INSTANCE);
    }
}
