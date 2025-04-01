package com.mrbysco.miab.datagen.data;

import com.mrbysco.miab.registry.MemeEntities;
import com.mrbysco.miab.registry.MemeLootTables;
import com.mrbysco.miab.registry.MemeRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.WritableRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.ProblemReporter.Collector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithEnchantedBonusCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class MemeLootProvider extends LootTableProvider {
	public MemeLootProvider(PackOutput packOutput, CompletableFuture<Provider> lookupProvider) {
		super(packOutput, Set.of(), List.of(
				new SubProviderEntry(MemeBlockLoot::new, LootContextParamSets.BLOCK),
				new SubProviderEntry(MemeEntityLoot::new, LootContextParamSets.ENTITY)
		), lookupProvider);
	}

	private static class MemeBlockLoot extends BlockLootSubProvider {
		public MemeBlockLoot(HolderLookup.Provider registries) {
			super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
		}

		@Override
		protected void generate() {
			for (DeferredHolder<Block, ? extends Block> block : MemeRegistry.BLOCKS.getEntries()) {
				dropSelf(block.get());
			}
		}

		@Override
		protected Iterable<Block> getKnownBlocks() {
			return (Iterable<Block>) MemeRegistry.BLOCKS.getEntries().stream().map(holder -> (Block) holder.get())::iterator;
		}
	}

	private static class MemeEntityLoot extends EntityLootSubProvider {
		protected MemeEntityLoot(HolderLookup.Provider registries) {
			super(FeatureFlags.REGISTRY.allFlags(), registries);
		}

		@Override
		public void generate(BiConsumer<ResourceKey<LootTable>, Builder> output) {
			output.accept(MemeLootTables.MEME_BASE, LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("bottles")
							.when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.11F, 0.02F))
							.add(LootItem.lootTableItem(MemeRegistry.MEME_IN_A_BOTTLE.get()))
							.add(LootItem.lootTableItem(MemeRegistry.SPLASH_MEME_IN_A_BOTTLE.get()))
							.add(LootItem.lootTableItem(MemeRegistry.LINGERING_MEME_IN_A_BOTTLE.get()))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("default")

							.when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.11F, 0.02F))
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
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.ATTACHED_GIRLFRIEND.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.BONGO_CAT.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.add(LootItem.lootTableItem(Items.NOTE_BLOCK)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
									.apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F)))
							)
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.JOHN_CENA.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.1F, 0.01F))
							.add(LootItem.lootTableItem(MemeRegistry.WRESTLING_BELT.get()))
					)
			);
			this.add(MemeEntities.CLIPPY.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.add(LootItem.lootTableItem(MemeRegistry.CLIPPY.get()))
					)
			);
			this.add(MemeEntities.DANCING_HOTDOG.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.DANKEY_KANG.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.DAT_BOI.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)

					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")

                        .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.11F, 0.02F))
							.add(LootItem.lootTableItem(Items.SLIME_BALL))
					)
			);
			this.add(MemeEntities.DOGE.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.DONALD_TRUMP.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.EDUARD_KHIL.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.1F, 0.01F))
							.add(LootItem.lootTableItem(MemeRegistry.TROLL_MASK.get()))
					)
			);
			this.add(MemeEntities.FOREVER_ALONE.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.GNOME.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.1F, 0.01F))
							.add(LootItem.lootTableItem(MemeRegistry.GNOME_HAT.get()))
					)
			);
			this.add(MemeEntities.GRAND_DAD.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.1F, 0.01F))
							.add(LootItem.lootTableItem(MemeRegistry.RIPOFF_HAT.get()))
					)
			);
			this.add(MemeEntities.GRUMPY_CAT.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.HE_MAN.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.KNUCKLES.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.KNUCKLES_QUEEN.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.NIGEL_THORNBERRY.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.NYAN_CAT.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.add(LootItem.lootTableItem(MemeRegistry.POPTART.get())
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
									.apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.TAC_NAYN.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.add(LootItem.lootTableItem(MemeRegistry.WAFFLE.get())
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
									.apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F)))))
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.PEPE.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.PHIL_SWIFT.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.1F, 0.01F))
							.add(LootItem.lootTableItem(MemeRegistry.FLEX_TAPE.get()))
					)
			);
			this.add(MemeEntities.PINGU.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.PPAP.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.add(LootItem.lootTableItem(MemeRegistry.PEN.get()))
							.add(LootItem.lootTableItem(MemeRegistry.APPLE.get()))
							.add(LootItem.lootTableItem(MemeRegistry.PINEAPPLE.get()))
					)
			);
			this.add(MemeEntities.ROADMAN_SHAQ.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.ROBBIE_ROTTEN.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.1F, 0.01F))
							.add(LootItem.lootTableItem(MemeRegistry.SAX.get()))
					)
			);
			this.add(MemeEntities.ROFL_COPTER.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.add(LootItem.lootTableItem(MemeRegistry.ROFLCOPTER.get()))
					)
			);
			this.add(MemeEntities.SANIC.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.SANS.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.add(LootItem.lootTableItem(Items.BONE)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
									.apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F)))
							)
					)
			);
			this.add(MemeEntities.SHREK.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.add(LootItem.lootTableItem(MemeRegistry.ONION.get()))
					)
			);
			this.add(MemeEntities.SKYWALKER.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.add(LootItem.lootTableItem(Items.SAND)
									.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
									.apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F)))
							)
					)
			);
			this.add(MemeEntities.TOM.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
			);
			this.add(MemeEntities.TOM.get(), LootTable.lootTable()
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(NestedLootTable.lootTableReference(MemeLootTables.MEME_BASE))
					)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).name("main")
							.add(LootItem.lootTableItem(MemeRegistry.TRUMP_HAIR.get()))
					)
			);
		}

		@Override
		protected Stream<EntityType<?>> getKnownEntityTypes() {
			return MemeEntities.ENTITIES.getEntries().stream().map(DeferredHolder::get);
		}
	}

	@Override
	protected void validate(WritableRegistry<LootTable> writableregistry, ValidationContext validationcontext, Collector problemreporter$collector) {
		super.validate(writableregistry, validationcontext, problemreporter$collector);
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
