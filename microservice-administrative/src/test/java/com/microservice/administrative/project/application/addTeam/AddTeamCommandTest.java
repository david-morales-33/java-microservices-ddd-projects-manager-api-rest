package com.microservice.administrative.project.application.addTeam;

import com.microservice.administrative.project.domain.ProjectIdTest;
import com.microservice.administrative.role.domain.RoleIdTest;
import com.microservice.administrative.team.domain.TeamIdTest;
import com.microservice.administrative.team.domain.TeamNameTest;

public final class AddTeamCommandTest {
    public static AddTeamCommand create(String projectId, String teamId, String roleId, String name) {
        return new AddTeamCommand(projectId, teamId, roleId, name);
    }

    public static AddTeamCommand random() {
        return create(ProjectIdTest.random().value(), TeamIdTest.random().value(), RoleIdTest.random().value(), TeamNameTest.random().value());
    }
}
