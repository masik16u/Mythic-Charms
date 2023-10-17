package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.MythicCharms;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerMixin {

    private int ticksInAir = 0;
    private boolean isOnFire = false;

    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo info){
        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;

        if (TrinketsApi.getTrinketComponent(player).get().isEquipped(Items.IRON_INGOT)) {
            if (!player.isOnGround() && !player.isClimbing() && !player.isInsideWaterOrBubbleColumn() && !player.isFallFlying() && player.getVelocity().y < 0) {
                ticksInAir += 1;
            } else {
                ticksInAir = 0;
            }

            if (ticksInAir >= 8 && ticksInAir < 60 && !player.isSneaking()) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 4, 0, false, false, false));
            }
        }

        if (TrinketsApi.getTrinketComponent(player).get().isEquipped(Items.GOLD_INGOT)) {
            if (player.isOnFire() && !isOnFire) {
                isOnFire = true;
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 410, 0, false, false, true));
            }
            if (!player.isOnFire()) {
                isOnFire = false;
            }
        }

        player.removeStatusEffect(StatusEffects.SLOWNESS);

    }

    /*private List<ItemStack> getCharms(LivingEntity player, Item charm) {
        List<ItemStack> list = new ArrayList<>();

        if (TrinketsApi.getTrinketComponent(player).isPresent()) {
            List<Pair<SlotReference, ItemStack>> slots = TrinketsApi.getTrinketComponent(player).get().getEquipped(charm);
            slots.forEach(slot -> list.add(slot.getRight()));
        }
        return list;
    }*/

    private boolean wearingUsableElytra(ServerPlayerEntity player) {
        ItemStack chestItemStack = player.getEquippedStack(EquipmentSlot.CHEST);
        return chestItemStack.getItem() == Items.ELYTRA && ElytraItem.isUsable(chestItemStack);
    }

}
