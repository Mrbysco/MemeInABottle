package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelPingu;
import com.mrbysco.miab.entity.memes.EntityPingu;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPingu extends RenderLiving<EntityPingu>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/pingu.png");

    public RenderPingu(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelPingu(), 0.5F);
    }

    protected ResourceLocation getEntityTexture(EntityPingu entity)
    {
        return TEXTURE;
    }
}
