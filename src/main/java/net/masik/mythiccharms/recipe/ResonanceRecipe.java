package net.masik.mythiccharms.recipe;

import com.google.gson.JsonObject;
import net.masik.mythiccharms.block.ModBlocks;
import net.masik.mythiccharms.util.SafeDefaultedList;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class ResonanceRecipe implements Recipe<SimpleInventory>, RecipeJsonProvider {
    public final Identifier id;
    public final Item result;
    public final Set<Item> ingredients;
    public final List<ItemStack> stacks;

    public ResonanceRecipe(Collection<Item> ingredients, Item result) {
        this.result = result;
        this.ingredients = new LinkedHashSet<>(ingredients);
        this.stacks = new SafeDefaultedList<>(this.ingredients.stream().map(ItemStack::new).toList(), ItemStack.EMPTY);
        this.id = Registries.ITEM.getId(result);
    }

    public static ResonanceRecipe forCodec(Collection<Ingredient> ingredients, Item result) {
        return new ResonanceRecipe(ingredients.stream().map(
                ingredient -> ingredient.getMatchingStacks()[0].getItem()).toList(),
                result);
    }

    @Override
    public ItemStack createIcon() {
        return ModBlocks.RESONANCE_TABLE.asItem().getDefaultStack();
    }

    @Override
    public boolean matches(SimpleInventory items, World world) {
        if (world.isClient()) {
            return false;
        }
        RecipeMatcher recipeMatcher = new RecipeMatcher();
        int i = 0;

        for (int j = 0; j < items.size(); ++j) {
            ItemStack itemStack = items.getStack(j);
            if (!itemStack.isEmpty()) {
                ++i;
                recipeMatcher.addInput(itemStack, 1);
            }
        }

        return i == this.ingredients.size() && recipeMatcher.match(this, null);
    }

    @Override
    public ItemStack craft(SimpleInventory items, DynamicRegistryManager registryManager) {
        return this.result.getDefaultStack();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(DynamicRegistryManager registryManager) {
        return this.result.getDefaultStack();
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        Ingredient[] ingredients = new Ingredient[this.ingredients.size()];
        for (int i = 0; i < ingredients.length; i++) {
            ingredients[i] = Ingredient.ofStacks(this.stacks.get(i));
        }
        return DefaultedList.copyOf(Ingredient.EMPTY, ingredients);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ResonanceRecipeSerializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    @Override
    public void serialize(JsonObject json) {
        ResonanceRecipeSerializer.INSTANCE.write(this, json);
    }

    @Override
    //#if MC >= 12002
    public Identifier id()
    //#else
    //$$ public Identifier getRecipeId()
    //#endif
    {
        return this.id;
    }

    //#if MC >= 12002
    @Override
    public RecipeSerializer<?> serializer() {
        return ResonanceRecipeSerializer.INSTANCE;
    }

    @Nullable
    @Override
    public net.minecraft.advancement.AdvancementEntry advancement() {
        return null;
    }
    //#else
    //$$ @Nullable
    //$$ @Override
    //$$ public JsonObject toAdvancementJson() {
    //$$     return null;
    //$$ }
    //$$ @Nullable
    //$$ @Override
    //$$ public Identifier getAdvancementId() {
    //$$     return null;
    //$$ }
    //$$ @Override
    //$$ public Identifier getId() {
    //$$    return this.id;
    //$$ }
    //#endif

    public static class Type implements RecipeType<ResonanceRecipe> {
        public static final RecipeType<ResonanceRecipe> INSTANCE = new Type();
        public static final String ID = "resonance_infusing";
    }

}