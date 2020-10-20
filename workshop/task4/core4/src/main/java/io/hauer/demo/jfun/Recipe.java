package io.hauer.demo.jfun;

import cyclops.reactive.ReactiveSeq;
import lombok.Data;

import java.util.List;

@Data
public class Recipe {
    private final String title;
    private final String description;
    private final ReactiveSeq<Ingredient> ingredients;
    private final ReactiveSeq<String> pictures;
}
