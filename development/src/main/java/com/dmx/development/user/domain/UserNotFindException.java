package com.dmx.development.user.domain;

import com.dmx.development.shared.domain.UserId;

public class UserNotFindException extends RuntimeException {
    public UserNotFindException(UserId userId) {
        super(String.format("User <%s> not found", userId.value()));
    }
}
