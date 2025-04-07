package com.microservice.development.funcionality.domain;

import com.microservice.development.shared.domain.FuncionalityId;
import com.microservice.development.shared.domain.RoleId;
import com.microservice.development.shared.domain.TeamId;

import java.util.Objects;

public final class Funcionality {
    private final FuncionalityId id;
    private final FuncionalityName name;
    private final FuncionalityDescription description;
    private final FuncionalityCreationdate creationdate;
    private final FuncionalityState state;
    private final TeamId teamId;
    private final RoleId roleId;

    public Funcionality(
            FuncionalityId id,
            FuncionalityName name,
            FuncionalityDescription description,
            FuncionalityCreationdate creationdate,
            FuncionalityState state,
            TeamId teamId,
            RoleId roleId
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationdate = creationdate;
        this.state = state;
        this.teamId = teamId;
        this.roleId = roleId;
    }

    private Funcionality() {
        this.id = null;
        this.name = null;
        this.description = null;
        this.creationdate = null;
        this.state = null;
        this.teamId = null;
        this.roleId = null;
    }

    public static Funcionality fromPrimitives(FuncionalityDTO data) {
        return new Funcionality(
                new FuncionalityId(data.id()),
                new FuncionalityName(data.name()),
                new FuncionalityDescription(data.description()),
                new FuncionalityCreationdate(data.creationdate()),
                new FuncionalityState(data.state()),
                new TeamId(data.teamId()),
                new RoleId(data.roleId())
        );
    }

    public FuncionalityDTO toPrimitives() {
        return new FuncionalityDTO(
                this.id.value(),
                this.name.value(),
                this.description.value(),
                this.creationdate.value(),
                this.state.value(),
                this.teamId.value(),
                this.roleId.value()
        );
    }

    public FuncionalityId getId() {
        return this.id;
    }

    public FuncionalityName getName() {
        return this.name;
    }

    public FuncionalityDescription getDescription() {
        return this.description;
    }

    public FuncionalityCreationdate getCreationdate() {
        return this.creationdate;
    }

    public FuncionalityState getState() {
        return this.state;
    }

    public TeamId getTeamId() {
        return this.teamId;
    }

    public RoleId getRoleId() {
        return this.roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Funcionality that = (Funcionality) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(creationdate, that.creationdate) && Objects.equals(state, that.state) && Objects.equals(teamId, that.teamId) && Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, creationdate, state, teamId, roleId);
    }
}
