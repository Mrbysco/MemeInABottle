package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.BongoCatModel;
import com.mrbysco.miab.client.render.layer.NoteBlockLayer;
import com.mrbysco.miab.entity.memes.BongoCatEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BongoCatRenderer extends MobRenderer<BongoCatEntity, BongoCatModel<BongoCatEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/bongocat.png");

	public BongoCatRenderer(EntityRendererProvider.Context context) {
		super(context, new BongoCatModel(context.bakeLayer(ClientHandler.BONGO_CAT)), 0.3F);
		this.addLayer(new NoteBlockLayer(this, context.getItemInHandRenderer()));
	}

	public ResourceLocation getTextureLocation(BongoCatEntity entity) {
		return TEXTURE;
	}
}
