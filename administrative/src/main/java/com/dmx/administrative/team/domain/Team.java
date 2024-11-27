package com.dmx.administrative.team.domain;

import com.dmx.administrative.post.domain.Post;
import com.dmx.administrative.role.domain.Role;
import com.dmx.shared.domain.SpaceId;
import com.dmx.shared.domain.TeamId;
import com.dmx.shared.domain.AggregateRoot;
import com.dmx.shared.domain.UserId;
import com.dmx.administrative.space.domain.Space;
import com.dmx.administrative.space.domain.SpaceDTO;

import java.util.HashMap;
import java.util.HashSet;

public final class Team extends AggregateRoot {
    private final TeamId id;
    private final TeamName name;
    private final TeamCreationDate creationDate;
    private final TeamState state;
    private final Role role;
    private final HashSet<UserId> memberList;
    private final HashMap<String, Space> spaceList;
    private TeamMembersCounter membersCounter;
    private TeamSpacesCounter spacesCounter;

    public Team(
            TeamId id,
            TeamName name,
            TeamCreationDate creationDate,
            TeamState state,
            Role role,
            HashSet<UserId> memberList,
            HashMap<String, Space> spaceList
    ) {
        this.id = id;
        this.name = name;
        this.membersCounter = new TeamMembersCounter(memberList.size());
        this.spacesCounter = new TeamSpacesCounter(spaceList.size());
        this.creationDate = creationDate;
        this.state = state;
        this.role = role;
        this.memberList = memberList;
        this.spaceList = spaceList;
    }

    public static Team fromPrimitives(TeamDTO data) {
        HashSet<UserId> newMemberList = new HashSet<>();
        HashMap<String, Space> newSpaceList = new HashMap<>();

        data.memberList().forEach(element -> {
            newMemberList.add(new UserId(element));
        });

        data.spaceList().forEach((key, value) -> {
            newSpaceList.put(key, Space.fromPrimitive(value));
        });

        return new Team(
                new TeamId(data.id()),
                new TeamName(data.name()),
                new TeamCreationDate(data.creationDate()),
                new TeamState(data.state()),
                Role.fromPrimitives(data.role()),
                newMemberList,
                newSpaceList
        );
    }

    public TeamDTO toPrimitives() {
        HashSet<String> memberList = new HashSet<>();
        HashMap<String, SpaceDTO> spaceList = new HashMap<>();

        this.memberList.forEach(element -> {
            memberList.add(element.value());
        });

        this.spaceList.forEach((key, value) -> {
            spaceList.put(key, value.toPrimitives());
        });

        return new TeamDTO(
                this.id.value(),
                this.name.value(),
                this.membersCounter.value(),
                this.spacesCounter.value(),
                this.creationDate.value(),
                this.state.value(),
                this.role.toPrimitives(),
                memberList,
                spaceList
        );
    }

    public void addSpace(Space newSpace) {
        if (!this.isValidSpace(newSpace.getId())) {
            throw new SpaceNotValidException("El espacio <" + newSpace.getId().value() + "> ya existe");
        }
        this.spaceList.put(newSpace.getId().value(), newSpace);
        this.spacesCounter = this.incrementSpaceCounter();
    }

    public void addUser(UserId newMember) {
        if (!this.isValidUser(newMember)) {
            throw new UserNotValidException("El usuario <" + newMember.value() + "> ya existe");
        }
        this.memberList.add(newMember);
        this.membersCounter = this.incrementMembersCounter();
    }

    public void addPost(Post newPost) {
        Space currentSpace = this.spaceList.get(newPost.getSpaceId().value());
        if (currentSpace == null) {
            throw new SpaceNotFoundException("El espacio no existe");
        }
        currentSpace.addPost(newPost.getId());
    }

    public TeamSpacesCounter incrementSpaceCounter() {
        return new TeamSpacesCounter(this.spacesCounter.value() + 1);
    }

    public TeamMembersCounter incrementMembersCounter() {
        return new TeamMembersCounter(this.membersCounter.value() + 1);
    }

    public boolean isValidUser(UserId userId) {
        return !this.memberList.contains(userId);
    }

    public boolean isValidSpace(SpaceId spaceId) {
        return !this.spaceList.containsKey(spaceId.value());
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
        return role;
    }

    public HashSet<UserId> getMemberList() {
        return this.memberList;
    }

    public HashMap<String, Space> getSpaceList() {
        return this.spaceList;
    }
}
