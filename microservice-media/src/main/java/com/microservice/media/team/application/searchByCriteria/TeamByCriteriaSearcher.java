package com.microservice.media.team.application.searchByCriteria;

import com.microservice.media.shared.domain.criteria.Criteria;
import com.microservice.media.shared.domain.criteria.Filters;
import com.microservice.media.shared.domain.criteria.Order;
import com.microservice.media.team.domain.Team;
import com.microservice.media.team.domain.TeamQueryRepository;

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
