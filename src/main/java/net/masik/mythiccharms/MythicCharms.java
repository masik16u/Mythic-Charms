package net.masik.mythiccharms;

import net.fabricmc.api.ModInitializer;
import net.masik.mythiccharms.block.ModBlocks;
import net.masik.mythiccharms.config.MythicCharmsConfig;
import net.masik.mythiccharms.item.ModItems;
import net.masik.mythiccharms.recipe.ModRecipes;
import net.masik.mythiccharms.util.ModLootTableModifiers;
import net.masik.mythiccharms.util.ModRegistries;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MythicCharms implements ModInitializer {
    public static final String MOD_ID = "mythic_charms";
    public static final Logger LOGGER = LoggerFactory.getLogger("mythic_charms");
    public static final MythicCharmsConfig CONFIG = MythicCharmsConfig.createAndLoad();

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        MythicCharms.LOGGER.info("[Mythic Charms] Initializing...");
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModLootTableModifiers.modifyLootTables();
        ModRegistries.registerRegistries();
        ModRecipes.registerRecipes();
    }
}