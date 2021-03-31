package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.AbstractMeme;
import net.minecraft.client.renderer.model.ModelRenderer;

public class HotDogModel<T extends AbstractMeme> extends HumanBaseModel<T> {

	public HotDogModel() {
		super();
		textureWidth = 64;
		textureHeight = 64;

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
		bipedHead.setTextureOffset(0, 5).addBox(-3.0F, -6.0F, -2.0F, 7.0F, 6.0F, 4.0F, 0.0F, true);
		bipedHead.setTextureOffset(2, 0).addBox(-1.9F, -7.0F, -2.0F, 5.0F, 1.0F, 4.0F, 0.0F, true);

		ModelRenderer headset = new ModelRenderer(this);
		headset.setRotationPoint(0.0F, 23.0F, 0.0F);
		bipedHead.addChild(headset);
		headset.setTextureOffset(54, 58).addBox(-4.8F, -29.4F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, true);
		headset.setTextureOffset(44, 58).addBox(3.8F, -29.4F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, true);
		headset.setTextureOffset(32, 55).addBox(-2.9F, -31.4F, -0.5F, 7.0F, 1.0F, 1.0F, 0.0F, true);

		ModelRenderer headsetRight = new ModelRenderer(this);
		headsetRight.setRotationPoint(1.0F, -29.4F, 0.5F);
		headset.addChild(headsetRight);
		setRotationAngle(headsetRight, 0.0F, 0.0F, -0.9425F);
		headsetRight.setTextureOffset(56, 55).addBox(-3.7F, -4.5F, -1.0F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		ModelRenderer headsetLeft = new ModelRenderer(this);
		headsetLeft.setRotationPoint(1.0F, -29.4F, 0.5F);
		headset.addChild(headsetLeft);
		setRotationAngle(headsetLeft, 0.0F, 0.0F, 0.9425F);
		headsetLeft.setTextureOffset(48, 55).addBox(0.15F, -3.7F, -1.0F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		bipedHeadwear = new ModelRenderer(this);
		bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);


		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.5F, 1.0F, 0.0F);
		bipedBody.setTextureOffset(22, 11).addBox(-3.5F, 0.0F, -2.0F, 7.0F, 13.0F, 4.0F, 0.0F, true);
		bipedBody.setTextureOffset(12, 28).addBox(3.5F, -2.5F, -2.0F, 2.0F, 16.0F, 4.0F, 0.0F, true);
		bipedBody.setTextureOffset(0, 28).addBox(-5.5F, -2.5F, -2.0F, 2.0F, 16.0F, 4.0F, 0.0F, true);
		bipedBody.setTextureOffset(24, 30).addBox(-3.5F, -2.5F, 2.0F, 7.0F, 16.0F, 2.0F, 0.0F, true);

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		setRotationAngle(bipedRightArm, -1.3963F, -0.1F, -0.1F);
		bipedRightArm.setTextureOffset(22, 0).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		setRotationAngle(bipedLeftArm, -1.3963F, 0.1F, 0.1F);
		bipedLeftArm.setTextureOffset(34, 0).addBox(0.0F, -2.0F, -2.0F, 3.0F, 8.0F, 3.0F, 0.0F, true);

		bipedRightLeg = new ModelRenderer(this);
		bipedRightLeg.setRotationPoint(-1.9F, 14.0F, 1.1F);
		bipedRightLeg.setTextureOffset(0, 48).addBox(-1.1F, 0.2F, -2.6F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		ModelRenderer bipedRightLeg2 = new ModelRenderer(this);
		bipedRightLeg2.setRotationPoint(-0.2F, 3.6F, -0.7F);
		bipedRightLeg.addChild(bipedRightLeg2);
		setRotationAngle(bipedRightLeg2, 0.2618F, -0.1222F, 0.0F);
		bipedRightLeg2.setTextureOffset(0, 55).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 6.0F, 3.0F, 0.0F, true);

		ModelRenderer bipedRightFoot = new ModelRenderer(this);
		bipedRightFoot.setRotationPoint(4.7F, 10.2F, 0.2F);
		bipedRightLeg.addChild(bipedRightFoot);
		setRotationAngle(bipedRightFoot, 0.2618F, -0.1222F, 0.0175F);
		bipedRightFoot.setTextureOffset(26, 48).addBox(-6.3F, -1.9F, -1.0F, 4.0F, 2.0F, 4.0F, 0.0F, true);

		bipedLeftLeg = new ModelRenderer(this);
		bipedLeftLeg.setRotationPoint(1.9F, 14.0F, 1.1F);
		bipedLeftLeg.setTextureOffset(12, 48).addBox(-1.0F, 0.2F, -2.6F, 3.0F, 3.0F, 3.0F, 0.0F, true);

		ModelRenderer bipedLeftFoot = new ModelRenderer(this);
		bipedLeftFoot.setRotationPoint(0.7F, 10.2F, -0.2F);
		bipedLeftLeg.addChild(bipedLeftFoot);
		setRotationAngle(bipedLeftFoot, 0.2618F, 0.1222F, -0.0175F);
		bipedLeftFoot.setTextureOffset(42, 48).addBox(-2.0F, -1.9F, -1.2F, 4.0F, 2.0F, 4.0F, 0.0F, true);

		ModelRenderer bipedLeftLeg2 = new ModelRenderer(this);
		bipedLeftLeg2.setRotationPoint(0.2F, 3.6F, -0.7F);
		bipedLeftLeg.addChild(bipedLeftLeg2);
		setRotationAngle(bipedLeftLeg2, 0.2618F, 0.1222F, 0.0F);
		bipedLeftLeg2.setTextureOffset(12, 55).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 6.0F, 3.0F, 0.0F, true);
	}
}