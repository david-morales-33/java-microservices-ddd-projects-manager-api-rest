package com.microservice.administrative.team.application.find;

import com.microservice.administrative.shared.domain.TeamId;
import com.microservice.administrative.team.TeamModuleUnitTestCase;
import com.microservice.administrative.team.domain.Team;
import com.microservice.administrative.team.domain.TeamIdTest;
import com.microservice.administrative.team.domain.TeamNotFoundException;
import com.microservice.administrative.team.domain.TeamTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class FindTeamQueryHandlerTest extends TeamModuleUnitTestCase {
    FindTeamQueryHandler queryHandler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        queryHandler = new FindTeamQueryHandler(new TeamFinder(queryRepository));
    }

    @Test
    void it_should_find_an_existing_team() {
        Team team = TeamTest.random();
        FindTeamQuery query = FindTeamQueryTest.create(team.getId().value());
        TeamResponse response = TeamResponseTest.create(team.getId(), team.getName(), team.getCreationDate(), team.getState(), team.getRole(), team.getMemberList());

        shouldHaveAskById(team);

        assertEquals(response.getResponse(), queryHandler.handle(query).getResponse());
    }

    @Test
    void it_should_throw_an_exception_when_team_doest_exist() {
        FindTeamQuery query = FindTeamQueryTest.random();

        shouldHaveAskById(TeamIdTest.create(query.getTeamId()));

        assertThrows(TeamNotFoundException.class, () -> queryHandler.handle(query));
    }
}
