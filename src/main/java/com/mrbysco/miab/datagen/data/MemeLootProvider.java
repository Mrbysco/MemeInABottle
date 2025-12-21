package com.mrbysco.miab.datagen.data;

import com.mrbysco.miab.registry.MemeEntities;
import com.mrbysco.miab.registry.MemeLootTables;
import com.mrbysco.miab.registry.MemeRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class MemeLootProvider extends LootTableProvider {
	public MemeLootProvider(PackOutput packOutput) {
		super(packOutput, Set.of(), List.of(
				new SubProviderEntry(MemeBlockLoot::new, LootContextParamSets.BLOCK),
				new SubProviderEntry(MemeEntityLoot::new, LootContextParamSets.ENTITY)
		));
	}

	private static class MemeBlockLoot extends BlockLootSubProvider {
		public MemeBlockLoot() {
			super(Set.of(), FeatureFlags.REGISTRY.allFlags());
		}

		@Override
		protected void generate() {
			for (RegistryObject<Block> block : MemeRegistry.BLOCKS.getEntries()) {
				dropSelf(block.get());
			}
		}

		@Override
		protected Iterable<Block> getKnownBlocks() {
			return (Iterable<Block>) MemeRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
		}
	}

	private static class MemeEntityLoot extends EntityLootSubProvider {
		protected MemeEntityLoot() {
			super(FeatureFlags.REGISTRY.allFlags());
		}

		@Override
		public void generate(BiConsumer<ResourceLocation, LootTable.Builder> output) {
			output.accept(MemeLootTables.MEME_BASE, LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("bottles")
							.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.01F, 0.01F))
							.add(LootItem.lootTableItem(MemeRegistry.MEME_IN_A_BOTTLE.get()))
							.add(LootItem.lootTableItem(MemeRegistry.SPLASH_MEME_IN_A_BOTTLE.get()))
							.add(LootItem.lootTableItem(MemeRegistry.LINGERING_MEME_IN_A_BOTTLE.get()))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("default")
							.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.001F, 0.01F))
							.when(LootItemKilledByPlayerCondition.killedByPlayer())
							.add(LootItem.lootTableItem(MemeRegistry.MEME_RECORD1.get()))
							.add(LootItem.lootTableItem(MemeRegistry.MEME_RECORD2.get()))
					)
			);
			super.generate(output);
		}

		@Override
		public void generate() {


			this.add(MemeEntities.SKYWALKER.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.ATTACHED_GIRLFRIEND.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.BONGO_CAT.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.add(LootItem.lootTableItem(Items.NOTE_BLOCK)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.JOHN_CENA.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.1F, 0.01F))
							.add(LootItem.lootTableItem(MemeRegistry.WRESTLING_BELT.get()))
					)
			);
			this.add(MemeEntities.CLIPPY.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.add(LootItem.lootTableItem(MemeRegistry.CLIPPY.get()))
					)
			);
			this.add(MemeEntities.DANCING_HOTDOG.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.DANKEY_KANG.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.DAT_BOI.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)

					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.001F, 0.01F))
							.add(LootItem.lootTableItem(Items.SLIME_BALL))
					)
			);
			this.add(MemeEntities.DOGE.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.DONALD_TRUMP.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.EDUARD_KHIL.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.1F, 0.01F))
							.add(LootItem.lootTableItem(MemeRegistry.TROLL_MASK.get()))
					)
			);
			this.add(MemeEntities.FOREVER_ALONE.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.GNOME.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.1F, 0.01F))
							.add(LootItem.lootTableItem(MemeRegistry.GNOME_HAT.get()))
					)
			);
			this.add(MemeEntities.GRAND_DAD.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.1F, 0.01F))
							.add(LootItem.lootTableItem(MemeRegistry.RIPOFF_HAT.get()))
					)
			);
			this.add(MemeEntities.GRUMPY_CAT.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.HE_MAN.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.KNUCKLES.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.KNUCKLES_QUEEN.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
//			this.add(MemeEntities.MOON_MAN.get(), LootTable.lootTable()
//					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
//							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
//					)
//					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
//							.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.1F, 0.01F))
//							.add(LootItem.lootTableItem(MemeRegistry.BURGER.get()))
//					)
//			);
			this.add(MemeEntities.NIGEL_THORNBERRY.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.NYAN_CAT.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.add(LootItem.lootTableItem(MemeRegistry.POPTART.get())
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.TAC_NAYN.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.add(LootItem.lootTableItem(MemeRegistry.WAFFLE.get())
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.PEPE.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.PHIL_SWIFT.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.1F, 0.01F))
							.add(LootItem.lootTableItem(MemeRegistry.FLEX_TAPE.get()))
					)
			);
			this.add(MemeEntities.PINGU.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.PPAP.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.add(LootItem.lootTableItem(MemeRegistry.PEN.get()))
							.add(LootItem.lootTableItem(MemeRegistry.APPLE.get()))
							.add(LootItem.lootTableItem(MemeRegistry.PINEAPPLE.get()))
					)
			);
			this.add(MemeEntities.ROADMAN_SHAQ.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.ROBBIE_ROTTEN.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.1F, 0.01F))
							.add(LootItem.lootTableItem(MemeRegistry.SAX.get()))
					)
			);
			this.add(MemeEntities.ROFL_COPTER.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.add(LootItem.lootTableItem(MemeRegistry.ROFLCOPTER.get()))
					)
			);
			this.add(MemeEntities.SANIC.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.SANS.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.add(LootItem.lootTableItem(Items.BONE)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))
					)
			);
			this.add(MemeEntities.SHREK.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.add(LootItem.lootTableItem(MemeRegistry.ONION.get()))
					)
			);
			this.add(MemeEntities.SKYWALKER.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.add(LootItem.lootTableItem(Items.SAND)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
									.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))
					)
			);
			this.add(MemeEntities.TOM.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.TOM.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(LootTableReference.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.add(LootItem.lootTableItem(MemeRegistry.TRUMP_HAIR.get()))
					)
			);
		}

		@Override
		protected Stream<EntityType<?>> getKnownEntityTypes() {
			return MemeEntities.ENTITIES.getEntries().stream().map(RegistryObject::get);
		}
	}

	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationcontext) {
		super.validate(map, validationcontext);
	}

	//	@Override
//	protected void validate(Map<ResourceLocation, LootTable> map, @Nonnull ValidationContext context) {
//		List<ResourceLocation> ignored = List.of(
//				MemeLootTables.MEME_BASE
//		);
//		map.forEach((name, table) -> {
//			if (!ignored.contains(name)) {
//				LootTables.validate(context, name, table);
//			}
//		});
//	}
}
