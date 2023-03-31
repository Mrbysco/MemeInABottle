package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.HumanBaseModel;
import com.mrbysco.miab.entity.memes.PhilSwiftEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class PhilSwiftRenderer extends AbstractHumanoidRenderer<PhilSwiftEntity, HumanBaseModel<PhilSwiftEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/phil_swift.png");

	public PhilSwiftRenderer(EntityRendererProvider.Context context) {
		this(context, ClientHandler.PHIL_SWIFT, ClientHandler.HUMANOID_INNER_ARMOR, ClientHandler.HUMANOID_OUTER_ARMOR);
	}

	public PhilSwiftRenderer(EntityRendererProvider.Context context, ModelLayerLocation layerLocation,
							 ModelLayerLocation innerLocation, ModelLayerLocation outerLocation) {
		super(context,
				new HumanBaseModel<>(context.bakeLayer(layerLocation)),
				new HumanBaseModel<>(context.bakeLayer(innerLocation)),
				new HumanBaseModel<>(context.bakeLayer(outerLocation)));
	}

	public ResourceLocation getTextureLocation(PhilSwiftEntity entity) {
		return TEXTURE;
	}
}
