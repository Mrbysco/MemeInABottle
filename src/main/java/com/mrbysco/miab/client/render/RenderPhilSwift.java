package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelHumanBase;
import com.mrbysco.miab.entity.memes.EntityPhilSwift;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class RenderPhilSwift<T extends EntityPhilSwift, M extends ModelHumanBase<T>> extends BipedRenderer<EntityPhilSwift, ModelHumanBase<EntityPhilSwift>>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/phill_swift.png");

    public RenderPhilSwift(EntityRendererManager EntityRendererManagerIn)
    {
        super(EntityRendererManagerIn, new ModelHumanBase(), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new ModelHumanBase<>(0.5F, true), new ModelHumanBase<>(1.0F, true)));
    }

    protected ResourceLocation getEntityTexture(EntityPhilSwift entity)
    {
        return TEXTURE;
    }
}
