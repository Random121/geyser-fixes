package com.random121.geyserfixes.mixin;

import net.minecraft.block.BambooBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BambooBlock.class)
public class BambooBlockMixin {

    // remove bamboo block collision
    @Inject(method = "getCollisionShape", at = @At("HEAD"), cancellable = true)
    public void getCollisionShape(BlockState state,
                                  BlockView world,
                                  BlockPos pos,
                                  ShapeContext context,
                                  CallbackInfoReturnable<VoxelShape> cir
    ) {
        cir.setReturnValue(VoxelShapes.empty());
    }
}
