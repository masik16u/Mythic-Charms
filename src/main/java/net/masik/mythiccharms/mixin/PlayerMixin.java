package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.*;
import net.masik.mythiccharms.MythicCharms;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(PlayerEntity.class)
public class PlayerMixin {

    //fragile charms
    @Inject(method = "dropInventory",  at = @At("HEAD"))
    public void dropInventory(CallbackInfo info){
        PlayerEntity player = (PlayerEntity) (Object) this;

        MythicCharms.LOGGER.info("Lol you died");
    }

    @Redirect(method = "canHarvest", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isToolRequired()Z"))
    public boolean canHarvest(BlockState instance) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        if (!TrinketsApi.getTrinketComponent(player).get().isEquipped(Items.NETHERITE_INGOT)) return instance.isToolRequired();

        return player.getMainHandStack().isDamageable() && instance.isToolRequired();
    }

    /*@Inject(method = "getBurningDuration", at = @At(value = "RETURN"), cancellable = true)
    public void getBurningDuration(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(40);
    }*/

    @ModifyArg(method = "setFireTicks", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setFireTicks(I)V"))
    @Debug(export = true)
    public int modifyFireTicks(int fireTicks) {
        return fireTicks / 2;
    }
}

