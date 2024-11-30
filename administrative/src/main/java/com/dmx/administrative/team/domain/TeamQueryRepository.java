package com.dmx.administrative.team.domain;

import com.dmx.shared.domain.TeamId;
import com.dmx.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface TeamQueryRepository {
    Optional<Team> find(TeamId id);
    List<Team> searchAll();
    List<Team> match(Criteria criteria);
}
