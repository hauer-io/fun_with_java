package io.hauer.demo;

import cyclops.data.ImmutableList;
import cyclops.data.Vector;

public class Stomach {
    final ImmutableList<Food> content;

    Stomach() {
        this(Vector.of());
    }

    Stomach(final ImmutableList<Food> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content.toString();
    }
}
