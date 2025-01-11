package net.masik.mythiccharms.mixin;

import net.masik.mythiccharms.processor.ModStructureProcessorType;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.processor.StructureProcessor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StructureTemplate.class)
public class StructureTemplateMixin {

    // Prevent water from spawning inside waterloggable blocks
    // Runs when structure is placed in the world
    @Inject(method = "place", at = @At("HEAD"))
    private void place(ServerWorldAccess world, BlockPos pos, BlockPos pivot, StructurePlacementData placementData, Random random, int flags, CallbackInfoReturnable<Boolean> cir) {

        // Return if no structure processors found
        if (placementData.getProcessors() == null) return;

        // Search through processors for mod's processor
        for (StructureProcessor processor : placementData.getProcessors()) {
            if (processor.getType() == ModStructureProcessorType.WATERLOGGED_PROCESSOR) {

                // If found disallow waterlogging
                placementData.setPlaceFluids(false);
                break;
            }
        }

    }

}
