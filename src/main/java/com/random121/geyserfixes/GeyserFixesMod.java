package com.random121.geyserfixes;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeyserFixesMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("geyserfixes");

	@Override
	public void onInitialize() {
		LOGGER.info("Loaded GeyserFixes");
	}
}
