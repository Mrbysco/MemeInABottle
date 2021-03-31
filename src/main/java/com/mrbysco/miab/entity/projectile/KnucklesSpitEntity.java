package com.mrbysco.miab.entity.projectile;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.init.MemeEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.LlamaSpitEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.UUID;

public class KnucklesSpitEntity extends LlamaSpitEntity {
	public AbstractMeme owner;
	private CompoundNBT ownerNbt;

	public KnucklesSpitEntity(EntityType<? extends KnucklesSpitEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	public KnucklesSpitEntity(World worldIn, AbstractMeme entity) {
		super(MemeEntities.KNUCKLES_SPIT.get(), worldIn);
		this.owner = entity;
		this.setPosition(entity.getPosX() - (double)(entity.getWidth() + 1.0F) * 0.5D * (double)MathHelper.sin(entity.renderYawOffset * ((float)Math.PI / 180F)), entity.getPosYEye() - (double)0.1F, entity.getPosZ() + (double)(entity.getWidth() + 1.0F) * 0.5D * (double)MathHelper.cos(entity.renderYawOffset * ((float)Math.PI / 180F)));
	}

	public KnucklesSpitEntity(World worldIn, double x, double y, double z, double p_i47274_8_, double p_i47274_10_, double p_i47274_12_) {
		super(MemeEntities.KNUCKLES_SPIT.get(), worldIn);
		this.setPosition(x, y, z);

		for (int i = 0; i < 7; ++i)
		{
			double d0 = 0.4D + 0.1D * (double)i;
			worldIn.addParticle(ParticleTypes.SPIT, x, y, z, p_i47274_8_ * d0, p_i47274_10_, p_i47274_12_ * d0);
		}

		this.setMotion(p_i47274_8_, p_i47274_10_, p_i47274_12_);
	}

	@Override
	public EntityType<?> getType() {
		return MemeEntities.KNUCKLES_SPIT.get();
	}

	public KnucklesSpitEntity(FMLPlayMessages.SpawnEntity spawnEntity, World worldIn) {
		this(MemeEntities.KNUCKLES_SPIT.get(), worldIn);
	}

	@Override
	public IPacket<?> createSpawnPacket() {
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
	public void setVelocity(double x, double y, double z) {
		this.setMotion(x, y, z);
		if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
			float f = MathHelper.sqrt(x * x + z * z);
			this.rotationPitch = (float)(MathHelper.atan2(y, (double)f) * (double)(180F / (float)Math.PI));
			this.rotationYaw = (float)(MathHelper.atan2(x, z) * (double)(180F / (float)Math.PI));
			this.prevRotationPitch = this.rotationPitch;
			this.prevRotationYaw = this.rotationYaw;
			this.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, this.rotationPitch);
		}
	}

	protected void readAdditional(CompoundNBT compound) {
		if (compound.contains("Owner", 10)) {
			this.ownerNbt = compound.getCompound("Owner");
		}
	}

	protected void writeAdditional(CompoundNBT compound) {
		if (this.owner != null) {
			CompoundNBT compoundnbt = new CompoundNBT();
			UUID uuid = this.owner.getUniqueID();
			compoundnbt.putUniqueId("OwnerUUID", uuid);
			compound.put("Owner", compoundnbt);
		}
	}

	private void restoreOwnerFromSave() {
		if (this.ownerNbt != null && this.ownerNbt.hasUniqueId("OwnerUUID")) {
			UUID uuid = this.ownerNbt.getUniqueId("OwnerUUID");

			for(AbstractMeme meme : this.world.getEntitiesWithinAABB(AbstractMeme.class, this.getBoundingBox().grow(15.0D))) {
				if (meme.getUniqueID().equals(uuid)) {
					this.owner = meme;
					break;
				}
			}
		}

		this.ownerNbt = null;
	}

	protected void registerData() {
	}
}
