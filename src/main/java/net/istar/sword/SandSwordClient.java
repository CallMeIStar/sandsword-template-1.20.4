package net.istar.sword;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.istar.sword.client.renderer.SandSwordRenderer;
import net.istar.sword.entity.ModEntities;

public class SandSwordClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient(){
        EntityRendererRegistry.register(ModEntities.DUNEEDGE, (dispatcher, context) -> {
            return new SandSwordRenderer(dispatcher);
        });
    }
}
