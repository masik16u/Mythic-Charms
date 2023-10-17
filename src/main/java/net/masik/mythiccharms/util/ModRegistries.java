package net.masik.mythiccharms.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;

public class ModRegistries {

    public static void registerRegistries() {
        registerCustomWanderingTrades();
    }

    private static void registerCustomWanderingTrades() {
        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 27),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE, 1),
                    1, 0, 0));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 36),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_BLAZING_EMBRACE, 1),
                    1, 0, 0));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 30),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_EARTHS_ORDER, 1),
                    1, 0, 0));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 36),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_GAZE_SERENITY, 1),
                    1, 0, 0));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 23),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_BOTANIC_BLESSING, 1),
                    1, 0, 0));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 34),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_FLEETING_STRIDES, 1),
                    1, 0, 0));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 41),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_NIGHTS_GUARDIAN, 1),
                    1, 0, 0));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 34),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_HIGH_BOUNDS, 1),
                    1, 0, 0));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 28),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_DROWNED_FREEDOM, 1),
                    1, 0, 0));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 36),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_WEIGHTLESS_FLOW, 1),
                    1, 0, 0));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 36),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_COLLECTORS_GIFT, 1),
                    1, 0, 0));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 36),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_CLIMBERS_PATH, 1),
                    1, 0, 0));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 27),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_NATURES_CALL, 1),
                    1, 0, 0));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 34),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_BARTERS_PACT, 1),
                    1, 0, 0));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 41),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY, 1),
                    1, 0, 0));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 36),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_ECHOING_WRATH, 1),
                    1, 0, 0));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 41),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_ENCHANTED_WHISPERS, 1),
                    1, 0, 0));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 31),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_ARROW_DANCE, 1),
                    1, 0, 0));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 34),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_MOUNTAINS_STRENGTH, 1),
                    1, 0, 0));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 39),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_SAFE_TERRITORY, 1),
                    1, 0, 0));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 37),
                    new ItemStack(ModItems.BROKEN_CHARM, 1),
                    new ItemStack(ModItems.FRAGILE_CHARM_OF_QUIET_PRESENCE, 1),
                    1, 0, 0));
        });
    }

}
