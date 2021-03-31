package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.RoflCopterModel;
import com.mrbysco.miab.entity.memes.RoflCopterEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RoflCopterRenderer extends MobRenderer<RoflCopterEntity, RoflCopterModel<RoflCopterEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/roflcopter.png");

    public RoflCopterRenderer(EntityRendererManager EntityRendererManagerIn) {
        super(EntityRendererManagerIn, new RoflCopterModel(), 1.0F);
    }

    public ResourceLocation getEntityTexture(RoflCopterEntity entity) {
        return TEXTURE;
    }
}
