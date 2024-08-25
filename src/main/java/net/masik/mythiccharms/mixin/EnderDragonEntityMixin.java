package net.masik.mythiccharms.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.masik.mythiccharms.util.CharmHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Iterator;

@Mixin(EnderDragonEntity.class)
public class EnderDragonEntityMixin {

    @WrapOperation(method = "launchLivingEntities", at = @At(value = "INVOKE", target = "Ljava/util/Iterator;next()Ljava/lang/Object;"))
    private Object mountainsStrengthEffectDragon(Iterator instance, Operation<Object> original) {

        Entity entity = (Entity) instance.next();

        if (!entity.isPlayer()) return original.call(instance);

        if (!CharmHelper.charmMountainsStrengthEquipped((LivingEntity) entity)) return original.call(instance);

        return null;

    }

}
