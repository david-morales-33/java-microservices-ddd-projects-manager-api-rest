package com.microservice.administrative.card.domain;

import com.microservice.administrative.shared.domain.CardId;

import java.util.UUID;

public final class CardIdTest {
    public static CardId create(String value) {
        return new CardId(value);
    }

    public static CardId random() {
        return create(UUID.randomUUID().toString());
    }
}
