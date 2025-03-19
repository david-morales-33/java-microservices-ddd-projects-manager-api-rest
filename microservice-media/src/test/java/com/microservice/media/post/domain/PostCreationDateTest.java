package com.microservice.media.post.domain;

import com.microservice.media.shared.domain.DateTest;

public final class PostCreationDateTest {
    public static PostCreationDate create(String value) {
        return new PostCreationDate(value);
    }

    public static PostCreationDate random() {
        return create(DateTest.random());
    }
}
