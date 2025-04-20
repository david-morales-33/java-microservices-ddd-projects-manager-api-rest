package com.microservice.development.team.application.addTeamMember;

import com.microservice.development.shared.domain.Service;
import com.microservice.development.shared.domain.TeamId;
import com.microservice.development.shared.domain.UserId;
import com.microservice.development.team.domain.Team;
import com.microservice.development.team.domain.TeamCommandRepository;
import com.microservice.development.team.domain.TeamNotFoundException;
import com.microservice.development.team.domain.TeamQueryRepository;
import com.microservice.development.user.domain.User;
import com.microservice.development.user.domain.UserNotFindException;
import com.microservice.development.user.domain.UserQueryRepository;

import java.util.Optional;

@Service
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
