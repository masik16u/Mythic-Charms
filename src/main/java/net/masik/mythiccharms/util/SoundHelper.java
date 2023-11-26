package net.masik.mythiccharms.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundEvent;

public class SoundHelper {

    public static void playSoundAtEntity(LivingEntity entity, SoundEvent soundEvent, float volume) {
        entity.getWorld().playSound(null, entity.getX(), entity.getY(), entity.getZ(),
                soundEvent, entity.getSoundCategory(), volume, 1.0F);
    }

}
