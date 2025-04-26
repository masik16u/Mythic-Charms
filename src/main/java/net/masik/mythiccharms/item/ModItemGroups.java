package net.masik.mythiccharms.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MYTHIC_CHARMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MythicCharms.MOD_ID, "mythic_charms_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.mythic_charms"))
                    .icon(() -> new ItemStack(ModBlocks.RESONANCE_TABLE)).entries((displayContext, entries) -> {

                        // Blocks
                        entries.add(ModBlocks.RESONANCE_TABLE);
                        entries.add(ModBlocks.AMETHYST_LAMP);
                        entries.add(ModBlocks.AMETHYST_EMBEDDED_STONE_PILLAR);
                        entries.add(ModBlocks.AMETHYST_EMBEDDED_DEEPSLATE_PILLAR);
                        entries.add(ModBlocks.AMETHYST_EMBEDDED_CHISELED_STONE);
                        entries.add(ModBlocks.AMETHYST_EMBEDDED_CHISELED_DEEPSLATE);

                        // Useful items
                        entries.add(ModItems.RESONANCE_RING);
                        entries.add(ModItems.RESONANCE_COMPASS);
                        entries.add(ModItems.BROKEN_CHARM);
                        entries.add(ModItems.FRAGILE_CHARM_BASE);
                        entries.add(ModItems.AMETHYST_CORE);

                        entries.add(ModItems.DEEPSLATE_CORE);

                        entries.add(ModItems.ANCIENT_CODEX);

                        // Patterns
                        entries.add(ModItems.SOUND_CARVING_PATTERN_FEATHERED_GRACE);
                        entries.add(ModItems.SOUND_CARVING_PATTERN_BLAZING_EMBRACE);
                        entries.add(ModItems.SOUND_CARVING_PATTERN_EARTHS_ORDER);
                        entries.add(ModItems.SOUND_CARVING_PATTERN_GAZE_SERENITY);
                        entries.add(ModItems.SOUND_CARVING_PATTERN_BOTANIC_BLESSING);
                        entries.add(ModItems.SOUND_CARVING_PATTERN_FLEETING_STRIDES);
                        entries.add(ModItems.SOUND_CARVING_PATTERN_NIGHTS_GUARDIAN);
                        entries.add(ModItems.SOUND_CARVING_PATTERN_HIGH_BOUNDS);
                        entries.add(ModItems.SOUND_CARVING_PATTERN_DROWNED_FREEDOM);
                        entries.add(ModItems.SOUND_CARVING_PATTERN_WEIGHTLESS_FLOW);
                        entries.add(ModItems.SOUND_CARVING_PATTERN_COLLECTORS_GIFT);
                        entries.add(ModItems.SOUND_CARVING_PATTERN_CLIMBERS_PATH);
                        entries.add(ModItems.SOUND_CARVING_PATTERN_NATURES_CALL);
                        entries.add(ModItems.SOUND_CARVING_PATTERN_BARTERS_PACT);
                        entries.add(ModItems.SOUND_CARVING_PATTERN_BATTLE_FURY);
                        entries.add(ModItems.SOUND_CARVING_PATTERN_ECHOING_WRATH);
                        entries.add(ModItems.SOUND_CARVING_PATTERN_ENCHANTED_WHISPERS);
                        entries.add(ModItems.SOUND_CARVING_PATTERN_ARROW_DANCE);
                        entries.add(ModItems.SOUND_CARVING_PATTERN_MOUNTAINS_STRENGTH);
                        entries.add(ModItems.SOUND_CARVING_PATTERN_SAFE_TERRITORY);
                        entries.add(ModItems.SOUND_CARVING_PATTERN_QUIET_PRESENCE);

                        // CHarms
                        entries.add(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE);
                        entries.add(ModItems.FRAGILE_CHARM_OF_BLAZING_EMBRACE);
                        entries.add(ModItems.FRAGILE_CHARM_OF_EARTHS_ORDER);
                        entries.add(ModItems.FRAGILE_CHARM_OF_GAZE_SERENITY);
                        entries.add(ModItems.FRAGILE_CHARM_OF_BOTANIC_BLESSING);
                        entries.add(ModItems.FRAGILE_CHARM_OF_FLEETING_STRIDES);
                        entries.add(ModItems.FRAGILE_CHARM_OF_NIGHTS_GUARDIAN);
                        entries.add(ModItems.FRAGILE_CHARM_OF_HIGH_BOUNDS);
                        entries.add(ModItems.FRAGILE_CHARM_OF_DROWNED_FREEDOM);
                        entries.add(ModItems.FRAGILE_CHARM_OF_WEIGHTLESS_FLOW);
                        entries.add(ModItems.FRAGILE_CHARM_OF_COLLECTORS_GIFT);
                        entries.add(ModItems.FRAGILE_CHARM_OF_CLIMBERS_PATH);
                        entries.add(ModItems.FRAGILE_CHARM_OF_NATURES_CALL);
                        entries.add(ModItems.FRAGILE_CHARM_OF_BARTERS_PACT);
                        entries.add(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY);
                        entries.add(ModItems.FRAGILE_CHARM_OF_ECHOING_WRATH);
                        entries.add(ModItems.FRAGILE_CHARM_OF_ENCHANTED_WHISPERS);
                        entries.add(ModItems.FRAGILE_CHARM_OF_ARROW_DANCE);
                        entries.add(ModItems.FRAGILE_CHARM_OF_MOUNTAINS_STRENGTH);
                        entries.add(ModItems.FRAGILE_CHARM_OF_SAFE_TERRITORY);
                        entries.add(ModItems.FRAGILE_CHARM_OF_QUIET_PRESENCE);

                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_FEATHERED_GRACE);
                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_BLAZING_EMBRACE);
                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_EARTHS_ORDER);
                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_GAZE_SERENITY);
                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_BOTANIC_BLESSING);
                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_FLEETING_STRIDES);
                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_NIGHTS_GUARDIAN);
                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_HIGH_BOUNDS);
                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_DROWNED_FREEDOM);
                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_WEIGHTLESS_FLOW);
                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_COLLECTORS_GIFT);
                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_CLIMBERS_PATH);
                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_NATURES_CALL);
                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_BARTERS_PACT);
                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_BATTLE_FURY);
                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_ECHOING_WRATH);
                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_ENCHANTED_WHISPERS);
                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_ARROW_DANCE);
                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_MOUNTAINS_STRENGTH);
                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_SAFE_TERRITORY);
                        entries.add(ModItems.UNBREAKABLE_CHARM_OF_QUIET_PRESENCE);

                        // Music
                        entries.add(ModItems.DISC_FRAGMENT_RESONANCE);
                        entries.add(ModItems.MUSIC_DISC_RESONANCE);

                        entries.add(ModItems.MUSIC_DISC_MYTH);

                        // Sherds
                        entries.add(ModItems.RESONANCE_POTTERY_SHERD);
                        entries.add(ModItems.CRYSTAL_POTTERY_SHERD);
                        entries.add(ModItems.CORE_POTTERY_SHERD);
                        entries.add(ModItems.FARMER_POTTERY_SHERD);
                        entries.add(ModItems.FARMLAND_POTTERY_SHERD);
                        entries.add(ModItems.BODY_POTTERY_SHERD);
                        entries.add(ModItems.PROPHECY_POTTERY_SHERD);
                        entries.add(ModItems.FREEDOM_POTTERY_SHERD);
                        entries.add(ModItems.MOUNTAIN_POTTERY_SHERD);
                        entries.add(ModItems.AID_POTTERY_SHERD);
                        entries.add(ModItems.SAFETY_POTTERY_SHERD);
                        entries.add(ModItems.NATURE_POTTERY_SHERD);
                        entries.add(ModItems.HEAT_POTTERY_SHERD);
                        entries.add(ModItems.FIGHT_POTTERY_SHERD);
                        entries.add(ModItems.GROWTH_POTTERY_SHERD);
                        entries.add(ModItems.GHOST_POTTERY_SHERD);

                    }).build());

    public static void registerItemGroups() {

    }

}
