package net.masik.mythiccharms.mixin;

import com.google.common.collect.ImmutableList;
import net.masik.mythiccharms.particle.ModParticles;
import net.masik.mythiccharms.util.CharmHelper;
import net.masik.mythiccharms.util.ParticleHelper;
import net.minecraft.client.gui.screen.ingame.EnchantmentScreen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.mob.AbstractPiglinEntity;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.PiglinBruteBrain;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Optional;

@Mixin(PiglinBruteBrain.class)
public class PiglinBruteBrainMixin {

    //change this logic in the future
    @Inject(method = "getTarget", at = @At(value = "RETURN"), cancellable = true)
    private static void bartersPactEffect(AbstractPiglinEntity piglin, CallbackInfoReturnable<Optional<? extends LivingEntity>> cir) {

        Optional<? extends LivingEntity> optional = cir.getReturnValue();

        if (optional.isEmpty()) return;

        LivingEntity entity = optional.get();

        List<AbstractPiglinEntity> piglinEntities = piglin.getBrain().getOptionalRegisteredMemory(MemoryModuleType.NEARBY_ADULT_PIGLINS).orElse(ImmutableList.of());

        for (AbstractPiglinEntity abstractPiglinEntity : piglinEntities) {

            if (abstractPiglinEntity.getTarget() == entity) {
                return;
            }

        }

        if (!entity.isPlayer()) return;

        if (!CharmHelper.charmBartersPactEquipped(entity)) return;

        //PARTICLE
        PlayerEntity player = (PlayerEntity) entity;

        Random random = Random.create();

        if (random.nextInt(10) < 3) {
            ParticleHelper.spawnParticle(player, ModParticles.BARTERS_PACT_EFFECT_PARTICLE,
                    piglin.getX() + (double) random.nextBetween(-5, 5) / 10,
                    piglin.getY() + (double) random.nextBetween(2, 15) / 10,
                    piglin.getZ() + (double) random.nextBetween(-5, 5) / 10,
                    1, 0.1, 0.1, 0.1, 0.01);
        }

        cir.setReturnValue(Optional.empty());

    }

}
