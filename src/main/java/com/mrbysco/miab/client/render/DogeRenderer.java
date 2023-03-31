package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Wolf;

public class DogeRenderer extends WolfRenderer {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/doge.png");

	public DogeRenderer(EntityRendererProvider.Context context) {
		super(context);
	}

	public ResourceLocation getTextureLocation(Wolf entity) {
		return TEXTURE;
	}
}
