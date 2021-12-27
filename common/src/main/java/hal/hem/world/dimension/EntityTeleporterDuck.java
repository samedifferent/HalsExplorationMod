package hal.hem.world.dimension;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.Nullable;

public interface EntityTeleporterDuck {
    @Nullable Entity changeDimensionForge(ServerLevel serverLevel, ITeleporter teleporter);
}
