package net.istar.sword;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.istar.sword.entity.custom.DuneEdgeEntity;
import net.istar.sword.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SandSword implements ModInitializer {
	public static final String MOD_ID = "sandsword";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		FabricDefaultAttributeRegistry.register(MOD_ID, DuneEdgeEntity.createMobAttributes());
	}
}