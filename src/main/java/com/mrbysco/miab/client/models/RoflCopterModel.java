package com.mrbysco.miab.client.models;

import com.google.common.collect.ImmutableList;
import com.mrbysco.miab.entity.memes.RoflCopterEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class RoflCopterModel<T extends RoflCopterEntity> extends SegmentedModel<T> {
	private final ModelRenderer Copter;
	private final ModelRenderer Top_part;
	private final ModelRenderer Top_Propelor;
	private final ModelRenderer Middle_Part;
	private final ModelRenderer Landing_Left;
	private final ModelRenderer Landing_LeftChild;
	private final ModelRenderer Landing_Right;
	private final ModelRenderer Landing_RightChild;
	private final ModelRenderer Back_Part;
	private final ModelRenderer Back_Propelor;

	public RoflCopterModel() {
		textureWidth = 128;
		textureHeight = 128;

		Copter = new ModelRenderer(this);
		Copter.setRotationPoint(0.0F, 24.0F, 0.0F);


		Top_part = new ModelRenderer(this);
		Top_part.setRotationPoint(0.0F, -23.0F, 0.0F);
		Copter.addChild(Top_part);
		Top_part.setTextureOffset(2, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		Top_Propelor = new ModelRenderer(this);
		Top_Propelor.setRotationPoint(0.0F, -2.1F, 0.0F);
		Top_part.addChild(Top_Propelor);
		Top_Propelor.setTextureOffset(4, 123).addBox(-12.0F, -1.0F, -2.0F, 24.0F, 1.0F, 4.0F, 0.0F, false);

		Middle_Part = new ModelRenderer(this);
		Middle_Part.setRotationPoint(0.0F, -12.0F, 0.0F);
		Copter.addChild(Middle_Part);
		Middle_Part.setTextureOffset(2, 0).addBox(-6.0F, -6.0F, -10.0F, 12.0F, 12.0F, 20.0F, 0.0F, false);
		Middle_Part.setTextureOffset(8, 32).addBox(-3.0F, -10.0F, -7.0F, 6.0F, 4.0F, 14.0F, 0.0F, false);
		Middle_Part.setTextureOffset(46, 0).addBox(-3.0F, -5.0F, 10.0F, 6.0F, 8.0F, 3.0F, 0.0F, false);
		Middle_Part.setTextureOffset(0, 0).addBox(-3.0F, -2.0F, -15.0F, 6.0F, 6.0F, 5.0F, 0.0F, false);

		Landing_Left = new ModelRenderer(this);
		Landing_Left.setRotationPoint(-6.0F, 10.0F, 0.0F);
		Middle_Part.addChild(Landing_Left);
		Landing_Left.setTextureOffset(0, 80).addBox(-1.0F, -1.0F, -12.0F, 1.0F, 2.0F, 24.0F, 0.0F, false);
		Landing_Left.setTextureOffset(0, 80).addBox(-1.0F, -3.0F, -14.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		Landing_Left.setTextureOffset(18, 80).addBox(-1.0F, -3.0F, 12.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		Landing_LeftChild = new ModelRenderer(this);
		Landing_LeftChild.setRotationPoint(0.9F, -5.9F, -5.0F);
		Landing_Left.addChild(Landing_LeftChild);
		setRotationAngle(Landing_LeftChild, 0.0F, 0.0F, 0.1745F);
		Landing_LeftChild.setTextureOffset(6, 80).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		Landing_Right = new ModelRenderer(this);
		Landing_Right.setRotationPoint(7.0F, 10.0F, 0.0F);
		Middle_Part.addChild(Landing_Right);
		Landing_Right.setTextureOffset(0, 52).addBox(-1.0F, -1.0F, -12.0F, 1.0F, 2.0F, 24.0F, 0.0F, false);
		Landing_Right.setTextureOffset(18, 52).addBox(-1.0F, -3.0F, 12.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		Landing_Right.setTextureOffset(0, 52).addBox(-1.0F, -3.0F, -14.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		Landing_RightChild = new ModelRenderer(this);
		Landing_RightChild.setRotationPoint(-0.9F, -6.0F, -5.0F);
		Landing_Right.addChild(Landing_RightChild);
		setRotationAngle(Landing_RightChild, 0.0F, 0.0F, -0.1745F);
		Landing_RightChild.setTextureOffset(6, 52).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		Back_Part = new ModelRenderer(this);
		Back_Part.setRotationPoint(0.0F, -15.0F, 16.0F);
		Copter.addChild(Back_Part);
		Back_Part.setTextureOffset(69, 3).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 3.0F, 9.0F, 0.0F, false);

		Back_Propelor = new ModelRenderer(this);
		Back_Propelor.setRotationPoint(-1.0F, 0.6F, 3.0F);
		Back_Part.addChild(Back_Propelor);
		Back_Propelor.setTextureOffset(0, 113).addBox(-1.0F, -6.0F, -1.0F, 1.0F, 12.0F, 2.0F, 0.0F, false);
	}

	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.Copter);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		boolean flag = !entityIn.getIsCopterLanded();

		float f3 = (flag ? ((MathHelper.cos(ageInTicks * 1F)) * 0.4F) : 0.0F);
		if(flag) {
			this.Back_Propelor.rotateAngleX += f3;
			this.Top_Propelor.rotateAngleY += -f3;
		} else {
			this.Back_Propelor.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.3F * limbSwingAmount;
			this.Top_Propelor.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.3F * limbSwingAmount;
			this.Back_Propelor.rotateAngleY = 0.0F;
			this.Top_Propelor.rotateAngleY = 0.0F;
		}
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}