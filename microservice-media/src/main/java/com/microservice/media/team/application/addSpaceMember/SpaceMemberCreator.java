package com.microservice.media.team.application.addSpaceMember;

import com.microservice.media.shared.domain.Service;
import com.microservice.media.shared.domain.SpaceId;
import com.microservice.media.shared.domain.TeamId;
import com.microservice.media.shared.domain.UserId;
import com.microservice.media.team.domain.Team;
import com.microservice.media.team.domain.TeamCommandRepository;
import com.microservice.media.team.domain.TeamNotFoundException;
import com.microservice.media.team.domain.TeamQueryRepository;

import java.util.Optional;

@Service
public final class SpaceMemberCreator {
    private final TeamQueryRepository queryRepository;
    private final TeamCommandRepository commandRepository;

    public SpaceMemberCreator(TeamQueryRepository queryRepository, TeamCommandRepository commandRepository) {
        this.queryRepository = queryRepository;
        this.commandRepository = commandRepository;
    }

    public void execute(TeamId teamId, SpaceId spaceId, UserId userId) throws TeamNotFoundException {
        Optional<Team> teamResponse = this.queryRepository.find(teamId);
        if (teamResponse.isEmpty()) throw new TeamNotFoundException();

        Team team = teamResponse.get();
        team.addSpaceMember(spaceId, userId);
        this.commandRepository.save(team);
    }
}
