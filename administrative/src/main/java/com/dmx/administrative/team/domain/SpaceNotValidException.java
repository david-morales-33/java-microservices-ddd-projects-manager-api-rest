package com.dmx.administrative.team.domain;

import com.dmx.shared.exceptions.DomainException;

public class SpaceNotValidException extends DomainException {
    public SpaceNotValidException(String value) {
        super(value);
    }
}
