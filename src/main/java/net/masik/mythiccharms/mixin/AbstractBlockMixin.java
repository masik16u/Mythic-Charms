package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.block.ModBlocks;
import net.masik.mythiccharms.item.ModItems;
import net.masik.mythiccharms.particle.ModParticles;
import net.masik.mythiccharms.util.CharmHelper;
import net.masik.mythiccharms.util.ParticleHelper;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(AbstractBlock.class)
public class AbstractBlockMixin {

    @Inject(method = "onUse", at = @At("HEAD"), cancellable = true)
    private void useOnResonanceTable(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
        if (player == null) return;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(player);
        if (trinket.isEmpty() || !trinket.get().isEquipped(ModItems.RESONANCE_RING)) return;

        BlockPos blockPos = hit.getBlockPos();

        if (!world.getBlockState(blockPos).getBlock().equals(ModBlocks.RESONANCE_TABLE)) return;

        ItemStack itemStack = player.getStackInHand(hand).copy();
        itemStack.setCount(1);

        if (!itemStack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "resonance_ingredients")))) return;

        ItemEntity itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1, blockPos.getZ() + 0.5,
                itemStack);
        itemEntity.setVelocity(0,0,0);
        itemEntity.setPickupDelay(60);
        world.spawnEntity(itemEntity);

        if (!player.getAbilities().creativeMode) player.getStackInHand(hand).decrement(1);
        cir.setReturnValue(ActionResult.SUCCESS);
    }

}
