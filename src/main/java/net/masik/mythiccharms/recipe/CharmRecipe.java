package net.masik.mythiccharms.recipe;

import net.masik.mythiccharms.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class CharmRecipe {
    public static final int INPUT_SIZE = 5;
    public final Item output;
    public final List<Item> input;
    public final Set<Item> inputSet;

    public CharmRecipe(Item output, List<Item> input) {
        this.output = output;
        this.input = input;
        this.inputSet = input.stream().filter(item -> item != Items.AIR).collect(Collectors.toSet());
    }

    public static CharmRecipe fragile(Item output, Item... input) {
        Item[] ingredient = new Item[INPUT_SIZE];
        Arrays.fill(ingredient, Items.AIR);
        ingredient[0] = ModItems.FRAGILE_CHARM_BASE;
        System.arraycopy(input, 0, ingredient, 1, Math.min(input.length, INPUT_SIZE));
        return new CharmRecipe(output, Arrays.asList(ingredient));
    }

    public static CharmRecipe unbreakable(Item output, Item charm) {
        Item[] ingredient = new Item[INPUT_SIZE];
        Arrays.fill(ingredient, Items.AIR);
        ingredient[0] = charm;
        ingredient[1] = Items.NETHERITE_INGOT;
        ingredient[2] = ModItems.DEEPSLATE_FRAGMENT;
        return new CharmRecipe(output, Arrays.asList(ingredient));
    }
}