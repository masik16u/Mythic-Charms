package net.masik.mythiccharms.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.masik.mythiccharms.MythicCharms;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {

    private static Identifier buildInjectionRoute(Identifier id) {
        return new Identifier(MythicCharms.MOD_ID, "injections/" + id.getNamespace() + "/" + id.getPath());
    }

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            LootTable lootTable = lootManager.getLootTable(buildInjectionRoute(id));
            if (lootTable != LootTable.EMPTY) {
                LootPool[] pools = lootTable.pools;

                supplyPools(tableBuilder, pools);
            }
        });
    }

    private static void supplyPools(LootTable.Builder tableBuilder, LootPool[] pools) {
        for (LootPool pool: pools) {
            tableBuilder.pool(pool);
        }
    }

}
