package com.mrbysco.miab.client.models;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;

public class ModelHotDog extends ModelHumanBase {
	private final ModelRenderer Headset;
	private final ModelRenderer HeadsetRight;
	private final ModelRenderer HeadsetLeft;
	private final ModelRenderer bipedLeftFoot;
	private final ModelRenderer bipedLeftLeg2;
	private final ModelRenderer bipedRightLeg2;
	private final ModelRenderer bipedRightFoot;

	public ModelHotDog() {
		textureWidth = 64;
		textureHeight = 64;

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
		bipedHead.cubeList.add(new ModelBox(bipedHead, 0, 5, -3.0F, -6.0F, -2.0F, 7, 6, 4, 0.0F, true));
		bipedHead.cubeList.add(new ModelBox(bipedHead, 2, 0, -1.9F, -7.0F, -2.0F, 5, 1, 4, 0.0F, true));

		Headset = new ModelRenderer(this);
		Headset.setRotationPoint(0.0F, 23.0F, 0.0F);
		bipedHead.addChild(Headset);
		Headset.cubeList.add(new ModelBox(Headset, 54, 58, -4.8F, -29.4F, -1.5F, 2, 3, 3, 0.0F, true));
		Headset.cubeList.add(new ModelBox(Headset, 44, 58, 3.8F, -29.4F, -1.5F, 2, 3, 3, 0.0F, true));
		Headset.cubeList.add(new ModelBox(Headset, 32, 55, -2.9F, -31.4F, -0.5F, 7, 1, 1, 0.0F, true));

		HeadsetRight = new ModelRenderer(this);
		HeadsetRight.setRotationPoint(1.0F, -29.4F, 0.5F);
		setRotationAngle(HeadsetRight, 0.0F, 0.0F, -0.9425F);
		Headset.addChild(HeadsetRight);
		HeadsetRight.cubeList.add(new ModelBox(HeadsetRight, 56, 55, -3.7F, -4.5F, -1.0F, 3, 1, 1, 0.0F, true));

		HeadsetLeft = new ModelRenderer(this);
		HeadsetLeft.setRotationPoint(1.0F, -29.4F, 0.5F);
		setRotationAngle(HeadsetLeft, 0.0F, 0.0F, 0.9425F);
		Headset.addChild(HeadsetLeft);
		HeadsetLeft.cubeList.add(new ModelBox(HeadsetLeft, 48, 55, 0.15F, -3.7F, -1.0F, 3, 1, 1, 0.0F, true));

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		setRotationAngle(bipedRightArm, -1.3963F, -0.1F, -0.1F);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 22, 0, -2.0F, -2.0F, -2.0F, 3, 8, 3, 0.0F, false));

		bipedLeftLeg = new ModelRenderer(this);
		bipedLeftLeg.setRotationPoint(1.9F, 14.0F, 1.1F);
		bipedLeftLeg.cubeList.add(new ModelBox(bipedLeftLeg, 12, 48, -1.0F, 0.2F, -2.6F, 3, 3, 3, 0.0F, true));

		bipedLeftFoot = new ModelRenderer(this);
		bipedLeftFoot.setRotationPoint(0.7F, 10.2F, -0.2F);
		setRotationAngle(bipedLeftFoot, 0.2618F, 0.1222F, -0.0175F);
		bipedLeftLeg.addChild(bipedLeftFoot);
		bipedLeftFoot.cubeList.add(new ModelBox(bipedLeftFoot, 42, 48, -2.0F, -1.9F, -1.2F, 4, 2, 4, 0.0F, true));

		bipedLeftLeg2 = new ModelRenderer(this);
		bipedLeftLeg2.setRotationPoint(0.2F, 3.6F, -0.7F);
		setRotationAngle(bipedLeftLeg2, 0.2618F, 0.1222F, 0.0F);
		bipedLeftLeg.addChild(bipedLeftLeg2);
		bipedLeftLeg2.cubeList.add(new ModelBox(bipedLeftLeg2, 12, 55, -1.0F, -1.0F, -2.0F, 3, 6, 3, 0.0F, true));

		bipedRightLeg = new ModelRenderer(this);
		bipedRightLeg.setRotationPoint(-1.9F, 14.0F, 1.1F);
		bipedRightLeg.cubeList.add(new ModelBox(bipedRightLeg, 0, 48, -1.1F, 0.2F, -2.6F, 3, 3, 3, 0.0F, false));

		bipedRightLeg2 = new ModelRenderer(this);
		bipedRightLeg2.setRotationPoint(-0.2F, 3.6F, -0.7F);
		setRotationAngle(bipedRightLeg2, 0.2618F, -0.1222F, 0.0F);
		bipedRightLeg.addChild(bipedRightLeg2);
		bipedRightLeg2.cubeList.add(new ModelBox(bipedRightLeg2, 0, 55, -1.0F, -1.0F, -2.0F, 3, 6, 3, 0.0F, true));

		bipedRightFoot = new ModelRenderer(this);
		bipedRightFoot.setRotationPoint(4.7F, 10.2F, 0.2F);
		setRotationAngle(bipedRightFoot, 0.2618F, -0.1222F, 0.0175F);
		bipedRightLeg.addChild(bipedRightFoot);
		bipedRightFoot.cubeList.add(new ModelBox(bipedRightFoot, 26, 48, -6.3F, -1.9F, -1.0F, 4, 2, 4, 0.0F, true));

		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, -5.0F, 0.0F);
		bipedBody.cubeList.add(new ModelBox(bipedBody, 22, 11, -3.0F, 6.0F, -2.0F, 7, 13, 4, 0.0F, true));
		bipedBody.cubeList.add(new ModelBox(bipedBody, 12, 28, 4.0F, 3.5F, -2.0F, 2, 16, 4, 0.0F, true));
		bipedBody.cubeList.add(new ModelBox(bipedBody, 0, 28, -5.0F, 3.5F, -2.0F, 2, 16, 4, 0.0F, true));
		bipedBody.cubeList.add(new ModelBox(bipedBody, 24, 30, -3.0F, 3.5F, 2.0F, 7, 16, 2, 0.0F, true));

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		setRotationAngle(bipedLeftArm, -1.3963F, 0.1F, 0.1F);
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 34, 0, 0.0F, -2.0F, -2.0F, 3, 8, 3, 0.0F, true));

		bipedHeadwear = new ModelRenderer(this);
		bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);

	}
}