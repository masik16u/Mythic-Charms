package net.masik.mythiccharms.item;

import dev.emi.trinkets.api.*;
import net.masik.mythiccharms.util.TooltipHelper;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class TooltipTrinketItem extends TrinketItem {

    private final String tooltipKey;
    private final Boolean notNormal;

    public TooltipTrinketItem(Settings settings, String tooltip, Boolean shift) {
        super(settings);
        tooltipKey = tooltip;
        notNormal = shift;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        TooltipHelper.addTooltip(tooltip, tooltipKey, notNormal);

    }

}
