package io.hauer.demo.jfun;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Controller
@RequestMapping("/api/recipe")
public class RecipeController {

    private final RecipeService service;

    @GetMapping
    public ResponseEntity<Collection<Recipe>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> get(@PathVariable final long id) {
        return service.get(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Recipe> handleNoSucheElement() {
        return ResponseEntity
                .notFound()
                .build();
    }
}
