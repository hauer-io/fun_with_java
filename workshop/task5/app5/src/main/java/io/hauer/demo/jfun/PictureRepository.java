package io.hauer.demo.jfun;

import cyclops.reactive.ReactiveSeq;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class PictureRepository extends Storage<Picture> {
    private final String filePath;


    @Override
    ReactiveSeq<String> getLines() throws IOException {
        return readLines(filePath);
    }

    @Override
    public Map<Long, Picture> loadData(final ReactiveSeq<String> lines) {
        return lines
                .map(line -> line.split(";"))
                .collect(Collectors.toMap(this::getId, this::getPicture));

    }

    private Picture getPicture(final String[] values) {
        return new Picture(values[1]);
    }

    private Long getId(final String[] values){
        return Long.parseLong(values[0]);
    }

}
