package io.hauer.demo.jfun;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RecipeTest extends AbstractTest {

    @Test
    void loadPasta() throws Exception {
        var content = "{\"title\":\"Pasta\",\"pictures\":[\"http://localhost:8080/api/picture/1\"]}";
        mvc
                .perform(get("/api/recipe/1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json(content));
    }
}
