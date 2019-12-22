package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.memes.EntityFA;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;

public class ModelFA<T extends EntityFA> extends ModelHumanBase<T> {

	public ModelFA() {
		textureWidth = 64;
		textureHeight = 64;

		bipedLeftLeg = new RendererModel(this);
		bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.1F);
		bipedLeftLeg.cubeList.add(new ModelBox(bipedLeftLeg, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));

		bipedHeadwear = new RendererModel(this);
		bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);

		bipedHead = new RendererModel(this);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.cubeList.add(new ModelBox(bipedHead, 1, 43, -5.0F, -7.0F, -4.0F, 10, 7, 8, 0.0F, true));
		bipedHead.cubeList.add(new ModelBox(bipedHead, 0, 32, -5.0F, -10.0F, -4.0F, 9, 3, 7, 0.0F, true));

		bipedBody = new RendererModel(this);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.cubeList.add(new ModelBox(bipedBody, 16, 16, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, true));

		bipedRightArm = new RendererModel(this);
		bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 40, 16, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));

		bipedLeftArm = new RendererModel(this);
		bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 40, 16, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, true));

		bipedRightLeg = new RendererModel(this);
		bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.1F);
		bipedRightLeg.cubeList.add(new ModelBox(bipedRightLeg, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
	}
}