package com.Mrbysco.MIAB.renderer.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFA extends ModelBase {
        public ModelRenderer right_arm;
        public ModelRenderer right_leg;
        public ModelRenderer head_2;
        public ModelRenderer torso;
        public ModelRenderer left_arm;
        public ModelRenderer left_leg;
        public ModelRenderer head;

        public ModelFA() {
            this.textureWidth = 64;
            this.textureHeight = 64;
            this.head_2 = new ModelRenderer(this, 0, 32);
            this.head_2.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.head_2.addBox(-4.0F, -10.0F, -4.0F, 9, 3, 7, 0.0F);
            this.left_leg = new ModelRenderer(this, 0, 16);
            this.left_leg.mirror = true;
            this.left_leg.setRotationPoint(1.9F, 12.0F, 0.1F);
            this.left_leg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
            this.left_arm = new ModelRenderer(this, 40, 16);
            this.left_arm.mirror = true;
            this.left_arm.setRotationPoint(5.0F, 2.0F, -0.0F);
            this.left_arm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
            this.setRotateAngle(left_arm, -1.5707963267948966F, 0.10000736613927509F, -0.10000736613927509F);
            this.right_leg = new ModelRenderer(this, 0, 16);
            this.right_leg.setRotationPoint(-1.9F, 12.0F, 0.1F);
            this.right_leg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
            this.right_arm = new ModelRenderer(this, 40, 16);
            this.right_arm.setRotationPoint(-5.0F, 2.0F, 0.0F);
            this.right_arm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
            this.setRotateAngle(right_arm, -1.5707963267948966F, -0.10000736613927509F, 0.10000736613927509F);
            this.torso = new ModelRenderer(this, 16, 16);
            this.torso.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.torso.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
            this.head = new ModelRenderer(this, 1, 43);
            this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.head.addBox(-5.0F, -7.0F, -4.0F, 10, 7, 8, 0.0F);
        }

        @Override
        public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
            this.head_2.render(f5);
            this.left_leg.render(f5);
            this.left_arm.render(f5);
            this.right_leg.render(f5);
            this.right_arm.render(f5);
            this.torso.render(f5);
            this.head.render(f5);
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