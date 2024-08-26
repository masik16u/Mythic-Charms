package net.masik.mythiccharms.mixin;

import com.google.common.collect.ImmutableList;
import net.masik.mythiccharms.util.CharmHelper;
import net.minecraft.client.gui.screen.ingame.EnchantmentScreen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.mob.AbstractPiglinEntity;
import net.minecraft.entity.mob.PiglinBruteBrain;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Optional;

@Mixin(PiglinBruteBrain.class)
public class PiglinBruteBrainMixin {

    //change this logic in the future
    @Inject(method = "getTarget", at = @At(value = "RETURN"), cancellable = true)
    private static void bartersPactEffect(AbstractPiglinEntity piglin, CallbackInfoReturnable<Optional<? extends LivingEntity>> cir) {

        Optional<? extends LivingEntity> optional = cir.getReturnValue();

        if (optional.isEmpty()) return;

        List<AbstractPiglinEntity> piglinEntities = piglin.getBrain().getOptionalRegisteredMemory(MemoryModuleType.NEARBY_ADULT_PIGLINS).orElse(ImmutableList.of());

        for (AbstractPiglinEntity abstractPiglinEntity : piglinEntities) {

            if (abstractPiglinEntity.getTarget() == optional.get()) {
                return;
            }

        }

        if (!CharmHelper.charmBartersPactEquipped(optional.get())) return;

        cir.setReturnValue(Optional.empty());

    }

}
