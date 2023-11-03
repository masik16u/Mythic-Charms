package net.masik.mythiccharms.client.mixin.client;

import net.masik.mythiccharms.access.ExtendedTooltipAccessor;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;
import java.util.List;

@Mixin(value = Item.class, priority = 1100)
public class ItemMixin implements ExtendedTooltipAccessor {
    @Unique
    @Nullable
    private MutableText extendedTooltip = null;

    @Inject(method = "appendTooltip", at = @At("HEAD"))
    private void addExtendedToolTip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
        if (getHiddenTooltip() == null) return;
        if (!Screen.hasShiftDown()) {
            tooltip.add(getHintTooltip());
        } else {
            tooltip.addAll(Arrays.stream(getHiddenTooltip().getString().split("\n")).map(this::formatHiddenTooltip).toList());
        }
    }

    @Override
    @Nullable
    public MutableText getHiddenTooltip() {
        return this.extendedTooltip;
    }

    @Override
    public void setHiddenTooltip(String key) {
        this.extendedTooltip = Text.translatable(key);
    }
}
