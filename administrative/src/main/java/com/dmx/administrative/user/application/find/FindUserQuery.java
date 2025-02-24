package com.dmx.administrative.user.application.find;

import com.dmx.administrative.shared.domain.bus.query.Query;

public record FindUserQuery(
        String userId
) implements Query {
}
