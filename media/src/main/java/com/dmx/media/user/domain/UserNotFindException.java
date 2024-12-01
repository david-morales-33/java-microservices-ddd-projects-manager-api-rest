package com.dmx.media.user.domain;

import com.dmx.shared.domain.UserId;

public final class UserNotFindException extends RuntimeException {
    public UserNotFindException(UserId userId) {
        super(String.format("User <%s> not found", userId.value()));
    }
}
