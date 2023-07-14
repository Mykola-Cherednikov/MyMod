package com.example.elements.material;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class PultOtYaderkiMaterial implements ToolMaterial {

    public static final PultOtYaderkiMaterial INSTANCE = new PultOtYaderkiMaterial();

    @Override
    public int getDurability() {
        return 1;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
