package com.microservice.media.space.domain;

import com.microservice.media.post.domain.Post;
import com.microservice.media.post.domain.PostDTO;
import com.microservice.media.shared.domain.SpaceId;
import com.microservice.media.shared.domain.UserId;
import com.microservice.media.team.domain.UserNotValidException;

import java.util.*;

public final class Space {
    private final SpaceId id;
    private final SpaceName name;
    private final SpaceCreationDate creationDate;
    private final SpaceCreateBy createBy;
    private Map<String, Post> postList;
    private Set<UserId> memberList;
    private SpacePostCounter postCounter;
    private SpaceMembersCounter membersCounter;

    public Space(
            SpaceId id,
            SpaceName name,
            SpaceCreationDate creationDate,
            SpaceCreateBy createBy,
            HashMap<String, Post> postList,
            HashSet<UserId> memberList) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.createBy = createBy;
        this.postList = postList;
        this.memberList = memberList;
        this.membersCounter = new SpaceMembersCounter(memberList.size());
        this.postCounter = new SpacePostCounter(postList.size());
    }

    public Space() {
        this.id = null;
        this.name = null;
        this.creationDate = null;
        this.createBy = null;
        this.postList = new HashMap<>();
        this.memberList = new HashSet<>();
    }

    public static Space create(
            SpaceId id,
            SpaceName name,
            SpaceCreationDate creationDate,
            SpaceCreateBy createBy,
            HashMap<String, Post> postList,
            HashSet<UserId> memberList) {
        return new Space(id, name, creationDate, createBy, postList, memberList);
    }

    public static Space fromPrimitive(SpaceDTO data) {
        HashMap<String, Post> newPostIdList = new HashMap<>();
        HashSet<UserId> newMemberIdList = new HashSet<>();

        data.postList().forEach((key, value) -> newPostIdList.put(value.id(), Post.fromPrimitives(value)));
        data.memberList().forEach(element -> newMemberIdList.add(new UserId(element)));

        return new Space(
                new SpaceId(data.id()),
                new SpaceName(data.name()),
                new SpaceCreationDate(data.creationDate()),
                new SpaceCreateBy(data.createBy()),
                newPostIdList,
                newMemberIdList);
    }

    public SpaceDTO toPrimitives() {
        HashMap<String, PostDTO> postList = new HashMap<String, PostDTO>();
        HashSet<String> memberList = new HashSet<>();

        this.postList.forEach((key, element) -> postList.put(element.getId().value(), element.toPrimitives()));
        this.memberList.forEach(element -> memberList.add(element.value()));

        return new SpaceDTO(
                this.id.value(),
                this.name.value(),
                this.creationDate.value(),
                this.createBy.value(),
                postList,
                memberList,
                this.postCounter.value(),
                this.membersCounter.value());
    }

    private SpaceMembersCounter incrementMembersCounter() {
        return new SpaceMembersCounter(this.membersCounter.value() + 1);
    }

    private SpacePostCounter incrementPostCounter() {
        return new SpacePostCounter(this.postCounter.value() + 1);
    }

    public void addMember(UserId newUser) {
        if (this.memberList.contains(newUser))
            throw new SpaceMemberAlreadyExists();
        this.memberList.add(newUser);
        this.membersCounter = this.incrementMembersCounter();
    }

    public void addPost(Post newPost) {

        if (!this.toPrimitives().memberList().contains(newPost.getUser().getId().value()))
            throw new UserNotValidException("El usuario no es valido en el espacio");

        this.postList.put(newPost.getId().value(), newPost);
        this.postCounter = this.incrementPostCounter();
    }

    public SpaceId getId() {
        return this.id;
    }

    public SpaceName getName() {
        return this.name;
    }

    public SpaceCreateBy getCreateBy() {
        return this.createBy;
    }

    public Map<String, Post> getPostList() {
        return postList;
    }

    public SpacePostCounter getPostCounter() {
        return this.postCounter;
    }

    public SpaceMembersCounter getMembersCounter() {
        return this.membersCounter;
    }

    public Set<UserId> getMemberList() {
        return this.memberList;
    }

    public SpaceCreationDate getCreationDate() {
        return this.creationDate;
    }

    private void setPostList(Map<String, Post> postList) {
        this.postList = postList;
    }

    private void setMemberList(Set<UserId> memberList) {
        this.memberList = memberList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Space space = (Space) o;
        return Objects.equals(id, space.id) && Objects.equals(name, space.name) && Objects.equals(creationDate, space.creationDate) && Objects.equals(createBy, space.createBy) && Objects.equals(postList, space.postList) && Objects.equals(memberList, space.memberList) && Objects.equals(postCounter, space.postCounter) && Objects.equals(membersCounter, space.membersCounter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, creationDate, createBy, postList, memberList, postCounter, membersCounter);
    }
}
