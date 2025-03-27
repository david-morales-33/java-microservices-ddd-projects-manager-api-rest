package com.microservice.media.team.application.createSpace;

import com.microservice.media.shared.domain.TeamId;
import com.microservice.media.team.TeamUnitTestCase;
import com.microservice.media.team.domain.Team;
import com.microservice.media.team.domain.TeamIdTest;
import com.microservice.media.team.domain.TeamNotFoundException;
import com.microservice.media.team.domain.TeamTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public final class CreateSpaceCommandHandlerTest extends TeamUnitTestCase {

    CreateSpaceCommandHandler handler;

    @BeforeEach
    protected void setUp(){
        super.setUp();
        handler = new CreateSpaceCommandHandler(new SpaceCreator(commandRepository, queryRepository));
    }

    @Test
    void it_should_create_a_new_space(){
        Team team = TeamTest.random();
        CreateSpaceCommand command = CreateSpaceCommandTest.random(team.getId().value());

        shouldAnswerAnyTeam(team);

        handler.handle(command);

        shouldVerifySaveTeam(team);
    }

    @Test
    void it_should_throw_an_exception_when_team_does_not_exists(){
        TeamId id = TeamIdTest.random();
        CreateSpaceCommand command = CreateSpaceCommandTest.random(id.value());

        shouldAnswerEmptyTeam(id);

        assertThrows(TeamNotFoundException.class, ()->handler.handle(command));
    }
}
