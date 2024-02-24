package net.istar.sword.client.renderer;

import net.istar.sword.client.model.DuneEdgeModel;
import net.istar.sword.entity.custom.DuneEdgeEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class DuneEdgeRenderer extends MobEntityRenderer<DuneEdgeEntity, DuneEdgeModel> {

    public DuneEdgeRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new DuneEdgeModel(), 0.5f);
    }

    @Override
    public Identifier getTexture(DuneEdgeEntity entity) {
        return new Identifier("sandsword", "textures/item/cube.png");
    }
}
