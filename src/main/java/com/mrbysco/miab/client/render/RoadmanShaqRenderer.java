package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.HumanBaseModel;
import com.mrbysco.miab.entity.memes.RoadmanShaqEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class RoadmanShaqRenderer extends BipedRenderer<RoadmanShaqEntity, HumanBaseModel<RoadmanShaqEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/bigshaq.png");

    public RoadmanShaqRenderer(EntityRendererManager EntityRendererManagerIn) {
        super(EntityRendererManagerIn, new HumanBaseModel(), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new HumanBaseModel<>(0.5F, true), new HumanBaseModel<>(1.0F, true)));
    }

    public ResourceLocation getEntityTexture(RoadmanShaqEntity entity) {
        return TEXTURE;
    }
}
