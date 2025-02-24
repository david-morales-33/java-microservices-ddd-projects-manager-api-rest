package com.dmx.administrative.team.application.searchByCriteria;

import com.dmx.administrative.shared.domain.criteria.Criteria;
import com.dmx.administrative.shared.domain.criteria.Filters;
import com.dmx.administrative.shared.domain.criteria.Order;
import com.dmx.administrative.team.domain.Team;
import com.dmx.administrative.team.domain.TeamQueryRepository;


import java.util.List;
import java.util.Optional;

public final class TeamByCriteriaSearcher {
    private final TeamQueryRepository queryRepository;

    public TeamByCriteriaSearcher(TeamQueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    public TeamResponse execute(Filters filters, Order order, Optional<Integer> offset, Optional<Integer> limit) {
        Criteria criteria = new Criteria(filters, order, limit, offset);
        List<Team> response = this.queryRepository.match(criteria);
        return new TeamResponse(response);
    }
}
