package com.Mrbysco.MIAB.entity.monsters.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBill extends ModelBase
{
	  //fields
	    ModelRenderer Hat1;
	    ModelRenderer Hat;
	    ModelRenderer head;
	    ModelRenderer body7;
	    ModelRenderer body6;
	    ModelRenderer body5;
	    ModelRenderer body4;
	    ModelRenderer body3;
	    ModelRenderer body2;
	    ModelRenderer body1;
	    ModelRenderer body;
	    ModelRenderer rightarm;
	    ModelRenderer leftarm;
	    ModelRenderer rightleg;
	    ModelRenderer leftleg;
	  
	  public ModelBill()
	  {
	    
	    this.Hat1 = new ModelRenderer(this, 4, 24);
	    this.Hat1.addBox(-1F, -6F, -1F, 2, 6, 2);
	    this.Hat1.setRotationPoint(0F, 0F, 0F);
	    this.setRotation(Hat1, 0F, 0F, 0F);
	      
	    this.Hat = new ModelRenderer(this, 0, 20);
	    this.Hat.addBox(-3F, 0F, -1F, 6, 2, 2);
	    this.Hat.setRotationPoint(0F, 0F, 0F);
	    this.setRotation(Hat, 0F, 0F, 0F);
	      
	    this.head = new ModelRenderer(this, 0, 0);
	    this.head.addBox(-3F, 6F, -1.1F, 6, 6, 1);
	    this.setRotation(head, 0F, 0F, 0F);
	      
	    this.body7 = new ModelRenderer(this, 28, 0);
	    this.body7.addBox(-1F, 2F, -1F, 2, 2, 2);
	    this.body7.setRotationPoint(0F, 0F, 0F);
	    this.setRotation(body7, 0F, 0F, 0F);
	      
	    this.body6 = new ModelRenderer(this, 26, 4);
	    this.body6.addBox(0F, 4F, -1F, 4, 2, 2);
	    this.body6.setRotationPoint(-2F, 0F, 0F);;
	    this.setRotation(body6, 0F, 0F, 0F);
	      
	    this.body5 = new ModelRenderer(this, 24, 8);
	    this.body5.addBox(-3F, 6F, -1F, 6, 2, 2);
	    this.body5.setRotationPoint(0F, 0F, 0F);
	    this.setRotation(body5, 0F, 0F, 0F);
	      
	    this.body4 = new ModelRenderer(this, 22, 12);
	    this.body4.addBox(-4F, 8F, -1F, 8, 2, 2);
	    this.body4.setRotationPoint(0F, 0F, 0F);
	    this.setRotation(body4, 0F, 0F, 0F);
	      
	    this.body3 = new ModelRenderer(this, 20, 16);
	    this.body3.addBox(-4F, 10F, -1F, 8, 2, 2);
	    this.body3.setRotationPoint(0F, 0F, 0F);
	    this.setRotation(body3, 0F, 0F, 0F);
	      
	    this.body2 = new ModelRenderer(this, 18, 20);
	    this.body2.addBox(-6F, 12F, -1F, 12, 2, 2);
	    this.body2.setRotationPoint(0F, 0F, 0F);
	    this.setRotation(body2, 0F, 0F, 0F);
	      
	    this.body1 = new ModelRenderer(this, 16, 24);
	    this.body1.addBox(-7F, 14F, -1F, 14, 2, 2);
	    this.body1.setRotationPoint(0F, 0F, 0F);
	    this.setRotation(body1, 0F, 0F, 0F);
	      
	    this.body = new ModelRenderer(this, 14, 28);
	    this.body.addBox(-8F, 16F, -1F, 16, 2, 2);
	    this.body.setRotationPoint(0F, 0F, 0F);
	    this.setRotation(body, 0F, 0F, 0F);
	      
	    this.rightarm = new ModelRenderer(this, 8, 8);
	    this.rightarm.addBox(-1F, -1F, -1F, 2, 8, 2);
	    this.rightarm.setRotationPoint(-5F, 11F, 0F);
	    this.setRotation(rightarm, -1.570796F, 0F, 0F);
	      
	    this.leftarm = new ModelRenderer(this, 8, 8);
	    this.leftarm.addBox(-1F, -1F, -1F, 2, 8, 2);
	    this.leftarm.setRotationPoint(5F, 11F, 0F);
	    this.setRotation(leftarm, -1.570796F, 0F, 0F);
	      
	    this.rightleg = new ModelRenderer(this, 0, 8);
	    this.rightleg.addBox(-2F, 6F, -1F, 2, 6, 2);
	    this.rightleg.setRotationPoint(-2F, 12F, 0F);
	    this.setRotation(rightleg, 0F, 0F, 0F);
	      
	    this.leftleg = new ModelRenderer(this, 0, 8);
	    this.leftleg.addBox(0F, 6F, -1F, 2, 6, 2);
	    this.leftleg.setRotationPoint(2F, 12F, 0F);
	    this.setRotation(leftleg, 0F, 0F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, Entity entityIn)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entityIn);
	    Hat1.render(f5);
	    Hat.render(f5);
	    head.render(f5);
	    body7.render(f5);
	    body6.render(f5);
	    body5.render(f5);
	    body4.render(f5);
	    body3.render(f5);
	    body2.render(f5);
	    body1.render(f5);
	    body.render(f5);
	    rightarm.render(f5);
	    leftarm.render(f5);
	    rightleg.render(f5);
	    leftleg.render(f5);
	  }
	  
	  private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	  }
	  
	  public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity entityIn)
	    {
	        super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, entityIn);
	        float f = MathHelper.sin(this.swingProgress * (float)Math.PI);
	        float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
	        this.rightarm.rotateAngleZ = 0.0F;
	        this.leftarm.rotateAngleZ = 0.0F;
	        this.rightarm.rotateAngleY = -(0.1F - f * 0.6F);
	        this.leftarm.rotateAngleY = 0.1F - f * 0.6F;
	        this.rightarm.rotateAngleX = -((float)Math.PI / 2F);
	        this.leftarm.rotateAngleX = -((float)Math.PI / 2F);
	        this.rightarm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
	        this.leftarm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
	        this.rightarm.rotateAngleZ += MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
	        this.leftarm.rotateAngleZ -= MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
	        this.rightarm.rotateAngleX += MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
	        this.leftarm.rotateAngleX -= MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
	    }

	}
