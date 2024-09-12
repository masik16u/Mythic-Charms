package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.particle.ModParticles;
import net.masik.mythiccharms.util.CharmHelper;
import net.masik.mythiccharms.util.ParticleHelper;
import net.masik.mythiccharms.util.SoundHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.*;

@Mixin(Trinket.class)
public interface TrinketMixin {
    @Inject(method = "onEquip", at = @At("RETURN"))
    private void onEquipCharm(ItemStack stack, SlotReference slot, LivingEntity entity, CallbackInfo ci) {

        if (!stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier("trinkets:mythic_charm/mythic_charm")))) return;

        if (stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "fragile_charms")))) {

            dealDamage(entity, 2, SoundEvents.BLOCK_TUFF_BREAK);

            summonParticles(entity, stack);

            checkCombo(entity);

        }
        if (stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "unbreakable_charms")))) {

            dealDamage(entity, 1, SoundEvents.BLOCK_DEEPSLATE_BREAK);

            summonParticles(entity, stack);

            checkCombo(entity);

        }
    }

    @Inject(method = "onUnequip", at = @At("RETURN"))
    private void onUnequipCharm(ItemStack stack, SlotReference slot, LivingEntity entity, CallbackInfo ci) {

        if (!stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier("trinkets:mythic_charm/mythic_charm")))) return;

        if (stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "fragile_charms")))) {

            dealDamage(entity, 2, SoundEvents.BLOCK_TUFF_BREAK);

        }
        if (stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "unbreakable_charms")))) {

            dealDamage(entity, 1, SoundEvents.BLOCK_DEEPSLATE_BREAK);

        }
    }



    @Unique
    private void summonParticles(LivingEntity entity, ItemStack stack) {

        if (!entity.isPlayer()) return;

        PlayerEntity player = (PlayerEntity) entity;

        String charmName = stack.toString();

        ParticleHelper.spawnParticle(player,
                CharmHelper.PARTICLES.get(charmName.substring(charmName.indexOf("of_") + 3)),
                player.getX() + Math.sin(Math.toRadians(player.getYaw() + 180)) * -0.5F,
                player.getY() + 1.5F,
                player.getZ() + Math.cos(Math.toRadians(player.getYaw() + 180)) * 0.5F,
                1, 0, 0, 0, 0);

    }

    @Unique
    private void dealDamage(LivingEntity entity, int amount, SoundEvent soundEvent) {

        entity.damage(entity.getDamageSources().magic(), amount);

        SoundHelper.playSoundAtEntity(entity, soundEvent, 40F);

    }

    @Unique
    private void checkCombo(LivingEntity entity) {

        Set<String> charmsEquipped = new HashSet<>();

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);

        if (trinket.isEmpty()) return;

        for (Pair<SlotReference, ItemStack> slotReferenceItemStackPair : trinket.get().getAllEquipped()) {

            String charmName = slotReferenceItemStackPair.getRight().toString();

            charmsEquipped.add(charmName.substring(charmName.indexOf("of_") + 3));

        }

        for (Set<String> stringSet : CharmHelper.COMBINATIONS) {

            if (charmsEquipped.containsAll(stringSet)) {

                SoundHelper.playSoundAtEntity(entity, SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE, 40F);

            }

        }
    }

}
