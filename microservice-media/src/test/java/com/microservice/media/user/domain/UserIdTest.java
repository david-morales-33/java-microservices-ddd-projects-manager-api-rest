package com.microservice.media.user.domain;


import com.microservice.media.shared.domain.UserId;
import com.microservice.media.shared.domain.UuidTest;

public final class UserIdTest {
    public static UserId create(String value) {
        return new UserId(value);
    }

    public static UserId random() {
        return create(UuidTest.random());
    }
}
