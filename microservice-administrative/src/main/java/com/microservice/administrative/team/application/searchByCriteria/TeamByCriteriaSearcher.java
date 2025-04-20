package com.microservice.administrative.team.application.searchByCriteria;

import com.microservice.administrative.shared.domain.Service;
import com.microservice.administrative.shared.domain.criteria.Criteria;
import com.microservice.administrative.shared.domain.criteria.Filters;
import com.microservice.administrative.shared.domain.criteria.Order;
import com.microservice.administrative.team.domain.Team;
import com.microservice.administrative.team.domain.TeamQueryRepository;

import java.util.List;
import java.util.Optional;

@Service
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
