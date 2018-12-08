package com.Mrbysco.miab.entities.base;

import java.util.Calendar;

import javax.annotation.Nullable;

import com.Mrbysco.miab.entities.projectiles.EntityKnucklesSpit;
import com.Mrbysco.miab.init.MemeLoot;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityKnucklesBase extends EntityCreature implements IMob, IRangedAttackMob{

	private static final DataParameter<Boolean> ARMS_RAISED = EntityDataManager.<Boolean>createKey(EntityMob.class, DataSerializers.BOOLEAN);
	private final EntityAIBreakDoor breakDoor = new EntityAIBreakDoor(this);

	private boolean isBreakDoorsTaskSet;
    private boolean didSpit;

	public EntityKnucklesBase(World worldIn) {
		super(worldIn);
	    super.setSize(0.9F, 0.9F);
	}

	protected void initEntityAI()
	{
        this.tasks.addTask(1, new EntityAIAttackRanged((IRangedAttackMob) this, 1.25D, 15, 10.0F));
		this.tasks.addTask(3, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
        
        this.applyEntityAI();
	}

   protected void applyEntityAI()
   {
       this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
   }

   public void setArmsRaised(boolean armsRaised)
   {
       this.getDataManager().set(ARMS_RAISED, Boolean.valueOf(armsRaised));
   }
   
   protected void applyEntityAttributes()
   {
       super.applyEntityAttributes();
       
       this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
       this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
       this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
       this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.6D);
   }
   
   public boolean isBreakDoorsTaskSet()
   {
       return this.isBreakDoorsTaskSet;
   }

   /**
    * Sets or removes EntityAIBreakDoor task
    */
   public void setBreakDoorsAItask(boolean enabled)
   {
       if (this.isBreakDoorsTaskSet != enabled)
       {
           this.isBreakDoorsTaskSet = enabled;
           ((PathNavigateGround)this.getNavigator()).setBreakDoors(enabled);

           if (enabled)
           {
               this.tasks.addTask(1, this.breakDoor);
           }
           else
           {
               this.tasks.removeTask(this.breakDoor);
           }
       }
   }

   /**
    * Get the experience points the entity currently has.
    */
   protected int getExperiencePoints(EntityPlayer player)
   {
       return super.getExperiencePoints(player);
   }
   
   public void onLivingUpdate()
   {
		if (this.isRiding() && this.getAttackTarget() != null && this.getRidingEntity() instanceof EntityChicken)
       {
           ((EntityLiving)this.getRidingEntity()).getNavigator().setPath(this.getNavigator().getPath(), 1.5D);
       }
		float f = this.getBrightness();
		
		ignoreUndeadFire = true;
	       
       super.onLivingUpdate();
      
       ignoreUndeadFire = false;
   }
   
   private boolean ignoreUndeadFire = false;
   
   public void onUpdate()
   {
       super.onUpdate();
   }
   
   public boolean attackEntityAsMob(Entity entityIn)
   {
       boolean flag = super.attackEntityAsMob(entityIn);

       if (flag)
       {
           float f = this.world.getDifficultyForLocation(new BlockPos(this)).getAdditionalDifficulty();

           if (this.getHeldItemMainhand() == null)
           {
               if (this.isBurning() && this.rand.nextFloat() < f * 0.3F)
               {
                   entityIn.setFire(2 * (int)f);
               }
           }
       }

       return flag;
   }
   
   protected SoundEvent getSwimSound()
   {
       return SoundEvents.ENTITY_HOSTILE_SWIM;
   }

   protected SoundEvent getSplashSound()
   {
       return SoundEvents.ENTITY_HOSTILE_SPLASH;
   }
   
   protected SoundEvent getAmbientSound()
   {
       return SoundEvents.ENTITY_ZOMBIE_AMBIENT;
   }
   
   protected SoundEvent getHurtSound(DamageSource p_184601_1_)
   {
       return SoundEvents.ENTITY_HOSTILE_HURT;
   }

   protected SoundEvent getDeathSound()
   {
       return SoundEvents.ENTITY_HOSTILE_DEATH;
   }

   protected SoundEvent getFallSound(int heightIn)
   {
       return heightIn > 4 ? SoundEvents.ENTITY_HOSTILE_BIG_FALL : SoundEvents.ENTITY_HOSTILE_SMALL_FALL;
   }


   protected void playStepSound(BlockPos pos, Block blockIn)
   {
       SoundEvent soundevent = SoundEvents.ENTITY_ZOMBIE_VILLAGER_STEP;
       this.playSound(soundevent, 0.15F, 1.0F);
   }
   
   @Nullable
   protected ResourceLocation getLootTable()
   {
	   return MemeLoot.MEME_BASE_LOOT;
   }
   
   protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
   {
       super.setEquipmentBasedOnDifficulty(difficulty);

       if (this.rand.nextFloat() < (this.world.getDifficulty() == EnumDifficulty.HARD ? 0.05F : 0.01F))
       {
           int i = this.rand.nextInt(3);

           if (i == 0)
           {
               this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
           }
           else
           {
               this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SHOVEL));
           }
       }
   }
   
   public static void registerFixesZombie(DataFixer fixer)
   {
       EntityLiving.registerFixesMob(fixer, EntityMemeBase.class);
   }
   
   public void writeEntityToNBT(NBTTagCompound compound)
   {
       super.writeEntityToNBT(compound);

       compound.setBoolean("CanBreakDoors", this.isBreakDoorsTaskSet());
   }
   
   public void readEntityFromNBT(NBTTagCompound compound)
   {
       super.readEntityFromNBT(compound);

       this.setBreakDoorsAItask(compound.getBoolean("CanBreakDoors"));
   }
   
   public void onKillEntity(EntityLivingBase entityLivingIn)
   {
       super.onKillEntity(entityLivingIn);

       if ((this.world.getDifficulty() == EnumDifficulty.NORMAL || this.world.getDifficulty() == EnumDifficulty.HARD) && entityLivingIn instanceof EntityVillager)
       {
           if (this.world.getDifficulty() != EnumDifficulty.HARD && this.rand.nextBoolean())
           {
               return;
           }
           
           EntityMemeBase entitymemebase = new EntityMemeBase(this.world);
           entitymemebase.copyLocationAndAnglesFrom(entityLivingIn);
           this.world.removeEntity(entityLivingIn);
           entitymemebase.onInitialSpawn(this.world.getDifficultyForLocation(new BlockPos(entitymemebase)), null);

           this.world.spawnEntity(entitymemebase);
           this.world.playEvent((EntityPlayer)null, 1026, new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ), 0);
       }
   }

   public float getEyeHeight()
   {
       float f = 1.74F;
       return f;
   }
   
   protected boolean canEquipItem(ItemStack stack)
   {
       return stack.getItem() == Items.EGG && this.isRiding() ? false : super.canEquipItem(stack);
   }
   
   @Nullable
   public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
   {
       livingdata = super.onInitialSpawn(difficulty, livingdata);
       float f = difficulty.getClampedAdditionalDifficulty();
       this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);

       this.setBreakDoorsAItask(this.rand.nextFloat() < f * 0.1F);
       this.setEquipmentBasedOnDifficulty(difficulty);
       this.setEnchantmentBasedOnDifficulty(difficulty);

       if (this.getItemStackFromSlot(EntityEquipmentSlot.HEAD) == null)
       {
           Calendar calendar = this.world.getCurrentDate();

           if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25F)
           {
               this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(this.rand.nextFloat() < 0.1F ? Blocks.LIT_PUMPKIN : Blocks.PUMPKIN));
               this.inventoryArmorDropChances[EntityEquipmentSlot.HEAD.getIndex()] = 0.0F;
           }
       }

       this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * 0.05000000074505806D, 0));
       double d0 = this.rand.nextDouble() * 1.5D * (double)f;

       if (d0 > 1.0D)
       {
           this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).applyModifier(new AttributeModifier("Random meme-spawn bonus", d0, 2));
       }

       if (this.rand.nextFloat() < f * 0.05F)
       {
           this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(new AttributeModifier("Leader meme bonus", this.rand.nextDouble() * 3.0D + 1.0D, 2));
           this.setBreakDoorsAItask(true);
       }

       return livingdata;
   }

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		EntityKnucklesSpit entityknucklesspit = new EntityKnucklesSpit(this.world, this);
        double d0 = target.posX - this.posX;
        double d1 = target.getEntityBoundingBox().minY + (double)(target.height / 3.0F) - entityknucklesspit.posY;
        double d2 = target.posZ - this.posZ;
        float f = MathHelper.sqrt(d0 * d0 + d2 * d2) * 0.2F;
        entityknucklesspit.shoot(d0, d1 + (double)f, d2, 1.5F, 10.0F);
        this.world.playSound((EntityPlayer)null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_LLAMA_SPIT, this.getSoundCategory(), 1.0F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
        this.world.spawnEntity(entityknucklesspit);
	}
	
	@Override
	public void setSwingingArms(boolean swingingArms) {
	}

}