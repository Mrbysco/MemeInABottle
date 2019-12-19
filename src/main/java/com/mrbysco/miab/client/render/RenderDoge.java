package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;

public class RenderDoge extends RenderWolf
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/doge.png");

    public RenderDoge(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
    }

    protected ResourceLocation getEntityTexture(EntityWolf entity)
    {
        return TEXTURE;
    }
}
