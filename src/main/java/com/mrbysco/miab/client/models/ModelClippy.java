package com.mrbysco.miab.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelClippy extends ModelBase {
	private final ModelRenderer root;
	private final ModelRenderer LeftBrow;
	private final ModelRenderer LeftBrowChild;
	private final ModelRenderer LeftEye;
	private final ModelRenderer Clip;
	private final ModelRenderer ClipChild;
	private final ModelRenderer RightEye;
	private final ModelRenderer RightBrow;
	private final ModelRenderer RightBrowChild;

	public ModelClippy() {
		textureWidth = 64;
		textureHeight = 64;

		root = new ModelRenderer(this);
		root.setRotationPoint(0.0F, 0.0F, 0.0F);

		LeftBrow = new ModelRenderer(this);
		LeftBrow.setRotationPoint(1.0F, 10.0F, -1.0F);
		root.addChild(LeftBrow);
		LeftBrow.cubeList.add(new ModelBox(LeftBrow, 32, 26, -9.0F, -20.0F, -2.0F, 6, 2, 2, 0.0F, true));

		LeftBrowChild = new ModelRenderer(this);
		LeftBrowChild.setRotationPoint(1.0F, 10.0F, -1.0F);
		LeftBrow.addChild(LeftBrowChild);
		LeftBrowChild.cubeList.add(new ModelBox(LeftBrowChild, 40, 22, -12.0F, -28.0F, -1.0F, 2, 2, 2, 0.0F, true));

		LeftEye = new ModelRenderer(this);
		LeftEye.setRotationPoint(1.0F, 10.0F, -1.0F);
		root.addChild(LeftEye);
		LeftEye.cubeList.add(new ModelBox(LeftEye, 32, 32, -9.0F, -15.0F, -2.0F, 6, 6, 2, 0.0F, true));

		Clip = new ModelRenderer(this);
		Clip.setRotationPoint(1.0F, 10.0F, -1.0F);
		root.addChild(Clip);
		Clip.cubeList.add(new ModelBox(Clip, 0, 0, -5.0F, 12.0F, 0.0F, 8, 2, 2, 0.0F, true));

		ClipChild = new ModelRenderer(this);
		ClipChild.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(ClipChild, 0.0F, -0.0183F, 0.0F);
		Clip.addChild(ClipChild);
		ClipChild.cubeList.add(new ModelBox(ClipChild, 44, 4, -5.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F, true));

		RightEye = new ModelRenderer(this);
		RightEye.setRotationPoint(1.0F, 10.0F, -1.0F);
		root.addChild(RightEye);
		RightEye.cubeList.add(new ModelBox(RightEye, 16, 32, 4.0F, -15.0F, -2.0F, 6, 6, 2, 0.0F, true));

		RightBrow = new ModelRenderer(this);
		RightBrow.setRotationPoint(1.0F, 10.0F, -1.0F);
		root.addChild(RightBrow);
		RightBrow.cubeList.add(new ModelBox(RightBrow, 16, 26, 4.0F, -20.0F, -2.0F, 6, 2, 2, 0.0F, true));

		RightBrowChild = new ModelRenderer(this);
		RightBrowChild.setRotationPoint(1.0F, 10.0F, -1.0F);
		RightBrow.addChild(RightBrowChild);
		RightBrowChild.cubeList.add(new ModelBox(RightBrowChild, 16, 22, 9.0F, -28.0F, -1.0F, 2, 2, 2, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		GlStateManager.translate(0.0F, 0.001F, 0.0F);
		root.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}