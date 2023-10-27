package net.masik.mythiccharms.mixin;

import net.masik.mythiccharms.block.ModBlocks;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ExperienceOrbEntity.class)
public class ExperienceOrbEntityMixin {

    @Inject(method = "spawn", at = @At("RETURN"))
    private static void spawnExperienceNugget(ServerWorld world, Vec3d pos, int amount, CallbackInfo ci) {

        if (checkResonanceTable(BlockPos.ofFloored(pos), world)) return;

        java.util.Random rand = new java.util.Random();

        if (rand.nextInt(10) >= 3) return;

        world.spawnEntity(new ItemEntity(world, pos.x, pos.y, pos.z, ModItems.EXPERIENCE_NUGGET.getDefaultStack()));

    }

    @Unique
    private static boolean checkResonanceTable(BlockPos bottlePos, World world) {
        for (BlockPos pos : BlockPos.iterate(new BlockPos(-1, -1, -1), new BlockPos(1, 1, 1))) {
            Block oneDown = world.getBlockState(bottlePos.add(pos)).getBlock();
            Block twoDown = world.getBlockState(bottlePos.add(pos).down(1)).getBlock();
            if (oneDown.equals(ModBlocks.RESONANCE_TABLE) && twoDown.equals(Blocks.LAPIS_BLOCK)) return true;
        }
        return false;
    }

}
