package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.item.ModItems;
import net.masik.mythiccharms.particle.ModParticles;
import net.masik.mythiccharms.util.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    // break fragile when totem used
    //fragile charms
    @Inject(method = "tryUseTotem",  at = @At("RETURN"))
    private void destroyFragileCharms(DamageSource source, CallbackInfoReturnable<Boolean> cir) {

        if (cir.getReturnValue()) {

            LivingEntity player = (LivingEntity) (Object) this;

            TrinketsApi.getTrinketComponent(player).ifPresent(trinkets -> trinkets.forEach((ref, stack) -> {

                if (stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "fragile_charms")))) {

                    // Play break sound
                    SoundHelper.playSoundAtEntity(player, SoundEvents.ENTITY_ITEM_BREAK, 20F);

                    // Replace with broken charms
                    ref.inventory().setStack(ref.index(), ModItems.BROKEN_CHARM.getDefaultStack());

                    // Give advancement
                    AdvancementsHelper.grantAdvancement(player, new Identifier(MythicCharms.MOD_ID, "story/broken_charm"));

                }

            }));

        }

    }

    //highBounds
    // increase jump velocity for HB
    @Inject(method = "getJumpVelocity", at = @At(value = "RETURN"), cancellable = true)
    private void highBoundsEffectJump(CallbackInfoReturnable<Float> cir) {

        LivingEntity entity = (LivingEntity) (Object) this;

        if (!entity.isPlayer()) return;


        if (!CharmHelper.charmHighBoundsEquipped(entity)) return;


        PlayerEntity player = (PlayerEntity) entity;

        player.addExhaustion(0.1F);

        float high = 0.6F;

        //featheredGrace combo
        if (CharmHelper.charmFleetingStridesEquipped(entity) &&
                CharmHelper.charmCombinationFleetingStridesAndHighBoundsEnabled(entity)) high += 0.05F;

        //PARTICLE
        Random random = Random.create();

        if (random.nextInt(10) < 7) {
            ParticleHelper.spawnParticle(player, ModParticles.HIGH_BOUNDS_EFFECT_PARTICLE,
                    player.getX() + (double) random.nextBetween(-2, 2) / 10,
                    player.getY(),
                    player.getZ() + (double) random.nextBetween(-2, 2) / 10,
                    random.nextBetween(3, 5), 0.1, 0, 0.1, 0.07);
        }

        cir.setReturnValue(entity.getJumpBoostVelocityModifier() + high);

    }

    // lower fall damage for HB
    @ModifyArg(method = "computeFallDamage", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;ceil(F)I"), index = 0)
    private float highBoundsEffectFall(float value) {

        LivingEntity entity = (LivingEntity) (Object) this;

        if (!entity.isPlayer()) return value;


        if (!CharmHelper.charmHighBoundsEquipped(entity)) return value;


        return value - 2;

    }

    //fleetingStrides
    // increase hunger reduction when jump running for FS
    @Inject(method = "jump", at = @At("RETURN"))
    private void fleetingStridesHungerOnJump(CallbackInfo ci) {

        LivingEntity entity = (LivingEntity) (Object) this;

        if (!entity.isPlayer()) return;


        if (!CharmHelper.charmFleetingStridesEquipped(entity)) return;


        PlayerEntity player = (PlayerEntity) entity;

        if (!player.isSprinting() || player.getAbilities().flying) return;

        float exhaustion = 0.1F;

        //highBounds combo
        if (CharmHelper.charmHighBoundsEquipped(player) && CharmHelper.charmCombinationFleetingStridesAndHighBoundsEnabled(player)) {

            exhaustion += 0.05F;

        }

        //battleFury combo
        if (CharmHelper.charmBattleFuryEquipped(player) && CharmHelper.charmCombinationFleetingStridesAndBattleFuryEnabled(player)) {

            exhaustion += (float) (0.1F * BattleFuryHelper.getMultiplier(player));

        }

        //PARTICLE
        Random random = Random.create();

        if (random.nextInt(10) < 7) {
            ParticleHelper.spawnParticle(player, ModParticles.FLEETING_STRIDES_EFFECT_PARTICLE,
                    player.getX() + (double) random.nextBetween(-2, 2) / 10,
                    player.getY(),
                    player.getZ() + (double) random.nextBetween(-2, 2) / 10,
                    random.nextBetween(3, 5), 0.1, 0, 0.1, 0.07);
        }

        player.addExhaustion(exhaustion);

    }

    //climbersPath
    // increase step height to 1.5b for CP
    @Inject(method = "getStepHeight", at = @At("RETURN"), cancellable = true)
    private void climbersPathEffect(CallbackInfoReturnable<Float> cir) {

        LivingEntity entity = (LivingEntity) (Object) this;

        if (!entity.isPlayer()) return;


        if (!CharmHelper.charmClimbersPathEquipped(entity)) return;


        float height = 1.1F;

        //highBounds combo
        if (CharmHelper.charmHighBoundsEquipped(entity) &&
                CharmHelper.charmCombinationClimbersPathAndHighBoundsEnabled(entity)) height += 0.5F;

        //PARTICLE
        PlayerEntity player = (PlayerEntity) entity;

        Random random = Random.create();

        if (random.nextInt(10) < 1 && player.isOnGround()) {
            ParticleHelper.spawnParticle(player, ModParticles.CLIMBERS_PATH_EFFECT_PARTICLE,
                    player.getX() + (double) random.nextBetween(-2, 2) / 10,
                    player.getY(),
                    player.getZ() + (double) random.nextBetween(-2, 2) / 10,
                    1, 0.1, 0.1, 0.1, 0.01);
        }

        cir.setReturnValue(height);

    }

    //mountainsStrength
    // disable knockback for MS
    @Inject(method = "takeKnockback", at = @At(value = "HEAD"), cancellable = true)
    private void mountainsStrengthEffectKnock(double strength, double x, double z, CallbackInfo ci) {

        LivingEntity entity = (LivingEntity) (Object) this;

        if (!entity.isPlayer()) return;


        if (!CharmHelper.charmMountainsStrengthEquipped(entity)) return;


        ci.cancel();

    }

    // disable pushing for MS
    @Inject(method = "isPushable", at = @At("RETURN"), cancellable = true)
    private void mountainsStrengthEffectPush(CallbackInfoReturnable<Boolean> cir) {

        LivingEntity entity = (LivingEntity) (Object) this;

        if (!entity.isPlayer()) return;


        if (!CharmHelper.charmMountainsStrengthEquipped(entity)) return;


        cir.setReturnValue(false);

    }

}
