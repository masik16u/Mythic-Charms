package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.block.ModBlocks;
import net.masik.mythiccharms.item.ModItems;
import net.masik.mythiccharms.recipe.CharmRecipe;
import net.masik.mythiccharms.recipe.ModRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ExperienceBottleEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
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

import java.util.*;
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
        List<ItemEntity> entities = bottle.getWorld().getEntitiesByType(EntityType.ITEM, box, item -> true);
        Set<Item> items = entities.stream().map(entity -> entity.getStack().getItem()).collect(Collectors.toSet());

        for (Item key : ModRecipes.RESONANCE_TABLE.keySet()) {
            CharmRecipe recipe = ModRecipes.RESONANCE_TABLE.get(key);
            if (!items.equals(recipe.inputSet)) continue;

            entities.forEach(entity -> entity.getStack().decrement(1));
            ItemEntity result = new ItemEntity(world, bottle.getX(), bottle.getY(), bottle.getZ(),
                    key.getDefaultStack());
            world.spawnEntity(result);

            player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, player.getSoundCategory(), 40.0F, 1.0F);
            player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.ENTITY_PLAYER_LEVELUP, player.getSoundCategory(), 10.0F, 1.0F);

            if (player.getServer() != null) {

                player.getServer().getWorld(player.getWorld().getRegistryKey()).spawnParticles(ParticleTypes.WAX_OFF,
                        bottle.getX(), bottle.getY(), bottle.getZ(), 50, 0.3, 0.5, 0.3, 3);

            }

        }

    }

    @Unique
    private boolean checkResonanceTable(BlockPos bottlePos, World world) {
        Block oneDown = world.getBlockState(bottlePos.down()).getBlock();
        Block twoDown = world.getBlockState(bottlePos.down(2)).getBlock();
        return oneDown.equals(ModBlocks.RESONANCE_TABLE) && twoDown.equals(Blocks.LAPIS_BLOCK);
    }

}
