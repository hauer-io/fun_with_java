package io.hauer.demo.jfun;

import cyclops.control.Option;
import lombok.AllArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
public class RecipeService {
    private final Repository<Recipe> repo;

    public Option<Recipe> get(final long id) {
        return Option.ofNullable(repo.get(id));
    }

    public Collection<Recipe> getAll() {
        return repo.getAll();
    }
}