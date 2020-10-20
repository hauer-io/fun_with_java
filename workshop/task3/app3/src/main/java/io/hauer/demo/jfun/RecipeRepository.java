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
            var values = line.split(";");
            var id = Long.parseLong(values[0]);
            var ingredients = new LinkedList<Ingredient>();
            var ingredientsValues = values[3].split(",");
            for (var ingredientsValue : ingredientsValues) {
                var quantityCompound = ingredientsValue.split(":");
                var ingredient = new Ingredient(quantityCompound[0],quantityCompound[1]);
                ingredients.add(ingredient);
            }
            var pictures = new LinkedList<String>();
            var pictureValues = values[4].split(",");
            for (var pictureValue : pictureValues) {
                pictures.add("http://localhost:8080/api/picture/" + pictureValue);
            }
            var recipe = new Recipe(values[1], values[2], ingredients, pictures);
            data.put(id, recipe);
        }
    }
}
