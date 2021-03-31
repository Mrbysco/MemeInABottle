package com.mrbysco.miab.client.models;

import com.google.common.collect.ImmutableList;
import com.mrbysco.miab.entity.memes.ChocolateGuyEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

public class TomModel<T extends ChocolateGuyEntity> extends SegmentedModel<T> {
	public ModelRenderer bipedHead;
	public ModelRenderer bipedBody;
	/** The Biped's Right Arm */
	public ModelRenderer bipedRightArm;
	/** The Biped's Left Arm */
	public ModelRenderer bipedLeftArm;
	/** The Biped's Right Leg */
	public ModelRenderer bipedRightLeg;
	/** The Biped's Left Leg */
	public ModelRenderer bipedLeftLeg;

	public TomModel() {
		this.textureWidth = 64;
		this.textureHeight = 64;

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, 5.0F, 0.0F);
		bipedHead.setTextureOffset(2, 2).addBox(-4.0F, -8.0F, -3.0F, 8.0F, 8.0F, 6.0F, 0.0F, false);
		bipedHead.setTextureOffset(2, 32).addBox(0.25F, -7.0F, 3.0F, 0.0F, 6.0F, 2.0F, 0.0F, false);

		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, 5.0F, 0.0F);
		bipedBody.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 10.0F, 4.0F, 0.0F, false);
		bipedBody.setTextureOffset(0, 32).addBox(0.25F, 6.0F, 2.0F, 0.0F, 4.0F, 2.0F, 0.0F, false);

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-4.0F, 7.0F, 0.0F);
		bipedRightArm.setTextureOffset(40, 16).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(4.0F, 7.0F, 0.0F);
		bipedLeftArm.setTextureOffset(40, 16).addBox(0.0F, -2.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, true);

		bipedLeftLeg = new ModelRenderer(this);
		bipedLeftLeg.setRotationPoint(2.0F, 15.0F, 0.0F);
		bipedLeftLeg.setTextureOffset(0, 16).addBox(-2.1F, 0.0F, -1.9F, 4.0F, 9.0F, 4.0F, 0.0F, true);

		bipedRightLeg = new ModelRenderer(this);
		bipedRightLeg.setRotationPoint(-2.0F, 15.0F, 0.0F);
		bipedRightLeg.setTextureOffset(0, 16).addBox(-1.9F, 0.0F, -1.9F, 4.0F, 9.0F, 4.0F, 0.0F, false);
	}

	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.bipedBody, this.bipedRightArm, this.bipedLeftArm, this.bipedRightLeg, this.bipedLeftLeg, this.bipedHead);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.bipedLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.bipedRightLeg.rotateAngleY = 0.0F;
		this.bipedLeftLeg.rotateAngleY = 0.0F;
		this.bipedRightLeg.rotateAngleZ = 0.0F;
		this.bipedLeftLeg.rotateAngleZ = 0.0F;

		this.bipedHead.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		this.bipedHead.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		this.bipedHead.rotateAngleX = headPitch * ((float)Math.PI / 180F);

		ItemStack itemstack = entityIn.getHeldItemMainhand();
		if (entityIn.isAggressive() && (itemstack.isEmpty() || !(itemstack.getItem() instanceof net.minecraft.item.BowItem))) {
			ModelHelper.func_239105_a_(this.bipedLeftArm, this.bipedRightArm, entityIn.isAggressive(), this.swingProgress, ageInTicks);
		}
	}
}