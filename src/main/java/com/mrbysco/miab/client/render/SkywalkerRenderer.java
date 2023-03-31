package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.HumanBaseModel;
import com.mrbysco.miab.entity.memes.SkywalkerEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class SkywalkerRenderer extends AbstractHumanoidRenderer<SkywalkerEntity, HumanBaseModel<SkywalkerEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/skywalker.png");

	public SkywalkerRenderer(EntityRendererProvider.Context context) {
		this(context, ClientHandler.SKYWALKER, ClientHandler.HUMANOID_INNER_ARMOR, ClientHandler.HUMANOID_OUTER_ARMOR);
	}

	public SkywalkerRenderer(EntityRendererProvider.Context context, ModelLayerLocation layerLocation,
							 ModelLayerLocation innerLocation, ModelLayerLocation outerLocation) {
		super(context,
				new HumanBaseModel<>(context.bakeLayer(layerLocation)),
				new HumanBaseModel<>(context.bakeLayer(innerLocation)),
				new HumanBaseModel<>(context.bakeLayer(outerLocation)));
	}

	public ResourceLocation getTextureLocation(SkywalkerEntity entity) {
		return TEXTURE;
	}
}
