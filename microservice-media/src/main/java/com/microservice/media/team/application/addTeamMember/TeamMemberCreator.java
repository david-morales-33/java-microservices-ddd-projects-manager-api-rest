package com.microservice.media.team.application.addTeamMember;

import com.microservice.media.shared.domain.TeamId;
import com.microservice.media.shared.domain.UserId;
import com.microservice.media.team.domain.Team;
import com.microservice.media.team.domain.TeamCommandRepository;
import com.microservice.media.team.domain.TeamNotFoundException;
import com.microservice.media.team.domain.TeamQueryRepository;
import com.microservice.media.user.domain.User;
import com.microservice.media.user.domain.UserNotFindException;
import com.microservice.media.user.domain.UserQueryRepository;

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
