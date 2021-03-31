package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import net.minecraft.client.renderer.entity.CatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.ResourceLocation;

public class GrumpyRenderer extends CatRenderer {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/grumpy.png");

    public GrumpyRenderer(EntityRendererManager EntityRendererManagerIn)
    {
        super(EntityRendererManagerIn);
    }

    @Override
    public ResourceLocation getEntityTexture(CatEntity entity) {
        return TEXTURE;
    }
}
