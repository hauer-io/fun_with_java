package io.hauer.demo.jfun;

import cyclops.reactive.IO;
import cyclops.reactive.ReactiveSeq;
import lombok.Data;
import lombok.With;

import java.util.List;

@With
@Data
public class Recipe {
    private final String title;
    private final String description;
    private final ReactiveSeq<Ingredient> ingredients;
    private final ReactiveSeq<String> pictures;
}
