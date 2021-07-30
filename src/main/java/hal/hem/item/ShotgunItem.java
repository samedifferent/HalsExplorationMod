package hal.hem.item;

import hal.hem.HEM;
import hal.hem.registry.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShootableItem;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class ShotgunItem extends ShootableItem {

    public static final Predicate<ItemStack> BULLET = (stack) -> {
        return stack.getItem().equals(ModItems.SHOTGUN_SHELL.get());
    };

    public ShotgunItem() {
        super(new Item.Properties().durability(384).tab(HEM.TAB));
    }

    @Override
    public void releaseUsing(ItemStack p_77615_1_, World p_77615_2_, LivingEntity p_77615_3_, int p_77615_4_) {
        super.releaseUsing(p_77615_1_, p_77615_2_, p_77615_3_, p_77615_4_);
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
