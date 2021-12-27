package hal.hem.item;

import hal.hem.HEMCommon;
import hal.hem.registry.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

public class ShotgunItem extends ProjectileWeaponItem {

    public static final Predicate<ItemStack> BULLET = (stack) -> stack.getItem().equals(ModItems.SHOTGUN_SHELL.get());

    public ShotgunItem() {
        super(new Item.Properties().durability(384).tab(HEMCommon.TAB));
    }

    @Override
    public void releaseUsing(ItemStack itemStack, Level level, LivingEntity livingEntity, int i) {
        super.releaseUsing(itemStack, level, livingEntity, i);
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return BULLET;
    }

    @Override
    public int getDefaultProjectileRange() {
        return 20;
    }
}
