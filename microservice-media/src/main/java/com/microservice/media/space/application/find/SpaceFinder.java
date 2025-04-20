package com.microservice.media.space.application.find;

import com.microservice.media.shared.domain.Service;
import com.microservice.media.shared.domain.SpaceId;
import com.microservice.media.space.domain.Space;
import com.microservice.media.space.domain.SpaceQueryRepository;
import com.microservice.media.team.domain.SpaceNotFoundException;

import java.util.Optional;

@Service
public final class SpaceFinder {

    private final SpaceQueryRepository queryRepository;

    public SpaceFinder(SpaceQueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    public SpaceResponse execute(SpaceId spaceId) throws SpaceNotFoundException {
        Optional<Space> response = this.queryRepository.find(spaceId);
        if (response.isEmpty()) throw new SpaceNotFoundException(spaceId.value());
        Space space = response.get();
        return new SpaceResponse(space.toPrimitives());
    }
}
