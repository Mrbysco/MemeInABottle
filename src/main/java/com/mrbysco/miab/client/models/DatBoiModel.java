package com.mrbysco.miab.client.models;

import com.google.common.collect.ImmutableList;
import com.mrbysco.miab.entity.memes.DatBoiEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class DatBoiModel<T extends DatBoiEntity> extends SegmentedModel<T> {
	private final ModelRenderer bipedHead;
	private final ModelRenderer bipedBody;
	private final ModelRenderer bipedLeftArm;
	private final ModelRenderer bipedRightArm;
	private final ModelRenderer RightKnee;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftKnee;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer Bike;
	private final ModelRenderer Saddle;
	private final ModelRenderer Frame;
	private final ModelRenderer FullPedalLeft;
	private final ModelRenderer LeftPeddleScape;
	private final ModelRenderer LeftPaddle;
	private final ModelRenderer FullPeddleRight;
	private final ModelRenderer RightPeddleScape;
	private final ModelRenderer RightPaddle;
	private final ModelRenderer Wheel;

	public DatBoiModel() {
		textureWidth = 64;
		textureHeight = 64;

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, -13.0F, 0.0F);
		bipedHead.setTextureOffset(42, 28).addBox(-3.0F, -6.0F, -6.9F, 6.0F, 2.0F, 5.0F, 0.0F, true);
		bipedHead.setTextureOffset(0, 3).addBox(2.5F, -5.0F, -5.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		bipedHead.setTextureOffset(0, 0).addBox(-3.5F, -5.0F, -5.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		bipedHead.setTextureOffset(1, 19).addBox(-3.0F, -4.0F, -8.0F, 6.0F, 4.0F, 8.0F, 0.0F, true);

		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, 18.0F, 0.0F);
		bipedBody.setTextureOffset(0, 0).addBox(-3.0F, -31.0F, -3.0F, 6.0F, 12.0F, 6.0F, 0.0F, true);
		bipedBody.setTextureOffset(24, 0).addBox(-2.0F, -29.0F, -4.0F, 4.0F, 8.0F, 1.0F, 0.0F, true);
		bipedBody.setTextureOffset(24, 9).addBox(-2.0F, -19.0F, -2.0F, 4.0F, 2.0F, 4.0F, 0.0F, true);

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(-2.0F, -10.0F, 0.0F);
		setRotationAngle(bipedLeftArm, -1.1723F, 0.3562F, -0.2969F);
		bipedLeftArm.setTextureOffset(40, 0).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 12.0F, 2.0F, 0.0F, true);

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(3.0F, -10.0F, 0.0F);
		setRotationAngle(bipedRightArm, -1.1723F, -0.4897F, 0.0F);
		bipedRightArm.setTextureOffset(40, 14).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 12.0F, 2.0F, 0.0F, true);

		RightKnee = new ModelRenderer(this);
		RightKnee.setRotationPoint(3.0F, -1.0F, -1.0F);
		setRotationAngle(RightKnee, 0.266F, 0.0F, 0.4653F);
		RightKnee.setTextureOffset(56, 0).addBox(-6.0F, 1.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, true);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-6.0F, 13.0F, 0.0F);
		RightKnee.addChild(RightLeg);
		setRotationAngle(RightLeg, 0.0F, 0.0F, -0.6981F);
		RightLeg.setTextureOffset(56, 14).addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);

		LeftKnee = new ModelRenderer(this);
		LeftKnee.setRotationPoint(-1.7F, -2.0F, -1.0F);
		setRotationAngle(LeftKnee, -0.1496F, 0.0F, -0.565F);
		LeftKnee.setTextureOffset(48, 0).addBox(2.0F, 2.0F, 0.0F, 2.0F, 12.0F, 2.0F, 0.0F, true);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(2.7F, 13.0F, 1.0F);
		LeftKnee.addChild(LeftLeg);
		setRotationAngle(LeftLeg, -0.2618F, 0.0873F, 0.7854F);
		LeftLeg.setTextureOffset(48, 14).addBox(-0.5F, -0.5F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);

		Bike = new ModelRenderer(this);
		Bike.setRotationPoint(0.0F, 18.0F, 0.0F);
		

		Saddle = new ModelRenderer(this);
		Saddle.setRotationPoint(0.0F, 0.0F, 0.0F);
		Bike.addChild(Saddle);
		Saddle.setTextureOffset(42, 46).addBox(-2.0F, -17.0F, -5.0F, 4.0F, 2.0F, 6.0F, 0.0F, true);
		Saddle.setTextureOffset(40, 40).addBox(-4.0F, -17.0F, 1.0F, 8.0F, 2.0F, 4.0F, 0.0F, true);

		Frame = new ModelRenderer(this);
		Frame.setRotationPoint(0.0F, 0.0F, 0.0F);
		Bike.addChild(Frame);
		Frame.setTextureOffset(0, 46).addBox(-4.0F, -7.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);
		Frame.setTextureOffset(28, 46).addBox(2.0F, -7.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);
		Frame.setTextureOffset(8, 36).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 2.0F, 2.0F, 0.0F, true);
		Frame.setTextureOffset(0, 38).addBox(-1.0F, -15.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);
		Frame.setTextureOffset(36, 54).addBox(-0.5F, 0.6F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, true);
		Frame.setTextureOffset(40, 54).addBox(-0.5F, 0.6F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, true);
		Frame.setTextureOffset(44, 54).addBox(-0.5F, 0.6F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, true);
		Frame.setTextureOffset(48, 54).addBox(-0.5F, 0.6F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, true);
		Frame.setTextureOffset(8, 40).addBox(-5.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, 0.0F, true);

		FullPedalLeft = new ModelRenderer(this);
		FullPedalLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		Frame.addChild(FullPedalLeft);
		

		LeftPeddleScape = new ModelRenderer(this);
		LeftPeddleScape.setRotationPoint(-4.0F, 0.0F, -1.0F);
		FullPedalLeft.addChild(LeftPeddleScape);
		setRotationAngle(LeftPeddleScape, -1.0922F, 0.0F, 0.0F);
		LeftPeddleScape.setTextureOffset(32, 39).addBox(-2.0F, -6.5F, -0.2F, 1.0F, 6.0F, 1.0F, 0.0F, true);

		LeftPaddle = new ModelRenderer(this);
		LeftPaddle.setRotationPoint(-5.4F, -2.2F, 4.9F);
		FullPedalLeft.addChild(LeftPaddle);
		LeftPaddle.setTextureOffset(36, 35).addBox(-2.35F, -1.0F, -2.0F, 4.0F, 1.0F, 3.0F, 0.0F, true);

		FullPeddleRight = new ModelRenderer(this);
		FullPeddleRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		Frame.addChild(FullPeddleRight);
		

		RightPeddleScape = new ModelRenderer(this);
		RightPeddleScape.setRotationPoint(4.0F, 0.0F, -1.0F);
		FullPeddleRight.addChild(RightPeddleScape);
		setRotationAngle(RightPeddleScape, -2.0237F, 0.0F, 0.0F);
		RightPeddleScape.setTextureOffset(36, 39).addBox(1.0F, -1.0F, -0.7F, 1.0F, 6.0F, 1.0F, 0.0F, true);

		RightPaddle = new ModelRenderer(this);
		RightPaddle.setRotationPoint(5.4F, -2.2F, -4.9F);
		FullPeddleRight.addChild(RightPaddle);
		RightPaddle.setTextureOffset(50, 36).addBox(-1.4F, -0.75F, -1.4F, 4.0F, 1.0F, 3.0F, 0.0F, true);

		Wheel = new ModelRenderer(this);
		Wheel.setRotationPoint(0.0F, 0.0F, 0.0F);
		Bike.addChild(Wheel);
		Wheel.setTextureOffset(52, 60).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 3.0F, 0.0F, true);
		Wheel.setTextureOffset(44, 60).addBox(-0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 3.0F, 0.0F, true);
		Wheel.setTextureOffset(40, 60).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, true);
		Wheel.setTextureOffset(36, 60).addBox(-0.5F, 1.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, true);
		Wheel.setTextureOffset(8, 44).addBox(-1.0F, -6.0F, -4.0F, 2.0F, 2.0F, 8.0F, 0.0F, true);
		Wheel.setTextureOffset(8, 54).addBox(-1.0F, 4.0F, -4.0F, 2.0F, 2.0F, 8.0F, 0.0F, true);
		Wheel.setTextureOffset(0, 54).addBox(-1.0F, -4.0F, 4.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
		Wheel.setTextureOffset(28, 54).addBox(-1.0F, -4.0F, -6.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
	}

	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.bipedHead, this.bipedBody, this.bipedLeftArm, this.bipedRightArm, this.RightKnee, this.LeftKnee, this.Bike);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Wheel.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 3F * limbSwingAmount;
		this.Wheel.rotateAngleY = 0.0F;
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}