package io.hauer.demo;

import java.util.LinkedList;
import java.util.List;

public class Stomach {
    final List<Food> content = new LinkedList<>();

    @Override
    public String toString() {
        return content.toString();
    }
}
