package net.masik.mythiccharms.block;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TooltipBlockItem extends BlockItem {

    private final String tooltipKey;

    public TooltipBlockItem(Block block, Settings settings, String tooltip) {

        super(block, settings);

        tooltipKey = tooltip;

    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        List<String> tooltipLines = new ArrayList<>();

        int width = 40;

        int cursor = 0;

        String wideTooltip = Text.translatable(tooltipKey).getString();

        int spaceSymbol = 0;

        while (spaceSymbol != -1) {
            spaceSymbol = wideTooltip.indexOf(' ', cursor + width);
            tooltipLines.add(wideTooltip.substring(cursor, spaceSymbol != -1 ? spaceSymbol : wideTooltip.length()));
            cursor = spaceSymbol + 1;
        }

        for (String tooltipLine : tooltipLines) {
            tooltip.add(Text.of("§7§o%s".formatted(tooltipLine)));
        }

    }

}
