package com.microservice.administrative.card.domain;

import com.microservice.administrative.shared.domain.CardId;

public final class CardTest {
    public static Card create(CardId id, CardName name, CardCreationDate creationDate) {
        return new Card(id, name, creationDate);
    }

    public static Card random() {
        return create(CardIdTest.random(), CardNameTest.random(), CardCreationDateTest.random());
    }
}
