package com.mrbysco.miab.client.models.knuckles;

import com.mrbysco.miab.entity.memes.EntityKnuckles;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;

public class ModelKnucklesAku<T extends EntityKnuckles> extends EntityModel<T> {
    public RendererModel chest;
    public RendererModel left_arm;
    public RendererModel right_arm;
    public RendererModel left_leg;
    public RendererModel right_leg;
    public RendererModel head;
    public RendererModel chest_front;
    public RendererModel chest_back;
    public RendererModel chest_right;
    public RendererModel chest_left;
    public RendererModel chest_part;
    public RendererModel chest_part2;
    public RendererModel chest_part3;
    public RendererModel chest_part4;
    public RendererModel left_arm_2;
    public RendererModel right_hand;
    public RendererModel left_arm_bit1;
    public RendererModel left_arm_bit2;
    public RendererModel right_arm_2;
    public RendererModel right_hand_1;
    public RendererModel right_arm_bit1;
    public RendererModel right_arm_bit2;
    public RendererModel left_foot;
    public RendererModel right_foot;
    public RendererModel head_top;
    public RendererModel mouth;
    public RendererModel mouth_top;
    public RendererModel nose;
    public RendererModel goatee;
    public RendererModel brow_1;
    public RendererModel brow_2;
    public RendererModel horn_left_1;
    public RendererModel horn_right_1;
    public RendererModel horn_left_2;
    public RendererModel horn_right_2;

    public ModelKnucklesAku() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.head = new RendererModel(this, 0, 5);
        this.head.setRotationPoint(0.5F, 6.0F, 0.0F);
        this.head.addBox(-4.0F, -2.0F, -2.0F, 7, 4, 4, 0.0F);
        this.left_arm_bit1 = new RendererModel(this, 0, 54);
        this.left_arm_bit1.setRotationPoint(1.7F, -1.5F, 0.0F);
        this.left_arm_bit1.addBox(2.0F, -0.5F, 0.0F, 2, 1, 2, 0.0F);
        this.chest_right = new RendererModel(this, 48, 36);
        this.chest_right.setRotationPoint(-6.0F, -4.5F, 2.0F);
        this.chest_right.addBox(0.0F, 0.0F, -1.5F, 1, 8, 3, 0.0F);
        this.chest_left = new RendererModel(this, 56, 36);
        this.chest_left.setRotationPoint(5.0F, -4.5F, 2.0F);
        this.chest_left.addBox(0.0F, 0.0F, -1.5F, 1, 8, 3, 0.0F);
        this.left_leg = new RendererModel(this, 40, 0);
        this.left_leg.setRotationPoint(2.0F, 17.0F, 0.0F);
        this.left_leg.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.chest_part4 = new RendererModel(this, 5, 39);
        this.chest_part4.setRotationPoint(-4.5F, 0.0F, -0.5F);
        this.chest_part4.addBox(8.5F, -3.0F, -0.5F, 1, 6, 1, 0.0F);
        this.chest_back = new RendererModel(this, 28, 44);
        this.chest_back.setRotationPoint(-4.0F, -3.0F, 3.2F);
        this.chest_back.addBox(0.0F, 0.0F, 0.0F, 8, 6, 2, 0.0F);
        this.left_arm_2 = new RendererModel(this, 14, 60);
        this.left_arm_2.setRotationPoint(5.3F, -0.2F, 0.0F);
        this.left_arm_2.addBox(0.0F, -1.0F, 0.0F, 4, 2, 2, 0.0F);
        this.setRotateAngle(left_arm_2, 0.0F, 0.0F, 0.6108652381980153F);
        this.chest_part2 = new RendererModel(this, 5, 39);
        this.chest_part2.setRotationPoint(0.0F, 3.5F, -0.5F);
        this.chest_part2.addBox(-4.0F, -0.5F, -0.5F, 8, 1, 1, 0.0F);
        this.chest_part3 = new RendererModel(this, 5, 39);
        this.chest_part3.setRotationPoint(-4.5F, 0.0F, -0.5F);
        this.chest_part3.addBox(-0.5F, -3.0F, -0.5F, 1, 6, 1, 0.0F);
        this.goatee = new RendererModel(this, 0, 13);
        this.goatee.setRotationPoint(-0.5F, 1.9F, -2.6F);
        this.goatee.addBox(-1.0F, -1.0F, -0.5F, 2, 3, 1, 0.0F);
        this.nose = new RendererModel(this, 15, 0);
        this.nose.setRotationPoint(-0.5F, -0.3F, -3.0F);
        this.nose.addBox(-1.0F, -0.6F, -0.5F, 2, 1, 1, 0.0F);
        this.chest = new RendererModel(this, 0, 36);
        this.chest.setRotationPoint(0.0F, 13.0F, -2.0F);
        this.chest.addBox(-5.0F, -5.0F, 0.0F, 10, 10, 4, 0.0F);
        this.left_foot = new RendererModel(this, 36, 6);
        this.left_foot.setRotationPoint(-0.5F, 0.0F, 0.0F);
        this.left_foot.addBox(-0.5F, 4.0F, -2.8F, 2, 2, 4, 0.0F);
        this.horn_left_1 = new RendererModel(this, 22, 10);
        this.horn_left_1.setRotationPoint(2.7F, -1.0F, 0.0F);
        this.horn_left_1.addBox(0.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(horn_left_1, 0.0F, 0.0F, -0.5235987755982988F);
        this.right_hand_1 = new RendererModel(this, 39, 54);
        this.right_hand_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.right_hand_1.addBox(-10.0F, 1.2F, -0.5F, 3, 3, 3, 0.0F);
        this.head_top = new RendererModel(this, 0, 0);
        this.head_top.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.head_top.addBox(-3.0F, -1.0F, -2.0F, 5, 1, 3, 0.0F);
        this.horn_left_2 = new RendererModel(this, 22, 5);
        this.horn_left_2.setRotationPoint(4.2F, -2.7F, 0.0F);
        this.horn_left_2.addBox(-0.5F, -2.0F, -1.0F, 1, 3, 2, 0.0F);
        this.right_arm = new RendererModel(this, 50, 60);
        this.right_arm.setRotationPoint(-3.0F, 10.0F, -1.0F);
        this.right_arm.addBox(-6.0F, -1.0F, 0.0F, 3, 2, 2, 0.0F);
        this.right_arm_bit1 = new RendererModel(this, 0, 57);
        this.right_arm_bit1.setRotationPoint(-1.7F, -1.5F, 0.0F);
        this.right_arm_bit1.addBox(-4.0F, -0.5F, 0.0F, 2, 1, 2, 0.0F);
        this.mouth = new RendererModel(this, 22, 2);
        this.mouth.setRotationPoint(-0.5F, -0.5F, -2.5F);
        this.mouth.addBox(-3.0F, 0.0F, -0.5F, 6, 2, 1, 0.0F);
        this.right_hand = new RendererModel(this, 14, 54);
        this.right_hand.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.right_hand.addBox(6.5F, 1.2F, -0.5F, 3, 3, 3, 0.0F);
        this.brow_1 = new RendererModel(this, 6, 13);
        this.brow_1.setRotationPoint(-2.5F, -3.1F, -1.6F);
        this.brow_1.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.right_leg = new RendererModel(this, 56, 0);
        this.right_leg.setRotationPoint(-2.0F, 17.0F, 0.0F);
        this.right_leg.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.left_arm_bit2 = new RendererModel(this, 0, 54);
        this.left_arm_bit2.setRotationPoint(-1.3F, -2.5F, 0.0F);
        this.left_arm_bit2.addBox(4.0F, -0.5F, 0.0F, 2, 1, 2, 0.0F);
        this.mouth_top = new RendererModel(this, 22, 0);
        this.mouth_top.setRotationPoint(-0.5F, -1.0F, -2.5F);
        this.mouth_top.addBox(-2.0F, 0.0F, -0.4F, 4, 1, 1, 0.0F);
        this.horn_right_2 = new RendererModel(this, 22, 5);
        this.horn_right_2.mirror = true;
        this.horn_right_2.setRotationPoint(-5.2F, -2.7F, 0.0F);
        this.horn_right_2.addBox(-0.5F, -2.0F, -1.0F, 1, 3, 2, 0.0F);
        this.chest_part = new RendererModel(this, 5, 39);
        this.chest_part.setRotationPoint(0.0F, -3.5F, -0.5F);
        this.chest_part.addBox(-4.0F, -0.5F, -0.5F, 8, 1, 1, 0.0F);
        this.horn_right_1 = new RendererModel(this, 22, 10);
        this.horn_right_1.mirror = true;
        this.horn_right_1.setRotationPoint(-3.8F, -1.0F, 0.0F);
        this.horn_right_1.addBox(-2.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(horn_right_1, 0.0F, 0.0F, 0.5235987755982988F);
        this.left_arm = new RendererModel(this, 0, 60);
        this.left_arm.setRotationPoint(3.0F, 10.0F, -1.0F);
        this.left_arm.addBox(3.0F, -1.0F, 0.0F, 3, 2, 2, 0.0F);
        this.chest_front = new RendererModel(this, 28, 36);
        this.chest_front.setRotationPoint(-4.0F, -3.0F, -2.0F);
        this.chest_front.addBox(0.0F, 0.0F, 0.0F, 8, 6, 2, 0.0F);
        this.right_arm_bit2 = new RendererModel(this, 0, 57);
        this.right_arm_bit2.setRotationPoint(-0.7F, -2.5F, 0.0F);
        this.right_arm_bit2.addBox(-4.0F, -0.5F, 0.0F, 2, 1, 2, 0.0F);
        this.brow_2 = new RendererModel(this, 10, 13);
        this.brow_2.setRotationPoint(-2.5F, -3.1F, -1.6F);
        this.brow_2.addBox(3.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(brow_2, 0.0F, 0.008726646259971648F, 0.0F);
        this.right_foot = new RendererModel(this, 50, 6);
        this.right_foot.setRotationPoint(-0.5F, 0.0F, 0.0F);
        this.right_foot.addBox(-0.5F, 4.0F, -2.8F, 2, 2, 4, 0.0F);
        this.right_arm_2 = new RendererModel(this, 38, 60);
        this.right_arm_2.setRotationPoint(-5.4F, -0.2F, 0.0F);
        this.right_arm_2.addBox(-4.0F, -1.0F, 0.0F, 4, 2, 2, 0.0F);
        this.setRotateAngle(right_arm_2, 0.0F, 0.0F, -0.6108652381980153F);
        this.left_arm.addChild(this.left_arm_bit1);
        this.chest.addChild(this.chest_right);
        this.chest.addChild(this.chest_left);
        this.chest.addChild(this.chest_part4);
        this.chest.addChild(this.chest_back);
        this.left_arm.addChild(this.left_arm_2);
        this.chest.addChild(this.chest_part2);
        this.chest.addChild(this.chest_part3);
        this.head.addChild(this.goatee);
        this.head.addChild(this.nose);
        this.left_leg.addChild(this.left_foot);
        this.head.addChild(this.horn_left_1);
        this.right_arm.addChild(this.right_hand_1);
        this.head.addChild(this.head_top);
        this.head.addChild(this.horn_left_2);
        this.right_arm.addChild(this.right_arm_bit1);
        this.head.addChild(this.mouth);
        this.left_arm.addChild(this.right_hand);
        this.head.addChild(this.brow_1);
        this.left_arm.addChild(this.left_arm_bit2);
        this.head.addChild(this.mouth_top);
        this.head.addChild(this.horn_right_2);
        this.chest.addChild(this.chest_part);
        this.head.addChild(this.horn_right_1);
        this.chest.addChild(this.chest_front);
        this.right_arm.addChild(this.right_arm_bit2);
        this.head.addChild(this.brow_2);
        this.right_leg.addChild(this.right_foot);
        this.right_arm.addChild(this.right_arm_2);
    }

    @Override
    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.head.render(f5);
        this.left_leg.render(f5);
        this.chest.render(f5);
        this.right_arm.render(f5);
        this.right_leg.render(f5);
        this.left_arm.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }

    public void setRotationAngles(T entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
	    super.setRotationAngles(entity, f, f1, f2, f3, f4, f5);  
	    this.right_leg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1 * 0.5F;
        this.left_leg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1 * 0.5F;
        this.right_leg.rotateAngleY = 0.0F;
        this.left_leg.rotateAngleY = 0.0F;
    }
}
