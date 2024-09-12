package net.masik.mythiccharms.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.masik.mythiccharms.particle.ModParticles;
import net.masik.mythiccharms.util.CharmHelper;
import net.masik.mythiccharms.util.ParticleHelper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.spawner.PhantomSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PhantomSpawner.class)
public class PhantomSpawnerMixin {

    @Inject(method = "spawn", at = @At(value = "INVOKE", target = "Lnet/minecraft/stat/StatType;getOrCreateStat(Ljava/lang/Object;)Lnet/minecraft/stat/Stat;"), cancellable = true)
    private void nightsGuardianEffect(ServerWorld world, boolean spawnMonsters, boolean spawnAnimals, CallbackInfoReturnable<Integer> cir, @Local ServerPlayerEntity player) {


        if (!CharmHelper.charmNightsGuardianEquipped(player)) return;


        //PARTICLE
        Random random = Random.create();

        if (random.nextInt(90) < 1) {
            ParticleHelper.spawnParticle(player, ModParticles.NIGHTS_GUARDIAN_EFFECT_PARTICLE,
                    player.getX() + (double) random.nextBetween(-5, 5) / 10,
                    player.getY() + (double) random.nextBetween(2, 15) / 10,
                    player.getZ() + (double) random.nextBetween(-5, 5) / 10,
                    1, 0.1, 0.1, 0.1, 0.01);
        }

        cir.setReturnValue(0);

    }

}
