package com.mrbysco.miab.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mrbysco.miab.entity.memes.RoflCopterEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class RoflCopterModel<T extends RoflCopterEntity> extends EntityModel<T> {
	private final ModelPart copter;
	private final ModelPart top_propelor;
	private final ModelPart back_propelor;

	public RoflCopterModel(ModelPart root) {
		this.copter = root.getChild("copter");
		this.top_propelor = this.copter.getChild("top_part").getChild("top_propelor");
		this.back_propelor = this.copter.getChild("back_part").getChild("back_propelor");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition copter = partdefinition.addOrReplaceChild("copter", CubeListBuilder.create().create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition top_part = copter.addOrReplaceChild("top_part", CubeListBuilder.create().texOffs(2, 12).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F).mirror(false), PartPose.offset(0.0F, -23.0F, 0.0F));

		PartDefinition top_propelor = top_part.addOrReplaceChild("top_propelor", CubeListBuilder.create().texOffs(4, 123).mirror().addBox(-12.0F, -1.0F, -2.0F, 24.0F, 1.0F, 4.0F).mirror(false), PartPose.offset(0.0F, -2.1F, 0.0F));

		PartDefinition middle_part = copter.addOrReplaceChild("middle_part", CubeListBuilder.create().texOffs(2, 0).mirror().addBox(-6.0F, -6.0F, -10.0F, 12.0F, 12.0F, 20.0F).mirror(false)
				.texOffs(8, 32).mirror().addBox(-3.0F, -10.0F, -7.0F, 6.0F, 4.0F, 14.0F).mirror(false)
				.texOffs(46, 0).mirror().addBox(-3.0F, -5.0F, 10.0F, 6.0F, 8.0F, 3.0F).mirror(false)
				.texOffs(0, 0).mirror().addBox(-3.0F, -2.0F, -15.0F, 6.0F, 6.0F, 5.0F).mirror(false), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition landing_left = middle_part.addOrReplaceChild("landing_left", CubeListBuilder.create().texOffs(0, 80).mirror().addBox(-1.0F, -1.0F, -12.0F, 1.0F, 2.0F, 24.0F).mirror(false)
				.texOffs(0, 80).mirror().addBox(-1.0F, -3.0F, -14.0F, 1.0F, 2.0F, 2.0F).mirror(false)
				.texOffs(18, 80).mirror().addBox(-1.0F, -3.0F, 12.0F, 1.0F, 2.0F, 2.0F).mirror(false), PartPose.offset(-6.0F, 10.0F, 0.0F));

		PartDefinition landing_left_child = landing_left.addOrReplaceChild("landing_left_child", CubeListBuilder.create().texOffs(6, 80).mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 5.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(0.9F, -5.9F, -5.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition landing_right = middle_part.addOrReplaceChild("landing_right", CubeListBuilder.create().texOffs(0, 52).mirror().addBox(-1.0F, -1.0F, -12.0F, 1.0F, 2.0F, 24.0F).mirror(false)
				.texOffs(18, 52).mirror().addBox(-1.0F, -3.0F, 12.0F, 1.0F, 2.0F, 2.0F).mirror(false)
				.texOffs(0, 52).mirror().addBox(-1.0F, -3.0F, -14.0F, 1.0F, 2.0F, 2.0F).mirror(false), PartPose.offset(7.0F, 10.0F, 0.0F));

		PartDefinition landing_right_child = landing_right.addOrReplaceChild("landing_right_child", CubeListBuilder.create().texOffs(6, 52).mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 5.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(-0.9F, -6.0F, -5.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition back_part = copter.addOrReplaceChild("back_part", CubeListBuilder.create().texOffs(69, 3).mirror().addBox(-1.5F, -1.0F, -3.0F, 3.0F, 3.0F, 9.0F).mirror(false), PartPose.offset(0.0F, -15.0F, 16.0F));

		PartDefinition back_propelor = back_part.addOrReplaceChild("back_propelor", CubeListBuilder.create().texOffs(0, 113).mirror().addBox(-1.0F, -6.0F, -1.0F, 1.0F, 12.0F, 2.0F).mirror(false), PartPose.offset(-1.0F, 0.6F, 3.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		boolean flag = !entityIn.getIsCopterLanded();

		float f3 = (flag ? ((Mth.cos(ageInTicks)) * 0.4F) : 0.0F);
		if (flag) {
			this.back_propelor.xRot += f3;
			this.top_propelor.yRot -= f3;
		} else {
			this.back_propelor.xRot = Mth.cos(limbSwing * 0.6662F) * 0.3F * limbSwingAmount;
			this.top_propelor.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.3F * limbSwingAmount;
			this.back_propelor.yRot = 0.0F;
			this.top_propelor.yRot = 0.0F;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		copter.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}