package com.Mrbysco.miab.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelNigel extends ModelBase {
    public ModelRenderer right_arm;
    public ModelRenderer right_leg;
    public ModelRenderer torso;
    public ModelRenderer left_arm;
    public ModelRenderer left_leg;
    public ModelRenderer head;

    public ModelNigel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        
        this.setTextureOffset("head.headpart1", 0, 55);
        this.setTextureOffset("head.headpart2", 1, 47);
        this.setTextureOffset("head.headpart3", 1, 36);
        this.setTextureOffset("head.headnose", 22, 60);
        this.setTextureOffset("head.headmustache", 28, 60);
        
        this.head = new ModelRenderer(this, "head");
        this.head.addBox("headpart1", -2.0F, -3.0F, -4.0F, 4, 3, 6);
        this.head.addBox("headpart2", -3.0F, -7.0F, -3.0F, 6, 4, 5);
        this.head.addBox("headpart3", -4.0F, -12.0F, -3.0F, 8, 5, 5);
        this.head.addBox("headnose", -1.0F, -9.0F, -4.0F, 2, 3, 1);  
        this.head.addBox("headmustache", -4.0F, -6.0F, -5.0F, 8, 2, 2);
        this.torso = new ModelRenderer(this, 16, 16);
        this.torso.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.torso.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.right_leg = new ModelRenderer(this, 0, 16);
        this.right_leg.setRotationPoint(-1.9F, 12.0F, 0.1F);
        this.right_leg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.left_leg = new ModelRenderer(this, 0, 16);
        this.left_leg.mirror = true;
        this.left_leg.setRotationPoint(1.9F, 12.0F, 0.1F);
        this.left_leg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.left_arm = new ModelRenderer(this, 40, 16);
        this.left_arm.mirror = true;
        this.left_arm.setRotationPoint(5.0F, 2.0F, -0.0F);
        this.left_arm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotation(left_arm, -1.5707963267948966F, 0.10000736613927509F, -0.10000736613927509F);
        this.right_arm = new ModelRenderer(this, 40, 16);
        this.right_arm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.right_arm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotation(right_arm, -1.5707963267948966F, -0.10000736613927509F, 0.10000736613927509F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.right_leg.render(f5);
        this.head.render(f5);
        this.left_arm.render(f5);
        this.right_arm.render(f5);
        this.torso.render(f5);
        this.left_leg.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotation(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
	    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);  
	    this.right_leg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1 * 0.5F;
        this.left_leg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1 * 0.5F;
        this.right_leg.rotateAngleY = 0.0F;
        this.left_leg.rotateAngleY = 0.0F;
    }
}
