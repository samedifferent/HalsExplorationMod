package hal.hem.registry;

import hal.hem.HEMCommon;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class ModDimensions {
    public static final ResourceKey<Level> BLUELEAF_WORLD = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(HEMCommon.MOD_ID, "blueleaf"));
}
