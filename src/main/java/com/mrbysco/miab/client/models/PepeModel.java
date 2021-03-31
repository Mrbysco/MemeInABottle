package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.AbstractMeme;
import net.minecraft.client.renderer.model.ModelRenderer;

public class PepeModel<T extends AbstractMeme> extends HumanBaseModel<T> {
	public PepeModel() {
		textureWidth = 64;
		textureHeight = 64;

		bipedLeftLeg = new ModelRenderer(this);
		bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.1F);
		bipedLeftLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.setTextureOffset(1, 2).addBox(0.5F, -7.0F, -4.0F, 3.0F, 3.0F, 7.0F, 0.0F, true);
		bipedHead.setTextureOffset(6, 2).addBox(-3.5F, -7.0F, -4.0F, 3.0F, 3.0F, 7.0F, 0.0F, true);
		bipedHead.setTextureOffset(5, 1).addBox(-0.5F, -6.0F, -4.0F, 1.0F, 2.0F, 6.0F, 0.0F, true);
		bipedHead.setTextureOffset(1, 5).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 4.0F, 7.0F, 0.0F, true);
		bipedHead.setTextureOffset(8, 13).addBox(-3.0F, -2.0F, -4.5F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, true);

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		bipedRightArm.setTextureOffset(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		bipedLeftArm.setTextureOffset(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);

		bipedRightLeg = new ModelRenderer(this);
		bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.1F);
		bipedRightLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}
}