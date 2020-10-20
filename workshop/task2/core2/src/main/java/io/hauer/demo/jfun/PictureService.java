package io.hauer.demo.jfun;

import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.NoSuchElementException;

@AllArgsConstructor
public class PictureService {
    private final Repository<Picture> repo;

    public byte[] getContent(final long id) {
        var picture = repo.get(id);

        if(picture == null) {
            throw new NoSuchElementException();
        }

        return repo
                .get(id)
                .getContent();
    }
}
