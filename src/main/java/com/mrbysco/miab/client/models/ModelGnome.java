package com.mrbysco.miab.client.models;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;

public class ModelGnome extends ModelHumanBase {
	private final ModelRenderer bipedRightFoot;
	private final ModelRenderer bipedLeftFoot;
	private final ModelRenderer Beard;
	private final ModelRenderer RightEar;
	private final ModelRenderer Hat;
	private final ModelRenderer HatTop;
	private final ModelRenderer LeftEar;
	private final ModelRenderer Nose;

	public ModelGnome() {
		textureWidth = 64;
		textureHeight = 64;

		bipedRightLeg = new ModelRenderer(this);
		bipedRightLeg.setRotationPoint(-1.5F, 18.0F, 0.0F);
		bipedRightLeg.cubeList.add(new ModelBox(bipedRightLeg, 0, 32, -1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F, true));

		bipedRightFoot = new ModelRenderer(this);
		bipedRightFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedRightLeg.addChild(bipedRightFoot);
		bipedRightFoot.cubeList.add(new ModelBox(bipedRightFoot, 0, 39, -1.5F, 4.0F, -2.5F, 3, 2, 4, 0.0F, true));

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(4.0F, 11.0F, 0.0F);
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 36, 32, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, true));

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-4.0F, 11.0F, 0.0F);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 28, 32, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, true));

		bipedLeftLeg = new ModelRenderer(this);
		bipedLeftLeg.setRotationPoint(1.5F, 18.0F, 0.0F);
		bipedLeftLeg.cubeList.add(new ModelBox(bipedLeftLeg, 14, 32, -1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F, true));

		bipedLeftFoot = new ModelRenderer(this);
		bipedLeftFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedLeftLeg.addChild(bipedLeftFoot);
		bipedLeftFoot.cubeList.add(new ModelBox(bipedLeftFoot, 14, 39, -1.5F, 4.0F, -2.5F, 3, 2, 4, 0.0F, true));

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, 9.0F, 0.0F);
		bipedHead.cubeList.add(new ModelBox(bipedHead, 0, 0, -2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F, true));

		bipedHeadwear = new ModelRenderer(this);
		bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);

		Beard = new ModelRenderer(this);
		Beard.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Beard);
		Beard.cubeList.add(new ModelBox(Beard, 0, 8, -2.5F, 1.0F, -2.5F, 5, 2, 3, 0.0F, true));

		RightEar = new ModelRenderer(this);
		RightEar.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightEar, 0.0F, 0.6517F, -0.2143F);
		bipedHead.addChild(RightEar);
		RightEar.cubeList.add(new ModelBox(RightEar, 0, 13, -2.2F, -0.6F, -2.0F, 2, 2, 1, 0.0F, true));

		Hat = new ModelRenderer(this);
		Hat.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(Hat, -0.1607F, 0.0F, 0.0F);
		bipedHead.addChild(Hat);
		Hat.cubeList.add(new ModelBox(Hat, 16, 0, -2.5F, -4.2F, -2.5F, 5, 3, 5, 0.0F, true));

		HatTop = new ModelRenderer(this);
		HatTop.setRotationPoint(0.0F, -2.6F, -0.2F);
		setRotationAngle(HatTop, -0.2588F, 0.0F, 0.0F);
		Hat.addChild(HatTop);
		HatTop.cubeList.add(new ModelBox(HatTop, 36, 0, -2.0F, -2.6F, -1.8F, 4, 2, 4, 0.0F, true));

		LeftEar = new ModelRenderer(this);
		LeftEar.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftEar, 0.0F, -0.6517F, 0.2143F);
		bipedHead.addChild(LeftEar);
		LeftEar.cubeList.add(new ModelBox(LeftEar, 6, 13, 0.2F, -0.6F, -2.0F, 2, 2, 1, 0.0F, true));

		Nose = new ModelRenderer(this);
		Nose.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(Nose, 0.0F, 0.0F, 0.0089F);
		bipedHead.addChild(Nose);
		Nose.cubeList.add(new ModelBox(Nose, 0, 16, -0.5F, 0.0F, -3.3F, 1, 1, 2, 0.0F, true));

		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, 14.5F, 0.0F);
		bipedBody.cubeList.add(new ModelBox(bipedBody, 0, 21, -3.0F, -3.5F, -2.0F, 6, 7, 4, 0.0F, true));
	}
}