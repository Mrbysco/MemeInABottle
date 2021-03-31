package com.mrbysco.miab.client.models.knuckles;

import com.google.common.collect.ImmutableList;
import com.mrbysco.miab.entity.memes.KnucklesEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class KnucklesModel<T extends KnucklesEntity> extends SegmentedModel<T> {
	private final ModelRenderer chest;
	private final ModelRenderer chest_part2;
	private final ModelRenderer chest_part4;
	private final ModelRenderer chest_front;
	private final ModelRenderer chest_back;
	private final ModelRenderer chest_part3;
	private final ModelRenderer chest_part;
	private final ModelRenderer chest_right;
	private final ModelRenderer chest_left;
	private final ModelRenderer left_arm;
	private final ModelRenderer right_hand;
	private final ModelRenderer left_arm_2;
	private final ModelRenderer right_arm;
	private final ModelRenderer right_arm_2;
	private final ModelRenderer right_hand_1;
	private final ModelRenderer left_leg;
	private final ModelRenderer left_foot;
	private final ModelRenderer right_leg;
	private final ModelRenderer right_foot;
	private final ModelRenderer head;
	private final ModelRenderer mouth;
	private final ModelRenderer nose;
	private final ModelRenderer mouth_top;
	private final ModelRenderer head_top;

	public KnucklesModel() {
		textureWidth = 64;
		textureHeight = 64;

		chest = new ModelRenderer(this);
		chest.setRotationPoint(0.0F, 13.0F, -2.0F);
		chest.setTextureOffset(0, 36).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 4.0F, 0.0F, false);

		chest_part2 = new ModelRenderer(this);
		chest_part2.setRotationPoint(0.0F, 3.5F, -0.5F);
		chest.addChild(chest_part2);
		chest_part2.setTextureOffset(5, 39).addBox(-4.0F, -0.5F, -0.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		chest_part4 = new ModelRenderer(this);
		chest_part4.setRotationPoint(-4.5F, 0.0F, -0.5F);
		chest.addChild(chest_part4);
		chest_part4.setTextureOffset(5, 39).addBox(8.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		chest_front = new ModelRenderer(this);
		chest_front.setRotationPoint(-4.0F, -3.0F, -2.0F);
		chest.addChild(chest_front);
		chest_front.setTextureOffset(28, 36).addBox(0.0F, 0.0F, 0.0F, 8.0F, 6.0F, 2.0F, 0.0F, false);

		chest_back = new ModelRenderer(this);
		chest_back.setRotationPoint(-4.0F, -3.0F, 3.2F);
		chest.addChild(chest_back);
		chest_back.setTextureOffset(28, 44).addBox(0.0F, 0.0F, 0.0F, 8.0F, 6.0F, 2.0F, 0.0F, false);

		chest_part3 = new ModelRenderer(this);
		chest_part3.setRotationPoint(-4.5F, 0.0F, -0.5F);
		chest.addChild(chest_part3);
		chest_part3.setTextureOffset(5, 39).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		chest_part = new ModelRenderer(this);
		chest_part.setRotationPoint(0.0F, -3.5F, -0.5F);
		chest.addChild(chest_part);
		chest_part.setTextureOffset(5, 39).addBox(-4.0F, -0.5F, -0.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		chest_right = new ModelRenderer(this);
		chest_right.setRotationPoint(-6.0F, -4.5F, 2.0F);
		chest.addChild(chest_right);
		chest_right.setTextureOffset(48, 36).addBox(0.0F, 0.0F, -1.5F, 1.0F, 8.0F, 3.0F, 0.0F, false);

		chest_left = new ModelRenderer(this);
		chest_left.setRotationPoint(5.0F, -4.5F, 2.0F);
		chest.addChild(chest_left);
		chest_left.setTextureOffset(56, 36).addBox(0.0F, 0.0F, -1.5F, 1.0F, 8.0F, 3.0F, 0.0F, false);

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(3.0F, 10.0F, -1.0F);
		left_arm.setTextureOffset(0, 60).addBox(3.0F, -1.0F, 0.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		right_hand = new ModelRenderer(this);
		right_hand.setRotationPoint(0.0F, 0.0F, 0.0F);
		left_arm.addChild(right_hand);
		right_hand.setTextureOffset(14, 54).addBox(6.5F, 1.2F, -0.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		left_arm_2 = new ModelRenderer(this);
		left_arm_2.setRotationPoint(5.3F, -0.2F, 0.0F);
		left_arm.addChild(left_arm_2);
		setRotationAngle(left_arm_2, 0.0F, 0.0F, 0.6109F);
		left_arm_2.setTextureOffset(14, 60).addBox(0.0F, -1.0F, 0.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(-3.0F, 10.0F, -1.0F);
		right_arm.setTextureOffset(50, 60).addBox(-6.0F, -1.0F, 0.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		right_arm_2 = new ModelRenderer(this);
		right_arm_2.setRotationPoint(-5.4F, -0.2F, 0.0F);
		right_arm.addChild(right_arm_2);
		setRotationAngle(right_arm_2, 0.0F, 0.0F, -0.6109F);
		right_arm_2.setTextureOffset(38, 60).addBox(-4.0F, -1.0F, 0.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		right_hand_1 = new ModelRenderer(this);
		right_hand_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		right_arm.addChild(right_hand_1);
		right_hand_1.setTextureOffset(39, 54).addBox(-10.0F, 1.2F, -0.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(2.0F, 17.0F, 0.0F);
		left_leg.setTextureOffset(40, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		left_foot = new ModelRenderer(this);
		left_foot.setRotationPoint(-0.5F, 0.0F, 0.0F);
		left_leg.addChild(left_foot);
		left_foot.setTextureOffset(36, 6).addBox(-0.5F, 4.0F, -2.8F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-2.0F, 17.0F, 0.0F);
		right_leg.setTextureOffset(56, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		right_foot = new ModelRenderer(this);
		right_foot.setRotationPoint(-0.5F, 0.0F, 0.0F);
		right_leg.addChild(right_foot);
		right_foot.setTextureOffset(50, 6).addBox(-0.5F, 4.0F, -2.8F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.5F, 6.0F, 0.0F);
		head.setTextureOffset(0, 5).addBox(-4.0F, -2.0F, -2.0F, 7.0F, 4.0F, 4.0F, 0.0F, false);

		mouth = new ModelRenderer(this);
		mouth.setRotationPoint(-0.5F, -0.5F, -2.5F);
		head.addChild(mouth);
		mouth.setTextureOffset(22, 2).addBox(-3.0F, 0.0F, -0.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		nose = new ModelRenderer(this);
		nose.setRotationPoint(-0.5F, -0.2F, -3.0F);
		head.addChild(nose);
		nose.setTextureOffset(17, 0).addBox(-0.5F, -0.6F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		mouth_top = new ModelRenderer(this);
		mouth_top.setRotationPoint(-0.5F, -1.0F, -2.5F);
		head.addChild(mouth_top);
		mouth_top.setTextureOffset(22, 0).addBox(-2.0F, 0.0F, -0.4F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		head_top = new ModelRenderer(this);
		head_top.setRotationPoint(0.0F, -2.0F, 0.0F);
		head.addChild(head_top);
		head_top.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, -2.0F, 5.0F, 1.0F, 3.0F, 0.0F, false);
		
	}

	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.chest, this.left_arm, this.right_arm, this.left_leg, this.right_leg, this.head);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
		this.right_leg.rotateAngleY = 0.0F;
		this.left_leg.rotateAngleY = 0.0F;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}