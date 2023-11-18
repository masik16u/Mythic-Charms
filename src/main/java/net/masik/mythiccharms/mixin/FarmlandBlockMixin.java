package net.masik.mythiccharms.mixin;

import net.masik.mythiccharms.util.CharmHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(FarmlandBlock.class)
public class FarmlandBlockMixin {

    @Inject(method = "onLandedUpon", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/FarmlandBlock;setToDirt(Lnet/minecraft/entity/Entity;Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)V"), cancellable = true)
    private void botanicBlessingAndFeatheredGraceEffect(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance, CallbackInfo ci) {


        if (!CharmHelper.charmBotanicBlessingEquipped((LivingEntity) entity) ||
                !CharmHelper.charmFeatheredGraceEquipped((LivingEntity) entity) ||
                !CharmHelper.charmCombinationBotanicBlessingAndFeatheredGraceEnabled((LivingEntity) entity)) return;


        ci.cancel();

    }

}
