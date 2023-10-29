package net.masik.mythiccharms.access;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public interface ExtendedTooltipAccessor {
    @Nullable
    MutableText getHiddenTooltip();

    void setHiddenTooltip(String key);

    default Text getHintTooltip() {
        return Text.translatable("util.mythic_charms.shift_tooltip");
    }

    default Text formatHiddenTooltip(String text) {
        return Text.of("§5§o%s§r".formatted(text));
    }
}
