package net.masik.mythiccharms.config;

import io.wispforest.owo.config.Option;
import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.Nest;
import io.wispforest.owo.config.annotation.Sync;

@SuppressWarnings("unused")
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
    @Nest
    @Sync(Option.SyncMode.OVERRIDE_CLIENT)
    public CharmCombinationsEnabled charmCombinationsEnabled = new CharmCombinationsEnabled();

    public static class CharmsEnabled {
        public boolean charmFeatheredGraceEnabled = true;
        public boolean charmBlazingEmbraceEnabled = true;
        public boolean charmEarthsOrderEnabled = true;
        public boolean charmGazeSerenityEnabled = true;
        public boolean charmBotanicBlessingEnabled = true;
        public boolean charmFleetingStridesEnabled = true;
        public boolean charmNightsGuardianEnabled = true;
        public boolean charmHighBoundsEnabled = true;
        public boolean charmDrownedFreedomEnabled = true;
        public boolean charmWeightlessFlowEnabled = true;
        public boolean charmCollectorsGiftEnabled = true;
        public boolean charmClimbersPathEnabled = true;
        public boolean charmNaturesCallEnabled = true;
        public boolean charmBartersPactEnabled = true;
        public boolean charmBattleFuryEnabled = true;
        public boolean charmEchoingWrathEnabled = true;
        public boolean charmEnchantedWhispersEnabled = true;
        public boolean charmArrowDanceEnabled = true;
        public boolean charmMountainsStrengthEnabled = true;
        public boolean charmSafeTerritoryEnabled = true;
        public boolean charmQuietPresenceEnabled = true;
    }

    public static class CharmCombinationsEnabled {

        public boolean charmCombinationFeatheredGraceAndHighBoundsEnabled = true;
        public boolean charmCombinationBlazingEmbraceAndBattleFuryEnabled = true;
        public boolean charmCombinationEarthsOrderAndBlazingEmbraceEnabled = true;
        public boolean charmCombinationEarthsOrderAndDrownedFreedomEnabled = true;
        public boolean charmCombinationEarthsOrderAndWeightlessFlowEnabled = true;
        public boolean charmCombinationEarthsOrderAndBattleFuryEnabled = true;
        public boolean charmCombinationBotanicBlessingAndFeatheredGraceEnabled = true;
        public boolean charmCombinationFleetingStridesAndHighBoundsEnabled = true;
        public boolean charmCombinationFleetingStridesAndBattleFuryEnabled = true;
        public boolean charmCombinationWeightlessFlowAndFeatheredGraceEnabled = true;
        public boolean charmCombinationClimbersPathAndHighBoundsEnabled = true;
        public boolean charmCombinationEchoingWrathAndBlazingEmbraceEnabled = true;
        public boolean charmCombinationEchoingWrathAndBattleFuryEnabled = true;
        public boolean charmCombinationQuietPresenceAndFeatheredGraceEnabled = true;

    }

}
