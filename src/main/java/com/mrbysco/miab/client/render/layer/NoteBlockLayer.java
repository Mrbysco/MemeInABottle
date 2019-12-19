package com.mrbysco.miab.client.render.layer;

import com.mrbysco.miab.client.render.RenderBongoCat;
import com.mrbysco.miab.entity.memes.EntityBongoCat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class NoteBlockLayer implements LayerRenderer<EntityBongoCat> {
	private final RenderBongoCat bongoRenderer;

	public NoteBlockLayer(RenderBongoCat bongoRenderer)
	{
		this.bongoRenderer = bongoRenderer;
	}

	@Override
	public void doRenderLayer(EntityBongoCat entitylivingbaseIn, float limbSwing, float limbSwingAmount,
							  float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		ItemStack noteStack = new ItemStack(Blocks.NOTEBLOCK);

		if (!noteStack.isEmpty())
		{
			GlStateManager.enableRescaleNormal();
			GlStateManager.pushMatrix();
			GlStateManager.translate(0.0F, 0.775F, -0.55F);
			GlStateManager.scale(0.75F, 0.75F, 0.75F);
			GlStateManager.rotate(-10.0F, 1.0F, 0.0F, 0.0F);

			int i = entitylivingbaseIn.getBrightnessForRender();
			int j = i % 65536;
			int k = i / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

			GlStateManager.scale(0.45F, 0.45F, 0.45F);
			GlStateManager.translate(0.7F, 0.75F, 1F);
			Minecraft.getMinecraft().getRenderItem().renderItem(noteStack, ItemCameraTransforms.TransformType.NONE);

			GlStateManager.translate(-1.4F, 0F, 0F);
			Minecraft.getMinecraft().getRenderItem().renderItem(noteStack, ItemCameraTransforms.TransformType.NONE);
			GlStateManager.popMatrix();
			GlStateManager.disableRescaleNormal();
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
}