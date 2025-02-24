package com.dmx.media.user.application.find;

import com.dmx.media.shared.domain.bus.query.Query;

public record FindUserQuery(
                String userId) implements Query {
}
