package com.microservice.administrative.funcionality.domain;

import com.microservice.administrative.shared.domain.WordTest;

public final class FuncionalityDescriptionTest {
    public static FuncionalityDescription create(String value) {
        return new FuncionalityDescription(value);
    }

    public static FuncionalityDescription random() {
        return create(WordTest.random());
    }
}
