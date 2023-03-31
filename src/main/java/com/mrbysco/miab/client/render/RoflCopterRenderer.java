package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.RoflCopterModel;
import com.mrbysco.miab.entity.memes.RoflCopterEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RoflCopterRenderer extends MobRenderer<RoflCopterEntity, RoflCopterModel<RoflCopterEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/roflcopter.png");

	public RoflCopterRenderer(EntityRendererProvider.Context context) {
		super(context, new RoflCopterModel(context.bakeLayer(ClientHandler.ROFL_COPTER)), 1.0F);
	}

	public ResourceLocation getTextureLocation(RoflCopterEntity entity) {
		return TEXTURE;
	}
}
