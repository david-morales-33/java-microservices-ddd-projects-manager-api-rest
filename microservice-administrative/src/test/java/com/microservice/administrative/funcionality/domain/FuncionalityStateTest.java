package com.microservice.administrative.funcionality.domain;

import com.microservice.administrative.shared.domain.BooleanTest;

public final class FuncionalityStateTest {
    public static FuncionalityState create(Boolean value) {
        return new FuncionalityState(value);
    }

    public static FuncionalityState random() {
        return create(BooleanTest.random());
    }
}
