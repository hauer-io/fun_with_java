package io.hauer.demo.jfun;

import cyclops.control.Eval;
import lombok.Data;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.util.function.Supplier;

@Data
public class Picture {
    private final String path;
    private final Eval<byte[]> content = Eval.later(this::loadContent);

    public byte[] getContent() {
        return content.get();
    }

    private byte[] loadContent() {
        try {
            return Files.readAllBytes(ResourceUtils
                    .getFile(path)
                    .toPath());
        } catch (IOException ioException) {
            return null;
        }
    }
}
