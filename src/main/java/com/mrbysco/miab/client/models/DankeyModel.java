package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.memes.DankeyEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class DankeyModel<T extends DankeyEntity> extends HumanBaseModel<T> {

	public DankeyModel(ModelPart root) {
		super(root);
	}

	public static MeshDefinition createMesh(CubeDeformation cubeDeformation) {
		MeshDefinition meshdefinition = new MeshDefinition();

		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubeDeformation)
				.texOffs(32, 10).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 3.0F, 2.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(2, 16).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 6.0F, 6.0F, cubeDeformation)
				.texOffs(4, 28).addBox(-4.0F, 6.0F, -2.0F, 8.0F, 6.0F, 4.0F, cubeDeformation), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(32, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, cubeDeformation)
				.texOffs(33, 24).addBox(-2.0F, 2.0F, -1.5F, 3.0F, 6.0F, 3.0F, cubeDeformation)
				.texOffs(32, 33).addBox(-3.0F, 8.0F, -2.0F, 4.0F, 4.0F, 4.0F, cubeDeformation), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, cubeDeformation)
				.texOffs(33, 24).addBox(-1.0F, 2.0F, -1.5F, 3.0F, 6.0F, 3.0F, cubeDeformation)
				.texOffs(32, 33).addBox(-1.0F, 8.0F, -2.0F, 4.0F, 4.0F, 4.0F, cubeDeformation), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 38).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, cubeDeformation)
				.texOffs(0, 51).addBox(-2.0F, 9.0F, -2.5F, 4.0F, 3.0F, 5.0F, cubeDeformation), PartPose.offset(-1.9F, 12.0F, 0.1F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 38).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, cubeDeformation)
				.texOffs(0, 51).addBox(-2.0F, 9.0F, -2.5F, 4.0F, 3.0F, 5.0F, cubeDeformation), PartPose.offset(1.9F, 12.0F, 0.1F));

		return meshdefinition;
	}
}