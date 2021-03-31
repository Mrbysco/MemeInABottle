package com.mrbysco.miab.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.knuckles.KnucklesAkuModel;
import com.mrbysco.miab.client.models.knuckles.KnucklesModel;
import com.mrbysco.miab.client.models.knuckles.KnucklesSaiyanModel;
import com.mrbysco.miab.client.models.knuckles.KnucklesTankModel;
import com.mrbysco.miab.client.models.knuckles.KnucklesYugiModel;
import com.mrbysco.miab.entity.memes.KnucklesEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class KnucklesRenderer extends MobRenderer<KnucklesEntity, EntityModel<KnucklesEntity>> {
    private static final ResourceLocation REGULAR = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/knuckles.png");
    private static final ResourceLocation TANK = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/tankknuckles.png");
    private static final ResourceLocation BLUE = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/blueknuckles.png");
    private static final ResourceLocation AKU = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/akuknuckles.png");
    private static final ResourceLocation YUGI = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/yugiknuckles.png");
    private static final ResourceLocation SAIYAN1 = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/saiyanknuckles.png");
    private static final ResourceLocation SAIYAN2 = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/saiyanknuckles2.png");

    private static final KnucklesModel<KnucklesEntity> knuckles = new KnucklesModel<>();
    private static final KnucklesTankModel<KnucklesEntity> tankKnuckles = new KnucklesTankModel<>();
    private static final KnucklesAkuModel<KnucklesEntity> akuKnuckles = new KnucklesAkuModel<>();
    private static final KnucklesYugiModel<KnucklesEntity> yugiKnuckles = new KnucklesYugiModel<>();
    private static final KnucklesSaiyanModel<KnucklesEntity> saiyanKnuckles = new KnucklesSaiyanModel<>();

    public KnucklesRenderer(EntityRendererManager EntityRendererManagerIn) {
        super(EntityRendererManagerIn, new KnucklesModel(), 0.4F);
    }

    @Override
    protected void preRenderCallback(KnucklesEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        switch (entitylivingbaseIn.getKnucklesType()) {
            default:
                if(this.entityModel != knuckles) {
                    this.entityModel = knuckles;
                }
                if(this.shadowSize != 0.4F) {
                    this.shadowSize = 0.4F;
                }
                matrixStackIn.scale(0.65F, 0.65F, 0.65F);

                break;
            case 1:
                if(this.entityModel != tankKnuckles) {
                    this.entityModel = tankKnuckles;
                }
                if(this.shadowSize != 0.8F) {
                    this.shadowSize = 0.8F;
                }
                matrixStackIn.scale(0.9F, 0.9F, 0.9F);
                break;
            case 3:
                if(this.entityModel != akuKnuckles) {
                    this.entityModel = akuKnuckles;
                }
                if(this.shadowSize != 0.4F) {
                    this.shadowSize = 0.4F;
                }
                matrixStackIn.scale(0.65F, 0.65F, 0.65F);

                break;
            case 4:
                if(this.entityModel != yugiKnuckles) {
                    this.entityModel = yugiKnuckles;
                }
                if(this.shadowSize != 0.4F) {
                    this.shadowSize = 0.4F;
                }
                matrixStackIn.scale(0.65F, 0.65F, 0.65F);

                break;
            case 5:
            case 6:
                if(this.entityModel != saiyanKnuckles) {
                    this.entityModel = saiyanKnuckles;
                }
                if(this.shadowSize != 0.4F) {
                    this.shadowSize = 0.4F;
                }
                matrixStackIn.scale(0.65F, 0.65F, 0.65F);

                break;
        }
    }

    public ResourceLocation getEntityTexture(KnucklesEntity entity) {
        switch (entity.getKnucklesType()) {
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
}
