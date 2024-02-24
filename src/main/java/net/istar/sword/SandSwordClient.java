package net.istar.sword;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.istar.sword.client.renderer.DuneEdgeRenderer;

public class SandSwordClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient(){
        EntityRendererRegistry.INSTANCE.register(SandSword.MOD_ID, (dispatcher, context) -> {
            return new DuneEdgeRenderer(dispatcher);
        });
    }
}
