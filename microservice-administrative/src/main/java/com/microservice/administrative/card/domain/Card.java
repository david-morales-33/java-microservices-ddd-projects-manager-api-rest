package com.microservice.administrative.card.domain;

import com.microservice.administrative.shared.domain.AggregateRoot;
import com.microservice.administrative.shared.domain.CardId;

public final class Card extends AggregateRoot {
    private final CardId id;
    private final CardName name;
    private final CardCreationDate creationDate;

    public Card(CardId id, CardName name, CardCreationDate creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }

    public static Card fromPrimitives(CardDTO data) {
        return new Card(
                new CardId(data.id()),
                new CardName(data.name()),
                new CardCreationDate(data.CreationDate())
        );
    }

    public CardDTO toPrimitives() {
        return new CardDTO(
                this.id.value(),
                this.name.value(),
                this.creationDate.value()
        );
    }

    public CardId getId() {
        return this.id;
    }

    public CardName getName() {
        return this.name;
    }

    public CardCreationDate getCreationDate() {
        return this.creationDate;
    }
}
