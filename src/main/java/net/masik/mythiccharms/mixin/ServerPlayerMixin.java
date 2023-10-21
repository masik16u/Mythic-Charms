package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.item.ModItems;
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
import java.util.Optional;

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

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(player);

        if (trinket.isEmpty() || (!trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE) &&
                !trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FEATHERED_GRACE))) {
            return;
        }

        if (!player.isOnGround() && !player.isClimbing() && !player.isInsideWaterOrBubbleColumn() &&
                !player.isFallFlying() && player.getVelocity().y < 0) {

            ticksInAir += 1;

        } else {

            ticksInAir = 0;

        }

        int ticksInAirCap = 40;

        //highBounds combo
        if (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_HIGH_BOUNDS) ||
                trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_HIGH_BOUNDS)) {

            ticksInAirCap = 60;

        }

        if (ticksInAir >= 8 && ticksInAir < ticksInAirCap && (!player.isSneaking() ||
                (trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_WEIGHTLESS_FLOW) ||
                        trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_WEIGHTLESS_FLOW)))) {

            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 4, 0,
                    false, false, false));

        }

    }

    //collectorsGift
    @Inject(method = "playerTick", at = @At("RETURN"))
    private void collectorsGiftEffect(CallbackInfo info) {

        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(player);

        if (trinket.isEmpty() || (!trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_COLLECTORS_GIFT) &&
                !trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_COLLECTORS_GIFT))) {
            return;
        }

        Box box = Box.from(player.getPos()).expand(4);

        List<Entity> entities = new ArrayList<>(player.getWorld().getEntitiesByType(EntityType.ITEM, box, item -> true));

        entities.forEach(item -> {

            item.setVelocity(item.getVelocity().add(player.getPos().subtract(item.getPos()).multiply(0.03F)));

            item.velocityModified = true;

        });

    }

    //botanicBlessing
    @Inject(method = "playerTick", at = @At("RETURN"))
    private void botanicBlessingEffect(CallbackInfo info){

        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;

        java.util.Random rand = new java.util.Random();

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(player);

        if (trinket.isEmpty() || (!trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BOTANIC_BLESSING) &&
                !trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BOTANIC_BLESSING))) {
            return;
        }

        if (cropGrowTimer > 20) {

            cropGrowTimer = 0;

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

        cropGrowTimer++;

    }

}
