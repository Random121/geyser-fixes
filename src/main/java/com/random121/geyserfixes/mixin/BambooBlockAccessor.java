package com.random121.geyserfixes.mixin;

import net.minecraft.block.BambooBlock;
import net.minecraft.util.shape.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BambooBlock.class)
public interface BambooBlockAccessor {

    @Accessor("NO_LEAVES_SHAPE")
    static VoxelShape getNO_LEAVES_SHAPE() {
        throw new AssertionError();
    }
}
