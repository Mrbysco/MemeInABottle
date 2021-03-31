package com.mrbysco.miab.client.render.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mrbysco.miab.client.models.BongoCatModel;
import com.mrbysco.miab.entity.memes.BongoCatEntity;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3f;

public class NoteBlockLayer<T extends BongoCatEntity, M extends BongoCatModel<T>> extends LayerRenderer<T, M> {
	public NoteBlockLayer(IEntityRenderer<T, M> entityRenderer)
	{
		super(entityRenderer);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entityIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		ItemStack noteStack = new ItemStack(Blocks.NOTE_BLOCK);
		if (!noteStack.isEmpty()) {
			matrixStackIn.push();
			matrixStackIn.translate(0.0F, 0.775F, -0.55F);
			matrixStackIn.scale(0.75F, 0.75F, 0.75F);
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(-10.0F));

			matrixStackIn.scale(0.45F, 0.45F, 0.45F);
			matrixStackIn.translate(0.7F, 0.75F, 1F);
			Minecraft.getInstance().getFirstPersonRenderer().renderItemSide(entityIn, noteStack, ItemCameraTransforms.TransformType.NONE, false, matrixStackIn, bufferIn, packedLightIn);

			matrixStackIn.translate(-1.4F, 0F, 0F);
			Minecraft.getInstance().getFirstPersonRenderer().renderItemSide(entityIn, noteStack, ItemCameraTransforms.TransformType.NONE, false, matrixStackIn, bufferIn, packedLightIn);

			matrixStackIn.pop();
		}
	}
}