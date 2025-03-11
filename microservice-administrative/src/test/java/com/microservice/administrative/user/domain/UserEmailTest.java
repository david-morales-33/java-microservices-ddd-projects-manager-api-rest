package com.microservice.administrative.user.domain;

import com.microservice.administrative.shared.domain.EmailTest;

public final class UserEmailTest {
    public static UserEmail crate(String value) {
        return new UserEmail(value);
    }

    public static UserEmail random() {
        return crate(EmailTest.random());
    }
}
