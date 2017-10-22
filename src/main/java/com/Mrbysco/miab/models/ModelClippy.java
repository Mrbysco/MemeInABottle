package com.Mrbysco.miab.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelClippy extends ModelBase {
    public ModelRenderer Clip;
    public ModelRenderer RightEye;
    public ModelRenderer LeftEye;
    public ModelRenderer LeftBrow;
    public ModelRenderer RightBrow;
    public ModelRenderer ClipPart;
    public ModelRenderer ClipPart1;
    public ModelRenderer ClipPart2;
    public ModelRenderer ClipPart3;
    public ModelRenderer ClipPart4;
    public ModelRenderer ClipPart5;
    public ModelRenderer ClipPart6;
    public ModelRenderer ClipPart7;
    public ModelRenderer ClipPart8;
    public ModelRenderer ClipPart9;
    public ModelRenderer ClipPart10;
    public ModelRenderer ClipPart11;
    public ModelRenderer ClipPart12;
    public ModelRenderer ClipPart13;
    public ModelRenderer ClipPart14;
    public ModelRenderer LeftBrowPart;
    public ModelRenderer RightBrowPart;

    public ModelClippy() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.ClipPart1 = new ModelRenderer(this, 28, 0);
        this.ClipPart1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ClipPart1.addBox(7.0F, 4.0F, 0.0F, 2, 6, 2, 0.0F);
        this.ClipPart2 = new ModelRenderer(this, 36, 0);
        this.ClipPart2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ClipPart2.addBox(9.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.ClipPart9 = new ModelRenderer(this, 0, 18);
        this.ClipPart9.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ClipPart9.addBox(5.0F, -20.0F, 0.0F, 2, 20, 2, 0.0F);
        this.setRotateAngle(ClipPart9, 0.0F, 0.01832595714594046F, 0.0F);
        this.LeftBrowPart = new ModelRenderer(this, 40, 22);
        this.LeftBrowPart.setRotationPoint(-1.0F, 10.0F, -1.0F);
        this.LeftBrowPart.addBox(10.0F, -28.0F, -1.0F, 2, 2, 2, 0.0F);
        this.ClipPart4 = new ModelRenderer(this, 52, 0);
        this.ClipPart4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ClipPart4.addBox(-7.0F, 0.0F, 0.0F, 2, 10, 2, 0.0F);
        this.Clip = new ModelRenderer(this, 0, 0);
        this.Clip.setRotationPoint(-1.0F, 10.0F, -1.0F);
        this.Clip.addBox(-3.0F, 12.0F, 0.0F, 8, 2, 2, 0.0F);
        this.ClipPart8 = new ModelRenderer(this, 16, 8);
        this.ClipPart8.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ClipPart8.addBox(-3.0F, -24.0F, 0.0F, 6, 2, 2, 0.0F);
        this.ClipPart14 = new ModelRenderer(this, 34, 12);
        this.ClipPart14.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ClipPart14.addBox(-5.0F, -4.0F, 0.0F, 2, 2, 2, 0.0F);
        this.ClipPart = new ModelRenderer(this, 20, 0);
        this.ClipPart.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ClipPart.addBox(5.0F, 10.0F, 0.0F, 2, 2, 2, 0.0F);
        this.LeftEye = new ModelRenderer(this, 32, 32);
        this.LeftEye.setRotationPoint(-1.0F, 10.0F, -1.0F);
        this.LeftEye.addBox(3.0F, -15.0F, -2.0F, 6, 6, 2, 0.0F);
        this.ClipPart6 = new ModelRenderer(this, 8, 4);
        this.ClipPart6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ClipPart6.addBox(-7.0F, -20.0F, 0.0F, 2, 8, 2, 0.0F);
        this.RightEye = new ModelRenderer(this, 16, 32);
        this.RightEye.setRotationPoint(-1.0F, 10.0F, -1.0F);
        this.RightEye.addBox(-10.0F, -15.0F, -2.0F, 6, 6, 2, 0.0F);
        this.ClipPart7 = new ModelRenderer(this, 16, 4);
        this.ClipPart7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ClipPart7.addBox(-5.0F, -22.0F, 0.0F, 2, 2, 2, 0.0F);
        this.RightBrowPart = new ModelRenderer(this, 16, 22);
        this.RightBrowPart.setRotationPoint(-1.0F, 10.0F, -1.0F);
        this.RightBrowPart.addBox(-11.0F, -28.0F, -1.0F, 2, 2, 2, 0.0F);
        this.ClipPart5 = new ModelRenderer(this, 0, 4);
        this.ClipPart5.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.ClipPart5.addBox(-9.0F, -16.0F, 0.0F, 2, 12, 2, 0.0F);
        this.RightBrow = new ModelRenderer(this, 16, 26);
        this.RightBrow.setRotationPoint(-1.0F, 10.0F, -1.0F);
        this.RightBrow.addBox(-10.0F, -20.0F, -2.0F, 6, 2, 2, 0.0F);
        this.ClipPart12 = new ModelRenderer(this, 15, 12);
        this.ClipPart12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ClipPart12.addBox(-1.0F, 6.0F, 0.0F, 4, 2, 2, 0.0F);
        this.LeftBrow = new ModelRenderer(this, 32, 26);
        this.LeftBrow.setRotationPoint(-1.0F, 10.0F, -1.0F);
        this.LeftBrow.addBox(3.0F, -20.0F, -2.0F, 6, 2, 2, 0.0F);
        this.ClipPart13 = new ModelRenderer(this, 26, 12);
        this.ClipPart13.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ClipPart13.addBox(-3.0F, -2.0F, 0.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(ClipPart13, 0.0F, 0.01832595714594046F, 0.0F);
        this.ClipPart3 = new ModelRenderer(this, 44, 0);
        this.ClipPart3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ClipPart3.addBox(-5.0F, 10.0F, 0.0F, 2, 2, 2, 0.0F);
        this.ClipPart10 = new ModelRenderer(this, 32, 8);
        this.ClipPart10.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ClipPart10.addBox(3.0F, -22.0F, 0.0F, 2, 2, 2, 0.0F);
        this.ClipPart11 = new ModelRenderer(this, 44, 4);
        this.ClipPart11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ClipPart11.addBox(3.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(ClipPart11, 0.0F, 0.01832595714594046F, 0.0F);
        this.Clip.addChild(this.ClipPart1);
        this.Clip.addChild(this.ClipPart2);
        this.Clip.addChild(this.ClipPart9);
        this.LeftBrow.addChild(this.LeftBrowPart);
        this.Clip.addChild(this.ClipPart4);
        this.Clip.addChild(this.ClipPart8);
        this.Clip.addChild(this.ClipPart14);
        this.Clip.addChild(this.ClipPart);
        this.Clip.addChild(this.ClipPart6);
        this.Clip.addChild(this.ClipPart7);
        this.RightBrow.addChild(this.RightBrowPart);
        this.Clip.addChild(this.ClipPart5);
        this.Clip.addChild(this.ClipPart12);
        this.Clip.addChild(this.ClipPart13);
        this.Clip.addChild(this.ClipPart3);
        this.Clip.addChild(this.ClipPart10);
        this.Clip.addChild(this.ClipPart11);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	GlStateManager.translate(0.0F, 0.001F, 0.0F);
    	this.Clip.render(f5);
        this.RightEye.render(f5);
        this.LeftEye.render(f5);
        this.RightBrow.render(f5);
        this.LeftBrow.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
