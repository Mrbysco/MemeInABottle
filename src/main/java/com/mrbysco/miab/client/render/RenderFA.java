package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelFA;
import com.mrbysco.miab.client.models.ModelHumanBase;
import com.mrbysco.miab.entity.memes.EntityFA;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class RenderFA<T extends EntityFA, M extends ModelFA<T>> extends BipedRenderer<EntityFA, ModelFA<EntityFA>>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/foreveralone.png");

    public RenderFA(EntityRendererManager EntityRendererManagerIn)
    {
        super(EntityRendererManagerIn, new ModelFA(), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new ModelHumanBase<>(0.5F, true), new ModelHumanBase<>(1.0F, true)));
    }

    protected ResourceLocation getEntityTexture(EntityFA entity)
    {
        return TEXTURE;
    }
}
