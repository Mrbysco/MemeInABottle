package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import net.minecraft.client.renderer.entity.CatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cat;

public class GrumpyRenderer extends CatRenderer {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/grumpy.png");

	public GrumpyRenderer(EntityRendererProvider.Context context) {
		super(context);
	}

	@Override
	public ResourceLocation getTextureLocation(Cat entity) {
		return TEXTURE;
	}
}
