package com.microservice.administrative.funcionality.domain;

import com.microservice.administrative.shared.domain.DateTest;

public final class FuncionalityCreationDateTest {
    public static FuncionalityCreationdate create(String value) {
        return new FuncionalityCreationdate(value);
    }

    public static FuncionalityCreationdate random() {
        return create(DateTest.random());
    }
}
