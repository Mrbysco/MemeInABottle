package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.memes.EntitySanic;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

public class ModelSanic<T extends EntitySanic> extends EntityModel<T> {
	private final RendererModel Body;

	public ModelSanic() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new RendererModel(this);
		Body.setRotationPoint(0.0F, 17.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 0, -7.0F, -7.0F, -7.0F, 14, 14, 14, 0.0F, true));
	}

	@Override
	public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Body.render(f5);
	}

	public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
		RendererModel.rotateAngleX = x;
		RendererModel.rotateAngleY = y;
		RendererModel.rotateAngleZ = z;
	}

	public void setRotationAngles(T entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(entity, f, f1, f2, f3, f4, f5);
		this.Body.rotateAngleX = MathHelper.cos(f * 0.6662F) * 3F * f1;
		this.Body.rotateAngleY = 0.0F;
	}
}