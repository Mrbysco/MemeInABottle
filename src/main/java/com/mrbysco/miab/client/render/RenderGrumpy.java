package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderOcelot;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.util.ResourceLocation;

public class RenderGrumpy extends RenderOcelot
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/grumpy.png");

    public RenderGrumpy(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityOcelot entity) {
        return TEXTURE;
    }
}
