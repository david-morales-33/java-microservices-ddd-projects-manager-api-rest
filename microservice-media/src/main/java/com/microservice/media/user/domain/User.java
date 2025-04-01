package com.microservice.media.user.domain;

import com.microservice.media.role.domain.Role;
import com.microservice.media.role.domain.RoleDTO;
import com.microservice.media.shared.domain.AggregateRoot;
import com.microservice.media.shared.domain.UserId;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User extends AggregateRoot {
    private final UserId id;
    private final UserName name;
    private final UserEmail email;
    private final UserNickName nickName;
    private Map<String, Role> roleList;

    public User(UserId id, UserName name, UserEmail email, UserNickName nickName, Map<String, Role> roleList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.nickName = nickName;
        this.roleList = roleList;
    }

    private User() {
        this.id = null;
        this.name = null;
        this.email = null;
        this.nickName = null;
        this.roleList = new HashMap<>();
    }

    public UserId getId() {
        return this.id;
    }

    public UserName getName() {
        return this.name;
    }

    public UserEmail getEmail() {
        return this.email;
    }

    public UserNickName getNickName() {
        return this.nickName;
    }

    public Map<String, Role> getRoleList() {
        return this.roleList;
    }

    public void setRoleList(Map<String, Role> roleList) {
        this.roleList = roleList;
    }

    public static User fromPrimitives(UserDTO data) {
        Map<String, Role> roleList = new HashMap<>();
        data.roleList().forEach((key, value) -> {
            roleList.put(key, Role.fromPrimitives(value));
        });
        return new User(
                new UserId(data.id()),
                new UserName(data.name()),
                new UserEmail(data.email()),
                new UserNickName(data.nickName()),
                roleList
        );
    }

    public UserDTO toPrimitives() {
        Map<String, RoleDTO> roleList = new HashMap<>();
        this.roleList.forEach((key, value) -> {
            roleList.put(key, value.toPrimitives());
        });

        return new UserDTO(
                this.id.value(),
                this.name.value(),
                this.email.value(),
                this.nickName.value(),
                roleList
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(nickName, user.nickName) && Objects.equals(roleList, user.roleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, nickName, roleList);
    }
}
