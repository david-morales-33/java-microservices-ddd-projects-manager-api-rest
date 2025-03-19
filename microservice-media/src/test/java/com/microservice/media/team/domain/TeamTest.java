package com.microservice.media.team.domain;

import com.microservice.media.role.domain.Role;
import com.microservice.media.role.domain.RoleTest;
import com.microservice.media.shared.domain.TeamId;
import com.microservice.media.shared.domain.UserId;
import com.microservice.media.space.domain.Space;
import com.microservice.media.space.domain.SpaceTest;
import com.microservice.media.user.domain.User;
import com.microservice.media.user.domain.UserTest;

import java.util.HashMap;

public final class TeamTest {
    public static Team create(
            TeamId id,
            TeamName name,
            TeamCreationDate creationDate,
            TeamState state,
            Role role,
            HashMap<String, User> memberList,
            HashMap<String, Space> spaceList
    ) {
        return new Team(id, name, creationDate, state, role, memberList, spaceList);
    }

    public static Team random() {
        Role role = RoleTest.random();
        HashMap<String, User> memberList = new HashMap<>();
        HashMap<String, Space> spaceList = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            Space space = SpaceTest.random();

            spaceList.put(space.getId().value(), space);

            space.getMemberList().forEach(user -> {
                User member = UserTest.create(new UserId(user.value()));
                memberList.put(user.value(), member);
            });
        }

        return create(
                TeamIdTest.random(),
                TeamNameTest.random(),
                TeamCreationDateTest.random(),
                TeamStateTest.create(Boolean.TRUE),
                role,
                memberList,
                spaceList
        );
    }
}
