package io.hauer.demo.jfun;

import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.NoSuchElementException;

@AllArgsConstructor
public class RecipeService {
    private final Repository<Recipe> repo;

    public Recipe get(final long id) {
        var recipe = repo.get(id);

        if (recipe == null) {
            throw new NoSuchElementException();
        }

        return recipe;
    }

    public Collection<Recipe> getAll() {
        return repo.getAll();
    }

}
