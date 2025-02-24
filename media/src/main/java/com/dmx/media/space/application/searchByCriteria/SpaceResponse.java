package com.dmx.media.space.application.searchByCriteria;

import com.dmx.media.shared.domain.bus.query.Response;
import com.dmx.media.space.domain.Space;
import com.dmx.media.space.domain.SpaceDTO;

import java.util.ArrayList;
import java.util.List;

public final class SpaceResponse implements Response {
    private final List<SpaceDTO> response = new ArrayList<>();

    public SpaceResponse(List<Space> data) {
        data.forEach((elements) -> {
            this.response.add(elements.toPrimitives());
        });
    }

    public List<SpaceDTO> getResponse() {
        return this.response;
    }
}
