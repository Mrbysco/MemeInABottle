package com.mrbysco.miab.client.models;

import com.google.common.collect.ImmutableList;
import com.mrbysco.miab.entity.memes.BongoCatEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class BongoCatModel<T extends BongoCatEntity> extends SegmentedModel<T> {
	private final ModelRenderer bipedHead;
	private final ModelRenderer RightEar;
	private final ModelRenderer LeftEar;
	private final ModelRenderer bipedLeftLeg;
	private final ModelRenderer bipedLeftArm;
	private final ModelRenderer bipedRightLeg;
	private final ModelRenderer bipedRightArm;
	private final ModelRenderer bipedBody;

	public BongoCatModel() {
		textureWidth = 64;
		textureHeight = 64;

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(-1.0F, 12.0F, 0.0F);
		bipedHead.setTextureOffset(1, 6).addBox(-2.0F, -6.0F, -2.0F, 6.0F, 6.0F, 4.0F, 0.0F, true);

		RightEar = new ModelRenderer(this);
		RightEar.setRotationPoint(3.0F, -7.7F, -1.0F);
		bipedHead.addChild(RightEar);
		setRotationAngle(RightEar, 0.0F, 0.0F, 0.5236F);
		RightEar.setTextureOffset(10, 0).addBox(-3.5F, 2.0F, 0.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		LeftEar = new ModelRenderer(this);
		LeftEar.setRotationPoint(-1.0F, -7.7F, -1.02F);
		bipedHead.addChild(LeftEar);
		setRotationAngle(LeftEar, 0.0F, 0.0F, 1.0472F);
		LeftEar.setTextureOffset(0, 0).addBox(2.0F, -3.5F, 0.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		bipedLeftLeg = new ModelRenderer(this);
		bipedLeftLeg.setRotationPoint(1.0F, 18.0F, 0.1F);
		bipedLeftLeg.setTextureOffset(0, 16).addBox(-1.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, true);

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(4.0F, 14.0F, 0.0F);
		setRotationAngle(bipedLeftArm, -2.0944F, 0.1F, 0.1F);
		bipedLeftArm.setTextureOffset(40, 16).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 6.0F, 3.0F, 0.0F, true);

		bipedRightLeg = new ModelRenderer(this);
		bipedRightLeg.setRotationPoint(-2.0F, 18.0F, 0.1F);
		bipedRightLeg.setTextureOffset(0, 16).addBox(-1.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, false);

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-4.0F, 14.0F, 0.0F);
		setRotationAngle(bipedRightArm, -2.0944F, -0.1F, -0.1F);
		bipedRightArm.setTextureOffset(40, 16).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);

		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, 12.0F, 0.0F);
		bipedBody.setTextureOffset(16, 16).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 6.0F, 4.0F, 0.0F, true);
	}

	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.bipedHead, this.bipedLeftLeg, this.bipedRightLeg, this.bipedLeftArm, this.bipedRightArm, this.bipedBody);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.bipedRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		this.bipedLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
		this.bipedRightLeg.rotateAngleY = 0.0F;
		this.bipedLeftLeg.rotateAngleY = 0.0F;

		boolean flag = entityIn.isTapping();
		float f = MathHelper.sin(this.swingProgress * (float)Math.PI);
		float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
		this.bipedRightArm.rotateAngleZ = 0.0F;
		this.bipedLeftArm.rotateAngleZ = 0.0F;
		this.bipedRightArm.rotateAngleY = -(0.1F - f * 0.6F);
		this.bipedLeftArm.rotateAngleY = 0.1F - f * 0.6F;
		float f2 = -(float)Math.PI / (1.5F);
		this.bipedRightArm.rotateAngleX = f2;
		this.bipedLeftArm.rotateAngleX = f2;

		//clap?
		float f3 = (flag ? ((MathHelper.cos(ageInTicks)) * 0.4F) : 0.0F);
		this.bipedRightArm.rotateAngleX += f3;
		this.bipedLeftArm.rotateAngleX += -f3;

		this.bipedRightArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
		this.bipedLeftArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
		this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}