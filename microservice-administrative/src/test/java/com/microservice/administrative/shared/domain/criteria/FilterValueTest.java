package com.microservice.administrative.shared.domain.criteria;

import com.microservice.administrative.shared.domain.WordTest;

public final class FilterValueTest {
    public static FilterValue random() {
        return new FilterValue(WordTest.random());
    }
}
