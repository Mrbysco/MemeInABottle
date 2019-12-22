package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.memes.EntityRoflCopter;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

public class ModelRoflCopter<T extends EntityRoflCopter> extends EntityModel<T> {
	private final RendererModel Copter;
	private final RendererModel Top_part;
	private final RendererModel Top_Propelor;
	private final RendererModel Middle_Part;
	private final RendererModel Landing_Left;
	private final RendererModel Landing_LeftChild;
	private final RendererModel Landing_Right;
	private final RendererModel Landing_RightChild;
	private final RendererModel Back_Part;
	private final RendererModel Back_Propelor;

	public ModelRoflCopter() {
		textureWidth = 128;
		textureHeight = 128;

		Copter = new RendererModel(this);
		Copter.setRotationPoint(0.0F, 24.0F, 0.0F);

		Top_part = new RendererModel(this);
		Top_part.setRotationPoint(0.0F, -23.0F, 0.0F);
		Copter.addChild(Top_part);
		Top_part.cubeList.add(new ModelBox(Top_part, 2, 12, -1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F, true));

		Top_Propelor = new RendererModel(this);
		Top_Propelor.setRotationPoint(0.0F, -2.1F, 0.0F);
		Top_part.addChild(Top_Propelor);
		Top_Propelor.cubeList.add(new ModelBox(Top_Propelor, 4, 123, -12.0F, -1.0F, -2.0F, 24, 1, 4, 0.0F, true));

		Middle_Part = new RendererModel(this);
		Middle_Part.setRotationPoint(0.0F, -12.0F, 0.0F);
		Copter.addChild(Middle_Part);
		Middle_Part.cubeList.add(new ModelBox(Middle_Part, 2, 0, -6.0F, -6.0F, -10.0F, 12, 12, 20, 0.0F, true));
		Middle_Part.cubeList.add(new ModelBox(Middle_Part, 8, 32, -3.0F, -10.0F, -7.0F, 6, 4, 14, 0.0F, true));
		Middle_Part.cubeList.add(new ModelBox(Middle_Part, 46, 0, -3.0F, -5.0F, 10.0F, 6, 8, 3, 0.0F, true));
		Middle_Part.cubeList.add(new ModelBox(Middle_Part, 0, 0, -3.0F, -2.0F, -15.0F, 6, 6, 5, 0.0F, true));

		Landing_Left = new RendererModel(this);
		Landing_Left.setRotationPoint(-6.0F, 10.0F, 0.0F);
		Middle_Part.addChild(Landing_Left);
		Landing_Left.cubeList.add(new ModelBox(Landing_Left, 0, 80, -1.0F, -1.0F, -12.0F, 1, 2, 24, 0.0F, true));
		Landing_Left.cubeList.add(new ModelBox(Landing_Left, 0, 80, -1.0F, -3.0F, -14.0F, 1, 2, 2, 0.0F, true));
		Landing_Left.cubeList.add(new ModelBox(Landing_Left, 18, 80, -1.0F, -3.0F, 12.0F, 1, 2, 2, 0.0F, true));

		Landing_LeftChild = new RendererModel(this);
		Landing_LeftChild.setRotationPoint(0.9F, -5.9F, -5.0F);
		setRotationAngle(Landing_LeftChild, 0.0F, 0.0F, 0.1745F);
		Landing_Left.addChild(Landing_LeftChild);
		Landing_LeftChild.cubeList.add(new ModelBox(Landing_LeftChild, 6, 80, -1.0F, 0.0F, 0.0F, 1, 5, 2, 0.0F, true));

		Landing_Right = new RendererModel(this);
		Landing_Right.setRotationPoint(7.0F, 10.0F, 0.0F);
		Middle_Part.addChild(Landing_Right);
		Landing_Right.cubeList.add(new ModelBox(Landing_Right, 0, 52, -1.0F, -1.0F, -12.0F, 1, 2, 24, 0.0F, true));
		Landing_Right.cubeList.add(new ModelBox(Landing_Right, 18, 52, -1.0F, -3.0F, 12.0F, 1, 2, 2, 0.0F, true));
		Landing_Right.cubeList.add(new ModelBox(Landing_Right, 0, 52, -1.0F, -3.0F, -14.0F, 1, 2, 2, 0.0F, true));

		Landing_RightChild = new RendererModel(this);
		Landing_RightChild.setRotationPoint(-0.9F, -6.0F, -5.0F);
		setRotationAngle(Landing_RightChild, 0.0F, 0.0F, -0.1745F);
		Landing_Right.addChild(Landing_RightChild);
		Landing_RightChild.cubeList.add(new ModelBox(Landing_RightChild, 6, 52, -1.0F, 0.0F, 0.0F, 1, 5, 2, 0.0F, true));

		Back_Part = new RendererModel(this);
		Back_Part.setRotationPoint(0.0F, -15.0F, 16.0F);
		Copter.addChild(Back_Part);
		Back_Part.cubeList.add(new ModelBox(Back_Part, 69, 3, -1.5F, -1.0F, -3.0F, 3, 3, 9, 0.0F, true));

		Back_Propelor = new RendererModel(this);
		Back_Propelor.setRotationPoint(-1.0F, 0.6F, 3.0F);
		Back_Part.addChild(Back_Propelor);
		Back_Propelor.cubeList.add(new ModelBox(Back_Propelor, 0, 113, -1.0F, -6.0F, -1.0F, 1, 12, 2, 0.0F, true));
	}

	@Override
	public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Copter.render(f5);
	}

	public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
		RendererModel.rotateAngleX = x;
		RendererModel.rotateAngleY = y;
		RendererModel.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
								  float headPitch, float scaleFactor) {
		super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
		boolean flag = !entityIn.getIsCopterLanded();

		float f3 = (flag ? ((MathHelper.cos(ageInTicks * 1F)) * 0.4F) : 0.0F);
		if(flag)
		{
			this.Back_Propelor.rotateAngleX += f3;
			this.Top_Propelor.rotateAngleY += -f3;
		}
		else
		{
			this.Back_Propelor.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.3F * limbSwingAmount;
			this.Top_Propelor.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.3F * limbSwingAmount;
			this.Back_Propelor.rotateAngleY = 0.0F;
			this.Top_Propelor.rotateAngleY = 0.0F;
		}
	}
}