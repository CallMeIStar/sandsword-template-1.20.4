package net.istar.sword;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.istar.sword.entity.custom.SandSwordEntity;
import net.istar.sword.item.ModItems;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SandSword implements ModInitializer {
	public static final EntityType<SandSwordEntity> DUNEEDGE = Registry.register(Registries.ENTITY_TYPE,
			new Identifier(SandSword.MOD_ID, "duneedge"), FabricEntityTypeBuilder.<SandSwordEntity>create(SpawnGroup.MISC, SandSwordEntity:: new)
					.dimensions(EntityDimensions.fixed(0.5f,0.5f)).build());
	public static final String MOD_ID = "sandsword";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}