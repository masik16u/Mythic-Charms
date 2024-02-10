package net.masik.mythiccharms;

import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.util.TriState;
import net.masik.mythiccharms.block.ModBlocks;
import net.masik.mythiccharms.item.ModItems;

import net.masik.mythiccharms.recipe.ModRecipes;
import net.masik.mythiccharms.util.ModLootTableModifiers;
import net.masik.mythiccharms.util.ModRegistries;
import net.masik.mythiccharms.util.MythicCharmsConfig;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MythicCharms implements ModInitializer {
	public static final String MOD_ID = "mythic_charms";
    public static final Logger LOGGER = LoggerFactory.getLogger("mythic_charms");
	public static final MythicCharmsConfig CONFIG = MythicCharmsConfig.createAndLoad();

	@Override
	public void onInitialize() {
		MythicCharms.LOGGER.info("[Mythic Charms] Initializing...");

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.modifyLootTables();
		ModRegistries.registerRegistries();

		ModRecipes.registerRecipes();
//		TrinketsApi.registerTrinketPredicate(new Identifier(MOD_ID, "mythic_charm_predicate"), (stack, slot, entity) -> {
//			if (!stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "mythic_charms")))) {
//				return TriState.FALSE;
//			}
//			return TriState.TRUE;
//		});
	}
}