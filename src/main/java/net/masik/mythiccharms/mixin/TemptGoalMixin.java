package net.masik.mythiccharms.mixin;

import net.masik.mythiccharms.particle.ModParticles;
import net.masik.mythiccharms.util.CharmHelper;
import net.masik.mythiccharms.util.ParticleHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TemptGoal.class)
public abstract class TemptGoalMixin {

    @Shadow public abstract boolean canStart();

    // Nature's Call charm effect
    // Runs when animal checks weather it is tempted
    @Inject(method = "isTemptedBy", at = @At("RETURN"), cancellable = true)
    private void naturesCallEffect(LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {

        if (!entity.isPlayer()) return;


        if (!CharmHelper.charmNaturesCallEquipped(entity)) return;


        if (entity.isSneaking()) return;

        // PARTICLE
        // Summon particle around tempted animal
        TemptGoal goal = (TemptGoal) (Object) this;
        PathAwareEntity pathAwareEntity = goal.mob;
        PlayerEntity player = (PlayerEntity) entity;

        Random random = Random.create();

        if (random.nextInt(10) < 3 && canStart()) {
            ParticleHelper.spawnParticle(player, ModParticles.NATURES_CALL_EFFECT_PARTICLE,
                    pathAwareEntity.getX() + (double) random.nextBetween(-5, 5) / 10,
                    pathAwareEntity.getY() + (double) random.nextBetween(2, 5) / 10,
                    pathAwareEntity.getZ() + (double) random.nextBetween(-5, 5) / 10,
                    1, 0.1, 0.1, 0.1, 0.01);
        }

        // If charm equipped returns 'true' (animal is tempted by player)
        cir.setReturnValue(true);

    }

}
