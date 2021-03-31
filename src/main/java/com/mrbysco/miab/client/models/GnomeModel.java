package com.mrbysco.miab.client.models;

import com.google.common.collect.ImmutableList;
import com.mrbysco.miab.entity.memes.GnomeEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class GnomeModel<T extends GnomeEntity> extends SegmentedModel<T> {
	private final ModelRenderer Left_Leg;
	private final ModelRenderer Right_Leg;
	private final ModelRenderer Torso;
	private final ModelRenderer Left_Arm;
	private final ModelRenderer Right_Arm;
	private final ModelRenderer Head;

	public GnomeModel() {
		textureWidth = 64;
		textureHeight = 64;

		Left_Leg = new ModelRenderer(this);
		Left_Leg.setRotationPoint(1.5F, 18.0F, 0.0F);
		Left_Leg.setTextureOffset(0, 32).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		ModelRenderer left_Foot = new ModelRenderer(this);
		left_Foot.setRotationPoint(0.0F, 0.0F, 0.0F);
		Left_Leg.addChild(left_Foot);
		left_Foot.setTextureOffset(0, 39).addBox(-1.5F, 4.0F, -2.5F, 3.0F, 2.0F, 4.0F, 0.0F, false);

		Right_Leg = new ModelRenderer(this);
		Right_Leg.setRotationPoint(-1.5F, 18.0F, 0.0F);
		Right_Leg.setTextureOffset(14, 32).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		ModelRenderer right_Foot = new ModelRenderer(this);
		right_Foot.setRotationPoint(0.0F, 0.0F, 0.0F);
		Right_Leg.addChild(right_Foot);
		right_Foot.setTextureOffset(14, 39).addBox(-1.5F, 4.0F, -2.5F, 3.0F, 2.0F, 4.0F, 0.0F, false);

		Torso = new ModelRenderer(this);
		Torso.setRotationPoint(0.0F, 14.5F, 0.0F);
		Torso.setTextureOffset(0, 21).addBox(-3.0F, -3.5F, -2.0F, 6.0F, 7.0F, 4.0F, 0.0F, false);

		Left_Arm = new ModelRenderer(this);
		Left_Arm.setRotationPoint(4.0F, 11.0F, 0.0F);
		Left_Arm.setTextureOffset(28, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Right_Arm = new ModelRenderer(this);
		Right_Arm.setRotationPoint(-4.0F, 11.0F, 0.0F);
		Right_Arm.setTextureOffset(36, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 9.0F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		ModelRenderer beard = new ModelRenderer(this);
		beard.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(beard);
		beard.setTextureOffset(0, 8).addBox(-2.5F, 1.0F, -2.5F, 5.0F, 2.0F, 3.0F, 0.0F, false);

		ModelRenderer left_Ear = new ModelRenderer(this);
		left_Ear.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(left_Ear);
		setRotationAngle(left_Ear, 0.0F, -0.6517F, -0.2143F);
		left_Ear.setTextureOffset(0, 13).addBox(0.2F, -0.6F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		ModelRenderer hat_Base = new ModelRenderer(this);
		hat_Base.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(hat_Base);
		setRotationAngle(hat_Base, -0.1607F, 0.0F, 0.0F);
		hat_Base.setTextureOffset(16, 0).addBox(-2.5F, -4.2F, -2.5F, 5.0F, 3.0F, 5.0F, 0.0F, false);

		ModelRenderer hat_2 = new ModelRenderer(this);
		hat_2.setRotationPoint(0.0F, -2.3959F, -0.7337F);
		hat_Base.addChild(hat_2);
		setRotationAngle(hat_2, -0.2588F, 0.0F, 0.0F);
		hat_2.setTextureOffset(36, 0).addBox(-2.0F, -2.6F, -1.8F, 4.0F, 2.0F, 4.0F, 0.0F, false);

		ModelRenderer right_Ear = new ModelRenderer(this);
		right_Ear.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(right_Ear);
		setRotationAngle(right_Ear, 0.0F, 0.6517F, 0.2143F);
		right_Ear.setTextureOffset(6, 13).addBox(-2.2F, -0.6F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		ModelRenderer nose = new ModelRenderer(this);
		nose.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(nose);
		setRotationAngle(nose, 0.0F, 0.0F, 0.0089F);
		nose.setTextureOffset(0, 16).addBox(-0.5F, 0.0F, -3.3F, 1.0F, 1.0F, 2.0F, 0.0F, false);
	}

	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.Left_Leg, this.Right_Leg, this.Torso, this.Left_Arm, this.Right_Arm, this.Head);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Right_Leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		this.Left_Leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
		this.Right_Leg.rotateAngleY = 0.0F;
		this.Left_Leg.rotateAngleY = 0.0F;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}