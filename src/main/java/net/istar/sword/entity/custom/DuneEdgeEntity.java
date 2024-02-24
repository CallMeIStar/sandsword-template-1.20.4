package net.istar.sword.entity.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.istar.sword.entity.ModEntities;
import net.istar.sword.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@Environment(EnvType.CLIENT)
public class DuneEdgeEntity extends PersistentProjectileEntity {
    private static final ItemStack PROJECTILE_ITEM = new ItemStack(ModItems.DUNEEDGE);

    public DuneEdgeEntity(EntityType<DuneEdgeEntity> entityType, World world) {
        super(entityType, world, PROJECTILE_ITEM);
    }
    public DuneEdgeEntity(World world, LivingEntity owner, ItemStack stack) {
        super(ModEntities.DUNEEDGE, owner, world, stack);
    }
    public DuneEdgeEntity(EntityType<? extends DuneEdgeEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world, PROJECTILE_ITEM);
    }

    public DuneEdgeEntity(EntityType<? extends DuneEdgeEntity> type, LivingEntity entity, World world) {
        super(type, world, PROJECTILE_ITEM);
    }
    public static ItemStack getProjectileItem() {
        return PROJECTILE_ITEM;
    }

    protected static ItemStack getPickupItem() {
        return PROJECTILE_ITEM;
    }

    public static DuneEdgeEntity createMobAttributes() {
        return null;
    }
}