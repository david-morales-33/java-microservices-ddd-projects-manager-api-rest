package com.dmx.media.space.domain;

import java.util.List;
import java.util.Optional;

import com.dmx.media.shared.domain.SpaceId;
import com.dmx.media.shared.domain.criteria.Criteria;

public interface SpaceQueryRepository {
    Optional<Space> find(SpaceId spaceId);
    List<Space> match(Criteria criteria);
}
