package com.dmx.media.space.application.find;

import com.dmx.media.space.domain.Space;
import com.dmx.media.space.domain.SpaceQueryRepository;
import com.dmx.media.team.domain.SpaceNotFoundException;
import com.dmx.shared.domain.SpaceId;

import java.util.Optional;

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
