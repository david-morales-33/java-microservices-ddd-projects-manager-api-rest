package com.dmx.media.team.domain;

import com.dmx.shared.exceptions.DomainException;

public final class SpaceNotValidException extends DomainException {
    public SpaceNotValidException(String value) {
        super(value);
    }
}
