package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.TomModel;
import com.mrbysco.miab.entity.memes.ChocolateGuyEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ChocolateGuyRenderer extends MobRenderer<ChocolateGuyEntity, TomModel<ChocolateGuyEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/tom.png");

    public ChocolateGuyRenderer(EntityRendererManager EntityRendererManagerIn) {
        super(EntityRendererManagerIn, new TomModel(), 0.5F);
    }

    public ResourceLocation getEntityTexture(ChocolateGuyEntity entity) {
        return TEXTURE;
    }
}
