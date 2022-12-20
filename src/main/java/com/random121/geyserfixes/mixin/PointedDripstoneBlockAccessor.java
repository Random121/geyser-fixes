package com.random121.geyserfixes.mixin;

import net.minecraft.block.PointedDripstoneBlock;
import net.minecraft.util.shape.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PointedDripstoneBlock.class)
public interface PointedDripstoneBlockAccessor {

    @Accessor("TIP_MERGE_SHAPE")
    static VoxelShape getTIP_MERGE_SHAPE() {
        throw new AssertionError();
    }

    @Accessor("UP_TIP_SHAPE")
    static VoxelShape getUP_TIP_SHAPE() {
        throw new AssertionError();
    }

    @Accessor("DOWN_TIP_SHAPE")
    static VoxelShape getDOWN_TIP_SHAPE() {
        throw new AssertionError();
    }

    @Accessor("BASE_SHAPE")
    static VoxelShape getBASE_SHAPE() {
        throw new AssertionError();
    }

    @Accessor("FRUSTUM_SHAPE")
    static VoxelShape getFRUSTUM_SHAPE() {
        throw new AssertionError();
    }

    @Accessor("MIDDLE_SHAPE")
    static VoxelShape getMIDDLE_SHAPE() {
        throw new AssertionError();
    }
}
