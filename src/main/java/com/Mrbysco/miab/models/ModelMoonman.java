package com.Mrbysco.miab.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelMoonman extends ModelBase {
    public ModelRenderer Right_arm;
    public ModelRenderer Right_leg;
    public ModelRenderer Torso;
    public ModelRenderer Left_arm;
    public ModelRenderer Left_leg;
    public ModelRenderer Moon5;
    public ModelRenderer Moon4;
    public ModelRenderer Moon3;
    public ModelRenderer Moon2;
    public ModelRenderer Moon1;

    public ModelMoonman() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Moon3 = new ModelRenderer(this, 0, 12);
        this.Moon3.mirror = true;
        this.Moon3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Moon3.addBox(-3.0F, -5.0F, 0.0F, 6, 2, 2, 0.0F);
        this.Left_arm = new ModelRenderer(this, 40, 16);
        this.Left_arm.mirror = true;
        this.Left_arm.setRotationPoint(5.0F, 2.0F, -0.0F);
        this.Left_arm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotation(Left_arm, -1.5707963267948966F, 0.10000736613927509F, -0.10000736613927509F);
        this.Moon4 = new ModelRenderer(this, 0, 6);
        this.Moon4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Moon4.addBox(-3.0F, -7.0F, -2.0F, 6, 2, 4, 0.0F);
        this.Moon2 = new ModelRenderer(this, 20, 6);
        this.Moon2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Moon2.addBox(-3.0F, -3.0F, -2.0F, 6, 2, 4, 0.0F);
        this.Right_arm = new ModelRenderer(this, 40, 16);
        this.Right_arm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.Right_arm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotation(Right_arm, -1.5707963267948966F, -0.10000736613927509F, 0.10000736613927509F);
        this.Left_leg = new ModelRenderer(this, 0, 16);
        this.Left_leg.mirror = true;
        this.Left_leg.setRotationPoint(1.9F, 12.0F, 0.1F);
        this.Left_leg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.Moon1 = new ModelRenderer(this, 20, 0);
        this.Moon1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Moon1.addBox(-3.0F, -1.0F, -4.0F, 6, 2, 4, 0.0F);
        this.Torso = new ModelRenderer(this, 16, 16);
        this.Torso.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Torso.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.Right_leg = new ModelRenderer(this, 0, 16);
        this.Right_leg.setRotationPoint(-1.9F, 12.0F, 0.1F);
        this.Right_leg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.Moon5 = new ModelRenderer(this, 0, 0);
        this.Moon5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Moon5.addBox(-3.0F, -9.0F, -4.0F, 6, 2, 4, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Moon3.render(f5);
        this.Left_arm.render(f5);
        this.Moon4.render(f5);
        this.Moon2.render(f5);
        this.Right_arm.render(f5);
        this.Left_leg.render(f5);
        this.Moon1.render(f5);
        this.Torso.render(f5);
        this.Right_leg.render(f5);
        this.Moon5.render(f5);
    }

    public void setRotation(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
	    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);  
	    this.Right_leg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1 * 0.5F;
        this.Left_leg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1 * 0.5F;
        this.Right_leg.rotateAngleY = 0.0F;
        this.Left_leg.rotateAngleY = 0.0F;
    }
}
