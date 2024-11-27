package com.dmx.administrative.team.domain;

import com.dmx.shared.exceptions.DomainException;

public class SpaceNotFoundException extends DomainException {
    public SpaceNotFoundException(String value) {
        super(value);
    }
}
