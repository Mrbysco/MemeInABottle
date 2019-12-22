package com.mrbysco.miab.client.render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelGnome;
import com.mrbysco.miab.client.models.ModelHumanBase;
import com.mrbysco.miab.entity.memes.EntityGnome;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class RenderGnome<T extends EntityGnome, M extends ModelGnome<T>> extends BipedRenderer<EntityGnome, ModelGnome<EntityGnome>>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/gnome.png");

    public RenderGnome(EntityRendererManager EntityRendererManagerIn)
    {
        super(EntityRendererManagerIn, new ModelGnome(), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new ModelHumanBase<>(0.5F, true), new ModelHumanBase<>(1.0F, true)));
    }

    @Override
    protected void preRenderCallback(EntityGnome gnome, float partialTickTime) {
        GlStateManager.scalef(0.75F,0.75F,0.75F);
    }

    protected ResourceLocation getEntityTexture(EntityGnome entity)
    {
        return TEXTURE;
    }
}
