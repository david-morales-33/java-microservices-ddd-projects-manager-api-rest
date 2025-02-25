package com.microservice.media.space.application.find;

import com.microservice.media.shared.domain.bus.query.Response;
import com.microservice.media.space.domain.SpaceDTO;

public final class SpaceResponse implements Response {
    private final SpaceDTO response;

    public SpaceResponse(SpaceDTO response) {
        this.response = response;
    }

    public SpaceDTO getResponse() {
        return this.response;
    }
}
