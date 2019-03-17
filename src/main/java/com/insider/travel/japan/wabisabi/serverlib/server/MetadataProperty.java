package com.insider.travel.japan.wabisabi.serverlib.server;

import java.util.Optional;

public class MetadataProperty<T> {

    private final Optional<T> value;

    private final T defaultValue;

    public MetadataProperty(T value, T defaultValue) {
        this.value = Optional.ofNullable(value);
        this.defaultValue = defaultValue;
    }

    public T get() {
        return value.orElse(defaultValue);
    }

}
