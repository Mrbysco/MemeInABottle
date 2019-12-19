package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelHumanBase;
import com.mrbysco.miab.client.models.ModelRobbie;
import com.mrbysco.miab.entity.memes.EntityRobbie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.util.ResourceLocation;

public class RenderRobbie extends RenderBiped<EntityRobbie>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/robbie.png");

    public RenderRobbie(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelRobbie(), 0.5F);
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

    protected ResourceLocation getEntityTexture(EntityRobbie entity)
    {
        return TEXTURE;
    }
}
