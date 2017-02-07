package com.Mrbysco.MIAB.renderer.monsters;

import java.util.List;

import com.Mrbysco.MIAB.entity.monsters.entityBase.EntityMemeBase;
import com.google.common.collect.Lists;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.layers.LayerVillagerArmor;
import net.minecraft.util.ResourceLocation;

public class RenderMemeBase extends RenderBiped<EntityMemeBase>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation("miab:entity/texture.png");
    private final ModelBiped defaultModel;
    private final List<LayerRenderer<EntityMemeBase>> defaultLayers;

    public RenderMemeBase(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelZombie(), 0.5F, 1.0F);
        LayerRenderer<?> layerrenderer = (LayerRenderer)this.layerRenderers.get(0);
        this.defaultModel = this.modelBipedMain;
        this.addLayer(new LayerHeldItem(this));
        LayerBipedArmor layerbipedarmor = new LayerBipedArmor(this)
        {
            protected void initArmor()
            {
                this.modelLeggings = new ModelZombie(0.5F, true);
                this.modelArmor = new ModelZombie(1.0F, true);
            }
        };
        this.addLayer(layerbipedarmor);
        this.defaultLayers = Lists.newArrayList(this.layerRenderers);

        if (layerrenderer instanceof LayerCustomHead)
        {
            this.removeLayer(layerrenderer);
        }

        this.removeLayer(layerbipedarmor);
        this.addLayer(new LayerVillagerArmor(this));
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntityMemeBase entitylivingbaseIn, float partialTickTime)
    {
       super.preRenderCallback(entitylivingbaseIn, partialTickTime);
    }

    /**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(EntityMemeBase entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.swapArmor(entity);
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityMemeBase entity)
    {
            return TEXTURE;
    }

    private void swapArmor(EntityMemeBase meme)
    {
        this.modelBipedMain = (ModelBiped)this.mainModel;
    }

    protected void rotateCorpse(EntityMemeBase entityLiving, float p_77043_2_, float p_77043_3_, float partialTicks)
    {
        super.rotateCorpse(entityLiving, p_77043_2_, p_77043_3_, partialTicks);
    }
}