package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.item.ModItems;
import net.masik.mythiccharms.util.CharmHelper;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(EndermanEntity.class)
public class EndermanMixin {

    @Inject(method = "isPlayerStaring", at = @At("RETURN"), cancellable = true)
    private void gazeSerenityEffect(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {


        if (!CharmHelper.charmGazeSerenityEquipped(player)) return;


        cir.setReturnValue(false);

    }

}
