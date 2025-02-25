package com.microservice.administrative.user.domain;

import com.microservice.administrative.shared.domain.UserId;

public class UserNotFindException extends RuntimeException {
    public UserNotFindException(UserId userId) {
        super(String.format("User <%s> not found", userId.value()));
    }
}
