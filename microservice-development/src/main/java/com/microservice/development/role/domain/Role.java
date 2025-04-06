package com.microservice.development.role.domain;

import com.microservice.development.shared.domain.RoleId;

import java.util.Objects;

public class Role {
    private final RoleId id;
    private final RoleName name;
    private final RoleDescription description;

    public Role(RoleId id, RoleName name, RoleDescription description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Role() {
        this.id = null;
        this.name = null;
        this.description = null;
    }

    public static Role create(RoleId id, RoleName name, RoleDescription description) {
        return new Role(id, name, description);
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) && Objects.equals(name, role.name) && Objects.equals(description, role.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
