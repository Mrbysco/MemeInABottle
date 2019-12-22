package com.mrbysco.miab.client.models;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.math.MathHelper;

public class ModelNyan<T extends CatEntity> extends EntityModel<T> {
	private final RendererModel nyanBody;
	private final RendererModel nyanBackLeftLeg;
	private final RendererModel nyanFrontRightLeg;
	private final RendererModel nyanTail;
	private final RendererModel nyanFrontLeftLeg;
	private final RendererModel nyanBackRightLeg;
	private final RendererModel nyanhead = new RendererModel(this, "head");;
	private int state = 1;

	public ModelNyan() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.nyanhead.func_217178_a("main", -2.5F, -2.0F, -2.0F, 5, 4, 5, 0.0F, 0, 0);
		this.nyanhead.func_217178_a("nose", -1.5F, 0.0F, -3.0F, 3, 2, 2, 0.0F, 0, 24);
		this.nyanhead.func_217178_a("ear1", -2.0F, -3.0F, 0.0F, 1, 1, 2, 0.0F, 0, 10);
		this.nyanhead.func_217178_a("ear2", 1.0F, -3.0F, 0.0F, 1, 1, 2, 0.0F, 6, 10);
		this.nyanFrontLeftLeg = new RendererModel(this, 48, 0);
		this.nyanFrontLeftLeg.setRotationPoint(1.2F, 19.0F, -5.0F);
		this.nyanFrontLeftLeg.addBox(-1.0F, 0.0F, 0.0F, 2, 10, 2);
		this.nyanTail = new RendererModel(this, 0, 15);
		this.nyanTail.setRotationPoint(0.0F, 15.0F, 8.0F);
		this.nyanTail.addBox(-0.5F, -1.0F, -1.0F, 1, 8, 1, 0.0F);
		this.nyanBackRightLeg = new RendererModel(this, 8, 13);
		this.nyanBackRightLeg.setRotationPoint(-1.1F, 19.0F, 5.0F);
		this.nyanBackRightLeg.addBox(-1.0F, 0.0F, 1.0F, 2, 6, 2);
		this.nyanFrontRightLeg = new RendererModel(this, 48, 0);
		this.nyanFrontRightLeg.setRotationPoint(-1.2F, 19.0F, -5.0F);
		this.nyanFrontRightLeg.addBox(-1.0F, 0.0F, 0.0F, 2, 10, 2);
		this.nyanBody = new RendererModel(this, 20, 0);
		this.nyanBody.setRotationPoint(0.0F, 12.0F, -10.0F);
		this.nyanBody.addBox(-2.0F, 3.0F, -8.0F, 4, 16, 9, 0.0F);
		this.nyanBackLeftLeg = new RendererModel(this, 8, 13);
		this.nyanBackLeftLeg.setRotationPoint(1.1F, 19.0F, 5.0F);
		this.nyanBackLeftLeg.addBox(-1.0F, 0.0F, 1.0F, 2, 6, 2);
	}

	@Override
	public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) {
		nyanBody.render(f5);
		nyanBackLeftLeg.render(f5);
		nyanFrontRightLeg.render(f5);
		nyanTail.render(f5);
		nyanFrontLeftLeg.render(f5);
		nyanBackRightLeg.render(f5);
		nyanhead.render(f5);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)	{
		this.nyanhead.rotateAngleX = headPitch * 0.017453292F;
		this.nyanhead.rotateAngleY = netHeadYaw * 0.017453292F;

		if (this.state != 3)
		{
			this.nyanBody.rotateAngleX = ((float)Math.PI / 2F);
			this.nyanFrontLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
			this.nyanBackRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
			this.nyanFrontLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
			this.nyanBackRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
		}
	}

	public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
		RendererModel.rotateAngleX = x;
		RendererModel.rotateAngleY = y;
		RendererModel.rotateAngleZ = z;
	}

	/**
	 * Used for easily adding entity-dependent animations. The second and third float params here are the same second
	 * and third as in the setRotationAngles method.
	 */
	public void setLivingAnimations(T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime)
	{
		this.nyanBody.rotationPointY = 12.0F;
		this.nyanBody.rotationPointZ = -10.0F;
		this.nyanhead.rotationPointY = 15.0F;
		this.nyanhead.rotationPointZ = -9.0F;
		this.nyanTail.rotationPointY = 15.0F;
		this.nyanTail.rotationPointZ = 8.0F;
		this.nyanFrontLeftLeg.rotationPointY = 13.8F;
		this.nyanFrontLeftLeg.rotationPointZ = -5.0F;
		this.nyanFrontRightLeg.rotationPointY = 13.8F;
		this.nyanFrontRightLeg.rotationPointZ = -5.0F;
		this.nyanBackLeftLeg.rotationPointY = 18.0F;
		this.nyanBackLeftLeg.rotationPointZ = 5.0F;
		this.nyanBackRightLeg.rotationPointY = 18.0F;
		this.nyanBackRightLeg.rotationPointZ = 5.0F;
		this.nyanTail.rotateAngleX = 0.9F;
		this.state = 2;
	}
}