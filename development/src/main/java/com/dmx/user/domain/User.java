package com.dmx.user.domain;

import com.dmx.shared.domain.UserId;

import java.util.Arrays;

public final class User {
    private final UserId id;
    private final UserName name;
    private final UserRoleId[] role;
    private final UserNickeName nickeName;
    private final UserEmail email;

    public User(
            UserId id,
            UserName name,
            UserRoleId[] roleList,
            UserNickeName nickeName,
            UserEmail email
    ) {
        this.id = id;
        this.name = name;
        this.role = roleList;
        this.nickeName = nickeName;
        this.email = email;
    }

    public static User create(
            UserId id,
            UserName name,
            UserRoleId[] roleList,
            UserNickeName nickeName,
            UserEmail email
    ) {
        return new User(id, name, roleList, nickeName, email);
    }

    public UserId getId() {
        return this.id;
    }

    public UserName getName() {
        return this.name;
    }

    public UserRoleId[] getRole() {
        return this.role;
    }

    public UserNickeName getNickeName() {
        return this.nickeName;
    }

    public UserEmail getEmail() {
        return this.email;
    }
    
    public static User fromPrimitives(
            String id,
            String name,
            String[] roleList,
            String nickeName,
            String email
    ) {
        UserRoleId[] userRoleIdList = new UserRoleId[roleList.length];

        for (int roleId = 0; roleId < roleList.length; roleId++) {
            userRoleIdList[roleId] = new UserRoleId(roleList[roleId]);
        }
        return new User(
                new UserId(id),
                new UserName(name),
                userRoleIdList,
                new UserNickeName(nickeName),
                new UserEmail(email)
        );
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", role=" + Arrays.toString(role) +
                ", nickeName=" + nickeName +
                ", email=" + email +
                '}';
    }
}
