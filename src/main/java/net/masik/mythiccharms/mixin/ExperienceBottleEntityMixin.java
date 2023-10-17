package net.masik.mythiccharms.mixin;

import dev.emi.trinkets.api.TrinketsApi;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.block.ModBlocks;
import net.masik.mythiccharms.item.ModItems;
import net.masik.mythiccharms.recipe.ModRecipes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ExperienceBottleEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Mixin(ExperienceBottleEntity.class)
public class ExperienceBottleEntityMixin {

    @Inject(method = "onCollision", at = @At("RETURN"))
    private void onCollision(HitResult hitResult, CallbackInfo ci) {

        ThrownItemEntity entity = (ThrownItemEntity) (Object) this;

        PlayerEntity player = entity.getWorld().getClosestPlayer(entity, 10);

        if (player != null) {

            if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ModItems.RESONANCE_RING)) {

                if (entity.getWorld().getBlockState(entity.getBlockPos().add(0, -1, 0)).getBlock() == ModBlocks.RESONANCE_TABLE &&
                        entity.getWorld().getBlockState(entity.getBlockPos().add(0, -2, 0)).getBlock() == Blocks.LAPIS_BLOCK) {

                    Box box = Box.from(entity.getPos()).expand(1);

                    List<String> ingredients = new ArrayList<>();

                    List<ItemEntity> items = new ArrayList<>(entity.getWorld().getEntitiesByType(EntityType.ITEM, box, item -> true));

                    items.forEach(item -> {

                        ingredients.add(item.getStack().toString());

                    });

                    Collections.sort(ingredients);

                    if (ModRecipes.RESONANCE_TABLE_RECIPES.contains(ingredients)) {

                        items.forEach(Entity::discard);

                        ItemEntity result = new ItemEntity(entity.getWorld(), entity.getX(), entity.getY(), entity.getZ(),
                                ModRecipes.RESONANCE_TABLE_RECIPE_RESULTS.get(ModRecipes.RESONANCE_TABLE_RECIPES.indexOf(ingredients)));
                        entity.getWorld().spawnEntity(result);

                        player.getWorld().playSound((PlayerEntity) null, player.getX(), player.getY(), player.getZ(),
                                SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, player.getSoundCategory(), 40.0F, 1.0F);
                        player.getWorld().playSound((PlayerEntity) null, player.getX(), player.getY(), player.getZ(),
                                SoundEvents.ENTITY_PLAYER_LEVELUP, player.getSoundCategory(), 10.0F, 1.0F);

                        if (player.getServer() != null) {

                            player.getServer().getWorld(player.getWorld().getRegistryKey()).spawnParticles(ParticleTypes.WAX_OFF,
                                    entity.getX(), entity.getY(), entity.getZ(), 50, 0.3, 0.5, 0.3, 3);

                        }

                    }

                }

            }

        }

    }

}
