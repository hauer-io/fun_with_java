package io.hauer.demo.jfun;

import lombok.Data;

import java.util.List;

@Data
public class Recipe {
    private String title;
    private String description;
    private List<Ingredient> ingredients;
    private List<String> pictures;
}
