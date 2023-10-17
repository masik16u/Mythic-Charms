package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FarmlandBlock.class)
public class FarmlandBlockMixin {

    @Inject(method = "onLandedUpon", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/FarmlandBlock;setToDirt(Lnet/minecraft/entity/Entity;Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)V"), cancellable = true)
    private void botanicBlessingEffect(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance, CallbackInfo ci) {

        if ((TrinketsApi.getTrinketComponent((LivingEntity) entity).get().isEquipped(ModItems.FRAGILE_CHARM_OF_BOTANIC_BLESSING) ||
                TrinketsApi.getTrinketComponent((LivingEntity) entity).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BOTANIC_BLESSING)) &&
                (TrinketsApi.getTrinketComponent((LivingEntity) entity).get().isEquipped(ModItems.FRAGILE_CHARM_OF_FEATHERED_GRACE) ||
                TrinketsApi.getTrinketComponent((LivingEntity) entity).get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_FEATHERED_GRACE))) {

            ci.cancel();

        }

    }

}
