package net.masik.mythiccharms.mixin;

import net.masik.mythiccharms.item.ModItems;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ExperienceOrbEntity.class)
public class ExperienceOrbEntityMixin {

    @Inject(method = "spawn", at = @At("RETURN"))
    private static void spawnExperienceNugget(ServerWorld world, Vec3d pos, int amount, CallbackInfo ci) {

        java.util.Random rand = new java.util.Random();

        if (rand.nextInt(10) >= 3) return;

        world.spawnEntity(new ItemEntity(world, pos.x, pos.y, pos.z, ModItems.EXPERIENCE_NUGGET.getDefaultStack()));

    }

}
