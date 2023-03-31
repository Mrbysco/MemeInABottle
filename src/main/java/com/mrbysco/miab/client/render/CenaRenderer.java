package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.HumanBaseModel;
import com.mrbysco.miab.entity.memes.CenaEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class CenaRenderer extends AbstractHumanoidRenderer<CenaEntity, HumanBaseModel<CenaEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/john_cena.png");

	public CenaRenderer(EntityRendererProvider.Context context) {
		this(context, ClientHandler.JOHN_CENA, ClientHandler.HUMANOID_INNER_ARMOR, ClientHandler.HUMANOID_OUTER_ARMOR);
	}

	public CenaRenderer(EntityRendererProvider.Context context, ModelLayerLocation layerLocation,
						ModelLayerLocation innerLocation, ModelLayerLocation outerLocation) {
		super(context,
				new HumanBaseModel<>(context.bakeLayer(layerLocation)),
				new HumanBaseModel<>(context.bakeLayer(innerLocation)),
				new HumanBaseModel<>(context.bakeLayer(outerLocation)));
	}

	public ResourceLocation getTextureLocation(CenaEntity entity) {
		return TEXTURE;
	}
}
