package com.mrbysco.miab.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mrbysco.miab.entity.memes.DatBoiEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class DatBoiModel<T extends DatBoiEntity> extends EntityModel<T> {
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart leftArm;
	private final ModelPart rightArm;
	private final ModelPart rightKnee;
	private final ModelPart leftKnee;
	private final ModelPart bike, wheel;

	public DatBoiModel(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.leftArm = root.getChild("left_arm");
		this.rightArm = root.getChild("right_arm");
		this.rightKnee = root.getChild("right_knee");
		this.leftKnee = root.getChild("left_knee");
		this.bike = root.getChild("bike");
		this.wheel = this.bike.getChild("wheel");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedHead = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().create().texOffs(42, 28).addBox(-3.0F, -6.0F, -6.9F, 6.0F, 2.0F, 5.0F)
				.texOffs(0, 3).addBox(2.5F, -5.0F, -5.5F, 1.0F, 1.0F, 1.0F)
				.texOffs(0, 0).addBox(-3.5F, -5.0F, -5.5F, 1.0F, 1.0F, 1.0F)
				.texOffs(1, 19).addBox(-3.0F, -4.0F, -8.0F, 6.0F, 4.0F, 8.0F), PartPose.offset(0.0F, -13.0F, 0.0F));

		PartDefinition bipedBody = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -31.0F, -3.0F, 6.0F, 12.0F, 6.0F)
				.texOffs(24, 0).addBox(-2.0F, -29.0F, -4.0F, 4.0F, 8.0F, 1.0F)
				.texOffs(24, 9).addBox(-2.0F, -19.0F, -2.0F, 4.0F, 2.0F, 4.0F), PartPose.offset(0.0F, 18.0F, 0.0F));

		PartDefinition bipedLeftArm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 0).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 12.0F, 2.0F), PartPose.offsetAndRotation(-2.0F, -10.0F, 0.0F, -1.1723F, 0.3562F, -0.2969F));

		PartDefinition bipedRightArm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 14).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 12.0F, 2.0F), PartPose.offsetAndRotation(3.0F, -10.0F, 0.0F, -1.1723F, -0.4897F, 0.0F));

		PartDefinition RightKnee = partdefinition.addOrReplaceChild("right_knee", CubeListBuilder.create().texOffs(56, 0).addBox(-6.0F, 1.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offsetAndRotation(3.0F, -1.0F, -1.0F, 0.266F, 0.0F, 0.4653F));

		PartDefinition RightLeg = RightKnee.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(56, 14).addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F), PartPose.offsetAndRotation(-6.0F, 13.0F, 0.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition LeftKnee = partdefinition.addOrReplaceChild("left_knee", CubeListBuilder.create().texOffs(48, 0).addBox(2.0F, 2.0F, 0.0F, 2.0F, 12.0F, 2.0F), PartPose.offsetAndRotation(-1.7F, -2.0F, -1.0F, -0.1496F, 0.0F, -0.565F));

		PartDefinition LeftLeg = LeftKnee.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(48, 14).addBox(-0.5F, -0.5F, -1.0F, 2.0F, 8.0F, 2.0F), PartPose.offsetAndRotation(2.7F, 13.0F, 1.0F, -0.2618F, 0.0873F, 0.7854F));

		PartDefinition Bike = partdefinition.addOrReplaceChild("bike", CubeListBuilder.create(), PartPose.offset(0.0F, 18.0F, 0.0F));

		PartDefinition Saddle = Bike.addOrReplaceChild("saddle", CubeListBuilder.create().texOffs(42, 46).addBox(-2.0F, -17.0F, -5.0F, 4.0F, 2.0F, 6.0F)
				.texOffs(40, 40).addBox(-4.0F, -17.0F, 1.0F, 8.0F, 2.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Frame = Bike.addOrReplaceChild("frame", CubeListBuilder.create().texOffs(0, 46).addBox(-4.0F, -7.0F, -1.0F, 2.0F, 6.0F, 2.0F)
				.texOffs(28, 46).addBox(2.0F, -7.0F, -1.0F, 2.0F, 6.0F, 2.0F)
				.texOffs(8, 36).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 2.0F, 2.0F)
				.texOffs(0, 38).addBox(-1.0F, -15.0F, -1.0F, 2.0F, 6.0F, 2.0F)
				.texOffs(36, 54).addBox(-0.5F, 0.6F, -0.5F, 1.0F, 5.0F, 1.0F)
				.texOffs(40, 54).addBox(-0.5F, 0.6F, -0.5F, 1.0F, 5.0F, 1.0F)
				.texOffs(44, 54).addBox(-0.5F, 0.6F, -0.5F, 1.0F, 5.0F, 1.0F)
				.texOffs(48, 54).addBox(-0.5F, 0.6F, -0.5F, 1.0F, 5.0F, 1.0F)
				.texOffs(8, 40).addBox(-5.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition FullPedalLeft = Frame.addOrReplaceChild("FullPedalLeft", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftPeddleScape = FullPedalLeft.addOrReplaceChild("LeftPeddleScape", CubeListBuilder.create().texOffs(32, 39).addBox(-2.0F, -6.5F, -0.2F, 1.0F, 6.0F, 1.0F), PartPose.offsetAndRotation(-4.0F, 0.0F, -1.0F, -1.0922F, 0.0F, 0.0F));

		PartDefinition LeftPaddle = FullPedalLeft.addOrReplaceChild("LeftPaddle", CubeListBuilder.create().texOffs(36, 35).addBox(-2.35F, -1.0F, -2.0F, 4.0F, 1.0F, 3.0F), PartPose.offset(-5.4F, -2.2F, 4.9F));

		PartDefinition FullPeddleRight = Frame.addOrReplaceChild("FullPeddleRight", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightPeddleScape = FullPeddleRight.addOrReplaceChild("RightPeddleScape", CubeListBuilder.create().texOffs(36, 39).addBox(1.0F, -1.0F, -0.7F, 1.0F, 6.0F, 1.0F), PartPose.offsetAndRotation(4.0F, 0.0F, -1.0F, -2.0237F, 0.0F, 0.0F));

		PartDefinition RightPaddle = FullPeddleRight.addOrReplaceChild("RightPaddle", CubeListBuilder.create().texOffs(50, 36).addBox(-1.4F, -0.75F, -1.4F, 4.0F, 1.0F, 3.0F), PartPose.offset(5.4F, -2.2F, -4.9F));

		PartDefinition Wheel = Bike.addOrReplaceChild("wheel", CubeListBuilder.create().texOffs(52, 60).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 3.0F)
				.texOffs(44, 60).addBox(-0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 3.0F)
				.texOffs(40, 60).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 3.0F, 1.0F)
				.texOffs(36, 60).addBox(-0.5F, 1.0F, -0.5F, 1.0F, 3.0F, 1.0F)
				.texOffs(8, 44).addBox(-1.0F, -6.0F, -4.0F, 2.0F, 2.0F, 8.0F)
				.texOffs(8, 54).addBox(-1.0F, 4.0F, -4.0F, 2.0F, 2.0F, 8.0F)
				.texOffs(0, 54).addBox(-1.0F, -4.0F, 4.0F, 2.0F, 8.0F, 2.0F)
				.texOffs(28, 54).addBox(-1.0F, -4.0F, -6.0F, 2.0F, 8.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.wheel.xRot = Mth.cos(limbSwing * 0.6662F) * 3F * limbSwingAmount;
		this.wheel.yRot = 0.0F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightKnee.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftKnee.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bike.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}