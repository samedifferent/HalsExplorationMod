package hal.hem.registry;

import hal.hem.HEMCommon;
import hal.hem.entity.projectile.BulletEntity;
import me.shedaniel.architectury.registry.DeferredRegister;
import me.shedaniel.architectury.registry.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(HEMCommon.MOD_ID, Registry.ENTITY_TYPE_REGISTRY);

    public static final RegistrySupplier<EntityType<BulletEntity>> BULLET = ENTITIES.register("bullet",
            () -> EntityType.Builder.of(BulletEntity::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(20).build(new ResourceLocation(HEMCommon.MOD_ID + "bullet").toString()));
}
