package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.*;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.item.ModItems;
import net.masik.mythiccharms.util.BattleFuryHelper;
import net.masik.mythiccharms.util.CharmHelper;
import net.masik.mythiccharms.util.SoundHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.EnchantingTableBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Mixin(PlayerEntity.class)
public class PlayerMixin {

    //fragile charms
    @Inject(method = "dropInventory",  at = @At("HEAD"))
    private void destroyFragileCharms(CallbackInfo info){

        PlayerEntity player = (PlayerEntity) (Object) this;

        TrinketsApi.getTrinketComponent(player).ifPresent(trinkets -> trinkets.forEach((ref, stack) -> {

            if (stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "fragile_charms")))) {

                SoundHelper.playSoundAtEntity(player, SoundEvents.ENTITY_ITEM_BREAK, 20F);

                ref.inventory().setStack(ref.index(), ModItems.BROKEN_CHARM.getDefaultStack());

            }

        }));

    }

    //earthsOrder
    @Inject(method = "canHarvest", at = @At("RETURN"), cancellable = true)
    private void earthsOrderEffect(BlockState state, CallbackInfoReturnable<Boolean> cir) {

        PlayerEntity player = (PlayerEntity) (Object) this;


        if (!CharmHelper.charmEarthsOrderEquipped(player)) return;


        if (player.getMainHandStack().isDamageable()) return;

        cir.setReturnValue(true);

    }

    @Inject(method = "getBlockBreakingSpeed", at = @At("RETURN"), cancellable = true)
    private void earthsOrderEffectSpeed(BlockState block, CallbackInfoReturnable<Float> cir) {

        PlayerEntity player = (PlayerEntity) (Object) this;


        if (!CharmHelper.charmEarthsOrderEquipped(player)) return;


        if (player.getMainHandStack().isDamageable()) return;

        float speedModifier = 3.5F;

        //battleFury combo
        if (CharmHelper.charmBattleFuryEquipped(player) &&
                CharmHelper.charmCombinationEarthsOrderAndBattleFuryEnabled(player)) {

            speedModifier *= (float) BattleFuryHelper.getMultiplier(player);

        }

        //drownedFreedom combo
        if (CharmHelper.charmDrownedFreedomEquipped(player) &&
                CharmHelper.charmCombinationEarthsOrderAndDrownedFreedomEnabled(player) &&
                player.isSubmergedIn(FluidTags.WATER) &&
                !EnchantmentHelper.hasAquaAffinity(player)) {

            speedModifier += 5;

        }

        //weightlessFlow combo
        if (CharmHelper.charmWeightlessFlowEquipped(player) &&
                CharmHelper.charmCombinationEarthsOrderAndWeightlessFlowEnabled(player) &&
                !player.isOnGround()) {

            speedModifier += 5;

        }

        cir.setReturnValue(cir.getReturnValue() * speedModifier);

    }

    //fleetingStrides
    @Inject(method = "getOffGroundSpeed", at = @At("RETURN"), cancellable = true)
    private void fleetingStridesEffect(CallbackInfoReturnable<Float> cir) {

        PlayerEntity player = (PlayerEntity) (Object) this;


        if (!CharmHelper.charmFleetingStridesEquipped(player)) return;


        if (!player.isSprinting()) return;

        float speed = 0.035F;

        float exhaustion = 0.1F;

        //highBounds combo
        if (CharmHelper.charmHighBoundsEquipped(player) && CharmHelper.charmCombinationFleetingStridesAndHighBoundsEnabled(player)) {

            speed += 0.01F;
            exhaustion += 0.05F;

        }

        //battleFury combo
        if (CharmHelper.charmBattleFuryEquipped(player) && CharmHelper.charmCombinationFleetingStridesAndBattleFuryEnabled(player)) {

            speed += (float) (0.02F * BattleFuryHelper.getMultiplier(player));
            exhaustion += (float) (0.1F * BattleFuryHelper.getMultiplier(player));

        }

        player.addExhaustion(exhaustion);

        cir.setReturnValue(speed);

    }

    //blazingEmbrace
    @Inject(method = "setFireTicks", at = @At("RETURN"))
    private void blazingEmbraceEffect(int fireTicks, CallbackInfo ci) {

        PlayerEntity player = (PlayerEntity) (Object) this;


        if (!CharmHelper.charmBlazingEmbraceEquipped(player)) return;


        if (!player.isOnFire()) {

            float duration = 410;

            //battleFury combo
            if (CharmHelper.charmBattleFuryEquipped(player) &&
                    CharmHelper.charmCombinationBlazingEmbraceAndBattleFuryEnabled(player)) {

                duration *= (float) BattleFuryHelper.getMultiplier(player);

            }

            player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, (int) duration, 0,
                    false, false, true));

        }

    }

    //battleFury
    @ModifyArg(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"), index = 1)
    private float battleFuryEffect(float amount) {

        PlayerEntity player = (PlayerEntity) (Object) this;


        if (!CharmHelper.charmBattleFuryEquipped(player)) return amount;


        return (float) (amount * BattleFuryHelper.getMultiplier(player));
    }

    //echoingWrath
    @Inject(method = "damage", at = @At("RETURN"))
    private void echoingWrathEffect(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {

        PlayerEntity player = (PlayerEntity) (Object) this;


        if (!CharmHelper.charmEchoingWrathEquipped(player) || source.getAttacker() == null) return;

        Box box = Box.from(player.getPos()).expand(2);

        List<LivingEntity> entities = new ArrayList<>(player.getWorld().getEntitiesByClass(LivingEntity.class, box, entity -> true));

        entities.forEach(entity -> {

            if (entity instanceof TameableEntity) {
                if (((TameableEntity) entity).isOwner(player)) return;
            }

            float damageMultiplier = 1;

            //battleFury combo
            if (CharmHelper.charmBattleFuryEquipped(player) &&
                    CharmHelper.charmCombinationEchoingWrathAndBattleFuryEnabled(player)) {

                damageMultiplier *= (float) BattleFuryHelper.getMultiplier(player);

            }

            //blazingEmbrace combo
            if (CharmHelper.charmBlazingEmbraceEquipped(player) &&
                    CharmHelper.charmCombinationEchoingWrathAndBlazingEmbraceEnabled(player)) {

                damageMultiplier *= 0.5F;

                entity.setFireTicks(60);

            }

            entity.damage(player.getDamageSources().magic(), amount / 2 > 10 ? 5 * damageMultiplier : amount / 2 * damageMultiplier);

            entity.setVelocity(entity.getVelocity().add(player.getPos().subtract(entity.getPos()).multiply(-0.3F)));
            entity.velocityModified = true;

        });

    }

    @ModifyArg(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"), index = 1)
    private float echoingWrathDealLessDamage(float amount) {

        PlayerEntity player = (PlayerEntity) (Object) this;


        if (!CharmHelper.charmEchoingWrathEquipped(player)) return amount;


        return (float) (amount * 0.75);
    }

    //mountainsStrength
    @ModifyArg(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"), index = 1)
    private float mountainsStrengthReceiveMoreDamage(float amount) {

        PlayerEntity player = (PlayerEntity) (Object) this;


        if (!CharmHelper.charmMountainsStrengthEquipped(player)) return amount;


        return (float) (amount * 1.25);

    }

    //arrowDance
    @Inject(method = "canBeHitByProjectile", at = @At("RETURN"), cancellable = true)
    private void arrowDanceEffect(CallbackInfoReturnable<Boolean> cir) {

        PlayerEntity player = (PlayerEntity) (Object) this;


        if (!CharmHelper.charmArrowDanceEquipped(player)) return;


        if (!player.isSneaking()) return;

        cir.setReturnValue(false);

    }

    @ModifyArg(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"), index = 1)
    private float arrowDanceReceiveMoreDamage(float amount) {

        PlayerEntity player = (PlayerEntity) (Object) this;


        if (!CharmHelper.charmArrowDanceEquipped(player)) return amount;


        return (float) (amount * 1.25);

    }

    //climbersPath
    @Inject(method = "travel", at = @At("RETURN"))
    private void climbersPathHungerWhileRunning(Vec3d movementInput, CallbackInfo ci) {

        PlayerEntity player = (PlayerEntity) (Object) this;


        if (!CharmHelper.charmClimbersPathEquipped(player)) return;


        if (!player.isSprinting()) return;

        player.addExhaustion(0.05F);

    }

    //weightlessFlow
    @Inject(method = "travel", at = @At("RETURN"))
    private void weightlessFlowHungerWhileRunning(Vec3d movementInput, CallbackInfo ci) {

        PlayerEntity player = (PlayerEntity) (Object) this;


        if (!CharmHelper.charmWeightlessFlowEquipped(player)) return;


        if (!player.isSprinting()) return;

        player.addExhaustion(0.05F);

    }

    //drownedFreedom
    @Inject(method = "travel", at = @At("RETURN"))
    private void drownedFreedomHungerWhileRunning(Vec3d movementInput, CallbackInfo ci) {

        PlayerEntity player = (PlayerEntity) (Object) this;


        if (!CharmHelper.charmDrownedFreedomEquipped(player)) return;


        if (!player.isSprinting()) return;

        player.addExhaustion(0.05F);

    }

}

