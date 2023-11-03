package net.masik.mythiccharms.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModRegistries {
    private static final Map<Item, Integer> prices = new HashMap<>();

    static {
        prices.put(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE, 27);
        prices.put(ModItems.FRAGILE_CHARM_OF_BLAZING_EMBRACE, 36);
        prices.put(ModItems.FRAGILE_CHARM_OF_EARTHS_ORDER, 30);
        prices.put(ModItems.FRAGILE_CHARM_OF_GAZE_SERENITY, 36);
        prices.put(ModItems.FRAGILE_CHARM_OF_BOTANIC_BLESSING, 23);
        prices.put(ModItems.FRAGILE_CHARM_OF_FLEETING_STRIDES, 34);
        prices.put(ModItems.FRAGILE_CHARM_OF_NIGHTS_GUARDIAN, 41);
        prices.put(ModItems.FRAGILE_CHARM_OF_HIGH_BOUNDS, 34);
        prices.put(ModItems.FRAGILE_CHARM_OF_DROWNED_FREEDOM, 28);
        prices.put(ModItems.FRAGILE_CHARM_OF_WEIGHTLESS_FLOW, 36);
        prices.put(ModItems.FRAGILE_CHARM_OF_COLLECTORS_GIFT, 36);
        prices.put(ModItems.FRAGILE_CHARM_OF_CLIMBERS_PATH, 36);
        prices.put(ModItems.FRAGILE_CHARM_OF_NATURES_CALL, 27);
        prices.put(ModItems.FRAGILE_CHARM_OF_BARTERS_PACT, 34);
        prices.put(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY, 41);
        prices.put(ModItems.FRAGILE_CHARM_OF_ECHOING_WRATH, 36);
        prices.put(ModItems.FRAGILE_CHARM_OF_ENCHANTED_WHISPERS, 41);
        prices.put(ModItems.FRAGILE_CHARM_OF_ARROW_DANCE, 31);
        prices.put(ModItems.FRAGILE_CHARM_OF_MOUNTAINS_STRENGTH, 34);
        prices.put(ModItems.FRAGILE_CHARM_OF_SAFE_TERRITORY, 39);
        prices.put(ModItems.FRAGILE_CHARM_OF_QUIET_PRESENCE, 37);
    }

    public static void registerRegistries() {
        registerCustomWanderingTrades();
    }

    private static void registerCustomWanderingTrades() {
        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> prices.forEach((charm, price) -> createCharmTrade(factories, charm, price)));
    }

    private static void createCharmTrade(List<TradeOffers.Factory> factories, Item charm, int price) {
        factories.add((entity, random) -> new TradeOffer(
                new ItemStack(Items.EMERALD, price),
                new ItemStack(ModItems.BROKEN_CHARM, 1),
                new ItemStack(charm, 1),
                1, 0, 0));
    }
}
