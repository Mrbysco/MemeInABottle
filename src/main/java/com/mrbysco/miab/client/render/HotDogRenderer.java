package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.HotDogModel;
import com.mrbysco.miab.entity.memes.HotDogEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class HotDogRenderer extends BipedRenderer<HotDogEntity, HotDogModel<HotDogEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/hotdog.png");

    public HotDogRenderer(EntityRendererManager EntityRendererManagerIn) {
        super(EntityRendererManagerIn, new HotDogModel(), 0.5F);
    }

    public ResourceLocation getEntityTexture(HotDogEntity entity) {
        return TEXTURE;
    }
}
