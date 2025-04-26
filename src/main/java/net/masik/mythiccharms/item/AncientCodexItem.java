package net.masik.mythiccharms.item;

import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.util.AdvancementsHelper;
import net.masik.mythiccharms.util.CharmHelper;
import net.masik.mythiccharms.util.SoundHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class AncientCodexItem extends Item {

    public AncientCodexItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        // check if item in another hand is a pattern
        if (user.getOffHandStack().isIn(TagKey.of(RegistryKeys.ITEM, new Identifier(MythicCharms.MOD_ID, "sound_carving_patterns")))) {

            Random random = Random.create();
            // get all patterns list except currently holding one
            ArrayList<Integer> range = new ArrayList<>(IntStream.rangeClosed(0, CharmHelper.PATTERNS.size() - 1).boxed().toList());
            range.remove(CharmHelper.PATTERNS.indexOf(user.getOffHandStack().getItem()));

            if (!user.getAbilities().creativeMode) {
                // remove both book and pattern
                user.getOffHandStack().decrement(1);
                user.getMainHandStack().decrement(1);
            }

            // give random pattern from range
            user.giveItemStack(CharmHelper.PATTERNS.get(range.get(random.nextInt(range.size()))).getDefaultStack());

            // play sound
            SoundHelper.playSoundAtEntity(user, SoundEvents.ITEM_BOOK_PAGE_TURN, 20F);

            // give adv
            AdvancementsHelper.grantAdvancement(user, new Identifier(MythicCharms.MOD_ID, "story/ancient_codex"));

            return TypedActionResult.success(user.getStackInHand(hand));

        }

        return TypedActionResult.fail(user.getStackInHand(hand));
    }
}
