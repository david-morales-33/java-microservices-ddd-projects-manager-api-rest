package com.dmx.administrative.team.domain;

import com.dmx.shared.exceptions.DomainException;

public final class UserNotValidException extends DomainException {
    public UserNotValidException(String value) {
        super(value);
    }
}
