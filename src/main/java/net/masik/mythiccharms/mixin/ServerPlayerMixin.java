package net.masik.mythiccharms.mixin;

import com.mojang.authlib.GameProfile;
import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.StemBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BannerPatternItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
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

    @Inject(method = "playerTick", at = @At("HEAD"))
    private void charmsTick(CallbackInfo info){

        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;

        //featheredGrace
        if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE) ||
                TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FEATHERED_GRACE)) {

            if (!player.isOnGround() && !player.isClimbing() && !player.isInsideWaterOrBubbleColumn() &&
                    !player.isFallFlying() && player.getVelocity().y < 0) {

                ticksInAir += 1;

            } else {

                ticksInAir = 0;

            }

            int ticksInAirCap = 40;

            //highBounds combo
            if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_HIGH_BOUNDS) ||
                    TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_HIGH_BOUNDS)) {

                ticksInAirCap = 60;

            }

            if (ticksInAir >= 8 && ticksInAir < ticksInAirCap && (!player.isSneaking() ||
                    (TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_WEIGHTLESS_FLOW) ||
                    TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_WEIGHTLESS_FLOW)))) {

                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 4, 0,
                        false, false, false));

            }

        }

        //collectorsGift
        if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_COLLECTORS_GIFT) ||
                TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_COLLECTORS_GIFT)) {

            Box box = Box.from(player.getPos()).expand(4);

            List<Entity> entities = new ArrayList<>(player.getWorld().getEntitiesByType(EntityType.ITEM, box, item -> true));

            entities.forEach(item -> {

                item.setVelocity(item.getVelocity().add(player.getPos().subtract(item.getPos()).multiply(0.03F)));

                item.velocityModified = true;

            });

        }

        java.util.Random rand = new java.util.Random();

        //botanicBlessing
        if ((TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_BOTANIC_BLESSING) ||
                TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BOTANIC_BLESSING)) &&
                cropGrowTimer > 20) {

            cropGrowTimer = 0;

            for (int i = 0; i < 5; i++) {

                for (int k = 0; k < 5; k++) {

                    for (int j = 0; j < 5; j++) {

                        if (rand.nextInt(10) < 4) {
                            BlockPos blockPos = player.getBlockPos().add(-2 + i, -1 + j, -2 + k);

                            BlockState blockState = player.getWorld().getBlockState(blockPos);

                            Block block = blockState.getBlock();

                            if (block instanceof CropBlock cropBlock) {

                                if (!cropBlock.isMature(blockState)) {

                                    player.getWorld().setBlockState(blockPos, cropBlock.withAge(cropBlock.getAge(blockState) + 1));

                                }

                            }

                        }

                    }

                }

            }

        }

        cropGrowTimer++;

    }

}
