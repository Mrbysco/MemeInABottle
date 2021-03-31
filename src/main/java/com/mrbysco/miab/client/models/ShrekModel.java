package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.AbstractMeme;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ShrekModel<T extends AbstractMeme> extends HumanBaseModel<T> {
	private final ModelRenderer earLeft;
	private final ModelRenderer earRight;

	public ShrekModel() {
		textureWidth = 64;
		textureHeight = 64;

		bipedLeftLeg = new ModelRenderer(this);
		bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.1F);
		bipedLeftLeg.setTextureOffset(47, 35).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, true);

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, true);

		earLeft = new ModelRenderer(this);
		earLeft.setRotationPoint(0.0F, 24.0F, 0.0F);
		bipedHead.addChild(earLeft);
		setRotationAngle(earLeft, 0.0F, 0.0F, 0.1396F);
		earLeft.setTextureOffset(32, 0).addBox(-10.25F, -32.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		earLeft.setTextureOffset(32, 4).addBox(-11.25F, -32.5F, -1.5F, 1.0F, 3.0F, 3.0F, 0.0F, true);

		earRight = new ModelRenderer(this);
		earRight.setRotationPoint(0.0F, 24.0F, 0.0F);
		bipedHead.addChild(earRight);
		setRotationAngle(earRight, 0.0F, 0.0F, -0.1396F);
		earRight.setTextureOffset(42, 0).addBox(8.25F, -32.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		earRight.setTextureOffset(42, 4).addBox(10.25F, -32.5F, -1.5F, 1.0F, 3.0F, 3.0F, 0.0F, true);

		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.setTextureOffset(16, 16).addBox(-4.0F, -2.0F, -3.5F, 8.0F, 10.0F, 7.0F, 0.0F, true);
		bipedBody.setTextureOffset(17, 33).addBox(-4.0F, 8.0F, -3.0F, 8.0F, 4.0F, 6.0F, 0.0F, true);

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		bipedRightArm.setTextureOffset(0, 16).addBox(-3.0F, -4.0F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, true);

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		bipedLeftArm.setTextureOffset(47, 16).addBox(-1.0F, -4.0F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, true);

		bipedRightLeg = new ModelRenderer(this);
		bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.1F);
		bipedRightLeg.setTextureOffset(0, 35).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, true);

		bipedHeadwear = new ModelRenderer(this);
	}
}