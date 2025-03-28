package com.microservice.media.team.application.searchByCriteria;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public final class SearchByCriteriaTeamQueryTest {
    public static SearchByCriteriaTeamQuery create(
            List<HashMap<String, String>> filters,
            Optional<String> orderBy,
            Optional<String> orderType,
            Optional<Integer> limit,
            Optional<Integer> offset
    ) {
        return new SearchByCriteriaTeamQuery(filters, orderBy, orderType, limit, offset);
    }
}
