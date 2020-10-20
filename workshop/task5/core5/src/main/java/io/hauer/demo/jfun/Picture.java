package io.hauer.demo.jfun;

import cyclops.control.Maybe;
import cyclops.control.Try;
import lombok.Data;
import org.springframework.util.ResourceUtils;

import java.nio.file.Files;

@Data
public class Picture {
    private final String path;
    private final Maybe<byte[]> content = Try.withCatch(this::loadBytes).toMaybe();

    private byte[] loadBytes() throws Throwable {
        return Files.readAllBytes(ResourceUtils
                .getFile(path)
                .toPath());
    }
}
