package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.ServerStatHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.spawner.PhantomSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;

@Mixin(PhantomSpawner.class)
public class PhantomSpawnerMixin {

    @Inject(method = "spawn", at = @At(value = "INVOKE", target = "Lnet/minecraft/stat/StatType;getOrCreateStat(Ljava/lang/Object;)Lnet/minecraft/stat/Stat;"), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void nightsGuardianEffect(ServerWorld world, boolean spawnMonsters, boolean spawnAnimals, CallbackInfoReturnable<Integer> cir, Random random, int i, Iterator var6, ServerPlayerEntity serverPlayerEntity, BlockPos blockPos, LocalDifficulty localDifficulty, ServerStatHandler serverStatHandler) {

        if (TrinketsApi.getTrinketComponent(serverPlayerEntity).get().isEquipped(ModItems.FRAGILE_CHARM_OF_NIGHTS_GUARDIAN) ||
                TrinketsApi.getTrinketComponent(serverPlayerEntity).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_NIGHTS_GUARDIAN)) {

            cir.setReturnValue(0);

        }

    }

}
