package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;", at = @At("RETURN"), cancellable = true)
    private static void earthOrderAndBlazingEmbraceEffect(BlockState state, ServerWorld world, BlockPos pos, BlockEntity blockEntity, Entity entity, ItemStack stack, CallbackInfoReturnable<List<ItemStack>> cir) {

        if (entity == null) return;

        if (!entity.isPlayer()) return;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent((LivingEntity) entity);

        if (trinket.isEmpty() || (!trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_EARTHS_ORDER) &&
                !trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_EARTHS_ORDER))) {
            return;
        }

        if (!trinket.get().isEquipped(ModItems.FRAGILE_CHARM_OF_BLAZING_EMBRACE) &&
                !trinket.get().isEquipped(ModItems.UNBREAKABLE_CHARM_OF_BLAZING_EMBRACE)) {
            return;
        }

        if (!((LivingEntity) entity).getMainHandStack().isOf(Items.AIR)) return;

        List<ItemStack> itemStacks = new ArrayList<>();

        for (ItemStack item : cir.getReturnValue()) {

            Optional<RecipeEntry<SmeltingRecipe>> recipe = world.getRecipeManager().getFirstMatch(RecipeType.SMELTING, new SimpleInventory(item), world);

            itemStacks.add(recipe.isPresent() ? recipe.get().value().getResult(world.getRegistryManager()) : item);

        }

        cir.setReturnValue(itemStacks);

    }

}
