package com.microservice.administrative.board.domain;

import com.microservice.administrative.shared.domain.BooleanValueObject;

public final class BoardState extends BooleanValueObject {
    public BoardState(boolean value) {
        super(value);
    }
}
