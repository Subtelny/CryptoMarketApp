package pl.janda.crypto.util;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class CompoundId extends SimpleId<String> {

    private static final String SEPARATOR = "@";

    public CompoundId(String internal) {
        super(internal);
    }

    public CompoundId(Object... values) {
        this(make(values));
    }

    private static String make(Object... values) {
        return Arrays.stream(values).map(Object::toString).collect(Collectors.joining(SEPARATOR));
    }

    protected String getValueAtPosition(int position) {
        return getInternal().split(SEPARATOR)[position];
    }

}
