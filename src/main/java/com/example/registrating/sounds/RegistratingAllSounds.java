package com.example.registrating.sounds;

import com.example.register.blocks.BlockRegister;
import com.example.register.sounds.SoundRegister;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class RegistratingAllSounds {

    public static SoundEvent ANTON_BLOCK_BREAK_SOUND = SoundEvent.of(new Identifier("modid", "anton_block_break_sound"));

    public static BlockSoundGroup ANTON_SOUND_GROUP = new BlockSoundGroup(1.0F, 1.0F, ANTON_BLOCK_BREAK_SOUND, SoundEvents.BLOCK_STONE_STEP, SoundEvents.BLOCK_STONE_PLACE, SoundEvents.BLOCK_STONE_HIT, SoundEvents.BLOCK_STONE_FALL);

    public static SoundEvent ANTON_BLOCK_USE_SOUND = SoundEvent.of(new Identifier("modid", "anton_block_use_sound"));

    public static void registerAllSounds(){
        SoundRegister.registerSound("anton_block_break_sound", ANTON_BLOCK_BREAK_SOUND);
    }
}
