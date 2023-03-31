package com.mrbysco.miab.client.models;

import com.mrbysco.miab.entity.memes.GnomeEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class GnomeModel<T extends GnomeEntity> extends HierarchicalModel<T> {
	private final ModelPart root;
	private final ModelPart left_leg;
	private final ModelPart right_leg;

	public GnomeModel(ModelPart part) {
		this.root = part;
		this.left_leg = part.getChild("left_leg");
		this.right_leg = part.getChild("right_leg");
	}

	@Override
	public ModelPart root() {
		return this.root;
	}

	public static LayerDefinition createMesh() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("left_leg",
				CubeListBuilder.create()
						.texOffs(0, 32).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F)
						.texOffs(0, 39).addBox("left_foot", -1.5F, 4.0F, -2.5F, 3.0F, 2.0F, 4.0F),
				PartPose.offset(1.5F, 18.0F, 0.0F));

		partdefinition.addOrReplaceChild("right_leg",
				CubeListBuilder.create()
						.texOffs(14, 32).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F)
						.texOffs(14, 39).addBox("right_foot", -1.5F, 4.0F, -2.5F, 3.0F, 2.0F, 4.0F),
				PartPose.offset(-1.5F, 18.0F, 0.0F));

		partdefinition.addOrReplaceChild("torso",
				CubeListBuilder.create()
						.texOffs(0, 21).addBox(-3.0F, -3.5F, -2.0F, 6.0F, 7.0F, 4.0F),
				PartPose.offset(0.0F, 14.5F, 0.0F));

		partdefinition.addOrReplaceChild("left_arm",
				CubeListBuilder.create()
						.texOffs(28, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F),
				PartPose.offset(4.0F, 11.0F, 0.0F));

		partdefinition.addOrReplaceChild("right_arm",
				CubeListBuilder.create()
						.texOffs(36, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F),
				PartPose.offset(-4.0F, 11.0F, 0.0F));

		PartDefinition headDefinition = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create()
						.texOffs(0, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F)
						.texOffs(0, 8).addBox("beard", -2.5F, 1.0F, -2.5F, 5.0F, 2.0F, 3.0F),
				PartPose.offset(0.0F, 9.0F, 0.0F));

		headDefinition.addOrReplaceChild("left_ear", CubeListBuilder.create()
						.texOffs(0, 13).addBox("main", 0.2F, -0.6F, -2.0F, 2.0F, 2.0F, 1.0F),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.6517F, -0.2143F));
		headDefinition.addOrReplaceChild("right_ear", CubeListBuilder.create()
						.texOffs(6, 13).addBox("main", -2.2F, -0.6F, -2.0F, 2.0F, 2.0F, 1.0F),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6517F, 0.2143F));
		headDefinition.addOrReplaceChild("nose", CubeListBuilder.create()
						.texOffs(0, 16).addBox("main", -0.5F, 0.0F, -3.3F, 1.0F, 1.0F, 2.0F),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0089F));

		headDefinition.addOrReplaceChild("hat",
				CubeListBuilder.create()
						.texOffs(16, 0).addBox(-2.5F, -4.2F, -2.5F, 5.0F, 3.0F, 5.0F),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1607F, 0.0F, 0.0F));
		headDefinition.addOrReplaceChild("hat_2", CubeListBuilder.create()
						.texOffs(36, 0).addBox("main", -2.0F, -2.6F, -1.8F, 4.0F, 2.0F, 4.0F),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2588F, 0.0F, 0.0F));


		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.right_leg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		this.left_leg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;
		this.right_leg.yRot = 0.0F;
		this.left_leg.yRot = 0.0F;
	}
}