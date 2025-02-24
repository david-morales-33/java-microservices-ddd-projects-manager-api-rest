package com.dmx.media.space.application.find;

import com.dmx.media.shared.domain.SpaceId;
import com.dmx.media.shared.domain.bus.query.QueryHandler;
import com.dmx.media.team.domain.SpaceNotFoundException;


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
