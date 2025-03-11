package com.microservice.administrative.funcionality.domain;

import com.microservice.administrative.shared.domain.WordTest;

public final class FuncionalityNameTest {
    public static FuncionalityName create(String value) {
        return new FuncionalityName(value);
    }

    public static FuncionalityName random() {
        return create(WordTest.random());
    }
}
