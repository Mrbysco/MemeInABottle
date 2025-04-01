package com.mrbysco.miab.client;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.client.models.BongoCatModel;
import com.mrbysco.miab.client.models.ClippyModel;
import com.mrbysco.miab.client.models.DankeyModel;
import com.mrbysco.miab.client.models.DatBoiModel;
import com.mrbysco.miab.client.models.FAModel;
import com.mrbysco.miab.client.models.GnomeModel;
import com.mrbysco.miab.client.models.HotDogModel;
import com.mrbysco.miab.client.models.NigelModel;
import com.mrbysco.miab.client.models.NyanModel;
import com.mrbysco.miab.client.models.PepeModel;
import com.mrbysco.miab.client.models.PinguModel;
import com.mrbysco.miab.client.models.RoflCopterModel;
import com.mrbysco.miab.client.models.SanicModel;
import com.mrbysco.miab.client.models.ShrekModel;
import com.mrbysco.miab.client.models.TomModel;
import com.mrbysco.miab.client.models.knuckles.KnucklesAkuModel;
import com.mrbysco.miab.client.models.knuckles.KnucklesModel;
import com.mrbysco.miab.client.models.knuckles.KnucklesQueenModel;
import com.mrbysco.miab.client.models.knuckles.KnucklesSaiyanModel;
import com.mrbysco.miab.client.models.knuckles.KnucklesTankModel;
import com.mrbysco.miab.client.models.knuckles.KnucklesYugiModel;
import com.mrbysco.miab.client.render.AttachedGirlfriendRenderer;
import com.mrbysco.miab.client.render.BongoCatRenderer;
import com.mrbysco.miab.client.render.CenaRenderer;
import com.mrbysco.miab.client.render.ChocolateGuyRenderer;
import com.mrbysco.miab.client.render.ClippyRenderer;
import com.mrbysco.miab.client.render.DankeyRenderer;
import com.mrbysco.miab.client.render.DatBoiRenderer;
import com.mrbysco.miab.client.render.DogeRenderer;
import com.mrbysco.miab.client.render.FARenderer;
import com.mrbysco.miab.client.render.GnomeRenderer;
import com.mrbysco.miab.client.render.GrandDadRenderer;
import com.mrbysco.miab.client.render.GrumpyRenderer;
import com.mrbysco.miab.client.render.HeManRenderer;
import com.mrbysco.miab.client.render.HotDogRenderer;
import com.mrbysco.miab.client.render.KnucklesQueenRenderer;
import com.mrbysco.miab.client.render.KnucklesRenderer;
import com.mrbysco.miab.client.render.KnucklesSpitRenderer;
import com.mrbysco.miab.client.render.NigelRenderer;
import com.mrbysco.miab.client.render.NyanCatRenderer;
import com.mrbysco.miab.client.render.PPAPRenderer;
import com.mrbysco.miab.client.render.PepeRenderer;
import com.mrbysco.miab.client.render.PhilSwiftRenderer;
import com.mrbysco.miab.client.render.PinguRenderer;
import com.mrbysco.miab.client.render.RoadmanShaqRenderer;
import com.mrbysco.miab.client.render.RobbieRenderer;
import com.mrbysco.miab.client.render.RoflCopterRenderer;
import com.mrbysco.miab.client.render.SanicRenderer;
import com.mrbysco.miab.client.render.SansRenderer;
import com.mrbysco.miab.client.render.ShrekRenderer;
import com.mrbysco.miab.client.render.SkywalkerRenderer;
import com.mrbysco.miab.client.render.TacNyanRenderer;
import com.mrbysco.miab.client.render.TrololoRenderer;
import com.mrbysco.miab.client.render.TrumpRenderer;
import com.mrbysco.miab.registry.MemeEntities;
import com.mrbysco.miab.registry.MemeRegistry;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.LlamaSpitModel;
import net.minecraft.client.model.OcelotModel;
import net.minecraft.client.model.WolfModel;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientHandler {
	public static final ModelLayerLocation JOHN_CENA = new ModelLayerLocation(Reference.modLoc("john_cena"), "main");
	public static final ModelLayerLocation DONALD_TRUMP = new ModelLayerLocation(Reference.modLoc("donald_trump"), "main");
	public static final ModelLayerLocation DOGE = new ModelLayerLocation(Reference.modLoc("doge"), "main");
	public static final ModelLayerLocation GRUMPY_CAT = new ModelLayerLocation(Reference.modLoc("grumpy_cat"), "main");
	public static final ModelLayerLocation ATTACHED_GIRLFRIEND = new ModelLayerLocation(Reference.modLoc("attached_girlfriend"), "main");
	public static final ModelLayerLocation EDUARD_KHIL = new ModelLayerLocation(Reference.modLoc("eduard_khil"), "main");
	public static final ModelLayerLocation PPAP = new ModelLayerLocation(Reference.modLoc("ppap"), "main");
	public static final ModelLayerLocation ROBBIE_ROTTEN = new ModelLayerLocation(Reference.modLoc("robbie_rotten"), "main");
	public static final ModelLayerLocation GRAND_DAD = new ModelLayerLocation(Reference.modLoc("grand_dad"), "main");
	public static final ModelLayerLocation HE_MAN = new ModelLayerLocation(Reference.modLoc("he_man"), "main");
	public static final ModelLayerLocation SKYWALKER = new ModelLayerLocation(Reference.modLoc("skywalker"), "main");
	public static final ModelLayerLocation ROADMAN_SHAQ = new ModelLayerLocation(Reference.modLoc("roadman_shaq"), "main");
	public static final ModelLayerLocation DANKEY_KANG = new ModelLayerLocation(Reference.modLoc("dankey_kang"), "main");
	public static final ModelLayerLocation PHIL_SWIFT = new ModelLayerLocation(Reference.modLoc("phil_swift"), "main");
	public static final ModelLayerLocation SHREK = new ModelLayerLocation(Reference.modLoc("shrek"), "main");
	public static final ModelLayerLocation DAT_BOI = new ModelLayerLocation(Reference.modLoc("dat_boi"), "main");
	public static final ModelLayerLocation SANIC = new ModelLayerLocation(Reference.modLoc("sanic"), "main");
	public static final ModelLayerLocation PEPE = new ModelLayerLocation(Reference.modLoc("pepe"), "main");
	public static final ModelLayerLocation FOREVER_ALONE = new ModelLayerLocation(Reference.modLoc("forever_alone"), "main");
	public static final ModelLayerLocation NYAN_CAT = new ModelLayerLocation(Reference.modLoc("nyan_cat"), "main");
	public static final ModelLayerLocation TAC_NAYN = new ModelLayerLocation(Reference.modLoc("tac_nayn"), "main");
	public static final ModelLayerLocation NIGEL_THORNBERRY = new ModelLayerLocation(Reference.modLoc("nigel_thornberry"), "main");
	public static final ModelLayerLocation DANCING_HOTDOG = new ModelLayerLocation(Reference.modLoc("dancing_hotdog"), "main");
	public static final ModelLayerLocation BONGO_CAT = new ModelLayerLocation(Reference.modLoc("bongo_cat"), "main");
	public static final ModelLayerLocation ROFL_COPTER = new ModelLayerLocation(Reference.modLoc("rofl_copter"), "main");
	public static final ModelLayerLocation GNOME = new ModelLayerLocation(Reference.modLoc("gnome"), "main");
	public static final ModelLayerLocation CLIPPY = new ModelLayerLocation(Reference.modLoc("clippy"), "main");
	public static final ModelLayerLocation SANS = new ModelLayerLocation(Reference.modLoc("sans"), "main");
	public static final ModelLayerLocation PINGU = new ModelLayerLocation(Reference.modLoc("pingu"), "main");
	public static final ModelLayerLocation TOM = new ModelLayerLocation(Reference.modLoc("tom"), "main");
	public static final ModelLayerLocation KNUCKLES = new ModelLayerLocation(Reference.modLoc("knuckles"), "main");
	public static final ModelLayerLocation KNUCKLES_AKU = new ModelLayerLocation(Reference.modLoc("knuckles"), "aku");
	public static final ModelLayerLocation KNUCKLES_SAIYAN = new ModelLayerLocation(Reference.modLoc("knuckles"), "saiyan");
	public static final ModelLayerLocation KNUCKLES_TANK = new ModelLayerLocation(Reference.modLoc("knuckles"), "tank");
	public static final ModelLayerLocation KNUCKLES_YUGI = new ModelLayerLocation(Reference.modLoc("knuckles"), "yugi");
	public static final ModelLayerLocation KNUCKLES_SPIT = new ModelLayerLocation(Reference.modLoc("knuckles_spit"), "main");
	public static final ModelLayerLocation KNUCKLES_QUEEN = new ModelLayerLocation(Reference.modLoc("knuckles_queen"), "main");
	public static final ModelLayerLocation HUMANOID_INNER_ARMOR = new ModelLayerLocation(Reference.modLoc("humanoid"), "inner_armor");
	public static final ModelLayerLocation HUMANOID_OUTER_ARMOR = new ModelLayerLocation(Reference.modLoc("humanoid"), "outer_armor");

	public static void onClientSetup(final FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(MemeRegistry.FIDGET_SPINNER.get(), ResourceLocation.withDefaultNamespace("spinning"), (stack, world, livingEntity, tintIndex) ->
					livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack ? 1.0F : 0.0F);
		});

	}

	public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(MemeEntities.SPLASH_MEME.get(), (context) -> new ThrownItemRenderer<>(context, 0.75F, true));

		event.registerEntityRenderer(MemeEntities.JOHN_CENA.get(), CenaRenderer::new);
		event.registerEntityRenderer(MemeEntities.DONALD_TRUMP.get(), TrumpRenderer::new);
		event.registerEntityRenderer(MemeEntities.DOGE.get(), DogeRenderer::new);
		event.registerEntityRenderer(MemeEntities.GRUMPY_CAT.get(), GrumpyRenderer::new);
		event.registerEntityRenderer(MemeEntities.ATTACHED_GIRLFRIEND.get(), AttachedGirlfriendRenderer::new);
		event.registerEntityRenderer(MemeEntities.EDUARD_KHIL.get(), TrololoRenderer::new);
		event.registerEntityRenderer(MemeEntities.PPAP.get(), PPAPRenderer::new);
		event.registerEntityRenderer(MemeEntities.ROBBIE_ROTTEN.get(), RobbieRenderer::new);
		event.registerEntityRenderer(MemeEntities.GRAND_DAD.get(), GrandDadRenderer::new);
		event.registerEntityRenderer(MemeEntities.HE_MAN.get(), HeManRenderer::new);
		event.registerEntityRenderer(MemeEntities.SKYWALKER.get(), SkywalkerRenderer::new);
		event.registerEntityRenderer(MemeEntities.ROADMAN_SHAQ.get(), RoadmanShaqRenderer::new);
		event.registerEntityRenderer(MemeEntities.DANKEY_KANG.get(), DankeyRenderer::new);
		event.registerEntityRenderer(MemeEntities.PHIL_SWIFT.get(), PhilSwiftRenderer::new);
		event.registerEntityRenderer(MemeEntities.SHREK.get(), ShrekRenderer::new);

		event.registerEntityRenderer(MemeEntities.DAT_BOI.get(), DatBoiRenderer::new);
		event.registerEntityRenderer(MemeEntities.SANIC.get(), SanicRenderer::new);
		event.registerEntityRenderer(MemeEntities.PEPE.get(), PepeRenderer::new);
		event.registerEntityRenderer(MemeEntities.FOREVER_ALONE.get(), FARenderer::new);
		event.registerEntityRenderer(MemeEntities.NYAN_CAT.get(), NyanCatRenderer::new);
		event.registerEntityRenderer(MemeEntities.TAC_NAYN.get(), TacNyanRenderer::new);
		event.registerEntityRenderer(MemeEntities.NIGEL_THORNBERRY.get(), NigelRenderer::new);
		event.registerEntityRenderer(MemeEntities.DANCING_HOTDOG.get(), HotDogRenderer::new);
		event.registerEntityRenderer(MemeEntities.BONGO_CAT.get(), BongoCatRenderer::new);
		event.registerEntityRenderer(MemeEntities.ROFL_COPTER.get(), RoflCopterRenderer::new);
		event.registerEntityRenderer(MemeEntities.GNOME.get(), GnomeRenderer::new);
		event.registerEntityRenderer(MemeEntities.CLIPPY.get(), ClippyRenderer::new);
		event.registerEntityRenderer(MemeEntities.SANS.get(), SansRenderer::new);
		event.registerEntityRenderer(MemeEntities.PINGU.get(), PinguRenderer::new);
		event.registerEntityRenderer(MemeEntities.TOM.get(), ChocolateGuyRenderer::new);

		event.registerEntityRenderer(MemeEntities.KNUCKLES.get(), KnucklesRenderer::new);
		event.registerEntityRenderer(MemeEntities.KNUCKLES_SPIT.get(), KnucklesSpitRenderer::new);
		event.registerEntityRenderer(MemeEntities.KNUCKLES_QUEEN.get(), KnucklesQueenRenderer::new);
	}

	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		LayerDefinition humanoidDefinition = LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F), 64, 64);
		LayerDefinition outerArmorDefinition = LayerDefinition.create(HumanoidModel.createMesh(LayerDefinitions.OUTER_ARMOR_DEFORMATION, 0.0F), 64, 32);
		LayerDefinition innerArmorDefinition = LayerDefinition.create(HumanoidModel.createMesh(LayerDefinitions.INNER_ARMOR_DEFORMATION, 0.0F), 64, 32);

		event.registerLayerDefinition(HUMANOID_INNER_ARMOR, () -> innerArmorDefinition);
		event.registerLayerDefinition(HUMANOID_OUTER_ARMOR, () -> outerArmorDefinition);

		event.registerLayerDefinition(JOHN_CENA, () -> humanoidDefinition);
		event.registerLayerDefinition(DONALD_TRUMP, () -> humanoidDefinition);
		event.registerLayerDefinition(DOGE, () -> LayerDefinition.create(WolfModel.createMeshDefinition(CubeDeformation.NONE), 64, 32));
		event.registerLayerDefinition(GRUMPY_CAT, () -> LayerDefinition.create(OcelotModel.createBodyMesh(CubeDeformation.NONE), 64, 32));
		event.registerLayerDefinition(ATTACHED_GIRLFRIEND, () -> LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F), 64, 64));
		event.registerLayerDefinition(EDUARD_KHIL, () -> humanoidDefinition);
		event.registerLayerDefinition(PPAP, () -> humanoidDefinition);
		event.registerLayerDefinition(ROBBIE_ROTTEN, () -> humanoidDefinition);
		event.registerLayerDefinition(GRAND_DAD, () -> humanoidDefinition);
		event.registerLayerDefinition(HE_MAN, () -> humanoidDefinition);
		event.registerLayerDefinition(SKYWALKER, () -> humanoidDefinition);
		event.registerLayerDefinition(ROADMAN_SHAQ, () -> humanoidDefinition);
		event.registerLayerDefinition(DANKEY_KANG, () -> LayerDefinition.create(DankeyModel.createMesh(CubeDeformation.NONE), 64, 64));
		event.registerLayerDefinition(PHIL_SWIFT, () -> humanoidDefinition);
		event.registerLayerDefinition(SHREK, () -> LayerDefinition.create(ShrekModel.createMesh(CubeDeformation.NONE), 64, 64));
		event.registerLayerDefinition(DAT_BOI, DatBoiModel::createBodyLayer);
		event.registerLayerDefinition(SANIC, SanicModel::createBodyLayer);
		event.registerLayerDefinition(PEPE, () -> LayerDefinition.create(PepeModel.createMesh(CubeDeformation.NONE), 64, 64));
		event.registerLayerDefinition(FOREVER_ALONE, () -> LayerDefinition.create(FAModel.createMesh(CubeDeformation.NONE), 64, 64));
		event.registerLayerDefinition(NYAN_CAT, () -> LayerDefinition.create(NyanModel.createBodyMesh(CubeDeformation.NONE), 64, 32));
		event.registerLayerDefinition(TAC_NAYN, () -> LayerDefinition.create(NyanModel.createBodyMesh(CubeDeformation.NONE), 64, 32));
		event.registerLayerDefinition(NIGEL_THORNBERRY, () -> LayerDefinition.create(NigelModel.createMesh(CubeDeformation.NONE), 64, 64));
		event.registerLayerDefinition(DANCING_HOTDOG, HotDogModel::createBodyLayer);
		event.registerLayerDefinition(BONGO_CAT, BongoCatModel::createBodyLayer);
		event.registerLayerDefinition(ROFL_COPTER, RoflCopterModel::createBodyLayer);
		event.registerLayerDefinition(GNOME, GnomeModel::createMesh);
		event.registerLayerDefinition(CLIPPY, ClippyModel::createBodyLayer);
		event.registerLayerDefinition(SANS, () -> humanoidDefinition);
		event.registerLayerDefinition(PINGU, PinguModel::createBodyLayer);
		event.registerLayerDefinition(TOM, () -> LayerDefinition.create(TomModel.createMesh(CubeDeformation.NONE), 64, 64));
		event.registerLayerDefinition(KNUCKLES, KnucklesModel::createBodyLayer);
		event.registerLayerDefinition(KNUCKLES_AKU, KnucklesAkuModel::createBodyLayer);
		event.registerLayerDefinition(KNUCKLES_SAIYAN, KnucklesSaiyanModel::createBodyLayer);
		event.registerLayerDefinition(KNUCKLES_TANK, KnucklesTankModel::createBodyLayer);
		event.registerLayerDefinition(KNUCKLES_YUGI, KnucklesYugiModel::createBodyLayer);
		event.registerLayerDefinition(KNUCKLES_SPIT, LlamaSpitModel::createBodyLayer);
		event.registerLayerDefinition(KNUCKLES_QUEEN, () -> LayerDefinition.create(KnucklesQueenModel.createMesh(CubeDeformation.NONE), 64, 64));
	}
}