package com.example.elements.items;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EntityType;

import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;

import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.concurrent.atomic.AtomicInteger;


public class PultOtYaderki extends ToolItem {
    public PultOtYaderki(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        itemStack.damage(1, user, (p) -> { p.sendToolBreakStatus(hand);});

        for(int i = 0; i < 100; i++) {
            TntEntity tntEntity = EntityType.TNT.create(world);
            tntEntity.refreshPositionAfterTeleport(user.getPos().add(1f - (i / 100f), 5f, 1f + (i / 100f)));
            world.spawnEntity(tntEntity);

            for(int y = 0; y < i/3; y++){
                tntEntity.tick();
            }
        }


        return TypedActionResult.consume(user.getStackInHand(hand));
    }
}
