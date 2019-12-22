package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.memes.EntityBongoCat;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

public class ModelBongoCat<T extends EntityBongoCat> extends EntityModel<T> {
	private final RendererModel bipedHead;
	private final RendererModel RightEar;
	private final RendererModel LeftEar;
	private final RendererModel bipedLeftLeg;
	private final RendererModel bipedLeftArm;
	private final RendererModel bipedRightLeg;
	private final RendererModel bipedRightArm;
	private final RendererModel bipedBody;

	public ModelBongoCat() {
		textureWidth = 64;
		textureHeight = 64;

		bipedLeftLeg = new RendererModel(this);
		bipedLeftLeg.setRotationPoint(1.0F, 18.0F, 0.1F);
		bipedLeftLeg.cubeList.add(new ModelBox(bipedLeftLeg, 0, 16, -1.0F, 0.0F, -1.5F, 3, 6, 3, 0.0F, true));

		bipedLeftArm = new RendererModel(this);
		bipedLeftArm.setRotationPoint(4.0F, 14.0F, 0.0F);
		setRotationAngle(bipedLeftArm, -2.0944F, 0.1F, 0.1F);
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 40, 16, -1.0F, -2.0F, -2.0F, 3, 6, 3, 0.0F, true));

		bipedRightLeg = new RendererModel(this);
		bipedRightLeg.setRotationPoint(-2.0F, 18.0F, 0.1F);
		bipedRightLeg.cubeList.add(new ModelBox(bipedRightLeg, 0, 16, -1.0F, 0.0F, -1.5F, 3, 6, 3, 0.0F, false));

		bipedRightArm = new RendererModel(this);
		bipedRightArm.setRotationPoint(-4.0F, 14.0F, 0.0F);
		setRotationAngle(bipedRightArm, -2.0944F, -0.1F, -0.1F);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 40, 16, -2.0F, -2.0F, -2.0F, 3, 6, 3, 0.0F, false));

		bipedHead = new RendererModel(this);
		bipedHead.setRotationPoint(-1.0F, 12.0F, 0.0F);
		bipedHead.cubeList.add(new ModelBox(bipedHead, 1, 6, -2.0F, -6.0F, -2.0F, 6, 6, 4, 0.0F, true));

		RightEar = new RendererModel(this);
		RightEar.setRotationPoint(3.0F, -7.7F, -1.0F);
		setRotationAngle(RightEar, 0.0F, 0.0F, 0.5236F);
		bipedHead.addChild(RightEar);
		RightEar.cubeList.add(new ModelBox(RightEar, 10, 0, -3.5F, 2.0F, 0.0F, 3, 2, 2, 0.0F, false));

		LeftEar = new RendererModel(this);
		LeftEar.setRotationPoint(-1.0F, -7.7F, -1.02F);
		setRotationAngle(LeftEar, 0.0F, 0.0F, 1.0472F);
		bipedHead.addChild(LeftEar);
		LeftEar.cubeList.add(new ModelBox(LeftEar, 0, 0, 2.0F, -3.5F, 0.0F, 2, 3, 2, 0.0F, false));

		bipedBody = new RendererModel(this);
		bipedBody.setRotationPoint(0.0F, 12.0F, 0.0F);
		bipedBody.cubeList.add(new ModelBox(bipedBody, 16, 16, -3.0F, 0.0F, -2.0F, 6, 6, 4, 0.0F, true));
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
		this.bipedRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		this.bipedLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
		this.bipedRightLeg.rotateAngleY = 0.0F;
		this.bipedLeftLeg.rotateAngleY = 0.0F;

		EntityBongoCat cat = (EntityBongoCat) entityIn;
		boolean flag = cat.isTapping();
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
		float f3 = (flag ? ((MathHelper.cos(ageInTicks * 1F)) * 0.4F) : 0.0F);
		this.bipedRightArm.rotateAngleX += f3;
		this.bipedLeftArm.rotateAngleX += -f3;

		this.bipedRightArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
		this.bipedLeftArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
		this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	}

	public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
		RendererModel.rotateAngleX = x;
		RendererModel.rotateAngleY = y;
		RendererModel.rotateAngleZ = z;
	}
}