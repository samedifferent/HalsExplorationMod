package hal.hem.registry;

import hal.hem.HEM;
import hal.hem.item.AirshipItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HEM.MOD_ID);

    public static final RegistryObject<Item> AIRSHIP = ITEMS.register("airship", AirshipItem::new);
}
