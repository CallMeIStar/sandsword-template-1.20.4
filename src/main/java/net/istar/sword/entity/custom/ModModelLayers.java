package net.istar.sword.entity.custom;

import com.google.common.collect.Sets;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.istar.sword.SandSword;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import java.util.Set;
import java.util.stream.Stream;

@Environment(value= EnvType.CLIENT)

public class ModModelLayers {
    private static final String MAIN = "main";
    private static final Set<EntityModelLayer> LAYERS = Sets.newHashSet();
    public static final EntityModelLayer DUNEEDGE = new EntityModelLayer(new Identifier(SandSword.MOD_ID, "duneedge"), "main");

    private static EntityModelLayer registerMain(String id) {
        return ModModelLayers.register(id, MAIN);
    }

    private static EntityModelLayer register(String id, String layer) {
        EntityModelLayer entityModelLayer = ModModelLayers.create(id, layer);
        if (!LAYERS.add(entityModelLayer)) {
            throw new IllegalStateException("Duplicate registration for " + entityModelLayer);
        }
        return entityModelLayer;
    }

    private static EntityModelLayer create(String id, String layer) {
        return new EntityModelLayer(new Identifier("minecraft", id), layer);
    }
    public static Stream<EntityModelLayer> getLayers() {
        return LAYERS.stream();
    }
}