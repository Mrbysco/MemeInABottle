package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelSanic;
import com.mrbysco.miab.entity.memes.EntitySanic;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderSanic extends MobRenderer<EntitySanic, ModelSanic<EntitySanic>>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/sanic.png");

    public RenderSanic(EntityRendererManager EntityRendererManagerIn)
    {
        super(EntityRendererManagerIn, new ModelSanic(), 0.5F);
    }

    protected ResourceLocation getEntityTexture(EntitySanic entity)
    {
        return TEXTURE;
    }
}
