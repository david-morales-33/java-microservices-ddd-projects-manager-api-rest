package com.microservice.media.post.domain;

import com.microservice.media.shared.domain.SpaceId;
import com.microservice.media.space.domain.SpaceIdTest;
import com.microservice.media.user.domain.User;
import com.microservice.media.user.domain.UserTest;

public final class PostTest {
    public static Post create(PostId id, PostTitle title, PostContent content, PostCreationDate creationDate, SpaceId spaceId, User user){
        return new Post(id,title, content, creationDate, spaceId, user);
    }
    public static Post random(){
        return create(
                PostIdTest.random(),
                PostTitleTest.random(),
                PostContentTest.random(),
                PostCreationDateTest.random(),
                SpaceIdTest.random(),
                UserTest.random()
        );
    }
}
