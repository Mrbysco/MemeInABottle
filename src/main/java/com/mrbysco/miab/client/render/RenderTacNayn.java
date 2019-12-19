package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelNyan;
import com.mrbysco.miab.entity.memes.EntityNyanCat;
import com.mrbysco.miab.entity.memes.EntityTacNayn;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTacNayn extends RenderLiving<EntityTacNayn>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/tacnayn.png");

    public RenderTacNayn(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelNyan(), 0.5F);
    }

    protected ResourceLocation getEntityTexture(EntityTacNayn entity)
    {
        return TEXTURE;
    }
}
