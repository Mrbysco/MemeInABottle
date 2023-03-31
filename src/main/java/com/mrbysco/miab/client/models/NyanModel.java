package com.mrbysco.miab.client.models;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.Cat;

public class NyanModel<T extends Cat> extends AgeableListModel<T> {
	private static final int CROUCH_STATE = 0;
	private static final int WALK_STATE = 1;
	private static final int SPRINT_STATE = 2;
	protected static final int SITTING_STATE = 3;
	private static final float XO = 0.0F;
	private static final float YO = 16.0F;
	private static final float ZO = -9.0F;
	private static final float HEAD_WALK_Y = 15.0F;
	private static final float HEAD_WALK_Z = -9.0F;
	private static final float BODY_WALK_Y = 12.0F;
	private static final float BODY_WALK_Z = -10.0F;
	private static final float TAIL_1_WALK_Y = 15.0F;
	private static final float TAIL_1_WALK_Z = 8.0F;
	private static final float TAIL_2_WALK_Y = 20.0F;
	private static final float TAIL_2_WALK_Z = 14.0F;
	protected static final float BACK_LEG_Y = 18.0F;
	protected static final float BACK_LEG_Z = 5.0F;
	protected static final float FRONT_LEG_Y = 14.1F;
	private static final float FRONT_LEG_Z = -5.0F;
	private static final String TAIL_1 = "tail1";
	private static final String TAIL_2 = "tail2";
	protected final ModelPart leftHindLeg;
	protected final ModelPart rightHindLeg;
	protected final ModelPart leftFrontLeg;
	protected final ModelPart rightFrontLeg;
	protected final ModelPart tail1;
	protected final ModelPart tail2;
	protected final ModelPart head;
	protected final ModelPart body;
	protected int state = 1;

	public NyanModel(ModelPart root) {
		super(true, 10.0F, 4.0F);
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.tail1 = root.getChild("tail1");
		this.tail2 = root.getChild("tail2");
		this.leftHindLeg = root.getChild("left_hind_leg");
		this.rightHindLeg = root.getChild("right_hind_leg");
		this.leftFrontLeg = root.getChild("left_front_leg");
		this.rightFrontLeg = root.getChild("right_front_leg");
	}

	public static MeshDefinition createBodyMesh(CubeDeformation deformation) {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().addBox("main", -2.5F, -2.0F, -3.0F, 5.0F, 4.0F, 5.0F, deformation).addBox("nose", -1.5F, -0.001F, -4.0F, 3, 2, 2, deformation, 0, 24).addBox("ear1", -2.0F, -3.0F, 0.0F, 1, 1, 2, deformation, 0, 10).addBox("ear2", 1.0F, -3.0F, 0.0F, 1, 1, 2, deformation, 6, 10), PartPose.offset(0.0F, 15.0F, -9.0F));
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create()
						.texOffs(20, 0)
						.addBox(-2.0F, 3.0F, -8.0F, 4.0F, 16.0F, 9.0F, deformation),
				PartPose.offsetAndRotation(0.0F, 12.0F, -10.0F, ((float) Math.PI / 2F), 0.0F, 0.0F));
		partdefinition.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(0, 15).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F, deformation), PartPose.offsetAndRotation(0.0F, 15.0F, 8.0F, 0.9F, 0.0F, 0.0F));
		partdefinition.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(4, 15).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F, deformation), PartPose.offset(0.0F, 20.0F, 14.0F));
		CubeListBuilder cubelistbuilder = CubeListBuilder.create().texOffs(8, 13).addBox(-1.0F, 0.0F, 1.0F, 2.0F, 6.0F, 2.0F, deformation);
		partdefinition.addOrReplaceChild("left_hind_leg", cubelistbuilder, PartPose.offset(1.1F, 18.0F, 5.0F));
		partdefinition.addOrReplaceChild("right_hind_leg", cubelistbuilder, PartPose.offset(-1.1F, 18.0F, 5.0F));
		CubeListBuilder cubelistbuilder1 = CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 2.0F, deformation);
		partdefinition.addOrReplaceChild("left_front_leg", cubelistbuilder1, PartPose.offset(1.2F, 14.1F, -5.0F));
		partdefinition.addOrReplaceChild("right_front_leg", cubelistbuilder1, PartPose.offset(-1.2F, 14.1F, -5.0F));
		return meshdefinition;
	}

	protected Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.head);
	}

	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.body, this.leftHindLeg, this.rightHindLeg, this.leftFrontLeg, this.rightFrontLeg, this.tail1, this.tail2);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.xRot = headPitch * 0.017453292F;
		this.head.yRot = netHeadYaw * 0.017453292F;

		if (this.state != 3) {
			this.body.xRot = ((float) Math.PI / 2F);
			this.leftHindLeg.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
			this.rightHindLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
			this.leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
			this.rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		}
	}

	@Override
	public void prepareMobModel(T p_103142_, float p_103143_, float p_103144_, float p_103145_) {
		this.body.y = 12.0F;
		this.body.z = -10.0F;
		this.head.y = 15.0F;
		this.head.z = -9.0F;
		this.tail1.y = 15.0F;
		this.tail1.z = 8.0F;
		this.tail2.y = 20.0F;
		this.tail2.z = 14.0F;
		this.leftFrontLeg.y = 14.1F;
		this.leftFrontLeg.z = -5.0F;
		this.rightFrontLeg.y = 14.1F;
		this.rightFrontLeg.z = -5.0F;
		this.leftHindLeg.y = 18.0F;
		this.leftHindLeg.z = 5.0F;
		this.rightHindLeg.y = 18.0F;
		this.rightHindLeg.z = 5.0F;
		this.tail1.xRot = 0.9F;
		this.state = 2;
	}
}