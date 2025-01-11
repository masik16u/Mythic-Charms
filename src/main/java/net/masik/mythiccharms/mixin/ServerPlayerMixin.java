package net.masik.mythiccharms.mixin;

import net.masik.mythiccharms.particle.ModParticles;
import net.masik.mythiccharms.util.BattleFuryHelper;
import net.masik.mythiccharms.util.CharmHelper;
import net.masik.mythiccharms.util.ParticleHelper;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerMixin {

    @Unique
    private int ticksInAir = 0;

    @Unique
    private int cropGrowTimer = 0;

    //featheredGrace
    @Inject(method = "playerTick", at = @At("RETURN"))
    private void featheredGraceEffect(CallbackInfo info) {

        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;


        if (!CharmHelper.charmFeatheredGraceEquipped(player)) return;


        if (!player.isOnGround() && !player.isClimbing() && !player.isInsideWaterOrBubbleColumn() &&
                !player.isFallFlying() && player.getVelocity().y < 0) {

            ticksInAir += 1;

        } else {

            ticksInAir = 0;

        }

        int ticksInAirCap = 40;

        //highBounds combo
        if (CharmHelper.charmHighBoundsEquipped(player) &&
                CharmHelper.charmCombinationFeatheredGraceAndHighBoundsEnabled(player)) ticksInAirCap = 60;

        //weightlessFlow combo
        if (player.isSneaking() && (!CharmHelper.charmCombinationWeightlessFlowAndFeatheredGraceEnabled(player) ||
                (!CharmHelper.charmWeightlessFlowEquipped(player) &&
                        CharmHelper.charmCombinationWeightlessFlowAndFeatheredGraceEnabled(player)))) {
            return;
        }

        if (ticksInAir >= 8 && ticksInAir < ticksInAirCap) {

            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 4, 0,
                    false, false, false));

            //AdvancementsHelper.grantAdvancement(player, new Identifier("mythic_charms:story/charm_feathered_grace"));

            //PARTICLE
            Random random = Random.create();

            if (random.nextInt(10) < 3) {
                ParticleHelper.spawnParticle(player, ModParticles.FEATHERED_GRACE_EFFECT_PARTICLE,
                        player.getX() + (double) random.nextBetween(-2, 2) / 10,
                        player.getY(),
                        player.getZ() + (double) random.nextBetween(-2, 2) / 10,
                        1, 0.1, 0.1, 0.1, 0.01);
            }

        }

        if (this.ticksInAir >= 40 && this.ticksInAir < ticksInAirCap) {

            player.addExhaustion(0.05F);

        }

    }

    //collectorsGift
    @Inject(method = "playerTick", at = @At("RETURN"))
    private void collectorsGiftEffect(CallbackInfo info) {

        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;


        if (!CharmHelper.charmCollectorsGiftEquipped(player)) return;


        Box box = Box.from(player.getPos()).expand(4);

        List<Entity> entities = new ArrayList<>(player.getWorld().getEntitiesByType(EntityType.ITEM, box, item -> true));

        entities.forEach(item -> {

            item.setVelocity(item.getVelocity().add(player.getPos().subtract(item.getPos()).multiply(0.03F)));

            item.velocityModified = true;

            //PARTICLE
            Random random = Random.create();

            if (random.nextInt(10) < 1) {
                ParticleHelper.spawnParticle(player, ModParticles.COLLECTORS_GIFT_EFFECT_PARTICLE,
                        item.getX() + (double) random.nextBetween(-1, 1) / 10,
                        item.getY() + 0.5F,
                        item.getZ() + (double) random.nextBetween(-1, 1) / 10,
                        1, 0.1, 0.1, 0.1, 0.01);
            }

        });

    }

    //botanicBlessing
    @Inject(method = "playerTick", at = @At("RETURN"))
    private void botanicBlessingEffect(CallbackInfo info){

        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;

        Random random = Random.create();


        if (!CharmHelper.charmBotanicBlessingEquipped(player)) return;


        if (cropGrowTimer > 20) {

            cropGrowTimer = 0;

            for (BlockPos pos : BlockPos.iterate(new BlockPos(-4, 0, -4), new BlockPos(4, 1, 4))) {

                if (random.nextInt(10) < 4) {

                    BlockPos blockPos = player.getBlockPos().add(pos);

                    BlockState blockState = player.getWorld().getBlockState(blockPos);

                    if (blockState.getBlock() instanceof CropBlock cropBlock) {

                        if (!cropBlock.isMature(blockState)) {

                            //PARTICLE
                            if (random.nextInt(10) < 8) {
                                ParticleHelper.spawnParticle(player, ModParticles.BOTANIC_BLESSING_EFFECT_PARTICLE,
                                        blockPos.getX() + (double) random.nextBetween(-2, 2) / 10,
                                        blockPos.getY() + 1,
                                        blockPos.getZ() + (double) random.nextBetween(-2, 2) / 10,
                                        1, 0.1, 0.1, 0.1, 0.01);
                            }

                            player.getWorld().setBlockState(blockPos, cropBlock.withAge(cropBlock.getAge(blockState) + 1));

                        }

                    }

//                    if (rand.nextInt(10) < 6 && blockState.getBlock() instanceof PlantBlock) {
//
//                        for (int i = 0; i < 8; i++) {
//
//                            if (blockState.contains(BotanicBlessingHelper.AGES.get(i))) {
//
//                                IntProperty property = BotanicBlessingHelper.AGES.get(i);
//
//                                if (!blockState.get(property).equals(BotanicBlessingHelper.MAX_AGES.get(i))) {
//
//                                    player.getWorld().setBlockState(blockPos, blockState.with(property, blockState.get(property) + 1));
//
//                                }
//
//                                break;
//
//                            }
//
//                        }
//
//                    }

                }

            }

        }

        cropGrowTimer++;

    }

    //weightlessFlow
    @Inject(method = "playerTick", at = @At("RETURN"))
    private void weightlessFlowEffect(CallbackInfo info) {

        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;


        if (!CharmHelper.charmWeightlessFlowEquipped(player)) {
            player.setNoGravity(false);
            return;
        }


        if (player.isSneaking()) {
            player.setNoGravity(false);
            return;
        }

        //PARTICLE
        Random random = Random.create();

        if (random.nextInt(10) < 2) {
            ParticleHelper.spawnParticle(player, ModParticles.WEIGHTLESS_FLOW_EFFECT_PARTICLE,
                    player.getX() + (double) random.nextBetween(-2, 2) / 10,
                    player.getY(),
                    player.getZ() + (double) random.nextBetween(-2, 2) / 10,
                    1, 0.1, 0.1, 0.1, 0.01);
        }

        player.setNoGravity(true);

    }

    //battleFury
    @Inject(method = "playerTick", at = @At("RETURN"))
    private void battleFuryEffectParticle(CallbackInfo info) {

        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;


        if (!CharmHelper.charmBattleFuryEquipped(player)) return;

        //PARTICLE
        Random random = Random.create();

        if (random.nextInt((int) (16 - 2 * BattleFuryHelper.getMultiplier(player))) < 1 && BattleFuryHelper.getMultiplier(player) > 1) {
            ParticleHelper.spawnParticle(player, ModParticles.BATTLE_FURY_EFFECT_PARTICLE,
                    player.getX() + (double) random.nextBetween(-5, 5) / 10,
                    player.getY() + (double) random.nextBetween(2, 15) / 10,
                    player.getZ() + (double) random.nextBetween(-5, 5) / 10,
                    1, 0.1, 0.1, 0.1, 0.01 * BattleFuryHelper.getMultiplier(player));
        }

    }

    //enchantedWhispers
    @Inject(method = "playerTick", at = @At("RETURN"))
    private void enchantedWhispersEffectParticle(CallbackInfo info){

        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;


        if (!CharmHelper.charmEnchantedWhispersEquipped(player)) return;

        Random random = Random.create();

        if (random.nextInt(10) < 4) {
            for (BlockPos pos : BlockPos.iterate(new BlockPos(-2, -1, -2), new BlockPos(2, 1, 2))) {

                BlockPos blockPos = player.getBlockPos().add(pos);

                if (player.getWorld().getBlockState(blockPos).getBlock() instanceof EnchantingTableBlock) {

                    //PARTICLE
                    if (random.nextInt(10) < 1) {
                        ParticleHelper.spawnParticle(player, ModParticles.ENCHANTED_WHISPERS_EFFECT_PARTICLE,
                                blockPos.getX() + (double) random.nextBetween(-2, 2) / 10,
                                blockPos.getY() + 1,
                                blockPos.getZ() + (double) random.nextBetween(-2, 2) / 10,
                                1, 0.1, 0.1, 0.1, 0.01);
                    }
                }
            }
        }
    }

}
