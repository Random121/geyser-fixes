package com.random121.geyserfixes.mixin;

import com.random121.geyserfixes.GeyserFixesMod;
import net.minecraft.block.*;
import net.minecraft.block.enums.Thickness;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockItem.class)
public class BlockItemMixin {

    private static final VoxelShape TIP_MERGE_SHAPE = PointedDripstoneBlockAccessor.getTIP_MERGE_SHAPE();
    private static final VoxelShape UP_TIP_SHAPE = PointedDripstoneBlockAccessor.getUP_TIP_SHAPE();
    private static final VoxelShape DOWN_TIP_SHAPE = PointedDripstoneBlockAccessor.getDOWN_TIP_SHAPE();
    private static final VoxelShape BASE_SHAPE = PointedDripstoneBlockAccessor.getBASE_SHAPE();
    private static final VoxelShape FRUSTUM_SHAPE = PointedDripstoneBlockAccessor.getFRUSTUM_SHAPE();
    private static final VoxelShape MIDDLE_SHAPE = PointedDripstoneBlockAccessor.getMIDDLE_SHAPE();
    private static final VoxelShape NO_LEAVES_SHAPE = BambooBlockAccessor.getNO_LEAVES_SHAPE();

    @Inject(method = "canPlace", at = @At("HEAD"), cancellable = true)
    private void canPlace(ItemPlacementContext context, BlockState state, CallbackInfoReturnable<Boolean> cir) {
        final Block blockToBePlaced = state.getBlock();

        if (blockToBePlaced instanceof BambooBlock) {
            if (this.isCollidingWithPlayer(context, NO_LEAVES_SHAPE)) {
                cir.setReturnValue(false);
            }
        } else if (blockToBePlaced instanceof PointedDripstoneBlock) {
            if (this.isCollidingWithPlayer(context, this.getPointedDripstoneShape(state))) {
                cir.setReturnValue(false);
            }
        }
    }

    private boolean isCollidingWithPlayer(ItemPlacementContext context, VoxelShape blockShape) {
        final BlockPos blockPosition = context.getBlockPos();
        final VoxelShape blockCollisionShape = blockShape.offset(blockPosition.getX(),
                                                                 blockPosition.getY(),
                                                                 blockPosition.getZ());
        final VoxelShape playerCollisionShape = VoxelShapes.cuboid(context.getPlayer().getBoundingBox());

        return VoxelShapes.matchesAnywhere(blockCollisionShape, playerCollisionShape, BooleanBiFunction.AND);
    }

    private VoxelShape getPointedDripstoneShape(BlockState state) {
        final Thickness thickness = state.get(PointedDripstoneBlock.THICKNESS);
        final Direction verticalDirection = state.get(PointedDripstoneBlock.VERTICAL_DIRECTION);

        switch (thickness) {
            case TIP -> {
                return verticalDirection == Direction.DOWN ? DOWN_TIP_SHAPE : UP_TIP_SHAPE;
            }
            case TIP_MERGE -> {
                return TIP_MERGE_SHAPE;
            }
            case MIDDLE -> {
                return MIDDLE_SHAPE;
            }
            case FRUSTUM -> {
                return FRUSTUM_SHAPE;
            }
            default -> {
                return BASE_SHAPE;
            }
        }
    }
}
