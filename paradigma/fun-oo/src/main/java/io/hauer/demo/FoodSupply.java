package io.hauer.demo;

import java.util.LinkedList;
import java.util.List;

import static io.hauer.demo.Food.Apple;
import static io.hauer.demo.Food.Bread;
import static io.hauer.demo.Food.Oat;

public class FoodSupply {
    private static final List<Food> SUPPLY = new LinkedList<>( //
            List.of(Apple, Oat, Bread, Oat, Bread, Apple, Oat, Oat, Apple, Apple, Apple, Bread, Bread));

    static Food getNext(){
        return SUPPLY.remove(0);
    }
}
