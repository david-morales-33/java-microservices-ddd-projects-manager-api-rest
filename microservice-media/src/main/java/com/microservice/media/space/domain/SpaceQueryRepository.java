package com.microservice.media.space.domain;

import java.util.List;
import java.util.Optional;

import com.microservice.media.shared.domain.SpaceId;
import com.microservice.media.shared.domain.criteria.Criteria;

public interface SpaceQueryRepository {
    Optional<Space> find(SpaceId spaceId);
    List<Space> match(Criteria criteria);
}
