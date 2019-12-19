package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelHumanBase;
import com.mrbysco.miab.entity.memes.EntityHeMan;
import com.mrbysco.miab.entity.memes.EntityMario7;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.util.ResourceLocation;

public class RenderHeMan extends RenderBiped<EntityHeMan>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/heman.png");

    public RenderHeMan(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelHumanBase(), 0.5F);
        LayerBipedArmor layerbipedarmor = new LayerBipedArmor(this)
        {
            protected void initArmor()
            {
                this.modelLeggings = new ModelHumanBase(0.5F, true);
                this.modelArmor = new ModelHumanBase(1.0F, true);
            }
        };
        this.addLayer(layerbipedarmor);
    }

    protected ResourceLocation getEntityTexture(EntityHeMan entity)
    {
        return TEXTURE;
    }
}
