package com.microservice.media.team.application.find;

import com.microservice.media.shared.domain.TeamId;
import com.microservice.media.team.TeamUnitTestCase;
import com.microservice.media.team.domain.Team;
import com.microservice.media.team.domain.TeamIdTest;
import com.microservice.media.team.domain.TeamNotFoundException;
import com.microservice.media.team.domain.TeamTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class FindTeamQueryHandlerTest extends TeamUnitTestCase {

    FindTeamQueryHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new FindTeamQueryHandler(new TeamFinder(queryRepository));
    }

    @Test
    void it_should_find_an_existenting_team() {
        Team team = TeamTest.random();

        FindTeamQuery query = FindTeamQueryTest.create(team.getId().value());
        TeamResponse response = TeamResponseTest.create(team.toPrimitives());

        shouldAnswerAnyTeam(team);

        assertEquals(response.getResponse(), handler.handle(query).getResponse());
    }

    @Test
    void it_should_throw_an_exception_when_team_does_not_exist() {
        TeamId id = TeamIdTest.random();

        FindTeamQuery query = FindTeamQueryTest.create(id.value());

        shouldAnswerEmptyTeam(id);

        assertThrows(TeamNotFoundException.class, () -> handler.handle(query));
    }
}
