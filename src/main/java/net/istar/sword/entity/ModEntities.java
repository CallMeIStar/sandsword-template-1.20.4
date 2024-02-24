package net.istar.sword.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.istar.sword.SandSword;
import net.istar.sword.entity.custom.SandSwordEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<SandSwordEntity> DUNEEDGE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(SandSword.MOD_ID, "duneedge"), FabricEntityTypeBuilder.<SandSwordEntity>create(SpawnGroup.MISC, SandSwordEntity:: new)
                    .dimensions(EntityDimensions.fixed(0.5f,0.5f)).build());
}
