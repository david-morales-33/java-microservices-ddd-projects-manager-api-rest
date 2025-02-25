package com.microservice.media.user.domain;

import com.microservice.media.role.domain.Role;
import com.microservice.media.role.domain.RoleDTO;
import com.microservice.media.shared.domain.AggregateRoot;
import com.microservice.media.shared.domain.UserId;

import java.util.HashMap;

public final class User extends AggregateRoot {
    private final UserId id;
    private final UserName name;
    private final UserEmail email;
    private final UserNickName nickName;
    private final HashMap<String, Role> roleList;

    public User(UserId id, UserName name, UserEmail email, UserNickName nickName, HashMap<String, Role> roleList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.nickName = nickName;
        this.roleList = roleList;
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

    public HashMap<String, Role> getRole() {
        return this.roleList;
    }

    public static User fromPrimitives(UserDTO data) {
        HashMap<String, Role> roleList = new HashMap<>();
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
        HashMap<String, RoleDTO> roleList = new HashMap<>();
        this.roleList.forEach((key,value)->{
            roleList.put(key,value.toPrimitives());
        });

        return new UserDTO(
                this.id.value(),
                this.name.value(),
                this.email.value(),
                this.nickName.value(),
                roleList
                );
    }
}
