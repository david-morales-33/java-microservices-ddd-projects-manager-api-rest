package com.microservice.media.space.domain;

import com.microservice.media.post.domain.*;
import com.microservice.media.shared.domain.UserId;
import com.microservice.media.team.domain.UserNotValidException;
import com.microservice.media.user.domain.UserIdTest;
import com.microservice.media.user.domain.UserTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public final class SpaceUnitTest {

    Space space;

    @BeforeEach
    void setUp() {
        space = SpaceTest.random();
    }

    @Test
    void it_should_increment_member_counter() {
        UserId newUser = UserIdTest.random();

        space.addMember(newUser);

        assertEquals(4, space.getMembersCounter().value());
    }

    @Test
    void it_should_throw_an_exception_when_member_exists() {
        List<UserId> membersList = new ArrayList<>(space.getMemberList());
        UserId newUser = membersList.get(0);

        assertThrows(SpaceMemberAlreadyExists.class, () -> space.addMember(newUser));
    }

    @Test
    void it_should_increment_post_counter() {
        List<UserId> membersList = new ArrayList<>(space.getMemberList());
        UserId newUser = membersList.get(0);

        Post newPost = PostTest.create(
                PostIdTest.random(),
                PostTitleTest.random(),
                PostContentTest.random(),
                PostCreationDateTest.random(),
                space.getId(),
                UserTest.create(newUser)
        );

        space.addPost(newPost);

        assertEquals(4, space.getPostCounter().value());
    }

    @Test
    void it_should_throw_an_exception_when_user_does_not_exist_on_space() {
        Post newPost = PostTest.random();

        assertThrows(UserNotValidException.class, () -> space.addPost(newPost));
    }
}
