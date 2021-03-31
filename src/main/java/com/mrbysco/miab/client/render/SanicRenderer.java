package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.SanicModel;
import com.mrbysco.miab.entity.memes.SanicEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SanicRenderer extends MobRenderer<SanicEntity, SanicModel<SanicEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/sanic.png");

    public SanicRenderer(EntityRendererManager EntityRendererManagerIn) {
        super(EntityRendererManagerIn, new SanicModel(), 0.5F);
    }

    public ResourceLocation getEntityTexture(SanicEntity entity) {
        return TEXTURE;
    }
}
