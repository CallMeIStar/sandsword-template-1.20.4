package net.istar.sword;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.istar.sword.entity.ModEntities;
import net.istar.sword.entity.custom.DuneEdgeEntityModel;
import net.istar.sword.entity.custom.DuneEdgeEntityRenderer;
import net.istar.sword.entity.custom.ModModelLayers;

public class SandSwordClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient(){
        EntityRendererRegistry.register(ModEntities.DUNEEDGE, DuneEdgeEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.DUNEEDGE, DuneEdgeEntityModel::getTexturedModelData);
    }
}
