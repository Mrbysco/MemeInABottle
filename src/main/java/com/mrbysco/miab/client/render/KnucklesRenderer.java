package com.mrbysco.miab.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.knuckles.KnucklesAkuModel;
import com.mrbysco.miab.client.models.knuckles.KnucklesModel;
import com.mrbysco.miab.client.models.knuckles.KnucklesSaiyanModel;
import com.mrbysco.miab.client.models.knuckles.KnucklesTankModel;
import com.mrbysco.miab.client.models.knuckles.KnucklesYugiModel;
import com.mrbysco.miab.entity.memes.KnucklesEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class KnucklesRenderer extends MobRenderer<KnucklesEntity, EntityModel<KnucklesEntity>> {
	private static final ResourceLocation REGULAR = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/knuckles.png");
	private static final ResourceLocation TANK = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/tankknuckles.png");
	private static final ResourceLocation BLUE = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/blueknuckles.png");
	private static final ResourceLocation AKU = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/akuknuckles.png");
	private static final ResourceLocation YUGI = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/yugiknuckles.png");
	private static final ResourceLocation SAIYAN1 = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/saiyanknuckles.png");
	private static final ResourceLocation SAIYAN2 = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/saiyanknuckles2.png");

	private final KnucklesModel<KnucklesEntity> knuckles;
	private final KnucklesTankModel<KnucklesEntity> tankKnuckles;
	private final KnucklesAkuModel<KnucklesEntity> akuKnuckles;
	private final KnucklesYugiModel<KnucklesEntity> yugiKnuckles;
	private final KnucklesSaiyanModel<KnucklesEntity> saiyanKnuckles;

	public KnucklesRenderer(EntityRendererProvider.Context context) {
		super(context, new KnucklesModel<>(context.bakeLayer(ClientHandler.KNUCKLES)), 0.4F);
		this.knuckles = new KnucklesModel<>(context.bakeLayer(ClientHandler.KNUCKLES));
		this.tankKnuckles = new KnucklesTankModel<>(context.bakeLayer(ClientHandler.KNUCKLES_TANK));
		this.akuKnuckles = new KnucklesAkuModel<>(context.bakeLayer(ClientHandler.KNUCKLES_AKU));
		this.yugiKnuckles = new KnucklesYugiModel<>(context.bakeLayer(ClientHandler.KNUCKLES_YUGI));
		this.saiyanKnuckles = new KnucklesSaiyanModel<>(context.bakeLayer(ClientHandler.KNUCKLES_SAIYAN));
	}

	@Override
	protected void scale(KnucklesEntity entitylivingbaseIn, PoseStack poseStack, float partialTickTime) {
		switch (entitylivingbaseIn.getKnucklesType()) {
			default -> {
				this.model = knuckles;
				this.shadowRadius = 0.4F;
				poseStack.scale(0.65F, 0.65F, 0.65F);
			}
			case 1 -> {
				this.model = tankKnuckles;
				this.shadowRadius = 0.8F;
				poseStack.scale(0.9F, 0.9F, 0.9F);
			}
			case 3 -> {
				this.model = akuKnuckles;
				this.shadowRadius = 0.4F;
				poseStack.scale(0.65F, 0.65F, 0.65F);
			}
			case 4 -> {
				this.model = yugiKnuckles;
				this.shadowRadius = 0.4F;
				poseStack.scale(0.65F, 0.65F, 0.65F);
			}
			case 5, 6 -> {
				this.model = saiyanKnuckles;
				this.shadowRadius = 0.4F;
				poseStack.scale(0.65F, 0.65F, 0.65F);
			}
		}
	}

	public ResourceLocation getTextureLocation(KnucklesEntity entity) {
		return switch (entity.getKnucklesType()) {
			default -> REGULAR;
			case 1 -> TANK;
			case 2 -> BLUE;
			case 3 -> AKU;
			case 4 -> YUGI;
			case 5 -> SAIYAN1;
			case 6 -> SAIYAN2;
		};
	}
}
