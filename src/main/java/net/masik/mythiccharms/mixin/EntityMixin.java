package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.BlockView;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Mixin(Entity.class)
public class EntityMixin {

    //drownedFreedom
    @Inject(method = "isTouchingWater", at = @At("RETURN"), cancellable = true)
    private void drownedFreedomEffectTouch(CallbackInfoReturnable<Boolean> cir) {

        Entity entity = (Entity) (Object) this;

        if (!entity.isPlayer()) return;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent((LivingEntity) entity);

        if (trinket.isEmpty() || (!trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_DROWNED_FREEDOM) &&
                !trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_DROWNED_FREEDOM))) {
            return;
        }

        cir.setReturnValue(false);

    }

    @Inject(method = "isSwimming", at = @At("RETURN"), cancellable = true)
    private void drownedFreedomEffectSwim(CallbackInfoReturnable<Boolean> cir) {

        Entity entity = (Entity) (Object) this;

        if (!entity.isPlayer()) return;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent((LivingEntity) entity);

        if (trinket.isEmpty() || (!trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_DROWNED_FREEDOM) &&
                !trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_DROWNED_FREEDOM))) {
            return;
        }

        cir.setReturnValue(false);

    }

    //weightlessFlow
    @Inject(method = "hasNoGravity", at = @At("RETURN"), cancellable = true)
    private void weightlessFlowEffect(CallbackInfoReturnable<Boolean> cir) {

        Entity entity = (Entity) (Object) this;

        if (!entity.isPlayer()) return;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent((LivingEntity) entity);

        if (trinket.isEmpty() || (!trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_WEIGHTLESS_FLOW) &&
                !trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_WEIGHTLESS_FLOW))) {
            return;
        }

        if (entity.isSneaking()) return;

        cir.setReturnValue(true);

    }

    //safeTerritory
    @Inject(method = "canExplosionDestroyBlock", at = @At("RETURN"), cancellable = true)
    private void safeTerritoryEffect(Explosion explosion, BlockView world, BlockPos pos, BlockState state, float explosionPower, CallbackInfoReturnable<Boolean> cir) {

        Entity entity = (Entity) (Object) this;

        Box box = Box.from(entity.getPos()).expand(4);

        List<Entity> players = new ArrayList<>(entity.getWorld().getEntitiesByClass(PlayerEntity.class, box, player -> true));

        players.forEach(player -> {

            Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent((LivingEntity) player);

            if (trinket.isEmpty() || (!trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_SAFE_TERRITORY) &&
                    !trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_SAFE_TERRITORY))) {
                return;
            }

            cir.setReturnValue(false);

        });

    }

    //quietPresence
    @Inject(method = "bypassesSteppingEffects", at = @At("RETURN"), cancellable = true)
    private void quietPresenceEffect(CallbackInfoReturnable<Boolean> cir) {

        Entity entity = (Entity) (Object) this;

        if (!entity.isPlayer()) return;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent((LivingEntity) entity);

        if (trinket.isEmpty() || (!trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_QUIET_PRESENCE) &&
                !trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_QUIET_PRESENCE))) {
            return;
        }

        if (entity.isSprinting()) return;

        //featheredGrace combo
        if (!entity.isOnGround() && !trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE) &&
                !trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FEATHERED_GRACE)) {
            return;
        }

        cir.setReturnValue(true);

    }

}
