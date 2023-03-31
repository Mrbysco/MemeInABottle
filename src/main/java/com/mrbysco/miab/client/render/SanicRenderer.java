package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.SanicModel;
import com.mrbysco.miab.entity.memes.SanicEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SanicRenderer extends MobRenderer<SanicEntity, SanicModel<SanicEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/sanic.png");

	public SanicRenderer(EntityRendererProvider.Context context) {
		super(context, new SanicModel(context.bakeLayer(ClientHandler.SANIC)), 0.5F);
	}

	public ResourceLocation getTextureLocation(SanicEntity entity) {
		return TEXTURE;
	}
}
