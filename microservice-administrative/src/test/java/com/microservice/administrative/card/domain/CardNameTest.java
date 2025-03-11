package com.microservice.administrative.card.domain;

import com.microservice.administrative.shared.domain.WordTest;

public final class CardNameTest {
    public static CardName create(String value) {
        return new CardName(value);
    }

    public static CardName random() {
        return create(WordTest.random());
    }
}
