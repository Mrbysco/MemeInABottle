package com.mrbysco.miab.client.render;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.ModelBongoCat;
import com.mrbysco.miab.client.models.ModelHumanBase;
import com.mrbysco.miab.client.render.layer.NoteBlockLayer;
import com.mrbysco.miab.entity.memes.EntityBongoCat;
import com.mrbysco.miab.entity.memes.EntityCena;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.util.ResourceLocation;

public class RenderBongoCat extends RenderLiving<EntityBongoCat>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/bongocat.png");

    public RenderBongoCat(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelBongoCat(), 0.3F);
        this.addLayer(new NoteBlockLayer(this));
    }

    protected ResourceLocation getEntityTexture(EntityBongoCat entity)
    {
        return TEXTURE;
    }
}
