package com.dmx.administrative.space.application.searchByCriteria;

import com.dmx.administrative.space.domain.Space;
import com.dmx.administrative.space.domain.SpaceDTO;
import com.dmx.shared.domain.bus.query.Response;

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
