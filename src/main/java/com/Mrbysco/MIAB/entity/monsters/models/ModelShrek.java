package com.Mrbysco.MIAB.entity.monsters.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelShrek extends ModelBase
{
	    	  //fields
	        ModelRenderer head;
	        ModelRenderer rightarm;
	        ModelRenderer leftarm;
	        ModelRenderer rightleg;
	        ModelRenderer leftleg;
	        ModelRenderer LeftEar1;
	        ModelRenderer LeftEar2;
	        ModelRenderer RightEar1;
	        ModelRenderer RightEar2;
	        ModelRenderer UpperBody;
	        ModelRenderer MiddleBody;
	        ModelRenderer LowerBody;
	      
	      public ModelShrek()
	      {
	        textureWidth = 64;
	        textureHeight = 64;
	        
	          head = new ModelRenderer(this, 0, 0);
	          head.addBox(-4F, -12F, -5.5F, 8, 8, 8);
	          head.setRotationPoint(0F, 0F, 0F);
	          head.setTextureSize(64, 64);
	          head.mirror = true;
	          setRotation(head, 0F, 0F, 0F);
	          rightarm = new ModelRenderer(this, 47, 16);
	          rightarm.addBox(-3F, -6F, -2F, 4, 14, 4);
	          rightarm.setRotationPoint(-5F, 2F, 0F);
	          rightarm.setTextureSize(64, 64);
	          rightarm.mirror = true;
	          setRotation(rightarm, -0.0371786F, 0F, 0F);
	          leftarm = new ModelRenderer(this, 0, 16);
	          leftarm.addBox(-1F, -6F, -2F, 4, 14, 4);
	          leftarm.setRotationPoint(5F, 2F, 0F);
	          leftarm.setTextureSize(64, 64);
	          leftarm.mirror = true;
	          setRotation(leftarm, -0.0371755F, 0F, 0F);
	          rightleg = new ModelRenderer(this, 47, 35);
	          rightleg.addBox(-2F, -4F, -1.5F, 4, 14, 4);
	          rightleg.setRotationPoint(-2F, 14F, 0F);
	          rightleg.setTextureSize(64, 64);
	          rightleg.mirror = true;
	          setRotation(rightleg, 0F, 0F, 0F);
	          leftleg = new ModelRenderer(this, 0, 35);
	          leftleg.addBox(-2F, -4F, -1.5F, 4, 14, 4);
	          leftleg.setRotationPoint(2F, 14F, 0F);
	          leftleg.setTextureSize(64, 64);
	          leftleg.mirror = true;
	          setRotation(leftleg, 0F, 0F, 0F);
	          LeftEar1 = new ModelRenderer(this, 32, 0);
	          LeftEar1.addBox(4F, -2F, -2.5F, 2, 2, 2);
	          LeftEar1.setRotationPoint(0F, -8F, 0F);
	          LeftEar1.setTextureSize(64, 64);
	          LeftEar1.mirror = true;
	          setRotation(LeftEar1, 0F, 0F, -0.1745329F);
	          LeftEar2 = new ModelRenderer(this, 32, 4);
	          LeftEar2.addBox(6F, -2.5F, -3F, 1, 3, 3);
	          LeftEar2.setRotationPoint(0F, -8F, 0F);
	          LeftEar2.setTextureSize(64, 64);
	          LeftEar2.mirror = true;
	          setRotation(LeftEar2, 0F, 0F, -0.1745329F);
	          RightEar1 = new ModelRenderer(this, 42, 0);
	          RightEar1.addBox(-6F, -2F, -2.5F, 2, 2, 2);
	          RightEar1.setRotationPoint(0F, -8F, 0F);
	          RightEar1.setTextureSize(64, 64);
	          RightEar1.mirror = true;
	          setRotation(RightEar1, 0F, 0F, 0.1745329F);
	          RightEar2 = new ModelRenderer(this, 42, 4);
	          RightEar2.addBox(-7F, -2.5F, -3F, 1, 3, 3);
	          RightEar2.setRotationPoint(0F, -8F, 0F);
	          RightEar2.setTextureSize(64, 64);
	          RightEar2.mirror = true;
	          setRotation(RightEar2, 0F, 0F, 0.1745329F);
	          UpperBody = new ModelRenderer(this, 16, 16);
	          UpperBody.addBox(-4F, -4F, -3.5F, 8, 4, 7);
	          UpperBody.setRotationPoint(0F, 0F, 0F);
	          UpperBody.setTextureSize(64, 64);
	          UpperBody.mirror = true;
	          setRotation(UpperBody, 0F, 0F, 0F);
	          MiddleBody = new ModelRenderer(this, 16, 28);
	          MiddleBody.addBox(-4F, 0F, -3F, 8, 6, 7);
	          MiddleBody.setRotationPoint(0F, 0F, 0F);
	          MiddleBody.setTextureSize(64, 64);
	          MiddleBody.mirror = true;
	          setRotation(MiddleBody, 0F, 0F, 0F);
	          LowerBody = new ModelRenderer(this, 16, 42);
	          LowerBody.addBox(-4F, 6F, -2.6F, 8, 4, 6);
	          LowerBody.setRotationPoint(0F, 0F, 0F);
	          LowerBody.setTextureSize(64, 64);
	          LowerBody.mirror = true;
	          setRotation(LowerBody, 0F, 0F, 0F);
	      }
	      
	      public void render(Entity entityIn, float f, float f1, float f2, float f3, float f4, float f5)
		  {
		    super.render(entityIn, f, f1, f2, f3, f4, f5);
		    setRotationAngles(f, f1, f2, f3, f4, f5, entityIn);
	        head.render(f5);
	        rightarm.render(f5);
	        leftarm.render(f5);
	        rightleg.render(f5);
	        leftleg.render(f5);
	        LeftEar1.render(f5);
	        LeftEar2.render(f5);
	        RightEar1.render(f5);
	        RightEar2.render(f5);
	        UpperBody.render(f5);
	        MiddleBody.render(f5);
	        LowerBody.render(f5);
	      };
	  
	  private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	  }
	  
	  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	  {
	    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);  
	    this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1 * 0.5F;
        this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1 * 0.5F;
        this.rightleg.rotateAngleY = 0.0F;
        this.leftleg.rotateAngleY = 0.0F;
	  }
}
