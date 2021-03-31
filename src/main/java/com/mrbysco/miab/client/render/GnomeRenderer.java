package com.mrbysco.miab.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.GnomeModel;
import com.mrbysco.miab.entity.memes.GnomeEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GnomeRenderer extends MobRenderer<GnomeEntity, GnomeModel<GnomeEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/gnome.png");

    public GnomeRenderer(EntityRendererManager EntityRendererManagerIn) {
        super(EntityRendererManagerIn, new GnomeModel(), 0.5F);
    }

    @Override
    protected void preRenderCallback(GnomeEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(0.75F, 0.75F, 0.75F);
    }

    public ResourceLocation getEntityTexture(GnomeEntity entity) {
        return TEXTURE;
    }
}
