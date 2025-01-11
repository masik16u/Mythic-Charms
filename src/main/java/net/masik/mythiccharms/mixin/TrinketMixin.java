package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.item.ModItems;
import net.masik.mythiccharms.util.AdvancementsHelper;
import net.masik.mythiccharms.util.CharmHelper;
import net.masik.mythiccharms.util.ParticleHelper;
import net.masik.mythiccharms.util.SoundHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.*;

@Mixin(Trinket.class)
public interface TrinketMixin {

    // Runs when trinket is equipped
    @Inject(method = "onEquip", at = @At("RETURN"))
    private void onEquipCharm(ItemStack stack, SlotReference slot, LivingEntity entity, CallbackInfo ci) {

        // Check if equipped trinket is a Mythic Charm
        if (!stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier("trinkets:mythic_charm/mythic_charm")))) return;

        // Check if charm is fragile
        if (stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "fragile_charms")))) {

            dealDamage(entity, doesResonanceRingNullifyDamage(entity) ? 0 : 2, SoundEvents.BLOCK_TUFF_BREAK);

            summonParticles(entity, stack);

            checkCombo(entity);

        }
        // Else if charm is unbreakable
        else if (stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "unbreakable_charms")))) {

            dealDamage(entity, 0, SoundEvents.BLOCK_DEEPSLATE_BREAK);

            summonParticles(entity, stack);

            checkCombo(entity);

        }
    }

    // Runs when trinket is unequipped
    @Inject(method = "onUnequip", at = @At("RETURN"))
    private void onUnequipCharm(ItemStack stack, SlotReference slot, LivingEntity entity, CallbackInfo ci) {

        // Check if unequipped trinket is a Mythic Charm
        if (!stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier("trinkets:mythic_charm/mythic_charm")))) return;

        // Check if charm is fragile
        if (stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "fragile_charms")))) {

            dealDamage(entity, doesResonanceRingNullifyDamage(entity) ? 0 : 2, SoundEvents.BLOCK_TUFF_BREAK);

        }
        // Else if charm is unbreakable
        else if (stack.isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "unbreakable_charms")))) {

            dealDamage(entity, 0, SoundEvents.BLOCK_DEEPSLATE_BREAK);

        }
    }


    @Unique
    private boolean doesResonanceRingNullifyDamage(LivingEntity entity) {

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);

        if (trinket.isEmpty() || !trinket.get().isEquipped(ModItems.RESONANCE_RING)) return false;

        Random random = Random.create();

        return random.nextFloat() < 0.3F;

    }

    /**
     * Summons a charm particle behind a player
     *
     * @param entity Targeted player
     * @param stack Charm ItemStack that will be used to get particle
     */
    @Unique
    private void summonParticles(LivingEntity entity, ItemStack stack) {

        if (!entity.isPlayer()) return;

        PlayerEntity player = (PlayerEntity) entity;

        // Get charm item name from an item stack
        String charmName = stack.toString();

        // Summon particle on player's back fading outwards
        ParticleHelper.spawnParticle(player,
                CharmHelper.PARTICLES.get(charmName.substring(charmName.indexOf("of_") + 3)),
                player.getX() + Math.sin(Math.toRadians(player.getYaw() + 180)) * -0.5F,
                player.getY() + 1.5F,
                player.getZ() + Math.cos(Math.toRadians(player.getYaw() + 180)) * 0.5F,
                1, 0, 0, 0, 0);

    }

    /**
     * Deal damage to an entity with a following sound
     *
     * @param entity Targeted entity
     * @param amount Amount of damage dealt to entity
     * @param soundEvent Sound event played after dealing damage
     */
    @Unique
    private void dealDamage(LivingEntity entity, float amount, SoundEvent soundEvent) {

        entity.damage(entity.getDamageSources().magic(), amount);

        SoundHelper.playSoundAtEntity(entity, soundEvent, 40F);

    }

    /**
     * Check if entity has any charm combinations equipped
     *
     * @param entity Targeted entity
     */
    @Unique
    private void checkCombo(LivingEntity entity) {

        // Create empty string set with all charms equipped
        Set<String> charmsEquipped = new HashSet<>();

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(entity);

        if (trinket.isEmpty()) return;

        // Go through all trinkets equipped
        for (Pair<SlotReference, ItemStack> slotReferenceItemStackPair : trinket.get().getAllEquipped()) {

            // Get charm item name
            String charmName = slotReferenceItemStackPair.getRight().toString();

            // Add charm's name to created set
            charmsEquipped.add(charmName.substring(charmName.indexOf("of_") + 3));

        }

        // Go through possible combinations
        for (Set<String> stringSet : CharmHelper.COMBINATIONS) {

            // If set contains current combination
            if (charmsEquipped.containsAll(stringSet)) {

                SoundHelper.playSoundAtEntity(entity, SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE, 40F);

                // Give advancement
                AdvancementsHelper.grantAdvancement(entity, new Identifier(MythicCharms.MOD_ID, "story/equip_combination"));

            }

        }
    }

}
