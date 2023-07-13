package com.example.registrating.blocks;

import com.example.ExampleMod;
import com.example.elements.blocks.AntonBlock;
import com.example.register.blocks.BlockRegister;
import com.example.registrating.sounds.RegistratingAllSounds;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;

public class RegistratingAllBlocks {
    public static final AntonBlock AntonBlock = new AntonBlock(FabricBlockSettings.create().sounds(RegistratingAllSounds.ANTON_SOUND_GROUP));

    public static final Block newBlock = new Block(FabricBlockSettings.create().sounds(RegistratingAllSounds.ANTON_SOUND_GROUP));

    public static void registerAllBlocks(){
        BlockRegister.registerBlock("anton_block", AntonBlock);
        BlockRegister.registerBlock("new_block", newBlock);
    }
}
