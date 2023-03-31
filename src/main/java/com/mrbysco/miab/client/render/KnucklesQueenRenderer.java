package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.knuckles.KnucklesQueenModel;
import com.mrbysco.miab.entity.memes.KnucklesQueenEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public class KnucklesQueenRenderer extends HumanoidMobRenderer<KnucklesQueenEntity, KnucklesQueenModel<KnucklesQueenEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/da_queen.png");

	public KnucklesQueenRenderer(EntityRendererProvider.Context context) {
		super(context, new KnucklesQueenModel<>(context.bakeLayer(ClientHandler.KNUCKLES_QUEEN)), 0.5F);
	}

	public ResourceLocation getTextureLocation(KnucklesQueenEntity entity) {
		return TEXTURE;
	}
}
