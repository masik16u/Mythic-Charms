package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.TrinketComponent;
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
import java.util.Optional;

@Mixin(PhantomSpawner.class)
public class PhantomSpawnerMixin {

    @Inject(method = "spawn", at = @At(value = "INVOKE", target = "Lnet/minecraft/stat/StatType;getOrCreateStat(Ljava/lang/Object;)Lnet/minecraft/stat/Stat;"), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void nightsGuardianEffect(ServerWorld world, boolean spawnMonsters, boolean spawnAnimals, CallbackInfoReturnable<Integer> cir, Random random, int i, Iterator var6, ServerPlayerEntity serverPlayerEntity, BlockPos blockPos, LocalDifficulty localDifficulty, ServerStatHandler serverStatHandler) {

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(serverPlayerEntity);

        if (trinket.isEmpty() || (!trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_NIGHTS_GUARDIAN) &&
                !trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_NIGHTS_GUARDIAN))) {
            return;
        }

        cir.setReturnValue(0);

    }

}
