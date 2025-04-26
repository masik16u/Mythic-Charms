package net.masik.mythiccharms.item;

import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.util.ParticleHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionTypes;

public class ResonanceCompassItem extends Item {
    public ResonanceCompassItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        // check if in overworld and if not client
        if (world.getDimensionKey() == DimensionTypes.OVERWORLD && !world.isClient && world.getServer() != null) {

            // locate nearest structure
            BlockPos structurePos = world.getServer().getOverworld().locateStructure(TagKey.of(RegistryKeys.STRUCTURE, new Identifier(MythicCharms.MOD_ID, "carvers_structures")), user.getBlockPos(), 50, false);

            if (structurePos != null) {

                double userX = user.getX();
                double userZ = user.getZ();
                double structurePosX = structurePos.getX();
                double structurePosZ = structurePos.getZ();

                // math
                double distance = Math.hypot(userX - structurePosX, userZ - structurePosZ);

                double angle = Math.atan2(structurePosZ - userZ, structurePosX - userX);

                double modifierX = 0;
                double modifierZ = 0;

                // sound if structure not found or too far
                SoundEvent soundEvent = SoundEvents.BLOCK_TUFF_BREAK;

                // structure 8 blocks away
                if (distance <= 8) {

                    soundEvent = SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME;

                }
                // 300 blocks
                else if (distance <= 300) {

                    soundEvent = SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE;
                    modifierX = Math.cos(angle) * 6;
                    modifierZ = Math.sin(angle) * 6;

                    // spawn particle in the direction of the structure
                    ParticleHelper.spawnParticle(user, ParticleTypes.WAX_OFF,
                            user.getX() + Math.cos(angle) * 2, user.getY() + 2, user.getZ() + Math.sin(angle) * 2,
                            1, 0.1, 0.1, 0.1, 1);

                }

                // play sound in the direction of the structure
                user.getWorld().playSound(null, user.getX() + modifierX, user.getY(), user.getZ() + modifierZ,
                        soundEvent, user.getSoundCategory(), 40, 1.0F);


                // cooldown
                user.getItemCooldownManager().set(this, 20);

                return TypedActionResult.success(user.getStackInHand(hand));

            }
        }

        return TypedActionResult.fail(user.getStackInHand(hand));
    }
}
