package io.hauer.demo.jfun;

import lombok.AllArgsConstructor;

import java.util.NoSuchElementException;

@AllArgsConstructor
public class PictureService {
    private final PicturePort port;

    public byte[] getContent(final long id) {
        var picture = port.getPicture(id);

        if(picture == null) {
            throw new NoSuchElementException();
        }

        return port
                .getPicture(id)
                .getContent();
    }
}
