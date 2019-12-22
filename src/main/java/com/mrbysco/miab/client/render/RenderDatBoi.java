package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelDatBoi;
import com.mrbysco.miab.entity.memes.EntityDatBoi;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderDatBoi extends MobRenderer<EntityDatBoi, ModelDatBoi<EntityDatBoi>>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/datboi.png");

    public RenderDatBoi(EntityRendererManager EntityRendererManagerIn)
    {
        super(EntityRendererManagerIn, new ModelDatBoi(), 0.5F);
    }

    protected ResourceLocation getEntityTexture(EntityDatBoi entity)
    {
        return TEXTURE;
    }
}
