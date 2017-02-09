package com.Mrbysco.MIAB.renderer.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelSanic extends ModelBase {
    public ModelRenderer Body;

    public ModelSanic() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.Body.addBox(-7.0F, 2.0F, -7.0F, 14, 14, 14, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Body.render(f5);
    }

    public void setRotation(ModelRenderer modelRenderer, float x, float y, float z) {
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
