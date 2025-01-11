package net.masik.mythiccharms.mixin;

import net.masik.mythiccharms.particle.ModParticles;
import net.masik.mythiccharms.util.CharmHelper;
import net.masik.mythiccharms.util.ParticleHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(method = "afterBreak", at = @At("RETURN"))
    private void earthsOrderEffectParticle(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack tool, CallbackInfo ci) {

        if (!CharmHelper.charmEarthsOrderEquipped(player)) return;


        if (player.getMainHandStack().isDamageable()) return;

        //PARTICLE
        Random random = Random.create();

        if (random.nextInt(10) < 5) {
            ParticleHelper.spawnParticle(player, ModParticles.EARTHS_ORDER_EFFECT_PARTICLE,
                    pos.getX() + 0.5F + (double) random.nextBetween(-1, 1) / 10,
                    pos.getY() + 0.5F + (double) random.nextBetween(-1, 1) / 10,
                    pos.getZ() + 0.5F + (double) random.nextBetween(-1, 1) / 10,
                    random.nextBetween(1, 3), 0.2, 0.2, 0.2, 0.03);
        }

    }

    @Inject(method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;", at = @At("RETURN"), cancellable = true)
    private static void earthOrderAndBlazingEmbraceEffect(BlockState state, ServerWorld world, BlockPos pos, BlockEntity blockEntity, Entity entity, ItemStack stack, CallbackInfoReturnable<List<ItemStack>> cir) {

        if (entity == null) return;

        if (!entity.isPlayer()) return;


        if (!CharmHelper.charmEarthsOrderEquipped((LivingEntity) entity) ||
                !CharmHelper.charmBlazingEmbraceEquipped((LivingEntity) entity) ||
                !CharmHelper.charmCombinationEarthsOrderAndBlazingEmbraceEnabled((LivingEntity) entity)) return;


        if (((LivingEntity) entity).getMainHandStack().isDamageable()) return;

        List<ItemStack> itemStacks = new ArrayList<>();

        for (ItemStack item : cir.getReturnValue()) {

            Optional<SmeltingRecipe> recipe = world.getRecipeManager().getFirstMatch(RecipeType.SMELTING, new SimpleInventory(item), world);

            itemStacks.add(recipe.isPresent() ? recipe.get().getOutput(world.getRegistryManager()): item);

        }

        cir.setReturnValue(itemStacks);

    }

    @Inject(method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;", at = @At("RETURN"), cancellable = true)
    private static void botanicBlessingEffectDrop(BlockState state, ServerWorld world, BlockPos pos, BlockEntity blockEntity, Entity entity, ItemStack stack, CallbackInfoReturnable<List<ItemStack>> cir) {

        if (entity == null) return;

        if (!entity.isPlayer()) return;


        if (!CharmHelper.charmBotanicBlessingEquipped((LivingEntity) entity)) return;


        if (!(state.getBlock() instanceof CropBlock)) return;

        Random random = Random.create();

        List<ItemStack> itemStacks = cir.getReturnValue();

        itemStacks.forEach(itemStack -> itemStack.increment(random.nextBetween(0,2)));

        cir.setReturnValue(itemStacks);

    }

}