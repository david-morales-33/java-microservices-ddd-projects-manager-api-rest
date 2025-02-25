package com.microservice.media.user.domain;

import com.microservice.media.shared.domain.UserId;

public final class UserNotFindException extends RuntimeException {
    public UserNotFindException(UserId userId) {
        super(String.format("User <%s> not found", userId.value()));
    }
}
