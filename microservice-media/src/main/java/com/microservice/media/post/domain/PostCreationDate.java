package com.microservice.media.post.domain;

import com.microservice.media.shared.domain.StringValueObject;

public final class PostCreationDate extends StringValueObject {
    public PostCreationDate(String value) {
        super(value);
    }

    private PostCreationDate() {
        super(null);
    }
}
