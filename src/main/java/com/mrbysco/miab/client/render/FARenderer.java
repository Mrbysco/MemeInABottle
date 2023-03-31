package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.FAModel;
import com.mrbysco.miab.entity.memes.FAEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FARenderer extends HumanoidMobRenderer<FAEntity, FAModel<FAEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/foreveralone.png");

	public FARenderer(EntityRendererProvider.Context context) {
		super(context, new FAModel<>(context.bakeLayer(ClientHandler.FOREVER_ALONE)), 0.5F);
	}

	public ResourceLocation getTextureLocation(FAEntity entity) {
		return TEXTURE;
	}
}
