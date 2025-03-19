package com.microservice.media.post.domain;

import com.microservice.media.shared.domain.WordTest;

public final class PostTitleTest {
    public static PostTitle create(String value) {
        return new PostTitle(value);
    }

    public static PostTitle random() {
        return create(WordTest.random());
    }
}
