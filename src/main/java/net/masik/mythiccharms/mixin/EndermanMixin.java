package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EndermanEntity.class)
public class EndermanMixin {

    @Redirect(method = "isPlayerStaring", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;canSee(Lnet/minecraft/entity/Entity;)Z"))
    public boolean isPlayerStaring(PlayerEntity instance, Entity entity) {
        if (!TrinketsApi.getTrinketComponent(instance).get().isEquipped(Items.EMERALD)) return instance.canSee(entity);

        return false;
    }

}
