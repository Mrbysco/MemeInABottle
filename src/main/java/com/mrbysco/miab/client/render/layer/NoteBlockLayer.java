package com.mrbysco.miab.client.render.layer;

import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mrbysco.miab.client.models.ModelBongoCat;
import com.mrbysco.miab.entity.memes.EntityBongoCat;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;

public class NoteBlockLayer<T extends EntityBongoCat, M extends ModelBongoCat<T>> extends LayerRenderer<T, M> {
	public NoteBlockLayer(IEntityRenderer<T, M> entityRenderer)
	{
		super(entityRenderer);
	}

	@Override
	public void render(EntityBongoCat entityIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		ItemStack noteStack = new ItemStack(Blocks.NOTE_BLOCK);

		if (!noteStack.isEmpty())
		{
			GlStateManager.enableRescaleNormal();
			GlStateManager.pushMatrix();
			GlStateManager.translatef(0.0F, 0.775F, -0.55F);
			GlStateManager.scalef(0.75F, 0.75F, 0.75F);
			GlStateManager.rotatef(-10.0F, 1.0F, 0.0F, 0.0F);

			int i = entityIn.getBrightnessForRender();
			int j = i % 65536;
			int k = i / 65536;
			GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, (float)j, (float)k);
			GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);

			GlStateManager.scalef(0.45F, 0.45F, 0.45F);
			GlStateManager.translatef(0.7F, 0.75F, 1F);
			Minecraft.getInstance().getItemRenderer().renderItem(noteStack, ItemCameraTransforms.TransformType.NONE);

			GlStateManager.translatef(-1.4F, 0F, 0F);
			Minecraft.getInstance().getItemRenderer().renderItem(noteStack, ItemCameraTransforms.TransformType.NONE);
			GlStateManager.popMatrix();
			GlStateManager.disableRescaleNormal();
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
}