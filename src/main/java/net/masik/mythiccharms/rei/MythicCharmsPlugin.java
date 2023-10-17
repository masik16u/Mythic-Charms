package net.masik.mythiccharms.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.block.ModBlocks;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.item.Items;

import java.util.List;

public class MythicCharmsPlugin implements REIClientPlugin {
    public static final CategoryIdentifier<ResonanceTableDisplay> RESONANCE_INFUSING = CategoryIdentifier.of(MythicCharms.MOD_ID, "resonance");

    @Override
    public void registerCategories(CategoryRegistry registry) {

        registry.add(new ResonanceTableCategory());

        registry.addWorkstations(RESONANCE_INFUSING, EntryStacks.of(ModBlocks.RESONANCE_TABLE));

    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {

        //Fragile charms
        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.FEATHER), EntryIngredients.of(Items.PHANTOM_MEMBRANE),
                EntryIngredients.of(Items.RABBIT_HIDE), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.CRIMSON_FUNGUS), EntryIngredients.of(Items.MAGMA_CREAM),
                EntryIngredients.of(Items.PRISMARINE_CRYSTALS), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_BLAZING_EMBRACE)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.BLAZE_POWDER), EntryIngredients.of(Items.QUARTZ),
                EntryIngredients.of(Items.RAW_IRON), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_EARTHS_ORDER)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.ENDER_EYE), EntryIngredients.of(Items.FERMENTED_SPIDER_EYE),
                EntryIngredients.of(Items.GLISTERING_MELON_SLICE), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_GAZE_SERENITY)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.BONE_MEAL), EntryIngredients.of(Items.CLAY_BALL),
                EntryIngredients.of(Items.CRIMSON_FUNGUS), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_BOTANIC_BLESSING)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.BLAZE_POWDER), EntryIngredients.of(Items.RABBIT_HIDE),
                EntryIngredients.of(Items.SUGAR), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_FLEETING_STRIDES)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.NAUTILUS_SHELL), EntryIngredients.of(Items.PHANTOM_MEMBRANE),
                EntryIngredients.of(Items.PRISMARINE_CRYSTALS), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_NIGHTS_GUARDIAN)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.RABBIT_FOOT), EntryIngredients.of(Items.SLIME_BALL),
                EntryIngredients.of(Items.SUGAR), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_HIGH_BOUNDS)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.CLAY_BALL), EntryIngredients.of(Items.DRIED_KELP),
                EntryIngredients.of(Items.PRISMARINE_CRYSTALS), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_DROWNED_FREEDOM)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.GHAST_TEAR), EntryIngredients.of(Items.GLOW_INK_SAC),
                EntryIngredients.of(Items.PHANTOM_MEMBRANE), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_WEIGHTLESS_FLOW)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.ENDER_EYE), EntryIngredients.of(Items.GLOW_BERRIES),
                EntryIngredients.of(Items.WARPED_FUNGUS), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_COLLECTORS_GIFT)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.GLOW_INK_SAC), EntryIngredients.of(Items.RABBIT_FOOT),
                EntryIngredients.of(Items.SLIME_BALL), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_CLIMBERS_PATH)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.BONE_MEAL), EntryIngredients.of(Items.GLOW_INK_SAC),
                EntryIngredients.of(Items.HONEYCOMB), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_NATURES_CALL)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.ENDER_EYE), EntryIngredients.of(Items.GLISTERING_MELON_SLICE),
                EntryIngredients.of(Items.RAW_GOLD), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_BARTERS_PACT)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.GHAST_TEAR), EntryIngredients.of(Items.MAGMA_CREAM),
                EntryIngredients.of(Items.PRISMARINE_SHARD), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.ECHO_SHARD), EntryIngredients.of(Items.FERMENTED_SPIDER_EYE),
                EntryIngredients.of(Items.GREEN_DYE), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_ECHOING_WRATH)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.BLAZE_POWDER), EntryIngredients.of(Items.ECHO_SHARD),
                EntryIngredients.of(Items.GLOW_BERRIES), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_ENCHANTED_WHISPERS)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.HONEYCOMB), EntryIngredients.of(Items.MAGMA_CREAM),
                EntryIngredients.of(Items.RABBIT_HIDE), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_ARROW_DANCE)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.GLISTERING_MELON_SLICE), EntryIngredients.of(Items.NAUTILUS_SHELL),
                EntryIngredients.of(Items.QUARTZ), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_MOUNTAINS_STRENGTH)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.NAUTILUS_SHELL), EntryIngredients.of(Items.QUARTZ),
                EntryIngredients.of(Items.SLIME_BALL), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_SAFE_TERRITORY)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_BASE),
                EntryIngredients.of(Items.ECHO_SHARD), EntryIngredients.of(Items.FEATHER),
                EntryIngredients.of(Items.SLIME_BALL), EntryIngredients.of(ModItems.GLOWSTONE_NUGGET)),
                EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_QUIET_PRESENCE)));


        //Unbreakable charms
        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_FEATHERED_GRACE)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_BLAZING_EMBRACE),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_BLAZING_EMBRACE)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_EARTHS_ORDER),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_EARTHS_ORDER)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_GAZE_SERENITY),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_GAZE_SERENITY)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_BOTANIC_BLESSING),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_BOTANIC_BLESSING)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_FLEETING_STRIDES),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_FLEETING_STRIDES)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_NIGHTS_GUARDIAN),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_NIGHTS_GUARDIAN)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_HIGH_BOUNDS),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_HIGH_BOUNDS)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_DROWNED_FREEDOM),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_DROWNED_FREEDOM)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_WEIGHTLESS_FLOW),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_WEIGHTLESS_FLOW)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_COLLECTORS_GIFT),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_COLLECTORS_GIFT)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_CLIMBERS_PATH),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_CLIMBERS_PATH)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_NATURES_CALL),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_NATURES_CALL)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_BARTERS_PACT),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_BARTERS_PACT)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_BATTLE_FURY)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_ECHOING_WRATH),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_ECHOING_WRATH)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_ENCHANTED_WHISPERS),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_ENCHANTED_WHISPERS)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_ARROW_DANCE),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_ARROW_DANCE)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_MOUNTAINS_STRENGTH),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_MOUNTAINS_STRENGTH)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_SAFE_TERRITORY),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_SAFE_TERRITORY)));

        registry.add(new ResonanceTableDisplay(List.of(EntryIngredients.of(ModItems.FRAGILE_CHARM_OF_QUIET_PRESENCE),
                EntryIngredients.of(Items.NETHERITE_INGOT), EntryIngredients.of(ModItems.DEEPSLATE_FRAGMENT),
                EntryIngredients.of(Items.AIR), EntryIngredients.of(Items.AIR)), EntryIngredients.of(ModItems.UNBREAKABLE_CHARM_OF_QUIET_PRESENCE)));

    }

}
