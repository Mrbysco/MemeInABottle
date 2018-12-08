package com.Mrbysco.miab.models;

import com.Mrbysco.miab.entities.passive.EntityRoflCopter;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelRoflCopter - Mrbyso
 * Created using Tabula 7.0.0
 */
public class ModelRoflCopter extends ModelBase {
	public ModelRenderer Back_Part;
    public ModelRenderer Landing_Right;
    public ModelRenderer Landing_Left;
    public ModelRenderer Middle_Part;
    public ModelRenderer Top_part;
    public ModelRenderer Top_Propelor;
    public ModelRenderer Back_Propelor;
    public ModelRenderer Landing_Right_Front;
    public ModelRenderer Landing_Right_Back;
    public ModelRenderer Landing_Right_Line_Front;
    public ModelRenderer Landing_Right_Line_Back;
    public ModelRenderer Landing_Left_Front;
    public ModelRenderer Landing_Left_Back;
    public ModelRenderer Landing_Left_Line_Front;
    public ModelRenderer Landing_Left_Line_Back;
    public ModelRenderer Middle_Front;
    public ModelRenderer Middle_Top_Part;
    public ModelRenderer Middle_Back;

    public ModelRoflCopter() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Landing_Right_Line_Back = new ModelRenderer(this, 12, 52);
        this.Landing_Right_Line_Back.setRotationPoint(0.9F, -6.0F, 2.0F);
        this.Landing_Right_Line_Back.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2, 0.0F);
        this.setRotateAngle(Landing_Right_Line_Back, 0.0F, 0.0F, 0.17453292519943295F);
        this.Top_part = new ModelRenderer(this, 2, 12);
        this.Top_part.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Top_part.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.Landing_Right_Front = new ModelRenderer(this, 0, 52);
        this.Landing_Right_Front.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Landing_Right_Front.addBox(0.0F, -3.0F, -14.0F, 1, 2, 2, 0.0F);
        this.Landing_Right_Line_Front = new ModelRenderer(this, 6, 52);
        this.Landing_Right_Line_Front.setRotationPoint(0.9F, -6.0F, -5.0F);
        this.Landing_Right_Line_Front.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2, 0.0F);
        this.setRotateAngle(Landing_Right_Line_Front, 0.0F, 0.0F, 0.17453292519943295F);
        this.Back_Propelor = new ModelRenderer(this, 0, 113);
        this.Back_Propelor.setRotationPoint(1.0F, 9.6F, 19.0F);
        this.Back_Propelor.addBox(0.0F, -6.0F, -1.0F, 1, 12, 2, 0.0F);
        this.Landing_Left_Line_Back = new ModelRenderer(this, 12, 80);
        this.Landing_Left_Line_Back.setRotationPoint(-0.9F, -5.9F, 2.0F);
        this.Landing_Left_Line_Back.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2, 0.0F);
        this.setRotateAngle(Landing_Left_Line_Back, 0.0F, 0.0F, -0.17453292519943295F);
        this.Top_Propelor = new ModelRenderer(this, 4, 123);
        this.Top_Propelor.setRotationPoint(0.0F, -1.1F, 0.0F);
        this.Top_Propelor.addBox(-12.0F, -1.0F, -2.0F, 24, 1, 4, 0.0F);
        this.setRotateAngle(Top_Propelor, 0.0F, -0.017453292519943295F, 0.0F);
        this.Landing_Left_Back = new ModelRenderer(this, 18, 80);
        this.Landing_Left_Back.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Landing_Left_Back.addBox(0.0F, -3.0F, 12.0F, 1, 2, 2, 0.0F);
        this.Landing_Right = new ModelRenderer(this, 0, 52);
        this.Landing_Right.setRotationPoint(-7.0F, 22.0F, 0.0F);
        this.Landing_Right.addBox(0.0F, -1.0F, -12.0F, 1, 2, 24, 0.0F);
        this.Landing_Left_Front = new ModelRenderer(this, 0, 80);
        this.Landing_Left_Front.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Landing_Left_Front.addBox(0.0F, -3.0F, -14.0F, 1, 2, 2, 0.0F);
        this.Landing_Left = new ModelRenderer(this, 0, 80);
        this.Landing_Left.setRotationPoint(6.0F, 22.0F, 0.0F);
        this.Landing_Left.addBox(0.0F, -1.0F, -12.0F, 1, 2, 24, 0.0F);
        this.Middle_Part = new ModelRenderer(this, 2, 0);
        this.Middle_Part.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.Middle_Part.addBox(-6.0F, -6.0F, -10.0F, 12, 12, 20, 0.0F);
        this.Middle_Top_Part = new ModelRenderer(this, 8, 32);
        this.Middle_Top_Part.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.Middle_Top_Part.addBox(-3.0F, -2.0F, -7.0F, 6, 4, 14, 0.0F);
        this.Middle_Back = new ModelRenderer(this, 46, 0);
        this.Middle_Back.setRotationPoint(0.0F, -2.0F, 13.5F);
        this.Middle_Back.addBox(-3.0F, -3.0F, -3.5F, 6, 8, 3, 0.0F);
        this.Back_Part = new ModelRenderer(this, 69, 3);
        this.Back_Part.setRotationPoint(0.0F, 9.0F, 16.0F);
        this.Back_Part.addBox(-1.5F, -1.0F, -3.0F, 3, 3, 9, 0.0F);
        this.Landing_Left_Line_Front = new ModelRenderer(this, 6, 80);
        this.Landing_Left_Line_Front.setRotationPoint(-0.9F, -5.9F, -5.0F);
        this.Landing_Left_Line_Front.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2, 0.0F);
        this.setRotateAngle(Landing_Left_Line_Front, 0.0F, 0.0F, -0.17453292519943295F);
        this.Landing_Right_Back = new ModelRenderer(this, 18, 52);
        this.Landing_Right_Back.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Landing_Right_Back.addBox(0.0F, -3.0F, 12.0F, 1, 2, 2, 0.0F);
        this.Middle_Front = new ModelRenderer(this, 0, 0);
        this.Middle_Front.setRotationPoint(0.0F, 1.0F, -12.5F);
        this.Middle_Front.addBox(-3.0F, -3.0F, -2.5F, 6, 6, 5, 0.0F);
        this.Landing_Right.addChild(this.Landing_Right_Line_Back);
        this.Landing_Right.addChild(this.Landing_Right_Front);
        this.Landing_Right.addChild(this.Landing_Right_Line_Front);
        this.Landing_Left.addChild(this.Landing_Left_Line_Back);
        this.Landing_Left.addChild(this.Landing_Left_Back);
        this.Landing_Left.addChild(this.Landing_Left_Front);
        this.Middle_Part.addChild(this.Middle_Top_Part);
        this.Middle_Part.addChild(this.Middle_Back);
        this.Landing_Left.addChild(this.Landing_Left_Line_Front);
        this.Landing_Right.addChild(this.Landing_Right_Back);
        this.Middle_Part.addChild(this.Middle_Front);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Top_part.render(f5);
        this.Back_Propelor.render(f5);
        this.Top_Propelor.render(f5);
        this.Landing_Right.render(f5);
        this.Landing_Left.render(f5);
        this.Middle_Part.render(f5);
        this.Back_Part.render(f5);
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

        EntityRoflCopter rofl = (EntityRoflCopter)entityIn;
        boolean flag = !rofl.getIsCopterLanded();
        
        float f3 = (flag ? ((MathHelper.cos(ageInTicks * 1F)) * 0.4F) : 0.0F);
        if(flag)
        {
            this.Back_Propelor.rotateAngleX += f3;
            this.Top_Propelor.rotateAngleY += -f3;
        }
        else
        {
    	    this.Back_Propelor.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.3F * limbSwingAmount;
            this.Top_Propelor.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.3F * limbSwingAmount;
            this.Back_Propelor.rotateAngleY = 0.0F;
            this.Top_Propelor.rotateAngleY = 0.0F;
        }
    }
}
