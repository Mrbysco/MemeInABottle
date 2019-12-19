package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelHumanBase;
import com.mrbysco.miab.entity.memes.EntityHeMan;
import com.mrbysco.miab.entity.memes.EntitySkywalker;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.util.ResourceLocation;

public class RenderSkywalker extends RenderBiped<EntitySkywalker>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/skywalker.png");

    public RenderSkywalker(RenderManager renderManagerIn)
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

    protected ResourceLocation getEntityTexture(EntitySkywalker entity)
    {
        return TEXTURE;
    }
}
