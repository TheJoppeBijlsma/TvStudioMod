package io.github.joppebijlsma.tvstudio;

import io.github.joppebijlsma.tvstudio.registries.*;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TvStudio implements ModInitializer {
	public static final Logger TVSTUDIO_LOGGER = LoggerFactory.getLogger("tvstudio");
	public static final String MOD_ID = "tvstudio";

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
