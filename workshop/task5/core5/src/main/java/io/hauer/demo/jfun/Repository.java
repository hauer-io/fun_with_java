package io.hauer.demo.jfun;

import java.util.Collection;

public interface Repository<T> {
    T get(final long id);

    void delete(final long id);

    void put(final long id, final T value);

    void create(final T value);

    boolean exists(final long id);

    Collection<T> getAll();
}
