package com.dmx.media.team.application.addSpaceMember;

import com.dmx.media.team.domain.Team;
import com.dmx.media.team.domain.TeamCommandRepository;
import com.dmx.media.team.domain.TeamNotFoundException;
import com.dmx.media.team.domain.TeamQueryRepository;
import com.dmx.shared.domain.SpaceId;
import com.dmx.shared.domain.TeamId;
import com.dmx.shared.domain.UserId;

import java.util.Optional;

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
