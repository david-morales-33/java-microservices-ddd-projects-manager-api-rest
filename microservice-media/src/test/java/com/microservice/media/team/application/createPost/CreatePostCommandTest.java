package com.microservice.media.team.application.createPost;

import com.microservice.media.post.domain.PostContentTest;
import com.microservice.media.post.domain.PostCreationDateTest;
import com.microservice.media.post.domain.PostIdTest;
import com.microservice.media.post.domain.PostTitleTest;
import com.microservice.media.space.domain.SpaceIdTest;
import com.microservice.media.user.domain.UserIdTest;

public final class CreatePostCommandTest {
    public static CreatePostCommand create(String teamId, String posId, String title, String content, String creationDate, String spaceId, String userId) {
        return new CreatePostCommand(teamId, posId, title, content, creationDate, spaceId, userId);
    }

    public static CreatePostCommand random(String teamId) {
        return create(
                teamId,
                PostIdTest.random().value(),
                PostTitleTest.random().value(),
                PostContentTest.random().value(),
                PostCreationDateTest.random().value(),
                SpaceIdTest.random().value(),
                UserIdTest.random().value()
        );
    }
}
