package io.hauer.demo.jfun;

import cyclops.control.Option;
import lombok.AllArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
public class PictureService {
    private final Repository<Picture> repo;

    public Option<byte[]> getContent(final long id) {
        return Option
                .ofNullable(repo.get(id))
                .flatMap(picture -> picture.getContent().toMaybe());
    }
}
