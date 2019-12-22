package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelHumanBase;
import com.mrbysco.miab.client.models.ModelNigel;
import com.mrbysco.miab.entity.memes.EntityNigel;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class RenderNigel<T extends EntityNigel, M extends ModelNigel<T>> extends BipedRenderer<EntityNigel, ModelNigel<EntityNigel>>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/nigel.png");

    public RenderNigel(EntityRendererManager EntityRendererManagerIn)
    {
        super(EntityRendererManagerIn, new ModelNigel(), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new ModelHumanBase<>(0.5F, true), new ModelHumanBase<>(1.0F, true)));
    }

    protected ResourceLocation getEntityTexture(EntityNigel entity)
    {
        return TEXTURE;
    }
}
