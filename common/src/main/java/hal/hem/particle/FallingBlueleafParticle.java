package hal.hem.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

@Environment(EnvType.CLIENT)
public class FallingBlueleafParticle extends TextureSheetParticle {
    private float angularVelocity;
    private float angularAcceleration;

    protected FallingBlueleafParticle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed);
        this.gravity = 0.05F;
        this.hasPhysics = true;
        this.lifetime = 100;
        this.scale(1.1F);
        this.angularVelocity = 0.1F;
        this.angularAcceleration = 0.0F;
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void tick() {
        super.tick();
        this.oRoll = this.roll;
        this.roll += this.angularVelocity;
        this.angularVelocity += this.angularAcceleration;
    }

    @Environment(EnvType.CLIENT)
    public record Factory(SpriteSet spriteSet) implements ParticleProvider<SimpleParticleType> {
        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            FallingBlueleafParticle particle = new FallingBlueleafParticle(level, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.pickSprite(this.spriteSet);
            return particle;
        }
    }
}
