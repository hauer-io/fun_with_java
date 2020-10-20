package io.hauer.demo.jfun;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;

import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Component
public class Storage implements PicturePort {
    private final AppProperties properties;
    private final Map<Long, Picture> pictures = new HashMap<>();

    @PostConstruct
    public void loadData() throws IOException {
        loadFileData();
    }

    private List<String> readLines(final String path) throws IOException {
        return Files.readAllLines(ResourceUtils
                .getFile(path)
                .toPath());
    }

    private void loadFileData() throws IOException {
        var lines = readLines(properties.getFileStorage());
        for (var line : lines) {
            var picture = new Picture();
            var values = line.split(";");
            var id = Long.parseLong(values[0]);
            picture.setPath(values[1]);
            pictures.put(id, picture);
        }
    }

    @Override
    public Picture getPicture(long id) {
        return pictures.get(id);

    }
}
