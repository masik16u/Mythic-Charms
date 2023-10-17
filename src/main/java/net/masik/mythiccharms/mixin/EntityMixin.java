package net.masik.mythiccharms.mixin;

import com.google.common.collect.Iterables;
import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.BlockView;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(Entity.class)
public class EntityMixin {

    //drownedFreedom
    @Inject(method = "isTouchingWater", at = @At("RETURN"), cancellable = true)
    private void drownedFreedomEffectTouch(CallbackInfoReturnable<Boolean> cir) {

        Entity entity = (Entity) (Object) this;

        if (entity.isPlayer()) {

            if (TrinketsApi.getTrinketComponent((LivingEntity) entity).get().isEquipped(ModItems.FRAGILE_CHARM_OF_DROWNED_FREEDOM) ||
                    TrinketsApi.getTrinketComponent((LivingEntity) entity).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_DROWNED_FREEDOM)) {

                cir.setReturnValue(false);

            }

        }

    }

    @Inject(method = "isSwimming", at = @At("RETURN"), cancellable = true)
    private void drownedFreedomEffectSwim(CallbackInfoReturnable<Boolean> cir) {

        Entity entity = (Entity) (Object) this;

        if (entity.isPlayer()) {

            if (TrinketsApi.getTrinketComponent((LivingEntity) entity).get().isEquipped(ModItems.FRAGILE_CHARM_OF_DROWNED_FREEDOM) ||
                    TrinketsApi.getTrinketComponent((LivingEntity) entity).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_DROWNED_FREEDOM)) {

                cir.setReturnValue(false);

            }

        }

    }

    //weightlessFlow
    @Inject(method = "hasNoGravity", at = @At("RETURN"), cancellable = true)
    private void weightlessFlowEffect(CallbackInfoReturnable<Boolean> cir) {

        Entity entity = (Entity) (Object) this;

        if (entity.isPlayer()) {

            if ((TrinketsApi.getTrinketComponent((LivingEntity) entity).get().isEquipped(ModItems.FRAGILE_CHARM_OF_WEIGHTLESS_FLOW) ||
                    TrinketsApi.getTrinketComponent((LivingEntity) entity).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_WEIGHTLESS_FLOW)) &&
                    !entity.isSneaking()) {

                cir.setReturnValue(true);

            }

        }

    }

    //safeTerritory
    @Inject(method = "canExplosionDestroyBlock", at = @At("RETURN"), cancellable = true)
    private void safeTerritoryEffect(Explosion explosion, BlockView world, BlockPos pos, BlockState state, float explosionPower, CallbackInfoReturnable<Boolean> cir) {

        Entity entity = (Entity) (Object) this;

        Box box = Box.from(entity.getPos()).expand(4);

        List<Entity> players = new ArrayList<>(entity.getWorld().getEntitiesByClass(PlayerEntity.class, box, player -> true));

        players.forEach(player -> {

            if (TrinketsApi.getTrinketComponent((LivingEntity) player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_SAFE_TERRITORY) ||
                    TrinketsApi.getTrinketComponent((LivingEntity) player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_SAFE_TERRITORY)) {

                cir.setReturnValue(false);

            }

        });

    }

    //quietPresence
    @Inject(method = "bypassesSteppingEffects", at = @At("RETURN"), cancellable = true)
    private void quietPresenceEffect(CallbackInfoReturnable<Boolean> cir) {

        Entity entity = (Entity) (Object) this;

        if (entity.isPlayer()) {

            //featheredGrace combo somewhere here
            if ((TrinketsApi.getTrinketComponent((LivingEntity) entity).get().isEquipped(ModItems.FRAGILE_CHARM_OF_QUIET_PRESENCE) ||
                    TrinketsApi.getTrinketComponent((LivingEntity) entity).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_QUIET_PRESENCE)) &&
                    !entity.isSprinting() && (entity.isOnGround() ||
                    (TrinketsApi.getTrinketComponent((LivingEntity) entity).get().isEquipped(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE) ||
                            TrinketsApi.getTrinketComponent((LivingEntity) entity).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FEATHERED_GRACE)))) {

                cir.setReturnValue(true);

            }

        }

    }

}
