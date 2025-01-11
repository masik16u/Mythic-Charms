package net.masik.mythiccharms.util;

import net.masik.mythiccharms.MythicCharms;
import net.minecraft.advancement.Advancement;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.ServerAdvancementLoader;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class AdvancementsHelper {

    public static void grantAdvancement(LivingEntity entity, Identifier id) {

        if (entity.getWorld().isClient) return;

        if (!entity.isPlayer()) return;

        if (entity.getServer() == null) return;

        Advancement advancement = entity.getServer().getAdvancementLoader().get(id);
        if (advancement != null) ((ServerPlayerEntity) entity).getAdvancementTracker().grantCriterion(advancement, "requirement");

    }

}
