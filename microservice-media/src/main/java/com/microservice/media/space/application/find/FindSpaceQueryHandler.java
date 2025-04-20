package com.microservice.media.space.application.find;

import com.microservice.media.shared.domain.Service;
import com.microservice.media.shared.domain.SpaceId;
import com.microservice.media.shared.domain.bus.query.QueryHandler;
import com.microservice.media.team.domain.SpaceNotFoundException;

@Service
final public class FindSpaceQueryHandler implements QueryHandler<FindSpaceQuery, SpaceResponse> {
    private final SpaceFinder finder;

    public FindSpaceQueryHandler(SpaceFinder finder) {
        this.finder = finder;
    }

    @Override
    public SpaceResponse handle(FindSpaceQuery query) throws SpaceNotFoundException {
        SpaceId spaceId = new SpaceId(query.getSpaceId());
        return this.finder.execute(spaceId);
    }
}
