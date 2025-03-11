package com.microservice.administrative.user.domain;

import com.microservice.administrative.role.domain.Role;
import com.microservice.administrative.role.domain.RoleTest;
import com.microservice.administrative.shared.domain.UserId;

import java.util.HashMap;

public final class UserTest {
    public static User create(UserId id, UserName name, UserEmail email, UserNickName nickName, HashMap<String, Role> roleList) {
        return new User(id, name, email, nickName, roleList);
    }

    public static User random() {
        HashMap<String, Role> roleList = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            Role role = RoleTest.random();
            roleList.put(role.getId().value(), role);
        }
        return create(UserIdTest.random(), UserNameTest.random(), UserEmailTest.random(), UserNickNameTest.random(), roleList);
    }
}
