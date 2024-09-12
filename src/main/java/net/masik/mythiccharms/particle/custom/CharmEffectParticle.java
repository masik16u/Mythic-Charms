package net.masik.mythiccharms.particle.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class CharmEffectParticle extends SpriteBillboardParticle {
    protected CharmEffectParticle(ClientWorld level, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteProvider spriteProvider) {
        super(level, x, y, z, velocityX, velocityY, velocityZ);

        this.setSpriteForAge(spriteProvider);

//        this.velocityMultiplier = 0.1F;

        this.maxAge = 20;
        this.scale = 0.2F;
        this.alpha = 0;

        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
        this.x = x;
        this.y = y;
        this.z = z;

    }

    @Override
    public void tick() {
        super.tick();
        this.alpha = 1 - (float)age / maxAge;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteSet) {
            this.spriteProvider = spriteSet;
        }

        public Particle createParticle(DefaultParticleType particleType, ClientWorld level, double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new CharmEffectParticle(level, x, y, z, dx, dy, dz, spriteProvider);
        }
    }
}
