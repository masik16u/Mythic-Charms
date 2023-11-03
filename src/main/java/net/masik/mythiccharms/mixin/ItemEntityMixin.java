package net.masik.mythiccharms.mixin;

import net.masik.mythiccharms.block.ModBlocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public class ItemEntityMixin {
    @Unique
    private int angle = 0;

    @Inject(method = "tick", at = @At("RETURN"))
    private void itemOnResonanceTable(CallbackInfo ci) {
        ItemEntity itemEntity = (ItemEntity) (Object) this;

        if (!itemEntity.getWorld().getBlockState(itemEntity.getBlockPos().down()).getBlock().equals(ModBlocks.RESONANCE_TABLE))
            return;

        if (this.angle > 40) this.angle = 0;

        Vec3d v1 = new Vec3d(Math.cos(Math.PI * this.angle / 20.0) * 0.01, 0, Math.sin(Math.PI * this.angle / 20.0) * 0.01);

        BlockPos blockPos = itemEntity.getBlockPos();
        Vec3d v2 = new Vec3d(blockPos.getX() + 0.495, blockPos.getY() + 1, blockPos.getZ() + 0.5);

        itemEntity.setVelocity(itemEntity.getVelocity().add(v1.add(v2.subtract(itemEntity.getPos()).multiply(0.04F))));
        itemEntity.velocityModified = true;

        this.angle += 1;
    }
}
