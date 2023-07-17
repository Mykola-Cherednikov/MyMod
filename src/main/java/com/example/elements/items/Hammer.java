package com.example.elements.items;

import com.example.ExampleMod;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.ServerPlayerInteractionManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.BlockView;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class Hammer extends PickaxeItem {
    public Hammer(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    public boolean Mine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if(!world.isClient()) {
            List<BlockPos> positions = getNeighbourBlocks(world, (PlayerEntity) miner, 1);
            for (var item : positions) {
                world.breakBlock(item,true);
            }
        }
        return super.postMine(stack, world, state, pos, miner);
    }

    List<BlockPos> getNeighbourBlocks(World world, PlayerEntity playerEntity, int radius) {
        ArrayList<BlockPos> potentialBrokenBlocks = new ArrayList<>();

        Vec3d cameraPos = playerEntity.getCameraPosVec(1);
        Vec3d rotation = playerEntity.getRotationVec(1);
        double reachDistance = 4.5f;
        Vec3d combined = cameraPos.add(rotation.x * reachDistance, rotation.y * reachDistance, rotation.z * reachDistance);

        BlockHitResult blockHitResult = world.raycast(new RaycastContext(cameraPos, combined, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, playerEntity));

        if (blockHitResult.getType() == HitResult.Type.BLOCK) {
            Direction.Axis axis = blockHitResult.getSide().getAxis();
            BlockPos origin = blockHitResult.getBlockPos();

            boolean valid = false;

            if (axis == Direction.Axis.Y) {
                for(int x = -radius; x <= radius; x++){
                    for(int z = -radius; z <= radius; z++){
                        potentialBrokenBlocks.add(origin.add(new Vec3i(x, 0, z)));
                    }
                }
            } else if (axis == Direction.Axis.X) {
                for(int z = -radius; z <= radius; z++){
                    for(int y = -radius; y <= radius; y++){
                        potentialBrokenBlocks.add(origin.add(new Vec3i(0, y, z)));
                    }
                }
            } else if (axis == Direction.Axis.Z) {
                for(int i = -radius; i <= radius; i++){
                    for(int y = -radius; y <= radius; y++){
                        potentialBrokenBlocks.add(origin.add(new Vec3i(i, y, 0)));
                    }
                }
            }
        }

        return potentialBrokenBlocks;
    }
}
