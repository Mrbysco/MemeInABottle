package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelNyan;
import com.mrbysco.miab.entity.memes.EntityNyanCat;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderNyanCat extends MobRenderer<EntityNyanCat, ModelNyan<EntityNyanCat>>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/nyancat.png");

    public RenderNyanCat(EntityRendererManager EntityRendererManagerIn)
    {
        super(EntityRendererManagerIn, new ModelNyan(), 0.5F);
    }

    protected ResourceLocation getEntityTexture(EntityNyanCat entity)
    {
        return TEXTURE;
    }
}
