package com.dmx.administrative.team.domain;

import java.util.List;
import java.util.Optional;

import com.dmx.administrative.shared.domain.TeamId;
import com.dmx.administrative.shared.domain.criteria.Criteria;

public interface TeamQueryRepository {
    Optional<Team> find(TeamId id);
    List<Team> searchAll();
    List<Team> match(Criteria criteria);
}
