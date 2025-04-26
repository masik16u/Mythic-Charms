package net.masik.mythiccharms.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.masik.mythiccharms.util.CharmHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(EnderDragonEntity.class)
public class EnderDragonEntityMixin {

    // disable knockback of the dragon for MS
    @WrapWithCondition(method = "launchLivingEntities", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;addVelocity(DDD)V"))
    private boolean mountainsStrengthEffectDragon(Entity entity, double deltaX, double deltaY, double deltaZ) {

        if (!entity.isPlayer()) return true;

        if (!CharmHelper.charmMountainsStrengthEquipped((LivingEntity) entity)) return true;

        return false;
    }

}
