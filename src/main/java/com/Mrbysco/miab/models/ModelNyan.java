package com.Mrbysco.miab.models;

import com.Mrbysco.miab.entities.base.EntityCatBase;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

public class ModelNyan extends ModelBase {
	public ModelRenderer nyanhead;
    public ModelRenderer nyantail;
    public ModelRenderer nyanbody;
    public ModelRenderer nyanbackrightleg;
    public ModelRenderer nyanfrontrightleg;
    public ModelRenderer nyanbackleftleg;
    public ModelRenderer nyanfrontleftleg;
    private int state = 1;

    public ModelNyan() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("head.main", 1, 1);
        this.setTextureOffset("head.nose", 1, 25);
        this.setTextureOffset("head.ear1", 0, 10);
        this.setTextureOffset("head.ear2", 6, 10);
        this.nyanhead = new ModelRenderer(this, "head");
        this.nyanhead.addBox("ear2", 1.0F, -3.0F, 0.0F, 1, 1, 2);
        this.nyanhead.addBox("ear1", -2.0F, -3.0F, 0.0F, 1, 1, 2);
        this.nyanhead.addBox("main", -2.5F, -2.0F, -2.0F, 5, 4, 4);  
        this.nyanhead.addBox("nose", -1.5F, 0.0F, -3.0F, 3, 2, 1);
        this.nyanfrontleftleg = new ModelRenderer(this, 48, 0);
        this.nyanfrontleftleg.setRotationPoint(1.2F, 19.0F, -5.0F);
        this.nyanfrontleftleg.addBox(-1.0F, 0.0F, 0.0F, 2, 10, 2);
        this.nyantail = new ModelRenderer(this, 0, 15);
        this.nyantail.setRotationPoint(0.0F, 15.0F, 8.0F);
        this.nyantail.addBox(-0.5F, -1.0F, -1.0F, 1, 8, 1, 0.0F);
        this.nyanbackrightleg = new ModelRenderer(this, 8, 13);
        this.nyanbackrightleg.setRotationPoint(-1.1F, 19.0F, 5.0F);
        this.nyanbackrightleg.addBox(-1.0F, 0.0F, 1.0F, 2, 6, 2);
        this.nyanfrontrightleg = new ModelRenderer(this, 48, 0);
        this.nyanfrontrightleg.setRotationPoint(-1.2F, 19.0F, -5.0F);
        this.nyanfrontrightleg.addBox(-1.0F, 0.0F, 0.0F, 2, 10, 2);
        this.nyanbody = new ModelRenderer(this, 20, 0);
        this.nyanbody.setRotationPoint(0.0F, 12.0F, -10.0F);
        this.nyanbody.addBox(-2.0F, 3.0F, -8.0F, 4, 16, 9, 0.0F);
        this.nyanbackleftleg = new ModelRenderer(this, 8, 13);
        this.nyanbackleftleg.setRotationPoint(1.1F, 19.0F, 5.0F);
        this.nyanbackleftleg.addBox(-1.0F, 0.0F, 1.0F, 2, 6, 2);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
            this.nyanhead.render(scale);
            this.nyanbody.render(scale);
            this.nyantail.render(scale);
            this.nyanfrontleftleg.render(scale);
            this.nyanbackrightleg.render(scale);
            this.nyanfrontrightleg.render(scale);
            this.nyanbackleftleg.render(scale);
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        this.nyanhead.rotateAngleX = headPitch * 0.017453292F;
        this.nyanhead.rotateAngleY = netHeadYaw * 0.017453292F;

        if (this.state != 3)
        {
            this.nyanbody.rotateAngleX = ((float)Math.PI / 2F);
            this.nyanfrontleftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
            this.nyanbackrightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
            this.nyanfrontleftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
            this.nyanbackrightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
            
        }
    }
    
    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float p_78086_2_, float p_78086_3_, float partialTickTime)
    {
        EntityCatBase entityocelot = (EntityCatBase)entitylivingbaseIn;
        this.nyanbody.rotationPointY = 12.0F;
        this.nyanbody.rotationPointZ = -10.0F;
        this.nyanhead.rotationPointY = 15.0F;
        this.nyanhead.rotationPointZ = -9.0F;
        this.nyantail.rotationPointY = 15.0F;
        this.nyantail.rotationPointZ = 8.0F;
        this.nyanfrontleftleg.rotationPointY = 13.8F;
        this.nyanfrontleftleg.rotationPointZ = -5.0F;
        this.nyanfrontrightleg.rotationPointY = 13.8F;
        this.nyanfrontrightleg.rotationPointZ = -5.0F;
        this.nyanbackleftleg.rotationPointY = 18.0F;
        this.nyanbackleftleg.rotationPointZ = 5.0F;
        this.nyanbackrightleg.rotationPointY = 18.0F;
        this.nyanbackrightleg.rotationPointZ = 5.0F;
        this.nyantail.rotateAngleX = 0.9F;
        this.state = 2;
   }
}