package net.istar.sword.client.renderer;

import net.istar.sword.client.model.SandSwordModel;
import net.istar.sword.entity.custom.SandSwordEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

public class SandSwordRenderer extends MobEntityRenderer<SandSwordEntity, SandSwordModel> {

    public SandSwordRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher.getRenderer(), new SandSwordModel(), 0.5f);
    }

    @Override
    public Identifier getTexture(SandSwordEntity entity) {
        return new Identifier("duneedge", "textures/item/duneedge.png");
    }

    @Override
    public Identifier getTexture(MobEntity entity) {
        return null;
    }
}