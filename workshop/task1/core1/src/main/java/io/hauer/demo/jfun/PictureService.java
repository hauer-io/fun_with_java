package io.hauer.demo.jfun;

import cyclops.control.Either;
import cyclops.control.Option;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PictureService {
    private final PicturePort port;

    public Either<String, byte[]> getContent(final long id) {
        return Option
                .ofNullable(port.getPicture(id))
                .toEither("Kein Bild gefunden")
                .flatMap(Picture::getContent);
    }
}
