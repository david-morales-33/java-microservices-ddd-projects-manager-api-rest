package com.microservice.development.team.domain;

import com.microservice.development.role.domain.Role;
import com.microservice.development.shared.domain.AggregateRoot;
import com.microservice.development.shared.domain.TeamId;
import com.microservice.development.shared.domain.UserId;
import com.microservice.development.user.domain.User;
import com.microservice.development.user.domain.UserDTO;

import java.util.HashMap;

public final class Team extends AggregateRoot {
    private final TeamId id;
    private final TeamName name;
    private final TeamCreationDate creationDate;
    private final TeamState state;
    private final Role role;
    private final HashMap<String, User> memberList;
    private TeamMembersCounter membersCounter;
    private TeamSpacesCounter spacesCounter;

    public Team(
            TeamId id,
            TeamName name,
            TeamCreationDate creationDate,
            TeamState state,
            Role role,
            HashMap<String, User> memberList
    ) {
        this.id = id;
        this.name = name;
        this.membersCounter = new TeamMembersCounter(memberList.size());
        this.creationDate = creationDate;
        this.state = state;
        this.role = role;
        this.memberList = memberList;
    }

    public static Team create(
            TeamId id,
            TeamName name,
            TeamCreationDate creationDate,
            TeamState state,
            Role role,
            HashMap<String, User> memberList
    ) {
        return new Team(id, name, creationDate, state, role, memberList);
    }

    public static Team fromPrimitives(TeamDTO data) {
        HashMap<String, User> newMemberList = new HashMap<>();

        data.memberList().forEach((key, value) -> {
            newMemberList.put(key, User.fromPrimitives(value));
        });

        return new Team(
                new TeamId(data.id()),
                new TeamName(data.name()),
                new TeamCreationDate(data.creationDate()),
                new TeamState(data.state()),
                Role.fromPrimitives(data.role()),
                newMemberList
        );
    }

    public TeamDTO toPrimitives() {
        HashMap<String, UserDTO> memberList = new HashMap<>();

        this.memberList.forEach((key, value) -> {
            memberList.put(key, value.toPrimitives());
        });

        return new TeamDTO(
                this.id.value(),
                this.name.value(),
                this.membersCounter.value(),
                this.spacesCounter.value(),
                this.creationDate.value(),
                this.state.value(),
                this.role.toPrimitives(),
                memberList
        );
    }


    public void addUser(User newMember) {
        if (!this.isValidUser(newMember.getId())) {
            throw new UserNotValidException("El usuario <" + newMember.getName().value() + "> ya existe");
        }
        this.memberList.put(newMember.getId().value(), newMember);
        this.membersCounter = this.incrementMembersCounter();
    }

    public TeamSpacesCounter incrementSpaceCounter() {
        return new TeamSpacesCounter(this.spacesCounter.value() + 1);
    }

    public TeamMembersCounter incrementMembersCounter() {
        return new TeamMembersCounter(this.membersCounter.value() + 1);
    }

    public boolean isValidUser(UserId userId) {
        return !this.memberList.containsKey(userId.value());
    }

    public TeamId getId() {
        return this.id;
    }

    public TeamName getName() {
        return this.name;
    }

    public TeamMembersCounter getMembersCounter() {
        return this.membersCounter;
    }

    public TeamSpacesCounter getSpacesCounter() {
        return this.spacesCounter;
    }

    public TeamCreationDate getCreationDate() {
        return this.creationDate;
    }

    public TeamState getState() {
        return this.state;
    }

    public Role getRole() {
        return this.role;
    }

    public HashMap<String, User> getMemberList() {
        return this.memberList;
    }
}
