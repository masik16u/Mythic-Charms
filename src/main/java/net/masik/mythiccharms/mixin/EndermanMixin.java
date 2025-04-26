package net.masik.mythiccharms.mixin;

import net.masik.mythiccharms.particle.ModParticles;
import net.masik.mythiccharms.util.CharmHelper;
import net.masik.mythiccharms.util.ParticleHelper;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EndermanEntity.class)
public abstract class EndermanMixin {

    @Shadow public abstract boolean isAngry();

    // spawn particles and ignore player staring for GS
    @Inject(method = "isPlayerStaring", at = @At("RETURN"), cancellable = true)
    private void gazeSerenityEffect(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {

        if (!CharmHelper.charmGazeSerenityEquipped(player)) return;

        //PARTICLE
        EndermanEntity entity = (EndermanEntity) (Object) this;

        Random random = Random.create();

        if (random.nextInt(10) < 3 && !isAngry() && cir.getReturnValue()) {
            ParticleHelper.spawnParticle(player, ModParticles.GAZE_SERENITY_EFFECT_PARTICLE,
                    entity.getX() + (double) random.nextBetween(-5, 5) / 10,
                    entity.getY() + (double) random.nextBetween(2, 20) / 10,
                    entity.getZ() + (double) random.nextBetween(-5, 5) / 10,
                    1, 0.1, 0.1, 0.1, 0.01);
        }

        cir.setReturnValue(false);

    }

}
