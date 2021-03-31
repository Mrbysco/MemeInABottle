package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.HumanBaseModel;
import com.mrbysco.miab.client.models.knuckles.KnucklesQueenModel;
import com.mrbysco.miab.entity.memes.KnucklesQueenEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class KnucklesQueenRenderer extends BipedRenderer<KnucklesQueenEntity, KnucklesQueenModel<KnucklesQueenEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/da_queen.png");

    public KnucklesQueenRenderer(EntityRendererManager EntityRendererManagerIn) {
        super(EntityRendererManagerIn, new KnucklesQueenModel(), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new HumanBaseModel<>(0.5F, true), new HumanBaseModel<>(1.0F, true)));
    }

    public ResourceLocation getEntityTexture(KnucklesQueenEntity entity) {
        return TEXTURE;
    }
}
