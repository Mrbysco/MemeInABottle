package com.mrbysco.miab.client.models;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.math.MathHelper;

public class NyanModel<T extends CatEntity> extends AgeableModel<T> {
	private final ModelRenderer nyanBody;
	private final ModelRenderer nyanBackLeftLeg;
	private final ModelRenderer nyanFrontRightLeg;
	private final ModelRenderer nyanTail;
	private final ModelRenderer nyanFrontLeftLeg;
	private final ModelRenderer nyanBackRightLeg;
	private final ModelRenderer nyanhead;
	private int state = 1;

	public NyanModel() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.nyanhead = new ModelRenderer(this);
		this.nyanhead.addBox("main", -2.5F, -2.0F, -2.0F, 5, 4, 5, 0.0F, 0, 0);
		this.nyanhead.addBox("nose", -1.5F, 0.0F, -3.0F, 3, 2, 2, 0.0F, 0, 24);
		this.nyanhead.addBox("ear1", -2.0F, -3.0F, 0.0F, 1, 1, 2, 0.0F, 0, 10);
		this.nyanhead.addBox("ear2", 1.0F, -3.0F, 0.0F, 1, 1, 2, 0.0F, 6, 10);

		this.nyanBody = new ModelRenderer(this, 20, 0);
		this.nyanBody.addBox(-2.0F, 3.0F, -8.0F, 4.0F, 16.0F, 9.0F, 0.0F);
		this.nyanBody.setRotationPoint(0.0F, 12.0F, -10.0F);
		this.nyanTail = new ModelRenderer(this, 0, 15);
		this.nyanTail.addBox(-0.5F, -1.0F, -1.0F, 1, 8, 1, 0.0F);
		this.nyanTail.rotateAngleX = 0.9F;
		this.nyanTail.setRotationPoint(0.0F, 15.0F, 8.0F);
		this.nyanBackLeftLeg = new ModelRenderer(this, 8, 13);
		this.nyanBackLeftLeg.addBox(-1.0F, 0.0F, 1.0F, 2, 6, 2);
		this.nyanBackLeftLeg.setRotationPoint(1.1F, 19.0F, 5.0F);
		this.nyanBackRightLeg = new ModelRenderer(this, 8, 13);
		this.nyanBackRightLeg.addBox(-1.0F, 0.0F, 1.0F, 2, 6, 2);
		this.nyanBackRightLeg.setRotationPoint(-1.1F, 19.0F, 5.0F);
		this.nyanFrontLeftLeg = new ModelRenderer(this, 48, 0);
		this.nyanFrontLeftLeg.addBox(-1.0F, 0.0F, 0.0F, 2, 10, 2);
		this.nyanFrontLeftLeg.setRotationPoint(1.2F, 19.0F, -5.0F);
		this.nyanFrontRightLeg = new ModelRenderer(this, 48, 0);
		this.nyanFrontRightLeg.addBox(-1.0F, 0.0F, 0.0F, 2, 10, 2);
		this.nyanFrontRightLeg.setRotationPoint(-1.2F, 19.0F, -5.0F);
	}

	protected Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.nyanhead);
	}

	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.nyanBody, this.nyanBackLeftLeg, this.nyanBackRightLeg, this.nyanFrontLeftLeg, this.nyanFrontRightLeg, this.nyanTail);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.nyanhead.rotateAngleX = headPitch * 0.017453292F;
		this.nyanhead.rotateAngleY = netHeadYaw * 0.017453292F;

		if (this.state != 3) {
			this.nyanBody.rotateAngleX = ((float)Math.PI / 2F);
			this.nyanFrontLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
			this.nyanBackRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
			this.nyanFrontLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
			this.nyanBackRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
		}
	}

	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		this.nyanBody.rotationPointY = 12.0F;
		this.nyanBody.rotationPointZ = -10.0F;
		this.nyanhead.rotationPointY = 15.0F;
		this.nyanhead.rotationPointZ = -9.0F;
		this.nyanTail.rotationPointY = 15.0F;
		this.nyanTail.rotationPointZ = 8.0F;
		this.nyanFrontLeftLeg.rotationPointY = 13.8F;
		this.nyanFrontLeftLeg.rotationPointZ = -5.0F;
		this.nyanFrontRightLeg.rotationPointY = 13.8F;
		this.nyanFrontRightLeg.rotationPointZ = -5.0F;
		this.nyanBackLeftLeg.rotationPointY = 18.0F;
		this.nyanBackLeftLeg.rotationPointZ = 5.0F;
		this.nyanBackRightLeg.rotationPointY = 18.0F;
		this.nyanBackRightLeg.rotationPointZ = 5.0F;
		this.nyanTail.rotateAngleX = 0.9F;
		this.state = 2;
	}
}