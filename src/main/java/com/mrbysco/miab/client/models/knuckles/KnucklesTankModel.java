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

public class KnucklesTankModel<T extends KnucklesEntity> extends EntityModel<T> {
	private final ModelPart tank;

	public KnucklesTankModel(ModelPart root) {
		this.tank = root.getChild("tank");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition tank = partdefinition.addOrReplaceChild("tank", CubeListBuilder.create().texOffs(80, 113).addBox(-6.0F, -1.5F, -6.0F, 12.0F, 3.0F, 12.0F), PartPose.offset(0.0F, 16.5F, 0.0F));

		PartDefinition tank_2 = tank.addOrReplaceChild("tank_2", CubeListBuilder.create().texOffs(0, 99).addBox(-8.0F, -2.5F, -12.0F, 16.0F, 5.0F, 24.0F), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition tank_side = tank.addOrReplaceChild("tank_side", CubeListBuilder.create().texOffs(0, 118).addBox(-5.0F, -1.5F, -1.0F, 10.0F, 3.0F, 2.0F), PartPose.offset(0.0F, 0.0F, -7.0F));

		PartDefinition right_arm = tank.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(50, 60).addBox(-6.0F, -1.0F, 0.0F, 3.0F, 2.0F, 2.0F), PartPose.offset(-3.0F, -4.5F, -1.0F));

		PartDefinition right_arm_2 = right_arm.addOrReplaceChild("right_arm_2", CubeListBuilder.create().texOffs(38, 60).addBox(-4.0F, -1.0F, 0.0F, 4.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-5.4F, 0.3F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition right_hand = right_arm.addOrReplaceChild("right_hand", CubeListBuilder.create().texOffs(39, 54).addBox(-10.0F, 1.2F, -0.5F, 3.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = tank.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 5).addBox(-4.0F, -2.0F, -2.0F, 7.0F, 4.0F, 4.0F), PartPose.offset(0.5F, -8.0F, 0.0F));

		PartDefinition mouth = head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(22, 2).addBox(-3.0F, 0.0F, -0.5F, 6.0F, 2.0F, 1.0F), PartPose.offset(-0.5F, 0.0F, -2.5F));

		PartDefinition mouth_top = head.addOrReplaceChild("mouth_top", CubeListBuilder.create().texOffs(22, 0).addBox(-2.0F, 0.0F, -0.4F, 4.0F, 1.0F, 1.0F), PartPose.offset(-0.5F, -1.0F, -2.5F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(17, 0).addBox(-0.5F, -0.6F, -0.5F, 1.0F, 1.0F, 1.0F), PartPose.offset(-0.5F, -0.2F, -3.0F));

		PartDefinition head_top = head.addOrReplaceChild("head_top", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -1.0F, -2.0F, 5.0F, 1.0F, 3.0F), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition torso = tank.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(36, 0).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 5.0F, 4.0F), PartPose.offset(0.0F, -1.0F, -2.0F));

		PartDefinition chest_part = torso.addOrReplaceChild("chest_part", CubeListBuilder.create().texOffs(46, 19).addBox(-4.0F, 15.5F, -0.5F, 8.0F, 1.0F, 1.0F), PartPose.offset(0.0F, -20.0F, -0.5F));

		PartDefinition chest_part4 = torso.addOrReplaceChild("chest_part4", CubeListBuilder.create().texOffs(40, 16).addBox(8.5F, 13.0F, -0.5F, 1.0F, 3.0F, 1.0F), PartPose.offset(-4.5F, -16.5F, -0.5F));

		PartDefinition chest_front = torso.addOrReplaceChild("chest_front", CubeListBuilder.create().texOffs(44, 9).addBox(0.0F, 16.0F, 0.0F, 8.0F, 3.0F, 2.0F), PartPose.offset(-4.0F, -19.5F, -2.0F));

		PartDefinition chest_part3 = torso.addOrReplaceChild("chest_part3", CubeListBuilder.create().texOffs(40, 16).addBox(-0.5F, 13.0F, -0.5F, 1.0F, 3.0F, 1.0F), PartPose.offset(-4.5F, -16.5F, -0.5F));

		PartDefinition chest_right = torso.addOrReplaceChild("chest_right", CubeListBuilder.create().texOffs(36, 9).addBox(0.0F, 0.0F, -1.5F, 1.0F, 4.0F, 3.0F), PartPose.offset(-6.0F, -4.5F, 2.0F));

		PartDefinition chest_left = torso.addOrReplaceChild("chest_left", CubeListBuilder.create().texOffs(36, 9).addBox(0.0F, 0.0F, -1.5F, 1.0F, 4.0F, 3.0F), PartPose.offset(5.0F, -4.5F, 2.0F));

		PartDefinition chest_back = torso.addOrReplaceChild("chest_back", CubeListBuilder.create().texOffs(44, 14).addBox(0.0F, 0.0F, 0.0F, 8.0F, 3.0F, 2.0F), PartPose.offset(-4.0F, -3.0F, 3.2F));

		PartDefinition tank_side_2 = tank.addOrReplaceChild("tank_side_2", CubeListBuilder.create().texOffs(0, 112).addBox(-5.0F, -1.5F, -1.0F, 10.0F, 3.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 7.0F));

		PartDefinition wheels_2 = tank.addOrReplaceChild("wheels_2", CubeListBuilder.create().texOffs(0, 73).addBox(-1.2F, -0.5F, -12.0F, 2.0F, 1.0F, 24.0F), PartPose.offset(6.5F, 7.0F, 0.0F));

		PartDefinition cannon = tank.addOrReplaceChild("cannon", CubeListBuilder.create().texOffs(56, 107).addBox(-1.0F, -1.0F, -12.0F, 2.0F, 2.0F, 14.0F), PartPose.offsetAndRotation(0.0F, -0.2F, -10.0F, -0.1222F, 0.0F, 0.0F));

		PartDefinition wheels_1 = tank.addOrReplaceChild("wheels_1", CubeListBuilder.create().texOffs(0, 73).addBox(-1.0F, -0.5F, -12.0F, 2.0F, 1.0F, 24.0F), PartPose.offset(-6.2F, 7.0F, 0.0F));

		PartDefinition left_arm = tank.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 60).addBox(3.0F, -1.0F, 0.0F, 3.0F, 2.0F, 2.0F), PartPose.offset(3.0F, -4.5F, -1.0F));

		PartDefinition left_hand = left_arm.addOrReplaceChild("left_hand", CubeListBuilder.create().texOffs(14, 54).addBox(6.5F, 18.2F, -0.5F, 3.0F, 3.0F, 3.0F), PartPose.offset(0.0F, -16.5F, 0.0F));

		PartDefinition left_arm_2 = left_arm.addOrReplaceChild("left_arm_2", CubeListBuilder.create().texOffs(14, 60).addBox(9.7508F, 12.9256F, 0.0F, 4.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(5.3F, -16.7F, 0.0F, 0.0F, 0.0F, 0.6109F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		tank.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}