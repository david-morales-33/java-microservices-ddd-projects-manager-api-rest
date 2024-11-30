package com.dmx.administrative.team.domain;

import com.dmx.shared.exceptions.DomainException;

public final class SpaceNotFoundException extends DomainException {
    public SpaceNotFoundException(String value) {
        super(value);
    }
}
