package com.Mrbysco.miab.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelHotDog extends ModelBase {
    public ModelRenderer right_arm;
    public ModelRenderer left_earpiece;
    public ModelRenderer left_arm;
    public ModelRenderer left_thigh;
    public ModelRenderer right_thigh;
    public ModelRenderer right_bun;
    public ModelRenderer torso;
    public ModelRenderer back_bun;
    public ModelRenderer head_top;
    public ModelRenderer right_earpiece;
    public ModelRenderer top_headset;
    public ModelRenderer d_right_headset;
    public ModelRenderer d_left_headset;
    public ModelRenderer left_bun;
    public ModelRenderer left_calf;
    public ModelRenderer left_foot;
    public ModelRenderer right_calf;
    public ModelRenderer right_foot;

    public ModelHotDog() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.right_earpiece = new ModelRenderer(this, 44, 58);
        this.right_earpiece.setRotationPoint(-1.0F, -5.4F, 0.5F);
        this.right_earpiece.addBox(-4.8F, 0.0F, -2.0F, 2, 3, 3, 0.0F);
        this.back_bun = new ModelRenderer(this, 24, 30);
        this.back_bun.setRotationPoint(-10.0F, -1.0F, 4.0F);
        this.back_bun.addBox(6.0F, -0.5F, -2.0F, 7, 16, 2, 0.0F);
        this.right_arm = new ModelRenderer(this, 34, 0);
        this.right_arm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.right_arm.addBox(-3.0F, -2.0F, -2.0F, 3, 8, 3, 0.0F);
        this.setRotateAngle(right_arm, -1.3962634015954636F, -0.10000736613927509F, 0.10000736613927509F);
        this.right_thigh = new ModelRenderer(this, 12, 48);
        this.right_thigh.setRotationPoint(-1.9F, 14.0F, 1.1F);
        this.right_thigh.addBox(-2.0F, 0.2F, -2.6F, 3, 4, 3, 0.0F);
        this.setRotateAngle(right_thigh, -0.2617993877991494F, 0.12217304763960307F, 0.0F);
        this.right_bun = new ModelRenderer(this, 12, 28);
        this.right_bun.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.right_bun.addBox(-6.0F, -0.5F, -2.0F, 2, 16, 4, 0.0F);
        this.top_headset = new ModelRenderer(this, 32, 55);
        this.top_headset.setRotationPoint(-1.0F, -5.4F, 1.5F);
        this.top_headset.addBox(-3.1F, -2.0F, -2.0F, 7, 1, 1, 0.0F);
        this.d_left_headset = new ModelRenderer(this, 48, 55);
        this.d_left_headset.setRotationPoint(-1.0F, -5.4F, 0.5F);
        this.d_left_headset.addBox(0.6F, -4.2F, -1.0F, 3, 1, 1, 0.0F);
        this.setRotateAngle(d_left_headset, 0.0F, 0.0F, 0.9424777960769379F);
        this.left_arm = new ModelRenderer(this, 22, 0);
        this.left_arm.mirror = true;
        this.left_arm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.left_arm.addBox(-1.0F, -2.0F, -2.0F, 3, 8, 3, 0.0F);
        this.setRotateAngle(left_arm, -1.3962634015954636F, 0.10000736613927509F, -0.10000736613927509F);
        this.left_bun = new ModelRenderer(this, 0, 28);
        this.left_bun.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.left_bun.addBox(3.0F, -0.5F, -2.0F, 2, 16, 4, 0.0F);
        this.left_thigh = new ModelRenderer(this, 0, 48);
        this.left_thigh.mirror = true;
        this.left_thigh.setRotationPoint(1.9F, 14.0F, 1.1F);
        this.left_thigh.addBox(-1.9F, 0.2F, -2.6F, 3, 4, 3, 0.0F);
        this.setRotateAngle(left_thigh, -0.2617993877991494F, -0.12217304763960307F, 0.0F);
        this.right_foot = new ModelRenderer(this, 42, 48);
        this.right_foot.setRotationPoint(-0.7F, 10.2F, -0.2F);
        this.right_foot.addBox(-2.0F, -1.9F, -1.2F, 4, 2, 4, 0.0F);
        this.setRotateAngle(right_foot, 0.2617993877991494F, -0.12217304763960307F, -0.017453292519943295F);
        this.left_calf = new ModelRenderer(this, 0, 55);
        this.left_calf.setRotationPoint(0.2F, 3.6F, -0.7F);
        this.left_calf.addBox(-2.0F, 0.0F, -2.0F, 3, 6, 3, 0.0F);
        this.setRotateAngle(left_calf, 0.2617993877991494F, 0.12217304763960307F, 0.0F);
        this.torso = new ModelRenderer(this, 0, 5);
        this.torso.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.torso.addBox(-4.0F, 0.0F, -2.0F, 7, 19, 4, 0.0F);
        this.head_top = new ModelRenderer(this, 2, 0);
        this.head_top.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.head_top.addBox(-3.1F, -1.0F, -2.0F, 5, 1, 4, 0.0F);
        this.d_right_headset = new ModelRenderer(this, 56, 55);
        this.d_right_headset.setRotationPoint(-1.0F, -5.4F, 0.5F);
        this.d_right_headset.addBox(-3.3F, -3.5F, -1.0F, 3, 1, 1, 0.0F);
        this.setRotateAngle(d_right_headset, 0.0F, 0.0F, -0.9424777960769379F);
        this.left_earpiece = new ModelRenderer(this, 54, 58);
        this.left_earpiece.setRotationPoint(-1.0F, -5.4F, 0.5F);
        this.left_earpiece.addBox(3.8F, 0.0F, -2.0F, 2, 3, 3, 0.0F);
        this.left_foot = new ModelRenderer(this, 26, 48);
        this.left_foot.setRotationPoint(-4.7F, 10.2F, 0.2F);
        this.left_foot.addBox(2.3F, -1.9F, -1.0F, 4, 2, 4, 0.0F);
        this.setRotateAngle(left_foot, 0.2617993877991494F, 0.12217304763960307F, 0.017453292519943295F);
        this.right_calf = new ModelRenderer(this, 12, 55);
        this.right_calf.setRotationPoint(-0.2F, 3.6F, -0.7F);
        this.right_calf.addBox(-2.0F, 0.0F, -2.0F, 3, 6, 3, 0.0F);
        this.setRotateAngle(right_calf, 0.2617993877991494F, -0.12217304763960307F, 0.0F);
        this.right_thigh.addChild(this.right_foot);
        this.left_thigh.addChild(this.left_calf);
        this.left_thigh.addChild(this.left_foot);
        this.right_thigh.addChild(this.right_calf);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.right_arm.render(f5);
        this.left_arm.render(f5);
        this.right_thigh.render(f5);
        this.head_top.render(f5);
        this.torso.render(f5);
        this.d_right_headset.render(f5);
        this.left_thigh.render(f5);
        this.right_earpiece.render(f5);
        this.d_left_headset.render(f5);
        this.back_bun.render(f5);
        this.left_earpiece.render(f5);
        this.left_bun.render(f5);
        this.right_bun.render(f5);
        this.top_headset.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
	    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);  
	    this.right_thigh.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1 * 0.5F;
        this.left_thigh.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1 * 0.5F;
        this.right_thigh.rotateAngleY = 0.0F;
        this.left_thigh.rotateAngleY = 0.0F;
    }
}
