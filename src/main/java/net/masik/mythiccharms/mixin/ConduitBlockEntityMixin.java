package net.masik.mythiccharms.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.masik.mythiccharms.util.CharmHelper;
import net.minecraft.block.entity.ConduitBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.FluidTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ConduitBlockEntity.class)
public class ConduitBlockEntityMixin {

    @WrapOperation(method = "givePlayersEffects", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isTouchingWaterOrRain()Z"))
    private static boolean drownedFreedomEffectConduit(PlayerEntity instance, Operation<Boolean> original) {

        if (!CharmHelper.charmDrownedFreedomEquipped(instance)) return original.call(instance);

        return instance.updateMovementInFluid(FluidTags.WATER, 0.014);

    }

}
