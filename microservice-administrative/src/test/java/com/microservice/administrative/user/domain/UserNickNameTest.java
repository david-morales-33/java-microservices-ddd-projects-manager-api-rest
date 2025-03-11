package com.microservice.administrative.user.domain;

import com.microservice.administrative.shared.domain.WordTest;

public final class UserNickNameTest {
    public static UserNickName create(String value) {
        return new UserNickName(value);
    }

    public static UserNickName random() {
        return create(WordTest.random());
    }
}
