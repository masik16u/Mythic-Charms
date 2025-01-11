package net.masik.mythiccharms.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.masik.mythiccharms.MythicCharms;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block RESONANCE_TABLE = registerBlock("resonance_table", new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block AMETHYST_LAMP = registerBlock("amethyst_lamp", new AmethystLampBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).luminance(state -> state.get(ModBlockProperties.LIGHT_LEVEL))));

    public static final Block AMETHYST_EMBEDDED_STONE_PILLAR = registerBlock("amethyst_embedded_stone_pillar", new ModFacingBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block AMETHYST_EMBEDDED_DEEPSLATE_PILLAR = registerBlock("amethyst_embedded_deepslate_pillar", new ModFacingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_BRICKS)));

    public static final Block AMETHYST_EMBEDDED_CHISELED_STONE = registerBlock("amethyst_embedded_chiseled_stone", new ModHorizontalFacingBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block AMETHYST_EMBEDDED_CHISELED_DEEPSLATE = registerBlock("amethyst_embedded_chiseled_deepslate", new ModHorizontalFacingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_BRICKS)));

    private static Block registerBlock(String name, Block block) {

        registerBlockItem(name, block);

        return Registry.register(Registries.BLOCK, new Identifier(MythicCharms.MOD_ID, name), block);

    }

    private static Item registerBlockItem(String name, Block block) {

        return Registry.register(Registries.ITEM, new Identifier(MythicCharms.MOD_ID, name), new BlockItem(block,
                new FabricItemSettings()));

    }

    public static void registerModBlocks() {

    }

}
