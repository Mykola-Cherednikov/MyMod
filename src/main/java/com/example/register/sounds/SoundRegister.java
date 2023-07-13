package com.example.register.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class SoundRegister {
    public static SoundEvent registerSound(String id, SoundEvent soundEvent){
        return Registry.register(Registries.SOUND_EVENT, new Identifier("modid", id), soundEvent);
    }
}
