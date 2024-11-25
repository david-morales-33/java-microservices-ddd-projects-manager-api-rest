package com.dmx.administrative.space.domain;

import com.dmx.shared.domain.PostId;
import com.dmx.shared.domain.SpaceId;
import com.dmx.shared.domain.UserId;

public final class Space {
    private final SpaceId id;
    private final SpaceName name;
    private final SpaceCreationDate creationDate;
    private final SpaceCreateBy createBy;
    private final PostId[] postList;
    private final UserId[] memberList;

    public Space(
            SpaceId id,
            SpaceName name,
            SpaceCreationDate creationDate,
            SpaceCreateBy createBy,
            PostId[] postList,
            UserId[] memberList
    ) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.createBy = createBy;
        this.postList = postList;
        this.memberList = memberList;
    }

    public static Space fromPrimitive(SpaceDTO data) {
        int postListLength = data.postList().length;
        PostId[] newPostIdList = new PostId[postListLength];
        for (int postCounter = 0; postCounter < postListLength; postCounter++) {
            String currentPostId = data.postList()[postCounter];
            newPostIdList[postCounter] = new PostId(currentPostId);
        }

        int membersLength = data.memberList().length;
        UserId[] newMemberIdList = new UserId[membersLength];
        for (int membersCounter = 0; membersCounter < membersLength; membersCounter++) {
            String currentMemberId = data.memberList()[membersCounter];
            newMemberIdList[membersCounter] = new UserId(currentMemberId);
        }
        return new Space(
                new SpaceId(data.id()),
                new SpaceName(data.name()),
                new SpaceCreationDate(data.creationDate()),
                new SpaceCreateBy(data.createBy()),
                newPostIdList,
                newMemberIdList
        );
    }

    public SpaceDTO toPrimitives() {
        String[] postList = new String[this.postList.length];
        for (int postsCounter = 0; postsCounter < this.postList.length; postsCounter++) {
            postList[postsCounter] = this.postList[postsCounter].value();
        }
        String[] memberList = new String[this.memberList.length];
        for (int membersCounter = 0; membersCounter < this.memberList.length; membersCounter++) {
            memberList[membersCounter] = this.memberList[membersCounter].value();
        }

        return new SpaceDTO(
                this.id.value(),
                this.name.value(),
                this.creationDate.value(),
                this.createBy.value(),
                postList,
                memberList
        );
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

    public PostId[] getPostList() {
        return this.postList;
    }

    public UserId[] getMemberList() {
        return this.memberList;
    }

    public SpaceCreationDate getCreationDate() {
        return this.creationDate;
    }
}
