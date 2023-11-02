package net.masik.mythiccharms.recipe;

import com.google.common.collect.ImmutableList;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModRecipes {
    public static final Map<Item, ResonanceRecipe> RESONANCE_TABLE = new HashMap<>();

    static {
        /* Fragile Charms */
        add(fragile(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE,
                Items.FEATHER,
                Items.PHANTOM_MEMBRANE,
                Items.RABBIT_HIDE,
                ModItems.GLOWSTONE_NUGGET
        ));
        add(fragile(ModItems.FRAGILE_CHARM_OF_BLAZING_EMBRACE,
                Items.CRIMSON_FUNGUS,
                Items.MAGMA_CREAM,
                Items.PRISMARINE_CRYSTALS,
                ModItems.GLOWSTONE_NUGGET
        ));
        add(fragile(ModItems.FRAGILE_CHARM_OF_EARTHS_ORDER,
                Items.BLAZE_POWDER,
                Items.QUARTZ,
                Items.RAW_IRON,
                ModItems.GLOWSTONE_NUGGET
        ));
        add(fragile(ModItems.FRAGILE_CHARM_OF_GAZE_SERENITY,
                Items.ENDER_EYE,
                Items.FERMENTED_SPIDER_EYE,
                Items.GLISTERING_MELON_SLICE,
                ModItems.GLOWSTONE_NUGGET
        ));
        add(fragile(ModItems.FRAGILE_CHARM_OF_BOTANIC_BLESSING,
                Items.BONE_MEAL,
                Items.CLAY_BALL,
                Items.CRIMSON_FUNGUS,
                ModItems.GLOWSTONE_NUGGET
        ));
        add(fragile(ModItems.FRAGILE_CHARM_OF_FLEETING_STRIDES,
                Items.BLAZE_POWDER,
                Items.RABBIT_HIDE,
                Items.SUGAR,
                ModItems.GLOWSTONE_NUGGET
        ));
        add(fragile(ModItems.FRAGILE_CHARM_OF_NIGHTS_GUARDIAN,
                Items.PHANTOM_MEMBRANE,
                Items.PRISMARINE_CRYSTALS,
                Items.NAUTILUS_SHELL,
                ModItems.GLOWSTONE_NUGGET
        ));
        add(fragile(ModItems.FRAGILE_CHARM_OF_HIGH_BOUNDS,
                Items.RABBIT_FOOT,
                Items.SLIME_BALL,
                Items.SUGAR,
                ModItems.GLOWSTONE_NUGGET
        ));
        add(fragile(ModItems.FRAGILE_CHARM_OF_DROWNED_FREEDOM,
                Items.CLAY_BALL,
                Items.DRIED_KELP,
                Items.PRISMARINE_CRYSTALS,
                ModItems.GLOWSTONE_NUGGET
        ));
        add(fragile(ModItems.FRAGILE_CHARM_OF_WEIGHTLESS_FLOW,
                Items.GHAST_TEAR,
                Items.GLOW_INK_SAC,
                Items.PHANTOM_MEMBRANE,
                ModItems.GLOWSTONE_NUGGET
        ));
        add(fragile(ModItems.FRAGILE_CHARM_OF_COLLECTORS_GIFT,
                Items.ENDER_EYE,
                Items.GLOW_BERRIES,
                Items.WARPED_FUNGUS,
                ModItems.GLOWSTONE_NUGGET
        ));
        add(fragile(ModItems.FRAGILE_CHARM_OF_CLIMBERS_PATH,
                Items.GLOW_INK_SAC,
                Items.RABBIT_FOOT,
                Items.SLIME_BALL,
                ModItems.GLOWSTONE_NUGGET
        ));
        add(fragile(ModItems.FRAGILE_CHARM_OF_NATURES_CALL,
                Items.BONE_MEAL,
                Items.GLOW_INK_SAC,
                Items.HONEYCOMB,
                ModItems.GLOWSTONE_NUGGET
        ));
        add(fragile(ModItems.FRAGILE_CHARM_OF_BARTERS_PACT,
                Items.ENDER_EYE,
                Items.GLISTERING_MELON_SLICE,
                Items.RAW_GOLD,
                ModItems.GLOWSTONE_NUGGET
        ));
        add(fragile(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY,
                Items.GHAST_TEAR,
                Items.MAGMA_CREAM,
                Items.PRISMARINE_SHARD,
                ModItems.GLOWSTONE_NUGGET
        ));
        add(fragile(ModItems.FRAGILE_CHARM_OF_ECHOING_WRATH,
                Items.ECHO_SHARD,
                Items.FERMENTED_SPIDER_EYE,
                Items.GREEN_DYE,
                ModItems.GLOWSTONE_NUGGET
        ));
        add(fragile(ModItems.FRAGILE_CHARM_OF_ENCHANTED_WHISPERS,
                Items.BLAZE_POWDER,
                Items.ECHO_SHARD,
                Items.GLOW_BERRIES,
                ModItems.GLOWSTONE_NUGGET
        ));
        add(fragile(ModItems.FRAGILE_CHARM_OF_ARROW_DANCE,
                Items.HONEYCOMB,
                Items.MAGMA_CREAM,
                Items.RABBIT_HIDE,
                ModItems.GLOWSTONE_NUGGET
        ));
        add(fragile(ModItems.FRAGILE_CHARM_OF_MOUNTAINS_STRENGTH,
                Items.GLISTERING_MELON_SLICE,
                Items.NAUTILUS_SHELL,
                Items.QUARTZ,
                ModItems.GLOWSTONE_NUGGET
        ));
        add(fragile(ModItems.FRAGILE_CHARM_OF_SAFE_TERRITORY,
                Items.NAUTILUS_SHELL,
                Items.QUARTZ,
                Items.SLIME_BALL,
                ModItems.GLOWSTONE_NUGGET
        ));
        add(fragile(ModItems.FRAGILE_CHARM_OF_QUIET_PRESENCE,
                Items.ECHO_SHARD,
                Items.FEATHER,
                Items.SLIME_BALL,
                ModItems.GLOWSTONE_NUGGET
        ));

        /* Unbreakable Charms */
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_FEATHERED_GRACE,
                ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE
        ));
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_BLAZING_EMBRACE,
                ModItems.FRAGILE_CHARM_OF_BLAZING_EMBRACE
        ));
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_EARTHS_ORDER,
                ModItems.FRAGILE_CHARM_OF_EARTHS_ORDER
        ));
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_GAZE_SERENITY,
                ModItems.FRAGILE_CHARM_OF_GAZE_SERENITY
        ));
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_BOTANIC_BLESSING,
                ModItems.FRAGILE_CHARM_OF_BOTANIC_BLESSING
        ));
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_FLEETING_STRIDES,
                ModItems.FRAGILE_CHARM_OF_FLEETING_STRIDES
        ));
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_NIGHTS_GUARDIAN,
                ModItems.FRAGILE_CHARM_OF_NIGHTS_GUARDIAN
        ));
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_HIGH_BOUNDS,
                ModItems.FRAGILE_CHARM_OF_HIGH_BOUNDS
        ));
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_DROWNED_FREEDOM,
                ModItems.FRAGILE_CHARM_OF_DROWNED_FREEDOM
        ));
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_WEIGHTLESS_FLOW,
                ModItems.FRAGILE_CHARM_OF_WEIGHTLESS_FLOW
        ));
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_COLLECTORS_GIFT,
                ModItems.FRAGILE_CHARM_OF_COLLECTORS_GIFT
        ));
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_CLIMBERS_PATH,
                ModItems.FRAGILE_CHARM_OF_CLIMBERS_PATH
        ));
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_NATURES_CALL,
                ModItems.FRAGILE_CHARM_OF_NATURES_CALL
        ));
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_BARTERS_PACT,
                ModItems.FRAGILE_CHARM_OF_BARTERS_PACT
        ));
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_BATTLE_FURY,
                ModItems.FRAGILE_CHARM_OF_BATTLE_FURY
        ));
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_ECHOING_WRATH,
                ModItems.FRAGILE_CHARM_OF_ECHOING_WRATH
        ));
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_ENCHANTED_WHISPERS,
                ModItems.FRAGILE_CHARM_OF_ENCHANTED_WHISPERS
        ));
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_ARROW_DANCE,
                ModItems.FRAGILE_CHARM_OF_ARROW_DANCE
        ));
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_MOUNTAINS_STRENGTH,
                ModItems.FRAGILE_CHARM_OF_MOUNTAINS_STRENGTH
        ));
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_SAFE_TERRITORY,
                ModItems.FRAGILE_CHARM_OF_SAFE_TERRITORY
        ));
        add(unbreakable(ModItems.UNBREAKABLE_CHARM_OF_QUIET_PRESENCE,
                ModItems.FRAGILE_CHARM_OF_QUIET_PRESENCE
        ));
    }

    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER,
                MythicCharms.id(ResonanceRecipeSerializer.ID),
                ResonanceRecipeSerializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE,
                MythicCharms.id(ResonanceRecipe.Type.ID),
                ResonanceRecipe.Type.INSTANCE);
    }

    public static ResonanceRecipe fragile(Item output, Item... input) {
        ImmutableList.Builder<Item> ingredients = ImmutableList.builder();
        ingredients.add(ModItems.FRAGILE_CHARM_BASE);
        ingredients.addAll(Arrays.asList(input));
        return new ResonanceRecipe(ingredients.build(), output);
    }

    public static ResonanceRecipe unbreakable(Item output, Item charm) {
        return new ResonanceRecipe(List.of(charm, Items.NETHERITE_INGOT, ModItems.DEEPSLATE_FRAGMENT), output);
    }

    private static void add(ResonanceRecipe recipe) {
        RESONANCE_TABLE.put(recipe.result, recipe);
    }
}
