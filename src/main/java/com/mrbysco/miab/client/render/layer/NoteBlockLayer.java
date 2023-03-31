package com.mrbysco.miab.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.mrbysco.miab.client.models.BongoCatModel;
import com.mrbysco.miab.entity.memes.BongoCatEntity;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class NoteBlockLayer<T extends BongoCatEntity, M extends BongoCatModel<T>> extends RenderLayer<T, M> {
	private final ItemInHandRenderer itemInHandRenderer;

	public NoteBlockLayer(RenderLayerParent<T, M> entityRenderer, ItemInHandRenderer itemInHandRenderer) {
		super(entityRenderer);
		this.itemInHandRenderer = itemInHandRenderer;
	}

	@Override
	public void render(PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn, T entityIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		ItemStack noteStack = new ItemStack(Blocks.NOTE_BLOCK);
		if (!noteStack.isEmpty()) {
			poseStack.pushPose();
			poseStack.translate(0.0F, 0.775F, -0.55F);
			poseStack.scale(0.75F, 0.75F, 0.75F);
			poseStack.mulPose(Vector3f.XP.rotationDegrees(-10.0F));

			poseStack.scale(0.45F, 0.45F, 0.45F);
			poseStack.translate(0.7F, 0.75F, 1F);
			itemInHandRenderer.renderItem(entityIn, noteStack, ItemTransforms.TransformType.NONE, false, poseStack, bufferIn, packedLightIn);

			poseStack.translate(-1.4F, 0F, 0F);
			itemInHandRenderer.renderItem(entityIn, noteStack, ItemTransforms.TransformType.NONE, false, poseStack, bufferIn, packedLightIn);

			poseStack.popPose();
		}
	}
}