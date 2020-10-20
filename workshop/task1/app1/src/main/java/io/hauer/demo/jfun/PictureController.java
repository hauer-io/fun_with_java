package io.hauer.demo.jfun;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/api/picture")
@AllArgsConstructor
public class PictureController {

    private final PictureService service;

    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> get(@PathVariable final long id) {
        return ResponseEntity.ok(service.getContent(id));
    }

    @ExceptionHandler({ NoSuchElementException.class, IOException.class })
    public ResponseEntity<Picture> handleNoSucheElement() {
        return ResponseEntity
                .notFound()
                .build();
    }

}
