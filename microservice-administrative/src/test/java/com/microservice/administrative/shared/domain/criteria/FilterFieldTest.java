package com.microservice.administrative.shared.domain.criteria;

import com.microservice.administrative.shared.domain.WordTest;

public final class FilterFieldTest {
    public static FilterField random() {
        return new FilterField(WordTest.random());
    }
}
