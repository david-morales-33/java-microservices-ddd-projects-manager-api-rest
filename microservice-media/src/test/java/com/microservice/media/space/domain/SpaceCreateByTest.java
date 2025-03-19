package com.microservice.media.space.domain;

import com.microservice.media.user.domain.UserIdTest;

public final class SpaceCreateByTest {
    public static SpaceCreateBy create(String value){
        return new SpaceCreateBy(value);
    }

    public static SpaceCreateBy random(){
        return create(UserIdTest.random().value());
    }
}
