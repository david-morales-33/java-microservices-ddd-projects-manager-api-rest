package com.dmx.funcionality.domain;

import com.dmx.shared.domain.FuncionalityId;
import com.dmx.shared.domain.RoleId;
import com.dmx.shared.domain.TeamId;

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
}
