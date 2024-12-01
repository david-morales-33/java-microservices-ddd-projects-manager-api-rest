package com.dmx.media.team.application.createSpace;

import com.dmx.media.post.domain.Post;
import com.dmx.media.space.domain.Space;
import com.dmx.media.space.domain.SpaceCreateBy;
import com.dmx.media.space.domain.SpaceCreationDate;
import com.dmx.media.space.domain.SpaceName;
import com.dmx.media.team.domain.Team;
import com.dmx.media.team.domain.TeamCommandRepository;
import com.dmx.media.team.domain.TeamNotFoundException;
import com.dmx.media.team.domain.TeamQueryRepository;
import com.dmx.shared.domain.SpaceId;
import com.dmx.shared.domain.TeamId;
import com.dmx.shared.domain.UserId;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

public final class SpaceCreator {
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
