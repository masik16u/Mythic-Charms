package net.masik.mythiccharms;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.lwjgl.glfw.GLFW;

public class DJump {
    public static final String KEY_DOUBLE_JUMP = "key.mythic_charms.double_jump";

    public static KeyBinding doubleJumpKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(doubleJumpKey.wasPressed()) {
                client.player.jump();
            }
        });
    }

    public boolean wue(ClientPlayerEntity player) {
        return player.getInventory().armor.stream().anyMatch(stack -> stack.isOf(Items.ELYTRA)) && ElytraItem.isUsable(player.getEquippedStack(EquipmentSlot.CHEST));
    }

    public static void register() {
        doubleJumpKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_DOUBLE_JUMP,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_SPACE,
                KeyBinding.MOVEMENT_CATEGORY
        ));
        registerKeyInputs();
    }

}
