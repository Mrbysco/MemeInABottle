package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.init.MemeRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

public class RobbieModel<T extends AbstractMeme> extends HumanBaseModel<T> {
	public RobbieModel() { }

	public RobbieModel(float modelSize, boolean p_i46303_2_) {
        super(modelSize, p_i46303_2_);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        ItemStack itemstack = entityIn.getHeldItemMainhand();

        if ((itemstack.getItem() == MemeRegister.SAX.get())) {
            float f = MathHelper.sin(this.swingProgress * (float)Math.PI);
            float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
            this.bipedRightArm.rotateAngleZ = 0.0F;
            this.bipedRightArm.rotateAngleY = 0.1F - f * 0.6F;
            this.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F);
            this.bipedRightArm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
            this.bipedRightArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
            this.bipedRightArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        }
    }
}
