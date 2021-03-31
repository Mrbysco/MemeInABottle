package com.mrbysco.miab.client.models;

import com.google.common.collect.ImmutableList;
import com.mrbysco.miab.entity.memes.ClippyEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ClippyModel<T extends ClippyEntity> extends SegmentedModel<T> {
	private final ModelRenderer root;
	private final ModelRenderer LeftBrow;
	private final ModelRenderer LeftEye;
	private final ModelRenderer Clip;
	private final ModelRenderer RightEye;
	private final ModelRenderer RightBrow;

	public ClippyModel() {
		textureWidth = 64;
		textureHeight = 64;

		root = new ModelRenderer(this);
		root.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		LeftBrow = new ModelRenderer(this);
		LeftBrow.setRotationPoint(1.0F, 10.0F, -1.0F);
		root.addChild(LeftBrow);
		LeftBrow.setTextureOffset(32, 26).addBox(-9.0F, -20.0F, -2.0F, 6.0F, 2.0F, 2.0F, 0.0F, true);
		LeftBrow.setTextureOffset(40, 22).addBox(-11.0F, -18.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);

		LeftEye = new ModelRenderer(this);
		LeftEye.setRotationPoint(1.0F, 10.0F, -1.0F);
		root.addChild(LeftEye);
		LeftEye.setTextureOffset(32, 32).addBox(-9.0F, -15.0F, -2.0F, 6.0F, 6.0F, 2.0F, 0.0F, true);

		Clip = new ModelRenderer(this);
		Clip.setRotationPoint(1.0F, 10.0F, -1.0F);
		root.addChild(Clip);
		Clip.setTextureOffset(0, 0).addBox(-5.0F, 12.0F, 0.0F, 8.0F, 2.0F, 2.0F, 0.0F, true);
		Clip.setTextureOffset(28, 0).addBox(-9.0F, 4.0F, 0.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);
		Clip.setTextureOffset(36, 0).addBox(-11.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F, 0.0F, true);
		Clip.setTextureOffset(0, 18).addBox(-7.0F, -20.0F, 0.0F, 2.0F, 20.0F, 2.0F, 0.0F, true);
		Clip.setTextureOffset(52, 0).addBox(5.0F, 0.0F, 0.0F, 2.0F, 10.0F, 2.0F, 0.0F, true);
		Clip.setTextureOffset(16, 8).addBox(-3.0F, -24.0F, 0.0F, 6.0F, 2.0F, 2.0F, 0.0F, true);
		Clip.setTextureOffset(34, 12).addBox(3.0F, -4.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		Clip.setTextureOffset(20, 0).addBox(-7.0F, 10.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		Clip.setTextureOffset(8, 4).addBox(5.0F, -20.0F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
		Clip.setTextureOffset(44, 4).addBox(-5.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);
		Clip.setTextureOffset(32, 8).addBox(-5.0F, -22.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		Clip.setTextureOffset(44, 0).addBox(3.0F, 10.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		Clip.setTextureOffset(15, 12).addBox(-3.0F, 6.0F, 0.0F, 4.0F, 2.0F, 2.0F, 0.0F, true);
		Clip.setTextureOffset(26, 12).addBox(1.0F, -2.0F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
		Clip.setTextureOffset(0, 4).addBox(7.0F, -12.0F, 0.0F, 2.0F, 12.0F, 2.0F, 0.0F, true);
		Clip.setTextureOffset(16, 4).addBox(3.0F, -22.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);

		RightEye = new ModelRenderer(this);
		RightEye.setRotationPoint(1.0F, 10.0F, -1.0F);
		root.addChild(RightEye);
		RightEye.setTextureOffset(16, 32).addBox(4.0F, -15.0F, -2.0F, 6.0F, 6.0F, 2.0F, 0.0F, true);

		RightBrow = new ModelRenderer(this);
		RightBrow.setRotationPoint(1.0F, 10.0F, -1.0F);
		root.addChild(RightBrow);
		RightBrow.setTextureOffset(16, 26).addBox(4.0F, -20.0F, -2.0F, 6.0F, 2.0F, 2.0F, 0.0F, true);
		RightBrow.setTextureOffset(16, 22).addBox(10.0F, -18.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.root);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}