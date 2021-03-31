package com.mrbysco.miab.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ClippyModel;
import com.mrbysco.miab.entity.memes.ClippyEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class ClippyRenderer extends MobRenderer<ClippyEntity, ClippyModel<ClippyEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/clippy.png");

    public ClippyRenderer(EntityRendererManager EntityRendererManagerIn) {
        super(EntityRendererManagerIn, new ClippyModel(), 0.5F);
    }

    @Override
    protected void preRenderCallback(ClippyEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        float f = 0.999F;
        matrixStackIn.scale(f, f, f);
        matrixStackIn.translate(0.0D, (double)0.001F, 0.0D);
        float f1 = (float)1;
        float f2 = MathHelper.lerp(partialTickTime, entitylivingbaseIn.prevJumpFactor, entitylivingbaseIn.jumpFactor) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        matrixStackIn.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

    public ResourceLocation getEntityTexture(ClippyEntity entity) {
        return TEXTURE;
    }
}
