package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelNyan;
import com.mrbysco.miab.entity.memes.EntityNyanCat;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderNyanCat extends RenderLiving<EntityNyanCat>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/nyancat.png");

    public RenderNyanCat(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelNyan(), 0.5F);
    }

    protected ResourceLocation getEntityTexture(EntityNyanCat entity)
    {
        return TEXTURE;
    }
}
