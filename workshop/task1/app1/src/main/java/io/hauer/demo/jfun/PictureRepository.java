package io.hauer.demo.jfun;

import lombok.AllArgsConstructor;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@AllArgsConstructor
public class PictureRepository extends Storage<Picture> {
    private final String filePath;

    @Override
    public void loadData() throws IOException {
        var lines = readLines(filePath);
        for (var line : lines) {
            var picture = new Picture();
            var values = line.split(";");
            var id = Long.parseLong(values[0]);
            picture.setPath(values[1]);
            data.put(id, picture);
        }
    }
}
