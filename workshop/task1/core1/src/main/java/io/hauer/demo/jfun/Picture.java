package io.hauer.demo.jfun;

import cyclops.control.LazyEither;
import cyclops.control.Try;
import lombok.Data;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;

@Data
public class Picture {
    private String path;
    private LazyEither<String, byte[]> content = loadContent();

    private LazyEither<String, byte[]> loadContent() {
        return Try
                .withCatch(this::readPath)
                .toLazyEither()
                .mapLeft(Throwable::getLocalizedMessage);
    }

    private byte[] readPath() throws IOException {
        return Files.readAllBytes(ResourceUtils
                .getFile(path)
                .toPath());
    }
}
