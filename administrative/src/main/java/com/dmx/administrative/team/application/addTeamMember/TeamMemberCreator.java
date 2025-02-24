package com.dmx.administrative.team.application.addTeamMember;

import com.dmx.administrative.shared.domain.TeamId;
import com.dmx.administrative.shared.domain.UserId;
import com.dmx.administrative.team.domain.Team;
import com.dmx.administrative.team.domain.TeamCommandRepository;
import com.dmx.administrative.team.domain.TeamNotFoundException;
import com.dmx.administrative.team.domain.TeamQueryRepository;
import com.dmx.administrative.user.domain.User;
import com.dmx.administrative.user.domain.UserNotFindException;
import com.dmx.administrative.user.domain.UserQueryRepository;


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
