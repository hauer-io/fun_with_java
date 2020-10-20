package io.hauer.demo.jfun;

import cyclops.reactive.ReactiveSeq;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RecipeRepository extends Storage<Recipe> {
    private final String filePath;

    @Override
    ReactiveSeq<String> getLines() throws IOException {
        return readLines(filePath);
    }

    @Override
    public Map<Long, Recipe> loadData(final ReactiveSeq<String> lines) {
        return lines
                .map(line -> line.split(";"))
                .collect(Collectors.toMap(this::getId, this::getRecipes));

    }

    private ReactiveSeq<Ingredient> getIngredients(final String values) {
        return ReactiveSeq
                .of(values.split(","))
                .map(value -> value.split(":"))
                .map(pair -> new Ingredient(pair[0], pair[1]));
    }

    private ReactiveSeq<String> getRecipes(final String values) {
        return ReactiveSeq
                .of(values.split(","))
                .map(id -> "http://localhost:8080/api/picture/" + id);
    }

    private Recipe getRecipes(final String[] values) {
        return new Recipe(values[1], values[2], getIngredients(values[3]), getRecipes(values[4]));
    }

    private Long getId(final String[] values){
        return Long.parseLong(values[0]);
    }
}
