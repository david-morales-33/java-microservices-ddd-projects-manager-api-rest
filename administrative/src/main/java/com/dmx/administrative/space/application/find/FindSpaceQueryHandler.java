package com.dmx.administrative.space.application.find;

import com.dmx.administrative.space.domain.SpaceQueryRepository;
import com.dmx.administrative.team.domain.SpaceNotFoundException;
import com.dmx.shared.domain.SpaceId;
import com.dmx.shared.domain.bus.query.QueryHandler;

public class FindSpaceQueryHandler implements QueryHandler<FindSpaceQuery, SpaceResponse> {
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
