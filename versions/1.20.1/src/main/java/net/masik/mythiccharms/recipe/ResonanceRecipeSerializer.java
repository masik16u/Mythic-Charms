package net.masik.mythiccharms.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import net.masik.mythiccharms.MythicCharms;
import net.minecraft.item.Item;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ResonanceRecipeSerializer implements RecipeSerializer<ResonanceRecipe> {
    public static final ResonanceRecipeSerializer INSTANCE = new ResonanceRecipeSerializer();
    public static final String ID = "resonance_infusing";

    @Override
    public ResonanceRecipe read(Identifier id, PacketByteBuf buf) {
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

        buf.writeItemStack(recipe.getOutput(null));
    }

    public void write(ResonanceRecipe recipe, JsonObject json) {
        Consumer<String> logger = error -> MythicCharms.LOGGER.error("Failed to serialize ingredients %s".formatted(recipe.result), error);
        JsonArray ingredients = new JsonArray();
        recipe.getIngredients().stream().map(Ingredient::toJson).forEach(ingredients::add);
        json.add("ingredients", ingredients);
        json.add("result", Registries.ITEM.getCodec().encodeStart(JsonOps.INSTANCE, recipe.result).getOrThrow(false, logger));

    }

    @Override
    public ResonanceRecipe read(Identifier id, JsonObject json) {
        List<Ingredient> ingredients = new ArrayList<>();
        for (JsonElement element : json.getAsJsonArray("ingredients")) {
            Ingredient it = Ingredient.fromJson(element, false);
            if (!it.isEmpty()) ingredients.add(it);
        }
        Item result = JsonHelper.getItem(json,"result");
        return ResonanceRecipe.forCodec(ingredients, result);
    }
}
