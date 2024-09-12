package net.masik.mythiccharms;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.masik.mythiccharms.particle.ModParticles;
import net.masik.mythiccharms.particle.custom.CharmEffectParticle;
import net.masik.mythiccharms.particle.custom.CharmEquipParticle;

public class MythicCharmsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ParticleFactoryRegistry.getInstance().register(ModParticles.FEATHERED_GRACE_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLAZING_EMBRACE_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.EARTHS_ORDER_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.GAZE_SERENITY_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BOTANIC_BLESSING_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.FLEETING_STRIDES_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.NIGHTS_GUARDIAN_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.HIGH_BOUNDS_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.DROWNED_FREEDOM_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.WEIGHTLESS_FLOW_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.COLLECTORS_GIFT_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.CLIMBERS_PATH_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.NATURES_CALL_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BARTERS_PACT_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BATTLE_FURY_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.ECHOING_WRATH_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.ENCHANTED_WHISPERS_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.ARROW_DANCE_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.MOUNTAINS_STRENGTH_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.SAFE_TERRITORY_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.QUIET_PRESENCE_EQUIP_PARTICLE, CharmEquipParticle.Factory::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.FEATHERED_GRACE_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLAZING_EMBRACE_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.EARTHS_ORDER_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.GAZE_SERENITY_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BOTANIC_BLESSING_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.FLEETING_STRIDES_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.NIGHTS_GUARDIAN_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.HIGH_BOUNDS_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.DROWNED_FREEDOM_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.WEIGHTLESS_FLOW_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.COLLECTORS_GIFT_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.CLIMBERS_PATH_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.NATURES_CALL_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BARTERS_PACT_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BATTLE_FURY_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.ECHOING_WRATH_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.ENCHANTED_WHISPERS_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.ARROW_DANCE_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.MOUNTAINS_STRENGTH_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.SAFE_TERRITORY_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.QUIET_PRESENCE_EFFECT_PARTICLE, CharmEffectParticle.Factory::new);

    }
}
