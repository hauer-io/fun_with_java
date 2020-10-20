package io.hauer.demo.jfun;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "io.hauer.demo.jfun")
public class AppProperties {
    private String fileStorage = "classpath:file.data";
    private String recipeStorage = "classpath:recipe.data";
}
