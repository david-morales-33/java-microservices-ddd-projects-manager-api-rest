package com.microservice.media.post.domain;

import com.microservice.media.shared.domain.UuidTest;

public final class PostIdTest {
    public static PostId create(String id) {
        return new PostId(id);
    }

    public static PostId random() {
        return create(UuidTest.random());
    }
}
