package com.dmx.administrative.team.application.searchByCriteria;

import com.dmx.shared.domain.bus.query.QueryHandler;
import com.dmx.shared.domain.criteria.Filters;
import com.dmx.shared.domain.criteria.Order;

import java.util.Optional;

public final class SearchByCriteriaTeamQueryHandler implements QueryHandler<SearchByCriteriaTeamQuery, TeamResponse> {
    private final TeamByCriteriaSearcher searcher;

    public SearchByCriteriaTeamQueryHandler(TeamByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public TeamResponse handle(SearchByCriteriaTeamQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order order = Order.fromValues(query.orderBy(), query.orderType());
        Optional<Integer> offset = query.offset();
        Optional<Integer> limit = query.limit();
        return this.searcher.execute(filters, order, offset, limit);
    }
}
