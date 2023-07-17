package com.example.elements.material;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class IronHammerMaterial implements ToolMaterial {
    public static final IronHammerMaterial INSTANCE = new IronHammerMaterial();

    @Override
    public int getDurability() {
        return 1000;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 4f;
    }

    @Override
    public float getAttackDamage() {
        return 5;
    }

    @Override
    public int getMiningLevel() {
        return 2;
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
