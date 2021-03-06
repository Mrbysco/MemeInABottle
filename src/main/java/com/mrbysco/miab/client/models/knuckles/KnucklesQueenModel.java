package com.mrbysco.miab.client.models.knuckles;

import com.mrbysco.miab.client.models.HumanBaseModel;
import com.mrbysco.miab.entity.AbstractMeme;
import net.minecraft.client.renderer.model.ModelRenderer;

public class KnucklesQueenModel<T extends AbstractMeme> extends HumanBaseModel<T> {
	public KnucklesQueenModel() {
		textureWidth = 64;
		textureHeight = 64;

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.setTextureOffset(0, 7).addBox(-4.5F, -5.0F, -3.0F, 9.0F, 5.0F, 6.0F, 0.0F, true);
		bipedHead.setTextureOffset(2, 20).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 3.0F, 1.0F, 0.0F, true);
		bipedHead.setTextureOffset(42, 2).addBox(-0.5F, -3.05F, -5.5F, 1.0F, 1.0F, 4.0F, 0.0F, true);
		bipedHead.setTextureOffset(24, 0).addBox(-3.0F, -4.0F, -3.9F, 6.0F, 1.0F, 2.0F, 0.0F, true);
		bipedHead.setTextureOffset(0, 0).addBox(-3.5F, -6.0F, -3.0F, 7.0F, 1.0F, 5.0F, 0.0F, true);

		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.setTextureOffset(16, 48).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, true);

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		bipedRightArm.setTextureOffset(40, 48).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, false);

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		bipedLeftArm.setTextureOffset(40, 48).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, true);

		bipedRightLeg = new ModelRenderer(this);
		bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.1F);
		bipedRightLeg.setTextureOffset(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		bipedLeftLeg = new ModelRenderer(this);
		bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.1F);
		bipedLeftLeg.setTextureOffset(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);

		bipedHeadwear = new ModelRenderer(this);
	}
}