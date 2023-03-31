package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.HotDogModel;
import com.mrbysco.miab.entity.memes.HotDogEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HotDogRenderer extends HumanoidMobRenderer<HotDogEntity, HotDogModel<HotDogEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/hotdog.png");

	public HotDogRenderer(EntityRendererProvider.Context context) {
		super(context, new HotDogModel(context.bakeLayer(ClientHandler.DANCING_HOTDOG)), 0.5F);
	}

	public ResourceLocation getTextureLocation(HotDogEntity entity) {
		return TEXTURE;
	}
}
