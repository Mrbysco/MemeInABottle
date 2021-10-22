package com.mrbysco.miab.items;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.mrbysco.miab.init.MemeTab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext.FluidMode;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.world.World;
import net.minecraft.world.spawner.AbstractSpawner;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

public class ItemMemeSpawnEgg extends Item {
    private static final Map<Supplier<EntityType<?>>, ItemMemeSpawnEgg> EGGS = Maps.newIdentityHashMap();
    private final int primaryColor;
    private final int secondaryColor;
    public final Supplier<EntityType<?>> typeIn;

    private static final DefaultDispenseItemBehavior SPAWN_EGG_BEHAVIOR = new DefaultDispenseItemBehavior() {
        public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
            Direction direction = source.getBlockState().get(DispenserBlock.FACING);
            ((ItemMemeSpawnEgg) stack.getItem()).getType(stack.getTag()).spawn(source.getWorld(), stack, null,
                    source.getBlockPos().offset(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
            stack.shrink(1);
            return stack;
        }
    };

    public ItemMemeSpawnEgg(Supplier<EntityType<?>> typeIn, int primaryColorIn, int secondaryColorIn, Item.Properties properties) {
        super(properties.group(MemeTab.MEME_TAB));
        this.typeIn = typeIn;
        this.primaryColor = primaryColorIn;
        this.secondaryColor = secondaryColorIn;
        EGGS.put(typeIn, this);
        DispenserBlock.registerDispenseBehavior(this, SPAWN_EGG_BEHAVIOR);
    }

    public ActionResultType onItemUse(ItemUseContext context) {
        World worldIn = context.getWorld();
        if (worldIn.isRemote) {
            return ActionResultType.SUCCESS;
        } else {
            ItemStack stack = context.getItem();
            BlockPos pos = context.getPos();
            Direction dir = context.getFace();
            BlockState state = worldIn.getBlockState(pos);
            Block block = state.getBlock();
            if (block == Blocks.SPAWNER) {
                TileEntity tile = worldIn.getTileEntity(pos);
                if (tile instanceof MobSpawnerTileEntity) {
                    AbstractSpawner spawner = ((MobSpawnerTileEntity)tile).getSpawnerBaseLogic();
                    EntityType<?> type = this.getType(stack.getTag());
                    spawner.setEntityType(type);
                    tile.markDirty();
                    worldIn.notifyBlockUpdate(pos, state, state, 3);
                    stack.shrink(1);
                    return ActionResultType.SUCCESS;
                }
            }

            BlockPos pos2;
            if (state.getCollisionShape(worldIn, pos).isEmpty()) {
                pos2 = pos;
            } else {
                pos2 = pos.offset(dir);
            }

            EntityType<?> type = this.getType(stack.getTag());
            if (type.spawn(worldIn, stack, context.getPlayer(), pos2, SpawnReason.SPAWN_EGG, true, !Objects.equals(pos, pos2) && dir == Direction.UP) != null) {
                stack.shrink(1);
            }

            return ActionResultType.SUCCESS;
        }
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity player, Hand handIn) {
        ItemStack stack = player.getHeldItem(handIn);
        RayTraceResult traceResult = rayTrace(worldIn, player, FluidMode.SOURCE_ONLY);
        if (traceResult.getType() != Type.BLOCK) {
            return ActionResult.newResult(ActionResultType.PASS, stack);
        } else if (worldIn.isRemote) {
            return ActionResult.newResult(ActionResultType.SUCCESS, stack);
        } else {
            BlockRayTraceResult blockRayTraceResult = (BlockRayTraceResult)traceResult;
            BlockPos pos = blockRayTraceResult.getPos();
            if (!(worldIn.getBlockState(pos).getBlock() instanceof FlowingFluidBlock)) {
                return ActionResult.newResult(ActionResultType.PASS, stack);
            } else if (worldIn.isBlockModifiable(player, pos) && player.canPlayerEdit(pos, blockRayTraceResult.getFace(), stack)) {
                EntityType<?> type = this.getType(stack.getTag());
                if (type.spawn(worldIn, stack, player, pos, SpawnReason.SPAWN_EGG, false, false) == null) {
                    return ActionResult.newResult(ActionResultType.PASS, stack);
                } else {
                    if (!player.abilities.isCreativeMode) {
                        stack.shrink(1);
                    }

                    player.addStat(Stats.ITEM_USED.get(this));
                    return ActionResult.newResult(ActionResultType.SUCCESS, stack);
                }
            } else {
                return ActionResult.newResult(ActionResultType.FAIL, stack);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public int getColor(int p_195983_1_) {
        return p_195983_1_ == 0 ? this.primaryColor : this.secondaryColor;
    }

    public static Iterable<ItemMemeSpawnEgg> getEggs() {
        return Iterables.unmodifiableIterable(EGGS.values());
    }

    public EntityType<?> getType(@Nullable CompoundNBT compound) {
        if (compound != null && compound.contains("EntityTag", 10)) {
            CompoundNBT lvt_2_1_ = compound.getCompound("EntityTag");
            if (lvt_2_1_.contains("id", 8)) {
                return (EntityType)EntityType.byKey(lvt_2_1_.getString("id")).orElse(this.typeIn.get());
            }
        }

        return this.typeIn.get();
    }
}
