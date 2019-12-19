package com.mrbysco.miab.client.models.knuckles;

import com.mrbysco.miab.client.models.ModelHumanBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;

public class ModelKnucklesQueen extends ModelHumanBase {
    public ModelKnucklesQueen() {
    	this.textureWidth = 64;
        this.textureHeight = 64;

        bipedRightLeg = new ModelRenderer(this);
        bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.1F);
        bipedRightLeg.cubeList.add(new ModelBox(bipedRightLeg, 0, 48, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));

        bipedRightArm = new ModelRenderer(this);
        bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 40, 48, -2.0F, -2.0F, -2.0F, 3, 12, 4, 0.0F, false));

        bipedBody = new ModelRenderer(this);
        bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedBody.cubeList.add(new ModelBox(bipedBody, 16, 48, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, true));

        bipedLeftLeg = new ModelRenderer(this);
        bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.1F);
        bipedLeftLeg.cubeList.add(new ModelBox(bipedLeftLeg, 0, 48, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));

        bipedLeftArm = new ModelRenderer(this);
        bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
        bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 40, 48, -1.0F, -2.0F, -2.0F, 3, 12, 4, 0.0F, true));

        bipedHead = new ModelRenderer(this);
        bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedHead.cubeList.add(new ModelBox(bipedHead, 0, 7, -4.5F, -5.0F, -3.0F, 9, 5, 6, 0.0F, true));
        bipedHead.cubeList.add(new ModelBox(bipedHead, 2, 20, -4.0F, -3.5F, -4.0F, 8, 3, 1, 0.0F, true));
        bipedHead.cubeList.add(new ModelBox(bipedHead, 42, 2, -0.5F, -3.05F, -5.5F, 1, 1, 4, 0.0F, true));
        bipedHead.cubeList.add(new ModelBox(bipedHead, 24, 0, -3.0F, -4.0F, -3.9F, 6, 1, 2, 0.0F, true));
        bipedHead.cubeList.add(new ModelBox(bipedHead, 0, 0, -3.5F, -6.0F, -3.0F, 7, 1, 5, 0.0F, true));

        bipedHeadwear = new ModelRenderer(this);
        bipedHeadwear.setRotationPoint(0.0F, 24.0F, 0.0F);
    }
}
