package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.ShrekModel;
import com.mrbysco.miab.entity.memes.ShrekEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ShrekRenderer extends HumanoidMobRenderer<ShrekEntity, ShrekModel<ShrekEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/shrek.png");

	public ShrekRenderer(EntityRendererProvider.Context context) {
		super(context, new ShrekModel<>(context.bakeLayer(ClientHandler.SHREK)), 0.5F);
	}

	public ResourceLocation getTextureLocation(ShrekEntity entity) {
		return TEXTURE;
	}
}
