package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelHotDog;
import com.mrbysco.miab.entity.memes.EntityHotDog;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class RenderHotDog<T extends EntityHotDog, M extends ModelHotDog<T>> extends BipedRenderer<EntityHotDog, ModelHotDog<EntityHotDog>>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/hotdog.png");

    public RenderHotDog(EntityRendererManager EntityRendererManagerIn)
    {
        super(EntityRendererManagerIn, new ModelHotDog(), 0.5F);
    }

    protected ResourceLocation getEntityTexture(EntityHotDog entity)
    {
        return TEXTURE;
    }
}
