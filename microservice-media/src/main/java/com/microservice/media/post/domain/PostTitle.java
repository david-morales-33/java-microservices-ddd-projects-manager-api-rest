package com.microservice.media.post.domain;

import com.microservice.media.shared.domain.StringValueObject;

public final class PostTitle extends StringValueObject {
    public PostTitle(String value) {
        super(value);
    }

    private PostTitle() {
        super(null);
    }
}
