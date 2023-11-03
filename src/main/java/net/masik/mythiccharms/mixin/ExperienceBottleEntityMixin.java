package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.block.ModBlocks;
import net.masik.mythiccharms.item.ModItems;
import net.masik.mythiccharms.recipe.ResonanceRecipe;
import net.masik.mythiccharms.util.RecipeUtils;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ExperienceBottleEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Mixin(ExperienceBottleEntity.class)
public class ExperienceBottleEntityMixin {

    @Inject(method = "onCollision", at = @At("RETURN"))
    private void onCollision(HitResult hitResult, CallbackInfo ci) {
        ThrownItemEntity bottle = (ThrownItemEntity) (Object) this;

        PlayerEntity player = bottle.getWorld().getClosestPlayer(bottle, 10);
        if (player == null) return;

        Optional<TrinketComponent> trinket = TrinketsApi.getTrinketComponent(player);
        if (trinket.isEmpty() || !trinket.get().isEquipped(ModItems.RESONANCE_RING)) return;

        World world = bottle.getWorld();
        if (!checkResonanceTable(bottle.getBlockPos(), world)) return;

        Box box = Box.from(bottle.getPos()).expand(1);
        List<ItemEntity> entities = world.getEntitiesByType(EntityType.ITEM, box, item -> true);
        Set<ItemStack> stacks = entities.stream().map(ItemEntity::getStack).collect(Collectors.toSet());
        SimpleInventory inventory = new SimpleInventory(stacks.toArray(stacks.toArray(new ItemStack[0])));

        // Runs only if all detected item entities match a recipe
        world.getRecipeManager().getFirstMatch(
                ResonanceRecipe.Type.INSTANCE,
                inventory,
                world
        ).ifPresent(it -> {
            ResonanceRecipe recipe = RecipeUtils.get(it);
            ItemEntity result = new ItemEntity(world,
                    bottle.getX(),
                    bottle.getY(),
                    bottle.getZ(),
                    recipe.getResult(null));
            result.setVelocity(0, 0.4, 0);
            world.spawnEntity(result);

            world.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, player.getSoundCategory(), 40.0F, 1.0F);
            world.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.ENTITY_PLAYER_LEVELUP, player.getSoundCategory(), 10.0F, 1.0F);
            if (world instanceof ServerWorld serverWorld) {
                serverWorld.spawnParticles(ParticleTypes.WAX_OFF,
                        bottle.getX(), bottle.getY(), bottle.getZ(), 50, 0.3, 0.5, 0.3, 3);
            }

            entities.forEach(entity -> entity.getStack().decrement(1));
        });
    }

    @Unique
    private boolean checkResonanceTable(BlockPos bottlePos, World world) {
        for (BlockPos pos : BlockPos.iterate(new BlockPos(-1, -1, -1), new BlockPos(1, 1, 1))) {
            Block oneDown = world.getBlockState(bottlePos.add(pos)).getBlock();
            Block twoDown = world.getBlockState(bottlePos.add(pos).down(1)).getBlock();
            if (oneDown.equals(ModBlocks.RESONANCE_TABLE) && twoDown.equals(Blocks.LAPIS_BLOCK)) return true;
        }
        return false;
    }
}
