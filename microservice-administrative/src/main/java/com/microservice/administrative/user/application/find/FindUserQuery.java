package com.microservice.administrative.user.application.find;

import com.microservice.administrative.shared.domain.bus.query.Query;

public record FindUserQuery(
        String userId
) implements Query {
}
