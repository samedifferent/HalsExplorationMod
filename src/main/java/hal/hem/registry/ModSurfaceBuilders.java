package hal.hem.registry;

import hal.hem.HEM;
import hal.hem.world.gen.surfacebuilders.BlueleafPlainsSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSurfaceBuilders {
    public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, HEM.MOD_ID);

    public static final RegistryObject<BlueleafPlainsSurfaceBuilder> BLUELEAF_PLAINS = SURFACE_BUILDERS.register("blueleaf_plains", () -> new BlueleafPlainsSurfaceBuilder(SurfaceBuilderConfig.CODEC));
}
