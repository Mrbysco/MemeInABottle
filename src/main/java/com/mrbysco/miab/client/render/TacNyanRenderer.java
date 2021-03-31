package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.NyanModel;
import com.mrbysco.miab.entity.memes.TacNyanEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class TacNyanRenderer extends MobRenderer<TacNyanEntity, NyanModel<TacNyanEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/tacnayn.png");

    public TacNyanRenderer(EntityRendererManager EntityRendererManagerIn) {
        super(EntityRendererManagerIn, new NyanModel(), 0.5F);
    }

    public ResourceLocation getEntityTexture(TacNyanEntity entity) {
        return TEXTURE;
    }
}
