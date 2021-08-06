package hal.hem.registry;

import hal.hem.HEM;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ModDimensions {
    public static final RegistryKey<World> BLUELEAF_WORLD = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(HEM.MOD_ID, "blueleaf"));
}
