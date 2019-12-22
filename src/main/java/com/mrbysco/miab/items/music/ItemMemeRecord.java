package com.mrbysco.miab.items.music;

import com.google.common.collect.Maps;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.init.MemeTab;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Map;

public class ItemMemeRecord extends MusicDiscItem
{
	private static final Map<SoundEvent, ItemMemeRecord> RECORDS = Maps.<SoundEvent, ItemMemeRecord>newHashMap();
	private final String displayName;
	private final SoundEvent sound;

	public ItemMemeRecord(int comparatorValue, SoundEvent soundIn, Properties builder)
	{
		super(comparatorValue, soundIn, builder.maxDamage(1).group(MemeTab.MEME_TAB));
		this.displayName = "item." + Reference.MOD_PREFIX + "record." + this.getRegistryName().getPath() + ".desc";
		this.sound = soundIn;
		RECORDS.put(this.sound, this);
	}

	public ActionResultType onItemUse(ItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		BlockState state = worldIn.getBlockState(pos);
		if (state.getBlock() == Blocks.JUKEBOX && !(Boolean)state.get(JukeboxBlock.HAS_RECORD)) {
			ItemStack stack = context.getItem();
			if (!worldIn.isRemote) {
				((JukeboxBlock)Blocks.JUKEBOX).insertRecord(worldIn, pos, state, stack);
				worldIn.playEvent((PlayerEntity)null, 1010, pos, Item.getIdFromItem(this));
				stack.shrink(1);
				PlayerEntity playerIn = context.getPlayer();
				if (playerIn != null) {
					playerIn.addStat(Stats.PLAY_RECORD);
				}
			}

			return ActionResultType.SUCCESS;
		} else {
			return ActionResultType.PASS;
		}
	}

	@Nullable
	public static ItemMemeRecord getBySound(SoundEvent soundIn)
	{
		return RECORDS.get(soundIn);
	}

	@Override
	public SoundEvent getSound()
	{
		return this.sound;
	}
}