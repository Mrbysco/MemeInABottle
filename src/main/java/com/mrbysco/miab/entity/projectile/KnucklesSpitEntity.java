package com.mrbysco.miab.entity.projectile;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.registry.MemeEntities;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.LlamaSpit;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;

import java.util.UUID;

public class KnucklesSpitEntity extends LlamaSpit {
	public AbstractMeme owner;
	private CompoundTag ownerNbt;

	public KnucklesSpitEntity(EntityType<? extends KnucklesSpitEntity> entityType, Level level) {
		super(entityType, level);
	}

	public KnucklesSpitEntity(Level level, AbstractMeme entity) {
		super(MemeEntities.KNUCKLES_SPIT.get(), level);
		this.owner = entity;
		this.setPos(entity.getX() - (double) (entity.getBbWidth() + 1.0F) * 0.5D * (double) Mth.sin(entity.yBodyRot * ((float) Math.PI / 180F)), entity.getEyeY() - (double) 0.1F, entity.getZ() + (double) (entity.getBbWidth() + 1.0F) * 0.5D * (double) Mth.cos(entity.yBodyRot * ((float) Math.PI / 180F)));
	}

	public KnucklesSpitEntity(Level level, double x, double y, double z, double p_i47274_8_, double p_i47274_10_, double p_i47274_12_) {
		super(MemeEntities.KNUCKLES_SPIT.get(), level);
		this.setPos(x, y, z);

		for (int i = 0; i < 7; ++i) {
			double d0 = 0.4D + 0.1D * (double) i;
			level.addParticle(ParticleTypes.SPIT, x, y, z, p_i47274_8_ * d0, p_i47274_10_, p_i47274_12_ * d0);
		}

		this.setDeltaMovement(p_i47274_8_, p_i47274_10_, p_i47274_12_);
	}

	@Override
	public EntityType<?> getType() {
		return MemeEntities.KNUCKLES_SPIT.get();
	}

	public KnucklesSpitEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
		this(MemeEntities.KNUCKLES_SPIT.get(), level);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public void tick() {
		super.tick();

		if (this.ownerNbt != null) {
			this.restoreOwnerFromSave();
		}
	}

	@OnlyIn(Dist.CLIENT)
	public void lerpMotion(double x, double y, double z) {
		this.setDeltaMovement(x, y, z);
		if (this.xRotO == 0.0F && this.yRotO == 0.0F) {
			float f = Mth.sqrt((float) (x * x + z * z));
			this.setXRot((float) (Mth.atan2(y, (double) f) * (double) (180F / (float) Math.PI)));
			this.setYRot((float) (Mth.atan2(x, z) * (double) (180F / (float) Math.PI)));
			this.xRotO = this.getXRot();
			this.yRotO = this.getYRot();
			this.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
		}
	}

	protected void readAdditionalSaveData(CompoundTag compound) {
		if (compound.contains("Owner", 10)) {
			this.ownerNbt = compound.getCompound("Owner");
		}
	}

	protected void addAdditionalSaveData(CompoundTag compound) {
		if (this.owner != null) {
			CompoundTag compoundnbt = new CompoundTag();
			UUID uuid = this.owner.getUUID();
			compoundnbt.putUUID("OwnerUUID", uuid);
			compound.put("Owner", compoundnbt);
		}
	}

	private void restoreOwnerFromSave() {
		if (this.ownerNbt != null && this.ownerNbt.hasUUID("OwnerUUID")) {
			UUID uuid = this.ownerNbt.getUUID("OwnerUUID");

			for (AbstractMeme meme : this.level.getEntitiesOfClass(AbstractMeme.class, this.getBoundingBox().inflate(15.0D))) {
				if (meme.getUUID().equals(uuid)) {
					this.owner = meme;
					break;
				}
			}
		}

		this.ownerNbt = null;
	}

	protected void defineSynchedData() {
	}
}
