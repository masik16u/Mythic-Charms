package net.masik.mythiccharms.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class TooltipItem extends Item {

    private final List<String> tooltipKeys;
    private final Boolean notNormal;

    public TooltipItem(Settings settings, List<String> tooltips, Boolean shift) {
        super(settings);
        this.tooltipKeys = tooltips;
        this.notNormal = shift;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        if (this.notNormal) {

            if (true) {

                for (String tooltipKey : this.tooltipKeys) {

                    tooltip.add(Text.translatable(tooltipKey).formatted(Formatting.DARK_PURPLE).formatted(Formatting.ITALIC));

                }

            } else {

                tooltip.add(Text.translatable("util.mythic_charms.shift_tooltip"));

            }

        } else {

            for (String tooltipKey : this.tooltipKeys) {

                tooltip.add(Text.translatable(tooltipKey).formatted(Formatting.GRAY).formatted(Formatting.ITALIC));

            }

        }

    }

}