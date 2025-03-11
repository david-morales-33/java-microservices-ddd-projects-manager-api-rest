package com.microservice.administrative.user.domain;

import com.microservice.administrative.shared.domain.WordTest;

public final class UserNameTest {
    public static UserName create(String value) {
        return new UserName(value);
    }

    public static UserName random() {
        return create(WordTest.random());
    }
}
