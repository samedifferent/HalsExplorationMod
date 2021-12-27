package hal.hem.registry;

import hal.hem.HEMCommon;
import hal.hem.world.gen.surfacebuilders.BlueleafPlainsSurfaceBuilder;
import me.shedaniel.architectury.registry.DeferredRegister;
import me.shedaniel.architectury.registry.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class ModSurfaceBuilders {
    public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(HEMCommon.MOD_ID, Registry.SURFACE_BUILDER_REGISTRY);

    public static final RegistrySupplier<BlueleafPlainsSurfaceBuilder> BLUELEAF_PLAINS = SURFACE_BUILDERS.register("blueleaf_plains", () -> new BlueleafPlainsSurfaceBuilder(SurfaceBuilderBaseConfiguration.CODEC));
}
