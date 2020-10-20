package io.hauer.demo.jfun;

import cyclops.control.Option;
import cyclops.reactive.ReactiveSeq;

import java.util.function.Function;

public class RecipeTransformer {

    public static Function<RecipeService, ReactiveSeq<Ingredient>> loadIngredients(final long id) {
        return service -> service
                .get(id)
                .map(Recipe::getIngredients)
                .orElse(ReactiveSeq.empty());
    }

    public static Function<RecipeService, Option<Recipe>> updateIngredients(final long id,
            final ReactiveSeq<Ingredient> ingredients) {
        return service -> service
                .get(id)
                .map(recipe -> recipe.withIngredients(ingredients));
    }

    public static Function<RecipeService, Function<RecipeService, Option<Recipe>>> transformer(final long id,
            final Function<Ingredient, Ingredient> t) {
        return loadIngredients(id).andThen(ingredients -> updateIngredients(id, ingredients.map(t)));
    }
}

