package com.nnk.springboot.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.util.Optional;

@UtilityClass
public class OptionalUtils {

    @SneakyThrows
    public <T> T optionally(Optional<T> optional, Class<? extends RuntimeException> runtimeException) {
        if (optional.isPresent()) {
            return optional.get();
        }
        throw runtimeException.getConstructor().newInstance();
    }

}
