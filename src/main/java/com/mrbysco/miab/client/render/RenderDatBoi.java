package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelDatBoi;
import com.mrbysco.miab.entity.memes.EntityDatBoi;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDatBoi extends RenderLiving<EntityDatBoi>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/datboi.png");

    public RenderDatBoi(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelDatBoi(), 0.5F);
    }

    protected ResourceLocation getEntityTexture(EntityDatBoi entity)
    {
        return TEXTURE;
    }
}
