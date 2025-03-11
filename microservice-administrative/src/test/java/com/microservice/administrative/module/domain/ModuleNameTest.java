package com.microservice.administrative.module.domain;

import com.microservice.administrative.shared.domain.WordTest;

public final class ModuleNameTest {
    public static ModuleName create(String value) {
        return new ModuleName(value);
    }

    public static ModuleName random() {
        return create(WordTest.random());
    }
}
