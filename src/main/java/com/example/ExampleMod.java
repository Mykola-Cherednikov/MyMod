package com.example;

import com.example.elements.blocks.AntonBlock;
import com.example.elements.items.Hammer;
import com.example.register.sounds.SoundRegister;
import com.example.registrating.blocks.RegistratingAllBlocks;
import com.example.registrating.items.RegistratingAllItems;
import com.example.registrating.sounds.RegistratingAllSounds;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
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
		RegistratingAllBlocks.registerAllBlocks();
		RegistratingAllSounds.registerAllSounds();
		RegistratingAllItems.registerAllItems();

		PlayerBlockBreakEvents.BEFORE.register((world, player, blockPos, blockState, blockEntity) -> {
			BlockState state = world.getBlockState(blockPos);

				ItemStack item = player.getMainHandStack();

				if (item.getItem() instanceof Hammer) {
					Hammer h = (Hammer) item.getItem();
					h.Mine(item, world, blockState, blockPos, player);
				}

				return true;
		});

		LOGGER.info("Hello Fabric world!");

	}
}