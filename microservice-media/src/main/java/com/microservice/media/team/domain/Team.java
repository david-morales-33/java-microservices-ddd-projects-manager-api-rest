package com.microservice.media.team.domain;

import com.microservice.media.post.domain.Post;
import com.microservice.media.role.domain.Role;
import com.microservice.media.shared.domain.AggregateRoot;
import com.microservice.media.shared.domain.SpaceId;
import com.microservice.media.shared.domain.TeamId;
import com.microservice.media.shared.domain.UserId;
import com.microservice.media.user.domain.User;
import com.microservice.media.user.domain.UserDTO;
import com.microservice.media.space.domain.Space;
import com.microservice.media.space.domain.SpaceDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Team extends AggregateRoot {
    private final TeamId id;
    private final TeamName name;
    private final TeamCreationDate creationDate;
    private final TeamState state;
    private Role role;
    private Map<String, User> memberList;
    private Map<String, Space> spaceList;
    private TeamMembersCounter membersCounter;
    private TeamSpacesCounter spacesCounter;

    public Team(
            TeamId id,
            TeamName name,
            TeamCreationDate creationDate,
            TeamState state,
            Role role,
            HashMap<String, User> memberList,
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

    private Team() {
        this.id = null;
        this.name = null;
        this.membersCounter = null;
        this.spacesCounter = null;
        this.creationDate = null;
        this.state = null;
        this.role = null;
        this.memberList = new HashMap<>();
        this.spaceList = new HashMap<>();
        this.membersCounter = new TeamMembersCounter(0);
        this.spacesCounter = new TeamSpacesCounter(0);
    }

    public static Team create(
            TeamId id,
            TeamName name,
            TeamCreationDate creationDate,
            TeamState state,
            Role role,
            HashMap<String, User> memberList,
            HashMap<String, Space> spaceList
    ) {
        return new Team(id, name, creationDate, state, role, memberList, spaceList);
    }

    public static Team fromPrimitives(TeamDTO data) {
        HashMap<String, User> newMemberList = new HashMap<>();
        HashMap<String, Space> newSpaceList = new HashMap<>();

        data.memberList().forEach((key, value) -> {
            newMemberList.put(key, User.fromPrimitives(value));
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
        HashMap<String, UserDTO> memberList = new HashMap<>();
        HashMap<String, SpaceDTO> spaceList = new HashMap<>();

        this.memberList.forEach((key, value) -> {
            memberList.put(key, value.toPrimitives());
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

    public void addUser(User newMember) {
        if (!this.isValidUser(newMember.getId())) {
            throw new UserNotValidException("El usuario <" + newMember.getName().value() + "> ya existe");
        }
        this.memberList.put(newMember.getId().value(), newMember);
        this.membersCounter = this.incrementMembersCounter();
    }

    public void addSpaceMember(SpaceId spaceId, UserId userId) {
        Space space = this.spaceList.get(spaceId.value());
        User user = this.memberList.get(userId.value());

        if (space == null) throw new SpaceNotFoundException("No el espacio no existe dentro del equipo de trabajo");
        if (user == null) throw new UserNotValidException("El usuario no existe en este equipo de trabajo");

        space.addMember(user);
    }

    public void addPost(Post newPost) {
        Space currentSpace = this.spaceList.get(newPost.getSpaceId().value());

        if (currentSpace == null) throw new SpaceNotFoundException("El espacio no existe");

        if (!this.toPrimitives().memberList().containsKey(newPost.getUser().getId().value()))
            throw new UserNotValidException("El usuario no es valido en este equipo");

        currentSpace.addPost(newPost);
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

    public Map<String, User> getMemberList() {
        return this.memberList;
    }

    public Map<String, Space> getSpaceList() {
        return this.spaceList;
    }

    private void setMemberList(Map<String, User> memberList) {
        this.memberList = memberList;
    }

    private void setSpaceList(Map<String, Space> spaceList) {
        this.spaceList = spaceList;
    }

    private void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) && Objects.equals(name, team.name) && Objects.equals(creationDate, team.creationDate) && Objects.equals(state, team.state) && Objects.equals(role, team.role) && Objects.equals(memberList, team.memberList) && Objects.equals(spaceList, team.spaceList) && Objects.equals(membersCounter, team.membersCounter) && Objects.equals(spacesCounter, team.spacesCounter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, creationDate, state, role, memberList, spaceList, membersCounter, spacesCounter);
    }
}
