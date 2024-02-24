package net.istar.sword.client.model;

import com.sun.jna.platform.unix.X11;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.istar.sword.client.renderer.SandSwordRenderer;
import net.istar.sword.entity.custom.SandSwordEntity;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SandSwordModel implements ClientModInitializer {
    public static final EntityModelLayer SandSwordLayer = new EntityModelLayer(new Identifier("duneedgemodel", "models.duneedge_model"), "main");
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(SandSwordRenderer);
        return new SandSwordRenderer(SandSwordRenderer);

    }
}
