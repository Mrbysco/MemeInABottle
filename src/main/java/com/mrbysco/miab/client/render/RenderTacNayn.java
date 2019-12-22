package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelNyan;
import com.mrbysco.miab.entity.memes.EntityTacNayn;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderTacNayn extends MobRenderer<EntityTacNayn, ModelNyan<EntityTacNayn>>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/tacnayn.png");

    public RenderTacNayn(EntityRendererManager EntityRendererManagerIn)
    {
        super(EntityRendererManagerIn, new ModelNyan(), 0.5F);
    }

    protected ResourceLocation getEntityTexture(EntityTacNayn entity)
    {
        return TEXTURE;
    }
}
