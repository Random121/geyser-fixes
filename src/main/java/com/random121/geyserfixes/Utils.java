package com.random121.geyserfixes;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.player.PlayerEntity;
import org.geysermc.floodgate.api.FloodgateApi;

import java.util.UUID;
import java.util.function.Predicate;

public class Utils {
    private static final boolean IS_FLOODGATE_LOADED = FabricLoader.getInstance().isModLoaded("floodgate");
    private static final Predicate<UUID> bedrockPlayerPredicate = uuid -> FloodgateApi.getInstance()
                                                                                      .isFloodgatePlayer(uuid);

    public static boolean isBedrockPlayer(PlayerEntity player) {
        if (!IS_FLOODGATE_LOADED) {
            return false;
        }

        return bedrockPlayerPredicate.test(player.getUuid());
    }
}
