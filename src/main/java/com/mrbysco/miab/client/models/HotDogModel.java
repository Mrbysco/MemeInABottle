package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.AbstractMeme;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class HotDogModel<T extends AbstractMeme> extends HumanBaseModel<T> {

	public HotDogModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 5).addBox(-3.0F, -6.0F, -2.0F, 7.0F, 6.0F, 4.0F)
				.texOffs(2, 0).addBox(-1.9F, -7.0F, -2.0F, 5.0F, 1.0F, 4.0F), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition Headset = head.addOrReplaceChild("Headset", CubeListBuilder.create().texOffs(54, 58).addBox(-4.8F, -29.4F, -1.5F, 2.0F, 3.0F, 3.0F)
				.texOffs(44, 58).addBox(3.8F, -29.4F, -1.5F, 2.0F, 3.0F, 3.0F)
				.texOffs(32, 55).addBox(-2.9F, -31.4F, -0.5F, 7.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 23.0F, 0.0F));

		PartDefinition HeadsetRight = Headset.addOrReplaceChild("HeadsetRight", CubeListBuilder.create().texOffs(56, 55).addBox(-3.7F, -4.5F, -1.0F, 3.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(1.0F, -29.4F, 0.5F, 0.0F, 0.0F, -0.9425F));

		PartDefinition HeadsetLeft = Headset.addOrReplaceChild("HeadsetLeft", CubeListBuilder.create().texOffs(48, 55).addBox(0.15F, -3.7F, -1.0F, 3.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(1.0F, -29.4F, 0.5F, 0.0F, 0.0F, 0.9425F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(22, 11).addBox(-3.0F, -7.0F, -2.0F, 7.0F, 13.0F, 4.0F)
				.texOffs(12, 28).addBox(4.0F, -9.5F, -2.0F, 2.0F, 16.0F, 4.0F)
				.texOffs(0, 28).addBox(-5.0F, -9.5F, -2.0F, 2.0F, 16.0F, 4.0F)
				.texOffs(24, 30).addBox(-3.0F, -9.5F, 2.0F, 7.0F, 16.0F, 2.0F),
				PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(22, 0).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -1.3963F, -0.1F, -0.1F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(12, 48).addBox(-1.0F, 0.2F, -2.6F, 3.0F, 3.0F, 3.0F), PartPose.offset(1.9F, 14.0F, 1.1F));

		PartDefinition bipedLeftFoot = left_leg.addOrReplaceChild("bipedLeftFoot", CubeListBuilder.create().texOffs(42, 48).addBox(-2.0F, -1.9F, -1.2F, 4.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(0.7F, 10.2F, -0.2F, 0.2618F, 0.1222F, -0.0175F));

		PartDefinition bipedLeftLeg2 = left_leg.addOrReplaceChild("bipedLeftLeg2", CubeListBuilder.create().texOffs(12, 55).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.2F, 3.6F, -0.7F, 0.2618F, 0.1222F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 48).addBox(-1.1F, 0.2F, -2.6F, 3.0F, 3.0F, 3.0F), PartPose.offset(-1.9F, 14.0F, 1.1F));

		PartDefinition bipedRightLeg2 = right_leg.addOrReplaceChild("bipedRightLeg2", CubeListBuilder.create().texOffs(0, 55).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(-0.2F, 3.6F, -0.7F, 0.2618F, -0.1222F, 0.0F));

		PartDefinition bipedRightFoot = right_leg.addOrReplaceChild("bipedRightFoot", CubeListBuilder.create().texOffs(26, 48).addBox(-6.3F, -1.9F, -1.0F, 4.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(4.7F, 10.2F, 0.2F, 0.2618F, -0.1222F, 0.0175F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(34, 0).addBox(0.0F, -2.0F, -2.0F, 3.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -1.3963F, 0.1F, 0.1F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setupAnim(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		if (this.crouching) {
			this.body.y = 3.2F;
		} else {
			this.body.y = 6.0F;
		}
	}
}