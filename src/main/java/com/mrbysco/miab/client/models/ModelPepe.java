package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.AbstractMeme;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;

public class ModelPepe<T extends AbstractMeme> extends ModelHumanBase<T> {
	public ModelPepe() {
		textureWidth = 64;
		textureHeight = 64;

		bipedHead = new RendererModel(this);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.cubeList.add(new ModelBox(bipedHead, 1, 2, 0.5F, -7.0F, -4.0F, 3, 3, 7, 0.0F, true));
		bipedHead.cubeList.add(new ModelBox(bipedHead, 6, 2, -3.5F, -7.0F, -4.0F, 3, 3, 7, 0.0F, true));
		bipedHead.cubeList.add(new ModelBox(bipedHead, 5, 1, -0.5F, -6.0F, -4.0F, 1, 2, 6, 0.0F, true));
		bipedHead.cubeList.add(new ModelBox(bipedHead, 1, 5, -4.0F, -4.0F, -4.0F, 8, 4, 7, 0.0F, true));
		bipedHead.cubeList.add(new ModelBox(bipedHead, 8, 13, -3.0F, -2.0F, -4.5F, 6, 1, 1, 0.0F, true));

		bipedBody = new RendererModel(this);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.cubeList.add(new ModelBox(bipedBody, 16, 16, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, true));

		bipedRightArm = new RendererModel(this);
		bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 40, 16, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));

		bipedLeftArm = new RendererModel(this);
		bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 40, 16, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, true));

		bipedLeftLeg = new RendererModel(this);
		bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.1F);
		bipedLeftLeg.cubeList.add(new ModelBox(bipedLeftLeg, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));

		bipedRightLeg = new RendererModel(this);
		bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.1F);
		bipedRightLeg.cubeList.add(new ModelBox(bipedRightLeg, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));

		bipedHeadwear = new RendererModel(this);
		bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
	}
}