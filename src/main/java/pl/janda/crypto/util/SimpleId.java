package pl.janda.crypto.util;

import java.io.Serializable;
import java.util.Objects;

public abstract class SimpleId<T> implements Serializable {

    private final T internal;

    protected SimpleId(T internal) {
        this.internal = internal;
    }

    public T getInternal() {
        return internal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleId<?> simpleId = (SimpleId<?>) o;
        return Objects.equals(internal, simpleId.internal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(internal);
    }
}
