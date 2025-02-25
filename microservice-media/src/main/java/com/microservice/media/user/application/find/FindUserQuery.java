package com.microservice.media.user.application.find;

import com.microservice.media.shared.domain.bus.query.Query;

public record FindUserQuery(
                String userId) implements Query {
}
