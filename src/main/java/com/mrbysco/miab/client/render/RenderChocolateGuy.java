package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelHumanBase;
import com.mrbysco.miab.client.models.ModelTom;
import com.mrbysco.miab.entity.memes.EntityChocolateGuy;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class RenderChocolateGuy<T extends EntityChocolateGuy, M extends ModelTom<T>> extends BipedRenderer<EntityChocolateGuy, ModelTom<EntityChocolateGuy>>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/tom.png");

    public RenderChocolateGuy(EntityRendererManager EntityRendererManagerIn)
    {
        super(EntityRendererManagerIn, new ModelTom(), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new ModelHumanBase<>(0.5F, true), new ModelHumanBase<>(1.0F, true)));
    }

    protected ResourceLocation getEntityTexture(EntityChocolateGuy entity)
    {
        return TEXTURE;
    }
}
