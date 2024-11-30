package com.dmx.administrative.team.domain;

import com.dmx.shared.domain.TeamId;

import java.util.Optional;

public interface TeamQueryRepository {
    Optional<Team> find(TeamId id);
}
