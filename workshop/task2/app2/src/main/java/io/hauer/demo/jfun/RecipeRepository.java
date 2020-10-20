package io.hauer.demo.jfun;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.LinkedList;

@AllArgsConstructor
public class RecipeRepository extends Storage<Recipe> {
    private final String filePath;

    @Override
    public void loadData() throws IOException {
        var lines = readLines(filePath);
        for (var line : lines) {
            var recipe = new Recipe();
            var values = line.split(";");
            var id = Long.parseLong(values[0]);
            recipe.setTitle(values[1]);
            recipe.setDescription(values[2]);
            var ingredients = new LinkedList<Ingredient>();
            var ingredientsValues = values[3].split(",");
            for (var ingredientsValue : ingredientsValues) {
                var quantityCompound = ingredientsValue.split(":");
                var ingredient = new Ingredient();
                ingredient.setQuantity(quantityCompound[0]);
                ingredient.setCompound(quantityCompound[1]);
                ingredients.add(ingredient);
            }
            recipe.setIngredients(ingredients);
            var pictures = new LinkedList<String>();
            var pictureValues = values[4].split(",");
            for (var pictureValue : pictureValues) {
                pictures.add("http://localhost:8080/api/picture/" + pictureValue);
            }
            recipe.setPictures(pictures);
            data.put(id, recipe);
        }
    }
}
