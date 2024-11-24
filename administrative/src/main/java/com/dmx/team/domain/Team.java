package com.dmx.team.domain;

import com.dmx.role.domain.Role;
import com.dmx.shared.domain.TeamId;
import com.dmx.shared.domain.AggregateRoot;
import com.dmx.shared.domain.UserId;
import com.dmx.space.domain.Space;
import com.dmx.space.domain.SpaceDTO;

public final class Team extends AggregateRoot {
    private final TeamId id;
    private final TeamName name;
    private final TeamMembersCounter membersCounter;
    private final TeamSpacesCounter spacesCounter;
    private final TeamCreationDate creationDate;
    private final TeamState state;
    private final Role role;
    private final UserId[] memberList;
    private final Space[] spaceList;

    public Team(
            TeamId id,
            TeamName name,
            TeamMembersCounter membersCounter,
            TeamSpacesCounter spacesCounter,
            TeamCreationDate creationDate,
            TeamState state,
            Role role,
            UserId[] memberList,
            Space[] spaceList
    ) {
        this.id = id;
        this.name = name;
        this.membersCounter = membersCounter;
        this.spacesCounter = spacesCounter;
        this.creationDate = creationDate;
        this.state = state;
        this.role = role;
        this.memberList = memberList;
        this.spaceList = spaceList;
    }

    public static Team fromPrimitives(TeamDTO data){
        UserId[] newMemberList = new UserId[data.membersCounter()];
        for(int membersCounter= 0; membersCounter<data.membersCounter(); membersCounter++){
            String currentMemberId = data.memberList()[membersCounter];
            newMemberList[membersCounter]= new UserId(currentMemberId);
        }

        Space[] newSpaceList = new Space[data.spacesCounter()];
        for(int spacesCounter = 0; spacesCounter<data.spacesCounter(); spacesCounter++){
            SpaceDTO currentSpace = data.spaceList()[spacesCounter];
            newSpaceList[spacesCounter] = Space.fromPrimitive(currentSpace);
        }

        return new Team(
                new TeamId(data.id()),
                new TeamName(data.name()),
                new TeamMembersCounter(data.membersCounter()),
                new TeamSpacesCounter(data.spacesCounter()),
                new TeamCreationDate(data.creationDate()),
                new TeamState(data.state()),
                Role.fromPrimitives(data.role()),
                newMemberList,
                newSpaceList
        );
    }

    public TeamDTO toPrimitives(){
        String[] memberList = new String[this.membersCounter.value()];
        for(int membersCounter= 0; membersCounter< this.membersCounter.value(); membersCounter++){
            memberList[membersCounter]= this.memberList[membersCounter].value();
        }

        SpaceDTO[] spaceList = new SpaceDTO[this.spacesCounter.value()];
        for(int spacesCounter= 0 ; spacesCounter<this.spacesCounter.value(); spacesCounter++){
            spaceList[spacesCounter] = this.spaceList[spacesCounter].toPrimitives();
        }

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

    public UserId[] getMemberList() {
        return this.memberList;
    }

    public Space[] getSpaceList() {
        return this.spaceList;
    }
}
