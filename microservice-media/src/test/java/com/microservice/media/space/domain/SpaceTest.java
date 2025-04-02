package com.microservice.media.space.domain;

import com.microservice.media.post.domain.Post;
import com.microservice.media.post.domain.PostTest;
import com.microservice.media.shared.domain.SpaceId;
import com.microservice.media.shared.domain.UserId;
import com.microservice.media.user.domain.User;
import com.microservice.media.user.domain.UserTest;

import java.util.HashMap;
import java.util.HashSet;

public final class SpaceTest {
    public static Space create(
            SpaceId id,
            SpaceName name,
            SpaceCreationDate creationDate,
            SpaceCreateBy createBy,
            HashMap<String, Post> postList,
            HashSet<User> memberList
    ) {
        return new Space(id, name, creationDate, createBy, postList, memberList);
    }

    public static Space random() {
        HashMap<String, Post> postList = new HashMap<>();
        HashSet<User> memberList = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            Post post = PostTest.random();
            User user = UserTest.random();
            postList.put(post.getId().value(), post);
            memberList.add(user);
        }
        return create(
                SpaceIdTest.random(),
                SpaceNameTest.random(),
                SpaceCreationDateTest.random(),
                SpaceCreateByTest.random(),
                postList,
                memberList
        );
    }
}
