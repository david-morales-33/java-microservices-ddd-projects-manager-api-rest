package com.dmx.administrative.space.domain;

import com.dmx.shared.domain.SpaceId;

import java.util.Optional;

public interface SpaceQueryRepository {
    Optional<Space> find(SpaceId spaceId);
}
