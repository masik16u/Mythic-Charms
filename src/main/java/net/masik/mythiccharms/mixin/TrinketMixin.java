package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.util.CharmHelper;
import net.masik.mythiccharms.util.SoundHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mixin(Trinket.class)
public interface TrinketMixin {
    @Inject(method = "onEquip", at = @At("RETURN"))
    private void onEquipCharm(ItemStack stack, SlotReference slot, LivingEntity entity, CallbackInfo ci) {

        if (stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "fragile_charms")))) {

            entity.damage(entity.getDamageSources().magic(), 2);

            SoundHelper.playSoundAtEntity(entity, SoundEvents.BLOCK_TUFF_BREAK, 40F);

            if (checkCombo(entity)) {
                SoundHelper.playSoundAtEntity(entity, SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE, 40F);
            }

        }
        if (stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "unbreakable_charms")))) {

            entity.damage(entity.getDamageSources().magic(), 1);

            SoundHelper.playSoundAtEntity(entity, SoundEvents.BLOCK_DEEPSLATE_BREAK, 40F);

            if (checkCombo(entity)) {
                SoundHelper.playSoundAtEntity(entity, SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE, 40F);
            }

        }
    }

    @Inject(method = "onUnequip", at = @At("RETURN"))
    private void onUnequipCharm(ItemStack stack, SlotReference slot, LivingEntity entity, CallbackInfo ci) {

        if (stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "fragile_charms")))) {

            entity.damage(entity.getDamageSources().magic(), 2);

            SoundHelper.playSoundAtEntity(entity, SoundEvents.BLOCK_TUFF_BREAK, 40F);

        }
        if (stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "unbreakable_charms")))) {

            entity.damage(entity.getDamageSources().magic(), 1);

            SoundHelper.playSoundAtEntity(entity, SoundEvents.BLOCK_DEEPSLATE_BREAK, 40F);

        }
    }

    private boolean checkCombo(LivingEntity entity) {
        Set<String> charmsEquipped = new HashSet<>();

        for (Pair<SlotReference, ItemStack> slotReferenceItemStackPair : TrinketsApi.getTrinketComponent(entity).get().getAllEquipped()) {
            String charm = slotReferenceItemStackPair.getRight().toString();
            charmsEquipped.add(charm.substring(charm.indexOf("of_") + 3));
        }

        for (Set<String> stringSet : CharmHelper.combinations) {
            if (charmsEquipped.containsAll(stringSet)) return true;
        }

        return false;
    }
}
