package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.memes.EntityClippy;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;

public class ModelClippy<T extends EntityClippy> extends EntityModel<T> {
	private final RendererModel root;
	private final RendererModel LeftBrow;
	private final RendererModel LeftEye;
	private final RendererModel Clip;
	private final RendererModel RightEye;
	private final RendererModel RightBrow;

	public ModelClippy() {
		textureWidth = 64;
		textureHeight = 64;

		root = new RendererModel(this);
		root.setRotationPoint(0.0F, 0.0F, 0.0F);

		LeftBrow = new RendererModel(this);
		LeftBrow.setRotationPoint(1.0F, 10.0F, -1.0F);
		root.addChild(LeftBrow);
		LeftBrow.cubeList.add(new ModelBox(LeftBrow, 32, 26, -9.0F, -20.0F, -2.0F, 6, 2, 2, 0.0F, true));
		LeftBrow.cubeList.add(new ModelBox(LeftBrow, 40, 22, -11.0F, -18.0F, -2.0F, 2, 2, 2, 0.0F, true));

		LeftEye = new RendererModel(this);
		LeftEye.setRotationPoint(1.0F, 10.0F, -1.0F);
		root.addChild(LeftEye);
		LeftEye.cubeList.add(new ModelBox(LeftEye, 32, 32, -9.0F, -15.0F, -2.0F, 6, 6, 2, 0.0F, true));

		Clip = new RendererModel(this);
		Clip.setRotationPoint(1.0F, 10.0F, -1.0F);
		root.addChild(Clip);
		Clip.cubeList.add(new ModelBox(Clip, 0, 0, -5.0F, 12.0F, 0.0F, 8, 2, 2, 0.0F, true));
		Clip.cubeList.add(new ModelBox(Clip, 28, 0, -9.0F, 4.0F, 0.0F, 2, 6, 2, 0.0F, true));
		Clip.cubeList.add(new ModelBox(Clip, 36, 0, -11.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F, true));
		Clip.cubeList.add(new ModelBox(Clip, 0, 18, -7.0F, -20.0F, 0.0F, 2, 20, 2, 0.0F, true));
		Clip.cubeList.add(new ModelBox(Clip, 52, 0, 5.0F, 0.0F, 0.0F, 2, 10, 2, 0.0F, true));
		Clip.cubeList.add(new ModelBox(Clip, 16, 8, -3.0F, -24.0F, 0.0F, 6, 2, 2, 0.0F, true));
		Clip.cubeList.add(new ModelBox(Clip, 34, 12, 3.0F, -4.0F, 0.0F, 2, 2, 2, 0.0F, true));
		Clip.cubeList.add(new ModelBox(Clip, 20, 0, -7.0F, 10.0F, 0.0F, 2, 2, 2, 0.0F, true));
		Clip.cubeList.add(new ModelBox(Clip, 8, 4, 5.0F, -20.0F, 0.0F, 2, 8, 2, 0.0F, true));
		Clip.cubeList.add(new ModelBox(Clip, 44, 4, -5.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F, true));
		Clip.cubeList.add(new ModelBox(Clip, 32, 8, -5.0F, -22.0F, 0.0F, 2, 2, 2, 0.0F, true));
		Clip.cubeList.add(new ModelBox(Clip, 44, 0, 3.0F, 10.0F, 0.0F, 2, 2, 2, 0.0F, true));
		Clip.cubeList.add(new ModelBox(Clip, 15, 12, -3.0F, 6.0F, 0.0F, 4, 2, 2, 0.0F, true));
		Clip.cubeList.add(new ModelBox(Clip, 26, 12, 1.0F, -2.0F, 0.0F, 2, 8, 2, 0.0F, true));
		Clip.cubeList.add(new ModelBox(Clip, 0, 4, 7.0F, -12.0F, 0.0F, 2, 12, 2, 0.0F, true));
		Clip.cubeList.add(new ModelBox(Clip, 16, 4, 3.0F, -22.0F, 0.0F, 2, 2, 2, 0.0F, true));

		RightEye = new RendererModel(this);
		RightEye.setRotationPoint(1.0F, 10.0F, -1.0F);
		root.addChild(RightEye);
		RightEye.cubeList.add(new ModelBox(RightEye, 16, 32, 4.0F, -15.0F, -2.0F, 6, 6, 2, 0.0F, true));

		RightBrow = new RendererModel(this);
		RightBrow.setRotationPoint(1.0F, 10.0F, -1.0F);
		root.addChild(RightBrow);
		RightBrow.cubeList.add(new ModelBox(RightBrow, 16, 26, 4.0F, -20.0F, -2.0F, 6, 2, 2, 0.0F, true));
		RightBrow.cubeList.add(new ModelBox(RightBrow, 16, 22, 10.0F, -18.0F, -2.0F, 2, 2, 2, 0.0F, true));
	}

	@Override
	public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) {
		//GlStateManager.translatef(0.0F, 0.001F, 0.0F);
		root.render(f5);
	}
	public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
		RendererModel.rotateAngleX = x;
		RendererModel.rotateAngleY = y;
		RendererModel.rotateAngleZ = z;
	}
}