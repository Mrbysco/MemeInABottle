package com.mrbysco.miab.client.models.knuckles;

import com.mrbysco.miab.client.models.HumanBaseModel;
import com.mrbysco.miab.entity.memes.KnucklesQueenEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class KnucklesQueenModel<T extends KnucklesQueenEntity> extends HumanBaseModel<T> {
	public KnucklesQueenModel(ModelPart part) {
		super(part);
	}

	public static MeshDefinition createMesh(CubeDeformation cubeDeformation) {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 7).addBox(-4.5F, -5.0F, -3.0F, 9.0F, 5.0F, 6.0F, cubeDeformation)
				.texOffs(2, 20).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 3.0F, 1.0F, cubeDeformation)
				.texOffs(42, 2).addBox(-0.5F, -3.05F, -5.5F, 1.0F, 1.0F, 4.0F, cubeDeformation)
				.texOffs(24, 0).addBox(-3.0F, -4.0F, -3.9F, 6.0F, 1.0F, 2.0F, cubeDeformation)
				.texOffs(0, 0).addBox(-3.5F, -6.0F, -3.0F, 7.0F, 1.0F, 5.0F, cubeDeformation), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 48).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, cubeDeformation), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 48).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, cubeDeformation), PartPose.offset(5.0F, 2.0F, 0.0F));
		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 48).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, cubeDeformation), PartPose.offset(-5.0F, 2.0F, 0.0F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubeDeformation), PartPose.offset(1.9F, 12.0F, 0.1F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubeDeformation), PartPose.offset(-1.9F, 12.0F, 0.1F));

		return meshdefinition;
	}
}