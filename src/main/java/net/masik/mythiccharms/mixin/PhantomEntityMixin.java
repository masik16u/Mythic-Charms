package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PhantomEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Optional;

@Mixin(PhantomEntity.class)
public class PhantomEntityMixin {

    @Inject(method = "canTarget", at = @At("RETURN"), cancellable = true)
    private void nightsGuardianEffect(EntityType<?> type, CallbackInfoReturnable<Boolean> cir) {

        PhantomEntity phantomEntity = (PhantomEntity) (Object) this;

        LivingEntity phantomTarget = phantomEntity.getTarget();

        if (phantomTarget == null) return;

        if (!phantomTarget.isPlayer()) return;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(phantomTarget);

        if (trinket.isEmpty() || (!trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_NIGHTS_GUARDIAN) &&
                !trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_NIGHTS_GUARDIAN))) {
            return;
        }

        cir.setReturnValue(false);

    }

}
