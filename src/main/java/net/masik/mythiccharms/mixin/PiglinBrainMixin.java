package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PiglinBrain.class)
public class PiglinBrainMixin {

    @Inject(method = "onGuardedBlockInteracted", at = @At(value = "INVOKE", target = "Ljava/util/stream/Stream;filter(Ljava/util/function/Predicate;)Ljava/util/stream/Stream;"), cancellable = true)
    private static void bartersPactEffect(PlayerEntity player, boolean blockOpen, CallbackInfo ci) {

        java.util.Random rand = new java.util.Random();

        if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_BARTERS_PACT) ||
                TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BARTERS_PACT) &&
                        rand.nextInt(10) < 7) {

            ci.cancel();

        }

    }

}
