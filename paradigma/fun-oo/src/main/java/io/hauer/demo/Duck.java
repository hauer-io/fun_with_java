package io.hauer.demo;

public class Duck {
    private final String name;
    private final Stomach stomach;

    public Duck(final String name, final Stomach stomach) {
        this.name = name;
        this.stomach = stomach;
    }

    Duck eatF(final Food food){
        return new Duck(name, stomach.add(food));
    }

    @Override
    public String toString() {
        return "Duck{" + "name='" + name + '\'' + ", stomach=" + stomach + '}';
    }
}
