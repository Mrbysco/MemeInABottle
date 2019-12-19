package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelRoflCopter;
import com.mrbysco.miab.entity.memes.EntityRoflCopter;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderRoflCopter extends RenderLiving<EntityRoflCopter>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/roflcopter.png");

    public RenderRoflCopter(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelRoflCopter(), 1.0F);
    }

    protected ResourceLocation getEntityTexture(EntityRoflCopter entity)
    {
        return TEXTURE;
    }
}
