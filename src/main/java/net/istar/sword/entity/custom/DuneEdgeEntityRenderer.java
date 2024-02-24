package net.istar.sword.entity.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

@Environment(value= EnvType.CLIENT)
public class DuneEdgeEntityRenderer
        extends EntityRenderer<DuneEdgeEntity> {
    public static final Identifier TEXTURE = new Identifier("textures/entity/duneedge.png");
    private final DuneEdgeEntityModel model;

    public DuneEdgeEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new DuneEdgeEntityModel(context.getPart(ModModelLayers.DUNEEDGE));
    }

    @Override
    public void render(DuneEdgeEntity duneEdgeEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(g, duneEdgeEntity.prevYaw, duneEdgeEntity.getYaw()) - 90.0f));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(g, duneEdgeEntity.prevPitch, duneEdgeEntity.getPitch()) + 90.0f));
        matrixStack.pop();
        super.render(duneEdgeEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(DuneEdgeEntity tridentEntity) {
        return TEXTURE;
    }
}