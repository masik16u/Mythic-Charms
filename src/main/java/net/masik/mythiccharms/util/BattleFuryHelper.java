package net.masik.mythiccharms.util;

import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;

public class BattleFuryHelper {

    public static double getMultiplier(PlayerEntity player) {

        double hp = player.getHealth() / player.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH);

        return (1 / (hp + (double) 3 / 9) + (double) 3 / 12);

    }

}
