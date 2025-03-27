package com.microservice.media.shared.domain.criteria;

import com.microservice.media.shared.domain.WordTest;

public final class FilterFieldTest {
    public static FilterField random() {
        return new FilterField(WordTest.random());
    }
}
