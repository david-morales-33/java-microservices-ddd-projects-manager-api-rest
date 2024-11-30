package com.dmx.administrative.space.application.find;

import com.dmx.administrative.space.domain.SpaceDTO;
import com.dmx.shared.domain.bus.query.Response;

public class SpaceResponse implements Response {
    private final SpaceDTO response;

    public SpaceResponse(SpaceDTO response) {
        this.response = response;
    }

    public SpaceDTO getResponse() {
        return this.response;
    }
}
