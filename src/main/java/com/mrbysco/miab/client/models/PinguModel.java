package com.mrbysco.miab.client.models;

import com.google.common.collect.ImmutableList;
import com.mrbysco.miab.entity.memes.PinguEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class PinguModel<T extends PinguEntity> extends SegmentedModel<T> {
	private final ModelRenderer Body;
	private final ModelRenderer Body2;
	private final ModelRenderer ArmLeft;
	private final ModelRenderer ArmRight;
	private final ModelRenderer Head;
	private final ModelRenderer Mouth;
	private final ModelRenderer FeetLeft;
	private final ModelRenderer FeetRight;

	public PinguModel() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 18.5F, 0.0F);
		Body.setTextureOffset(0, 24).addBox(-3.0F, -4.5F, -3.0F, 6.0F, 9.0F, 5.0F, 0.0F, false);

		Body2 = new ModelRenderer(this);
		Body2.setRotationPoint(0.0F, 0.0F, -4.0F);
		Body.addChild(Body2);
		Body2.setTextureOffset(24, 30).addBox(-2.5F, -3.5F, 0.6F, 5.0F, 7.0F, 1.0F, 0.0F, false);

		ArmLeft = new ModelRenderer(this);
		ArmLeft.setRotationPoint(3.5F, 14.0F, -0.5F);
		ArmLeft.setTextureOffset(0, 38).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);

		ArmRight = new ModelRenderer(this);
		ArmRight.setRotationPoint(-3.5F, 14.0F, -0.5F);
		ArmRight.setTextureOffset(0, 38).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, true);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 14.5F, -0.5F);
		Head.setTextureOffset(0, 0).addBox(-2.0F, -4.5F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		Mouth = new ModelRenderer(this);
		Mouth.setRotationPoint(0.0F, -2.0F, -2.5F);
		Head.addChild(Mouth);
		Mouth.setTextureOffset(12, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		FeetLeft = new ModelRenderer(this);
		FeetLeft.setRotationPoint(-1.5F, 23.0F, -1.0F);
		FeetLeft.setTextureOffset(0, 10).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		FeetRight = new ModelRenderer(this);
		FeetRight.setRotationPoint(1.5F, 23.0F, -1.0F);
		FeetRight.setTextureOffset(0, 10).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 1.0F, 5.0F, 0.0F, true);
	}

	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.Body, this.ArmLeft, this.ArmRight, this.Head, this.FeetLeft, this.FeetRight);
	}

	protected Iterable<ModelRenderer> getHead() {
		return ImmutableList.of(this.Head);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.FeetRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		this.FeetLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
		this.FeetRight.rotateAngleY = 0.0F;
		this.FeetLeft.rotateAngleY = 0.0F;

		if (entityIn.isAggressive()) {
			float f = MathHelper.sin(this.swingProgress * (float)Math.PI);
			float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
			this.ArmRight.rotateAngleZ = 0.0F;
			this.ArmLeft.rotateAngleZ = 0.0F;
			this.ArmRight.rotateAngleY = -(0.1F - f * 0.6F);
			this.ArmLeft.rotateAngleY = 0.1F - f * 0.6F;
			this.ArmRight.rotateAngleX = -((float)Math.PI / 2F);
			this.ArmLeft.rotateAngleX = -((float)Math.PI / 2F);
			this.ArmRight.rotateAngleX -= f * 1.2F - f1 * 0.4F;
			this.ArmLeft.rotateAngleX -= f * 1.2F - f1 * 0.4F;
			this.ArmRight.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
			this.ArmLeft.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
			this.ArmRight.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
			this.ArmLeft.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		}
	}
}