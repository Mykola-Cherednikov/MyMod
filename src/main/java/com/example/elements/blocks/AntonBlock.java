package com.example.elements.blocks;

import com.example.registrating.sounds.RegistratingAllSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class AntonBlock extends Block {

    public static final BooleanProperty CHARGED = BooleanProperty.of("charged");

    public AntonBlock(Settings settings){
        super(settings);
        setDefaultState(getDefaultState().with(CHARGED, false));
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
        builder.add(CHARGED);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient && !world.getBlockState(pos).get(CHARGED)) {
            world.playSound(
                    null, // Player - if non-null, will play sound for every nearby player *except* the specified player
                    pos, // The position of where the sound will come from
                    RegistratingAllSounds.ANTON_BLOCK_USE_SOUND, // The sound that will play
                    SoundCategory.BLOCKS, // This determines which of the volume sliders affect this sound
                    2f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
                    1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
            );
            world.setBlockState(pos, state.with(CHARGED, true));
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (world.getBlockState(pos).get(CHARGED)){

            ZombieEntity zombieEntity = (ZombieEntity) EntityType.ZOMBIE.create(world);
            zombieEntity.refreshPositionAfterTeleport(Vec3d.ofCenter(pos).add(0, 1, 0));
            world.spawnEntity(zombieEntity);
        }

        world.setBlockState(pos, state.with(CHARGED, false));
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
}
