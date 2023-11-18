package net.masik.mythiccharms.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.masik.mythiccharms.MythicCharms;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.*;

public class ResonanceRecipe implements Recipe<SimpleInventory> {

    private final Identifier id;
    private final ItemStack output;
    private final DefaultedList<Ingredient> ingredients;

    public ResonanceRecipe(Identifier id, ItemStack output, DefaultedList<Ingredient> ingredients) {
        this.id = id;
        this.output = output;
        this.ingredients = ingredients;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        List<Item> recipeItems = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getMatchingStacks().length > 0) {
                recipeItems.add(ingredient.getMatchingStacks()[0].getItem());
            }
        }
        List<Item> inventoryItems = inventory.stacks.stream().map(ItemStack::getItem).toList();

        return inventoryItems.size() == recipeItems.size() && new HashSet<>(inventoryItems).containsAll(recipeItems);
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return output.copy();
    }

    public DefaultedList<Ingredient> getRecipeItems() {
        return ingredients;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<ResonanceRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "resonance_infusing";
    }

    public static class Serializer implements RecipeSerializer<ResonanceRecipe> {
        private Serializer() { }
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "resonance_infusing";

        @Override
        public ResonanceRecipe read(Identifier id, JsonObject json) {
            DefaultedList<Ingredient> defaultedList = getIngredients(JsonHelper.getArray(json, "ingredients"));

            ItemStack itemStack = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "result"));

            return new ResonanceRecipe(id, itemStack, defaultedList);
        }

        private static DefaultedList<Ingredient> getIngredients(JsonArray json) {
            DefaultedList<Ingredient> defaultedList = DefaultedList.of();

            for(int i = 0; i < json.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(json.get(i), false);
                if (!ingredient.isEmpty()) {
                    defaultedList.add(ingredient);
                }
            }

            return defaultedList;
        }

        @Override
        public ResonanceRecipe read(Identifier id, PacketByteBuf buf) {
            int i = buf.readVarInt();
            DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(i, Ingredient.EMPTY);

            for(int j = 0; j < defaultedList.size(); ++j) {
                defaultedList.set(j, Ingredient.fromPacket(buf));
            }

            ItemStack itemStack = buf.readItemStack();
            return new ResonanceRecipe(id, itemStack, defaultedList);
        }

        @Override
        public void write(PacketByteBuf buf, ResonanceRecipe recipe) {
            buf.writeVarInt(recipe.ingredients.size());
            Iterator var3 = recipe.ingredients.iterator();

            while(var3.hasNext()) {
                Ingredient ingredient = (Ingredient)var3.next();
                ingredient.write(buf);
            }

            buf.writeItemStack(recipe.output);
        }
    }
}