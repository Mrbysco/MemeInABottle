package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelHumanBase;
import com.mrbysco.miab.client.models.ModelShrek;
import com.mrbysco.miab.entity.memes.EntityShrek;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class RenderShrek<T extends EntityShrek, M extends ModelShrek<T>> extends BipedRenderer<EntityShrek, ModelShrek<EntityShrek>>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/shrek.png");

    public RenderShrek(EntityRendererManager EntityRendererManagerIn)
    {
        super(EntityRendererManagerIn, new ModelShrek(), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new ModelHumanBase<>(0.5F, true), new ModelHumanBase<>(1.0F, true)));
    }

    protected ResourceLocation getEntityTexture(EntityShrek entity)
    {
        return TEXTURE;
    }
}
