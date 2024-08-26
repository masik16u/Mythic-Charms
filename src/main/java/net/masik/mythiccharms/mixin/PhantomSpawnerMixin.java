package net.masik.mythiccharms.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.masik.mythiccharms.util.CharmHelper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.spawner.PhantomSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PhantomSpawner.class)
public class PhantomSpawnerMixin {

    @Inject(method = "spawn", at = @At(value = "INVOKE", target = "Lnet/minecraft/stat/StatType;getOrCreateStat(Ljava/lang/Object;)Lnet/minecraft/stat/Stat;"), cancellable = true)
    private void nightsGuardianEffect(ServerWorld world, boolean spawnMonsters, boolean spawnAnimals, CallbackInfoReturnable<Integer> cir, @Local ServerPlayerEntity serverPlayerEntity) {


        if (!CharmHelper.charmNightsGuardianEquipped(serverPlayerEntity)) return;


        cir.setReturnValue(0);

    }

}
