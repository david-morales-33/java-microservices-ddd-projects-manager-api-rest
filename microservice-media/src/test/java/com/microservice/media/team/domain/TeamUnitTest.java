package com.microservice.media.team.domain;

import com.microservice.media.post.domain.*;
import com.microservice.media.space.domain.Space;
import com.microservice.media.space.domain.SpaceIdTest;
import com.microservice.media.space.domain.SpaceTest;
import com.microservice.media.user.domain.User;
import com.microservice.media.user.domain.UserTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class TeamUnitTest {
    Team team;

    @BeforeEach
    void setUp() {
        team = TeamTest.random();
    }

    @Test
    void ADD_SPACE_it_should_increment_space_counter() {
        Space space = SpaceTest.random();

        team.addSpace(space);

        assertEquals(4, team.getSpacesCounter().value());
    }

    @Test
    void ADD_SPACE_it_should_throw_an_exception_when_space_already_exists() {
        Space space = SpaceTest.random();

        team.addSpace(space);

        assertThrows(SpaceNotValidException.class, () -> team.addSpace(space));
    }

    @Test
    void ADD_MEMBER_it_should_increment_members_counter() {
        User user = UserTest.random();

        team.addUser(user);

        assertEquals(10, team.getMembersCounter().value());
    }

    @Test
    void ADD_MEMBER_it_should_throw_an_exception_when_member_already_exists() {
        User user = UserTest.random();

        team.addUser(user);

        assertThrows(UserNotValidException.class, () -> team.addUser(user));
    }

    @Test
    void ADD_MEMBER_SPACE_it_should_increment_members_counter() {
        Space space = SpaceTest.random();
        User user = UserTest.random();

        team.addSpace(space);
        team.addUser(user);

        team.addSpaceMember(space.getId(), user.getId());

        assertEquals(4, team.getSpaceList().get(space.getId().value()).getMembersCounter().value());
    }

    @Test
    void ADD_MEMBER_SPACE_it_should_throw_an_exception_when_space_does_not_exist() {
        User user = UserTest.random();

        team.addUser(user);

        assertThrows(SpaceNotFoundException.class, () -> team.addSpaceMember(SpaceIdTest.random(), user.getId()));
    }

    @Test
    void ADD_MEMBER_SPACE_it_should_throw_an_exception_when_user_does_not_exist_on_team() {
        Space space = SpaceTest.random();
        User user = UserTest.random();

        team.addSpace(space);

        assertThrows(UserNotValidException.class, () -> team.addSpaceMember(space.getId(), user.getId()));
    }

    @Test
    void ADD_POST_it_Should_increment_post_post_counter() {
        Space space = SpaceTest.random();
        User user = UserTest.random();

        Post newPost = PostTest.create(PostIdTest.random(), PostTitleTest.random(), PostContentTest.random(), PostCreationDateTest.random(), space.getId(), user);

        team.addSpace(space);
        team.addUser(user);
        team.addSpaceMember(space.getId(), user.getId());

        team.addPost(newPost);

        assertEquals(4, team.getSpaceList().get(space.getId().value()).getPostCounter().value());
    }

    @Test
    void ADD_POST_it_should_throw_an_exception_when_space_does_not_exist_on_team() {
        User user = UserTest.random();

        Post newPost = PostTest.create(PostIdTest.random(), PostTitleTest.random(), PostContentTest.random(), PostCreationDateTest.random(), SpaceIdTest.random(), user);

        team.addUser(user);

        assertThrows(SpaceNotFoundException.class, () -> team.addPost(newPost));
    }

    @Test
    void ADD_POST_it_should_throw_an_exception_when_member_doest_exist_on_team() {
        Space space = SpaceTest.random();

        Post newPost = PostTest.create(PostIdTest.random(), PostTitleTest.random(), PostContentTest.random(), PostCreationDateTest.random(), space.getId(), UserTest.random());

        team.addSpace(space);

        assertThrows(UserNotValidException.class, () -> team.addPost(newPost));
    }

}
