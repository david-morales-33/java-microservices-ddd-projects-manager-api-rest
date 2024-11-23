package com.dmx.role.domain;

import com.dmx.shared.domain.RoleId;

public class Role {
    private final RoleId id;
    private final RoleName name;
    private final RoleDescription description;

    public Role(RoleId id, RoleName name, RoleDescription description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static Role fromPrimitives(RoleDTO data) {
        return new Role(
                new RoleId(data.id()),
                new RoleName(data.name()),
                new RoleDescription(data.description())
        );
    }

    public RoleDTO toPrimitives() {
        return new RoleDTO(
                this.id.value(),
                this.name.value(),
                this.description.value()
        );
    }

    public RoleId getId() {
        return this.id;
    }

    public RoleName getName() {
        return this.name;
    }

    public RoleDescription getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + this.id +
                ", name=" + this.name +
                ", description=" + this.description +
                '}';
    }
}
