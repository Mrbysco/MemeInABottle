package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.DankeyModel;
import com.mrbysco.miab.client.models.HumanBaseModel;
import com.mrbysco.miab.entity.memes.DankeyEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class DankeyRenderer extends BipedRenderer<DankeyEntity, DankeyModel<DankeyEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/dankey_kang.png");

    public DankeyRenderer(EntityRendererManager EntityRendererManagerIn) {
        super(EntityRendererManagerIn, new DankeyModel(), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new HumanBaseModel<>(0.5F, true), new HumanBaseModel<>(1.0F, true)));
    }

    public ResourceLocation getEntityTexture(DankeyEntity entity) {
        return TEXTURE;
    }
}
