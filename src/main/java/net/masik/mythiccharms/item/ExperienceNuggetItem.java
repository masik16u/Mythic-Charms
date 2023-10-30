package net.masik.mythiccharms.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ExperienceNuggetItem extends Item {
    public ExperienceNuggetItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack nugget = user.getStackInHand(hand);
        int quantity = user.isSneaking() ? nugget.getCount() : 1;

        user.addExperience(quantity);
        nugget.decrement(user.isCreative() ? 0 : quantity);

        user.swingHand(hand);

        user.getWorld().playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, user.getSoundCategory(), 0.1F, 1.0F);

        return TypedActionResult.consume(user.getStackInHand(hand));
    }

}
