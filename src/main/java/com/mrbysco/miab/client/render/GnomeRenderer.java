package com.mrbysco.miab.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.GnomeModel;
import com.mrbysco.miab.entity.memes.GnomeEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GnomeRenderer extends MobRenderer<GnomeEntity, GnomeModel<GnomeEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/gnome.png");

	public GnomeRenderer(EntityRendererProvider.Context context) {
		super(context, new GnomeModel(context.bakeLayer(ClientHandler.GNOME)), 0.5F);
	}

	@Override
	protected void scale(GnomeEntity gnomeEntity, PoseStack poseStack, float partialTickTime) {
		poseStack.scale(0.75F, 0.75F, 0.75F);
	}

	public ResourceLocation getTextureLocation(GnomeEntity entity) {
		return TEXTURE;
	}
}
