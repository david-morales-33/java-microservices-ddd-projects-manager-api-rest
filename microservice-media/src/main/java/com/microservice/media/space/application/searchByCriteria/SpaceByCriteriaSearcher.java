package com.microservice.media.space.application.searchByCriteria;

import com.microservice.media.shared.domain.criteria.Criteria;
import com.microservice.media.shared.domain.criteria.Filters;
import com.microservice.media.shared.domain.criteria.Order;
import com.microservice.media.space.domain.Space;
import com.microservice.media.space.domain.SpaceQueryRepository;

import java.util.List;
import java.util.Optional;

public final class SpaceByCriteriaSearcher {
    private final SpaceQueryRepository queryRepository;

    public SpaceByCriteriaSearcher(SpaceQueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    public SpaceResponse execute(Filters filters, Order order, Optional<Integer> offset, Optional<Integer> limit) {
        Criteria criteria = new Criteria(filters, order, limit, offset);
        List<Space> response = this.queryRepository.match(criteria);
        return new SpaceResponse(response);
    }
}
