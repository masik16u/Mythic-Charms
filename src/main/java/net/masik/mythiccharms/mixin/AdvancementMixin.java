package net.masik.mythiccharms.mixin;

import net.masik.mythiccharms.MythicCharms;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Advancement.class)
public class AdvancementMixin {

    // mixin to add the ability to disable charmicon on join
    @Inject(method = "getRewards", at = @At("RETURN"), cancellable = true)
    private void cancelReward(CallbackInfoReturnable<AdvancementRewards> cir) {

        Advancement advancement = (Advancement) (Object) this;

        if (advancement.getId().equals(new Identifier(MythicCharms.MOD_ID, "book/grant_book_on_first_join"))) {

            if (!MythicCharms.CONFIG.giveCharmiconOnSpawn()) cir.setReturnValue(AdvancementRewards.NONE);

        }

    }

}
