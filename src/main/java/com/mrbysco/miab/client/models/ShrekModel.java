package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.AbstractMeme;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class ShrekModel<T extends AbstractMeme> extends HumanBaseModel<T> {

	public ShrekModel(ModelPart part) {
		super(part);
	}

	public static MeshDefinition createMesh(CubeDeformation cubeDeformation) {
		MeshDefinition meshdefinition = new MeshDefinition();

		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubeDeformation), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(32, 0).addBox(-10.25F, -32.0F, -1.0F, 2.0F, 2.0F, 2.0F, cubeDeformation)
				.texOffs(32, 4).addBox(-11.25F, -32.5F, -1.5F, 1.0F, 3.0F, 3.0F, cubeDeformation), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.1396F));
		head.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(42, 0).addBox(8.25F, -32.0F, -1.0F, 2.0F, 2.0F, 2.0F, cubeDeformation)
				.texOffs(42, 4).addBox(10.25F, -32.5F, -1.5F, 1.0F, 3.0F, 3.0F, cubeDeformation), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, -0.1396F));
		partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, -2.0F, -3.5F, 8.0F, 10.0F, 7.0F, cubeDeformation)
				.texOffs(17, 33).addBox(-4.0F, 8.0F, -3.0F, 8.0F, 4.0F, 6.0F, cubeDeformation), PartPose.offset(0.0F, 0.0F, 0.0F));
		partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(47, 16).addBox(-1.0F, -4.0F, -2.0F, 4.0F, 14.0F, 4.0F, cubeDeformation), PartPose.offset(5.0F, 2.0F, 0.0F));
		partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -4.0F, -2.0F, 4.0F, 14.0F, 4.0F, cubeDeformation), PartPose.offset(-5.0F, 2.0F, 0.0F));
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(47, 35).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, cubeDeformation), PartPose.offset(1.9F, 12.0F, 0.1F));
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 35).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, cubeDeformation), PartPose.offset(-1.9F, 12.0F, 0.1F));

		return meshdefinition;
	}
}