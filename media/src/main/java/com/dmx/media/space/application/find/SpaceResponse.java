package com.dmx.media.space.application.find;

import com.dmx.media.space.domain.SpaceDTO;
import com.dmx.shared.domain.bus.query.Response;

public final class SpaceResponse implements Response {
    private final SpaceDTO response;

    public SpaceResponse(SpaceDTO response) {
        this.response = response;
    }

    public SpaceDTO getResponse() {
        return this.response;
    }
}
