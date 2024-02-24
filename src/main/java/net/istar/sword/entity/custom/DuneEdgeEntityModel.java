package net.istar.sword.entity.custom;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class DuneEdgeEntityModel extends EntityModel<Entity> {
	private final ModelPart bone;
	public DuneEdgeEntityModel(ModelPart root) {
		this.bone = root.getChild("bone");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create().uv(16, 16).cuboid(-8.25F, -9.0F, 6.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(18, 22).cuboid(-8.25F, -8.0F, 7.0F, 1.0F, 6.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-7.75F, -27.0F, 6.0F, 0.0F, 18.0F, 4.0F, new Dilation(0.0F))
		.uv(9, 0).cuboid(-8.25F, -27.0F, 7.0F, 1.0F, 18.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, 24.0F, -8.0F));

		ModelPartData cube_r1 = bone.addChild("cube_r1", ModelPartBuilder.create().uv(25, 20).cuboid(8.6978F, 8.0478F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-8.15F, -14.0026F, 8.0F, 0.0F, 0.0F, 0.7854F));

		ModelPartData cube_r2 = bone.addChild("cube_r2", ModelPartBuilder.create().uv(0, 28).cuboid(-0.05F, 8.2478F, 8.2478F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(25, 4).cuboid(-0.6F, 8.0907F, 8.0907F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(6, 21).cuboid(-1.1F, 3.0772F, 3.0772F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(16, 9).cuboid(-0.6F, 2.5772F, 2.5772F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(24, 7).cuboid(-0.1F, -10.4228F, -10.4228F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(16, 0).cuboid(0.4F, -11.4228F, -11.4228F, 0.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(7, 26).cuboid(0.4F, 2.2817F, 5.182F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-8.15F, -14.0026F, 8.0F, -0.7854F, 0.0F, 0.0F));

		ModelPartData cube_r3 = bone.addChild("cube_r3", ModelPartBuilder.create().uv(0, 23).cuboid(8.2407F, 7.5907F, -1.5F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-8.25F, -14.0026F, 8.0F, 0.0F, 0.0F, 0.7854F));

		ModelPartData cube_r4 = bone.addChild("cube_r4", ModelPartBuilder.create().uv(25, 24).cuboid(0.25F, 2.2817F, -7.182F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -14.0026F, 8.0F, 0.7854F, 0.0F, 0.0F));

		ModelPartData cube_r5 = bone.addChild("cube_r5", ModelPartBuilder.create().uv(23, 16).cuboid(-0.25F, -4.8564F, -5.7622F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -3.0026F, 8.0F, -0.3927F, 0.0F, 0.0F));

		ModelPartData cube_r6 = bone.addChild("cube_r6", ModelPartBuilder.create().uv(21, 0).cuboid(-0.25F, -4.8564F, 3.7622F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -3.0026F, 8.0F, 0.3927F, 0.0F, 0.0F));

		ModelPartData cube_r7 = bone.addChild("cube_r7", ModelPartBuilder.create().uv(12, 26).cuboid(-0.25F, -1.7706F, -0.1561F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -9.0026F, 4.0F, 0.3927F, 0.0F, 0.0F));

		ModelPartData cube_r8 = bone.addChild("cube_r8", ModelPartBuilder.create().uv(27, 12).cuboid(-0.25F, -1.7706F, -0.8439F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -9.0026F, 12.0F, -0.3927F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}