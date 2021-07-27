package hal.hem.registry;

import hal.hem.HEM;
import hal.hem.item.AirshipItem;
import net.minecraft.item.Item;
import net.minecraft.item.LilyPadItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HEM.MOD_ID);

    public static final RegistryObject<Item> AIRSHIP = ITEMS.register("airship", AirshipItem::new);
    public static final RegistryObject<Item> BRONZIUM_INGOT = ITEMS.register("bronzium_ingot", () -> new Item(new Item.Properties().tab(HEM.TAB)));
    public static final RegistryObject<Item> ROSE_COPPER_INGOT = ITEMS.register("rose_copper_ingot", () -> new Item(new Item.Properties().tab(HEM.TAB)));
    public static final RegistryObject<Item> COPPARITE_INGOT = ITEMS.register("copparite_ingot", () -> new Item(new Item.Properties().tab(HEM.TAB)));
    public static final RegistryObject<Item> BOILER = ITEMS.register("boiler", () -> new Item(new Item.Properties().tab(HEM.TAB)));
    public static final RegistryObject<Item> CIRCUIT_BOARD = ITEMS.register("circuit_board", () -> new Item(new Item.Properties().tab(HEM.TAB)));
    public static final RegistryObject<Item> FLOWERING_LILY = ITEMS.register("flowering_lily", () -> new LilyPadItem(ModBlocks.FLOWERING_LILY.get(), new Item.Properties().tab(HEM.TAB)));

}
