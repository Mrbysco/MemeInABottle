package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.PinguModel;
import com.mrbysco.miab.entity.memes.PinguEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PinguRenderer extends MobRenderer<PinguEntity, PinguModel<PinguEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/pingu.png");

	public PinguRenderer(EntityRendererProvider.Context context) {
		super(context, new PinguModel<>(context.bakeLayer(ClientHandler.PINGU)), 0.5F);
	}

	public ResourceLocation getTextureLocation(PinguEntity entity) {
		return TEXTURE;
	}
}
