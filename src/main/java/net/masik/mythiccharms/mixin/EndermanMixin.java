package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EndermanEntity.class)
public class EndermanMixin {

    @Inject(method = "isPlayerStaring", at = @At("RETURN"), cancellable = true)
    private void gazeSerenityEffect(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {

        if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.FRAGILE_CHARM_OF_GAZE_SERENITY) ||
                TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_GAZE_SERENITY)) {

            cir.setReturnValue(false);

        }

    }

}
