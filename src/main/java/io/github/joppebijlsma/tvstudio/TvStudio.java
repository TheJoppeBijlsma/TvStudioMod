package io.github.joppebijlsma.tvstudio;

import io.github.joppebijlsma.tvstudio.registries.ModBlockEntities;
import io.github.joppebijlsma.tvstudio.registries.ModBlocks;
import io.github.joppebijlsma.tvstudio.registries.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TvStudio implements ModInitializer {
	public static final Logger TVSTUDIO_LOGGER = LoggerFactory.getLogger("tvstudio");
	public static final String MOD_ID = "tvstudio";
	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerModBlockEntities();
	}
}
