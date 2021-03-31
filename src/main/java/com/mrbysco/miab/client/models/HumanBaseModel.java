package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.AbstractMeme;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;

public class HumanBaseModel<T extends AbstractMeme> extends BipedModel<T> {

	public HumanBaseModel() {
        this(0.0F, false);
	}

	public HumanBaseModel(float modelSize, boolean small) {
        super(modelSize, 0.0F, 64, 64);
    }

    public HumanBaseModel(float modelSize, float yOffsetIn, int textureWidthIn, int textureHeightIn) {
        super(modelSize, yOffsetIn, textureWidthIn, textureHeightIn);
    }

	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
        this.rightArmPose = ArmPose.EMPTY;
        this.leftArmPose = ArmPose.EMPTY;
        ItemStack itemstack = entityIn.getHeldItem(Hand.MAIN_HAND);
        if (itemstack.getItem() instanceof net.minecraft.item.BowItem && entityIn.isAggressive()) {
            if (entityIn.getPrimaryHand() == HandSide.RIGHT) {
                this.rightArmPose = ArmPose.BOW_AND_ARROW;
            } else {
                this.leftArmPose = ArmPose.BOW_AND_ARROW;
            }
        }

        super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTickTime);
    }

    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        ItemStack itemstack = entityIn.getHeldItemMainhand();
        if (entityIn.isAggressive() && (itemstack.isEmpty() || !(itemstack.getItem() instanceof net.minecraft.item.BowItem))) {
            ModelHelper.func_239105_a_(this.bipedLeftArm, this.bipedRightArm, entityIn.isAggressive(), this.swingProgress, ageInTicks);
        }
    }

    public void setRotationAngle(ModelRenderer RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }
}
