package com.mrbysco.miab.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelDatBoi extends ModelBase {
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

	public ModelDatBoi() {
		textureWidth = 64;
		textureHeight = 64;

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, -13.0F, 0.0F);
		bipedHead.cubeList.add(new ModelBox(bipedHead, 42, 28, -3.0F, -6.0F, -6.9F, 6, 2, 5, 0.0F, true));
		bipedHead.cubeList.add(new ModelBox(bipedHead, 0, 3, 2.5F, -5.0F, -5.5F, 1, 1, 1, 0.0F, true));
		bipedHead.cubeList.add(new ModelBox(bipedHead, 0, 0, -3.5F, -5.0F, -5.5F, 1, 1, 1, 0.0F, true));
		bipedHead.cubeList.add(new ModelBox(bipedHead, 1, 19, -3.0F, -4.0F, -8.0F, 6, 4, 8, 0.0F, true));

		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, 18.0F, 0.0F);
		bipedBody.cubeList.add(new ModelBox(bipedBody, 0, 0, -3.0F, -31.0F, -3.0F, 6, 12, 6, 0.0F, true));
		bipedBody.cubeList.add(new ModelBox(bipedBody, 24, 0, -2.0F, -29.0F, -4.0F, 4, 8, 1, 0.0F, true));
		bipedBody.cubeList.add(new ModelBox(bipedBody, 24, 9, -2.0F, -19.0F, -2.0F, 4, 2, 4, 0.0F, true));

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(-2.0F, -10.0F, 0.0F);
		setRotationAngle(bipedLeftArm, -1.1723F, 0.3562F, -0.2969F);
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 40, 0, -2.0F, 0.0F, -2.0F, 2, 12, 2, 0.0F, true));

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(3.0F, -10.0F, 0.0F);
		setRotationAngle(bipedRightArm, -1.1723F, -0.4897F, 0.0F);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 40, 14, -2.0F, 0.0F, -2.0F, 2, 12, 2, 0.0F, true));

		RightKnee = new ModelRenderer(this);
		RightKnee.setRotationPoint(3.0F, -1.0F, -1.0F);
		setRotationAngle(RightKnee, 0.266F, 0.0F, 0.4653F);
		RightKnee.cubeList.add(new ModelBox(RightKnee, 56, 0, -6.0F, 1.0F, -1.0F, 2, 12, 2, 0.0F, true));

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-6.0F, 13.0F, 0.0F);
		setRotationAngle(RightLeg, 0.0F, 0.0F, -0.6981F);
		RightKnee.addChild(RightLeg);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 56, 14, 0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, true));

		LeftKnee = new ModelRenderer(this);
		LeftKnee.setRotationPoint(-1.7F, -2.0F, -1.0F);
		setRotationAngle(LeftKnee, -0.1496F, 0.0F, -0.565F);
		LeftKnee.cubeList.add(new ModelBox(LeftKnee, 48, 0, 2.0F, 2.0F, 0.0F, 2, 12, 2, 0.0F, true));

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(2.7F, 13.0F, 1.0F);
		setRotationAngle(LeftLeg, -0.2618F, 0.0873F, 0.7854F);
		LeftKnee.addChild(LeftLeg);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 48, 14, -0.5F, -0.5F, -1.0F, 2, 8, 2, 0.0F, true));

		Bike = new ModelRenderer(this);
		Bike.setRotationPoint(0.0F, 18.0F, 0.0F);

		Saddle = new ModelRenderer(this);
		Saddle.setRotationPoint(0.0F, 0.0F, 0.0F);
		Bike.addChild(Saddle);
		Saddle.cubeList.add(new ModelBox(Saddle, 42, 46, -2.0F, -17.0F, -5.0F, 4, 2, 6, 0.0F, true));
		Saddle.cubeList.add(new ModelBox(Saddle, 40, 40, -4.0F, -17.0F, 1.0F, 8, 2, 4, 0.0F, true));

		Frame = new ModelRenderer(this);
		Frame.setRotationPoint(0.0F, 0.0F, 0.0F);
		Bike.addChild(Frame);
		Frame.cubeList.add(new ModelBox(Frame, 0, 46, -4.0F, -7.0F, -1.0F, 2, 6, 2, 0.0F, true));
		Frame.cubeList.add(new ModelBox(Frame, 28, 46, 2.0F, -7.0F, -1.0F, 2, 6, 2, 0.0F, true));
		Frame.cubeList.add(new ModelBox(Frame, 8, 36, -3.0F, -9.0F, -1.0F, 6, 2, 2, 0.0F, true));
		Frame.cubeList.add(new ModelBox(Frame, 0, 38, -1.0F, -15.0F, -1.0F, 2, 6, 2, 0.0F, true));
		Frame.cubeList.add(new ModelBox(Frame, 36, 54, -0.5F, 0.6F, -0.5F, 1, 5, 1, 0.0F, true));
		Frame.cubeList.add(new ModelBox(Frame, 40, 54, -0.5F, 0.6F, -0.5F, 1, 5, 1, 0.0F, true));
		Frame.cubeList.add(new ModelBox(Frame, 44, 54, -0.5F, 0.6F, -0.5F, 1, 5, 1, 0.0F, true));
		Frame.cubeList.add(new ModelBox(Frame, 48, 54, -0.5F, 0.6F, -0.5F, 1, 5, 1, 0.0F, true));
		Frame.cubeList.add(new ModelBox(Frame, 8, 40, -5.0F, -1.0F, -1.0F, 10, 2, 2, 0.0F, true));

		FullPedalLeft = new ModelRenderer(this);
		FullPedalLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		Frame.addChild(FullPedalLeft);

		LeftPeddleScape = new ModelRenderer(this);
		LeftPeddleScape.setRotationPoint(-4.0F, 0.0F, -1.0F);
		setRotationAngle(LeftPeddleScape, -1.0922F, 0.0F, 0.0F);
		FullPedalLeft.addChild(LeftPeddleScape);
		LeftPeddleScape.cubeList.add(new ModelBox(LeftPeddleScape, 32, 39, -2.0F, -6.5F, -0.2F, 1, 6, 1, 0.0F, true));

		LeftPaddle = new ModelRenderer(this);
		LeftPaddle.setRotationPoint(-5.4F, -2.2F, 4.9F);
		FullPedalLeft.addChild(LeftPaddle);
		LeftPaddle.cubeList.add(new ModelBox(LeftPaddle, 36, 35, -2.35F, -1.0F, -2.0F, 4, 1, 3, 0.0F, true));

		FullPeddleRight = new ModelRenderer(this);
		FullPeddleRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		Frame.addChild(FullPeddleRight);

		RightPeddleScape = new ModelRenderer(this);
		RightPeddleScape.setRotationPoint(4.0F, 0.0F, -1.0F);
		setRotationAngle(RightPeddleScape, -2.0237F, 0.0F, 0.0F);
		FullPeddleRight.addChild(RightPeddleScape);
		RightPeddleScape.cubeList.add(new ModelBox(RightPeddleScape, 36, 39, 1.0F, -1.0F, -0.7F, 1, 6, 1, 0.0F, true));

		RightPaddle = new ModelRenderer(this);
		RightPaddle.setRotationPoint(5.4F, -2.2F, -4.9F);
		FullPeddleRight.addChild(RightPaddle);
		RightPaddle.cubeList.add(new ModelBox(RightPaddle, 50, 36, -1.4F, -0.75F, -1.4F, 4, 1, 3, 0.0F, true));

		Wheel = new ModelRenderer(this);
		Wheel.setRotationPoint(0.0F, 0.0F, 0.0F);
		Bike.addChild(Wheel);
		Wheel.cubeList.add(new ModelBox(Wheel, 52, 60, -0.5F, -0.5F, -4.0F, 1, 1, 3, 0.0F, true));
		Wheel.cubeList.add(new ModelBox(Wheel, 44, 60, -0.5F, -0.5F, 1.0F, 1, 1, 3, 0.0F, true));
		Wheel.cubeList.add(new ModelBox(Wheel, 40, 60, -0.5F, -4.0F, -0.5F, 1, 3, 1, 0.0F, true));
		Wheel.cubeList.add(new ModelBox(Wheel, 36, 60, -0.5F, 1.0F, -0.5F, 1, 3, 1, 0.0F, true));
		Wheel.cubeList.add(new ModelBox(Wheel, 8, 44, -1.0F, -6.0F, -4.0F, 2, 2, 8, 0.0F, true));
		Wheel.cubeList.add(new ModelBox(Wheel, 8, 54, -1.0F, 4.0F, -4.0F, 2, 2, 8, 0.0F, true));
		Wheel.cubeList.add(new ModelBox(Wheel, 0, 54, -1.0F, -4.0F, 4.0F, 2, 8, 2, 0.0F, true));
		Wheel.cubeList.add(new ModelBox(Wheel, 28, 54, -1.0F, -4.0F, -6.0F, 2, 8, 2, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bipedHead.render(f5);
		bipedBody.render(f5);
		bipedLeftArm.render(f5);
		bipedRightArm.render(f5);
		RightKnee.render(f5);
		LeftKnee.render(f5);
		Bike.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Wheel.rotateAngleX = MathHelper.cos(f * 0.6662F) * 3F * f1;
		this.Wheel.rotateAngleY = 0.0F;
	}
}