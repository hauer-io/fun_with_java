package io.hauer.demo.jfun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@ConfigurationPropertiesScan
@SpringBootApplication
public class CookingBookApp {

    @Bean
    public PictureService pictureService(final PicturePort picturePort) {
        return new PictureService(picturePort);
    }

    public static void main(String[] args) {
        SpringApplication.run(CookingBookApp.class, args);
    }
}
