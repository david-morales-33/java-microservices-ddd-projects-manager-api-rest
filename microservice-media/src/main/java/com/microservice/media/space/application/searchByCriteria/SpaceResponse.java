package com.microservice.media.space.application.searchByCriteria;

import com.microservice.media.shared.domain.bus.query.Response;
import com.microservice.media.space.domain.Space;
import com.microservice.media.space.domain.SpaceDTO;

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
