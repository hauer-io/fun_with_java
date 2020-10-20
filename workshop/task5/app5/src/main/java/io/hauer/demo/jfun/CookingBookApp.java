package io.hauer.demo.jfun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@ConfigurationPropertiesScan
@SpringBootApplication
public class CookingBookApp {

    @Bean
    public Repository<Picture> pictureRepository(final AppProperties properties) {
        return new PictureRepository(properties.getFileStorage());
    }

    @Bean
    public PictureService pictureService(final Repository<Picture> pictureRepository) {
        return new PictureService(pictureRepository);
    }

    @Bean
    public Repository<Recipe> recipeRepository(final AppProperties properties) {
        return new RecipeRepository(properties.getRecipeStorage());
    }

    @Bean
    public RecipeService recipeService(final Repository<Recipe> recipeRepository) {
        return new RecipeService(recipeRepository);
    }

    public static void main(String[] args) {
        SpringApplication.run(CookingBookApp.class, args);
    }
}
