package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.PepeModel;
import com.mrbysco.miab.entity.memes.PepeEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PepeRenderer extends HumanoidMobRenderer<PepeEntity, PepeModel<PepeEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/pepe.png");

	public PepeRenderer(EntityRendererProvider.Context context) {
		super(context, new PepeModel(context.bakeLayer(ClientHandler.PEPE)), 0.5F);
	}

	public ResourceLocation getTextureLocation(PepeEntity entity) {
		return TEXTURE;
	}
}
