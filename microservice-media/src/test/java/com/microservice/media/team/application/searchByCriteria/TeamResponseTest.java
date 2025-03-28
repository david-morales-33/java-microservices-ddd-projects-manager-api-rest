package com.microservice.media.team.application.searchByCriteria;

import com.microservice.media.shared.domain.ListTest;
import com.microservice.media.team.domain.Team;
import com.microservice.media.team.domain.TeamSupplier;

import java.util.List;

public final class TeamResponseTest {
    public static TeamResponse create(List<Team> data) {
        return new TeamResponse(data);
    }

    public static TeamResponse random() {
        return create(ListTest.create(2, new TeamSupplier()));
    }
}
