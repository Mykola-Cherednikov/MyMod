package com.example;

import com.example.elements.blocks.AntonBlock;
import com.example.register.sounds.SoundRegister;
import com.example.registrating.blocks.RegistratingAllBlocks;
import com.example.registrating.sounds.RegistratingAllSounds;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitialize() {
		RegistratingAllSounds.registerAllSounds();
		RegistratingAllBlocks.registerAllBlocks();
		LOGGER.info("Hello Fabric world!");
	}
}