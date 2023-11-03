package net.masik.mythiccharms.mixin;

import net.masik.mythiccharms.util.CharmHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
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

            this.ticksInAir += 1;

        } else {

            this.ticksInAir = 0;

        }

        int ticksInAirCap = 40;

        //highBounds combo
        if (CharmHelper.charmHighBoundsEquipped(player) && CharmHelper.charmCombinationFeatheredGraceAndHighBoundsEnabled(player))
            ticksInAirCap = 60;

        //weightlessFlow combo
        if (player.isSneaking() && (!CharmHelper.charmCombinationWeightlessFlowAndFeatheredGraceEnabled(player) ||
                (!CharmHelper.charmWeightlessFlowEquipped(player) &&
                        CharmHelper.charmCombinationWeightlessFlowAndFeatheredGraceEnabled(player)))) {
            return;
        }


        if (this.ticksInAir >= 8 && this.ticksInAir < ticksInAirCap) {

            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 4, 0,
                    false, false, false));

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

        });

    }

    //botanicBlessing
    @Inject(method = "playerTick", at = @At("RETURN"))
    private void botanicBlessingEffect(CallbackInfo info) {

        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;

        java.util.Random rand = new java.util.Random();


        if (!CharmHelper.charmBotanicBlessingEquipped(player)) return;


        if (this.cropGrowTimer > 20) {

            this.cropGrowTimer = 0;

            for (BlockPos pos : BlockPos.iterate(new BlockPos(-2, 0, -2), new BlockPos(2, 1, 2))) {

                if (rand.nextInt(10) < 4) {

                    BlockPos blockPos = player.getBlockPos().add(pos);

                    BlockState blockState = player.getWorld().getBlockState(blockPos);

                    if (blockState.getBlock() instanceof CropBlock cropBlock) {

                        if (!cropBlock.isMature(blockState)) {

                            player.getWorld().setBlockState(blockPos, cropBlock.withAge(cropBlock.getAge(blockState) + 1));

                        }

                    }

                }

            }

        }

        this.cropGrowTimer++;

    }

}