package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.item.ModItems;
import net.masik.mythiccharms.util.CharmHelper;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
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
    @Inject(method = "dropInventory", at = @At("HEAD"))
    private void destroyFragileCharms(CallbackInfo info) {

        PlayerEntity player = (PlayerEntity) (Object) this;

        TrinketsApi.getTrinketComponent(player).ifPresent(trinkets -> trinkets.forEach((ref, stack) -> {

            if (stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "fragile_charms")))) {

                player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENTITY_ITEM_BREAK, player.getSoundCategory(), 20.0F, 1.0F);

                ref.inventory().setStack(ref.index(), ModItems.BROKEN_CHARM.getDefaultStack());

            }

        }));

    }

    //earthsOrder
    @Inject(method = "canHarvest", at = @At("RETURN"), cancellable = true)
    private void earthsOrderEffect(BlockState state, CallbackInfoReturnable<Boolean> cir) {

        PlayerEntity player = (PlayerEntity) (Object) this;


        if (!CharmHelper.charmEarthsOrderEquipped(player)) return;


        if (!player.getMainHandStack().isOf(Items.AIR)) return;

        cir.setReturnValue(true);

    }

    @Inject(method = "getBlockBreakingSpeed", at = @At("RETURN"), cancellable = true)
    private void earthsOrderEffectSpeed(BlockState block, CallbackInfoReturnable<Float> cir) {

        PlayerEntity player = (PlayerEntity) (Object) this;


        if (!CharmHelper.charmEarthsOrderEquipped(player)) return;


        if (!player.getMainHandStack().isOf(Items.AIR)) return;

        float speedModifier = 1.5F;

        //battleFury combo
        if (CharmHelper.charmBattleFuryEquipped(player) && CharmHelper.charmCombinationEarthsOrderAndBattleFuryEnabled(player)) {

            speedModifier *= 1 + 2 * (((float) player.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH)) - player.getHealth()) / 20;

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

        player.addExhaustion(0.1F);

        float speed = 0.035F;

        //highBounds combo
        if (CharmHelper.charmHighBoundsEquipped(player) && CharmHelper.charmCombinationFleetingStridesAndHighBoundsEnabled(player)) {

            speed += 0.01F;
            player.addExhaustion(0.05F);

        }

        //battleFury combo
        if (CharmHelper.charmBattleFuryEquipped(player) && CharmHelper.charmCombinationFleetingStridesAndBattleFuryEnabled(player)) {

            speed += 0.02F * (((float) player.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH)) - player.getHealth()) / 20;
            player.addExhaustion(0.1F * (((float) player.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH)) - player.getHealth()) / 20);

        }

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
            if (CharmHelper.charmBattleFuryEquipped(player) && CharmHelper.charmCombinationBlazingEmbraceAndBattleFuryEnabled(player)) {

                duration *= ((((float) player.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH)) - player.getHealth()) / 20);

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


        return amount * (1 + 2 * (((float) player.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH)) - player.getHealth()) / 20);

    }

    //echoingWrath
    @Inject(method = "damage", at = @At("RETURN"))
    private void echoingWrathEffect(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {

        PlayerEntity player = (PlayerEntity) (Object) this;


        if (!CharmHelper.charmEchoingWrathEquipped(player)) return;


        Box box = Box.from(player.getPos()).expand(3);

        List<Entity> entities = new ArrayList<>(player.getWorld().getEntitiesByClass(MobEntity.class, box, entity -> true));

        entities.forEach(entity -> {

            float damageMultiplier = 1;

            //battleFury combo
            if (CharmHelper.charmBattleFuryEquipped(player) && CharmHelper.charmCombinationEchoingWrathAndBattleFuryEnabled(player)) {

                damageMultiplier += 2 * (((float) player.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH)) - player.getHealth()) / 20;

            }

            //blazingEmbrace combo
            if (CharmHelper.charmBlazingEmbraceEquipped(player) && CharmHelper.charmCombinationEchoingWrathAndBlazingEmbraceEnabled(player)) {

                damageMultiplier *= 0.5F;

                entity.setFireTicks(60);

            }

            entity.damage(source, amount / 2 > 6 ? 3 * damageMultiplier : amount / 2 * damageMultiplier);

            entity.setVelocity(entity.getVelocity().add(player.getPos().subtract(entity.getPos()).multiply(-0.03F)));
            entity.velocityModified = true;

        });

    }

    //mountainsStrength and echoingWrath
    @ModifyArg(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"), index = 1)
    private float receiveMoreDamage(float amount) {

        PlayerEntity player = (PlayerEntity) (Object) this;


        if (!CharmHelper.charmMountainsStrengthEquipped(player) &&
                !CharmHelper.charmEchoingWrathEquipped(player) &&
                !CharmHelper.charmArrowDanceEquipped(player)) return amount;


        double multiplier = 0;

        if (CharmHelper.charmMountainsStrengthEquipped(player)) multiplier += 0.25;

        if (CharmHelper.charmEchoingWrathEquipped(player)) multiplier += 0.25;

        if (CharmHelper.charmArrowDanceEquipped(player)) multiplier += 0.5;

        return (float) (amount + multiplier * amount);

    }

    //enchantedWhispers
    @Inject(method = "getEnchantmentTableSeed", at = @At("RETURN"), cancellable = true)
    private void enchantedWhispersEffect(CallbackInfoReturnable<Integer> cir) {

        PlayerEntity player = (PlayerEntity) (Object) this;


        if (!CharmHelper.charmEnchantedWhispersEquipped(player)) return;


        if (player.experienceLevel <= 1) return;

        Random random = Random.create();

        cir.setReturnValue(random.nextInt());

        player.addExperienceLevels(-1);

    }

    //arrowDance
    @Inject(method = "canBeHitByProjectile", at = @At("RETURN"), cancellable = true)
    private void arrowDanceEffect(CallbackInfoReturnable<Boolean> cir) {

        java.util.Random rand = new java.util.Random();

        if (rand.nextInt(10) >= 7) return;

        PlayerEntity player = (PlayerEntity) (Object) this;


        if (!CharmHelper.charmArrowDanceEquipped(player)) return;


        cir.setReturnValue(false);

    }

    //climbersPath, weightlessFlow and drownedFreedom
    @Inject(method = "travel", at = @At("RETURN"))
    private void hungerWhileRunning(Vec3d movementInput, CallbackInfo ci) {

        PlayerEntity player = (PlayerEntity) (Object) this;


        if (!CharmHelper.charmClimbersPathEquipped(player) &&
                !CharmHelper.charmDrownedFreedomEquipped(player) &&
                !CharmHelper.charmWeightlessFlowEquipped(player)) return;


        if (!player.isSprinting()) return;

        float exhaustion = 0;

        if (CharmHelper.charmClimbersPathEquipped(player)) exhaustion += 0.05F;

        if (CharmHelper.charmDrownedFreedomEquipped(player)) exhaustion += 0.05F;

        if (CharmHelper.charmWeightlessFlowEquipped(player)) exhaustion += 0.05F;

        player.addExhaustion(exhaustion);

    }


    //resonance ring
    @ModifyArg(method = "dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ItemEntity;setPickupDelay(I)V"))
    private int dropItem(int pickupDelay) {

        PlayerEntity player = (PlayerEntity) (Object) this;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(player);

        if (trinket.isEmpty() || (!trinket.get().isEquipped(ModItems.RESONANCE_RING))) {
            return pickupDelay;
        }

        return 120;

    }

}

