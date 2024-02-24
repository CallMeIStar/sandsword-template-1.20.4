package net.istar.sword;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.istar.sword.entity.ModEntities;
import net.istar.sword.entity.custom.DuneEdgeEntityRenderer;

public class SandSwordClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient(){
        EntityRendererRegistry.register(ModEntities.DUNEEDGE, DuneEdgeEntityRenderer::new);
    }
}
