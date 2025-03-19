package com.microservice.media.user.domain;

import com.microservice.media.shared.domain.WordTest;

public final class UserNameTest {
    public static UserName create(String value) {
        return new UserName(value);
    }

    public static UserName random() {
        return create(WordTest.random());
    }
}
