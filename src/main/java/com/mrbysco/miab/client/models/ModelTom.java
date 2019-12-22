package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.memes.EntityChocolateGuy;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

public class ModelTom<T extends EntityChocolateGuy> extends ModelHumanBase<T> {
	public ModelTom() {
		textureWidth = 64;
		textureHeight = 64;

		bipedHeadwear = new RendererModel(this);
		bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHeadwear.cubeList.add(new ModelBox(bipedHeadwear, 32, 0, -4.0F, -3.0F, -3.0F, 8, 8, 6, 0.0F, false));

		bipedHead = new RendererModel(this);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.cubeList.add(new ModelBox(bipedHead, 2, 2, -4.0F, -3.0F, -3.0F, 8, 8, 6, 0.0F, false));
		bipedHead.cubeList.add(new ModelBox(bipedHead, 2, 32, 0.25F, -2.0F, 3.0F, 0, 6, 2, 0.0F, false));

		bipedBody = new RendererModel(this);
		bipedBody.setRotationPoint(0.0F, 5.0F, 0.0F);
		bipedBody.cubeList.add(new ModelBox(bipedBody, 16, 16, -4.0F, 0.0F, -2.0F, 8, 10, 4, 0.0F, false));
		bipedBody.cubeList.add(new ModelBox(bipedBody, 0, 32, 0.25F, 6.0F, 2.0F, 0, 4, 2, 0.0F, false));

		bipedRightArm = new RendererModel(this);
		bipedRightArm.setRotationPoint(-5.0F, 5.0F, 0.0F);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 40, 16, -3.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F, false));

		bipedLeftArm = new RendererModel(this);
		bipedLeftArm.setRotationPoint(5.0F, 5.0F, 0.0F);
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 40, 16, -1.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F, true));

		bipedRightLeg = new RendererModel(this);
		bipedRightLeg.setRotationPoint(-1.9F, 16.0F, 0.1F);
		bipedRightLeg.cubeList.add(new ModelBox(bipedRightLeg, 0, 16, -2.0F, -1.0F, -2.0F, 4, 9, 4, 0.0F, false));

		bipedLeftLeg = new RendererModel(this);
		bipedLeftLeg.setRotationPoint(1.9F, 16.0F, 0.1F);
		bipedLeftLeg.cubeList.add(new ModelBox(bipedLeftLeg, 0, 16, -2.0F, -1.0F, -2.0F, 4, 9, 4, 0.0F, true));
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
		if (this.isSneak)
		{
			this.bipedBody.rotateAngleX = 0.5F;
			this.bipedRightArm.rotateAngleX += 0.4F;
			this.bipedLeftArm.rotateAngleX += 0.4F;
			this.bipedRightLeg.rotationPointZ = 4.0F;
			this.bipedLeftLeg.rotationPointZ = 4.0F;
			this.bipedRightLeg.rotationPointY = 9.0F;
			this.bipedLeftLeg.rotationPointY = 9.0F;
			this.bipedHead.rotationPointY = 1.0F;
		}
		else
		{
			this.bipedBody.rotateAngleX = 0.0F;
			this.bipedRightLeg.rotationPointZ = 0.1F;
			this.bipedLeftLeg.rotationPointZ = 0.1F;
			this.bipedRightLeg.rotationPointY = 16.0F;
			this.bipedLeftLeg.rotationPointY = 16.0F;
			this.bipedHead.rotationPointY = 0.0F;
		}

		if(entityIn.isFollowingPlayer() || entityIn.getAttackTarget() != null) {
			this.bipedRightArm.rotationPointZ = 0.0F;
			this.bipedRightArm.rotationPointX = -5.0F;
			this.bipedLeftArm.rotationPointZ = 0.0F;
			this.bipedLeftArm.rotationPointX = 5.0F;
			this.bipedRightArm.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 0.25F;
			this.bipedLeftArm.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 0.25F;
			this.bipedRightArm.rotateAngleZ = 2.3561945F;
			this.bipedLeftArm.rotateAngleZ = -2.3561945F;
			this.bipedRightArm.rotateAngleY = 0.0F;
			this.bipedLeftArm.rotateAngleY = 0.0F;
		}
	}
}