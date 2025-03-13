package com.microservice.administrative.project.application.addTeam;

import com.microservice.administrative.project.ProjectUnitTestCase;
import com.microservice.administrative.project.domain.*;
import com.microservice.administrative.role.domain.RoleIdTest;
import com.microservice.administrative.role.domain.RoleTest;
import com.microservice.administrative.team.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public final class AddTeamCommandHandlerTest extends ProjectUnitTestCase {

    AddTeamCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new AddTeamCommandHandler(new TeamCreator(rootRepository));
    }

    @Test
    void it_should_create_a_new_team() {
        ProjectRoot project = ProjectRootTest.random();

        AddTeamCommand command = AddTeamCommandTest.create(project.getId().value(), TeamIdTest.random().value(), RoleIdTest.random().value(), TeamNameTest.random().value());

        shouldAnswerAnyProject(project);

        handler.handle(command);

        shouldVerifySaveProject(project);
    }

    @Test
    void it_should_throw_an_exception_when_project_does_not_exists() {

        AddTeamCommand command = AddTeamCommandTest.random();

        shouldAnswerEmptyProject(ProjectIdTest.create(command.getProjectId()));

        assertThrows(ProjectNotFound.class, () -> handler.handle(command));
    }

    @Test
    void it_should_throw_an_exception_when_team_already_exists() {
        AddTeamCommand command = AddTeamCommandTest.random();

        HashMap<String, Team> teamList = new HashMap<>();
        teamList.put(command.getTeamId(), TeamTest.create(
                TeamIdTest.create(command.getTeamId()),
                TeamNameTest.create(command.getName()),
                TeamCreationDateTest.random(),
                TeamStateTest.radom(),
                RoleTest.random(),
                new HashMap<>())
        );

        ProjectRoot project = ProjectRootTest.create(
                ProjectIdTest.create(command.getProjectId()),
                ProjectNameTest.random(),
                ProjectFuncionalitiesCounterTest.random(),
                teamList,
                new HashMap<>()
        );
        shouldAnswerAnyProject(project);
        assertThrows(ProjectInternalException.class, () -> handler.handle(command));
    }
}
