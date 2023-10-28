package net.masik.mythiccharms.recipe;

import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.block.ModBlocks;
import net.masik.mythiccharms.util.SafeDefaultedList;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ResonanceRecipe implements Recipe<StackSet>, RecipeJsonProvider {
    public final Item result;
    public final Set<Item> ingredients;
    public final List<ItemStack> stacks;

    public ResonanceRecipe(Collection<Item> ingredients, Item result) {
        this.result = result;
        this.ingredients = new LinkedHashSet<>(ingredients);
        this.stacks = new SafeDefaultedList<>(this.ingredients.stream().map(ItemStack::new).toList(), ItemStack.EMPTY);
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
    public boolean matches(StackSet items, World world) {
        if (world.isClient()) {
            return false;
        }
        return items.matches(this.stacks);
    }

    @Override
    public ItemStack craft(StackSet items, DynamicRegistryManager registryManager) {
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
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    @Override
    public void serialize(JsonObject json) {
        JsonOps jsonOps = JsonOps.INSTANCE;
        json.add(Serializer.ID, Serializer.CODEC.encodeStart(jsonOps, this).getOrThrow(false, error -> MythicCharms.LOGGER.error("Failed to serialize recipe for %s".formatted(this.result), error)));
    }

    @Override
    public Identifier id() {
        return Registries.ITEM.getId(this.result);
    }

    @Override
    public RecipeSerializer<?> serializer() {
        return Serializer.INSTANCE;
    }

    @Nullable
    @Override
    public AdvancementEntry advancement() {
        return null;
    }

    public static class Type implements RecipeType<ResonanceRecipe> {
        public static final RecipeType INSTANCE = new Type();
        public static final String ID = "resonance_infusing";
    }

    public static class Serializer implements RecipeSerializer<ResonanceRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "resonance_infusing";

        public static final Codec<ResonanceRecipe> CODEC = RecordCodecBuilder.create(in -> in.group(
                validateAmount(Ingredient.DISALLOW_EMPTY_CODEC, 5).fieldOf("ingredients").forGetter(ResonanceRecipe::getIngredients),
                RecipeCodecs.CRAFTING_RESULT_ITEM.fieldOf("result").forGetter(r -> r.result)
        ).apply(in, ResonanceRecipe::forCodec));

        private static Codec<List<Ingredient>> validateAmount(Codec<Ingredient> delegate, int max) {
            return Codecs.validate(Codecs.validate(
                    delegate.listOf(), list -> list.size() > max ? DataResult.error(() -> "Recipe has too many ingredients!") : DataResult.success(list)
            ), list -> list.isEmpty() ? DataResult.error(() -> "Recipe has no ingredients!") : DataResult.success(list));
        }

        @Override
        public Codec<ResonanceRecipe> codec() {
            return CODEC;
        }

        @Override
        public ResonanceRecipe read(PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);
            inputs.replaceAll(ignored -> Ingredient.fromPacket(buf));

            Item output = buf.readItemStack().getItem();
            return ResonanceRecipe.forCodec(inputs, output);
        }

        @Override
        public void write(PacketByteBuf buf, ResonanceRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.write(buf);
            }

            buf.writeItemStack(recipe.getResult(null));
        }
    }
}