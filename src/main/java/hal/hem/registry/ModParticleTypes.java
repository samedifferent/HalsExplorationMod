package hal.hem.registry;

import hal.hem.HEM;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, HEM.MOD_ID);

    public static final RegistryObject<BasicParticleType> FALLING_BLUELEAF = PARTICLE_TYPES.register("falling_blueleaf", () -> new BasicParticleType(false));
    public static final RegistryObject<BasicParticleType> BLOSSOM = PARTICLE_TYPES.register("blossom", () -> new BasicParticleType(false));
    public static final RegistryObject<BasicParticleType> BLUELEAF_SPORE = PARTICLE_TYPES.register("blueleaf_spore", () -> new BasicParticleType(false));
    public static final RegistryObject<BasicParticleType> HEAVY_SNOW = PARTICLE_TYPES.register("heavy_snow", () -> new BasicParticleType(false));

}
