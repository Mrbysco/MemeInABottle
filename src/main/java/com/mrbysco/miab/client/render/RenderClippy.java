package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelClippy;
import com.mrbysco.miab.entity.memes.EntityClippy;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderClippy extends RenderLiving<EntityClippy>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/clippy.png");

    public RenderClippy(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelClippy(), 0.5F);
    }

    protected void preRenderCallback(EntityClippy entitylivingbaseIn, float partialTickTime)
    {
        GlStateManager.scale(0.999F, 0.999F, 0.999F);
        float f1 = (float)1;
        float f2 = (entitylivingbaseIn.prevJumpFactor + (entitylivingbaseIn.jumpFactor - entitylivingbaseIn.prevJumpFactor) * partialTickTime) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GlStateManager.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

    protected ResourceLocation getEntityTexture(EntityClippy entity)
    {
        return TEXTURE;
    }
}
