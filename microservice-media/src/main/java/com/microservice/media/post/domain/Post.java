package com.microservice.media.post.domain;

import com.microservice.media.shared.domain.SpaceId;
import com.microservice.media.user.domain.User;

public final class Post {
    private final PostId id;
    private final PostTitle title;
    private final PostContent content;
    private final PostCreationDate creationDate;
    private final SpaceId spaceId;
    private User user;

    public Post(PostId id, PostTitle title, PostContent content, PostCreationDate creationDate, SpaceId spaceId, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.spaceId = spaceId;
        this.user = user;
    }

    public static Post create(
            PostId id,
            PostTitle title,
            PostContent content,
            PostCreationDate creationDate,
            SpaceId spaceId,
            User user
    ) {
        return new Post(id, title, content, creationDate, spaceId, user);
    }

    private Post() {
        this.id = null;
        this.title = null;
        this.content = null;
        this.creationDate = null;
        this.spaceId = null;
        this.user = null;
    }

    public static Post fromPrimitives(PostDTO data) {
        return new Post(
                new PostId(data.id()),
                new PostTitle(data.title()),
                new PostContent(data.content()),
                new PostCreationDate(data.creationDate()),
                new SpaceId(data.spaceId()),
                User.fromPrimitives(data.user())
        );
    }

    public PostDTO toPrimitives() {
        return new PostDTO(
                this.id.value(),
                this.title.value(),
                this.content.value(),
                this.creationDate.value(),
                this.spaceId.value(),
                this.user.toPrimitives()
        );
    }

    public PostId getId() {
        return id;
    }

    public PostTitle getTitle() {
        return title;
    }

    public PostContent getContent() {
        return content;
    }

    public PostCreationDate getCreationDate() {
        return creationDate;
    }

    public SpaceId getSpaceId() {
        return spaceId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
