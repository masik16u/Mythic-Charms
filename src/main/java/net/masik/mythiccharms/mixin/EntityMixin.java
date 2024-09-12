package net.masik.mythiccharms.mixin;

import net.masik.mythiccharms.particle.ModParticles;
import net.masik.mythiccharms.util.CharmHelper;
import net.masik.mythiccharms.util.ParticleHelper;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(Entity.class)
public class EntityMixin {

    //drownedFreedom
    @Inject(method = "isTouchingWater", at = @At("RETURN"), cancellable = true)
    private void drownedFreedomEffectTouch(CallbackInfoReturnable<Boolean> cir) {

        Entity entity = (Entity) (Object) this;

        if (!entity.isPlayer()) return;


        if (!CharmHelper.charmDrownedFreedomEquipped((LivingEntity) entity)) return;


        //PARTICLE
        PlayerEntity player = (PlayerEntity) entity;

        Random random = Random.create();

        if (random.nextInt(90) < 1 && cir.getReturnValue()) {
            ParticleHelper.spawnParticle(player, ModParticles.DROWNED_FREEDOM_EFFECT_PARTICLE,
                    player.getX() + (double) random.nextBetween(-5, 5) / 10,
                    player.getY() + (double) random.nextBetween(2, 15) / 10,
                    player.getZ() + (double) random.nextBetween(-5, 5) / 10,
                    1, 0.1, 0.1, 0.1, 0.01);
        }

        cir.setReturnValue(false);

    }

    @Inject(method = "isSwimming", at = @At("RETURN"), cancellable = true)
    private void drownedFreedomEffectSwim(CallbackInfoReturnable<Boolean> cir) {

        Entity entity = (Entity) (Object) this;

        if (!entity.isPlayer()) return;


        if (!CharmHelper.charmDrownedFreedomEquipped((LivingEntity) entity)) return;


        cir.setReturnValue(false);

    }

    //safeTerritory
    @Inject(method = "canExplosionDestroyBlock", at = @At("RETURN"), cancellable = true)
    private void safeTerritoryEffect(Explosion explosion, BlockView world, BlockPos pos, BlockState state, float explosionPower, CallbackInfoReturnable<Boolean> cir) {

        Entity entity = (Entity) (Object) this;

        Box box = Box.from(entity.getPos()).expand(4);

        List<PlayerEntity> players = new ArrayList<>(entity.getWorld().getEntitiesByClass(PlayerEntity.class, box, player -> true));

        players.forEach(player -> {


            if (!CharmHelper.charmSafeTerritoryEquipped(player)) return;


            //PARTICLE
            Random random = Random.create();

            if (random.nextInt(250) < 1) {
                ParticleHelper.spawnParticle(player, ModParticles.SAFE_TERRITORY_EFFECT_PARTICLE,
                        entity.getX() + (double) random.nextBetween(-5, 5) / 10,
                        entity.getY() + (double) random.nextBetween(2, 15) / 10,
                        entity.getZ() + (double) random.nextBetween(-5, 5) / 10,
                        1, 0.1, 0.1, 0.1, 0.08);
            }

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

        //PARTICLE
        PlayerEntity player = (PlayerEntity) entity;

        Random random = Random.create();

        if (random.nextInt(10) < 8) {
            ParticleHelper.spawnParticle(player, ModParticles.QUIET_PRESENCE_EFFECT_PARTICLE,
                    player.getX() + (double) random.nextBetween(-2, 2) / 10,
                    player.getY(),
                    player.getZ() + (double) random.nextBetween(-2, 2) / 10,
                    1, 0.1, 0.1, 0.1, 0.01);
        }

        cir.setReturnValue(true);

    }

}
