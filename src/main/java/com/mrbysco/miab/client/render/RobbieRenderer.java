package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.RobbieModel;
import com.mrbysco.miab.entity.memes.RobbieEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class RobbieRenderer extends AbstractHumanoidRenderer<RobbieEntity, RobbieModel<RobbieEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/robbie.png");

	public RobbieRenderer(EntityRendererProvider.Context context) {
		this(context, ClientHandler.ROBBIE_ROTTEN, ClientHandler.HUMANOID_INNER_ARMOR, ClientHandler.HUMANOID_OUTER_ARMOR);
	}

	public RobbieRenderer(EntityRendererProvider.Context context, ModelLayerLocation layerLocation,
						  ModelLayerLocation innerLocation, ModelLayerLocation outerLocation) {
		super(context,
				new RobbieModel<>(context.bakeLayer(layerLocation)),
				new RobbieModel<>(context.bakeLayer(innerLocation)),
				new RobbieModel<>(context.bakeLayer(outerLocation)));
	}

	public ResourceLocation getTextureLocation(RobbieEntity entity) {
		return TEXTURE;
	}
}
