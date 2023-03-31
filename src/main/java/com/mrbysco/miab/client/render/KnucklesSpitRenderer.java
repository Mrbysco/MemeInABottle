package com.mrbysco.miab.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import com.mrbysco.miab.entity.projectile.KnucklesSpitEntity;
import net.minecraft.client.model.LlamaSpitModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class KnucklesSpitRenderer extends EntityRenderer<KnucklesSpitEntity> {
	private static final ResourceLocation SPIT_TEXTURE = new ResourceLocation("textures/entity/llama/spit.png");
	private final LlamaSpitModel<KnucklesSpitEntity> model;

	public KnucklesSpitRenderer(EntityRendererProvider.Context context) {
		super(context);
		this.model = new LlamaSpitModel<>(context.bakeLayer(ModelLayers.LLAMA_SPIT));
	}

	@Override
	public void render(KnucklesSpitEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLightIn) {
		poseStack.pushPose();
		poseStack.translate(0.0D, (double) 0.15F, 0.0D);
		poseStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90.0F));
		poseStack.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		this.model.setupAnim(entityIn, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
		VertexConsumer vertexConsumer = bufferSource.getBuffer(this.model.renderType(SPIT_TEXTURE));
		this.model.renderToBuffer(poseStack, vertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferSource, packedLightIn);
	}

	public ResourceLocation getTextureLocation(KnucklesSpitEntity entity) {
		return SPIT_TEXTURE;
	}
}
