package com.microservice.administrative.team.application.addTeamMember;

import com.microservice.administrative.role.domain.RoleTest;
import com.microservice.administrative.team.TeamModuleUnitTestCase;
import com.microservice.administrative.team.domain.*;
import com.microservice.administrative.user.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public final class AddTeamMemberCommandHandlerTest extends TeamModuleUnitTestCase {

    AddTeamMemberCommandHandler commandHandler;
    UserQueryRepository userQueryRepository;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        userQueryRepository = mock(UserQueryRepository.class);
        commandHandler = new AddTeamMemberCommandHandler(new TeamMemberCreator(commandRepository, queryRepository, userQueryRepository));
    }

    @Test
    void it_should_add_new_team_member() {
        AddTeamMemberCommand command = AddTeamMemberCommandTest.random();
        User user = UserTest.create(UserIdTest.create(command.getUserId()));
        Team team = TeamTest.create(TeamIdTest.create(command.getTeamId()));

        when(userQueryRepository.find(user.getId())).thenReturn(Optional.of(user));

        shouldHaveAskById(team);

        commandHandler.handle(command);

        shouldHaveSave(team);
        shouldHaveAsk(team.getId());
    }

    @Test
    void it_should_throw_an_exception_when_user_does_not_exists() {
        AddTeamMemberCommand command = AddTeamMemberCommandTest.random();
        User user = UserTest.create(UserIdTest.create(command.getUserId()));
        Team team = TeamTest.create(TeamIdTest.create(command.getTeamId()));

        when(userQueryRepository.find(user.getId())).thenReturn(Optional.empty());
        shouldHaveAskById(team);

        assertThrows(UserNotFindException.class, () -> commandHandler.handle(command));
    }

    @Test
    void it_should_throw_an_exception_when_team_does_not_exists() {
        AddTeamMemberCommand command = AddTeamMemberCommandTest.random();
        User user = UserTest.create(UserIdTest.create(command.getUserId()));
        Team team = TeamTest.create(TeamIdTest.create(command.getTeamId()));

        when(userQueryRepository.find(user.getId())).thenReturn(Optional.of(user));
        shouldHaveAskById(team.getId());

        assertThrows(TeamNotFoundException.class, () -> commandHandler.handle(command));
    }

    @Test
    void it_should_throw_an_exception_when_team_member_already_exists() {
        AddTeamMemberCommand command = AddTeamMemberCommandTest.random();
        User user1 = UserTest.create(UserIdTest.create(command.getUserId()));
        User user2 = UserTest.create(UserIdTest.random());

        HashMap<String, User> membersList = new HashMap<>();
        membersList.put(user1.getId().value(), user1);
        membersList.put(user2.getId().value(), user2);

        Team team = TeamTest.create(
                TeamIdTest.create(command.getTeamId()),
                TeamNameTest.random(),
                TeamCreationDateTest.random(),
                TeamStateTest.radom(),
                RoleTest.random(),
                membersList
        );
        when(userQueryRepository.find(UserIdTest.create(command.getUserId()))).thenReturn(Optional.of(user1));
        shouldHaveAskById(team);
        assertThrows(UserNotValidException.class, () -> commandHandler.handle(command));
    }
}
