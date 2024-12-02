package com.dmx.development.team.application.addTeamMember;

import com.dmx.development.team.domain.Team;
import com.dmx.development.team.domain.TeamCommandRepository;
import com.dmx.development.team.domain.TeamNotFoundException;
import com.dmx.development.team.domain.TeamQueryRepository;
import com.dmx.development.user.domain.User;
import com.dmx.development.user.domain.UserNotFindException;
import com.dmx.development.user.domain.UserQueryRepository;
import com.dmx.shared.domain.TeamId;
import com.dmx.shared.domain.UserId;

import java.util.Optional;

public final class TeamMemberCreator {
    private final TeamCommandRepository teamCommandRepository;
    private final TeamQueryRepository teamQueryRepository;
    private final UserQueryRepository userQueryRepository;

    public TeamMemberCreator(
            TeamCommandRepository teamCommandRepository,
            TeamQueryRepository teamQueryRepository,
            UserQueryRepository userQueryRepository
    ) {
        this.teamCommandRepository = teamCommandRepository;
        this.teamQueryRepository = teamQueryRepository;
        this.userQueryRepository = userQueryRepository;
    }

    public void execute(TeamId teamId, UserId userId) throws UserNotFindException, TeamNotFoundException {

        Optional<User> userResponse = this.userQueryRepository.find(userId);
        if (userResponse.isEmpty()) throw new UserNotFindException(userId);

        User user = userResponse.get();

        Optional<Team> teamResponse = this.teamQueryRepository.find(teamId);
        if (teamResponse.isEmpty()) throw new TeamNotFoundException();

        Team team = teamResponse.get();

        team.addUser(user);
        this.teamCommandRepository.save(team);
    }
}
