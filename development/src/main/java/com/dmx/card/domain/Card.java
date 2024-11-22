package com.dmx.card.domain;

public class Card {
    private final CardId id;
    private final CardName name;
    private final CardDescription description;

    public Card(
            CardId id,
            CardName name,
            CardDescription description
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public CardId getId() {
        return id;
    }

    public CardName getName() {
        return name;
    }

    public CardDescription getDescription() {
        return description;
    }

    public static Card create(
            CardId id,
            CardName name,
            CardDescription description
    ){
        return new Card(id, name, description);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name=" + name +
                ", description=" + description +
                '}';
    }
}
