package com.example.register.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockRegister {
    public static Block registerBlock(String id, Block block) {
        Registry.register(Registries.ITEM, new Identifier("modid", id), new BlockItem(block, new FabricItemSettings()));
        return Registry.register(Registries.BLOCK, new Identifier("modid", id), block);
    }
}
