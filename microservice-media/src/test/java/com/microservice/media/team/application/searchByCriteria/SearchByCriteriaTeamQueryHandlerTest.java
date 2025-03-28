package com.microservice.media.team.application.searchByCriteria;

import com.microservice.media.shared.domain.ListTest;
import com.microservice.media.shared.domain.criteria.Criteria;
import com.microservice.media.shared.domain.criteria.CriteriaTest;
import com.microservice.media.team.TeamUnitTestCase;
import com.microservice.media.team.domain.Team;
import com.microservice.media.team.domain.TeamSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public final class SearchByCriteriaTeamQueryHandlerTest extends TeamUnitTestCase {

    SearchByCriteriaTeamQueryHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new SearchByCriteriaTeamQueryHandler(new TeamByCriteriaSearcher(queryRepository));
    }

    @Test
    void it_should_search_teams_match_by_criteria() {
        List<Team> teamList = ListTest.create(2, new TeamSupplier());
        List<HashMap<String, String>> filters = new ArrayList<>();

        Criteria criteria = CriteriaTest.random();

        criteria.filters().filters().forEach(value -> {
            HashMap<String, String> filterMap = new HashMap<>();
            filterMap.put("field", value.field().value());
            filterMap.put("operator", value.operator().value());
            filterMap.put("value", value.value().value());
            filters.add(filterMap);
        });

        SearchByCriteriaTeamQuery query = SearchByCriteriaTeamQueryTest.create(
                filters,
                Optional.of(criteria.order().orderBy().value()),
                Optional.of(criteria.order().orderType().value()),
                criteria.limit(),
                criteria.offset()
        );
        TeamResponse response = TeamResponseTest.create(teamList);

        //System.out.println(criteria.order().orderType().value());

        shouldAnswerAnyTeamByCriteria(criteria, teamList);

        assertEquals(response.getResponse(), handler.handle(query).getResponse());
    }
}
