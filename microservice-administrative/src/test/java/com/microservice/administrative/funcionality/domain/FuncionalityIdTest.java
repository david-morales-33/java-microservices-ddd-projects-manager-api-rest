package com.microservice.administrative.funcionality.domain;

import com.microservice.administrative.shared.domain.FuncionalityId;
import com.microservice.administrative.shared.domain.IntegerTest;

public final class FuncionalityIdTest {
    public static FuncionalityId create(Integer value) {
        return new FuncionalityId(value);
    }

    public static FuncionalityId random() {
        return create(IntegerTest.random());
    }
}
