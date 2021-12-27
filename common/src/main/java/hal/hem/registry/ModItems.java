package hal.hem.registry;

import hal.hem.HEMCommon;
import hal.hem.item.AirshipItem;
import hal.hem.item.ModItemTier;
import hal.hem.item.ShotgunShellItem;
import me.shedaniel.architectury.registry.DeferredRegister;
import me.shedaniel.architectury.registry.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.WaterLilyBlockItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(HEMCommon.MOD_ID, Registry.ITEM_REGISTRY);

    public static final RegistrySupplier<Item> AIRSHIP = ITEMS.register("airship", AirshipItem::new);
    public static final RegistrySupplier<Item> BRONZIUM_INGOT = ITEMS.register("bronzium_ingot", () -> new Item(new Item.Properties().tab(HEMCommon.TAB)));
    public static final RegistrySupplier<Item> ROSE_COPPER_INGOT = ITEMS.register("rose_copper_ingot", () -> new Item(new Item.Properties().tab(HEMCommon.TAB)));
    public static final RegistrySupplier<Item> COPPARITE_INGOT = ITEMS.register("copparite_ingot", () -> new Item(new Item.Properties().tab(HEMCommon.TAB)));
    public static final RegistrySupplier<Item> BOILER = ITEMS.register("boiler", () -> new Item(new Item.Properties().tab(HEMCommon.TAB)));
    public static final RegistrySupplier<Item> CIRCUIT_BOARD = ITEMS.register("circuit_board", () -> new Item(new Item.Properties().tab(HEMCommon.TAB)));
    public static final RegistrySupplier<Item> FLOWERING_LILY = ITEMS.register("flowering_lily", () -> new WaterLilyBlockItem(ModBlocks.FLOWERING_LILY.get(), new Item.Properties().tab(HEMCommon.TAB)));
    public static final RegistrySupplier<Item> ANCIENT_BLADE = ITEMS.register("ancient_blade", () -> new SwordItem(ModItemTier.COPPARITE, 3, -2.4F, new Item.Properties().tab(HEMCommon.TAB)));
    public static final RegistrySupplier<Item> SHOTGUN_SHELL = ITEMS.register("shotgun_shell", ShotgunShellItem::new);

}
