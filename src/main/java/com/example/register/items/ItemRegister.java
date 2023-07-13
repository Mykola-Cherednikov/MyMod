package com.example.register.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemRegister {
    public static Item registerItem(String id, Item item){
        return Registry.register(Registries.ITEM, new Identifier("modid", id), item);
    }
}
