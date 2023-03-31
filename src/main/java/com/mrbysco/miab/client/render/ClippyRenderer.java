package com.mrbysco.miab.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.client.models.ClippyModel;
import com.mrbysco.miab.entity.memes.ClippyEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ClippyRenderer extends MobRenderer<ClippyEntity, ClippyModel<ClippyEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/clippy.png");

	public ClippyRenderer(EntityRendererProvider.Context context) {
		super(context, new ClippyModel(context.bakeLayer(ClientHandler.CLIPPY)), 0.5F);
	}

	@Override
	protected void scale(ClippyEntity entitylivingbaseIn, PoseStack poseStack, float partialTickTime) {
		float f = 0.999F;
		poseStack.scale(f, f, f);
		poseStack.translate(0.0D, (double) 0.001F, 0.0D);
		float f1 = (float) 1;
		float f2 = Mth.lerp(partialTickTime, entitylivingbaseIn.prevJumpFactor, entitylivingbaseIn.jumpFactor) / (f1 * 0.5F + 1.0F);
		float f3 = 1.0F / (f2 + 1.0F);
		poseStack.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
	}

	public ResourceLocation getTextureLocation(ClippyEntity entity) {
		return TEXTURE;
	}
}
