package net.masik.mythiccharms.util;

import io.wispforest.owo.config.Option;
import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.Nest;
import io.wispforest.owo.config.annotation.Sync;

@Modmenu(modId = "mythic_charms")
@Config(name = "mythic-charms-config", wrapperName = "MythicCharmsConfig")
public class MythicCharmsConfigModel {

//    public Choices anEnumOption = Choices.ANOTHER_CHOICE;
//
//    public enum Choices {
//        A_CHOICE, ANOTHER_CHOICE;
//    }

    @Nest
    @Sync(Option.SyncMode.OVERRIDE_CLIENT)
    public CharmsEnabled charmsEnabled = new CharmsEnabled();

    public static class CharmsEnabled {

        public boolean CharmFeatheredGraceEnabled = true;
        public boolean CharmBlazingEmbraceEnabled = true;
        public boolean CharmEarthsOrderEnabled = true;
        public boolean CharmGazeSerenityEnabled = true;
        public boolean CharmBotanicBlessingEnabled = true;
        public boolean CharmFleetingStridesEnabled = true;
        public boolean CharmNightsGuardianEnabled = true;
        public boolean CharmHighBoundsEnabled = true;
        public boolean CharmDrownedFreedomEnabled = true;
        public boolean CharmWeightlessFlowEnabled = true;
        public boolean CharmCollectorsGiftEnabled = true;
        public boolean CharmClimbersPathEnabled = true;
        public boolean CharmNaturesCallEnabled = true;
        public boolean CharmBartersPactEnabled = true;
        public boolean CharmBattleFuryEnabled = true;
        public boolean CharmEchoingWrathEnabled = true;
        public boolean CharmEnchantedWhispersEnabled = true;
        public boolean CharmArrowDanceEnabled = true;
        public boolean CharmMountainsStrengthEnabled = true;
        public boolean CharmSafeTerritoryEnabled = true;
        public boolean CharmQuietPresenceEnabled = true;

    }

    @Nest
    @Sync(Option.SyncMode.OVERRIDE_CLIENT)
    public CharmCombinationsEnabled charmCombinationsEnabled = new CharmCombinationsEnabled();

    public static class CharmCombinationsEnabled {

        public boolean CharmCombinationFeatheredGraceAndHighBoundsEnabled = true;
        public boolean CharmCombinationBlazingEmbraceAndBattleFuryEnabled = true;
        public boolean CharmCombinationEarthsOrderAndBlazingEmbraceEnabled = true;
        public boolean CharmCombinationEarthsOrderAndDrownedFreedomEnabled = true;
        public boolean CharmCombinationEarthsOrderAndWeightlessFlowEnabled = true;
        public boolean CharmCombinationEarthsOrderAndBattleFuryEnabled = true;
        public boolean CharmCombinationBotanicBlessingAndFeatheredGraceEnabled = true;
        public boolean CharmCombinationFleetingStridesAndHighBoundsEnabled = true;
        public boolean CharmCombinationFleetingStridesAndBattleFuryEnabled = true;
        public boolean CharmCombinationWeightlessFlowAndFeatheredGraceEnabled = true;
        public boolean CharmCombinationClimbersPathAndHighBoundsEnabled = true;
        public boolean CharmCombinationEchoingWrathAndBlazingEmbraceEnabled = true;
        public boolean CharmCombinationEchoingWrathAndBattleFuryEnabled = true;
        public boolean CharmCombinationQuietPresenceAndFeatheredGraceEnabled = true;

    }

    @Sync(Option.SyncMode.OVERRIDE_CLIENT)
    public int experienceNuggetMobCap = 10;

}

