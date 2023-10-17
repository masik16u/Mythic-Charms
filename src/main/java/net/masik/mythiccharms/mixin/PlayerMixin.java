package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.*;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.block.ModBlocks;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
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

@Mixin(PlayerEntity.class)
public class PlayerMixin {

    //fragile charms
    @Inject(method = "dropInventory",  at = @At("RETURN"))
    private void destroyFragileCharms(CallbackInfo info){

        PlayerEntity player = (PlayerEntity) (Object) this;

        TrinketsApi.getTrinketComponent(player).ifPresent(trinkets -> trinkets.forEach((ref, stack) -> {

            if (stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "fragile_charms")))) {

                player.getWorld().playSound((PlayerEntity)null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENTITY_ITEM_BREAK, player.getSoundCategory(), 20.0F, 1.0F);

                ref.inventory().setStack(ref.index(), ModItems.BROKEN_CHARM.getDefaultStack());

            }

        }));

    }

    //earthsOrder
    @Inject(method = "canHarvest", at = @At("RETURN"), cancellable = true)
    private void earthsOrderEffect(BlockState state, CallbackInfoReturnable<Boolean> cir) {

        PlayerEntity player = (PlayerEntity) (Object) this;

        if ((TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_EARTHS_ORDER) ||
                TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_EARTHS_ORDER)) &&
                player.getMainHandStack().isOf(Items.AIR)) {

            cir.setReturnValue(true);

        }

    }

    @Inject(method = "getBlockBreakingSpeed", at = @At("RETURN"), cancellable = true)
    private void earthsOrderEffectSpeed(BlockState block, CallbackInfoReturnable<Float> cir) {

        PlayerEntity player = (PlayerEntity) (Object) this;

        if ((TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_EARTHS_ORDER) ||
                TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_EARTHS_ORDER))
                && player.getMainHandStack().isOf(Items.AIR)) {

            float speedModifier = 1.5F;

            //battleFury combo
            if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY) ||
                    TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BATTLE_FURY)) {

                speedModifier *= 1 + 2 * (((float) player.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH)) - player.getHealth()) / 20;

            }

            //drownedFreedom combo
            if ((TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_DROWNED_FREEDOM) ||
                    TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_DROWNED_FREEDOM)) &&
                    player.isSubmergedIn(FluidTags.WATER) && !EnchantmentHelper.hasAquaAffinity(player)) {

                speedModifier += 5;

            }

            //weightlessFlow combo
            if ((TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_WEIGHTLESS_FLOW) ||
                    TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_WEIGHTLESS_FLOW)) &&
                    !player.isOnGround()) {

                speedModifier += 5;

            }

            cir.setReturnValue(cir.getReturnValue() * speedModifier);

        }

    }

    //fleetingStrides
    @Inject(method = "getOffGroundSpeed", at = @At("RETURN"), cancellable = true)
    private void fleetingStridesEffect(CallbackInfoReturnable<Float> cir) {

        PlayerEntity player = (PlayerEntity) (Object) this;

        if ((TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_FLEETING_STRIDES) ||
                TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FLEETING_STRIDES)) &&
                player.isSprinting()) {

            player.addExhaustion(0.1F);

            float speed = 0.035F;

            if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_HIGH_BOUNDS) ||
                    TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_HIGH_BOUNDS)) {

                speed += 0.01F;

            }

            if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY) ||
                    TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BATTLE_FURY)) {

                speed += 0.02F * (((float) player.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH)) - player.getHealth()) / 20;
                player.addExhaustion(0.1F * (((float) player.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH)) - player.getHealth()) / 20);

            }

            cir.setReturnValue(speed);

        }

    }

    //blazingEmbrace
    @Inject(method = "setFireTicks", at = @At("RETURN"))
    private void blazingEmbraceEffect(int fireTicks, CallbackInfo ci) {

        PlayerEntity player = (PlayerEntity) (Object) this;

        if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_BLAZING_EMBRACE) ||
                TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BLAZING_EMBRACE)) {

            if (!player.isOnFire()) {

                float duration = 410;

                //battleFury combo
                if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY) ||
                        TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BATTLE_FURY)) {

                    duration *= ((((float) player.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH)) - player.getHealth()) / 20);

                }

                player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, (int) duration, 0,
                        false, false, true));

            }

        }

    }

    //battleFury
    @ModifyArg(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"), index = 1)
    private float battleFuryEffect(float amount) {

        PlayerEntity player = (PlayerEntity) (Object) this;

        if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY) ||
                TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BATTLE_FURY)) {

            return amount * (1 + 2 * (((float) player.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH)) - player.getHealth()) / 20);

        }

        return amount;

    }

    //echoingWrath
    @Inject(method = "damage", at = @At("RETURN"))
    private void echoingWrathEffect(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {

        PlayerEntity player = (PlayerEntity) (Object) this;

        if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_ECHOING_WRATH) ||
                TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_ECHOING_WRATH)) {

            Box box = Box.from(player.getPos()).expand(3);

            List<Entity> entities = new ArrayList<>(player.getWorld().getEntitiesByClass(MobEntity.class, box, entity -> true));

            entities.forEach(entity -> {

                float damageMultiplier = 1;

                //battleFury combo
                if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_BATTLE_FURY) ||
                        TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BATTLE_FURY)) {

                    damageMultiplier += 2 * (((float) player.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH)) - player.getHealth()) / 20;

                }

                if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_BLAZING_EMBRACE) ||
                        TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BLAZING_EMBRACE)) {

                    damageMultiplier *= 0.5F;

                    entity.setFireTicks(60);

                }

                entity.damage(source, amount / 2 > 6 ? 3 * damageMultiplier : amount / 2 * damageMultiplier);

            });

        }

    }

    //mountainsStrength
    @ModifyArg(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"), index = 1)
    private float mountainsStrengthNegativeEffect(float amount) {

        PlayerEntity player = (PlayerEntity) (Object) this;

        if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_MOUNTAINS_STRENGTH) ||
                TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_MOUNTAINS_STRENGTH)) {

            return (float) (amount + 0.25 * amount);

        }

        return amount;

    }

    //enchantedWhispers
    @Inject(method = "getEnchantmentTableSeed", at = @At("RETURN"), cancellable = true)
    private void enchantedWhispersEffect(CallbackInfoReturnable<Integer> cir) {

        PlayerEntity player = (PlayerEntity) (Object) this;

        if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_ENCHANTED_WHISPERS) ||
                TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_ENCHANTED_WHISPERS) &&
                        player.experienceLevel > 1) {

            Random random = Random.create();

            cir.setReturnValue(random.nextInt());

            player.addExperienceLevels(-1);

        }

    }

    //arrowDance
    @Inject(method = "canBeHitByProjectile", at = @At("RETURN"), cancellable = true)
    private void arrowDanceEffect(CallbackInfoReturnable<Boolean> cir) {

        PlayerEntity player = (PlayerEntity) (Object) this;

        java.util.Random rand = new java.util.Random();

        if ((TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_ARROW_DANCE) ||
                TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_ARROW_DANCE)) &&
                rand.nextInt(10) < 7) {

            cir.setReturnValue(false);

        }

    }

    //climbersPath
    @Inject(method = "travel", at = @At("RETURN"))
    private void climbersPathGiveHunger(Vec3d movementInput, CallbackInfo ci) {

        PlayerEntity player = (PlayerEntity) (Object) this;

        if ((TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_CLIMBERS_PATH) ||
                TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_CLIMBERS_PATH)) &&
                player.isSprinting()) {

            player.addExhaustion(0.05F);

        }

    }


    //resonance ring
    @ModifyArg(method = "dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ItemEntity;setPickupDelay(I)V"))
    private int dropItem(int pickupDelay) {

        PlayerEntity player = (PlayerEntity) (Object) this;

        if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.RESONANCE_RING)) {

            return 80;

        }

        return pickupDelay;

    }

}

