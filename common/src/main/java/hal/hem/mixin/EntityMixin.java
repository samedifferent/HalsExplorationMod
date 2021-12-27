package hal.hem.mixin;

import hal.hem.world.dimension.EntityTeleporterDuck;
import hal.hem.world.dimension.ITeleporter;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.PortalInfo;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Entity.class)
public abstract class EntityMixin implements EntityTeleporterDuck {

    // Shadow gets fields & methods from the class we are mixing into (I.E. Entity.class)
    @Shadow public Level level;
    @Shadow public boolean removed;
    @Shadow public float yRot;
    @Shadow public abstract void unRide();
    @Shadow @Nullable protected abstract PortalInfo findDimensionEntryPoint(ServerLevel serverLevel);
    @Shadow public abstract EntityType<?> getType();
    @Shadow protected abstract void removeAfterChangingDimensions();


    // This is a Forge patch, implemented as a Mixin
    // This patch can be found at
    // https://github.com/MinecraftForge/MinecraftForge/blob/eb1a9b57c6cc4d5cb4ad3c4305c2a73015d28917/patches/minecraft/net/minecraft/world/entity/Entity.java.patch#L235
    @Nullable
    public Entity changeDimensionForge(ServerLevel serverLevel, ITeleporter teleporter) {
        if (this.level instanceof ServerLevel && !this.removed) {
            this.level.getProfiler().push("changeDimension");
            this.unRide();
            this.level.getProfiler().push("reposition");
            PortalInfo portalinfo = teleporter.getPortalInfo((Entity) (Object) this, serverLevel, this::findDimensionEntryPoint);
            if (portalinfo == null) {
                return null;
            } else {
                Entity transportedEntity = teleporter.placeEntity((Entity) (Object) this, (ServerLevel) this.level, serverLevel, this.yRot, spawnPortal -> { //Forge: Start vanilla logic
                    this.level.getProfiler().popPush("reloading");
                    Entity entity = this.getType().create(serverLevel);
                    if (entity != null) {
                        entity.restoreFrom((Entity) (Object) this);
                        entity.moveTo(portalinfo.pos.x, portalinfo.pos.y, portalinfo.pos.z, portalinfo.yRot, entity.xRot);
                        entity.setDeltaMovement(portalinfo.speed);
                        serverLevel.addFromAnotherDimension(entity);
                        if (spawnPortal && serverLevel.dimension() == Level.END) {
                            ServerLevel.makeObsidianPlatform(serverLevel);
                        }
                    }
                    return entity;
                }); //Forge: End vanilla logic

                this.removeAfterChangingDimensions();
                this.level.getProfiler().pop();
                ((ServerLevel)this.level).resetEmptyTime();
                serverLevel.resetEmptyTime();
                this.level.getProfiler().pop();
                return transportedEntity;
            }
        } else {
            return null;
        }
    }
}
