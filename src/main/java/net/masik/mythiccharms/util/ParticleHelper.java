package net.masik.mythiccharms.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.DefaultParticleType;

public class ParticleHelper {

    public static void spawnParticle(PlayerEntity player, DefaultParticleType particle, double x, double y, double z,
                                int count, double deltaX, double deltaY, double deltaZ, double speed) {

        if (player.getServer() != null) {

            player.getServer().getWorld(player.getWorld().getRegistryKey()).spawnParticles(particle,
                    x, y, z, count, deltaX, deltaY, deltaZ, speed);

        }

    }

}
