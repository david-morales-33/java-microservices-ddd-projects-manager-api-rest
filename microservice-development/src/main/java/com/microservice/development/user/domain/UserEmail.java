package com.microservice.development.user.domain;

import com.microservice.development.shared.domain.StringValueObject;

public final class UserEmail extends StringValueObject {
    public UserEmail(String value) {
        super(value);
    }
    private UserEmail() {
        super(null);
    }
}
