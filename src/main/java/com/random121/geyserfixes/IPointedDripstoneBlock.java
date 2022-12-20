package com.random121.geyserfixes;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public interface IPointedDripstoneBlock {
    VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context);
}