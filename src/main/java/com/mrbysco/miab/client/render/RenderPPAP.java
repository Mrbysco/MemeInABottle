package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelHumanBase;
import com.mrbysco.miab.entity.memes.EntityPPAP;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class RenderPPAP<T extends EntityPPAP, M extends ModelHumanBase<T>> extends BipedRenderer<EntityPPAP, ModelHumanBase<EntityPPAP>>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/kosakadaimaou.png");

    public RenderPPAP(EntityRendererManager EntityRendererManagerIn)
    {
        super(EntityRendererManagerIn, new ModelHumanBase(), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new ModelHumanBase<>(0.5F, true), new ModelHumanBase<>(1.0F, true)));
    }

    protected ResourceLocation getEntityTexture(EntityPPAP entity)
    {
        return TEXTURE;
    }
}