package net.masik.mythiccharms.particle.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class CharmEquipParticle extends SpriteBillboardParticle {

    protected CharmEquipParticle(ClientWorld level, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteProvider spriteProvider) {
        super(level, x, y, z, velocityX, velocityY, velocityZ);

        this.setSpriteForAge(spriteProvider);

        this.velocityMultiplier = 0.1F;

        this.maxAge = 15;
        this.scale = 0.8F;
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
        this.alpha = (float) ((Math.pow((((float)age / maxAge * 2) - 1), 2) * -1 + 1) * 0.8F);
        this.scale = 0.8F + (float)age / maxAge * 0.4F;
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
            return new CharmEquipParticle(level, x, y, z, dx, dy, dz, spriteProvider);
        }
    }
}
