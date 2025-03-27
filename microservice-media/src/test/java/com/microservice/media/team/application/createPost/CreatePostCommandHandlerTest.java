package com.microservice.media.team.application.createPost;

import com.microservice.media.post.domain.PostContentTest;
import com.microservice.media.post.domain.PostCreationDateTest;
import com.microservice.media.post.domain.PostIdTest;
import com.microservice.media.post.domain.PostTitleTest;
import com.microservice.media.shared.domain.TeamId;
import com.microservice.media.space.domain.Space;
import com.microservice.media.space.domain.SpaceTest;
import com.microservice.media.team.TeamUnitTestCase;
import com.microservice.media.team.domain.Team;
import com.microservice.media.team.domain.TeamIdTest;
import com.microservice.media.team.domain.TeamNotFoundException;
import com.microservice.media.team.domain.TeamTest;
import com.microservice.media.user.domain.User;
import com.microservice.media.user.domain.UserTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class CreatePostCommandHandlerTest extends TeamUnitTestCase {

    CreatePostCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new CreatePostCommandHandler(new PostCreator(commandRepository, queryRepository));
    }

    @Test
    void it_should_create_a_new_post() {
        Team team = TeamTest.random();
        Space space = SpaceTest.random();
        User member = UserTest.random();

        team.addSpace(space);
        team.addUser(member);
        team.addSpaceMember(space.getId(), member.getId());

        CreatePostCommand command = CreatePostCommandTest.create(
                team.getId().value(),
                PostIdTest.random().value(),
                PostTitleTest.random().value(),
                PostContentTest.random().value(),
                PostCreationDateTest.random().value(),
                space.getId().value(),
                member.getId().value()
        );

        shouldAnswerAnyTeam(team);

        handler.handle(command);

        shouldVerifySaveTeam(team);
    }

    @Test
    void it_should_throw_an_exception_when_team_does_not_exists(){
        TeamId id = TeamIdTest.random();
        CreatePostCommand command = CreatePostCommandTest.random(id.value());

        shouldAnswerEmptyTeam(id);

        assertThrows(TeamNotFoundException.class, ()-> handler.handle(command));
    }
}
