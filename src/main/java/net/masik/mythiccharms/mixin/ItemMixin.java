package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.loader.api.FabricLoader;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.block.ModBlocks;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(Item.class)
public class ItemMixin {

    @Inject(method = "useOnBlock", at = @At("RETURN"))
    private void useOnResonanceTable(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        if (context.getPlayer() == null) return;
        PlayerEntity player = context.getPlayer();

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(player);
        if (trinket.isEmpty() || !trinket.get().isEquipped(ModItems.RESONANCE_RING)) return;

        BlockPos blockPos = context.getBlockPos();
        World world = context.getWorld();

        if (!world.getBlockState(blockPos).getBlock().equals(ModBlocks.RESONANCE_TABLE)) return;

        if (!context.getStack().isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "resonance_ingredients"))))
            return;

        ItemEntity itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1, blockPos.getZ() + 0.5,
                context.getStack().getItem().getDefaultStack());
        itemEntity.setVelocity(0, 0, 0);
        itemEntity.setPickupDelay(120);
        world.spawnEntity(itemEntity);

        context.getStack().decrement(1);
        player.swingHand(context.getHand());
        MythicCharms.LOGGER.info(String.valueOf(FabricLoader.getInstance().getGameDir()));
    }

}
