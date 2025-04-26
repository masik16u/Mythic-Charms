package net.masik.mythiccharms.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.masik.mythiccharms.util.CharmHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FarmlandBlock.class)
public class FarmlandBlockMixin {

//    @Inject(method = "onLandedUpon", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/FarmlandBlock;setToDirt(Lnet/minecraft/entity/Entity;Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)V"), cancellable = true)
//    private void botanicBlessingAndFeatheredGraceEffect(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance, CallbackInfo ci) {
//
//
//        if (!CharmHelper.charmBotanicBlessingEquipped((LivingEntity) entity) ||
//                !CharmHelper.charmFeatheredGraceEquipped((LivingEntity) entity) ||
//                !CharmHelper.charmCombinationBotanicBlessingAndFeatheredGraceEnabled((LivingEntity) entity)) return;
//
//
//        ci.cancel();
//
//    }

    // don't trample the farmland for BB & FG
    @WrapWithCondition(method = "onLandedUpon", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/FarmlandBlock;setToDirt(Lnet/minecraft/entity/Entity;Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)V"))
    private boolean botanicBlessingAndFeatheredGraceEffect(Entity entity, BlockState state, World world, BlockPos pos) {

        if (!entity.isPlayer()) return true;

        if (!CharmHelper.charmBotanicBlessingEquipped((LivingEntity) entity) ||
                !CharmHelper.charmFeatheredGraceEquipped((LivingEntity) entity) ||
                !CharmHelper.charmCombinationBotanicBlessingAndFeatheredGraceEnabled((LivingEntity) entity)) return true;

        return false;
    }

}
