package net.masik.mythiccharms.item;

import net.masik.mythiccharms.MythicCharms;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;
import java.util.Objects;

public class TooltipItem extends Item {

    private List<String> tooltipKeys;
    private Boolean notNormal;

    public TooltipItem(Settings settings, List<String> tooltips, Boolean shift) {
        super(settings);
        tooltipKeys = tooltips;
        notNormal = shift;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        if (notNormal) {

            if (Screen.hasShiftDown()) {

                for (String tooltipKey : tooltipKeys) {

                    tooltip.add(Text.translatable(tooltipKey).formatted(Formatting.DARK_PURPLE).formatted(Formatting.ITALIC));

                }

            } else {

                tooltip.add(Text.translatable("util.mythic_charms.shift_tooltip"));

            }

        } else {

            for (String tooltipKey : tooltipKeys) {

                tooltip.add(Text.translatable(tooltipKey).formatted(Formatting.GRAY).formatted(Formatting.ITALIC));

            }

        }

    }

}