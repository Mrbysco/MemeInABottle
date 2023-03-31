package com.mrbysco.miab.datagen.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.mrbysco.miab.registry.MemeEntities;
import com.mrbysco.miab.registry.MemeLootTables;
import com.mrbysco.miab.registry.MemeRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.EntityLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MemeLootProvider extends LootTableProvider {
	public MemeLootProvider(DataGenerator gen) {
		super(gen);
	}

	@Override
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
		return ImmutableList.of(
				Pair.of(MemeBlockLoot::new, LootContextParamSets.BLOCK),
				Pair.of(MemeEntityLoot::new, LootContextParamSets.ENTITY)
		);
	}

	private static class MemeBlockLoot extends BlockLoot {

		@Override
		protected void addTables() {
			for (RegistryObject<Block> block : MemeRegistry.BLOCKS.getEntries()) {
				dropSelf(block.get());
			}
		}

		@Override
		protected Iterable<Block> getKnownBlocks() {
			return (Iterable<Block>) MemeRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
		}
	}

	private static class MemeEntityLoot extends EntityLoot {
		@Override
		protected void addTables() {
			this.add(MemeLootTables.MEME_BASE, LootTable.lootTable()
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
		protected Iterable<EntityType<?>> getKnownEntities() {
			Stream<EntityType<?>> entities = MemeEntities.ENTITIES.getEntries().stream().map(RegistryObject::get);
			return (Iterable<EntityType<?>>) entities::iterator;
		}
	}

	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, @Nonnull ValidationContext context) {
		List<ResourceLocation> ignored = List.of(
				MemeLootTables.MEME_BASE
		);
		map.forEach((name, table) -> {
			if (!ignored.contains(name)) {
				LootTables.validate(context, name, table);
			}
		});
	}
}
