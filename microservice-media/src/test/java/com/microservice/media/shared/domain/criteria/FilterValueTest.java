package com.microservice.media.shared.domain.criteria;

import com.microservice.media.shared.domain.WordTest;

public final class FilterValueTest {
    public static FilterValue random() {
        return new FilterValue(WordTest.random());
    }
}
