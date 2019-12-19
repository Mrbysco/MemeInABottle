package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelHotDog;
import com.mrbysco.miab.entity.memes.EntityHotDog;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderHotDog extends RenderBiped<EntityHotDog>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/hotdog.png");

    public RenderHotDog(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelHotDog(), 0.5F);
    }

    protected ResourceLocation getEntityTexture(EntityHotDog entity)
    {
        return TEXTURE;
    }
}
