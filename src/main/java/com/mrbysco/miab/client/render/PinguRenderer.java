package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.PinguModel;
import com.mrbysco.miab.entity.memes.PinguEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PinguRenderer extends MobRenderer<PinguEntity, PinguModel<PinguEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/pingu.png");

    public PinguRenderer(EntityRendererManager EntityRendererManagerIn) {
        super(EntityRendererManagerIn, new PinguModel(), 0.5F);
    }

    public ResourceLocation getEntityTexture(PinguEntity entity) {
        return TEXTURE;
    }
}
