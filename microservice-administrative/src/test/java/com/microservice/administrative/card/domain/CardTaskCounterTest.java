package com.microservice.administrative.card.domain;

import com.microservice.administrative.shared.domain.IntegerTest;

public final class CardTaskCounterTest {
    public static CardTaskCounter create(Integer value) {
        return new CardTaskCounter(value);
    }

    public static CardTaskCounter random() {
        return create(IntegerTest.random());
    }
}
