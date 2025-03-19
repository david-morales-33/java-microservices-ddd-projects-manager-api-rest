package com.microservice.media.post.domain;

import com.microservice.media.shared.domain.WordTest;

public final class PostContentTest {
    public static PostContent create(String value) {
        return new PostContent(value);
    }

    public static PostContent random() {
        return create(WordTest.random());
    }
}
