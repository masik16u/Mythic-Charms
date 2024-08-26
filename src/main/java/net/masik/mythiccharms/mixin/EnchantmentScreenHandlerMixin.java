package net.masik.mythiccharms.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.EnchantmentScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;

@Mixin(EnchantmentScreenHandler.class)
public class EnchantmentScreenHandlerMixin{

    @SuppressWarnings("unchecked")
    @Inject(method = "generateEnchantments", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"), cancellable = true)
    private void enchantedWhispersEffect(ItemStack stack, int slot, int level, CallbackInfoReturnable<List<EnchantmentLevelEntry>> cir, @Local List list) {

        cir.setReturnValue(list);

    }

}
