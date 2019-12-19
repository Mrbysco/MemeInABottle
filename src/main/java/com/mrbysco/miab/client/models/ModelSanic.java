package com.mrbysco.miab.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelSanic extends ModelBase {
	private final ModelRenderer Body;

	public ModelSanic() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 17.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 0, -7.0F, -7.0F, -7.0F, 14, 14, 14, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Body.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Body.rotateAngleX = MathHelper.cos(f * 0.6662F) * 3F * f1;
		this.Body.rotateAngleY = 0.0F;
	}
}