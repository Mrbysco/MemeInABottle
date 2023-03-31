package com.mrbysco.miab.client.models;

import com.google.common.collect.ImmutableList;
import com.mrbysco.miab.entity.memes.BongoCatEntity;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class BongoCatModel<T extends BongoCatEntity> extends ListModel<T> {
	private final ModelPart head;
	private final ModelPart leftLeg;
	private final ModelPart leftArm;
	private final ModelPart rightLeg;
	private final ModelPart rightArm;
	private final ModelPart body;

	public BongoCatModel(ModelPart root) {
		this.head = root.getChild("head");
		this.leftLeg = root.getChild("left_leg");
		this.leftArm = root.getChild("left_arm");
		this.rightLeg = root.getChild("right_leg");
		this.rightArm = root.getChild("right_arm");
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(1, 6).addBox(-2.0F, -6.0F, -2.0F, 6.0F, 6.0F, 4.0F), PartPose.offset(-1.0F, 12.0F, 0.0F));

		PartDefinition right_ear = head.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(10, 0).addBox(-3.5F, 2.0F, 0.0F, 3.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(3.0F, -7.7F, -1.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition left_ear = head.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(0, 0).addBox(2.0F, -3.5F, 0.0F, 2.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(-1.0F, -7.7F, -1.02F, 0.0F, 0.0F, 1.0472F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offset(1.0F, 18.0F, 0.1F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(4.0F, 14.0F, 0.0F, -2.0944F, 0.1F, 0.1F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offset(-2.0F, 18.0F, 0.1F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(-4.0F, 14.0F, 0.0F, -2.0944F, -0.1F, -0.1F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 6.0F, 4.0F), PartPose.offset(0.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.head, this.leftLeg, this.rightLeg, this.leftArm, this.rightArm, this.body);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;
		this.rightLeg.yRot = 0.0F;
		this.leftLeg.yRot = 0.0F;

		boolean flag = entityIn.isTapping();
		float f = Mth.sin(this.attackTime * (float) Math.PI);
		float f1 = Mth.sin((1.0F - (1.0F - this.attackTime) * (1.0F - this.attackTime)) * (float) Math.PI);
		this.rightArm.zRot = 0.0F;
		this.leftArm.zRot = 0.0F;
		this.rightArm.yRot = -(0.1F - f * 0.6F);
		this.leftArm.yRot = 0.1F - f * 0.6F;
		float f2 = -(float) Math.PI / (1.5F);
		this.rightArm.xRot = f2;
		this.leftArm.xRot = f2;

		//clap?
		float f3 = (flag ? ((Mth.cos(ageInTicks)) * 0.4F) : 0.0F);
		this.rightArm.xRot += f3;
		this.leftArm.xRot -= f3;

		this.rightArm.xRot += f * 1.2F - f1 * 0.4F;
		this.leftArm.xRot += f * 1.2F - f1 * 0.4F;
		this.rightArm.zRot += Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.leftArm.zRot -= Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.rightArm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.leftArm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
	}
}