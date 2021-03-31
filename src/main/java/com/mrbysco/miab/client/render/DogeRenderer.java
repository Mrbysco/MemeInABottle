package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.ResourceLocation;

public class DogeRenderer extends WolfRenderer {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/doge.png");

    public DogeRenderer(EntityRendererManager EntityRendererManagerIn)
    {
        super(EntityRendererManagerIn);
    }

    public ResourceLocation getEntityTexture(WolfEntity entity) {
        return TEXTURE;
    }
}
