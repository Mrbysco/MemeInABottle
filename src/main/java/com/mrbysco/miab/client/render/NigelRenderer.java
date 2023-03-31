package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.HumanBaseModel;
import com.mrbysco.miab.entity.memes.NigelEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class NigelRenderer extends AbstractHumanoidRenderer<NigelEntity, HumanBaseModel<NigelEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/nigel.png");

	public NigelRenderer(EntityRendererProvider.Context context) {
		this(context, ClientHandler.NIGEL_THORNBERRY, ClientHandler.HUMANOID_INNER_ARMOR, ClientHandler.HUMANOID_OUTER_ARMOR);
	}

	public NigelRenderer(EntityRendererProvider.Context context, ModelLayerLocation layerLocation,
						 ModelLayerLocation innerLocation, ModelLayerLocation outerLocation) {
		super(context,
				new HumanBaseModel<>(context.bakeLayer(layerLocation)),
				new HumanBaseModel<>(context.bakeLayer(innerLocation)),
				new HumanBaseModel<>(context.bakeLayer(outerLocation)));
	}

	public ResourceLocation getTextureLocation(NigelEntity entity) {
		return TEXTURE;
	}
}
