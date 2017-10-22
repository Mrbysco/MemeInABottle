package com.Mrbysco.miab.rendering.baserender;

import com.Mrbysco.miab.entities.base.EntityMemeBase;

import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.util.ResourceLocation;

public class RenderMemeBase extends RenderBiped<EntityMemeBase>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation("miab:entity/texture.png");

    public RenderMemeBase(RenderManager renderManagerIn)
    {
    	super(renderManagerIn, new ModelZombie(), 0.5F);
        LayerBipedArmor layerbipedarmor = new LayerBipedArmor(this)
        {
            protected void initArmor()
            {
                this.modelLeggings = new ModelZombie(0.5F, true);
                this.modelArmor = new ModelZombie(1.0F, true);
            }
        };
        this.addLayer(layerbipedarmor);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityMemeBase entity)
    {
            return TEXTURE;
    }
}