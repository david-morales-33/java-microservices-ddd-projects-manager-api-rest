package com.microservice.media.team.application.createSpace;

import com.microservice.media.post.domain.Post;
import com.microservice.media.shared.domain.SpaceId;
import com.microservice.media.shared.domain.TeamId;
import com.microservice.media.shared.domain.UserId;
import com.microservice.media.space.domain.Space;
import com.microservice.media.space.domain.SpaceCreateBy;
import com.microservice.media.space.domain.SpaceCreationDate;
import com.microservice.media.space.domain.SpaceName;
import com.microservice.media.team.domain.Team;
import com.microservice.media.team.domain.TeamCommandRepository;
import com.microservice.media.team.domain.TeamNotFoundException;
import com.microservice.media.team.domain.TeamQueryRepository;

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
