package net.masik.mythiccharms.util;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.config.MythicCharmsConfig;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.entity.LivingEntity;

import java.util.Optional;

public class CharmHelper {
    private static final MythicCharmsConfig config = MythicCharms.CONFIG;

    // In the end I decided that im at home and probably a kid
    /*
    private static final Map<Identifier, Supplier<Boolean>> ITEM_TO_CONFIG = new HashMap<>();

    static {
        ModItems.FRAGILE_CHARMS.forEach((id, item) -> addItem(id));
        ModItems.UNBREAKABLE_CHARMS.forEach((id, item) -> addItem(id));
    }

    private static void addItem(Identifier id) {
        Class<? extends MythicCharmsConfig> configClass = config.getClass();
        String methodName = transformName(id);

        // Reflection, don't try this at home, kids
        try {
            Method option = configClass.getMethod(methodName);
            if (!option.canAccess(configClass)) {
                MythicCharms.LOGGER.warn("Option %s is not accessible".formatted(methodName));
                return;
            }

            ITEM_TO_CONFIG.put(id, () -> {
                try {
                    return (Boolean) option.invoke(configClass);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    MythicCharms.LOGGER.error("Failed to get value for option %s".formatted(methodName));
                    return true;
                }
            });
        } catch (NoSuchMethodException e) {
            MythicCharms.LOGGER.warn("Couldn't find config value %s".formatted(methodName), e);
        }
    }

    private static String transformName(Identifier id) {
        // Wtf
        return "charm%sEnabled".formatted(StringUtils.capitalize(id.getNamespace().replace("fragile_charm_of_", "").replace("_", " ")).replace(" ", ""));
    }
     */

    public static boolean charmFeatheredGraceEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmFeatheredGraceEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FEATHERED_GRACE));

    }

    public static boolean charmBlazingEmbraceEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmBlazingEmbraceEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BLAZING_EMBRACE) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BLAZING_EMBRACE));

    }

    public static boolean charmEarthsOrderEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmEarthsOrderEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_EARTHS_ORDER) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_EARTHS_ORDER));

    }

    public static boolean charmGazeSerenityEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmGazeSerenityEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_GAZE_SERENITY) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_GAZE_SERENITY));

    }

    public static boolean charmBotanicBlessingEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmBotanicBlessingEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BOTANIC_BLESSING) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BOTANIC_BLESSING));

    }

    public static boolean charmFleetingStridesEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmFleetingStridesEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_FLEETING_STRIDES) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FLEETING_STRIDES));

    }

    public static boolean charmNightsGuardianEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmNightsGuardianEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_NIGHTS_GUARDIAN) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_NIGHTS_GUARDIAN));

    }

    public static boolean charmHighBoundsEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmHighBoundsEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_HIGH_BOUNDS) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_HIGH_BOUNDS));

    }

    public static boolean charmDrownedFreedomEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmDrownedFreedomEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_DROWNED_FREEDOM) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_DROWNED_FREEDOM));

    }

    public static boolean charmWeightlessFlowEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmWeightlessFlowEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_WEIGHTLESS_FLOW) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_WEIGHTLESS_FLOW));

    }

    public static boolean charmCollectorsGiftEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmCollectorsGiftEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_COLLECTORS_GIFT) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_COLLECTORS_GIFT));

    }

    public static boolean charmClimbersPathEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmClimbersPathEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_CLIMBERS_PATH) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_CLIMBERS_PATH));

    }

    public static boolean charmNaturesCallEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmNaturesCallEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_NATURES_CALL) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_NATURES_CALL));

    }

    public static boolean charmBartersPactEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmBartersPactEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BARTERS_PACT) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BARTERS_PACT));

    }

    public static boolean charmBattleFuryEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmBattleFuryEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BATTLE_FURY));

    }

    public static boolean charmEchoingWrathEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmEchoingWrathEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_ECHOING_WRATH) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_ECHOING_WRATH));

    }

    public static boolean charmEnchantedWhispersEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmEnchantedWhispersEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_ENCHANTED_WHISPERS) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_ENCHANTED_WHISPERS));

    }

    public static boolean charmArrowDanceEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmArrowDanceEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_ARROW_DANCE) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_ARROW_DANCE));

    }

    public static boolean charmMountainsStrengthEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmMountainsStrengthEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_MOUNTAINS_STRENGTH) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_MOUNTAINS_STRENGTH));

    }

    public static boolean charmSafeTerritoryEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmSafeTerritoryEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_SAFE_TERRITORY) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_SAFE_TERRITORY));

    }

    public static boolean charmQuietPresenceEquipped(LivingEntity entity) {

        if (!config.charmsEnabled.charmQuietPresenceEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_QUIET_PRESENCE) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_QUIET_PRESENCE));

    }


    public static boolean charmCombinationFeatheredGraceAndHighBoundsEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.charmCombinationFeatheredGraceAndHighBoundsEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FEATHERED_GRACE)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_HIGH_BOUNDS) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_HIGH_BOUNDS));

    }

    public static boolean charmCombinationBlazingEmbraceAndBattleFuryEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.charmCombinationBlazingEmbraceAndBattleFuryEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BLAZING_EMBRACE) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BLAZING_EMBRACE)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BATTLE_FURY));

    }

    public static boolean charmCombinationEarthsOrderAndBlazingEmbraceEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.charmCombinationEarthsOrderAndBlazingEmbraceEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_EARTHS_ORDER) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_EARTHS_ORDER)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BLAZING_EMBRACE) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BLAZING_EMBRACE));

    }

    public static boolean charmCombinationEarthsOrderAndDrownedFreedomEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.charmCombinationEarthsOrderAndDrownedFreedomEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_EARTHS_ORDER) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_EARTHS_ORDER)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_DROWNED_FREEDOM) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_DROWNED_FREEDOM));

    }

    public static boolean charmCombinationEarthsOrderAndWeightlessFlowEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.charmCombinationEarthsOrderAndWeightlessFlowEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_EARTHS_ORDER) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_EARTHS_ORDER)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_WEIGHTLESS_FLOW) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_WEIGHTLESS_FLOW));

    }

    public static boolean charmCombinationEarthsOrderAndBattleFuryEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.charmCombinationEarthsOrderAndBattleFuryEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_EARTHS_ORDER) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_EARTHS_ORDER)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BATTLE_FURY));

    }

    public static boolean charmCombinationBotanicBlessingAndFeatheredGraceEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.charmCombinationBotanicBlessingAndFeatheredGraceEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BOTANIC_BLESSING) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BOTANIC_BLESSING)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FEATHERED_GRACE));

    }

    public static boolean charmCombinationFleetingStridesAndHighBoundsEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.charmCombinationFleetingStridesAndHighBoundsEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_FLEETING_STRIDES) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FLEETING_STRIDES)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_HIGH_BOUNDS) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_HIGH_BOUNDS));

    }

    public static boolean charmCombinationFleetingStridesAndBattleFuryEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.charmCombinationFleetingStridesAndBattleFuryEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_FLEETING_STRIDES) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FLEETING_STRIDES)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BATTLE_FURY));

    }

    public static boolean charmCombinationWeightlessFlowAndFeatheredGraceEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.charmCombinationWeightlessFlowAndFeatheredGraceEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_WEIGHTLESS_FLOW) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_WEIGHTLESS_FLOW)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FEATHERED_GRACE));

    }

    public static boolean charmCombinationClimbersPathAndHighBoundsEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.charmCombinationClimbersPathAndHighBoundsEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_CLIMBERS_PATH) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_CLIMBERS_PATH)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_HIGH_BOUNDS) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_HIGH_BOUNDS));

    }

    public static boolean charmCombinationEchoingWrathAndBlazingEmbraceEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.charmCombinationEchoingWrathAndBlazingEmbraceEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_ECHOING_WRATH) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_ECHOING_WRATH)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BLAZING_EMBRACE) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BLAZING_EMBRACE));

    }

    public static boolean charmCombinationEchoingWrathAndBattleFuryEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.charmCombinationEchoingWrathAndBattleFuryEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_ECHOING_WRATH) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_ECHOING_WRATH)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BATTLE_FURY));

    }

    public static boolean charmCombinationQuietPresenceAndFeatheredGraceEnabled(LivingEntity entity) {

        if (!config.charmCombinationsEnabled.charmCombinationQuietPresenceAndFeatheredGraceEnabled()) return false;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);
        return trinket.isPresent() && (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_QUIET_PRESENCE) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_QUIET_PRESENCE)) &&
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FEATHERED_GRACE));

    }

}
