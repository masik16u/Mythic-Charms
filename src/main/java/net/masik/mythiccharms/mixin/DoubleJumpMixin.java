package net.masik.mythiccharms.mixin;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.masik.mythiccharms.MythicCharms;
import net.minecraft.client.network.ClientPlayerEntity;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public abstract class DoubleJumpMixin {
    /*private int jumpCount = 0;
    private boolean jumpedLastTick = false;

    @Inject(method = "tickMovement", at = @At("HEAD"))
    private void tickMovement(CallbackInfo info) {
        ClientPlayerEntity player = (ClientPlayerEntity) (Object) this;
        if (player.isOnGround() || player.isClimbing()) {
            jumpCount = 1;
        } else if (!jumpedLastTick && jumpCount > 0 && player.getVelocity().y < 0 && hasIron(player)) {
            if (player.input.jumping && !player.getAbilities().flying) {
                if (canJump(player)) {
                    --jumpCount;
                    player.jump();

                    DoubleJumpEffect.play(player);

                    PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
                    passedData.writeUuid(player.getUuid());

                    ClientPlayNetworking.send(MythicCharms.C2S_DO_DOUBLEJUMP, passedData);
                }
            }
        }
        jumpedLastTick = player.input.jumping;
    }

    private boolean wearingUsableElytra(ClientPlayerEntity player) {
        ItemStack chestItemStack = player.getEquippedStack(EquipmentSlot.CHEST);
        return chestItemStack.getItem() == Items.ELYTRA && ElytraItem.isUsable(chestItemStack);
    }

    private boolean hasIron(ClientPlayerEntity player) {
        return player.getInventory().main.stream().anyMatch(stack -> stack.isOf(Items.IRON_INGOT));
    }

    private boolean canJump(ClientPlayerEntity player) {
        return !wearingUsableElytra(player) && !player.isFallFlying() && !player.hasVehicle()
                && !player.isTouchingWater() && !player.hasStatusEffect(StatusEffects.LEVITATION);
    }*/
}
