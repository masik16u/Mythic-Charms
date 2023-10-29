package net.masik.mythiccharms.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.access.ExtendedTooltipAccessor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModItems {
    public static final Item RESONANCE_RING = registerItem("resonance_ring", new Item(new FabricItemSettings()));
    public static final Item BROKEN_CHARM = registerItem("broken_charm", new Item(new FabricItemSettings()));
    public static final Item FRAGILE_CHARM_BASE = registerItem("fragile_charm_base", new Item(new FabricItemSettings()));
    public static final Item DEEPSLATE_FRAGMENT = registerItem("deepslate_fragment", new Item(new FabricItemSettings()));
    public static final Item EXPERIENCE_NUGGET = registerItem("experience_nugget", new Item(new FabricItemSettings()));
    public static final Item GLOWSTONE_NUGGET = registerItem("glowstone_nugget", new Item(new FabricItemSettings()));
    public static final Map<Identifier, Item> FRAGILE_CHARMS = new LinkedHashMap<>();
    public static final Item FRAGILE_CHARM_OF_FEATHERED_GRACE = registerFragileCharm("fragile_charm_of_feathered_grace",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FRAGILE_CHARM_OF_BLAZING_EMBRACE = registerFragileCharm("fragile_charm_of_blazing_embrace",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FRAGILE_CHARM_OF_EARTHS_ORDER = registerFragileCharm("fragile_charm_of_earths_order",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FRAGILE_CHARM_OF_GAZE_SERENITY = registerFragileCharm("fragile_charm_of_gaze_serenity",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FRAGILE_CHARM_OF_BOTANIC_BLESSING = registerFragileCharm("fragile_charm_of_botanic_blessing",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FRAGILE_CHARM_OF_FLEETING_STRIDES = registerFragileCharm("fragile_charm_of_fleeting_strides",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FRAGILE_CHARM_OF_NIGHTS_GUARDIAN = registerFragileCharm("fragile_charm_of_nights_guardian",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FRAGILE_CHARM_OF_HIGH_BOUNDS = registerFragileCharm("fragile_charm_of_high_bounds",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FRAGILE_CHARM_OF_DROWNED_FREEDOM = registerFragileCharm("fragile_charm_of_drowned_freedom",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FRAGILE_CHARM_OF_WEIGHTLESS_FLOW = registerFragileCharm("fragile_charm_of_weightless_flow",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FRAGILE_CHARM_OF_COLLECTORS_GIFT = registerFragileCharm("fragile_charm_of_collectors_gift",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FRAGILE_CHARM_OF_CLIMBERS_PATH = registerFragileCharm("fragile_charm_of_climbers_path",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FRAGILE_CHARM_OF_NATURES_CALL = registerFragileCharm("fragile_charm_of_natures_call",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FRAGILE_CHARM_OF_BARTERS_PACT = registerFragileCharm("fragile_charm_of_barters_pact",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FRAGILE_CHARM_OF_BATTLE_FURY = registerFragileCharm("fragile_charm_of_battle_fury",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FRAGILE_CHARM_OF_ECHOING_WRATH = registerFragileCharm("fragile_charm_of_echoing_wrath",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FRAGILE_CHARM_OF_ENCHANTED_WHISPERS = registerFragileCharm("fragile_charm_of_enchanted_whispers",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FRAGILE_CHARM_OF_ARROW_DANCE = registerFragileCharm("fragile_charm_of_arrow_dance",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FRAGILE_CHARM_OF_MOUNTAINS_STRENGTH = registerFragileCharm("fragile_charm_of_mountains_strength",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FRAGILE_CHARM_OF_SAFE_TERRITORY = registerFragileCharm("fragile_charm_of_safe_territory",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FRAGILE_CHARM_OF_QUIET_PRESENCE = registerFragileCharm("fragile_charm_of_quiet_presence",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Map<Identifier, Item> UNBREAKABLE_CHARMS = new LinkedHashMap<>();
    public static final Item UNBREAKABLE_CHARM_OF_FEATHERED_GRACE = registerUnbreakableCharm("unbreakable_charm_of_feathered_grace",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item UNBREAKABLE_CHARM_OF_BLAZING_EMBRACE = registerUnbreakableCharm("unbreakable_charm_of_blazing_embrace",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item UNBREAKABLE_CHARM_OF_EARTHS_ORDER = registerUnbreakableCharm("unbreakable_charm_of_earths_order",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item UNBREAKABLE_CHARM_OF_GAZE_SERENITY = registerUnbreakableCharm("unbreakable_charm_of_gaze_serenity",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item UNBREAKABLE_CHARM_OF_BOTANIC_BLESSING = registerUnbreakableCharm("unbreakable_charm_of_botanic_blessing",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item UNBREAKABLE_CHARM_OF_FLEETING_STRIDES = registerUnbreakableCharm("unbreakable_charm_of_fleeting_strides",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item UNBREAKABLE_CHARM_OF_NIGHTS_GUARDIAN = registerUnbreakableCharm("unbreakable_charm_of_nights_guardian",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item UNBREAKABLE_CHARM_OF_HIGH_BOUNDS = registerUnbreakableCharm("unbreakable_charm_of_high_bounds",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item UNBREAKABLE_CHARM_OF_DROWNED_FREEDOM = registerUnbreakableCharm("unbreakable_charm_of_drowned_freedom",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item UNBREAKABLE_CHARM_OF_WEIGHTLESS_FLOW = registerUnbreakableCharm("unbreakable_charm_of_weightless_flow",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item UNBREAKABLE_CHARM_OF_COLLECTORS_GIFT = registerUnbreakableCharm("unbreakable_charm_of_collectors_gift",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item UNBREAKABLE_CHARM_OF_CLIMBERS_PATH = registerUnbreakableCharm("unbreakable_charm_of_climbers_path",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item UNBREAKABLE_CHARM_OF_NATURES_CALL = registerUnbreakableCharm("unbreakable_charm_of_natures_call",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item UNBREAKABLE_CHARM_OF_BARTERS_PACT = registerUnbreakableCharm("unbreakable_charm_of_barters_pact",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item UNBREAKABLE_CHARM_OF_BATTLE_FURY = registerUnbreakableCharm("unbreakable_charm_of_battle_fury",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item UNBREAKABLE_CHARM_OF_ECHOING_WRATH = registerUnbreakableCharm("unbreakable_charm_of_echoing_wrath",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item UNBREAKABLE_CHARM_OF_ENCHANTED_WHISPERS = registerUnbreakableCharm("unbreakable_charm_of_enchanted_whispers",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item UNBREAKABLE_CHARM_OF_ARROW_DANCE = registerUnbreakableCharm("unbreakable_charm_of_arrow_dance",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item UNBREAKABLE_CHARM_OF_MOUNTAINS_STRENGTH = registerUnbreakableCharm("unbreakable_charm_of_mountains_strength",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item UNBREAKABLE_CHARM_OF_SAFE_TERRITORY = registerUnbreakableCharm("unbreakable_charm_of_safe_territory",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item UNBREAKABLE_CHARM_OF_QUIET_PRESENCE = registerUnbreakableCharm("unbreakable_charm_of_quiet_presence",
            new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));

    private static Item registerFragileCharm(String name, Item item) {
        FRAGILE_CHARMS.put(MythicCharms.id(name), item);
        return registerItem(name, item);
    }

    private static Item registerUnbreakableCharm(String name, Item item) {
        UNBREAKABLE_CHARMS.put(MythicCharms.id(name), item);
        return registerItem(name, item);
    }

    private static Item registerItem(String name, Item item) {
        Item registered = Registry.register(Registries.ITEM, new Identifier(MythicCharms.MOD_ID, name), item);
        ((ExtendedTooltipAccessor) registered).setHiddenTooltip("item.mythic_charms.%s.tooltip".formatted(name.replaceAll(".+_of_", "")));
        return registered;
    }

    private static void addItemsToToolsTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(RESONANCE_RING);
        entries.add(BROKEN_CHARM);
        entries.add(FRAGILE_CHARM_BASE);

        entries.addAll(FRAGILE_CHARMS.values().stream().map(Item::getDefaultStack).toList());
        entries.addAll(UNBREAKABLE_CHARMS.values().stream().map(Item::getDefaultStack).toList());
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
