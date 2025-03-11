package com.microservice.administrative.user.domain;

import com.microservice.administrative.shared.domain.UserId;
import com.microservice.administrative.shared.domain.UuidTest;

public final class UserIdTest {
    public static UserId create(String value) {
        return new UserId(value);
    }

    public static UserId random() {
        return create(UuidTest.random());
    }
}
