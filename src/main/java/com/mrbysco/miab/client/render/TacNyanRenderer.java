package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.NyanModel;
import com.mrbysco.miab.entity.memes.TacNyanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TacNyanRenderer extends MobRenderer<TacNyanEntity, NyanModel<TacNyanEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/tacnayn.png");

	public TacNyanRenderer(EntityRendererProvider.Context context) {
		super(context, new NyanModel(context.bakeLayer(ClientHandler.TAC_NAYN)), 0.5F);
	}

	public ResourceLocation getTextureLocation(TacNyanEntity entity) {
		return TEXTURE;
	}
}
