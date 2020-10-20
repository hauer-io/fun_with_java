package io.hauer.demo;

public class Duck {
    String name;
    Stomach stomach;

    public Duck(final String name, final Stomach stomach) {
        this.name = name;
        this.stomach = stomach;
    }

    @Override
    public String toString() {
        return "Duck{" + "name='" + name + '\'' + ", stomach=" + stomach + '}';
    }
}
