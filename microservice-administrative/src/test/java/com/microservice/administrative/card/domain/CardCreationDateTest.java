package com.microservice.administrative.card.domain;

import com.microservice.administrative.shared.domain.DateTest;

public final class CardCreationDateTest {
    public static CardCreationDate create(String value) {
        return new CardCreationDate(value);
    }

    public static CardCreationDate random() {
        return create(DateTest.random());
    }
}
