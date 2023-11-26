package net.masik.mythiccharms.util;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.masik.mythiccharms.util.MythicCharmsConfig;

import java.util.*;

public class CharmHelper {

    private static final MythicCharmsConfig config = MythicCharms.CONFIG;

    public static boolean charmFeatheredGraceEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmFeatheredGraceEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FEATHERED_GRACE));

    }

    public static boolean charmBlazingEmbraceEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmBlazingEmbraceEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BLAZING_EMBRACE) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BLAZING_EMBRACE));

    }

    public static boolean charmEarthsOrderEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmEarthsOrderEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_EARTHS_ORDER) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_EARTHS_ORDER));

    }

    public static boolean charmGazeSerenityEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmGazeSerenityEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_GAZE_SERENITY) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_GAZE_SERENITY));

    }

    public static boolean charmBotanicBlessingEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmBotanicBlessingEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BOTANIC_BLESSING) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BOTANIC_BLESSING));

    }

    public static boolean charmFleetingStridesEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmFleetingStridesEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_FLEETING_STRIDES) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FLEETING_STRIDES));

    }

    public static boolean charmNightsGuardianEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmNightsGuardianEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_NIGHTS_GUARDIAN) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_NIGHTS_GUARDIAN));

    }

    public static boolean charmHighBoundsEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmHighBoundsEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_HIGH_BOUNDS) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_HIGH_BOUNDS));

    }

    public static boolean charmDrownedFreedomEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmDrownedFreedomEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_DROWNED_FREEDOM) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_DROWNED_FREEDOM));

    }

    public static boolean charmWeightlessFlowEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmWeightlessFlowEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_WEIGHTLESS_FLOW) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_WEIGHTLESS_FLOW));

    }

    public static boolean charmCollectorsGiftEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmCollectorsGiftEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_COLLECTORS_GIFT) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_COLLECTORS_GIFT));

    }

    public static boolean charmClimbersPathEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmClimbersPathEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_CLIMBERS_PATH) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_CLIMBERS_PATH));

    }

    public static boolean charmNaturesCallEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmNaturesCallEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_NATURES_CALL) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_NATURES_CALL));

    }

    public static boolean charmBartersPactEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmBartersPactEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BARTERS_PACT) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BARTERS_PACT));

    }

    public static boolean charmBattleFuryEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmBattleFuryEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BATTLE_FURY));

    }

    public static boolean charmEchoingWrathEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmEchoingWrathEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_ECHOING_WRATH) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_ECHOING_WRATH));

    }

    public static boolean charmEnchantedWhispersEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmEnchantedWhispersEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_ENCHANTED_WHISPERS) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_ENCHANTED_WHISPERS));

    }

    public static boolean charmArrowDanceEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmArrowDanceEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_ARROW_DANCE) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_ARROW_DANCE));

    }

    public static boolean charmMountainsStrengthEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmMountainsStrengthEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_MOUNTAINS_STRENGTH) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_MOUNTAINS_STRENGTH));

    }

    public static boolean charmSafeTerritoryEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmSafeTerritoryEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_SAFE_TERRITORY) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_SAFE_TERRITORY));

    }

    public static boolean charmQuietPresenceEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.CharmQuietPresenceEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_QUIET_PRESENCE) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_QUIET_PRESENCE));

    }





    public static boolean charmCombinationFeatheredGraceAndHighBoundsEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.CharmCombinationFeatheredGraceAndHighBoundsEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FEATHERED_GRACE)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_HIGH_BOUNDS) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_HIGH_BOUNDS));

    }

    public static boolean charmCombinationBlazingEmbraceAndBattleFuryEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.CharmCombinationBlazingEmbraceAndBattleFuryEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BLAZING_EMBRACE) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BLAZING_EMBRACE)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BATTLE_FURY));

    }

    public static boolean charmCombinationEarthsOrderAndBlazingEmbraceEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.CharmCombinationEarthsOrderAndBlazingEmbraceEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_EARTHS_ORDER) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_EARTHS_ORDER)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BLAZING_EMBRACE) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BLAZING_EMBRACE));

    }

    public static boolean charmCombinationEarthsOrderAndDrownedFreedomEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.CharmCombinationEarthsOrderAndDrownedFreedomEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_EARTHS_ORDER) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_EARTHS_ORDER)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_DROWNED_FREEDOM) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_DROWNED_FREEDOM));

    }

    public static boolean charmCombinationEarthsOrderAndWeightlessFlowEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.CharmCombinationEarthsOrderAndWeightlessFlowEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_EARTHS_ORDER) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_EARTHS_ORDER)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_WEIGHTLESS_FLOW) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_WEIGHTLESS_FLOW));

    }

    public static boolean charmCombinationEarthsOrderAndBattleFuryEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.CharmCombinationEarthsOrderAndBattleFuryEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_EARTHS_ORDER) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_EARTHS_ORDER)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BATTLE_FURY));

    }

    public static boolean charmCombinationBotanicBlessingAndFeatheredGraceEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.CharmCombinationBotanicBlessingAndFeatheredGraceEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BOTANIC_BLESSING) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BOTANIC_BLESSING)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FEATHERED_GRACE));

    }

    public static boolean charmCombinationFleetingStridesAndHighBoundsEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.CharmCombinationFleetingStridesAndHighBoundsEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_FLEETING_STRIDES) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FLEETING_STRIDES)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_HIGH_BOUNDS) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_HIGH_BOUNDS));

    }

    public static boolean charmCombinationFleetingStridesAndBattleFuryEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.CharmCombinationFleetingStridesAndBattleFuryEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_FLEETING_STRIDES) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FLEETING_STRIDES)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BATTLE_FURY));

    }

    public static boolean charmCombinationWeightlessFlowAndFeatheredGraceEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.CharmCombinationWeightlessFlowAndFeatheredGraceEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_WEIGHTLESS_FLOW) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_WEIGHTLESS_FLOW)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FEATHERED_GRACE));

    }

    public static boolean charmCombinationClimbersPathAndHighBoundsEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.CharmCombinationClimbersPathAndHighBoundsEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_CLIMBERS_PATH) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_CLIMBERS_PATH)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_HIGH_BOUNDS) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_HIGH_BOUNDS));

    }

    public static boolean charmCombinationEchoingWrathAndBlazingEmbraceEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.CharmCombinationEchoingWrathAndBlazingEmbraceEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_ECHOING_WRATH) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_ECHOING_WRATH)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BLAZING_EMBRACE) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BLAZING_EMBRACE));

    }

    public static boolean charmCombinationEchoingWrathAndBattleFuryEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.CharmCombinationEchoingWrathAndBattleFuryEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_ECHOING_WRATH) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_ECHOING_WRATH)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BATTLE_FURY));

    }

    public static boolean charmCombinationQuietPresenceAndFeatheredGraceEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.CharmCombinationQuietPresenceAndFeatheredGraceEnabled( )) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_QUIET_PRESENCE) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_QUIET_PRESENCE)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FEATHERED_GRACE));

    }

    public static ArrayList<Set<String>> combinations = new ArrayList<>() {{
        add(new HashSet<>(List.of(new String[]{"feathered_grace", "high_bounds"})));
        add(new HashSet<>(List.of(new String[]{"blazing_embrace", "battle_fury"})));
        add(new HashSet<>(List.of(new String[]{"earths_order", "blazing_embrace"})));
        add(new HashSet<>(List.of(new String[]{"earths_order", "drowned_freedom"})));
        add(new HashSet<>(List.of(new String[]{"earths_order", "weightless_flow"})));
        add(new HashSet<>(List.of(new String[]{"earths_order", "battle_fury"})));
        add(new HashSet<>(List.of(new String[]{"botanic_blessing", "feathered_grace"})));
        add(new HashSet<>(List.of(new String[]{"fleeting_strides", "high_bounds"})));
        add(new HashSet<>(List.of(new String[]{"fleeting_strides", "battle_fury"})));
        add(new HashSet<>(List.of(new String[]{"weightless_flow", "feathered_grace"})));
        add(new HashSet<>(List.of(new String[]{"climbers_path", "high_bounds"})));
        add(new HashSet<>(List.of(new String[]{"echoing_wrath", "blazing_embrace"})));
        add(new HashSet<>(List.of(new String[]{"echoing_wrath", "battle_fury"})));
        add(new HashSet<>(List.of(new String[]{"quiet_presence", "feathered_grace"})));
    }};

}
