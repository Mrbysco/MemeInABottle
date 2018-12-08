package com.Mrbysco.miab.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelKnucklesQueen extends ModelBase {
    public ModelRenderer left_arm_2;
    public ModelRenderer right_leg_2;
    public ModelRenderer right_arm_2;
    public ModelRenderer left_leg_2;
    public ModelRenderer right_arm;
    public ModelRenderer right_leg;
    public ModelRenderer body;
    public ModelRenderer left_arm;
    public ModelRenderer left_leg;
    public ModelRenderer body_2;
    public ModelRenderer head;
    public ModelRenderer head_top;
    public ModelRenderer mouth;
    public ModelRenderer mouth_top;
    public ModelRenderer nose;

    public ModelKnucklesQueen() {
    	this.textureWidth = 64;
        this.textureHeight = 64;
        this.mouth = new ModelRenderer(this, 22, 2);
        this.mouth.setRotationPoint(-0.5F, -0.5F, -2.5F);
        this.mouth.addBox(-3.0F, 0.0F, -0.5F, 6, 2, 1, 0.0F);
        this.right_leg = new ModelRenderer(this, 0, 16);
        this.right_leg.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.right_leg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.head_top = new ModelRenderer(this, 0, 0);
        this.head_top.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.head_top.addBox(-3.0F, -1.0F, -2.0F, 5, 1, 3, 0.0F);
        this.head = new ModelRenderer(this, 0, 5);
        this.head.setRotationPoint(0.5F, -2.6F, 0.0F);
        this.head.addBox(-4.0F, -2.0F, -2.0F, 7, 4, 4, 0.0F);
        this.body_2 = new ModelRenderer(this, 16, 32);
        this.body_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body_2.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.25F);
        this.left_arm_2 = new ModelRenderer(this, 48, 48);
        this.left_arm_2.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.left_arm_2.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F);
        this.left_leg_2 = new ModelRenderer(this, 0, 48);
        this.left_leg_2.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.left_leg_2.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F);
        this.left_leg = new ModelRenderer(this, 16, 48);
        this.left_leg.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.left_leg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.right_leg_2 = new ModelRenderer(this, 0, 32);
        this.right_leg_2.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.right_leg_2.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F);
        this.mouth_top = new ModelRenderer(this, 22, 0);
        this.mouth_top.setRotationPoint(-0.5F, -1.0F, -2.5F);
        this.mouth_top.addBox(-2.0F, 0.0F, -0.4F, 4, 1, 1, 0.0F);
        this.right_arm = new ModelRenderer(this, 40, 16);
        this.right_arm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.right_arm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.right_arm_2 = new ModelRenderer(this, 40, 32);
        this.right_arm_2.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.right_arm_2.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F);
        this.nose = new ModelRenderer(this, 17, 0);
        this.nose.setRotationPoint(-0.5F, -0.2F, -3.0F);
        this.nose.addBox(-0.5F, -0.6F, -0.5F, 1, 1, 1, 0.0F);
        this.left_arm = new ModelRenderer(this, 32, 48);
        this.left_arm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.left_arm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.head.addChild(this.mouth);
        this.head.addChild(this.head_top);
        this.head.addChild(this.mouth_top);
        this.head.addChild(this.nose);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.left_arm.render(f5);
        this.right_leg_2.render(f5);
        this.left_arm_2.render(f5);
        this.body.render(f5);
        this.left_leg.render(f5);
        this.right_arm.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.head.offsetX, this.head.offsetY, this.head.offsetZ);
        GlStateManager.translate(this.head.rotationPointX * f5, this.head.rotationPointY * f5, this.head.rotationPointZ * f5);
        GlStateManager.scale(1.3D, 1.3D, 1.3D);
        GlStateManager.translate(-this.head.offsetX, -this.head.offsetY, -this.head.offsetZ);
        GlStateManager.translate(-this.head.rotationPointX * f5, -this.head.rotationPointY * f5, -this.head.rotationPointZ * f5);
        this.head.render(f5);
        GlStateManager.popMatrix();
        this.right_leg.render(f5);
        this.body_2.render(f5);
        this.right_arm_2.render(f5);
        this.left_leg_2.render(f5);
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
    		float headPitch, float scaleFactor, Entity entityIn) {
    	super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
    	this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
        this.right_leg.rotateAngleY = 0.0F;
        this.left_leg.rotateAngleY = 0.0F;
        copyModelAngles(this.left_leg, this.left_leg_2);
        copyModelAngles(this.right_leg, this.right_arm_2);
        copyModelAngles(this.left_arm, this.left_arm_2);
        copyModelAngles(this.right_arm, this.right_arm_2);
        copyModelAngles(this.body, this.body_2);
    }
    
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
