package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.registry.MemeRegistry;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;

public class RobbieModel<T extends AbstractMeme> extends HumanBaseModel<T> {
	public RobbieModel(ModelPart root) {
		super(root);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setupAnim(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		ItemStack itemstack = entityIn.getMainHandItem();

		if ((itemstack.getItem() == MemeRegistry.SAX.get())) {
			float f = Mth.sin(this.attackTime * (float) Math.PI);
			float f1 = Mth.sin((1.0F - (1.0F - this.attackTime) * (1.0F - this.attackTime)) * (float) Math.PI);
			this.rightArm.zRot = 0.0F;
			this.rightArm.yRot = 0.1F - f * 0.6F;
			this.rightArm.xRot = -((float) Math.PI / 2F);
			this.rightArm.xRot -= f * 1.2F - f1 * 0.4F;
			this.rightArm.zRot -= Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
			this.rightArm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
		}
	}
}
