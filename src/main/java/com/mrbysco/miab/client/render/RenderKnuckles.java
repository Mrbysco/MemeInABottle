package com.mrbysco.miab.client.render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.knuckles.ModelKnuckles;
import com.mrbysco.miab.client.models.knuckles.ModelKnucklesAku;
import com.mrbysco.miab.client.models.knuckles.ModelKnucklesSaiyan;
import com.mrbysco.miab.client.models.knuckles.ModelKnucklesTank;
import com.mrbysco.miab.client.models.knuckles.ModelKnucklesYugi;
import com.mrbysco.miab.entity.memes.EntityKnuckles;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class RenderKnuckles extends MobRenderer<EntityKnuckles, EntityModel<EntityKnuckles>>
{	private static final ResourceLocation REGULAR = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/knuckles.png");
    private static final ResourceLocation TANK = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/tankknuckles.png");
    private static final ResourceLocation BLUE = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/blueknuckles.png");
    private static final ResourceLocation AKU = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/akuknuckles.png");
    private static final ResourceLocation YUGI = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/yugiknuckles.png");
    private static final ResourceLocation SAIYAN1 = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/saiyanknuckles.png");
    private static final ResourceLocation SAIYAN2 = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/saiyanknuckles2.png");

    private static final ModelKnuckles<EntityKnuckles> knuckles = new ModelKnuckles<EntityKnuckles>();
    private static final ModelKnucklesTank<EntityKnuckles> tankKnuckles = new ModelKnucklesTank<EntityKnuckles>();
    private static final ModelKnucklesAku<EntityKnuckles> akuKnuckles = new ModelKnucklesAku<EntityKnuckles>();
    private static final ModelKnucklesYugi<EntityKnuckles> yugiKnuckles = new ModelKnucklesYugi<EntityKnuckles>();
    private static final ModelKnucklesSaiyan<EntityKnuckles> saiyanKnuckles = new ModelKnucklesSaiyan<EntityKnuckles>();

    public RenderKnuckles(EntityRendererManager EntityRendererManagerIn)
    {
        super(EntityRendererManagerIn, new ModelKnuckles(), 0.4F);
    }

    protected ResourceLocation getEntityTexture(EntityKnuckles entity) {
        switch (entity.getKnucklesType())
        {
            default:
                return REGULAR;
            case 1:
                return TANK;
            case 2:
                return BLUE;
            case 3:
                return AKU;
            case 4:
                return YUGI;
            case 5:
                return SAIYAN1;
            case 6:
                return SAIYAN2;
        }
    }

    @Override
    protected void preRenderCallback(EntityKnuckles entity, float partialTickTime) {
        switch (entity.getKnucklesType())
        {
            default:
                if(this.entityModel != this.knuckles)
                {
                    this.entityModel = this.knuckles;
                }
                if(this.shadowSize != 0.4F)
                {
                    this.shadowSize = 0.4F;
                }
                GlStateManager.scalef(0.65F, 0.65F, 0.65F);

                break;
            case 1:
                if(this.entityModel != this.tankKnuckles)
                {
                    this.entityModel = this.tankKnuckles;
                }
                if(this.shadowSize != 0.8F)
                {
                    this.shadowSize = 0.8F;
                }
                GlStateManager.scalef(0.9F, 0.9F, 0.9F);
                break;
            case 3:
                if(this.entityModel != this.akuKnuckles)
                {
                    this.entityModel = this.akuKnuckles;
                }
                if(this.shadowSize != 0.4F)
                {
                    this.shadowSize = 0.4F;
                }
                GlStateManager.scalef(0.65F, 0.65F, 0.65F);

                break;
            case 4:
                if(this.entityModel != this.yugiKnuckles)
                {
                    this.entityModel = this.yugiKnuckles;
                }
                if(this.shadowSize != 0.4F)
                {
                    this.shadowSize = 0.4F;
                }
                GlStateManager.scalef(0.65F, 0.65F, 0.65F);

                break;
            case 5:
            case 6:
                if(this.entityModel != this.saiyanKnuckles)
                {
                    this.entityModel = this.saiyanKnuckles;
                }
                if(this.shadowSize != 0.4F)
                {
                    this.shadowSize = 0.4F;
                }
                GlStateManager.scalef(0.65F, 0.65F, 0.65F);

                break;
        }

        super.preRenderCallback(entity, partialTickTime);
    }
}
