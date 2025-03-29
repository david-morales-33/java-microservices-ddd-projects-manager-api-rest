package com.microservice.media.team.application.createTeam;

import com.microservice.media.role.domain.RoleDescriptionTest;
import com.microservice.media.role.domain.RoleIdTest;
import com.microservice.media.role.domain.RoleNameTest;
import com.microservice.media.team.domain.TeamCreationDateTest;
import com.microservice.media.team.domain.TeamIdTest;
import com.microservice.media.team.domain.TeamNameTest;

public final class CreateTeamCommandTest {
    public static CreateTeamCommand create(String teamId, String teamName, String teamCreationDate, String roleId, String roleName, String roleDescription) {
        return new CreateTeamCommand(teamId, teamName, teamCreationDate, roleId, roleName, roleDescription);
    }

    public static CreateTeamCommand random() {
        return create(
                TeamIdTest.random().value(),
                TeamNameTest.random().value(),
                TeamCreationDateTest.random().value(),
                RoleIdTest.random().value(),
                RoleNameTest.random().value(),
                RoleDescriptionTest.random().value()
        );
    }
}
