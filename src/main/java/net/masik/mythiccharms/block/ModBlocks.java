package net.masik.mythiccharms.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.access.ExtendedTooltipAccessor;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModBlocks {
    public static final Block RESONANCE_TABLE = registerBlock("resonance_table", new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));

    private static Block registerBlock(String name, Block block) {

        registerBlockItem(name, block);

        return Registry.register(Registries.BLOCK, new Identifier(MythicCharms.MOD_ID, name), block);

    }

    @SuppressWarnings("DataFlowIssue")
    private static Item registerBlockItem(String name, Block block) {
        Item item = new BlockItem(block, new FabricItemSettings());
        ((ExtendedTooltipAccessor) item).setHiddenTooltip("item.mythic_charms.%s.tooltip".formatted(name));
        return Registry.register(Registries.ITEM, new Identifier(MythicCharms.MOD_ID, name), item);

    }

    private static void addItemsToToolsTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(RESONANCE_TABLE);
    }

    public static void registerModBlocks() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModBlocks::addItemsToToolsTabItemGroup);
    }

}
