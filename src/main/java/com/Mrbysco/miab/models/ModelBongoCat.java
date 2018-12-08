package com.Mrbysco.miab.models;

import com.Mrbysco.miab.entities.passive.EntityBongoCat;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelBongoCat - Mrbysco
 * Created using Tabula 7.0.0
 */
public class ModelBongoCat extends ModelBase {
    public ModelRenderer Right_Paw;
    public ModelRenderer Right_Bottom_Paw;
    public ModelRenderer Head;
    public ModelRenderer Torso;
    public ModelRenderer Left_Paw;
    public ModelRenderer Left_Bottom_Paw;
    public ModelRenderer Right_Ear;
    public ModelRenderer Left_ear;

    public ModelBongoCat() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Left_Paw = new ModelRenderer(this, 40, 16);
        this.Left_Paw.mirror = true;
        this.Left_Paw.setRotationPoint(4.0F, 14.0F, 0.0F);
        this.Left_Paw.addBox(-1.0F, -2.0F, -2.0F, 3, 6, 3, 0.0F);
        this.setRotateAngle(Left_Paw, -1.3962634015954636F, 0.10000736613927509F, -0.10000736613927509F);
        this.Right_Paw = new ModelRenderer(this, 40, 16);
        this.Right_Paw.setRotationPoint(-4.0F, 14.0F, 0.0F);
        this.Right_Paw.addBox(-2.0F, -2.0F, -2.0F, 3, 6, 3, 0.0F);
        this.setRotateAngle(Right_Paw, -1.3962634015954636F, -0.10000736613927509F, 0.10000736613927509F);
        this.Right_Ear = new ModelRenderer(this, 10, 0);
        this.Right_Ear.setRotationPoint(-3.0F, -7.7F, -1.0F);
        this.Right_Ear.addBox(0.0F, 0.0F, 0.0F, 3, 2, 2, 0.0F);
        this.setRotateAngle(Right_Ear, 0.0F, 0.0F, 0.5235987755982988F);
        this.Right_Bottom_Paw = new ModelRenderer(this, 0, 16);
        this.Right_Bottom_Paw.setRotationPoint(-1.0F, 18.0F, 0.1F);
        this.Right_Bottom_Paw.addBox(-2.0F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
        this.Left_Bottom_Paw = new ModelRenderer(this, 0, 16);
        this.Left_Bottom_Paw.mirror = true;
        this.Left_Bottom_Paw.setRotationPoint(2.0F, 18.0F, 0.1F);
        this.Left_Bottom_Paw.addBox(-2.0F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
        this.Left_ear = new ModelRenderer(this, 0, 0);
        this.Left_ear.setRotationPoint(1.0F, -7.7F, -1.02F);
        this.Left_ear.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(Left_ear, 0.0F, 0.0F, 1.0471975511965976F);
        this.Torso = new ModelRenderer(this, 16, 16);
        this.Torso.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.Torso.addBox(-3.0F, 0.0F, -2.0F, 6, 6, 4, 0.0F);
        this.Head = new ModelRenderer(this, 1, 6);
        this.Head.setRotationPoint(1.0F, 12.0F, 0.0F);
        this.Head.addBox(-4.0F, -6.0F, -2.0F, 6, 6, 4, 0.0F);
        this.Head.addChild(this.Right_Ear);
        this.Head.addChild(this.Left_ear);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Left_Paw.render(f5);
        this.Right_Paw.render(f5);
        this.Right_Bottom_Paw.render(f5);
        this.Left_Bottom_Paw.render(f5);
        this.Torso.render(f5);
        this.Head.render(f5);
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
    		float headPitch, float scaleFactor, Entity entityIn) {
    	super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);  
	    this.Right_Bottom_Paw.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
        this.Left_Bottom_Paw.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
        this.Right_Bottom_Paw.rotateAngleY = 0.0F;
        this.Left_Bottom_Paw.rotateAngleY = 0.0F;
        
        EntityBongoCat cat = (EntityBongoCat)entityIn;
        boolean flag = cat.isTapping();
        float f = MathHelper.sin(this.swingProgress * (float)Math.PI);
        float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
        this.Right_Paw.rotateAngleZ = 0.0F;
        this.Left_Paw.rotateAngleZ = 0.0F;
        this.Right_Paw.rotateAngleY = -(0.1F - f * 0.6F);
        this.Left_Paw.rotateAngleY = 0.1F - f * 0.6F;
        float f2 = -(float)Math.PI / (1.5F);
        this.Right_Paw.rotateAngleX = f2;
        this.Left_Paw.rotateAngleX = f2;
        
        //clap?
        float f3 = (flag ? ((MathHelper.cos(ageInTicks * 1F)) * 0.4F) : 0.0F);
        this.Right_Paw.rotateAngleX += f3;
        this.Left_Paw.rotateAngleX += -f3;
        
        this.Right_Paw.rotateAngleX += f * 1.2F - f1 * 0.4F;
        this.Left_Paw.rotateAngleX += f * 1.2F - f1 * 0.4F;
        this.Right_Paw.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.Left_Paw.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.Right_Paw.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        this.Left_Paw.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
    }
    
    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
