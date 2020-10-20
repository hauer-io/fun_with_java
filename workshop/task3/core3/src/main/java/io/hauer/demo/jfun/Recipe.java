package io.hauer.demo.jfun;

import lombok.Data;

import java.util.List;

@Data
public class Recipe {
    private final String title;
    private final String description;
    private final List<Ingredient> ingredients;
    private final List<String> pictures;
}
