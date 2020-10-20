package io.hauer.demo;

import cyclops.data.ImmutableList;
import cyclops.data.Vector;

public class Stomach {
    private final ImmutableList<Food> content;

    Stomach() {
        this(Vector.of());
    }

    Stomach(final ImmutableList<Food> content) {
        this.content = content;
    }

    Stomach add(final Food food) {
        return new Stomach(content.append(food));
    }

    @Override
    public String toString() {
        return content.toString();
    }
}
