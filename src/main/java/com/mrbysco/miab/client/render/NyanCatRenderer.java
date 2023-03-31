package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.NyanModel;
import com.mrbysco.miab.entity.memes.NyanCatEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class NyanCatRenderer extends MobRenderer<NyanCatEntity, NyanModel<NyanCatEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/nyancat.png");

	public NyanCatRenderer(EntityRendererProvider.Context context) {
		super(context, new NyanModel(context.bakeLayer(ClientHandler.NYAN_CAT)), 0.5F);
	}

	public ResourceLocation getTextureLocation(NyanCatEntity entity) {
		return TEXTURE;
	}
}
