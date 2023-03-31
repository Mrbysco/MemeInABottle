package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.memes.ChocolateGuyEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class TomModel<T extends ChocolateGuyEntity> extends HumanBaseModel<T> {
	public TomModel(ModelPart part) {
		super(part);
	}

	public static MeshDefinition createMesh(CubeDeformation cubeDeformation) {
		MeshDefinition meshdefinition = new MeshDefinition();

		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 8.0F, 6.0F, cubeDeformation), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(2, 2).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 8.0F, 6.0F, cubeDeformation)
				.texOffs(2, 32).addBox(0.25F, -2.0F, 3.0F, 0.0F, 6.0F, 2.0F, cubeDeformation), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 10.0F, 4.0F, cubeDeformation)
				.texOffs(0, 32).addBox(0.25F, 6.0F, 2.0F, 0.0F, 4.0F, 2.0F, cubeDeformation), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, cubeDeformation), PartPose.offset(-5.0F, 5.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-1.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, cubeDeformation), PartPose.offset(5.0F, 5.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, cubeDeformation), PartPose.offset(-1.9F, 16.0F, 0.1F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, cubeDeformation), PartPose.offset(1.9F, 16.0F, 0.1F));

		return meshdefinition;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		this.body.xRot = 0.0F;
		this.rightLeg.z = 0.1F;
		this.leftLeg.z = 0.1F;
		this.rightLeg.y = 16.0F;
		this.leftLeg.y = 16.0F;
		this.head.y = 0.0F;
		this.body.y = 5.0F;
		this.leftArm.y = 5.0F;
		this.rightArm.y = 5.0F;
	}
}