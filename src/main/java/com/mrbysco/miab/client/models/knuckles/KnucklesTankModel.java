package com.mrbysco.miab.client.models.knuckles;

import com.google.common.collect.ImmutableList;
import com.mrbysco.miab.entity.memes.KnucklesEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class KnucklesTankModel<T extends KnucklesEntity> extends SegmentedModel<T> {
	private final ModelRenderer tank;
	private final ModelRenderer tank_2;
	private final ModelRenderer tank_side;
	private final ModelRenderer right_arm;
	private final ModelRenderer right_arm_2;
	private final ModelRenderer right_hand;
	private final ModelRenderer head;
	private final ModelRenderer mouth;
	private final ModelRenderer mouth_top;
	private final ModelRenderer nose;
	private final ModelRenderer head_top;
	private final ModelRenderer chest;
	private final ModelRenderer chest_part;
	private final ModelRenderer chest_part4;
	private final ModelRenderer chest_front;
	private final ModelRenderer chest_part3;
	private final ModelRenderer chest_right;
	private final ModelRenderer chest_left;
	private final ModelRenderer chest_back;
	private final ModelRenderer tank_side_2;
	private final ModelRenderer wheels_2;
	private final ModelRenderer cannon;
	private final ModelRenderer wheels_1;
	private final ModelRenderer left_arm;
	private final ModelRenderer left_hand;
	private final ModelRenderer left_arm_2;

	public KnucklesTankModel() {
		textureWidth = 128;
		textureHeight = 128;

		tank = new ModelRenderer(this);
		tank.setRotationPoint(0.0F, 16.5F, 0.0F);
		tank.setTextureOffset(80, 113).addBox(-6.0F, -1.5F, -6.0F, 12.0F, 3.0F, 12.0F, 0.0F, false);

		tank_2 = new ModelRenderer(this);
		tank_2.setRotationPoint(0.0F, 4.0F, 0.0F);
		tank.addChild(tank_2);
		tank_2.setTextureOffset(0, 99).addBox(-8.0F, -2.5F, -12.0F, 16.0F, 5.0F, 24.0F, 0.0F, false);

		tank_side = new ModelRenderer(this);
		tank_side.setRotationPoint(0.0F, 0.0F, -7.0F);
		tank.addChild(tank_side);
		tank_side.setTextureOffset(0, 118).addBox(-5.0F, -1.5F, -1.0F, 10.0F, 3.0F, 2.0F, 0.0F, false);

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(-3.0F, -4.5F, -1.0F);
		tank.addChild(right_arm);
		right_arm.setTextureOffset(50, 60).addBox(-6.0F, -1.0F, 0.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		right_arm_2 = new ModelRenderer(this);
		right_arm_2.setRotationPoint(-5.0F, 0.75F, 0.0F);
		right_arm.addChild(right_arm_2);
		setRotationAngle(right_arm_2, 0.0F, 0.0F, -0.6109F);
		right_arm_2.setTextureOffset(38, 60).addBox(-4.0F, -2.0F, 0.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		right_hand = new ModelRenderer(this);
		right_hand.setRotationPoint(0.0F, 0.0F, 0.0F);
		right_arm.addChild(right_hand);
		right_hand.setTextureOffset(39, 54).addBox(-10.0F, 1.2F, -0.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.5F, -8.0F, 0.0F);
		tank.addChild(head);
		head.setTextureOffset(0, 5).addBox(-4.0F, -2.0F, -2.0F, 7.0F, 4.0F, 4.0F, 0.0F, false);

		mouth = new ModelRenderer(this);
		mouth.setRotationPoint(-0.5F, -17.0F, -2.5F);
		head.addChild(mouth);
		mouth.setTextureOffset(22, 2).addBox(-3.0F, 17.0F, -0.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		mouth_top = new ModelRenderer(this);
		mouth_top.setRotationPoint(-0.5F, -1.0F, -2.5F);
		head.addChild(mouth_top);
		mouth_top.setTextureOffset(22, 0).addBox(-2.0F, 0.0F, -0.4F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		nose = new ModelRenderer(this);
		nose.setRotationPoint(-0.5F, -0.2F, -3.0F);
		head.addChild(nose);
		nose.setTextureOffset(17, 0).addBox(-0.5F, -0.6F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		head_top = new ModelRenderer(this);
		head_top.setRotationPoint(0.0F, -2.0F, 0.0F);
		head.addChild(head_top);
		head_top.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, -2.0F, 5.0F, 1.0F, 3.0F, 0.0F, false);

		chest = new ModelRenderer(this);
		chest.setRotationPoint(0.0F, -1.0F, -2.0F);
		tank.addChild(chest);
		chest.setTextureOffset(36, 0).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 5.0F, 4.0F, 0.0F, false);

		chest_part = new ModelRenderer(this);
		chest_part.setRotationPoint(0.0F, -20.0F, -0.5F);
		chest.addChild(chest_part);
		chest_part.setTextureOffset(46, 19).addBox(-4.0F, 15.5F, -0.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		chest_part4 = new ModelRenderer(this);
		chest_part4.setRotationPoint(-4.5F, -16.5F, -0.5F);
		chest.addChild(chest_part4);
		chest_part4.setTextureOffset(40, 16).addBox(8.5F, 13.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		chest_front = new ModelRenderer(this);
		chest_front.setRotationPoint(-4.0F, -19.5F, -2.0F);
		chest.addChild(chest_front);
		chest_front.setTextureOffset(44, 9).addBox(0.0F, 16.0F, 0.0F, 8.0F, 3.0F, 2.0F, 0.0F, false);

		chest_part3 = new ModelRenderer(this);
		chest_part3.setRotationPoint(-4.5F, -16.5F, -0.5F);
		chest.addChild(chest_part3);
		chest_part3.setTextureOffset(40, 16).addBox(-0.5F, 13.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		chest_right = new ModelRenderer(this);
		chest_right.setRotationPoint(-6.0F, -4.5F, 2.0F);
		chest.addChild(chest_right);
		chest_right.setTextureOffset(36, 9).addBox(0.0F, 0.0F, -1.5F, 1.0F, 4.0F, 3.0F, 0.0F, false);

		chest_left = new ModelRenderer(this);
		chest_left.setRotationPoint(5.0F, -4.5F, 2.0F);
		chest.addChild(chest_left);
		chest_left.setTextureOffset(36, 9).addBox(0.0F, 0.0F, -1.5F, 1.0F, 4.0F, 3.0F, 0.0F, false);

		chest_back = new ModelRenderer(this);
		chest_back.setRotationPoint(-4.0F, -3.0F, 3.2F);
		chest.addChild(chest_back);
		chest_back.setTextureOffset(44, 14).addBox(0.0F, 0.0F, 0.0F, 8.0F, 3.0F, 2.0F, 0.0F, false);

		tank_side_2 = new ModelRenderer(this);
		tank_side_2.setRotationPoint(0.0F, 0.0F, 7.0F);
		tank.addChild(tank_side_2);
		tank_side_2.setTextureOffset(0, 112).addBox(-5.0F, -1.5F, -1.0F, 10.0F, 3.0F, 2.0F, 0.0F, false);

		wheels_2 = new ModelRenderer(this);
		wheels_2.setRotationPoint(6.5F, 7.0F, 0.0F);
		tank.addChild(wheels_2);
		wheels_2.setTextureOffset(0, 73).addBox(-1.2F, -0.5F, -12.0F, 2.0F, 1.0F, 24.0F, 0.0F, false);

		cannon = new ModelRenderer(this);
		cannon.setRotationPoint(0.0F, -0.2F, -10.0F);
		tank.addChild(cannon);
		setRotationAngle(cannon, -0.1222F, 0.0F, 0.0F);
		cannon.setTextureOffset(56, 107).addBox(-1.0F, -1.0F, -12.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);

		wheels_1 = new ModelRenderer(this);
		wheels_1.setRotationPoint(-6.2F, 7.0F, 0.0F);
		tank.addChild(wheels_1);
		wheels_1.setTextureOffset(0, 73).addBox(-1.0F, -0.5F, -12.0F, 2.0F, 1.0F, 24.0F, 0.0F, false);

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(3.0F, -4.5F, -1.0F);
		tank.addChild(left_arm);
		left_arm.setTextureOffset(0, 60).addBox(3.0F, -1.0F, 0.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		left_hand = new ModelRenderer(this);
		left_hand.setRotationPoint(0.0F, -16.5F, 0.0F);
		left_arm.addChild(left_hand);
		left_hand.setTextureOffset(14, 54).addBox(6.5F, 17.2F, -0.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		left_arm_2 = new ModelRenderer(this);
		left_arm_2.setRotationPoint(8.0F, 3.0F, 0.0F);
		left_arm.addChild(left_arm_2);
		setRotationAngle(left_arm_2, 0.0F, 0.0F, 0.6109F);
		left_arm_2.setTextureOffset(14, 60).addBox(-4.0F, -2.0F, 0.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.tank);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}