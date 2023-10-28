package net.masik.mythiccharms.block;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TooltipBlockItem extends BlockItem {

    private final List<String> tooltipKeys;

    public TooltipBlockItem(Block block, Settings settings, List<String> tooltips) {

        super(block, settings);

        this.tooltipKeys = tooltips;

    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (true) {
            for (String tooltipKey : this.tooltipKeys) {
                tooltip.add(Text.translatable(tooltipKey).formatted(Formatting.DARK_PURPLE).formatted(Formatting.ITALIC));
            }
        } else {
            tooltip.add(Text.translatable("util.mythic_charms.shift_tooltip"));
        }
    }
}
