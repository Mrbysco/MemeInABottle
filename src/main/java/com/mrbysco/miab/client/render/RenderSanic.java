package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelSanic;
import com.mrbysco.miab.entity.memes.EntitySanic;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSanic extends RenderLiving<EntitySanic>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/sanic.png");

    public RenderSanic(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelSanic(), 0.5F);
    }

    protected ResourceLocation getEntityTexture(EntitySanic entity)
    {
        return TEXTURE;
    }
}
