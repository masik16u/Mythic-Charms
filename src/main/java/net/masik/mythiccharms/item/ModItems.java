package net.masik.mythiccharms.item;

import dev.emi.trinkets.api.TrinketItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.sound.ModSounds;
import net.minecraft.block.DecoratedPotPatterns;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;

public class ModItems {

    //DEEPSLATE CORE
    private static final Text DEEPSLATE_CORE_TEXT = Text.translatable("item.mythic_charms.deepslate_core").formatted(Formatting.GRAY);
    private static final Text DEEPSLATE_CORE_APPLIES_TO_TEXT = Text.translatable("item.mythic_charms.deepslate_core.applies_to").formatted(Formatting.BLUE);
    private static final Text DEEPSLATE_CORE_INGREDIENTS_TEXT = Text.translatable("item.mythic_charms.deepslate_core.ingredients").formatted(Formatting.BLUE);
    private static final Text DEEPSLATE_CORE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable("item.mythic_charms.deepslate_core.base_slot_description");
    private static final Text DEEPSLATE_CORE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable("item.mythic_charms.deepslate_core.additions_slot_description");
    private static final Identifier EMPTY_SLOT_CHARM_TEXTURE = new Identifier(MythicCharms.MOD_ID, "item/empty_slot_charm");
    public static final Item DEEPSLATE_CORE = registerItem("deepslate_core",
            new SmithingTemplateItem(DEEPSLATE_CORE_APPLIES_TO_TEXT, DEEPSLATE_CORE_INGREDIENTS_TEXT,
                    DEEPSLATE_CORE_TEXT, DEEPSLATE_CORE_BASE_SLOT_DESCRIPTION_TEXT,
                    DEEPSLATE_CORE_ADDITIONS_SLOT_DESCRIPTION_TEXT, List.of(EMPTY_SLOT_CHARM_TEXTURE),
                    List.of(new Identifier("item/empty_slot_ingot"))));

    //OTHER ITEMS
    public static final Item RESONANCE_RING = registerItem("resonance_ring",
            new TrinketItem(new FabricItemSettings().maxCount(1)));
    public static final Item RESONANCE_COMPASS = registerItem("resonance_compass",
            new ResonanceCompassItem(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));
    public static final Item BROKEN_CHARM = registerItem("broken_charm",
            new TooltipItem(new FabricItemSettings(), false));
    public static final Item FRAGILE_CHARM_BASE = registerItem("fragile_charm_base",
            new Item(new FabricItemSettings()));
    public static final Item DISC_FRAGMENT_RESONANCE = registerItem("disc_fragment_resonance",
            new TooltipItem(new FabricItemSettings(), false));
    public static final Item MUSIC_DISC_RESONANCE = registerItem("music_disc_resonance", new MusicDiscItem(
            9, ModSounds.MUSIC_DISC_RESONANCE, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE),
            45));
    public static final Item MUSIC_DISC_MYTH = registerItem("music_disc_myth", new MusicDiscItem(
            13, ModSounds.MUSIC_DISC_MYTH, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE),
            43));



    //POTTERY SHERDS
    public static final Item RESONANCE_POTTERY_SHERD = registerItem("resonance_pottery_sherd",
            new Item(new FabricItemSettings()));
    public static final Item CRYSTAL_POTTERY_SHERD = registerItem("crystal_pottery_sherd",
            new Item(new FabricItemSettings()));
    public static final Item CORE_POTTERY_SHERD = registerItem("core_pottery_sherd",
            new Item(new FabricItemSettings()));
    public static final Item FARMER_POTTERY_SHERD = registerItem("farmer_pottery_sherd",
            new Item(new FabricItemSettings()));
    public static final Item FARMLAND_POTTERY_SHERD = registerItem("farmland_pottery_sherd",
            new Item(new FabricItemSettings()));
    public static final Item BODY_POTTERY_SHERD = registerItem("body_pottery_sherd",
            new Item(new FabricItemSettings()));
    public static final Item PROPHECY_POTTERY_SHERD = registerItem("prophecy_pottery_sherd",
            new Item(new FabricItemSettings()));
    public static final Item FREEDOM_POTTERY_SHERD = registerItem("freedom_pottery_sherd",
            new Item(new FabricItemSettings()));
    public static final Item MOUNTAIN_POTTERY_SHERD = registerItem("mountain_pottery_sherd",
            new Item(new FabricItemSettings()));
    public static final Item AID_POTTERY_SHERD = registerItem("aid_pottery_sherd",
            new Item(new FabricItemSettings()));
    public static final Item SAFETY_POTTERY_SHERD = registerItem("safety_pottery_sherd",
            new Item(new FabricItemSettings()));
    public static final Item NATURE_POTTERY_SHERD = registerItem("nature_pottery_sherd",
            new Item(new FabricItemSettings()));
    public static final Item HEAT_POTTERY_SHERD = registerItem("heat_pottery_sherd",
            new Item(new FabricItemSettings()));
    public static final Item FIGHT_POTTERY_SHERD = registerItem("fight_pottery_sherd",
            new Item(new FabricItemSettings()));
    public static final Item GROWTH_POTTERY_SHERD = registerItem("growth_pottery_sherd",
            new Item(new FabricItemSettings()));
    public static final Item GHOST_POTTERY_SHERD = registerItem("ghost_pottery_sherd",
            new Item(new FabricItemSettings()));



    //FRAGILE CHARMS
    public static final Item FRAGILE_CHARM_OF_FEATHERED_GRACE = registerItem("fragile_charm_of_feathered_grace",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));
    public static final Item FRAGILE_CHARM_OF_BLAZING_EMBRACE = registerItem("fragile_charm_of_blazing_embrace",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));
    public static final Item FRAGILE_CHARM_OF_EARTHS_ORDER = registerItem("fragile_charm_of_earths_order",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));
    public static final Item FRAGILE_CHARM_OF_GAZE_SERENITY = registerItem("fragile_charm_of_gaze_serenity",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));
    public static final Item FRAGILE_CHARM_OF_BOTANIC_BLESSING = registerItem("fragile_charm_of_botanic_blessing",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));
    public static final Item FRAGILE_CHARM_OF_FLEETING_STRIDES = registerItem("fragile_charm_of_fleeting_strides",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));
    public static final Item FRAGILE_CHARM_OF_NIGHTS_GUARDIAN = registerItem("fragile_charm_of_nights_guardian",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));
    public static final Item FRAGILE_CHARM_OF_HIGH_BOUNDS = registerItem("fragile_charm_of_high_bounds",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));
    public static final Item FRAGILE_CHARM_OF_DROWNED_FREEDOM = registerItem("fragile_charm_of_drowned_freedom",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));
    public static final Item FRAGILE_CHARM_OF_WEIGHTLESS_FLOW = registerItem("fragile_charm_of_weightless_flow",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));
    public static final Item FRAGILE_CHARM_OF_COLLECTORS_GIFT = registerItem("fragile_charm_of_collectors_gift",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));
    public static final Item FRAGILE_CHARM_OF_CLIMBERS_PATH = registerItem("fragile_charm_of_climbers_path",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));
    public static final Item FRAGILE_CHARM_OF_NATURES_CALL = registerItem("fragile_charm_of_natures_call",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));
    public static final Item FRAGILE_CHARM_OF_BARTERS_PACT = registerItem("fragile_charm_of_barters_pact",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));
    public static final Item FRAGILE_CHARM_OF_BATTLE_FURY = registerItem("fragile_charm_of_battle_fury",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));
    public static final Item FRAGILE_CHARM_OF_ECHOING_WRATH = registerItem("fragile_charm_of_echoing_wrath",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));
    public static final Item FRAGILE_CHARM_OF_ENCHANTED_WHISPERS = registerItem("fragile_charm_of_enchanted_whispers",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));
    public static final Item FRAGILE_CHARM_OF_ARROW_DANCE = registerItem("fragile_charm_of_arrow_dance",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));
    public static final Item FRAGILE_CHARM_OF_MOUNTAINS_STRENGTH = registerItem("fragile_charm_of_mountains_strength",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));
    public static final Item FRAGILE_CHARM_OF_SAFE_TERRITORY = registerItem("fragile_charm_of_safe_territory",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));
    public static final Item FRAGILE_CHARM_OF_QUIET_PRESENCE = registerItem("fragile_charm_of_quiet_presence",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), true));



    //UNBREAKABLE CHARMS
    public static final Item UNBREAKABLE_CHARM_OF_FEATHERED_GRACE = registerItem("unbreakable_charm_of_feathered_grace",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));
    public static final Item UNBREAKABLE_CHARM_OF_BLAZING_EMBRACE = registerItem("unbreakable_charm_of_blazing_embrace",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));
    public static final Item UNBREAKABLE_CHARM_OF_EARTHS_ORDER = registerItem("unbreakable_charm_of_earths_order",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));
    public static final Item UNBREAKABLE_CHARM_OF_GAZE_SERENITY = registerItem("unbreakable_charm_of_gaze_serenity",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));
    public static final Item UNBREAKABLE_CHARM_OF_BOTANIC_BLESSING = registerItem("unbreakable_charm_of_botanic_blessing",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));
    public static final Item UNBREAKABLE_CHARM_OF_FLEETING_STRIDES = registerItem("unbreakable_charm_of_fleeting_strides",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));
    public static final Item UNBREAKABLE_CHARM_OF_NIGHTS_GUARDIAN = registerItem("unbreakable_charm_of_nights_guardian",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));
    public static final Item UNBREAKABLE_CHARM_OF_HIGH_BOUNDS = registerItem("unbreakable_charm_of_high_bounds",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));
    public static final Item UNBREAKABLE_CHARM_OF_DROWNED_FREEDOM = registerItem("unbreakable_charm_of_drowned_freedom",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));
    public static final Item UNBREAKABLE_CHARM_OF_WEIGHTLESS_FLOW = registerItem("unbreakable_charm_of_weightless_flow",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));
    public static final Item UNBREAKABLE_CHARM_OF_COLLECTORS_GIFT = registerItem("unbreakable_charm_of_collectors_gift",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));
    public static final Item UNBREAKABLE_CHARM_OF_CLIMBERS_PATH = registerItem("unbreakable_charm_of_climbers_path",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));
    public static final Item UNBREAKABLE_CHARM_OF_NATURES_CALL = registerItem("unbreakable_charm_of_natures_call",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));
    public static final Item UNBREAKABLE_CHARM_OF_BARTERS_PACT = registerItem("unbreakable_charm_of_barters_pact",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));
    public static final Item UNBREAKABLE_CHARM_OF_BATTLE_FURY = registerItem("unbreakable_charm_of_battle_fury",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));
    public static final Item UNBREAKABLE_CHARM_OF_ECHOING_WRATH = registerItem("unbreakable_charm_of_echoing_wrath",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));
    public static final Item UNBREAKABLE_CHARM_OF_ENCHANTED_WHISPERS = registerItem("unbreakable_charm_of_enchanted_whispers",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));
    public static final Item UNBREAKABLE_CHARM_OF_ARROW_DANCE = registerItem("unbreakable_charm_of_arrow_dance",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));
    public static final Item UNBREAKABLE_CHARM_OF_MOUNTAINS_STRENGTH = registerItem("unbreakable_charm_of_mountains_strength",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));
    public static final Item UNBREAKABLE_CHARM_OF_SAFE_TERRITORY = registerItem("unbreakable_charm_of_safe_territory",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));
    public static final Item UNBREAKABLE_CHARM_OF_QUIET_PRESENCE = registerItem("unbreakable_charm_of_quiet_presence",
            new TooltipTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof(), true));



    //SOUND CARVING PATTERNS
    public static final Item SOUND_CARVING_PATTERN_FEATHERED_GRACE = registerItem("sound_carving_pattern_feathered_grace",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));
    public static final Item SOUND_CARVING_PATTERN_BLAZING_EMBRACE = registerItem("sound_carving_pattern_blazing_embrace",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));
    public static final Item SOUND_CARVING_PATTERN_EARTHS_ORDER = registerItem("sound_carving_pattern_earths_order",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));
    public static final Item SOUND_CARVING_PATTERN_GAZE_SERENITY = registerItem("sound_carving_pattern_gaze_serenity",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));
    public static final Item SOUND_CARVING_PATTERN_BOTANIC_BLESSING = registerItem("sound_carving_pattern_botanic_blessing",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));
    public static final Item SOUND_CARVING_PATTERN_FLEETING_STRIDES = registerItem("sound_carving_pattern_fleeting_strides",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));
    public static final Item SOUND_CARVING_PATTERN_NIGHTS_GUARDIAN = registerItem("sound_carving_pattern_nights_guardian",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));
    public static final Item SOUND_CARVING_PATTERN_HIGH_BOUNDS = registerItem("sound_carving_pattern_high_bounds",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));
    public static final Item SOUND_CARVING_PATTERN_DROWNED_FREEDOM = registerItem("sound_carving_pattern_drowned_freedom",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));
    public static final Item SOUND_CARVING_PATTERN_WEIGHTLESS_FLOW = registerItem("sound_carving_pattern_weightless_flow",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));
    public static final Item SOUND_CARVING_PATTERN_COLLECTORS_GIFT = registerItem("sound_carving_pattern_collectors_gift",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));
    public static final Item SOUND_CARVING_PATTERN_CLIMBERS_PATH = registerItem("sound_carving_pattern_climbers_path",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));
    public static final Item SOUND_CARVING_PATTERN_NATURES_CALL = registerItem("sound_carving_pattern_natures_call",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));
    public static final Item SOUND_CARVING_PATTERN_BARTERS_PACT = registerItem("sound_carving_pattern_barters_pact",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));
    public static final Item SOUND_CARVING_PATTERN_BATTLE_FURY = registerItem("sound_carving_pattern_battle_fury",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));
    public static final Item SOUND_CARVING_PATTERN_ECHOING_WRATH = registerItem("sound_carving_pattern_echoing_wrath",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));
    public static final Item SOUND_CARVING_PATTERN_ENCHANTED_WHISPERS = registerItem("sound_carving_pattern_enchanted_whispers",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));
    public static final Item SOUND_CARVING_PATTERN_ARROW_DANCE = registerItem("sound_carving_pattern_arrow_dance",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));
    public static final Item SOUND_CARVING_PATTERN_MOUNTAINS_STRENGTH = registerItem("sound_carving_pattern_mountains_strength",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));
    public static final Item SOUND_CARVING_PATTERN_SAFE_TERRITORY = registerItem("sound_carving_pattern_safe_territory",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));
    public static final Item SOUND_CARVING_PATTERN_QUIET_PRESENCE = registerItem("sound_carving_pattern_quiet_presence",
            new TooltipItem(new FabricItemSettings().rarity(Rarity.UNCOMMON), false));

    private static Item registerItem(String name, Item item) {

        return Registry.register(Registries.ITEM, new Identifier(MythicCharms.MOD_ID, name), item);

    }

//    private static void addItemsToToolsTabItemGroup(FabricItemGroupEntries entries) {
//        entries.add(RESONANCE_RING);
//    }

//    private static void addItemsToIngredientsTabItemGroup(FabricItemGroupEntries entries) {
//        entries.add(DEEPSLATE_FRAGMENT);
//    }

    public static void registerModItems() {

//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsTabItemGroup);
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsTabItemGroup);

    }

}
