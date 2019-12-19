package com.mrbysco.miab.client.models;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;

public class ModelDankey extends ModelHumanBase {
	public ModelDankey() {
		textureWidth = 64;
		textureHeight = 64;

		bipedHeadwear = new ModelRenderer(this);
		bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.cubeList.add(new ModelBox(bipedHead, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, true));
		bipedHead.cubeList.add(new ModelBox(bipedHead, 32, 10, -4.0F, -3.0F, -4.0F, 8, 3, 2, 0.5F, true));

		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.cubeList.add(new ModelBox(bipedBody, 2, 16, -4.0F, 0.0F, -3.0F, 8, 6, 6, 0.0F, true));
		bipedBody.cubeList.add(new ModelBox(bipedBody, 4, 28, -4.0F, 6.0F, -2.0F, 8, 6, 4, 0.0F, true));

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 32, 16, -3.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F, false));
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 33, 24, -2.0F, 2.0F, -1.5F, 3, 6, 3, 0.0F, false));
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 32, 33, -3.0F, 8.0F, -2.0F, 4, 4, 4, 0.0F, false));

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 32, 16, -1.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F, true));
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 33, 24, -1.0F, 2.0F, -1.5F, 3, 6, 3, 0.0F, true));
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 32, 33, -1.0F, 8.0F, -2.0F, 4, 4, 4, 0.0F, true));

		bipedRightLeg = new ModelRenderer(this);
		bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.1F);
		bipedRightLeg.cubeList.add(new ModelBox(bipedRightLeg, 0, 38, -2.0F, 0.0F, -2.0F, 4, 9, 4, 0.0F, false));
		bipedRightLeg.cubeList.add(new ModelBox(bipedRightLeg, 0, 51, -2.0F, 9.0F, -2.5F, 4, 3, 5, 0.0F, false));

		bipedLeftLeg = new ModelRenderer(this);
		bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.1F);
		bipedLeftLeg.cubeList.add(new ModelBox(bipedLeftLeg, 0, 38, -2.0F, 0.0F, -2.0F, 4, 9, 4, 0.0F, true));
		bipedLeftLeg.cubeList.add(new ModelBox(bipedLeftLeg, 0, 51, -2.0F, 9.0F, -2.5F, 4, 3, 5, 0.0F, true));
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}