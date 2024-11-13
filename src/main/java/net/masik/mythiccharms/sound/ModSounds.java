package net.masik.mythiccharms.sound;

import net.masik.mythiccharms.MythicCharms;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent MUSIC_DISC_RESONANCE = registerSoundEvent("music_disc.resonance");
    public static final SoundEvent MUSIC_DISC_MYTH = registerSoundEvent("music_disc.myth");

    private static SoundEvent registerSoundEvent(String name) {

        Identifier id = new Identifier(MythicCharms.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));

    }

}
