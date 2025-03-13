package com.microservice.administrative.project.application.addCard;

import com.microservice.administrative.project.domain.ProjectIdTest;
import com.microservice.administrative.team.domain.TeamIdTest;
import com.microservice.administrative.team.domain.TeamNameTest;

public final class AddCardCommandTest {
    public static AddCardCommand create(String projectId, String teamId, String name) {
        return new AddCardCommand(projectId, teamId, name);
    }

    public static AddCardCommand random() {
        return create(ProjectIdTest.random().value(), TeamIdTest.random().value(), TeamNameTest.random().value());
    }
}
