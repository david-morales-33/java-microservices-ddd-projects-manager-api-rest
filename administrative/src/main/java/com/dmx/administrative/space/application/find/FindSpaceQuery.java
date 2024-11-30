package com.dmx.administrative.space.application.find;

import com.dmx.shared.domain.bus.query.Query;

public class FindSpaceQuery implements Query {
    private final String spaceId;

    public FindSpaceQuery(String spaceId) {
        this.spaceId = spaceId;
    }

    public String getSpaceId() {
        return this.spaceId;
    }
}
