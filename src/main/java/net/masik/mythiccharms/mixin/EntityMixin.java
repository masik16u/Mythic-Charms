package net.masik.mythiccharms.mixin;

import net.masik.mythiccharms.util.CharmHelper;
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


        if (!CharmHelper.charmDrownedFreedomEquipped((LivingEntity) entity)) return;


        cir.setReturnValue(false);

    }

    @Inject(method = "isSwimming", at = @At("RETURN"), cancellable = true)
    private void drownedFreedomEffectSwim(CallbackInfoReturnable<Boolean> cir) {

        Entity entity = (Entity) (Object) this;

        if (!entity.isPlayer()) return;


        if (!CharmHelper.charmDrownedFreedomEquipped((LivingEntity) entity)) return;


        cir.setReturnValue(false);

    }

    //weightlessFlow
    @Inject(method = "hasNoGravity", at = @At("RETURN"), cancellable = true)
    private void weightlessFlowEffect(CallbackInfoReturnable<Boolean> cir) {

        Entity entity = (Entity) (Object) this;

        if (!entity.isPlayer()) return;


        if (!CharmHelper.charmWeightlessFlowEquipped((LivingEntity) entity)) return;


        if (entity.isSneaking()) return;

        cir.setReturnValue(true);

    }

    //safeTerritory
    @Inject(method = "canExplosionDestroyBlock", at = @At("RETURN"), cancellable = true)
    private void safeTerritoryEffect(Explosion explosion, BlockView world, BlockPos pos, BlockState state, float explosionPower, CallbackInfoReturnable<Boolean> cir) {

        Entity entity = (Entity) (Object) this;

        Box box = Box.from(entity.getPos()).expand(3);

        List<Entity> players = new ArrayList<>(entity.getWorld().getEntitiesByClass(PlayerEntity.class, box, player -> true));

        players.forEach(player -> {


            if (!CharmHelper.charmSafeTerritoryEquipped((LivingEntity) player)) return;


            cir.setReturnValue(false);

        });

    }

    //quietPresence
    @Inject(method = "bypassesSteppingEffects", at = @At("RETURN"), cancellable = true)
    private void quietPresenceEffect(CallbackInfoReturnable<Boolean> cir) {

        Entity entity = (Entity) (Object) this;

        if (!entity.isPlayer()) return;


        if (!CharmHelper.charmQuietPresenceEquipped((LivingEntity) entity)) return;


        if (entity.isSprinting()) return;

        //featheredGrace combo
        if (!entity.isOnGround() && (!CharmHelper.charmCombinationQuietPresenceAndFeatheredGraceEnabled((LivingEntity) entity) ||
                (!CharmHelper.charmFeatheredGraceEquipped((LivingEntity) entity) &&
                        CharmHelper.charmCombinationQuietPresenceAndFeatheredGraceEnabled((LivingEntity) entity)))) return;

        cir.setReturnValue(true);

    }

}
