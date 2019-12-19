package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelHumanBase;
import com.mrbysco.miab.client.models.ModelShrek;
import com.mrbysco.miab.entity.memes.EntityCena;
import com.mrbysco.miab.entity.memes.EntityShrek;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.util.ResourceLocation;

public class RenderShrek extends RenderBiped<EntityShrek>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/shrek.png");

    public RenderShrek(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelShrek(), 0.5F);
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

    protected ResourceLocation getEntityTexture(EntityShrek entity)
    {
        return TEXTURE;
    }
}
