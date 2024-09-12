package net.masik.mythiccharms.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.masik.mythiccharms.MythicCharms;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {

    public static final DefaultParticleType FEATHERED_GRACE_EQUIP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType BLAZING_EMBRACE_EQUIP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType EARTHS_ORDER_EQUIP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType GAZE_SERENITY_EQUIP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType BOTANIC_BLESSING_EQUIP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType FLEETING_STRIDES_EQUIP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType NIGHTS_GUARDIAN_EQUIP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType HIGH_BOUNDS_EQUIP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType DROWNED_FREEDOM_EQUIP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType WEIGHTLESS_FLOW_EQUIP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType COLLECTORS_GIFT_EQUIP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType CLIMBERS_PATH_EQUIP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType NATURES_CALL_EQUIP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType BARTERS_PACT_EQUIP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType BATTLE_FURY_EQUIP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType ECHOING_WRATH_EQUIP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType ENCHANTED_WHISPERS_EQUIP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType ARROW_DANCE_EQUIP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType MOUNTAINS_STRENGTH_EQUIP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType SAFE_TERRITORY_EQUIP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType QUIET_PRESENCE_EQUIP_PARTICLE = FabricParticleTypes.simple();

    public static final DefaultParticleType FEATHERED_GRACE_EFFECT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType BLAZING_EMBRACE_EFFECT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType EARTHS_ORDER_EFFECT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType GAZE_SERENITY_EFFECT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType BOTANIC_BLESSING_EFFECT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType FLEETING_STRIDES_EFFECT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType NIGHTS_GUARDIAN_EFFECT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType HIGH_BOUNDS_EFFECT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType DROWNED_FREEDOM_EFFECT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType WEIGHTLESS_FLOW_EFFECT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType COLLECTORS_GIFT_EFFECT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType CLIMBERS_PATH_EFFECT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType NATURES_CALL_EFFECT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType BARTERS_PACT_EFFECT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType BATTLE_FURY_EFFECT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType ECHOING_WRATH_EFFECT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType ENCHANTED_WHISPERS_EFFECT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType ARROW_DANCE_EFFECT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType MOUNTAINS_STRENGTH_EFFECT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType SAFE_TERRITORY_EFFECT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType QUIET_PRESENCE_EFFECT_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {

        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "feathered_grace_equip"), FEATHERED_GRACE_EQUIP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "blazing_embrace_equip"), BLAZING_EMBRACE_EQUIP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "earths_order_equip"), EARTHS_ORDER_EQUIP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "gaze_serenity_equip"), GAZE_SERENITY_EQUIP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "botanic_blessing_equip"), BOTANIC_BLESSING_EQUIP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "fleeting_strides_equip"), FLEETING_STRIDES_EQUIP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "nights_guardian_equip"), NIGHTS_GUARDIAN_EQUIP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "high_bounds_equip"), HIGH_BOUNDS_EQUIP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "drowned_freedom_equip"), DROWNED_FREEDOM_EQUIP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "weightless_flow_equip"), WEIGHTLESS_FLOW_EQUIP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "collectors_gift_equip"), COLLECTORS_GIFT_EQUIP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "climbers_path_equip"), CLIMBERS_PATH_EQUIP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "natures_call_equip"), NATURES_CALL_EQUIP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "barters_pact_equip"), BARTERS_PACT_EQUIP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "battle_fury_equip"), BATTLE_FURY_EQUIP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "echoing_wrath_equip"), ECHOING_WRATH_EQUIP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "enchanted_whispers_equip"), ENCHANTED_WHISPERS_EQUIP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "arrow_dance_equip"), ARROW_DANCE_EQUIP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "mountains_strength_equip"), MOUNTAINS_STRENGTH_EQUIP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "safe_territory_equip"), SAFE_TERRITORY_EQUIP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "quiet_presence_equip"), QUIET_PRESENCE_EQUIP_PARTICLE);

        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "feathered_grace_effect"), FEATHERED_GRACE_EFFECT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "blazing_embrace_effect"), BLAZING_EMBRACE_EFFECT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "earths_order_effect"), EARTHS_ORDER_EFFECT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "gaze_serenity_effect"), GAZE_SERENITY_EFFECT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "botanic_blessing_effect"), BOTANIC_BLESSING_EFFECT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "fleeting_strides_effect"), FLEETING_STRIDES_EFFECT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "nights_guardian_effect"), NIGHTS_GUARDIAN_EFFECT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "high_bounds_effect"), HIGH_BOUNDS_EFFECT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "drowned_freedom_effect"), DROWNED_FREEDOM_EFFECT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "weightless_flow_effect"), WEIGHTLESS_FLOW_EFFECT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "collectors_gift_effect"), COLLECTORS_GIFT_EFFECT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "climbers_path_effect"), CLIMBERS_PATH_EFFECT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "natures_call_effect"), NATURES_CALL_EFFECT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "barters_pact_effect"), BARTERS_PACT_EFFECT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "battle_fury_effect"), BATTLE_FURY_EFFECT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "echoing_wrath_effect"), ECHOING_WRATH_EFFECT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "enchanted_whispers_effect"), ENCHANTED_WHISPERS_EFFECT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "arrow_dance_effect"), ARROW_DANCE_EFFECT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "mountains_strength_effect"), MOUNTAINS_STRENGTH_EFFECT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "safe_territory_effect"), SAFE_TERRITORY_EFFECT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MythicCharms.MOD_ID, "quiet_presence_effect"), QUIET_PRESENCE_EFFECT_PARTICLE);

    }
}
