package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.NyanModel;
import com.mrbysco.miab.entity.memes.NyanCatEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class NyanCatRenderer extends MobRenderer<NyanCatEntity, NyanModel<NyanCatEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/nyancat.png");

    public NyanCatRenderer(EntityRendererManager EntityRendererManagerIn) {
        super(EntityRendererManagerIn, new NyanModel(), 0.5F);
    }

    public ResourceLocation getEntityTexture(NyanCatEntity entity) {
        return TEXTURE;
    }
}
