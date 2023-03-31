package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.AbstractMeme;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemStack;

public class HumanBaseModel<T extends AbstractMeme> extends HumanoidModel<T> {

	public HumanBaseModel(ModelPart part) {
		super(part);
	}

	public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
		this.rightArmPose = ArmPose.EMPTY;
		this.leftArmPose = ArmPose.EMPTY;
		ItemStack itemstack = entityIn.getItemInHand(InteractionHand.MAIN_HAND);
		if (itemstack.getItem() instanceof net.minecraft.world.item.BowItem && entityIn.isAggressive()) {
			if (entityIn.getMainArm() == HumanoidArm.RIGHT) {
				this.rightArmPose = ArmPose.BOW_AND_ARROW;
			} else {
				this.leftArmPose = ArmPose.BOW_AND_ARROW;
			}
		}

		super.prepareMobModel(entityIn, limbSwing, limbSwingAmount, partialTickTime);
	}

	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setupAnim(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		ItemStack itemstack = entityIn.getMainHandItem();
		if (entityIn.isAggressive() && (itemstack.isEmpty() || !(itemstack.getItem() instanceof net.minecraft.world.item.BowItem))) {
			AnimationUtils.animateZombieArms(this.leftArm, this.rightArm, entityIn.isAggressive(), this.attackTime, ageInTicks);
		}
	}

	public void setRotationAngle(ModelPart RendererModel, float x, float y, float z) {
		RendererModel.xRot = x;
		RendererModel.yRot = y;
		RendererModel.zRot = z;
	}
}
