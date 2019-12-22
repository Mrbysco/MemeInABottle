package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelHumanBase;
import com.mrbysco.miab.client.models.ModelPepe;
import com.mrbysco.miab.entity.memes.EntityPepe;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class RenderPepe<T extends EntityPepe, M extends ModelPepe<T>> extends BipedRenderer<EntityPepe, ModelPepe<EntityPepe>>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/pepe.png");

    public RenderPepe(EntityRendererManager EntityRendererManagerIn)
    {
        super(EntityRendererManagerIn, new ModelPepe(), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new ModelHumanBase<>(0.5F, true), new ModelHumanBase<>(1.0F, true)));
    }

    protected ResourceLocation getEntityTexture(EntityPepe entity)
    {
        return TEXTURE;
    }
}
