package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PhantomEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(PhantomEntity.class)
public class PhantomEntityMixin {

    @Inject(method = "canTarget", at = @At("RETURN"), cancellable = true)
    private void nightsGuardianEffect(EntityType<?> type, CallbackInfoReturnable<Boolean> cir) {

        PhantomEntity phantomEntity = (PhantomEntity) (Object) this;

        if (phantomEntity.getTarget() != null) {

            if (TrinketsApi.getTrinketComponent(phantomEntity.getTarget()).get().isEquipped(ModItems.FRAGILE_CHARM_OF_NIGHTS_GUARDIAN) ||
                    TrinketsApi.getTrinketComponent(phantomEntity.getTarget()).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_NIGHTS_GUARDIAN)) {

                cir.setReturnValue(false);

            }

        }

    }

}
