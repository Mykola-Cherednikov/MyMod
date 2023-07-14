package com.example.registrating.items;

import com.example.elements.items.PultOtYaderki;
import com.example.elements.material.PultOtYaderkiMaterial;
import com.example.register.items.ItemRegister;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class RegistratingAllItems {
    public static ToolItem Pult_Ot_Yaderki = new PultOtYaderki(PultOtYaderkiMaterial.INSTANCE, new Item.Settings().rarity(Rarity.EPIC));
    public static void registerAllItems(){
        ItemRegister.registerItem("pult_ot_yaderki", Pult_Ot_Yaderki);
    }
}
