package net.masik.mythiccharms.recipe;

import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(MythicCharms.MOD_ID, ResonanceRecipe.Serializer.ID),
                ResonanceRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(MythicCharms.MOD_ID, ResonanceRecipe.Type.ID),
                ResonanceRecipe.Type.INSTANCE);
    }
}
