package io.hauer.demo;

public class Duck {
    private final String name;
    private final Stomach stomach;

    public Duck(final String name, final Stomach stomach) {
        this.name = name;
        this.stomach = stomach;
    }

    void eat(final Food food){
        stomach.add(food);
    }

    @Override
    public String toString() {
        return "Duck{" + "name='" + name + '\'' + ", stomach=" + stomach + '}';
    }
}
