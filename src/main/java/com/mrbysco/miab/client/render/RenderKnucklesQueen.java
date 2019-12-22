package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelHumanBase;
import com.mrbysco.miab.client.models.knuckles.ModelKnucklesQueen;
import com.mrbysco.miab.entity.memes.EntityKnucklesQueen;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class RenderKnucklesQueen<T extends EntityKnucklesQueen, M extends ModelKnucklesQueen<T>> extends BipedRenderer<EntityKnucklesQueen, ModelKnucklesQueen<EntityKnucklesQueen>>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/da_queen.png");

    public RenderKnucklesQueen(EntityRendererManager EntityRendererManagerIn)
    {
        super(EntityRendererManagerIn, new ModelKnucklesQueen(), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new ModelHumanBase<>(0.5F, true), new ModelHumanBase<>(1.0F, true)));
    }

    protected ResourceLocation getEntityTexture(EntityKnucklesQueen entity)
    {
        return TEXTURE;
    }
}
