package com.mrbysco.miab.client.models.knuckles;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mrbysco.miab.entity.memes.KnucklesEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class KnucklesSaiyanModel<T extends KnucklesEntity> extends EntityModel<T> {
	private final ModelPart head;
	private final ModelPart torso;
	private final ModelPart leftArm;
	private final ModelPart rightArm;
	private final ModelPart leftLeg;
	private final ModelPart rightLeg;

	public KnucklesSaiyanModel(ModelPart root) {
		this.head = root.getChild("head");
		this.torso = root.getChild("torso");
		this.leftArm = root.getChild("left_arm");
		this.rightArm = root.getChild("right_arm");
		this.leftLeg = root.getChild("left_leg");
		this.rightLeg = root.getChild("right_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 5).addBox(-4.0F, -2.0F, -2.0F, 7.0F, 4.0F, 4.0F), PartPose.offset(0.5F, 6.0F, 0.0F));

		PartDefinition mouth_top = head.addOrReplaceChild("mouth_top", CubeListBuilder.create().texOffs(22, 0).addBox(-2.0F, 0.0F, -0.4F, 4.0F, 1.0F, 1.0F), PartPose.offset(-0.5F, -1.0F, -2.5F));

		PartDefinition hair_5 = head.addOrReplaceChild("hair_5", CubeListBuilder.create().texOffs(20, 13).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(2.4F, -2.2F, -0.5F, 0.0F, 0.0F, -0.5236F));

		PartDefinition hair_6 = head.addOrReplaceChild("hair_6", CubeListBuilder.create().texOffs(0, 13).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(-0.5F, -3.8F, -0.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition hair_7 = head.addOrReplaceChild("hair_7", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-2.5F, -3.2F, -0.5F, 0.7854F, 0.0F, -0.7854F));

		PartDefinition hair_4 = head.addOrReplaceChild("hair_4", CubeListBuilder.create().texOffs(20, 13).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-3.4F, -2.2F, -0.5F, 0.0F, 0.0F, 0.5236F));

		PartDefinition hair_3 = head.addOrReplaceChild("hair_3", CubeListBuilder.create().texOffs(12, 13).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(-2.5F, -4.0F, -0.5F, 0.0F, 0.0F, -1.2217F));

		PartDefinition mouth = head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(22, 2).addBox(-3.0F, 0.0F, -0.5F, 6.0F, 2.0F, 1.0F), PartPose.offset(-0.5F, -0.5F, -2.5F));

		PartDefinition head_top = head.addOrReplaceChild("head_top", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -1.0F, -2.0F, 5.0F, 1.0F, 3.0F), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(17, 0).addBox(-0.5F, -0.6F, -0.5F, 1.0F, 1.0F, 1.0F), PartPose.offset(-0.5F, -0.2F, -3.0F));

		PartDefinition hair_1 = head.addOrReplaceChild("hair_1", CubeListBuilder.create().texOffs(0, 13).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(-0.5F, -3.5F, -0.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition hair_2 = head.addOrReplaceChild("hair_2", CubeListBuilder.create().texOffs(12, 13).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(1.5F, -4.0F, -0.5F, 0.0F, 0.0F, 1.2217F));

		PartDefinition hair_8 = head.addOrReplaceChild("hair_8", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(1.5F, -3.2F, -0.5F, 0.7854F, 0.0F, 0.7854F));

		PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 36).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 4.0F), PartPose.offset(0.0F, 13.0F, -2.0F));

		PartDefinition chest_front = torso.addOrReplaceChild("chest_front", CubeListBuilder.create().texOffs(28, 36).addBox(0.0F, 0.0F, 0.0F, 8.0F, 6.0F, 2.0F), PartPose.offset(-4.0F, -3.0F, -2.0F));

		PartDefinition chest_back = torso.addOrReplaceChild("chest_back", CubeListBuilder.create().texOffs(28, 44).addBox(0.0F, 0.0F, 0.0F, 8.0F, 6.0F, 2.0F), PartPose.offset(-4.0F, -3.0F, 3.2F));

		PartDefinition chest_part3 = torso.addOrReplaceChild("chest_part3", CubeListBuilder.create().texOffs(0, 52).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F), PartPose.offset(-4.5F, 0.0F, -0.5F));

		PartDefinition chest_part2 = torso.addOrReplaceChild("chest_part2", CubeListBuilder.create().texOffs(0, 50).addBox(-4.0F, -0.5F, -0.5F, 8.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 3.5F, -0.5F));

		PartDefinition chest_left = torso.addOrReplaceChild("chest_left", CubeListBuilder.create().texOffs(56, 36).addBox(0.0F, 0.0F, -1.5F, 1.0F, 8.0F, 3.0F), PartPose.offset(5.0F, -4.5F, 2.0F));

		PartDefinition chest_part4 = torso.addOrReplaceChild("chest_part4", CubeListBuilder.create().texOffs(4, 52).addBox(8.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F), PartPose.offset(-4.5F, 0.0F, -0.5F));

		PartDefinition chest_right = torso.addOrReplaceChild("chest_right", CubeListBuilder.create().texOffs(48, 36).addBox(0.0F, 0.0F, -1.5F, 1.0F, 8.0F, 3.0F), PartPose.offset(-6.0F, -4.5F, 2.0F));

		PartDefinition chest_part = torso.addOrReplaceChild("chest_part", CubeListBuilder.create().texOffs(8, 52).addBox(-4.0F, -0.5F, -0.5F, 8.0F, 1.0F, 1.0F), PartPose.offset(0.0F, -3.5F, -0.5F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 60).mirror().addBox(3.0F, -1.0F, 0.0F, 3.0F, 2.0F, 2.0F).mirror(false), PartPose.offset(3.0F, 10.0F, -1.0F));

		PartDefinition right_hand = left_arm.addOrReplaceChild("right_hand", CubeListBuilder.create().texOffs(14, 54).addBox(6.5F, 1.2F, -0.5F, 3.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_arm_2 = left_arm.addOrReplaceChild("left_arm_2", CubeListBuilder.create().texOffs(14, 60).mirror().addBox(0.0F, -1.0F, 0.0F, 4.0F, 2.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(5.3F, -0.2F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(50, 60).addBox(-6.0F, -1.0F, 0.0F, 3.0F, 2.0F, 2.0F), PartPose.offset(-3.0F, 10.0F, -1.0F));

		PartDefinition right_hand_1 = right_arm.addOrReplaceChild("right_hand_1", CubeListBuilder.create().texOffs(39, 54).addBox(-10.0F, 1.2F, -0.5F, 3.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_arm_2 = right_arm.addOrReplaceChild("right_arm_2", CubeListBuilder.create().texOffs(38, 60).addBox(-4.0F, -1.0F, 0.0F, 4.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-5.4F, -0.2F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(40, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(2.0F, 17.0F, 0.0F));

		PartDefinition left_foot = left_leg.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(36, 6).addBox(-0.5F, 4.0F, -2.8F, 2.0F, 2.0F, 4.0F), PartPose.offset(-0.5F, 0.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(-2.0F, 17.0F, 0.0F));

		PartDefinition right_foot = right_leg.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(50, 6).addBox(-0.5F, 4.0F, -2.8F, 2.0F, 2.0F, 4.0F), PartPose.offset(-0.5F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;
		this.rightLeg.yRot = 0.0F;
		this.leftLeg.yRot = 0.0F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}