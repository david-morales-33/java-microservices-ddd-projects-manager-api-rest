package com.dmx.administrative.team.application.createSpace;

import com.dmx.administrative.post.domain.Post;
import com.dmx.administrative.space.domain.Space;
import com.dmx.administrative.space.domain.SpaceCreateBy;
import com.dmx.administrative.space.domain.SpaceCreationDate;
import com.dmx.administrative.space.domain.SpaceName;
import com.dmx.administrative.team.domain.Team;
import com.dmx.administrative.team.domain.TeamCommandRepository;
import com.dmx.administrative.team.domain.TeamNotFoundException;
import com.dmx.administrative.team.domain.TeamQueryRepository;
import com.dmx.shared.domain.SpaceId;
import com.dmx.shared.domain.TeamId;
import com.dmx.shared.domain.UserId;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

public class SpaceCreator {
    private final TeamCommandRepository commandRepository;
    private final TeamQueryRepository queryRepository;

    public SpaceCreator(TeamCommandRepository commandRepository, TeamQueryRepository queryRepository) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
    }

    public void execute(TeamId teamId, SpaceId spaceId, SpaceName name, SpaceCreationDate creationDate, SpaceCreateBy createBy) {
        Optional<Team> response = this.queryRepository.find(teamId);
        if (response.isEmpty()) throw new TeamNotFoundException();
        Team team = response.get();

        HashMap<String, Post> postList = new HashMap<>();
        HashSet<UserId> membersList = new HashSet<>();

        Space space = Space.create(spaceId, name, creationDate, createBy, postList, membersList);
        team.addSpace(space);
        this.commandRepository.save(team);
    }
}
