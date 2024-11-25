package com.dmx.administrative.user.domain;

import com.dmx.administrative.role.domain.Role;
import com.dmx.shared.domain.AggregateRoot;
import com.dmx.shared.domain.UserId;

public class User extends AggregateRoot {
    private final UserId id;
    private final UserName name;
    private final UserEmail email;
    private final UserNickName nickName;
    private final Role role;

    public User(UserId id, UserName name, UserEmail email, UserNickName nickName, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.nickName = nickName;
        this.role = role;
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

    public Role getRole() {
        return this.role;
    }

    public static User fromPrimitives(UserDTO data) {
        return new User(
                new UserId(data.id()),
                new UserName(data.name()),
                new UserEmail(data.email()),
                new UserNickName(data.nickName()),
                Role.fromPrimitives(data.role())
        );
    }

    public UserDTO toPrimitives() {
        return new UserDTO(
                this.id.value(),
                this.name.value(),
                this.email.value(),
                this.nickName.value(),
                this.role.toPrimitives()
        );
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + this.id +
                ", name=" + this.name +
                ", email=" + this.email +
                ", nickName=" + this.nickName +
                ", role=" + this.role +
                '}';
    }
}
