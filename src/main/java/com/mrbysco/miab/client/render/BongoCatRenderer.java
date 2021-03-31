package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.BongoCatModel;
import com.mrbysco.miab.client.render.layer.NoteBlockLayer;
import com.mrbysco.miab.entity.memes.BongoCatEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BongoCatRenderer extends MobRenderer<BongoCatEntity, BongoCatModel<BongoCatEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/bongocat.png");

    public BongoCatRenderer(EntityRendererManager EntityRendererManagerIn) {
        super(EntityRendererManagerIn, new BongoCatModel(), 0.3F);
        this.addLayer(new NoteBlockLayer(this));
    }

    public ResourceLocation getEntityTexture(BongoCatEntity entity) {
        return TEXTURE;
    }
}
