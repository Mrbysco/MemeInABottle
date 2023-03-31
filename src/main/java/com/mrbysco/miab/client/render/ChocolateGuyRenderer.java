package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.TomModel;
import com.mrbysco.miab.entity.memes.ChocolateGuyEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class ChocolateGuyRenderer extends AbstractHumanoidRenderer<ChocolateGuyEntity, TomModel<ChocolateGuyEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/tom.png");

	public ChocolateGuyRenderer(EntityRendererProvider.Context context) {
		this(context, ClientHandler.TOM, ClientHandler.HUMANOID_INNER_ARMOR, ClientHandler.HUMANOID_OUTER_ARMOR);
	}

	public ChocolateGuyRenderer(EntityRendererProvider.Context context, ModelLayerLocation layerLocation,
								ModelLayerLocation innerLocation, ModelLayerLocation outerLocation) {
		super(context,
				new TomModel<>(context.bakeLayer(layerLocation)),
				new TomModel<>(context.bakeLayer(innerLocation)),
				new TomModel<>(context.bakeLayer(outerLocation)));
	}

	public ResourceLocation getTextureLocation(ChocolateGuyEntity entity) {
		return TEXTURE;
	}
}
