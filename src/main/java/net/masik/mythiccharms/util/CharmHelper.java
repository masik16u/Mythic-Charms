package net.masik.mythiccharms.util;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.particle.ModParticles;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.*;

public class CharmHelper {

    private static final String FEATHERED_GRACE = "feathered_grace";
    private static final String BLAZING_EMBRACE = "blazing_embrace";
    private static final String EARTHS_ORDER = "earths_order";
    private static final String GAZE_SERENITY = "gaze_serenity";
    private static final String BOTANIC_BLESSING = "botanic_blessing";
    private static final String FLEETING_STRIDES = "fleeting_strides";
    private static final String NIGHTS_GUARDIAN = "nights_guardian";
    private static final String HIGH_BOUNDS = "high_bounds";
    private static final String DROWNED_FREEDOM = "drowned_freedom";
    private static final String WEIGHTLESS_FLOW = "weightless_flow";
    private static final String COLLECTORS_GIFT = "collectors_gift";
    private static final String CLIMBERS_PATH = "climbers_path";
    private static final String NATURES_CALL = "natures_call";
    private static final String BARTERS_PACT = "barters_pact";
    private static final String BATTLE_FURY = "battle_fury";
    private static final String ECHOING_WRATH = "echoing_wrath";
    private static final String ENCHANTED_WHISPERS = "enchanted_whispers";
    private static final String ARROW_DANCE = "arrow_dance";
    private static final String MOUNTAINS_STRENGTH = "mountains_strength";
    private static final String SAFE_TERRITORY = "safe_territory";
    private static final String QUIET_PRESENCE = "quiet_presence";

    private static final MythicCharmsConfig config = MythicCharms.CONFIG;



    public static boolean charmFeatheredGraceEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmFeatheredGraceEnabled( )) return false;
        return isCharmEquipped(entity, FEATHERED_GRACE);
    }

    public static boolean charmBlazingEmbraceEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmBlazingEmbraceEnabled( )) return false;
        return isCharmEquipped(entity, BLAZING_EMBRACE);
    }

    public static boolean charmEarthsOrderEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmEarthsOrderEnabled( )) return false;
        return isCharmEquipped(entity, EARTHS_ORDER);
    }

    public static boolean charmGazeSerenityEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmGazeSerenityEnabled( )) return false;
        return isCharmEquipped(entity, GAZE_SERENITY);
    }

    public static boolean charmBotanicBlessingEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmBotanicBlessingEnabled( )) return false;
        return isCharmEquipped(entity, BOTANIC_BLESSING);
    }

    public static boolean charmFleetingStridesEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmFleetingStridesEnabled( )) return false;
        return isCharmEquipped(entity, FLEETING_STRIDES);
    }

    public static boolean charmNightsGuardianEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmNightsGuardianEnabled( )) return false;
        return isCharmEquipped(entity, NIGHTS_GUARDIAN);
    }

    public static boolean charmHighBoundsEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmHighBoundsEnabled( )) return false;
        return isCharmEquipped(entity, HIGH_BOUNDS);
    }

    public static boolean charmDrownedFreedomEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmDrownedFreedomEnabled( )) return false;
        return isCharmEquipped(entity, DROWNED_FREEDOM);
    }

    public static boolean charmWeightlessFlowEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmWeightlessFlowEnabled( )) return false;
        return isCharmEquipped(entity, WEIGHTLESS_FLOW);
    }

    public static boolean charmCollectorsGiftEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmCollectorsGiftEnabled( )) return false;
        return isCharmEquipped(entity, COLLECTORS_GIFT);
    }

    public static boolean charmClimbersPathEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmClimbersPathEnabled( )) return false;
        return isCharmEquipped(entity, CLIMBERS_PATH);
    }

    public static boolean charmNaturesCallEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmNaturesCallEnabled( )) return false;
        return isCharmEquipped(entity, NATURES_CALL);
    }

    public static boolean charmBartersPactEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmBartersPactEnabled( )) return false;
        return isCharmEquipped(entity, BARTERS_PACT);
    }

    public static boolean charmBattleFuryEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmBattleFuryEnabled( )) return false;
        return isCharmEquipped(entity, BATTLE_FURY);
    }

    public static boolean charmEchoingWrathEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmEchoingWrathEnabled( )) return false;
        return isCharmEquipped(entity, ECHOING_WRATH);
    }

    public static boolean charmEnchantedWhispersEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmEnchantedWhispersEnabled( )) return false;
        return isCharmEquipped(entity, ENCHANTED_WHISPERS);
    }

    public static boolean charmArrowDanceEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmArrowDanceEnabled( )) return false;
        return isCharmEquipped(entity, ARROW_DANCE);
    }

    public static boolean charmMountainsStrengthEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmMountainsStrengthEnabled( )) return false;
        return isCharmEquipped(entity, MOUNTAINS_STRENGTH);
    }

    public static boolean charmSafeTerritoryEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmSafeTerritoryEnabled( )) return false;
        return isCharmEquipped(entity, SAFE_TERRITORY);
    }

    public static boolean charmQuietPresenceEquipped(LivingEntity entity) {
        if (!config.charmsEnabled.CharmQuietPresenceEnabled( )) return false;
        return isCharmEquipped(entity, QUIET_PRESENCE);
    }



    public static boolean charmCombinationFeatheredGraceAndHighBoundsEnabled(LivingEntity entity) {
        if (!config.charmCombinationsEnabled.CharmCombinationFeatheredGraceAndHighBoundsEnabled( )) return false;
        return isCharmsComboEquipped(entity, FEATHERED_GRACE, HIGH_BOUNDS);
    }

    public static boolean charmCombinationBlazingEmbraceAndBattleFuryEnabled(LivingEntity entity) {
        if (!config.charmCombinationsEnabled.CharmCombinationBlazingEmbraceAndBattleFuryEnabled( )) return false;
        return isCharmsComboEquipped(entity, BLAZING_EMBRACE, BATTLE_FURY);
    }

    public static boolean charmCombinationEarthsOrderAndBlazingEmbraceEnabled(LivingEntity entity) {
        if (!config.charmCombinationsEnabled.CharmCombinationEarthsOrderAndBlazingEmbraceEnabled( )) return false;
        return isCharmsComboEquipped(entity, EARTHS_ORDER, BLAZING_EMBRACE);
    }

    public static boolean charmCombinationEarthsOrderAndDrownedFreedomEnabled(LivingEntity entity) {
        if (!config.charmCombinationsEnabled.CharmCombinationEarthsOrderAndDrownedFreedomEnabled( )) return false;
        return isCharmsComboEquipped(entity, EARTHS_ORDER, DROWNED_FREEDOM);
    }

    public static boolean charmCombinationEarthsOrderAndWeightlessFlowEnabled(LivingEntity entity) {
        if (!config.charmCombinationsEnabled.CharmCombinationEarthsOrderAndWeightlessFlowEnabled( )) return false;
        return isCharmsComboEquipped(entity, EARTHS_ORDER, WEIGHTLESS_FLOW);
    }

    public static boolean charmCombinationEarthsOrderAndBattleFuryEnabled(LivingEntity entity) {
        if (!config.charmCombinationsEnabled.CharmCombinationEarthsOrderAndBattleFuryEnabled( )) return false;
        return isCharmsComboEquipped(entity, EARTHS_ORDER, BATTLE_FURY);
    }

    public static boolean charmCombinationBotanicBlessingAndFeatheredGraceEnabled(LivingEntity entity) {
        if (!config.charmCombinationsEnabled.CharmCombinationBotanicBlessingAndFeatheredGraceEnabled( )) return false;
        return isCharmsComboEquipped(entity, BOTANIC_BLESSING, FEATHERED_GRACE);
    }

    public static boolean charmCombinationFleetingStridesAndHighBoundsEnabled(LivingEntity entity) {
        if (!config.charmCombinationsEnabled.CharmCombinationFleetingStridesAndHighBoundsEnabled( )) return false;
        return isCharmsComboEquipped(entity, FLEETING_STRIDES, HIGH_BOUNDS);
    }

    public static boolean charmCombinationFleetingStridesAndBattleFuryEnabled(LivingEntity entity) {
        if (!config.charmCombinationsEnabled.CharmCombinationFleetingStridesAndBattleFuryEnabled( )) return false;
        return isCharmsComboEquipped(entity, FLEETING_STRIDES, BATTLE_FURY);
    }

    public static boolean charmCombinationWeightlessFlowAndFeatheredGraceEnabled(LivingEntity entity) {
        if (!config.charmCombinationsEnabled.CharmCombinationWeightlessFlowAndFeatheredGraceEnabled( )) return false;
        return isCharmsComboEquipped(entity, WEIGHTLESS_FLOW, FEATHERED_GRACE);
    }

    public static boolean charmCombinationClimbersPathAndHighBoundsEnabled(LivingEntity entity) {
        if (!config.charmCombinationsEnabled.CharmCombinationClimbersPathAndHighBoundsEnabled( )) return false;
        return isCharmsComboEquipped(entity, CLIMBERS_PATH, HIGH_BOUNDS);
    }

    public static boolean charmCombinationEchoingWrathAndBlazingEmbraceEnabled(LivingEntity entity) {
        if (!config.charmCombinationsEnabled.CharmCombinationEchoingWrathAndBlazingEmbraceEnabled( )) return false;
        return isCharmsComboEquipped(entity, ECHOING_WRATH, BLAZING_EMBRACE);
    }

    public static boolean charmCombinationEchoingWrathAndBattleFuryEnabled(LivingEntity entity) {
        if (!config.charmCombinationsEnabled.CharmCombinationEchoingWrathAndBattleFuryEnabled( )) return false;
        return isCharmsComboEquipped(entity, ECHOING_WRATH, BATTLE_FURY);
    }

    public static boolean charmCombinationQuietPresenceAndFeatheredGraceEnabled(LivingEntity entity) {
        if (!config.charmCombinationsEnabled.CharmCombinationQuietPresenceAndFeatheredGraceEnabled( )) return false;
        return isCharmsComboEquipped(entity, QUIET_PRESENCE, FEATHERED_GRACE);
    }



    private static boolean isCharmsComboEquipped(LivingEntity entity, String name_1, String name_2) {

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);

        return trinket.isPresent() && trinket.get().isEquipped(stack -> isStackInCharmTag(stack, name_1)) &&
                trinket.get().isEquipped(stack -> isStackInCharmTag(stack, name_2));

    }

    private static boolean isCharmEquipped(LivingEntity entity, String name) {

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);

        return trinket.isPresent() && trinket.get().isEquipped(stack -> isStackInCharmTag(stack, name));

    }

    private static boolean isStackInCharmTag(ItemStack stack, String name) {

        return stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "charms/" + name)));

    }



    public static final ArrayList<Set<String>> COMBINATIONS = new ArrayList<>() {{
        add(new HashSet<>(List.of(new String[]{FEATHERED_GRACE, HIGH_BOUNDS})));
        add(new HashSet<>(List.of(new String[]{BLAZING_EMBRACE, BATTLE_FURY})));
        add(new HashSet<>(List.of(new String[]{EARTHS_ORDER, BLAZING_EMBRACE})));
        add(new HashSet<>(List.of(new String[]{EARTHS_ORDER, DROWNED_FREEDOM})));
        add(new HashSet<>(List.of(new String[]{EARTHS_ORDER, WEIGHTLESS_FLOW})));
        add(new HashSet<>(List.of(new String[]{EARTHS_ORDER, BATTLE_FURY})));
        add(new HashSet<>(List.of(new String[]{BOTANIC_BLESSING, FEATHERED_GRACE})));
        add(new HashSet<>(List.of(new String[]{FLEETING_STRIDES, HIGH_BOUNDS})));
        add(new HashSet<>(List.of(new String[]{FLEETING_STRIDES, BATTLE_FURY})));
        add(new HashSet<>(List.of(new String[]{WEIGHTLESS_FLOW, FEATHERED_GRACE})));
        add(new HashSet<>(List.of(new String[]{CLIMBERS_PATH, HIGH_BOUNDS})));
        add(new HashSet<>(List.of(new String[]{ECHOING_WRATH, BLAZING_EMBRACE})));
        add(new HashSet<>(List.of(new String[]{ECHOING_WRATH, BATTLE_FURY})));
        add(new HashSet<>(List.of(new String[]{QUIET_PRESENCE, FEATHERED_GRACE})));
    }};

    public static final Map<String, DefaultParticleType> PARTICLES = new HashMap<>() {{
        put(FEATHERED_GRACE, ModParticles.FEATHERED_GRACE_EQUIP_PARTICLE);
        put(BLAZING_EMBRACE, ModParticles.BLAZING_EMBRACE_EQUIP_PARTICLE);
        put(EARTHS_ORDER, ModParticles.EARTHS_ORDER_EQUIP_PARTICLE);
        put(GAZE_SERENITY, ModParticles.GAZE_SERENITY_EQUIP_PARTICLE);
        put(BOTANIC_BLESSING, ModParticles.BOTANIC_BLESSING_EQUIP_PARTICLE);
        put(FLEETING_STRIDES, ModParticles.FLEETING_STRIDES_EQUIP_PARTICLE);
        put(NIGHTS_GUARDIAN, ModParticles.NIGHTS_GUARDIAN_EQUIP_PARTICLE);
        put(HIGH_BOUNDS, ModParticles.HIGH_BOUNDS_EQUIP_PARTICLE);
        put(DROWNED_FREEDOM, ModParticles.DROWNED_FREEDOM_EQUIP_PARTICLE);
        put(WEIGHTLESS_FLOW, ModParticles.WEIGHTLESS_FLOW_EQUIP_PARTICLE);
        put(COLLECTORS_GIFT, ModParticles.COLLECTORS_GIFT_EQUIP_PARTICLE);
        put(CLIMBERS_PATH, ModParticles.CLIMBERS_PATH_EQUIP_PARTICLE);
        put(NATURES_CALL, ModParticles.NATURES_CALL_EQUIP_PARTICLE);
        put(BARTERS_PACT, ModParticles.BARTERS_PACT_EQUIP_PARTICLE);
        put(BATTLE_FURY, ModParticles.BATTLE_FURY_EQUIP_PARTICLE);
        put(ECHOING_WRATH, ModParticles.ECHOING_WRATH_EQUIP_PARTICLE);
        put(ENCHANTED_WHISPERS, ModParticles.ENCHANTED_WHISPERS_EQUIP_PARTICLE);
        put(ARROW_DANCE, ModParticles.ARROW_DANCE_EQUIP_PARTICLE);
        put(MOUNTAINS_STRENGTH, ModParticles.MOUNTAINS_STRENGTH_EQUIP_PARTICLE);
        put(SAFE_TERRITORY, ModParticles.SAFE_TERRITORY_EQUIP_PARTICLE);
        put(QUIET_PRESENCE, ModParticles.QUIET_PRESENCE_EQUIP_PARTICLE);
    }};

}
