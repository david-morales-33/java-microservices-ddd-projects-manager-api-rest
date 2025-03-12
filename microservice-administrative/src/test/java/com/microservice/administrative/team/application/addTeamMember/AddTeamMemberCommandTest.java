package com.microservice.administrative.team.application.addTeamMember;

import com.microservice.administrative.team.domain.TeamIdTest;
import com.microservice.administrative.user.domain.UserIdTest;

public final class AddTeamMemberCommandTest {
    public static AddTeamMemberCommand create(String userId, String teamId) {
        return new AddTeamMemberCommand(userId, teamId);
    }

    public static AddTeamMemberCommand random() {
        return create(UserIdTest.random().value(), TeamIdTest.random().value());
    }
}
