package net.masik.mythiccharms.recipe;

import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.masik.mythiccharms.MythicCharms;
import net.minecraft.item.Item;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeCodecs;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.dynamic.Codecs;

import java.util.List;
import java.util.function.Consumer;

public class ResonanceRecipeSerializer implements RecipeSerializer<ResonanceRecipe> {
    public static final ResonanceRecipeSerializer INSTANCE = new ResonanceRecipeSerializer();
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

    public void write(ResonanceRecipe recipe, JsonObject json) {
        Consumer<String> logger = error -> MythicCharms.LOGGER.error("Failed to serialize ingredients %s".formatted(recipe.result), error);
        JsonOps jsonOps = JsonOps.INSTANCE;

        json.add("ingredients", ResonanceRecipeSerializer.validateAmount(Ingredient.DISALLOW_EMPTY_CODEC, 5).encodeStart(jsonOps, recipe.getIngredients()).getOrThrow(false, logger));
        json.add("result", RecipeCodecs.CRAFTING_RESULT_ITEM.encodeStart(jsonOps, recipe.result).getOrThrow(false, logger));
    }
}
