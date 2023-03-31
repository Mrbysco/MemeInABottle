package com.mrbysco.miab.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mrbysco.miab.entity.memes.PinguEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class PinguModel<T extends PinguEntity> extends EntityModel<T> {
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart left_feet;
	private final ModelPart right_feet;

	public PinguModel(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
		this.left_feet = root.getChild("left_feet");
		this.right_feet = root.getChild("right_feet");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.5F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 14.5F, -0.5F));

		PartDefinition Mouth = head.addOrReplaceChild("mouth", CubeListBuilder.create().create().texOffs(12, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F), PartPose.offset(0.0F, -2.0F, -2.5F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 24).addBox(-3.0F, -4.5F, -3.0F, 6.0F, 9.0F, 5.0F), PartPose.offset(0.0F, 18.5F, 0.0F));

		PartDefinition Body2 = body.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(24, 30).addBox(-2.5F, -3.5F, 0.6F, 5.0F, 7.0F, 1.0F), PartPose.offset(0.0F, 0.0F, -4.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 38).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 7.0F, 2.0F), PartPose.offset(3.5F, 14.0F, -0.5F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 38).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 7.0F, 2.0F), PartPose.offset(-3.5F, 14.0F, -0.5F));

		PartDefinition left_feet = partdefinition.addOrReplaceChild("left_feet", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 1.0F, 5.0F), PartPose.offset(-1.5F, 23.0F, -1.0F));

		PartDefinition right_feet = partdefinition.addOrReplaceChild("right_feet", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 1.0F, 5.0F), PartPose.offset(1.5F, 23.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.right_feet.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		this.left_feet.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;
		this.right_feet.yRot = 0.0F;
		this.left_feet.yRot = 0.0F;

		if (entityIn.isAggressive()) {
			float f = Mth.sin(this.attackTime * (float) Math.PI);
			float f1 = Mth.sin((1.0F - (1.0F - this.attackTime) * (1.0F - this.attackTime)) * (float) Math.PI);
			this.right_arm.zRot = 0.0F;
			this.left_arm.zRot = 0.0F;
			this.right_arm.yRot = -(0.1F - f * 0.6F);
			this.left_arm.yRot = 0.1F - f * 0.6F;
			this.right_arm.xRot = -((float) Math.PI / 2F);
			this.left_arm.xRot = -((float) Math.PI / 2F);
			this.right_arm.xRot -= f * 1.2F - f1 * 0.4F;
			this.left_arm.xRot -= f * 1.2F - f1 * 0.4F;
			this.right_arm.zRot += Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
			this.left_arm.zRot -= Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
			this.right_arm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
			this.left_arm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_feet.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_feet.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}