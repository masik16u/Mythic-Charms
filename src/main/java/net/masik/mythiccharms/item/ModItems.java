package net.masik.mythiccharms.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.masik.mythiccharms.MythicCharms;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ModItems {

    public static final Item RESONANCE_RING = registerItem("resonance_ring", new TooltipItem(new FabricItemSettings(),
            List.of("item.mythic_charms.resonance_ring.tooltip0", "item.mythic_charms.resonance_ring.tooltip1"), true));
    public static final Item BROKEN_CHARM = registerItem("broken_charm", new TooltipItem(new FabricItemSettings(),
            List.of("item.mythic_charms.broken_charm.tooltip0"), false));
    public static final Item FRAGILE_CHARM_BASE = registerItem("fragile_charm_base", new Item(new FabricItemSettings()));
    public static final Item DEEPSLATE_FRAGMENT = registerItem("deepslate_fragment", new TooltipItem(new FabricItemSettings(),
            List.of("item.mythic_charms.deepslate_fragment.tooltip0", "item.mythic_charms.deepslate_fragment.tooltip1"), false));
    public static final Item EXPERIENCE_NUGGET = registerItem("experience_nugget", new TooltipItem(new FabricItemSettings(),
            List.of("item.mythic_charms.experience_nugget.tooltip0", "item.mythic_charms.experience_nugget.tooltip1"), false));
    public static final Item GLOWSTONE_NUGGET = registerItem("glowstone_nugget", new Item(new FabricItemSettings()));
    public static final Map<Identifier, Item> FRAGILE_CHARMS = new LinkedHashMap<>();
    public static final Item FRAGILE_CHARM_OF_FEATHERED_GRACE = registerFragileCharm("fragile_charm_of_feathered_grace",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.feathered_grace.tooltip0",
                    "item.mythic_charms.feathered_grace.tooltip1", "item.mythic_charms.feathered_grace.tooltip2"), true));
    public static final Item FRAGILE_CHARM_OF_BLAZING_EMBRACE = registerFragileCharm("fragile_charm_of_blazing_embrace",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.blazing_embrace.tooltip0",
                    "item.mythic_charms.blazing_embrace.tooltip1", "item.mythic_charms.blazing_embrace.tooltip2"), true));
    public static final Item FRAGILE_CHARM_OF_EARTHS_ORDER = registerFragileCharm("fragile_charm_of_earths_order",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.earths_order.tooltip0",
                    "item.mythic_charms.earths_order.tooltip1"), true));
    public static final Item FRAGILE_CHARM_OF_GAZE_SERENITY = registerFragileCharm("fragile_charm_of_gaze_serenity",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.gaze_serenity.tooltip0",
                    "item.mythic_charms.gaze_serenity.tooltip1", "item.mythic_charms.gaze_serenity.tooltip2"), true));
    public static final Item FRAGILE_CHARM_OF_BOTANIC_BLESSING = registerFragileCharm("fragile_charm_of_botanic_blessing",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.botanic_blessing.tooltip0",
                    "item.mythic_charms.botanic_blessing.tooltip1"), true));
    public static final Item FRAGILE_CHARM_OF_FLEETING_STRIDES = registerFragileCharm("fragile_charm_of_fleeting_strides",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.fleeting_strides.tooltip0",
                    "item.mythic_charms.fleeting_strides.tooltip1"), true));
    public static final Item FRAGILE_CHARM_OF_NIGHTS_GUARDIAN = registerFragileCharm("fragile_charm_of_nights_guardian",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.nights_guardian.tooltip0",
                    "item.mythic_charms.nights_guardian.tooltip1", "item.mythic_charms.nights_guardian.tooltip2"), true));
    public static final Item FRAGILE_CHARM_OF_HIGH_BOUNDS = registerFragileCharm("fragile_charm_of_high_bounds",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.high_bounds.tooltip0",
                    "item.mythic_charms.high_bounds.tooltip1", "item.mythic_charms.high_bounds.tooltip2"), true));
    public static final Item FRAGILE_CHARM_OF_DROWNED_FREEDOM = registerFragileCharm("fragile_charm_of_drowned_freedom",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.drowned_freedom.tooltip0",
                    "item.mythic_charms.drowned_freedom.tooltip1", "item.mythic_charms.drowned_freedom.tooltip2"), true));
    public static final Item FRAGILE_CHARM_OF_WEIGHTLESS_FLOW = registerFragileCharm("fragile_charm_of_weightless_flow",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.weightless_flow.tooltip0",
                    "item.mythic_charms.weightless_flow.tooltip1", "item.mythic_charms.weightless_flow.tooltip2"), true));
    public static final Item FRAGILE_CHARM_OF_COLLECTORS_GIFT = registerFragileCharm("fragile_charm_of_collectors_gift",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.collectors_gift.tooltip0",
                    "item.mythic_charms.collectors_gift.tooltip1"), true));
    public static final Item FRAGILE_CHARM_OF_CLIMBERS_PATH = registerFragileCharm("fragile_charm_of_climbers_path",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.climbers_path.tooltip0",
                    "item.mythic_charms.climbers_path.tooltip1", "item.mythic_charms.climbers_path.tooltip2"), true));
    public static final Item FRAGILE_CHARM_OF_NATURES_CALL = registerFragileCharm("fragile_charm_of_natures_call",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.natures_call.tooltip0",
                    "item.mythic_charms.natures_call.tooltip1"), true));
    public static final Item FRAGILE_CHARM_OF_BARTERS_PACT = registerFragileCharm("fragile_charm_of_barters_pact",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.barters_pact.tooltip0",
                    "item.mythic_charms.barters_pact.tooltip1", "item.mythic_charms.barters_pact.tooltip2"), true));
    public static final Item FRAGILE_CHARM_OF_BATTLE_FURY = registerFragileCharm("fragile_charm_of_battle_fury",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.battle_fury.tooltip0",
                    "item.mythic_charms.battle_fury.tooltip1", "item.mythic_charms.battle_fury.tooltip2"), true));
    public static final Item FRAGILE_CHARM_OF_ECHOING_WRATH = registerFragileCharm("fragile_charm_of_echoing_wrath",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.echoing_wrath.tooltip0",
                    "item.mythic_charms.echoing_wrath.tooltip1", "item.mythic_charms.echoing_wrath.tooltip2"), true));
    public static final Item FRAGILE_CHARM_OF_ENCHANTED_WHISPERS = registerFragileCharm("fragile_charm_of_enchanted_whispers",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.enchanted_whispers.tooltip0",
                    "item.mythic_charms.enchanted_whispers.tooltip1", "item.mythic_charms.enchanted_whispers.tooltip2"), true));
    public static final Item FRAGILE_CHARM_OF_ARROW_DANCE = registerFragileCharm("fragile_charm_of_arrow_dance",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.arrow_dance.tooltip0",
                    "item.mythic_charms.arrow_dance.tooltip1"), true));
    public static final Item FRAGILE_CHARM_OF_MOUNTAINS_STRENGTH = registerFragileCharm("fragile_charm_of_mountains_strength",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.mountains_strength.tooltip0",
                    "item.mythic_charms.mountains_strength.tooltip1", "item.mythic_charms.mountains_strength.tooltip2"), true));
    public static final Item FRAGILE_CHARM_OF_SAFE_TERRITORY = registerFragileCharm("fragile_charm_of_safe_territory",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.safe_territory.tooltip0",
                    "item.mythic_charms.safe_territory.tooltip1"), true));
    public static final Item FRAGILE_CHARM_OF_QUIET_PRESENCE = registerFragileCharm("fragile_charm_of_quiet_presence",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), List.of("item.mythic_charms.quiet_presence.tooltip0",
                    "item.mythic_charms.quiet_presence.tooltip1"), true));
    public static final Map<Identifier, Item> UNBREAKABLE_CHARMS = new LinkedHashMap<>();
    public static final Item UNBREAKABLE_CHARM_OF_FEATHERED_GRACE = registerUnbreakableCharm("unbreakable_charm_of_feathered_grace",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.feathered_grace.tooltip0",
                    "item.mythic_charms.feathered_grace.tooltip1", "item.mythic_charms.feathered_grace.tooltip2"), true));
    public static final Item UNBREAKABLE_CHARM_OF_BLAZING_EMBRACE = registerUnbreakableCharm("unbreakable_charm_of_blazing_embrace",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.blazing_embrace.tooltip0",
                    "item.mythic_charms.blazing_embrace.tooltip1", "item.mythic_charms.blazing_embrace.tooltip2"), true));
    public static final Item UNBREAKABLE_CHARM_OF_EARTHS_ORDER = registerUnbreakableCharm("unbreakable_charm_of_earths_order",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.earths_order.tooltip0",
                    "item.mythic_charms.earths_order.tooltip1"), true));
    public static final Item UNBREAKABLE_CHARM_OF_GAZE_SERENITY = registerUnbreakableCharm("unbreakable_charm_of_gaze_serenity",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.gaze_serenity.tooltip0",
                    "item.mythic_charms.gaze_serenity.tooltip1", "item.mythic_charms.gaze_serenity.tooltip2"), true));
    public static final Item UNBREAKABLE_CHARM_OF_BOTANIC_BLESSING = registerUnbreakableCharm("unbreakable_charm_of_botanic_blessing",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.botanic_blessing.tooltip0",
                    "item.mythic_charms.botanic_blessing.tooltip1"), true));
    public static final Item UNBREAKABLE_CHARM_OF_FLEETING_STRIDES = registerUnbreakableCharm("unbreakable_charm_of_fleeting_strides",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.fleeting_strides.tooltip0",
                    "item.mythic_charms.fleeting_strides.tooltip1"), true));
    public static final Item UNBREAKABLE_CHARM_OF_NIGHTS_GUARDIAN = registerUnbreakableCharm("unbreakable_charm_of_nights_guardian",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.nights_guardian.tooltip0",
                    "item.mythic_charms.nights_guardian.tooltip1", "item.mythic_charms.nights_guardian.tooltip2"), true));
    public static final Item UNBREAKABLE_CHARM_OF_HIGH_BOUNDS = registerUnbreakableCharm("unbreakable_charm_of_high_bounds",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.high_bounds.tooltip0",
                    "item.mythic_charms.high_bounds.tooltip1", "item.mythic_charms.high_bounds.tooltip2"), true));
    public static final Item UNBREAKABLE_CHARM_OF_DROWNED_FREEDOM = registerUnbreakableCharm("unbreakable_charm_of_drowned_freedom",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.drowned_freedom.tooltip0",
                    "item.mythic_charms.drowned_freedom.tooltip1", "item.mythic_charms.drowned_freedom.tooltip2"), true));
    public static final Item UNBREAKABLE_CHARM_OF_WEIGHTLESS_FLOW = registerUnbreakableCharm("unbreakable_charm_of_weightless_flow",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.weightless_flow.tooltip0",
                    "item.mythic_charms.weightless_flow.tooltip1", "item.mythic_charms.weightless_flow.tooltip2"), true));
    public static final Item UNBREAKABLE_CHARM_OF_COLLECTORS_GIFT = registerUnbreakableCharm("unbreakable_charm_of_collectors_gift",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.collectors_gift.tooltip0",
                    "item.mythic_charms.collectors_gift.tooltip1"), true));
    public static final Item UNBREAKABLE_CHARM_OF_CLIMBERS_PATH = registerUnbreakableCharm("unbreakable_charm_of_climbers_path",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.climbers_path.tooltip0",
                    "item.mythic_charms.climbers_path.tooltip1", "item.mythic_charms.climbers_path.tooltip2"), true));
    public static final Item UNBREAKABLE_CHARM_OF_NATURES_CALL = registerUnbreakableCharm("unbreakable_charm_of_natures_call",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.natures_call.tooltip0",
                    "item.mythic_charms.natures_call.tooltip1"), true));
    public static final Item UNBREAKABLE_CHARM_OF_BARTERS_PACT = registerUnbreakableCharm("unbreakable_charm_of_barters_pact",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.barters_pact.tooltip0",
                    "item.mythic_charms.barters_pact.tooltip1", "item.mythic_charms.barters_pact.tooltip2"), true));
    public static final Item UNBREAKABLE_CHARM_OF_BATTLE_FURY = registerUnbreakableCharm("unbreakable_charm_of_battle_fury",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.battle_fury.tooltip0",
                    "item.mythic_charms.battle_fury.tooltip1", "item.mythic_charms.battle_fury.tooltip2"), true));
    public static final Item UNBREAKABLE_CHARM_OF_ECHOING_WRATH = registerUnbreakableCharm("unbreakable_charm_of_echoing_wrath",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.echoing_wrath.tooltip0",
                    "item.mythic_charms.echoing_wrath.tooltip1", "item.mythic_charms.echoing_wrath.tooltip2"), true));
    public static final Item UNBREAKABLE_CHARM_OF_ENCHANTED_WHISPERS = registerUnbreakableCharm("unbreakable_charm_of_enchanted_whispers",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.enchanted_whispers.tooltip0",
                    "item.mythic_charms.enchanted_whispers.tooltip1", "item.mythic_charms.enchanted_whispers.tooltip2"), true));
    public static final Item UNBREAKABLE_CHARM_OF_ARROW_DANCE = registerUnbreakableCharm("unbreakable_charm_of_arrow_dance",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.arrow_dance.tooltip0",
                    "item.mythic_charms.arrow_dance.tooltip1"), true));
    public static final Item UNBREAKABLE_CHARM_OF_MOUNTAINS_STRENGTH = registerUnbreakableCharm("unbreakable_charm_of_mountains_strength",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.mountains_strength.tooltip0",
                    "item.mythic_charms.mountains_strength.tooltip1", "item.mythic_charms.mountains_strength.tooltip2"), true));
    public static final Item UNBREAKABLE_CHARM_OF_SAFE_TERRITORY = registerUnbreakableCharm("unbreakable_charm_of_safe_territory",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.safe_territory.tooltip0",
                    "item.mythic_charms.safe_territory.tooltip1"), true));
    public static final Item UNBREAKABLE_CHARM_OF_QUIET_PRESENCE = registerUnbreakableCharm("unbreakable_charm_of_quiet_presence",
            new TooltipItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), List.of("item.mythic_charms.quiet_presence.tooltip0",
                    "item.mythic_charms.quiet_presence.tooltip1"), true));

    private static Item registerFragileCharm(String name, Item item) {
        FRAGILE_CHARMS.put(MythicCharms.id(name), item);
        return Registry.register(Registries.ITEM, new Identifier(MythicCharms.MOD_ID, name), item);
    }

    private static Item registerUnbreakableCharm(String name, Item item) {
        UNBREAKABLE_CHARMS.put(MythicCharms.id(name), item);
        return Registry.register(Registries.ITEM, new Identifier(MythicCharms.MOD_ID, name), item);
    }

    private static Item registerItem(String name, Item item) {

        return Registry.register(Registries.ITEM, new Identifier(MythicCharms.MOD_ID, name), item);

    }

    private static void addItemsToToolsTabItemGroup(FabricItemGroupEntries entries) {

        entries.add(RESONANCE_RING);
        entries.add(BROKEN_CHARM);
        entries.add(FRAGILE_CHARM_BASE);

        entries.add(FRAGILE_CHARM_OF_FEATHERED_GRACE);
        entries.add(FRAGILE_CHARM_OF_BLAZING_EMBRACE);
        entries.add(FRAGILE_CHARM_OF_EARTHS_ORDER);
        entries.add(FRAGILE_CHARM_OF_GAZE_SERENITY);
        entries.add(FRAGILE_CHARM_OF_BOTANIC_BLESSING);
        entries.add(FRAGILE_CHARM_OF_FLEETING_STRIDES);
        entries.add(FRAGILE_CHARM_OF_NIGHTS_GUARDIAN);
        entries.add(FRAGILE_CHARM_OF_HIGH_BOUNDS);
        entries.add(FRAGILE_CHARM_OF_DROWNED_FREEDOM);
        entries.add(FRAGILE_CHARM_OF_WEIGHTLESS_FLOW);
        entries.add(FRAGILE_CHARM_OF_COLLECTORS_GIFT);
        entries.add(FRAGILE_CHARM_OF_CLIMBERS_PATH);
        entries.add(FRAGILE_CHARM_OF_NATURES_CALL);
        entries.add(FRAGILE_CHARM_OF_BARTERS_PACT);
        entries.add(FRAGILE_CHARM_OF_BATTLE_FURY);
        entries.add(FRAGILE_CHARM_OF_ECHOING_WRATH);
        entries.add(FRAGILE_CHARM_OF_ENCHANTED_WHISPERS);
        entries.add(FRAGILE_CHARM_OF_ARROW_DANCE);
        entries.add(FRAGILE_CHARM_OF_MOUNTAINS_STRENGTH);
        entries.add(FRAGILE_CHARM_OF_SAFE_TERRITORY);
        entries.add(FRAGILE_CHARM_OF_QUIET_PRESENCE);

        entries.add(UNBREAKABLE_CHARM_OF_FEATHERED_GRACE);
        entries.add(UNBREAKABLE_CHARM_OF_BLAZING_EMBRACE);
        entries.add(UNBREAKABLE_CHARM_OF_EARTHS_ORDER);
        entries.add(UNBREAKABLE_CHARM_OF_GAZE_SERENITY);
        entries.add(UNBREAKABLE_CHARM_OF_BOTANIC_BLESSING);
        entries.add(UNBREAKABLE_CHARM_OF_FLEETING_STRIDES);
        entries.add(UNBREAKABLE_CHARM_OF_NIGHTS_GUARDIAN);
        entries.add(UNBREAKABLE_CHARM_OF_HIGH_BOUNDS);
        entries.add(UNBREAKABLE_CHARM_OF_DROWNED_FREEDOM);
        entries.add(UNBREAKABLE_CHARM_OF_WEIGHTLESS_FLOW);
        entries.add(UNBREAKABLE_CHARM_OF_COLLECTORS_GIFT);
        entries.add(UNBREAKABLE_CHARM_OF_CLIMBERS_PATH);
        entries.add(UNBREAKABLE_CHARM_OF_NATURES_CALL);
        entries.add(UNBREAKABLE_CHARM_OF_BARTERS_PACT);
        entries.add(UNBREAKABLE_CHARM_OF_BATTLE_FURY);
        entries.add(UNBREAKABLE_CHARM_OF_ECHOING_WRATH);
        entries.add(UNBREAKABLE_CHARM_OF_ENCHANTED_WHISPERS);
        entries.add(UNBREAKABLE_CHARM_OF_ARROW_DANCE);
        entries.add(UNBREAKABLE_CHARM_OF_MOUNTAINS_STRENGTH);
        entries.add(UNBREAKABLE_CHARM_OF_SAFE_TERRITORY);
        entries.add(UNBREAKABLE_CHARM_OF_QUIET_PRESENCE);
    }

    private static void addItemsToIngredientsTabItemGroup(FabricItemGroupEntries entries) {

        entries.add(DEEPSLATE_FRAGMENT);
        entries.add(EXPERIENCE_NUGGET);
        entries.add(GLOWSTONE_NUGGET);

    }

    public static void registerModItems() {

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsTabItemGroup);

    }

}
