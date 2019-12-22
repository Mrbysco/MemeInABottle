package com.mrbysco.miab.entity.projectile;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.init.MemeEntities;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;

import java.util.UUID;

public class EntityKnucklesSpit extends Entity implements IProjectile {
	public AbstractMeme owner;
	private CompoundNBT ownerNbt;

	public EntityKnucklesSpit(EntityType<? extends EntityKnucklesSpit> entityType, World worldIn)
	{
		super(entityType, worldIn);
	}

	public EntityKnucklesSpit(World worldIn, AbstractMeme entity)
	{
		super(MemeEntities.KNUCKLES_SPIT, worldIn);
		this.owner = entity;
		this.setPosition(entity.posX - (double)(entity.getWidth() + 1.0F) * 0.5D * (double)MathHelper.sin(entity.renderYawOffset * ((float)Math.PI / 180F)), entity.posY + (double)entity.getEyeHeight() - (double)0.1F, entity.posZ + (double)(entity.getWidth() + 1.0F) * 0.5D * (double)MathHelper.cos(entity.renderYawOffset * ((float)Math.PI / 180F)));
	}

	public EntityKnucklesSpit(World worldIn, double x, double y, double z, double p_i47274_8_, double p_i47274_10_, double p_i47274_12_)
	{
		super(MemeEntities.KNUCKLES_SPIT, worldIn);
		this.setPosition(x, y, z);

		for (int i = 0; i < 7; ++i)
		{
			double d0 = 0.4D + 0.1D * (double)i;
			worldIn.addParticle(ParticleTypes.SPIT, x, y, z, p_i47274_8_ * d0, p_i47274_10_, p_i47274_12_ * d0);
		}

		this.setMotion(p_i47274_8_, p_i47274_10_, p_i47274_12_);
	}

	public EntityKnucklesSpit(FMLPlayMessages.SpawnEntity spawnEntity, World worldIn) {
		this(MemeEntities.KNUCKLES_SPIT, worldIn);
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return new SSpawnObjectPacket(this);
	}


	public void tick() {
		super.tick();
		if (this.ownerNbt != null) {
			this.restoreOwnerFromSave();
		}

		Vec3d vec3d = this.getMotion();
		RayTraceResult raytraceresult = ProjectileHelper.rayTrace(this, this.getBoundingBox().expand(vec3d).grow(1.0D), (p_213879_1_) -> {
			return !p_213879_1_.isSpectator() && p_213879_1_ != this.owner;
		}, RayTraceContext.BlockMode.OUTLINE, true);
		if (raytraceresult != null && raytraceresult.getType() != RayTraceResult.Type.MISS && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
			this.onHit(raytraceresult);
		}

		this.posX += vec3d.x;
		this.posY += vec3d.y;
		this.posZ += vec3d.z;
		float f = MathHelper.sqrt(horizontalMag(vec3d));
		this.rotationYaw = (float)(MathHelper.atan2(vec3d.x, vec3d.z) * (double)(180F / (float)Math.PI));

		for(this.rotationPitch = (float)(MathHelper.atan2(vec3d.y, (double)f) * (double)(180F / (float)Math.PI)); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F) {
			;
		}

		while(this.rotationPitch - this.prevRotationPitch >= 180.0F) {
			this.prevRotationPitch += 360.0F;
		}

		while(this.rotationYaw - this.prevRotationYaw < -180.0F) {
			this.prevRotationYaw -= 360.0F;
		}

		while(this.rotationYaw - this.prevRotationYaw >= 180.0F) {
			this.prevRotationYaw += 360.0F;
		}

		this.rotationPitch = MathHelper.lerp(0.2F, this.prevRotationPitch, this.rotationPitch);
		this.rotationYaw = MathHelper.lerp(0.2F, this.prevRotationYaw, this.rotationYaw);
		float f1 = 0.99F;
		float f2 = 0.06F;
		if (!this.world.isMaterialInBB(this.getBoundingBox(), Material.AIR)) {
			this.remove();
		} else if (this.isInWaterOrBubbleColumn()) {
			this.remove();
		} else {
			this.setMotion(vec3d.scale((double)0.99F));
			if (!this.hasNoGravity()) {
				this.setMotion(this.getMotion().add(0.0D, (double)-0.06F, 0.0D));
			}

			this.setPosition(this.posX, this.posY, this.posZ);
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
			this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
		}
	}

	public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
		Vec3d vec3d = (new Vec3d(x, y, z)).normalize().add(this.rand.nextGaussian() * (double)0.0075F * (double)inaccuracy, this.rand.nextGaussian() * (double)0.0075F * (double)inaccuracy, this.rand.nextGaussian() * (double)0.0075F * (double)inaccuracy).scale((double)velocity);
		this.setMotion(vec3d);
		float f = MathHelper.sqrt(horizontalMag(vec3d));
		this.rotationYaw = (float)(MathHelper.atan2(vec3d.x, z) * (double)(180F / (float)Math.PI));
		this.rotationPitch = (float)(MathHelper.atan2(vec3d.y, (double)f) * (double)(180F / (float)Math.PI));
		this.prevRotationYaw = this.rotationYaw;
		this.prevRotationPitch = this.rotationPitch;
	}

	public void onHit(RayTraceResult p_190536_1_)
	{
		RayTraceResult.Type raytraceresult$type = p_190536_1_.getType();
		if (raytraceresult$type == RayTraceResult.Type.ENTITY && this.owner != null) {
			((EntityRayTraceResult)p_190536_1_).getEntity().attackEntityFrom(DamageSource.causeIndirectDamage(this, this.owner).setProjectile(), 1.0F);
		} else if (raytraceresult$type == RayTraceResult.Type.BLOCK && !this.world.isRemote) {
			this.remove();
		}
	}

	protected void readAdditional(CompoundNBT compound)
	{
		if (compound.contains("Owner", 10))
		{
			this.ownerNbt = compound.getCompound("Owner");
		}
	}

	protected void writeAdditional(CompoundNBT compound)
	{
		if (this.owner != null)
		{
			CompoundNBT compoundnbt = new CompoundNBT();
			UUID uuid = this.owner.getUniqueID();
			compoundnbt.putUniqueId("OwnerUUID", uuid);
			compound.put("Owner", compoundnbt);
		}
	}

	private void restoreOwnerFromSave()
	{
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

	protected void registerData()
	{
	}
}
