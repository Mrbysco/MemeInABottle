package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.DatBoiModel;
import com.mrbysco.miab.entity.memes.DatBoiEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class DatBoiRenderer extends MobRenderer<DatBoiEntity, DatBoiModel<DatBoiEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/datboi.png");

    public DatBoiRenderer(EntityRendererManager EntityRendererManagerIn) {
        super(EntityRendererManagerIn, new DatBoiModel(), 0.5F);
    }

    public ResourceLocation getEntityTexture(DatBoiEntity entity) {
        return TEXTURE;
    }
}
