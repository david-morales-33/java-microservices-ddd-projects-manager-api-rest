package com.dmx.media.space.domain;

import com.dmx.shared.domain.SpaceId;
import com.dmx.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface SpaceQueryRepository {
    Optional<Space> find(SpaceId spaceId);
    List<Space> match(Criteria criteria);
}
