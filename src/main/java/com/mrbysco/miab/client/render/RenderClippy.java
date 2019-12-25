package com.mrbysco.miab.client.render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelClippy;
import com.mrbysco.miab.entity.memes.EntityClippy;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class RenderClippy extends MobRenderer<EntityClippy, ModelClippy<EntityClippy>>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/clippy.png");

    public RenderClippy(EntityRendererManager EntityRendererManagerIn)
    {
        super(EntityRendererManagerIn, new ModelClippy(), 0.5F);
    }

    protected void preRenderCallback(EntityClippy entitylivingbaseIn, float partialTickTime)
    {
        GlStateManager.scalef(0.999F, 0.999F, 0.999F);
        float f1 = (float)1;
        float f2 = MathHelper.lerp(partialTickTime, entitylivingbaseIn.prevJumpFactor, entitylivingbaseIn.jumpFactor) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GlStateManager.scalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

    protected ResourceLocation getEntityTexture(EntityClippy entity)
    {
        return TEXTURE;
    }
}
