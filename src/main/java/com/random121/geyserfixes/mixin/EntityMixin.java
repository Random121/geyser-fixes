package com.random121.geyserfixes.mixin;

import com.random121.geyserfixes.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Shadow
    public abstract @Nullable LivingEntity getControllingPassenger();

    @Inject(method = "isLogicalSideForUpdatingMovement", at = @At("HEAD"), cancellable = true)
    public void isLogicalSideForUpdatingMovement(CallbackInfoReturnable<Boolean> cir) {
        LivingEntity entity = this.getControllingPassenger();

        // force the server to handle movement of steerable entities if the rider is a bedrock player
        // since bedrock edition expects the server to handle entity movements
        if ((entity instanceof PlayerEntity playerEntity) && Utils.isBedrockPlayer(playerEntity)) {
            cir.setReturnValue(true);
        }
    }
}
