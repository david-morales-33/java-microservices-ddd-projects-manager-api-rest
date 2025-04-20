package com.microservice.media.space.application.find;

import com.microservice.media.shared.domain.bus.query.Response;
import com.microservice.media.space.domain.SpaceDTO;

public record SpaceResponse(SpaceDTO response) implements Response {
}
