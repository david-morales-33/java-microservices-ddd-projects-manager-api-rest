package com.microservice.media.user.domain;

import com.microservice.media.shared.domain.WordTest;

public final class UserNickNameTest {
    public static UserNickName create(String value) {
        return new UserNickName(value);
    }

    public static UserNickName random() {
        return create(WordTest.random());
    }
}
