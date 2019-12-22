package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelHumanBase;
import com.mrbysco.miab.entity.memes.EntityTrololo;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class RenderTrololo<T extends EntityTrololo, M extends ModelHumanBase<T>> extends BipedRenderer<EntityTrololo, ModelHumanBase<EntityTrololo>>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/khil.png");

    public RenderTrololo(EntityRendererManager EntityRendererManagerIn)
    {
        super(EntityRendererManagerIn, new ModelHumanBase(), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new ModelHumanBase<>(0.5F, true), new ModelHumanBase<>(1.0F, true)));
    }

    protected ResourceLocation getEntityTexture(EntityTrololo entity)
    {
        return TEXTURE;
    }
}
