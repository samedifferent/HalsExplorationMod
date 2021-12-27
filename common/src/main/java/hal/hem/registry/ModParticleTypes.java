package hal.hem.registry;

import hal.hem.HEMCommon;
import hal.hem.particle.extra.ExtraSimpleParticleType;
import me.shedaniel.architectury.registry.DeferredRegister;
import me.shedaniel.architectury.registry.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;

public class ModParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(HEMCommon.MOD_ID, Registry.PARTICLE_TYPE_REGISTRY);

    public static final RegistrySupplier<SimpleParticleType> FALLING_BLUELEAF = PARTICLE_TYPES.register("falling_blueleaf", () -> new ExtraSimpleParticleType(false));
    public static final RegistrySupplier<SimpleParticleType> BLOSSOM = PARTICLE_TYPES.register("blossom", () -> new ExtraSimpleParticleType(false));
    public static final RegistrySupplier<SimpleParticleType> BLUELEAF_SPORE = PARTICLE_TYPES.register("blueleaf_spore", () -> new ExtraSimpleParticleType(false));
    public static final RegistrySupplier<SimpleParticleType> HEAVY_SNOW = PARTICLE_TYPES.register("heavy_snow", () -> new ExtraSimpleParticleType(false));
}
