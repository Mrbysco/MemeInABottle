package com.mrbysco.miab.entity.projectile;

import com.mrbysco.miab.init.MemeEntities;
import com.mrbysco.miab.init.MemeRegister;
import com.mrbysco.miab.memes.MemeRegistry;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

@OnlyIn(
        value = Dist.CLIENT,
        _interface = IRendersAsItem.class
)
public class SplashMemeEntity extends ProjectileItemEntity implements IRendersAsItem {
    @Override
    protected Item getDefaultItem() {
        return MemeRegister.SPLASH_MEME_IN_A_BOTTLE.get();
    }

    public SplashMemeEntity(EntityType<? extends SplashMemeEntity> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    public SplashMemeEntity(World worldIn, LivingEntity throwerIn) {
        super(MemeEntities.SPLASH_MEME.get(), throwerIn, worldIn);
    }
    
    public SplashMemeEntity(World worldIn, double x, double y, double z) {
        super(MemeEntities.SPLASH_MEME.get(), x, y, z, worldIn);
    }

    public SplashMemeEntity(FMLPlayMessages.SpawnEntity spawnEntity, World worldIn) {
        this(MemeEntities.SPLASH_MEME.get(), worldIn);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void handleStatusUpdate(byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; ++i) {
                this.world.addParticle(ParticleTypes.NOTE, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D);
            }
        }
    }
    
    @Override
    protected float getGravityVelocity()
    {
        return 0.05F;
    }

    /**
     * Called when this splash meme hits a block or entity.
     */
    @Override
    protected void onImpact(RayTraceResult result) {
        if (!this.world.isRemote) {
            if (this.isLingering()) {
                if(!world.isRemote) {
                    this.makeAreaOfEffectCloud();
                }
            }

            MemeRegistry.instance().triggerRandomMeme(world, this.getPosition(), world.getClosestPlayer(this, 100.0));

            this.remove();
        }
    }
    
    private void makeAreaOfEffectCloud() {
        AreaEffectCloudEntity entityareaeffectcloud = new AreaEffectCloudEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ());
        Entity entity = this.getShooter();
        if (entity instanceof LivingEntity) {
            entityareaeffectcloud.setOwner((LivingEntity)entity);
        }
        entityareaeffectcloud.setRadius(3.0F);
        entityareaeffectcloud.setRadiusOnUse(-0.5F);
        entityareaeffectcloud.setWaitTime(10);
        entityareaeffectcloud.setRadiusPerTick(-entityareaeffectcloud.getRadius() / (float)entityareaeffectcloud.getDuration());
        entityareaeffectcloud.setColor(13882323);
        entityareaeffectcloud.setCustomName(new StringTextComponent("dankcloud"));
        
        this.world.addEntity(entityareaeffectcloud);
    }
    
    @Override
    public void readAdditional(CompoundNBT compound)
    {
        super.readAdditional(compound);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
    }

    private boolean isLingering()
    {
    	return this.getItem().getItem() == MemeRegister.LINGERING_MEME_IN_A_BOTTLE.get();
    }
}
