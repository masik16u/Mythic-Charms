package net.masik.mythiccharms;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MythicCharms implements ModInitializer {

	public static final String MOD_ID = "mythic_charms";
	public static final String MOD_NAME = "Mythic Charms";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	/*@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroup.registerItemGroups();
		ModLootTableModifiers.modifyLootTables();
		ModRegistries.registerRegistries();
	}*/

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing");

	}
}
