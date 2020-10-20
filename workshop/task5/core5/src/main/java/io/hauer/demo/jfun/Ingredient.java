package io.hauer.demo.jfun;

import lombok.Data;
import lombok.With;

@With
@Data
public class Ingredient {
    private final String quantity;
    private final String compound;
}
