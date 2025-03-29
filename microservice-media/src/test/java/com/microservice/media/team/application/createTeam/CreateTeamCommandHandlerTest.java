package com.microservice.media.team.application.createTeam;

import com.microservice.media.role.domain.RoleDescription;
import com.microservice.media.role.domain.RoleName;
import com.microservice.media.role.domain.RoleTest;
import com.microservice.media.shared.domain.RoleId;
import com.microservice.media.shared.domain.TeamId;
import com.microservice.media.team.TeamUnitTestCase;
import com.microservice.media.team.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

public final class CreateTeamCommandHandlerTest extends TeamUnitTestCase {
    CreateTeamCommandHandler handler;
    CreateTeamCommand command;
    Team team;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new CreateTeamCommandHandler(new TeamCreator(commandRepository, queryRepository));
        command = CreateTeamCommandTest.random();
        team = TeamTest.create(
                new TeamId(command.getTeamId()),
                new TeamName(command.getTeamName()),
                new TeamCreationDate(command.getTeamCreationDate()),
                TeamStateTest.create(true),
                RoleTest.create(
                        new RoleId(command.getRoleId()),
                        new RoleName(command.getRoleName()),
                        new RoleDescription(command.getRoleDescription())
                ),
                new HashMap<>(),
                new HashMap<>()
        );
    }

    @Test
    void it_should_create_a_new_team() {
        handler.handle(command);

        shouldVerifySaveTeam(team);
    }

    @Test
    void it_should_throw_an_exception_when_team_already_exist() {
        shouldAnswerAnyTeam(team);

        assertThrows(TeamAlreadyExists.class, () -> handler.handle(command));
    }
}
