package io.hauer.demo.jfun;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;

public abstract class Storage<T> implements Repository<T>, InitializingBean {
    final Map<Long, T> data = new HashMap<>();

    abstract void loadData() throws IOException;

    @Override
    public T get(long id) {
        return data.get(id);
    }

    @Override
    public void delete(long id) {
        data.remove(id);
    }

    @Override
    public void put(long id, T value) {
        data.put(id, value);
    }

    @Override
    public void create(T value) {
        put(nextFreeId(), value);
    }

    @Override
    public Collection<T> getAll() {
        return data.values();
    }

    @Override
    public boolean exists(long id) {
        return data.containsKey(id);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        loadData();
    }

    static List<String> readLines(final String filePath) throws IOException {
        return Files.readAllLines(ResourceUtils
                .getFile(filePath)
                .toPath());
    }

    private Long nextFreeId() {
        return LongStream
                .iterate(1, it -> it + 1)
                .filter(it -> !data.containsKey(it))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No free id found"));
    }
}
