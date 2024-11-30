package com.dmx.administrative.space.application.find;

import com.dmx.administrative.space.domain.Space;
import com.dmx.administrative.space.domain.SpaceQueryRepository;
import com.dmx.administrative.team.domain.SpaceNotFoundException;
import com.dmx.shared.domain.SpaceId;

import java.util.Optional;

public class SpaceFinder {

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
