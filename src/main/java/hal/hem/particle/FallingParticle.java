package hal.hem.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FallingParticle extends SpriteTexturedParticle {
    protected FallingParticle(ClientWorld world, double x, double y, double z) {
        super(world, x, y, z);
        this.gravity = 0.05F;
        this.hasPhysics = true;
        this.lifetime = 100;
        this.scale(1.1F);
    }
    protected FallingParticle(ClientWorld world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(world, x, y, z, xSpeed, ySpeed, zSpeed);
        this.gravity = 0.05F;
        this.hasPhysics = true;
        this.lifetime = 100;
        this.scale(1.1F);
    }

    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @OnlyIn(Dist.CLIENT)
    public static class FallingBlueleafFactory implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite sprite;

        public FallingBlueleafFactory(IAnimatedSprite sprite) {
            this.sprite = sprite;
        }

        public Particle createParticle(BasicParticleType type, ClientWorld world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            FallingParticle particle = new FallingParticle(world, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.pickSprite(this.sprite);
            return particle;
        }
    }
}
