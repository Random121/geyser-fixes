package com.random121.geyserfixes;

import net.fabricmc.api.ModInitializer;
import org.geysermc.floodgate.api.FloodgateApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeyserFixesMod implements ModInitializer {
	public static final String MOD_ID = "geyserfixes";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initialized " + MOD_ID);
	}
}
