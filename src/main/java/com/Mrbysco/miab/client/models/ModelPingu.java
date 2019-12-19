package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.memes.EntityPingu;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelPingu extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer ArmLeft;
    public ModelRenderer ArmRight;
    public ModelRenderer Head;
    public ModelRenderer FeetLeft;
    public ModelRenderer FeetRight;
    public ModelRenderer Body2;
    public ModelRenderer Mouth;

    public ModelPingu() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 14.5F, -0.5F);
        this.Head.addBox(-2.0F, -4.5F, -2.0F, 4, 4, 4, 0.0F);
        this.Mouth = new ModelRenderer(this, 12, 0);
        this.Mouth.setRotationPoint(0.0F, -2.0F, -2.5F);
        this.Mouth.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
        this.FeetRight = new ModelRenderer(this, 0, 10);
        this.FeetRight.mirror = true;
        this.FeetRight.setRotationPoint(1.5F, 23.0F, -1.0F);
        this.FeetRight.addBox(-1.0F, 0.0F, -4.0F, 2, 1, 5, 0.0F);
        this.FeetLeft = new ModelRenderer(this, 0, 10);
        this.FeetLeft.setRotationPoint(-1.5F, 23.0F, -1.0F);
        this.FeetLeft.addBox(-1.0F, 0.0F, -4.0F, 2, 1, 5, 0.0F);
        this.ArmLeft = new ModelRenderer(this, 0, 38);
        this.ArmLeft.setRotationPoint(3.5F, 14.0F, -0.5F);
        this.ArmLeft.addBox(-0.5F, 0.0F, -1.0F, 1, 7, 2, 0.0F);
        this.Body = new ModelRenderer(this, 0, 24);
        this.Body.setRotationPoint(0.0F, 18.5F, 0.0F);
        this.Body.addBox(-3.0F, -4.5F, -3.0F, 6, 9, 5, 0.0F);
        this.Body2 = new ModelRenderer(this, 24, 30);
        this.Body2.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.Body2.addBox(-2.5F, -3.5F, 0.6F, 5, 7, 1, 0.0F);
        this.ArmRight = new ModelRenderer(this, 0, 38);
        this.ArmRight.mirror = true;
        this.ArmRight.setRotationPoint(-3.5F, 14.0F, -0.5F);
        this.ArmRight.addBox(-0.5F, 0.0F, -1.0F, 1, 7, 2, 0.0F);
        this.Head.addChild(this.Mouth);
        this.Body.addChild(this.Body2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Head.render(f5);
        this.FeetRight.render(f5);
        this.FeetLeft.render(f5);
        this.ArmLeft.render(f5);
        this.Body.render(f5);
        this.ArmRight.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                                  float headPitch, float scaleFactor, Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        this.FeetRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
        this.FeetLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
        this.FeetRight.rotateAngleY = 0.0F;
        this.FeetLeft.rotateAngleY = 0.0F;

        EntityPingu pingu = (EntityPingu)entityIn;

        if (pingu.isArmsRaised())
        {
            float f = MathHelper.sin(this.swingProgress * (float)Math.PI);
            float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
            this.ArmRight.rotateAngleZ = 0.0F;
            this.ArmLeft.rotateAngleZ = 0.0F;
            this.ArmRight.rotateAngleY = -(0.1F - f * 0.6F);
            this.ArmLeft.rotateAngleY = 0.1F - f * 0.6F;
            this.ArmRight.rotateAngleX = -((float)Math.PI / 2F);
            this.ArmLeft.rotateAngleX = -((float)Math.PI / 2F);
            this.ArmRight.rotateAngleX -= f * 1.2F - f1 * 0.4F;
            this.ArmLeft.rotateAngleX -= f * 1.2F - f1 * 0.4F;
            this.ArmRight.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
            this.ArmLeft.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
            this.ArmRight.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
            this.ArmLeft.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        }
    }
}
