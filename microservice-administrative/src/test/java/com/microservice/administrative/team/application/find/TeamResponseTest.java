package com.microservice.administrative.team.application.find;

import com.microservice.administrative.role.domain.Role;
import com.microservice.administrative.role.domain.RoleTest;
import com.microservice.administrative.shared.domain.TeamId;
import com.microservice.administrative.team.domain.*;
import com.microservice.administrative.user.domain.User;
import com.microservice.administrative.user.domain.UserTest;

import java.util.HashMap;

public final class TeamResponseTest {
    public static TeamResponse create(
            TeamId id,
            TeamName name,
            TeamCreationDate creationDate,
            TeamState state,
            Role role,
            HashMap<String, User> memberList
    ) {
        return new TeamResponse(new Team(id, name, creationDate, state, role, memberList).toPrimitives());
    }

    public static TeamResponse random() {
        HashMap<String, User> membersList = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            User user = UserTest.random();
            membersList.put(user.getId().value(), user);
        }
        return create(TeamIdTest.random(), TeamNameTest.random(), TeamCreationDateTest.random(), TeamStateTest.radom(), RoleTest.random(), membersList);
    }
}
