package io.hauer.demo.jfun;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.nio.file.Files;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled
public class LoadPictureTest extends AbstractTest {
    @Test
    void loadPastaPicture() throws Exception {
        final var content = Files.readAllBytes(ResourceUtils
                .getFile("classpath:pasta.jpg")
                .toPath());
        mvc
                .perform(get("/api/picture/1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().bytes(content));
    }
}
