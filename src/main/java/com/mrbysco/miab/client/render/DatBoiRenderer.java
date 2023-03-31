package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.DatBoiModel;
import com.mrbysco.miab.entity.memes.DatBoiEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DatBoiRenderer extends MobRenderer<DatBoiEntity, DatBoiModel<DatBoiEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/datboi.png");

	public DatBoiRenderer(EntityRendererProvider.Context context) {
		super(context, new DatBoiModel(context.bakeLayer(ClientHandler.DAT_BOI)), 0.5F);
	}

	public ResourceLocation getTextureLocation(DatBoiEntity entity) {
		return TEXTURE;
	}
}
