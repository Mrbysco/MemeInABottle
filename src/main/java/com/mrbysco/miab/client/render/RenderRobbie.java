package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelHumanBase;
import com.mrbysco.miab.client.models.ModelRobbie;
import com.mrbysco.miab.entity.memes.EntityRobbie;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class RenderRobbie<T extends EntityRobbie, M extends ModelRobbie<T>> extends BipedRenderer<EntityRobbie, ModelRobbie<EntityRobbie>>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/robbie.png");

    public RenderRobbie(EntityRendererManager EntityRendererManagerIn)
    {
        super(EntityRendererManagerIn, new ModelRobbie(), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new ModelHumanBase<>(0.5F, true), new ModelHumanBase<>(1.0F, true)));
    }

    protected ResourceLocation getEntityTexture(EntityRobbie entity)
    {
        return TEXTURE;
    }
}
