package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.AbstractMeme;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;

public class ModelDankey<T extends AbstractMeme> extends ModelHumanBase<T> {
	public ModelDankey() {
		textureWidth = 64;
		textureHeight = 64;

		bipedHeadwear = new RendererModel(this);
		bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);

		bipedHead = new RendererModel(this);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.cubeList.add(new ModelBox(bipedHead, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, true));
		bipedHead.cubeList.add(new ModelBox(bipedHead, 32, 10, -4.0F, -3.0F, -4.0F, 8, 3, 2, 0.5F, true));

		bipedBody = new RendererModel(this);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.cubeList.add(new ModelBox(bipedBody, 2, 16, -4.0F, 0.0F, -3.0F, 8, 6, 6, 0.0F, true));
		bipedBody.cubeList.add(new ModelBox(bipedBody, 4, 28, -4.0F, 6.0F, -2.0F, 8, 6, 4, 0.0F, true));

		bipedRightArm = new RendererModel(this);
		bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 32, 16, -3.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F, false));
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 33, 24, -2.0F, 2.0F, -1.5F, 3, 6, 3, 0.0F, false));
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 32, 33, -3.0F, 8.0F, -2.0F, 4, 4, 4, 0.0F, false));

		bipedLeftArm = new RendererModel(this);
		bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 32, 16, -1.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F, true));
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 33, 24, -1.0F, 2.0F, -1.5F, 3, 6, 3, 0.0F, true));
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 32, 33, -1.0F, 8.0F, -2.0F, 4, 4, 4, 0.0F, true));

		bipedRightLeg = new RendererModel(this);
		bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.1F);
		bipedRightLeg.cubeList.add(new ModelBox(bipedRightLeg, 0, 38, -2.0F, 0.0F, -2.0F, 4, 9, 4, 0.0F, false));
		bipedRightLeg.cubeList.add(new ModelBox(bipedRightLeg, 0, 51, -2.0F, 9.0F, -2.5F, 4, 3, 5, 0.0F, false));

		bipedLeftLeg = new RendererModel(this);
		bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.1F);
		bipedLeftLeg.cubeList.add(new ModelBox(bipedLeftLeg, 0, 38, -2.0F, 0.0F, -2.0F, 4, 9, 4, 0.0F, true));
		bipedLeftLeg.cubeList.add(new ModelBox(bipedLeftLeg, 0, 51, -2.0F, 9.0F, -2.5F, 4, 3, 5, 0.0F, true));
	}

	public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
		RendererModel.rotateAngleX = x;
		RendererModel.rotateAngleY = y;
		RendererModel.rotateAngleZ = z;
	}
}