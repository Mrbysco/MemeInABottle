package com.mrbysco.miab.entity.projectile;

import com.mrbysco.miab.memes.FunnyRegistry;
import com.mrbysco.miab.registry.MemeEntities;
import com.mrbysco.miab.registry.MemeRegistry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;

@OnlyIn(
		value = Dist.CLIENT,
		_interface = ItemSupplier.class
)
public class SplashMemeEntity extends ThrowableItemProjectile implements ItemSupplier {
	@Override
	protected Item getDefaultItem() {
		return MemeRegistry.SPLASH_MEME_IN_A_BOTTLE.get();
	}

	public SplashMemeEntity(EntityType<? extends SplashMemeEntity> entityType, Level level) {
		super(entityType, level);
	}

	public SplashMemeEntity(Level level, LivingEntity throwerIn) {
		super(MemeEntities.SPLASH_MEME.get(), throwerIn, level);
	}

	public SplashMemeEntity(Level level, double x, double y, double z) {
		super(MemeEntities.SPLASH_MEME.get(), x, y, z, level);
	}

	public SplashMemeEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
		this(MemeEntities.SPLASH_MEME.get(), level);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public void handleEntityEvent(byte id) {
		if (id == 3) {
			for (int i = 0; i < 8; ++i) {
				this.level.addParticle(ParticleTypes.NOTE, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@Override
	protected float getGravity() {
		return 0.05F;
	}

	/**
	 * Called when this splash meme hits a block or entity.
	 */
	@Override
	protected void onHit(HitResult result) {
		if (!this.level.isClientSide) {
			if (this.isLingering()) {
				if (!level.isClientSide) {
					this.makeAreaOfEffectCloud();
				}
			}

			FunnyRegistry.instance().triggerRandomMeme(level, this.blockPosition(), level.getNearestPlayer(this, 100.0));

			this.discard();
		}
	}

	private void makeAreaOfEffectCloud() {
		AreaEffectCloud entityareaeffectcloud = new AreaEffectCloud(this.level, this.getX(), this.getY(), this.getZ());
		Entity entity = this.getOwner();
		if (entity instanceof LivingEntity) {
			entityareaeffectcloud.setOwner((LivingEntity) entity);
		}
		entityareaeffectcloud.setRadius(3.0F);
		entityareaeffectcloud.setRadiusOnUse(-0.5F);
		entityareaeffectcloud.setWaitTime(10);
		entityareaeffectcloud.setRadiusPerTick(-entityareaeffectcloud.getRadius() / (float) entityareaeffectcloud.getDuration());
		entityareaeffectcloud.setFixedColor(13882323);
		entityareaeffectcloud.setCustomName(Component.literal("dankcloud"));

		this.level.addFreshEntity(entityareaeffectcloud);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
	}

	private boolean isLingering() {
		return this.getItem().getItem() == MemeRegistry.LINGERING_MEME_IN_A_BOTTLE.get();
	}
}
