package io.hauer.demo.jfun;

import cyclops.arrow.Kleisli;
import cyclops.control.Option;
import cyclops.reactive.ReactiveSeq;
import org.springframework.http.ResponseEntity;

import java.util.function.Function;

import static com.oath.cyclops.hkt.DataWitness.option;
import static cyclops.instances.control.OptionInstances.monad;

public class RecipeTransformer {
    private static final RecipeService service = new RecipeService(null);

    public static Kleisli<option, RecipeService, ReactiveSeq<Ingredient>> loadIngredients(final long id) {
        return Kleisli.of(monad(), service -> service
                .get(id)
                .map(Recipe::getIngredients));
    }

    public static Kleisli<option, RecipeService, Recipe> updateIngredients(final long id,
            final ReactiveSeq<Ingredient> ingredients) {
        return Kleisli.of(monad(), service -> service
                .get(id)
                .map(recipe -> recipe.withIngredients(ingredients)));
    }

    public static Kleisli<option, RecipeService, Recipe> transformer(final long id,
            final Function<Ingredient, Ingredient> t) {
        return loadIngredients(id).flatMapK(ingredients -> updateIngredients(id, ingredients.map(t)));
    }

    private static void test() {
        final var x = transformer(10, Function.identity()).apply(service);
        final var r = Option
                .narrowK(x)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .notFound()
                        .build());
    }
}

