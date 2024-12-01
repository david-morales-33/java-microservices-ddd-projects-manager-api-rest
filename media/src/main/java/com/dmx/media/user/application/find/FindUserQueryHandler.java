package com.dmx.media.user.application.find;

import com.dmx.administrative.user.domain.UserNotFindException;
import com.dmx.shared.domain.UserId;
import com.dmx.shared.domain.bus.query.QueryHandler;

public class FindUserQueryHandler implements QueryHandler<FindUserQuery, UserResponse> {
    private final UserFinder finder;

    public FindUserQueryHandler(UserFinder finder) {
        this.finder = finder;
    }

    @Override
    public UserResponse handle(FindUserQuery query) throws UserNotFindException {
        return this.finder.execute(new UserId(query.userId()));
    }
}
