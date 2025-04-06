package com.microservice.development.user.domain;

import com.microservice.development.shared.domain.StringValueObject;

public final class UserNickName extends StringValueObject {
    public UserNickName(String value) {
        super(value);
    }
    private UserNickName() {
        super(null);
    }
}
