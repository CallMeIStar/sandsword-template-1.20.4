package net.istar.sword.entity.custom;

import net.istar.sword.entity.ModEntities;
import net.istar.sword.entity.procedures.DuneEdgeWhileProjectileFlyingTickProcedure;
import net.istar.sword.item.ModItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DuneEdgeEntity extends PersistentProjectileEntity {
    private static final TrackedData<Boolean> ENCHANTED = DataTracker.registerData(DuneEdgeEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private boolean dealtDamage;
    private static final ItemStack DEFAULT_STACK = new ItemStack(ModItems.DUNEEDGE);
    private ItemStack stack;

    public DuneEdgeEntity(EntityType<DuneEdgeEntity> entityType, World world) {
        super(entityType, world, DEFAULT_STACK);
    }
    public DuneEdgeEntity(World world, LivingEntity owner, ItemStack stack) {
        super(ModEntities.DUNEEDGE, owner, world, stack);
        this.dataTracker.set(ENCHANTED, stack.hasGlint());
        this.stack = stack.copy();
        if (stack.hasCustomName()) {
            this.setCustomName(stack.getName());
        }
    }

    @Override
    protected SoundEvent getHitSound() {
        return SoundEvents.ITEM_TRIDENT_HIT_GROUND;
    }

    @Override
    public void onPlayerCollision(PlayerEntity player) {
        if (this.isOwner(player) || this.getOwner() == null) {
            super.onPlayerCollision(player);
        }
    }
    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        float f = 8.0f;
        if (entity instanceof LivingEntity livingEntity) {
            f += EnchantmentHelper.getAttackDamage(this.getItemStack(), livingEntity.getGroup());
        }
        Entity entity2 = this.getOwner();
        DamageSource damageSource = this.getDamageSources().trident(this, entity2 == null ? this : entity2);
        this.dealtDamage = true;
        SoundEvent soundEvent = SoundEvents.ITEM_TRIDENT_HIT;
        if (entity.damage(damageSource, f)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }
            if (entity instanceof LivingEntity livingEntity2) {
                if (entity2 instanceof LivingEntity) {
                    EnchantmentHelper.onUserDamaged(livingEntity2, entity2);
                    EnchantmentHelper.onTargetDamaged((LivingEntity)entity2, livingEntity2);
                }
                // Reduce pierce level on each hit
                byte currentPierceLevel = this.getPierceLevel();
                if (currentPierceLevel > 0) {
                    this.setPierceLevel((byte) (currentPierceLevel - 1));
                }


        this.dealtDamage = false;

        if (this.getPierceLevel() <= 0) {
            return;
        }
                this.onHit(livingEntity2);
                this.tick();

            }

        }
        float g = 1.0f;
        this.playSound(soundEvent, g, 1.0f);
    }

    @Override
    @Nullable
    protected EntityHitResult getEntityCollision(Vec3d currentPosition, Vec3d nextPosition) {
        if (this.dealtDamage) {
            return null;
        }
        return super.getEntityCollision(currentPosition, nextPosition);
    }
    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("DealtDamage", this.dealtDamage);

    }
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ENCHANTED, false);
    }
    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    public boolean isEnchanted() {
        return this.dataTracker.get(ENCHANTED);
    }
    @Override
    protected boolean tryPickup(PlayerEntity player) {
        return super.tryPickup(player) || this.isNoClip() && this.isOwner(player) && player.getInventory().insertStack(this.asItemStack());
    }
    @Override
    protected ItemStack asItemStack() {
        return this.stack.copyWithCount(1);
    }
    @Override
    public void tick() {
        super.tick();
        DuneEdgeWhileProjectileFlyingTickProcedure.execute(this.getWorld(), this.getX(), this.getY(), this.getZ());
        if(this.inGround && Math.random() <= 0.88 && this.inGroundTime == 1) {
            this.discard();
        }

}
}