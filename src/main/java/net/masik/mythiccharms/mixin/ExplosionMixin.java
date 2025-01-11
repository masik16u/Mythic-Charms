package net.masik.mythiccharms.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.masik.mythiccharms.util.CharmHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Explosion.class)
public class ExplosionMixin {

//    @ModifyArg(method = "collectBlocksAndDamageEntities", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/Vec3d;add(Lnet/minecraft/util/math/Vec3d;)Lnet/minecraft/util/math/Vec3d;"), index = 0)
//    private Vec3d mountainsStrengthEffectExplosion(Vec3d vec, @Local Entity entity) {
//
//        if (!entity.isPlayer()) return(vec);
//
//
//        if (!CharmHelper.charmMountainsStrengthEquipped((LivingEntity) entity)) return(vec);
//
//
//        return Vec3d.ZERO;
//
//    }

    @WrapWithCondition(method = "collectBlocksAndDamageEntities", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;setVelocity(Lnet/minecraft/util/math/Vec3d;)V"))
    private boolean mountainsStrengthEffectExplosion(Entity entity, Vec3d velocity) {

        if (!entity.isPlayer()) return true;

        return !CharmHelper.charmMountainsStrengthEquipped((LivingEntity) entity);

    }

}
