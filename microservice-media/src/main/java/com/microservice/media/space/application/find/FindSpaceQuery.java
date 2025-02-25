package com.microservice.media.space.application.find;

import com.microservice.media.shared.domain.bus.query.Query;

public final class FindSpaceQuery implements Query {
    private final String spaceId;

    public FindSpaceQuery(String spaceId) {
        this.spaceId = spaceId;
    }

    public String getSpaceId() {
        return this.spaceId;
    }
}
